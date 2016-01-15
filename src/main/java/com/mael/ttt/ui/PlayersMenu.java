package com.mael.ttt.ui;

public class PlayersMenu {

    private UserInterface gameUI;

    public PlayersMenu(UserInterface gameUI) {
        this.gameUI = gameUI;
    }

    public MenuOption getUserOption() {
        String option = "";
        while (isInvalidOption(option)) {
            gameUI.printMenuPrompt();
            option = gameUI.getMenuOption(gameUI.formatMenuOptions());
        }
        return MenuOption.inputToOption(option);
    }

    private boolean isInvalidOption(String option) {
        return !MenuOption.contains(option);
    }
}
