package com.mael.ttt.players;

import com.mael.ttt.ui.MenuOption;
import com.mael.ttt.ui.UserInterface;

import static com.mael.ttt.Mark.*;
import static com.mael.ttt.ui.MenuOption.*;

public class PlayerCreator {

    private UserInterface gameUI;

    public PlayerCreator(UserInterface gameUI) {
        this.gameUI = gameUI;
    }

    public Player createPlayer(MenuOption option) {
        return createPlayerOfType(option);
    }

    public Player createOpponent(MenuOption option) {
        return createOpponentOfType(option);
    }

    private Player createPlayerOfType(MenuOption option) {
        if (option == ROBOT_ROBOT) {
            return new RobotPlayer(gameUI, PLAYER);
        }
        return new HumanPlayer(gameUI, PLAYER);
    }

    private Player createOpponentOfType(MenuOption option) {
        if (option == HUMAN_ROBOT || option == ROBOT_ROBOT) {
            return new RobotPlayer(gameUI, OPPONENT);
        } else if (option == HUMAN_ALIEN) {
            return new AlienPlayer(gameUI, OPPONENT);
        }
        return new HumanPlayer(gameUI, OPPONENT);
    }
}
