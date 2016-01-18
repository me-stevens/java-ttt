package com.mael.ttt.ui;

import java.util.Map;

public class PlayersMenu {

    private UserInterface gameUI;

    public PlayersMenu(UserInterface gameUI) {
        this.gameUI = gameUI;
    }

    public MenuOption getPlayersMenuOption() {
        String input = askUntilRightOption(MenuOption.getPlayerOptions());
        return MenuOption.convertToOption(input);
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
