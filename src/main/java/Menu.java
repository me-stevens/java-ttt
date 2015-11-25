import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {

    private UserInterface gameUI;

    public enum Options {
        TWO_HUMANS, HUMAN_AND_ROBOT, TWO_ROBOTS, HUMAN_AND_ALIEN
    }

    public Menu(UserInterface gameUI) {
        this.gameUI = gameUI;
    }

    public List<Player> createPlayers() {
        Player player1 = new HumanPlayer(gameUI, "X");
        Player player2 = new HumanPlayer(gameUI, "O");

        char option = setOption().charAt(0);

        switch (option) {
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

        return Arrays.asList(player1, player2);
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

        for (int index = 1; index <= Options.values().length; index++) {
            validIndexes.add(Integer.toString(index));
        }

        return !validIndexes.contains(option);
    }
}
