public class Game {

    private Board board      = new Board(3);
    private ConsoleUI gameUI = new ConsoleUI(new GameConsole(System.in, System.out));

    public Board getBoard() {
        return board;
    }

    public boolean nextTurn() {
        gameUI.printBoard(board);

        int index = 1;
        //int index = stringToNumber(humanTurn());

        updateBoard(index, getMark(true));

        if (board.hasWinner(getMark(true)) || board.isFull() ) {
            gameUI.printGameOverMessage();
            return false;
        }

        return true;
    }

    public int stringToNumber(String cellIndex) {
        return Integer.parseInt(cellIndex);
    }

    }

    }

    public String getMark(boolean first) {
        return first ? "X" : "O";
    }

    public void updateBoard(int index, String mark) {
        board.setCell(board.getRowFromIndex(index), board.getColFromIndex(index), mark);
    }
}
