package com.mael.ttt;

import com.mael.ttt.players.*;
import com.mael.ttt.ui.Menu;
import com.mael.ttt.ui.MenuOption;
import com.mael.ttt.ui.UserInterface;

public class GameSetup {
    private UserInterface gameUI;
    private Menu menu;
    private Board board;
    private Turn turn;
    private PlayerCreator playerCreator;

    public GameSetup(UserInterface gameUI, Menu menu, Board board, Turn turn, PlayerCreator playerCreator) {
        this.gameUI        = gameUI;
        this.menu          = menu;
        this.board         = board;
        this.turn          = turn;
        this.playerCreator = playerCreator;
    }

    public void playGame() {
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