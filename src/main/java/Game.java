public class Game {

    private Board board;
    private UserInterface gameUI;
    private String currentPlayer;
    private Player player1;
    private Player player2;
    private boolean isHuman1;
    private boolean isHuman2;

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
        isHuman1      = true;
        isHuman2      = true;
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
        while (!option.matches("[1-3]")) {
            option = gameUI.printPlayersMenu();
        }
        return option;
    }

    public void setPlayers(String option) {
        switch (option.charAt(0)) {
            case '1':
                player1 = new HumanTurn(gameUI, "X");
                player2 = new HumanTurn(gameUI, "O");
                break;
            case '2':
                player1  = new HumanTurn(gameUI, "X");
                player2  = new RobotTurn(gameUI, "O");
                isHuman2 = false;
                break;
            case '3':
                player1  = new RobotTurn(gameUI, "X");
                player2  = new RobotTurn(gameUI, "O");
                isHuman1 = false;
                isHuman2 = false;
                break;
        }
    }

    public boolean nextTurn() {
        gameUI.printBoard(board);

        int index = (isHuman()) ? playTurn(player1) : playTurn(player2);
        board.setCell(index, currentPlayer);

        return updateGameStatus();
    }

    private boolean isHuman() {
        return ((currentPlayer.equals("X") && isHuman1) ||
                (currentPlayer.equals("O") && isHuman2));
    }

    public int playTurn(Player player) {
        return player.getCellIndex(board);
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

    public boolean getHumanity1() {
        return isHuman1;
    }

    public boolean getHumanity2() {
        return isHuman2;
    }
}
