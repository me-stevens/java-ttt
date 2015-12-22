package com.mael.ttt;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.mael.ttt.Mark.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class BoardTest {

    int size;
    private Board board;

    @Before
    public void setUp() {
        size  = 3;
        board = new Board(size);
    }

    @Test
    public void getsACopyOfTheBoard() {
        board.setCell(1, PLAYER);
        Board copy = board.getCopy();
        assertNotEquals(copy, board);
        assertEquals(getContentsAsString(board), getContentsAsString(copy));
    }

    @Test
    public void resetsBoard() {
        board.setCell(1, PLAYER);
        board.reset();
        Board expected = setAllCellsTo(EMPTY);
        assertEquals(getContentsAsString(expected), getContentsAsString(board));
    }

    @Test
    public void getsTheEmptyCellIndexes() {
        board.setCell(1, PLAYER);
        List<Integer> expected = asList(2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(expected, board.getEmptyCellIndexes());
    }

    @Test
    public void getsRowFromCellIndex() {
        assertEquals((1 - 1) / size, board.getRowFromIndex(1));
    }

    @Test
    public void getsColFromCellIndex() {
        assertEquals((1 - 1) % size, board.getColFromIndex(1));
    }

    @Test
    public void getsIndexFromCoords() {
        assertEquals(1, board.getIndexFromCoords(0, 0));
    }

    @Test
    public void checksThatCellIsNotBusy() {
        assertFalse(board.isCellBusy(1));
    }

    @Test
    public void checksIfCellIsBusy() {
        board.setCell(1, PLAYER);
        assertTrue(board.isCellBusy(1));
    }

    @Test
    public void setsAllBoardContentsAtOnce() {
        Board expected = setAllCellsTo(PLAYER);
        board.setBoardContents(PLAYER, PLAYER, PLAYER, PLAYER, PLAYER, PLAYER, PLAYER, PLAYER, PLAYER);
        assertEquals(getContentsAsString(expected), getContentsAsString(board));
    }

    private Board setAllCellsTo(Mark cellContent) {
        Board expected = new Board(size);
        for (int index = 1; index <= size*size; index++) {
            expected.setCell(index, cellContent);
        }
        return expected;
    }

    private String getContentsAsString(Board board) {
        String boardContents = "";
        for (int index = 1; index <= size*size; index++) {
            boardContents += board.getCell(index).getString();
        }
        return boardContents;
    }
}
