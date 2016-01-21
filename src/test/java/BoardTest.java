import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

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
    public void getsTheContentsOfTheBoard() {
        Board expected = setAllCellsTo("");
        expected.setCell(1, "hi");
        board.setCell(1, "hi");
        assertTrue( Arrays.deepEquals(expected.getContents(), board.getContents()) );
    }

    @Test
    public void setsTheContentsOfTheBoard() {
        board = setAllCellsTo("");
        Board expected = setAllCellsTo("hi");
        board.setContents(expected.getContents());
        assertTrue(Arrays.deepEquals(expected.getContents(), board.getContents()));
    }

    @Test
    public void resetsBoard() {
        board.setCell(1, "hi");
        board.reset();
        Board expected = setAllCellsTo("");
        assertTrue( Arrays.deepEquals(expected.getContents(), board.getContents()) );
    }

    @Test
    public void getsTheEmptyCellIndexes() {
        board.setCell(1, "hi");
        List<Integer> expected = asList(2, 3, 4, 5, 6, 7, 8, 9);
        assertEquals(expected, board.getEmptyCellIndexes());
    }

    @Test
    public void newBoardIsNotFull() {
        assertFalse(board.isFull());
    }

    @Test
    public void checksThatBoardIsFull() {
        board = setAllCellsTo("hi");
        assertTrue(board.isFull());
    }

    @Test
    public void getsRowFromCellIndex() {
        assertEquals(0, board.getRowFromIndex(1));
    }

    @Test
    public void getsColFromCellIndex() {
        assertEquals(0, board.getColFromIndex(1));
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
        board.setCell(1, "hi");
        assertTrue(board.isCellBusy(1));
    }

    private Board setAllCellsTo(String cellContent) {
        Board expected = new Board(size);
        for (int index = 1; index <= size*size; index++) {
            expected.setCell(index, cellContent);
        }

        return expected;
    }
}
