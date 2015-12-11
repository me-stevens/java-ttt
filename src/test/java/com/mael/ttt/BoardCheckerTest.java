package com.mael.ttt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static com.mael.ttt.Mark.*;

public class BoardCheckerTest {

    int size;
    private Board board;
    private BoardChecker checker;
    private String playerMark;
    private String opponentMark;

    @Before
    public void setUp() {
        size    = 3;
        board   = new Board(size);
        checker = new BoardChecker(board);

        playerMark   = PLAYER.getString();
        opponentMark = OPPONENT.getString();
    }

    @Test
    public void thereIsNoWinnerIfEmptyBoard() {
        assertFalse(checker.hasWinner(playerMark));
        assertFalse(checker.hasWinner(opponentMark));
    }

    @Test
    public void checksWinnerInRow() {
        for (int index = 1; index <= size; index++) {
            board.setCell(index, playerMark);
        }

        assertTrue(checker.hasWinner(playerMark));
    }

    @Test
    public void checksWinnerInColumn() {
        for (int row = 0; row < size; row++) {
            board.setCell(board.getIndexFromCoords(row, 0), playerMark);
        }

        assertTrue(checker.hasWinner(playerMark));
    }

    @Test
    public void checksWinnerInDiagonal() {
        for (int row = 0, col = 0; row < size && col < size; row++, col++) {
            board.setCell(board.getIndexFromCoords(row, col), playerMark);
        }

        assertTrue(checker.hasWinner(playerMark));
    }

    @Test
    public void checksWinnerInAntiDiagonal() {
        for (int row = 0, col = size-1; row < size && col >= 0; row++, col--) {
            board.setCell(board.getIndexFromCoords(row, col), playerMark);
        }

        assertTrue(checker.hasWinner(playerMark));
    }
}
