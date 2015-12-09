package com.mael.ttt.ui.menu;

import com.mael.ttt.Marks;
import com.mael.ttt.players.Player;
import com.mael.ttt.players.RobotPlayer;
import com.mael.ttt.ui.UserInterface;

import java.util.Arrays;
import java.util.List;

import static com.mael.ttt.Marks.*;

public class TwoRobots implements Option {

    public List<Player> createPlayers(UserInterface gameUI) {
        Player player1 = new RobotPlayer(gameUI, PLAYER.getMark());
        Player player2 = new RobotPlayer(gameUI, OPPONENT.getMark());
        return Arrays.asList(player1, player2);
    }
}
