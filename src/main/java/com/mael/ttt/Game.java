package com.mael.ttt;

import com.mael.ttt.players.Player;
import com.mael.ttt.ui.UserInterface;

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

    public Game(Board board, UserInterface gameUI, List<Player> players) {
        this.board   = board;
        this.gameUI  = gameUI;
        player1      = players.get(0);
        player2      = players.get(1);
        playerMark   = PLAYER.getMark();
        opponentMark = OPPONENT.getMark();
        resetGame();
    }

    private void resetGame() {
        board.reset();
        currentMark = playerMark;
    }

    public void start() {
        boolean play = true;
        while (play) {
            play = nextTurn();
        }
    }

    private boolean nextTurn() {
        gameUI.printBoard(board);
        board.setCell(getPlayer().getMove(board), currentMark);
        return updateGameStatus();
    }

    private Player getPlayer() {
        return (currentMark.equals(playerMark)) ? player1 : player2;
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
