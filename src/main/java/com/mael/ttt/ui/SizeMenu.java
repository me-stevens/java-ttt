package com.mael.ttt.ui;

public class SizeMenu {

    private UserInterface gameUI;

    public SizeMenu(UserInterface gameUI) {
        this.gameUI = gameUI;
    }

    public SizeOption getUserOption() {
        String option = "";
        while (isInvalidOption(option)) {
            gameUI.printMenuPrompt();
            option = gameUI.getMenuOption(gameUI.formatSizeMenuOptions());
        }
        return SizeOption.inputToOption(option);
    }

    private boolean isInvalidOption(String option) {
        return !SizeOption.contains(option);
    }
}
