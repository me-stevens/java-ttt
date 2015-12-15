package com.mael.ttt.ui;

import com.mael.ttt.players.PlayerType;

import static com.mael.ttt.players.PlayerType.*;

public enum MenuOption {
    HUMAN_HUMAN("1", "Human vs. Human", HUMAN, HUMAN),
    HUMAN_ROBOT("2", "Human vs. Robot", HUMAN, ROBOT),
    ROBOT_ROBOT("3", "Robot vs. Robot", ROBOT, ROBOT),
    HUMAN_ALIEN("4", "Human vs. Alien", HUMAN, ALIEN);

    private String menuOptionId;
    private String menuOptionText;
    private PlayerType playerType;
    private PlayerType opponentType;

    MenuOption(String menuOptionId, String menuOptionText, PlayerType player, PlayerType opponent) {
        this.menuOptionId   = menuOptionId;
        this.menuOptionText = menuOptionText;
        this.playerType     = player;
        this.opponentType   = opponent;
    }

    public String getMenuOptionId() {
        return menuOptionId;
    }

    public String getMenuOptionText() {
        return menuOptionText;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public PlayerType getOpponentType() {
        return opponentType;
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
