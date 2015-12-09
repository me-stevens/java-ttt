package com.mael.ttt;

import com.mael.ttt.players.Player;
import com.mael.ttt.ui.UserInterface;
import com.mael.ttt.ui.menu.MenuCreator;

import java.util.List;

import static com.mael.ttt.Marks.*;

public class Game {

    private Board board;
    private UserInterface gameUI;
    private String currentMark;
    private Player player1;
    private Player player2;
    private String playerMark;
    private String opponentMark;

    public Game(Board board, UserInterface gameUI) {
        this.board   = board;
        this.gameUI  = gameUI;
        playerMark   = PLAYER.getMark();
        opponentMark = OPPONENT.getMark();
        resetGame();
    }

    public void run() {
        do {
            resetGame();
            start();
        } while (gameUI.replay().equals("y"));
    }

    private void resetGame() {
        board.reset();
        currentMark = playerMark;
    }

    private void start() {
        gameUI.printWelcomeMessage();
        setPlayers();

        boolean play = true;
        while (play) {
            play = nextTurn();
        }
    }

    private void setPlayers() {
        List<Player> players = new MenuCreator().createMenu(gameUI).createPlayers();
        player1 = players.get(0);
        player2 = players.get(1);
    }

    private boolean nextTurn() {
        gameUI.printBoard(board);

        Player currentPlayer = (currentMark.equals(playerMark)) ? player1 : player2;
        int index            = currentPlayer.getCellIndex(board);
        board.setCell(index, currentMark);

        return updateGameStatus();
    }

    private boolean updateGameStatus() {
        if (checkForWinner() || checkForFull()) {
            return false;
        }

        swapPlayer();
        return true;
    }

    private boolean checkForWinner() {
        if (new BoardChecker(board).hasWinner(currentMark)) {
            gameUI.printBoard(board);
            gameUI.printHasWinnerMessage(currentMark);
            return true;
        }

        return false;
    }

    private boolean checkForFull() {
        if (board.isFull()) {
            gameUI.printBoard(board);
            gameUI.printIsFullMessage();
            return true;
        }

        return false;
    }

    private void swapPlayer() {
        currentMark = (currentMark == playerMark) ? opponentMark : playerMark;
    }
}
