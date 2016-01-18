package com.mael.ttt;

import com.mael.ttt.players.Player;
import com.mael.ttt.players.PlayerCreator;
import com.mael.ttt.ui.*;

public class GameRunner {
    private UserInterface gameUI;

    public GameRunner(UserInterface gameUI) {
        this.gameUI = gameUI;
    }

    public void playGame(Menu menu, PlayerCreator playerCreator) {
        do {
            gameUI.printWelcomeMessage();
            PlayerOption playerOption = menu.getPlayerOption();
            SizeOption sizeOption     = menu.getSizeOption();

            Player player             = playerCreator.createPlayer(playerOption);
            Player opponent           = playerCreator.createOpponent(playerOption);

            Game game                 = new Game(createTurn(sizeOption), player, opponent);
            game.play();
        } while (gameUI.replay());
    }

    private Turn createTurn(SizeOption sizeOption) {
        Board board = new Board(sizeOption.getBoardSize());
        return new Turn(gameUI, board, new BoardChecker(board));
    }

    public static void main(String[] args) {
        UserInterface gameUI = new UserInterface(new GameConsole(System.in, System.out));
        GameRunner gameSetup = new GameRunner(gameUI);
        gameSetup.playGame(new Menu(gameUI), new PlayerCreator(gameUI));
    }
}