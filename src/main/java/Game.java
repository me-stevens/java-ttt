public class Game {

    private Board board;
    private UserInterface gameUI;
    private String currentPlayer;
    private Player player1;
    private Player player2;

    public Game(Board board, UserInterface gameUI) {
        this.board  = board;
        this.gameUI = gameUI;
        resetGame();
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
        setPlayers(showPlayersMenu());

        boolean play = true;
        while (play) {
            play = nextTurn();
        }
    }

    public String showPlayersMenu() {
        String option = "";
        while (!option.matches("[1-4]")) {
            option = gameUI.printPlayersMenu();
        }
        return option;
    }

    public void setPlayers(String option) {
        switch (option.charAt(0)) {
            case '1':
                player1 = new HumanPlayer(gameUI, "X");
                player2 = new HumanPlayer(gameUI, "O");
                break;
            case '2':
                player1 = new HumanPlayer(gameUI, "X");
                player2 = new RobotPlayer(gameUI, "O");
                break;
            case '3':
                player1 = new RobotPlayer(gameUI, "X");
                player2 = new RobotPlayer(gameUI, "O");
                break;
            case '4':
                player1 = new HumanPlayer(gameUI, "X");
                player2 = new AlienPlayer(gameUI, "O");
                break;
        }
    }

    public boolean nextTurn() {
        gameUI.printBoard(board);

        int index = (currentPlayer.equals("X")) ? player1.getCellIndex(board) : player2.getCellIndex(board);
        board.setCell(index, currentPlayer);

        return updateGameStatus();
    }

    private boolean updateGameStatus() {
        if (checkForWinner() || checkForFull()) {
            return false;
        }

        swapPlayer();
        return true;
    }

    public boolean checkForWinner() {
        if (new BoardChecker(board).hasWinner(currentPlayer)) {
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

    private void swapPlayer() {
        currentPlayer = (currentPlayer == "X") ? "O" : "X";
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
