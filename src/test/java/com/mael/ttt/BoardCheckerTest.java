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
    private Mark playerMark;
    private Mark opponentMark;

    @Before
    public void setUp() {
        size    = 3;
        board   = new Board(size);
        checker = new BoardChecker(board);

        playerMark   = PLAYER;
        opponentMark = OPPONENT;
    }

    @Test
    public void checksThatBoardIsFull() {
        setBoardContents(size*size, PLAYER);
        assertTrue(checker.isFull());
    }

    @Test
    public void thereIsNoWinnerIfEmptyBoard() {
        assertFalse(checker.hasWinner(playerMark));
        assertFalse(checker.hasWinner(opponentMark));
    }

    @Test
    public void checksWinnerInRow() {
        setBoardContents(size, playerMark);
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

    private void setBoardContents(int numberOfCells, Mark cellContent) {
        for (int index = 1; index <= numberOfCells; index++) {
            board.setCell(index, cellContent);
        }
    }
}

