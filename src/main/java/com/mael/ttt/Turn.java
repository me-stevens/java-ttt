package com.mael.ttt;

import com.mael.ttt.players.Player;
import com.mael.ttt.ui.UserInterface;

import static com.mael.ttt.Mark.*;


public class Turn {

    private Board board;
    private UserInterface gameUI;
    private BoardChecker boardChecker;

    public Turn(UserInterface gameUI, Board board, BoardChecker boardChecker) {
        this.board        = board;
        this.boardChecker = boardChecker;
        this.gameUI       = gameUI;
    }

    public void placeMark(Player player) {
        gameUI.printBoard(board);
        board.setCell(player.getMove(board), player.getMark());
    }

    public boolean canBePlayed() {
        return !(hasWinner() || isFull());
    }

    public void printResults(Mark winnerMark) {
        gameUI.printBoard(board);
        if (hasWinner()) {
            gameUI.printHasWinnerMessage(winnerMark);
        } else if (isFull()) {
            gameUI.printIsFullMessage();
        }
    }

    private boolean hasWinner() {
        return hasWinner(PLAYER) || hasWinner(OPPONENT);
    }

    private boolean hasWinner(Mark currentMark) {
        return boardChecker.hasWinner(currentMark);
    }

    private boolean isFull() {
        return boardChecker.isFull();
    }
}