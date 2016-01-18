package com.mael.ttt.ui;

import java.util.Map;

public class Menu {

    private UserInterface gameUI;

    public Menu(UserInterface gameUI) {
        this.gameUI = gameUI;
    }

    public PlayerOption getPlayerOption() {
        String input = askUntilRightOption(PlayerOption.getPlayerOptions());
        return PlayerOption.convertToOption(input);
    }

    public SizeOption getSizeOption() {
        String input = askUntilRightOption(SizeOption.getSizeOptions());
        return SizeOption.convertToOption(input);
    }

    private String askUntilRightOption(Map<String, String> playerOptions) {
        String input = "";
        while (isInvalidInput(input, playerOptions)) {
            gameUI.printMenuPrompt();
            input = gameUI.getMenuOption(gameUI.formatMenuOptions(playerOptions));
        }
        return input;
    }

    private boolean isInvalidInput(String input, Map<String, String> playerOptions) {
        return !playerOptions.containsKey(input);
    }
}
