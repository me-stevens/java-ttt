import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
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

    }

}
