package com.mael.ttt.ui;

import java.util.*;

public class Menu {

    private UserInterface gameUI;
    private List<String> menuOptionIds;

    public Menu(UserInterface gameUI) {
        this.gameUI        = gameUI;
        this.menuOptionIds = new ArrayList<>();
        initializeOptions();
    }

    public String getUserOption() {
        String option = "";
        while (isInvalidOption(option)) {
            gameUI.printMenuPrompt();
            option = gameUI.getMenuOption(gameUI.formatMenuOptions());
        }
        return option;
    }

    private boolean isInvalidOption(String option) {
        return !menuOptionIds.contains(option);
    }

    private void initializeOptions() {
        for (MenuOption menuOption : MenuOption.values()) {
            this.menuOptionIds.add(menuOption.getMenuOptionId());
        }
    }
}
