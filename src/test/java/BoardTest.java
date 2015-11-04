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

    @Test (expected = IndexOutOfBoundsException.class)
    public void ifSetCellAtPositionBiggerThanSizeThrowsException() {
        board.setCell(1000, 1000, "X");
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void ifGetCellAtPositionBiggerThanSizeThrowsException() {
        board.getCell(1000, 1000);
    }

    @Test (expected = NullPointerException.class)
    public void ifSetCellWithNullThrowsException() {
        board.setCell(1, 1, null);
    }

    @Test
    public void getsCellContent() {
        board.setCell(1, 1, "X");
        assertEquals("X", board.getCell(1, 1));
    }

    @Test
    public void resetsBoard() {
        board.setCell(1, 1, "asdf");
        board.reset();

        for (String[] row: board.copy())
            assertArrayEquals(new String[]{"", "", ""}, row);
    }

    @Test
    public void getsTheSize() {
        assertEquals(size, board.getSize());
    }

    //--------------------------------

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
    public void checksWinnerInRow() {
        assertFalse(board.checkWinnerInRow(1));

        for (int j = 0; j < size; j++) {
            board.setCell(1, j, "X");
        }

        assertTrue(board.checkWinnerInRow(1));
    }

    @Test
    public void checksWinnerInColumn() {
        assertFalse(board.checkWinnerInColumn(1));

        for (int i = 0; i < size; i++) {
            board.setCell(i, 1, "X");
        }

        assertTrue(board.checkWinnerInColumn(1));
    }

    @Test
    public void checksWinnerInDiagonal() {
        assertFalse(board.checkWinnerInDiagonal());

        for (int i = 0, j = 0; i < size && j < size; i++, j++) {
            board.setCell(i, j, "X");
        }

        assertTrue(board.checkWinnerInDiagonal());
    }

    @Test
    public void checksWinnerInAntiDiagonal() {
        assertFalse(board.checkWinnerInAntiDiagonal());

        for (int i = 0, j = size-1; i < size && j >= 0; i++, j--) {
            board.setCell(i, j, "X");
        }

        assertTrue(board.checkWinnerInAntiDiagonal());
    }

    @Test
    public void checksWinner() {
        assertFalse(board.hasWinner());

        for (int i = 0; i < size; i++) {
            board.setCell(i, 1, "X");
        }

        assertTrue(board.hasWinner());
    }
}
