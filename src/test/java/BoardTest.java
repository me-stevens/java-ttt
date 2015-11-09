import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    int size;
    private Board board;

    @Before
    public void setUp() throws Exception {
        size  = 3;
        board = new Board(size);
    }

    @Test
    public void resetsBoard() {
        board.setCell(1, "asdf");
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
            board.setCell(index, "X");
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
        board.setCell(1, "X");
        assertTrue(board.isCellBusy(1));
    }
}
