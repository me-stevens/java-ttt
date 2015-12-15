package com.mael.ttt;

import com.mael.ttt.players.*;
import com.mael.ttt.ui.Menu;
import com.mael.ttt.ui.UserInterface;

import static com.mael.ttt.Mark.*;
import static com.mael.ttt.players.PlayerType.*;
import static com.mael.ttt.ui.MenuOption.idToOption;

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
            Game game     = new Game(new Turn(board, checker, gameUI), createPlayer(option), createOpponent(option));
            game.start();
        } while (gameUI.replay().equals("y"));
    }

    private void setUp() {
        board.reset();
        gameUI.printWelcomeMessage();
    }

    private String getMenuOption() {
        return new Menu(gameUI).getUserOption();
    }

    private Player createPlayer(String option) {
        return conversionTable(getPlayerType(option), PLAYER);
    }

    private Player createOpponent(String option) {
        return conversionTable(getOpponentType(option), OPPONENT);
    }

    private PlayerType getPlayerType(String option) {
        return idToOption(option).getPlayerType();
    }

    private PlayerType getOpponentType(String option) {
        return idToOption(option).getOpponentType();
    }

    public Player conversionTable(PlayerType playerType, Mark mark) {
        if (playerType == ROBOT) {
            return new RobotPlayer(gameUI, mark);
        } else if (playerType == ALIEN) {
            return new AlienPlayer(gameUI, mark);
        }
        return new HumanPlayer(gameUI, mark);
    }
}