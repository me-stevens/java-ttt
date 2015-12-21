package com.mael.ttt.ui;

public enum MenuOption {
    HUMAN_HUMAN("1", "Human vs. Human"),
    HUMAN_ROBOT("2", "Human vs. Robot"),
    ROBOT_ROBOT("3", "Robot vs. Robot"),
    HUMAN_ALIEN("4", "Human vs. Alien");

    private String menuOptionId;
    private String menuOptionText;

    MenuOption(String menuOptionId, String menuOptionText) {
        this.menuOptionId   = menuOptionId;
        this.menuOptionText = menuOptionText;
    }

    public String getMenuOptionId() {
        return menuOptionId;
    }

    public String getMenuOptionText() {
        return menuOptionText;
    }


    public static MenuOption idToOption(String menuOptionId) {
        for (MenuOption menuOption : values()) {
            if (menuOptionId.equals(menuOption.getMenuOptionId())) {
                return menuOption;
            }
        }

        return HUMAN_HUMAN;
    }
}
