package com.mael.ttt;

import com.mael.ttt.players.Player;
import com.mael.ttt.ui.UserInterface;

public class Turn {

    private final Board board;
    private final UserInterface gameUI;

    public Turn(Board board, UserInterface gameUI) {
        this.board  = board;
        this.gameUI = gameUI;
    }

    public boolean keepPlaying(Player player, Mark currentMark) {
        gameUI.printBoard(board);
        board.setCell(player.getMove(board), currentMark.getMark());
        return isNotGameOver(currentMark);
    }

    private boolean isNotGameOver(Mark currentMark) {
        return !(checkForWinner(currentMark) || checkForFull());
    }

    private boolean checkForWinner(Mark currentMark) {
        if (new BoardChecker(board).hasWinner(currentMark.getMark())) {
            gameUI.printBoard(board);
            gameUI.printHasWinnerMessage(currentMark.getMark());
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
}