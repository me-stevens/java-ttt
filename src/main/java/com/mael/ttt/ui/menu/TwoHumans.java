package com.mael.ttt.ui.menu;

import com.mael.ttt.players.HumanPlayer;
import com.mael.ttt.players.Player;
import com.mael.ttt.ui.UserInterface;

import java.util.Arrays;
import java.util.List;

public class TwoHumans implements Option {

    public List<Player> createPlayers(UserInterface gameUI) {
        Player player1 = new HumanPlayer(gameUI);
        Player player2 = new HumanPlayer(gameUI);
        return Arrays.asList(player1, player2);
    }
}
