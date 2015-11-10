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
            resetGame();
            start();
        } while (gameUI.replay().equals("y"));
    }

    private void resetGame() {
        board.reset();
        currentPlayer = "X";
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
        HumanTurn human = new HumanTurn(board, gameUI);
        return human.getCellIndex();
    }

    public int robotTurn() {
        RobotTurn robot = new RobotTurn(board, gameUI);
        return robot.getCellIndex();
    }
}
