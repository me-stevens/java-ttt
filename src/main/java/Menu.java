import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Menu {

    private UserInterface gameUI;
    private HashMap<String, List<Player>> options;

    public Menu(UserInterface gameUI) {
        this.gameUI = gameUI;
        options     = new HashMap<String, List<Player>>();
        twoHumans();
        humanAndRobot();
        twoRobots();
        humanAndAlien();
    }

    public List<Player> createPlayers() {
        String option = setOption();

        return options.get(option);
    }

    private void twoHumans() {
        Player player1 = new HumanPlayer(gameUI, "X");
        Player player2 = new HumanPlayer(gameUI, "O");
        options.put("1", Arrays.asList(player1, player2));
    }

    private void humanAndRobot() {
        Player player1 = new HumanPlayer(gameUI, "X");
        Player player2 = new RobotPlayer(gameUI, "O");
        options.put("2", Arrays.asList(player1, player2));
    }

    private void twoRobots() {
        Player player1 = new RobotPlayer(gameUI, "X");
        Player player2 = new RobotPlayer(gameUI, "O");
        options.put("3", Arrays.asList(player1, player2));
    }

    private void humanAndAlien() {
        Player player1 = new HumanPlayer(gameUI, "X");
        Player player2 = new AlienPlayer(gameUI, "O");
        options.put("4", Arrays.asList(player1, player2));
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

        for (int index = 1; index <= options.size(); index++) {
            validIndexes.add(Integer.toString(index));
        }

        return !validIndexes.contains(option);
    }
}
