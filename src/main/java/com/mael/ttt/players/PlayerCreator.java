package com.mael.ttt.players;

import com.mael.ttt.ui.PlayerOption;
import com.mael.ttt.ui.UserInterface;

import static com.mael.ttt.Mark.*;
import static com.mael.ttt.ui.PlayerOption.*;

public class PlayerCreator {

    private UserInterface gameUI;

    public PlayerCreator(UserInterface gameUI) {
        this.gameUI = gameUI;
    }

    public Player createPlayer(PlayerOption option) {
        if (option == ROBOT_ROBOT) {
            return new RobotPlayer(gameUI, PLAYER);
        }
        return new HumanPlayer(gameUI, PLAYER);
    }

    public Player createOpponent(PlayerOption option) {
        if (option == HUMAN_ROBOT || option == ROBOT_ROBOT) {
            return new RobotPlayer(gameUI, OPPONENT);
        } else if (option == HUMAN_ALIEN) {
            return new AlienPlayer(gameUI, OPPONENT);
        }
        return new HumanPlayer(gameUI, OPPONENT);
    }
}
