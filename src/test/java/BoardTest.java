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
        board.setCell(1, 1, "asdf");
        board.reset();

        for (String[] row: board.copy())
            assertArrayEquals(new String[]{"", "", ""}, row);
    }

    @Test
    public void checksForFullBoard() {
        assertFalse(board.isFull());

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board.setCell(i, j, "X");
            }
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
    public void checksIfCellIsBusy() {
        assertFalse(board.isCellBusy(0, 0));
        assertFalse(board.isCellBusy(1));

        board.setCell(0, 0, "X");
        assertTrue(board.isCellBusy(0, 0));
        assertTrue(board.isCellBusy(1));
    }
}
