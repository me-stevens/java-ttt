package com.mael.ttt.ui;

import com.mael.ttt.players.AlienPlayer;
import com.mael.ttt.players.HumanPlayer;
import com.mael.ttt.players.Player;
import com.mael.ttt.players.RobotPlayer;

import java.util.*;
import java.util.function.Supplier;

public class Menu {

    private UserInterface gameUI;
    private Map<String, Supplier<List<Player>>> menuOptions;
    private List<String> printedMenuOptions;

    public Menu(UserInterface gameUI) {
        this.gameUI        = gameUI;
        menuOptions        = new HashMap<>();
        printedMenuOptions = new ArrayList<>();

        initializeOptions();
    }

    public List<Player> createPlayers() {
        String option = setOption();
        return menuOptions.get(option).get();
    }

    private void initializeOptions() {
        menuOptions.put("1", this::twoHumans);
        printedMenuOptions.add(" 1) Human vs. human\n");

        menuOptions.put("2", this::humanAndRobot);
        printedMenuOptions.add(" 2) Human vs. robot\n");

        menuOptions.put("3", this::twoRobots);
        printedMenuOptions.add(" 3) Robot vs. robot\n");

        menuOptions.put("4", this::humanAndAlien);
        printedMenuOptions.add(" 4) Human vs. alien\n");
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
            option = printPlayersMenu();
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

    private String printPlayersMenu() {
        String menu = "\nChoose an option:\n";
        for (String printedMenuOption : printedMenuOptions) {
            menu += printedMenuOption;
        }

        return gameUI.getMenuOption(menu);
    }
}
