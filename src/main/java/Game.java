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

    public void run() {
        do {
            board.reset();
            start();
        } while(gameUI.replay().equals("y"));
    }

    public void start() {
        gameUI.printWelcomeMessage();

        boolean play = true;
        while (play) {
            play = nextTurn();
        }
    }

    public boolean nextTurn() {
        gameUI.printBoard(board);
        int index = humanTurn();
        updateBoard(index, getMark(first));

        return updateGameStatus();
    }

    private boolean updateGameStatus() {
        BoardChecker checker = new BoardChecker(board);

        if (checker.hasWinner(getMark(first)) || board.isFull() ) {
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
        String cellIndex      = gameUI.getInput();
        String validCellIndex = "[1-9]";

        while ( !cellIndex.matches(validCellIndex) ) {
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
