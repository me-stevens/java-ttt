package com.mael.ttt.ui.menu;

import com.mael.ttt.players.Player;
import com.mael.ttt.ui.UserInterface;

import java.util.List;

public interface Option {
    List<Player> createPlayers(UserInterface gameUI);
}
