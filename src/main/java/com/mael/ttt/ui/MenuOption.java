package com.mael.ttt.ui;

import com.mael.ttt.Mark;
import com.mael.ttt.players.AlienPlayer;
import com.mael.ttt.players.HumanPlayer;
import com.mael.ttt.players.Player;
import com.mael.ttt.players.RobotPlayer;

public enum MenuOption {
    HUMAN_HUMAN("1", "Human vs. Human", "human", "human"),
    HUMAN_ROBOT("2", "Human vs. Robot", "human", "robot"),
    ROBOT_ROBOT("3", "Robot vs. Robot", "robot", "robot"),
    HUMAN_ALIEN("4", "Human vs. Alien", "human", "alien");

    private String menuOptionId;
    private String menuOptionText;
    private String playerType;
    private String opponentType;

    MenuOption(String menuOptionId, String menuOptionText, String player, String opponent) {
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

    public String getPlayerType() {
        return playerType;
    }

    public String getOpponentType() {
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

    public static Player createPlayer(String playerType, UserInterface gameUI, Mark mark) {
        if (playerType.equals("human")) {
            return new HumanPlayer(gameUI, mark);
        } else if (playerType.equals("robot")) {
            return new RobotPlayer(gameUI, mark);
        }
        return new AlienPlayer(gameUI, mark);
    }
}
