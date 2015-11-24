import java.util.ArrayList;

public class Menu {

    private UserInterface gameUI;
    private int size;

    public Menu(UserInterface gameUI, int size) {
        this.gameUI = gameUI;
        this.size   = size;
    }

    public Player[] createPlayers() {
        Player player1;
        Player player2;
        char option = setOption().charAt(0);

        switch (option) {
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
            default:
                player1 = null;
                player2 = null;
                break;
        }

        return new Player[] {player1, player2};
    }

    private String setOption() {
        String option = "";

        while (isInvalidOption(option)) {
            option = gameUI.printPlayersMenu();
        }

        return option;
    }

    private boolean isInvalidOption(String option) {
        ArrayList<String> validIndexes = new ArrayList();

        for (int index = 1; index <= size*size; index++) {
            validIndexes.add(Integer.toString(index));
        }

        return !validIndexes.contains(option);
    }
}
