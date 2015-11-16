import java.util.List;

public class RobotTurn {

    private Board tempBoard;
    private final String playerToOptimize;
    private int size;

    public RobotTurn(Board board, String currentPlayer) {
        tempBoard        = board;
        playerToOptimize = currentPlayer;
        size             = board.getSize();
    }

    public int getCellIndex() {
        UserInterface gameUI = new UserInterface(new GameConsole(System.in, System.out));
        gameUI.printRobotPrompt();
        return 1;
    }
}