package com.mael.ttt.players;

import com.mael.ttt.Mark;
import com.mael.ttt.ui.MenuOption;
import com.mael.ttt.ui.UserInterface;

import static com.mael.ttt.Mark.*;
import static com.mael.ttt.players.PlayerType.*;

public class PlayerCreator {

    private UserInterface gameUI;

    public PlayerCreator(UserInterface gameUI) {
        this.gameUI = gameUI;
    }

    public Player createPlayer(MenuOption option) {
        return createPlayerOfType(option.getPlayerType(), PLAYER);
    }

    public Player createOpponent(MenuOption option) {
        return createPlayerOfType(option.getOpponentType(), OPPONENT);
    }

    private Player createPlayerOfType(PlayerType playerType, Mark mark) {
        if (playerType == ROBOT) {
            return new RobotPlayer(gameUI, mark);
        } else if (playerType == ALIEN) {
            return new AlienPlayer(gameUI, mark);
        }
        return new HumanPlayer(gameUI, mark);
    }
}
