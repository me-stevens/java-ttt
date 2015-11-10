public class Game {

    private Board board;
    private UserInterface gameUI;
    private String currentPlayer;

    public Game(Board board, UserInterface gameUI) {
        this.board    = board;
        this.gameUI   = gameUI;
        currentPlayer = "X";
    }

    public Board getBoard() {
        return board;
    }

    public void run() {
        do {
            board.reset();
            currentPlayer = "X";
            start();
        } while (gameUI.replay().equals("y"));
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
        board.setCell(index, currentPlayer);

        return updateGameStatus();
    }

    private boolean updateGameStatus() {
        if (checkForWinner() || checkForFull()) {
            return false;
        }

        currentPlayer = (currentPlayer == "X") ? "O" : "X";
        return true;
    }

    public boolean checkForWinner() {
        BoardChecker checker = new BoardChecker(board);

        if (checker.hasWinner(currentPlayer)) {
            gameUI.printBoard(board);
            gameUI.printHasWinnerMessage(currentPlayer);
            return true;
        }

        return false;
    }

    public boolean checkForFull() {
        if (board.isFull()) {
            gameUI.printBoard(board);
            gameUI.printIsFullMessage();
            return true;
        }

        return false;
    }

    public int humanTurn() {
        String cellIndex = returnEmptyCellIndex(returnValidCellIndex());
        return stringToNumber(cellIndex);
    }

    public String returnValidCellIndex() {
        String cellIndex      = gameUI.getInput();
        String validCellIndex = "[1-9]";

        while (!cellIndex.matches(validCellIndex)) {
            gameUI.printNotValidCellMessage();
            cellIndex = gameUI.getInput();
        }

        return cellIndex;
    }

    public String returnEmptyCellIndex(String cellIndex) {
        while (board.isCellBusy(stringToNumber(cellIndex))) {
            gameUI.printCellIsBusyMessage();
            cellIndex = gameUI.getInput();
        }

        return cellIndex;
    }

    public int stringToNumber(String cellIndex) {
        return Integer.parseInt(cellIndex);
    }
}
