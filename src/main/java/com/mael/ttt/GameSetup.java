package com.mael.ttt;

import com.mael.ttt.players.Player;
import com.mael.ttt.ui.UserInterface;
import com.mael.ttt.ui.Menu;
import com.mael.ttt.ui.MenuOption;

import static com.mael.ttt.Mark.*;

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
            gameUI.printWelcomeMessage();
            board.reset();
            String option = new Menu(gameUI).getUserOption();
            Game game     = new Game(new Turn(board, checker, gameUI), getPlayer(option), getOpponent(option));
            game.start();
        } while (gameUI.replay().equals("y"));
    }

    private Player getPlayer(String option) {
        return MenuOption.createPlayer(getPlayerType(option), gameUI, PLAYER);
    }

    private Player getOpponent(String option) {
        return MenuOption.createPlayer(getOpponentType(option), gameUI, OPPONENT);
    }

    private String getPlayerType(String option) {
        return MenuOption.idToOption(option).getPlayerType();
    }

    private String getOpponentType(String option) {
        return MenuOption.idToOption(option).getOpponentType();
    }
}