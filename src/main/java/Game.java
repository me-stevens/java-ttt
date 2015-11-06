public class Game {

    private Board board;
    private UserInterface gameUI;
    private boolean first;

    public Game(Board board, UserInterface gameUI) {
        this.board  = board;
        this.gameUI = gameUI;
        first       = true;
    }

    public Board getBoard() {
        return board;
    }

    public boolean nextTurn() {
        gameUI.printBoard(board);

        int index = humanTurn();

        updateBoard(index, getMark(first));

        if (board.hasWinner(getMark(first)) || board.isFull() ) {
            gameUI.printBoard(board);
            gameUI.printGameOverMessage();
            return false;
        }

        first = !first;
        return true;
    }

    public int humanTurn() {
        String cellIndex = returnEmptyCellIndex(returnValidCellIndex());
        return stringToNumber(cellIndex);
    }

    public String returnValidCellIndex() {
        String cellIndex = gameUI.getInput();
        String regex     = buildRegex(board.getSize()*board.getSize());

        while ( !cellIndex.matches(regex) ) {
             gameUI.printNotValidCellMessage();
             cellIndex = gameUI.getInput();
        }

        return cellIndex;
    }

    public String returnEmptyCellIndex(String cellIndex) {
        while ( board.isCellBusy(stringToNumber(cellIndex)) ) {
            gameUI.printCellIsBusyMessage();
            cellIndex = gameUI.getInput();
        }

        return cellIndex;
    }

    public String buildRegex(int size) {
        return (size < 10) ?
                "[1-" + size + "]" :
                "[0-" + (size/10) + "][0-" + (size%10) + "]";
    }

    public int stringToNumber(String cellIndex) {
        return Integer.parseInt(cellIndex);
    }

    public String getMark(boolean first) {
        return first ? "X" : "O";
    }

    public void updateBoard(int index, String mark) {
        board.setCell(board.getRowFromIndex(index), board.getColFromIndex(index), mark);
    }
}
