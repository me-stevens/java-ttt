package com.mael.ttt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static com.mael.ttt.Mark.*;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BoardTest {

    private int size;
    private Board board;

    public BoardTest(int boardSize) {
        size  = boardSize;
        board = new Board(size);
    }

    @Parameterized.Parameters
    public static Collection dataSetup() {
        return Arrays.asList(new Object[][] { {3}, {4} });
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
        List<Integer> expected = getCellIndexesStartingOn(2);
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

    private List<Integer> getCellIndexesStartingOn(int start) {
        List<Integer> expected = new ArrayList<>();
        for (int i = start; i <= size*size; i++) {
            expected.add(i);
        }
        return expected;
    }
}
