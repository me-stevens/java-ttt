package com.mael.ttt.ui;

public enum MenuOption {
    HUMAN_HUMAN("1", "Human vs. Human"),
    HUMAN_ROBOT("2", "Human vs. Robot"),
    ROBOT_ROBOT("3", "Robot vs. Robot"),
    HUMAN_ALIEN("4", "Human vs. Alien");

    private String id;
    private String text;

    MenuOption(String menuOptionId, String menuOptionText) {
        this.id   = menuOptionId;
        this.text = menuOptionText;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public static MenuOption idToOption(String id) {
        for (MenuOption menuOption : values()) {
            if (menuOption.getId().equals(id)) {
                return menuOption;
            }
        }
        return HUMAN_HUMAN;
    }

    public static boolean contains(String id) {
        for (MenuOption menuOption : values()) {
            if (menuOption.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
