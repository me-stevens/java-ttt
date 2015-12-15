package com.mael.ttt;

import com.mael.ttt.players.Player;
import com.mael.ttt.ui.UserInterface;

public class Turn {

    private Board board;
    private UserInterface gameUI;
    private BoardChecker boardChecker;

    public Turn(Board board, BoardChecker boardChecker, UserInterface gameUI) {
        this.board        = board;
        this.boardChecker = boardChecker;
        this.gameUI       = gameUI;
    }

    public void placeMark(Player player) {
        gameUI.printBoard(board);
        board.setCell(player.getMove(board), player.getMark().getString());
    }

    public boolean isNotGameOver(Player player) {
        return checkForWinnerOrFull(player.getMark());
    }

    private boolean checkForWinnerOrFull(Mark currentMark) {
        return !(checkForWinner(currentMark) || checkForFull());
    }

    private boolean checkForWinner(Mark currentMark) {
        if (boardChecker.hasWinner(currentMark.getString())) {
            gameUI.printBoard(board);
            gameUI.printHasWinnerMessage(currentMark.getString());
            return true;
        }

        return false;
    }

    private boolean checkForFull() {
        if (boardChecker.isFull()) {
            gameUI.printBoard(board);
            gameUI.printIsFullMessage();
            return true;
        }

        return false;
    }
}