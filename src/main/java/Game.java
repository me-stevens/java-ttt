import java.util.List;

public class Game {

    private Board board;
    private UserInterface gameUI;
    private String currentMark;
    private Player currentPlayer;
    private Player player1;
    private Player player2;


    public Game(Board board, UserInterface gameUI) {
        this.board  = board;
        this.gameUI = gameUI;
        resetGame();
    }

    public void run() {
        do {
            resetGame();
            start();
        } while (gameUI.replay().equals("y"));
    }

    private void resetGame() {
        board.reset();
        currentMark = "X";
    }

    public void start() {
        gameUI.printWelcomeMessage();
        setPlayers();

        boolean play = true;
        while (play) {
            play = nextTurn();
        }
    }

    private void setPlayers() {
        List<Player> players = new Menu(gameUI).createPlayers();
        player1 = players.get(0);
        player2 = players.get(1);
    }

    public boolean nextTurn() {
        gameUI.printBoard(board);

        currentPlayer = (currentMark.equals("X")) ? player1 : player2;
        int index     = currentPlayer.getCellIndex(board);
        board.setCell(index, currentMark);

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
        if (new BoardChecker(board).hasWinner(currentMark)) {
            gameUI.printBoard(board);
            gameUI.printHasWinnerMessage(currentMark);
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
        currentMark = (currentMark == "X") ? "O" : "X";
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
