package com.mael.ttt.ui;

public class Menu {

    private UserInterface gameUI;

    public Menu(UserInterface gameUI) {
        this.gameUI = gameUI;
    }

    public MenuOption getUserOption() {
        String option = "";
        while (isInvalidOption(option)) {
            gameUI.printMenuPrompt();
            option = gameUI.getMenuOption(gameUI.formatMenuOptions());
        }

        return MenuOption.idToOption(option);
    }

    private boolean isInvalidOption(String option) {
        return !MenuOption.contains(option);
    }
}
