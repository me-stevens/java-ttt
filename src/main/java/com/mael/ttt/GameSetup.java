package com.mael.ttt;

import com.mael.ttt.players.Player;
import com.mael.ttt.ui.UserInterface;
import com.mael.ttt.ui.menu.MenuCreator;

import java.util.List;

public class GameSetup {
    private Board board;
    private UserInterface gameUI;

    public GameSetup(Board board, UserInterface gameUI) {
        this.board  = board;
        this.gameUI = gameUI;
    }

    public void setUp() {
        gameUI.printWelcomeMessage();
    }

    public void playGame() {
        do {
            board.reset();
            List<Player> players = setPlayers();
            Game game = new Game(new Turn(board, gameUI), players.get(0), players.get(1));
            game.start();
        } while (gameUI.replay().equals("y"));
    }

    private List<Player> setPlayers() {
        return new MenuCreator(gameUI).createMenu().createPlayers();
    }
}