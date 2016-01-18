package com.mael.ttt.ui;

import java.util.ArrayList;
import java.util.List;

public enum MenuOption {
    HUMAN_HUMAN("1", "Human vs. Human"),
    HUMAN_ROBOT("2", "Human vs. Robot"),
    ROBOT_ROBOT("3", "Robot vs. Robot"),
    HUMAN_ALIEN("4", "Human vs. Alien");

    private String option;
    private String text;
    private static List<String> allInputs = new ArrayList<>();

    MenuOption(String input, String text) {
        this.option = input;
        this.text  = text;
    }

    public String getOption() {
        return option;
    }

    public String getText() {
        return text;
    }

    public static List<String> getAllInputs() {
        allInputs.clear();
        for (MenuOption menuOption : values()) {
            allInputs.add(menuOption.getOption());
        }
        return allInputs;
    }

    public static MenuOption inputToOption(String input) {
        for (MenuOption menuOption : values()) {
            if (menuOption.getOption().equals(input)) {
                return menuOption;
            }
        }
        return HUMAN_HUMAN;
    }
}
