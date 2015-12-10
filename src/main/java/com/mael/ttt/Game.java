package com.mael.ttt;

import com.mael.ttt.players.Player;
import com.mael.ttt.ui.UserInterface;

import static com.mael.ttt.Marks.*;

public class Game {

    private Board board;
    private UserInterface gameUI;
    private Player player;
    private Player opponent;
    private String playerMark;
    private String opponentMark;
    private String currentMark;

    public Game(Board board, UserInterface gameUI, Player player, Player opponent) {
        this.board    = board;
        this.gameUI   = gameUI;
        this.player   = player;
        this.opponent = opponent;
        playerMark    = PLAYER.getMark();
        opponentMark  = OPPONENT.getMark();
        currentMark   = playerMark;
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
        return (currentMark.equals(playerMark)) ? player : opponent;
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
        currentMark = (currentMark.equals(playerMark)) ? opponentMark : playerMark;
    }
}