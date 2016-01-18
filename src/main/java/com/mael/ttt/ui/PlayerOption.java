package com.mael.ttt.ui;

import java.util.HashMap;
import java.util.Map;

public enum PlayerOption {
    HUMAN_HUMAN("1", "Human vs. Human"),
    HUMAN_ROBOT("2", "Human vs. Robot"),
    ROBOT_ROBOT("3", "Robot vs. Robot"),
    HUMAN_ALIEN("4", "Human vs. Alien");

    private String option;
    private String text;

    PlayerOption(String option, String text) {
        this.option = option;
        this.text   = text;
    }

    public String getOption() {
        return option;
    }

    public String getText() {
        return text;
    }

    public static Map<String, String> getPlayerOptions() {
        Map<String, String> playerOptions = new HashMap<>();

        for (PlayerOption option: values()) {
            playerOptions.put(option.getOption(), option.getText());
        }

        return playerOptions;
    }

    public static PlayerOption convertToOption(String input) {
        for (PlayerOption menuOption : values()) {
            if (menuOption.getOption().equals(input)) {
                return menuOption;
            }
        }
        return HUMAN_HUMAN;
    }
}
