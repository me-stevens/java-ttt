public class Game {

    private Board board      = new Board(3);
    private ConsoleUI gameUI = new ConsoleUI(new GameConsole(System.in, System.out));

    public Board getBoard() {
        return board;
    }

    public boolean nextTurn() {
        if (board.hasWinner(getMark(true)) || board.isFull() ) {
            return false;
        }

        return true;
    }

    public int stringToNumber(String cellIndex) {
        return Integer.parseInt(cellIndex);
    }

    public int getRowFromIndex(int index) {
        return index / board.getSize();
    }

    public int getColFromIndex(int index) {
        return index % board.getSize();
    }

    public String getMark(boolean first) {
        return first ? "X" : "O";
    }

    public void updateBoard(int i, int j, String mark) {
        board.setCell(i, j, mark);
    }
}
