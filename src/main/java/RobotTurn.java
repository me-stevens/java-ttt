public class RobotTurn {

    private final Board board;
    private final UserInterface gameUI;

    public RobotTurn(Board board, UserInterface gameUI) {
        this.board  = board;
        this.gameUI = gameUI;
    }

    public int getCellIndex() {
        gameUI.printRobotPrompt();
        return 1;
    }
}
