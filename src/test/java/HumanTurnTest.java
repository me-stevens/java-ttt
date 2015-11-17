import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanTurnTest {

    private HumanTurn humanTurn;
    private SpyConsole spy;
    private int size;
    private Board board;

    @Before
    public void setUp() {
        size      = 3;
        board     = new Board(size);
        spy       = new SpyConsole();
        humanTurn = new HumanTurn(board, new UserInterface(spy), "X");
    }

    @Test
    public void repeatsUntilCellIsNumber() {
        spy.setInputs("a", "20", "1");
        assertEquals(1, humanTurn.getCellIndex());
        assertEquals(3, spy.timesReadWasCalled());
    }

    @Test
    public void repeatsUntilItGetsEmptyCellIndex() {
        board.setCell(1, "X");
        spy.setInputs("1", "2");
        assertEquals(2, humanTurn.getCellIndex());
        assertEquals(2, spy.timesReadWasCalled());
    }

    @Test
    public void returnsRightIndex() {
        spy.setInputs("2");
        assertEquals(2, humanTurn.getCellIndex());
    }
}
