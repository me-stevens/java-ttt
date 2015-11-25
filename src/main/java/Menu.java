import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;

public class Menu {

    private UserInterface gameUI;
    private HashMap<String, Supplier<List<Player>>> menuOptions;

    public Menu(UserInterface gameUI) {
        this.gameUI      = gameUI;
        this.menuOptions = new HashMap<>();
        initializeOptions();
    }

    public List<Player> createPlayers() {
        String option = setOption();
        return menuOptions.get(option).get();
    }

    private void initializeOptions() {
        menuOptions.put("1", this::twoHumans);
        menuOptions.put("2", this::humanAndRobot);
        menuOptions.put("3", this::twoRobots);
        menuOptions.put("4", this::humanAndAlien);

    }

    private List<Player> twoHumans() {
        Player player1 = new HumanPlayer(gameUI, "X");
        Player player2 = new HumanPlayer(gameUI, "O");
        return Arrays.asList(player1, player2);
    }

    private List<Player> humanAndRobot() {
        Player player1 = new HumanPlayer(gameUI, "X");
        Player player2 = new RobotPlayer(gameUI, "O");
        return Arrays.asList(player1, player2);
    }

    private List<Player> twoRobots() {
        Player player1 = new RobotPlayer(gameUI, "X");
        Player player2 = new RobotPlayer(gameUI, "O");
        return Arrays.asList(player1, player2);
    }

    private List<Player> humanAndAlien() {
        Player player1 = new HumanPlayer(gameUI, "X");
        Player player2 = new AlienPlayer(gameUI, "O");
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

        for (int index = 1; index <= menuOptions.size(); index++) {
            validIndexes.add(Integer.toString(index));
        }

        return !validIndexes.contains(option);
    }
}
