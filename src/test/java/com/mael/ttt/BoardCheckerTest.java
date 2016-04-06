package com.mael.ttt;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static com.mael.ttt.Mark.*;


public class BoardCheckerTest {

    private int size;
    private Board board;
    private BoardChecker checker;

    @Before
    public void setUp() {
        size    = 3;
        board   = new Board (size);
        checker = new BoardChecker(board);
    }

    @Test
    public void checksThatBoardIsFull() {
        setBoardContents(size*size, PLAYER);
        assertTrue(checker.isFull());
    }

    @Test
    public void thereIsNoWinnerIfEmptyBoard() {
        assertFalse(checker.hasWinner(PLAYER));
        assertFalse(checker.hasWinner(OPPONENT));
    }

    @Test
    public void checksWinnerInRow() {
        setBoardContents(size, PLAYER);
        assertTrue(checker.hasWinner(PLAYER));
    }

    @Test
    public void checksWinnerInColumn() {
        for (int row = 0; row < size; row++) {
            board.setCell(board.getIndexFromCoords(row, 0), PLAYER);
        }

        assertTrue(checker.hasWinner(PLAYER));
    }

    @Test
    public void checksWinnerInDiagonal() {
        for (int row = 0, col = 0; row < size && col < size; row++, col++) {
            board.setCell(board.getIndexFromCoords(row, col), PLAYER);
        }

        assertTrue(checker.hasWinner(PLAYER));
    }

    @Test
    public void checksWinnerInAntiDiagonal() {
        for (int row = 0, col = size-1; row < size && col >= 0; row++, col--) {
            board.setCell(board.getIndexFromCoords(row, col), PLAYER);
        }

        assertTrue(checker.hasWinner(PLAYER));
    }

    private void setBoardContents(int numberOfCells, Mark cellContent) {
        for (int index = 1; index <= numberOfCells; index++) {
            board.setCell(index, cellContent);
        }
    }
}

