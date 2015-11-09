import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
    public void resetsBoard() {
        board.setCell(1, "hi");
        board.reset();

        for (int index = 1; index <= size*size; index++) {
            assertEquals("", board.getCell(index));
        }
    }

    @Test
    public void newBoardIsNotFull() {
        assertFalse(board.isFull());
    }

    @Test
    public void checksThatBoardIsFull() {
        for (int index = 1; index <= size*size; index++) {
            board.setCell(index, "hi");
        }

        assertTrue(board.isFull());
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
        board.setCell(1, "hi");
        assertTrue(board.isCellBusy(1));
    }

    @Test
    public void getsTheContentsOfTheBoard() {
        String[][] expected = new String[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                expected[row][col] = "";
            }
        }

        expected[0][0] = "hi";
        board.setCell(1, "hi");
        assertTrue( Arrays.deepEquals(expected, board.getContents()) );
    }
}
