package com.mael.ttt;

import com.mael.ttt.players.*;
import com.mael.ttt.ui.GameConsole;
import com.mael.ttt.ui.Menu;
import com.mael.ttt.ui.PlayerOption;
import com.mael.ttt.ui.UserInterface;

public class GameRunner {
    private UserInterface gameUI;
    private Board board;

    public GameRunner(UserInterface gameUI, Board board) {
        this.gameUI = gameUI;
        this.board  = board;
    }

    public void playGame(Menu menu, Turn turn, PlayerCreator playerCreator) {
        do {
            setUp();
            PlayerOption option = menu.getPlayerOption();

            Game game         = new Game(turn, playerCreator.createPlayer(option), playerCreator.createOpponent(option));
            game.play();
        } while (gameUI.replay());
    }

    private void setUp() {
        board.reset();
        gameUI.printWelcomeMessage();
    }

    public static void main(String[] args) {
        UserInterface gameUI = new UserInterface(new GameConsole(System.in, System.out));
        Board board          = new Board(3);
        GameRunner gameSetup = new GameRunner(gameUI, board);
        gameSetup.playGame(new Menu(gameUI), new Turn(gameUI, board, new BoardChecker(board)), new PlayerCreator(gameUI));
    }
}