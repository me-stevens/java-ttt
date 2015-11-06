import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BoardCheckerTest {

    int size;
    private Board board;
    private BoardChecker checker;

    @Before
    public void setUp() {
        size    = 3;
        board   = new Board(size);
        checker = new BoardChecker(board);
    }

    @Test
    public void checksWinnerInRow() {
        assertFalse(checker.checkWinnerInRow(1, "X"));

        for (int j = 0; j < size; j++) {
            board.setCell(1, j, "X");
        }

        assertTrue(checker.checkWinnerInRow(1, "X"));
    }

    @Test
    public void checksWinnerInColumn() {
        assertFalse(checker.checkWinnerInColumn(1, "X"));

        for (int i = 0; i < size; i++) {
            board.setCell(i, 1, "X");
        }

        assertTrue(checker.checkWinnerInColumn(1, "X"));
    }

    @Test
    public void checksWinnerInDiagonal() {
        assertFalse(checker.checkWinnerInDiagonal("X"));

        for (int i = 0, j = 0; i < size && j < size; i++, j++) {
            board.setCell(i, j, "X");
        }

        assertTrue(checker.checkWinnerInDiagonal("X"));
    }

    @Test
    public void checksWinnerInAntiDiagonal() {
        assertFalse(checker.checkWinnerInAntiDiagonal("X"));

        for (int i = 0, j = size-1; i < size && j >= 0; i++, j--) {
            board.setCell(i, j, "X");
        }

        assertTrue(checker.checkWinnerInAntiDiagonal("X"));
    }

    @Test
    public void checksWinner() {
        assertFalse(checker.hasWinner("X"));

        for (int i = 0; i < size; i++) {
            board.setCell(i, 1, "X");
        }

        assertTrue(checker.hasWinner("X"));
    }
}
