package com.mael.ttt;

import com.mael.ttt.players.Player;
import com.mael.ttt.ui.UserInterface;
import com.mael.ttt.ui.menu.MenuCreator;

import java.util.List;

public class GameSetup {
    private UserInterface gameUI;

    public GameSetup(UserInterface gameUI) {
        this.gameUI = gameUI;
    }

    public void setUp() {
        gameUI.printWelcomeMessage();
    }

    public void playGame() {
        do {
            Game game = new Game(new Board(3), gameUI, setPlayers());
            game.start();
        } while (gameUI.replay().equals("y"));
    }

    private List<Player> setPlayers() {
        return new MenuCreator().createMenu(gameUI).createPlayers();
    }
}
