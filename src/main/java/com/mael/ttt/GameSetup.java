package com.mael.ttt;

import com.mael.ttt.players.*;
import com.mael.ttt.ui.Menu;
import com.mael.ttt.ui.MenuOption;
import com.mael.ttt.ui.UserInterface;

public class GameSetup {
    private UserInterface gameUI;
    private Board board;

    public GameSetup(UserInterface gameUI, Board board) {
        this.gameUI        = gameUI;
        this.board         = board;
    }

    public void playGame(Menu menu, Turn turn, PlayerCreator playerCreator) {
        do {
            setUp();
            MenuOption option = menu.getUserOption();
            Game game         = new Game(turn, playerCreator.createPlayer(option), playerCreator.createOpponent(option));
            game.play();
        } while (gameUI.replay());
    }

    private void setUp() {
        board.reset();
        gameUI.printWelcomeMessage();
    }
}