package com.mael.ttt.ui.menu;

import com.mael.ttt.players.Player;
import com.mael.ttt.ui.UserInterface;

import java.util.*;

public class Menu {

    private UserInterface gameUI;
    private Map<String, Option> menuOptions;
    private List<String> menuOptionIds;
    private List<String> menuOptionTexts;

    public Menu(UserInterface gameUI, List<String> menuOptionIds, List<Option> menuOptions, List<String> menuOptionTexts) {
        this.gameUI          = gameUI;
        this.menuOptionIds   = menuOptionIds;
        this.menuOptions     = new HashMap<>();
        this.menuOptionTexts = menuOptionTexts;

        initializeOptions(menuOptionIds, menuOptions);
    }

    public List<Player> createPlayers() {
        String option = setOption();
        return menuOptions.get(option).createPlayers(gameUI);
    }

    private void initializeOptions(List<String> menuOptionIds, List<Option> menuOptions) {
        for (int i = 0; i < menuOptionIds.size(); i++) {
            this.menuOptions.put(menuOptionIds.get(i), menuOptions.get(i));
        }
    }

    private String setOption() {
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
        return gameUI.getMenuOption(gameUI.formatMenuOptions(menuOptionIds, menuOptionTexts));
    }
}
