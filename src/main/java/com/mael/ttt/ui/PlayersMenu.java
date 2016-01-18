package com.mael.ttt.ui;

import java.util.List;

public class PlayersMenu {

    private UserInterface gameUI;

    public PlayersMenu(UserInterface gameUI) {
        this.gameUI = gameUI;
    }

    public MenuOption getPlayersMenuOption() {
        return MenuOption.inputToOption(askUntilRightOption(MenuOption.getAllInputs()));
    }

    private String askUntilRightOption(List<String> allInputs) {
        String input = "";
        while (isInvalidInput(input, allInputs)) {
            gameUI.printMenuPrompt();
            input = gameUI.getMenuOption(gameUI.formatMenuOptions());
        }
        return input;
    }

    private boolean isInvalidInput(String input, List<String> allInputs) {
        return !contains(input, allInputs);
    }

    public boolean contains(String input, List<String> allInputs) {
        for (String option : allInputs) {
            if (option.equals(input)) {
                return true;
            }
        }
        return false;
    }
}
