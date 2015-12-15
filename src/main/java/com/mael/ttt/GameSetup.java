package com.mael.ttt;

import com.mael.ttt.players.Player;
import com.mael.ttt.players.PlayerType;
import com.mael.ttt.ui.Menu;
import com.mael.ttt.ui.MenuOption;
import com.mael.ttt.ui.UserInterface;

import static com.mael.ttt.Mark.OPPONENT;
import static com.mael.ttt.Mark.PLAYER;

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
            String option = getMenuOption();
            Game game     = new Game(new Turn(board, checker, gameUI), getPlayer(option), getOpponent(option));
            game.start();
        } while (gameUI.replay().equals("y"));
    }

    private void setUp() {
        gameUI.printWelcomeMessage();
        board.reset();
    }

    private String getMenuOption() {
        return new Menu(gameUI).getUserOption();
    }

    private Player getPlayer(String option) {
        return MenuOption.conversionTable(getPlayerType(option), gameUI, PLAYER);
    }

    private Player getOpponent(String option) {
        return MenuOption.conversionTable(getOpponentType(option), gameUI, OPPONENT);
    }

    private PlayerType getPlayerType(String option) {
        return MenuOption.idToOption(option).getPlayerType();
    }

    private PlayerType getOpponentType(String option) {
        return MenuOption.idToOption(option).getOpponentType();
    }
}