package com.mael.ttt;

import com.mael.ttt.players.*;
import com.mael.ttt.ui.Menu;
import com.mael.ttt.ui.MenuOption;
import com.mael.ttt.ui.UserInterface;

public class GameSetup {
    private Board board;
    private BoardChecker checker;
    private UserInterface gameUI;

    public GameSetup(Board board, UserInterface gameUI) {
        this.board   = board;
        this.checker = new BoardChecker(board);
        this.gameUI  = gameUI;
    }

    public void playGame() {
        do {
            setUp();
            MenuOption option = getMenuOption();
            Game game     = new Game(new Turn(board, checker, gameUI), createPlayer(option), createOpponent(option));
            game.start();
        } while (gameUI.replay().equals("y"));
    }

    private void setUp() {
        board.reset();
        gameUI.printWelcomeMessage();
    }

    private MenuOption getMenuOption() {
        return new Menu(gameUI).getUserOption();
    }

    private Player createPlayer(MenuOption option) {
        return new PlayerCreator(gameUI).createPlayer(option);
    }

    private Player createOpponent(MenuOption option) {
        return new PlayerCreator(gameUI).createOpponent(option);
    }
}