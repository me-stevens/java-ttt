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
    public void thereIsNoWinnerIfEmptyBoard() {
        assertFalse(checker.hasWinner("X"));
        assertFalse(checker.hasWinner("O"));
    }

    @Test
    public void checksWinnerInRow() {
        for (int col = 0; col < size; col++) {
            board.setCell(board.getIndexFromCoords(0, col), "X");
        }

        assertTrue(checker.hasWinner("X"));
    }

    @Test
    public void checksWinnerInColumn() {
        for (int row = 0; row < size; row++) {
            board.setCell(board.getIndexFromCoords(row, 0), "X");
        }

        assertTrue(checker.hasWinner("X"));
    }

    @Test
    public void checksWinnerInDiagonal() {
        for (int row = 0, col = 0; row < size && col < size; row++, col++) {
            board.setCell(board.getIndexFromCoords(row, col), "X");
        }

        assertTrue(checker.hasWinner("X"));
    }

    @Test
    public void checksWinnerInAntiDiagonal() {
        for (int row = 0, col = size-1; row < size && col >= 0; row++, col--) {
            board.setCell(board.getIndexFromCoords(row, col), "X");
        }

        assertTrue(checker.hasWinner("X"));
    }
}
