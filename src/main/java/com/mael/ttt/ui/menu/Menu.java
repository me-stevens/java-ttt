package com.mael.ttt.ui.menu;

import com.mael.ttt.players.Player;
import com.mael.ttt.ui.UserInterface;
import java.util.*;

public class Menu {

    private UserInterface gameUI;
    private Map<String, Option> menuOptions;

    public Menu(UserInterface gameUI, List<Option> menuOptions) {
        this.gameUI      = gameUI;
        this.menuOptions = new HashMap<>();

        initializeOptions(menuOptions);
    }

    public List<Player> createPlayers() {
        return menuOptions.get(getUserOption()).createPlayers(gameUI);
    }

    private void initializeOptions(List<Option> menuOptions) {
        for (int i = 0; i < MenuOption.values().length; i++) {
            this.menuOptions.put(MenuOption.values()[i].getMenuOptionId(), menuOptions.get(i));
        }
    }

    private String getUserOption() {
        String option = "";
        while (isInvalidOption(option)) {
            option = printPlayersMenu();
        }
        return option;
    }

    private boolean isInvalidOption(String option) {
        return !menuOptions.containsKey(option);
    }

    private String printPlayersMenu() {
        gameUI.printMenuPrompt();
        return gameUI.getMenuOption(gameUI.formatMenuOptions());
    }
}
