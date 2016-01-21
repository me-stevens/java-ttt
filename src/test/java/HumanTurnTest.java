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
        spy       = new SpyConsole();
        board     = new Board(size);
        humanTurn = new HumanTurn(board, new UserInterface(spy));
    }

    @Test
    public void repeatsUntilCellIsNumber() {
        spy.setInputs("a", "20", "1");
        assertEquals("1", humanTurn.returnValidCellIndex());
        assertEquals(3, spy.timesReadWasCalled());
    }

    @Test
    public void repeatsUntilEmptyCellIndex() {
        board.setCell(1, "X");
        spy.setInputs("1", "2");
        assertEquals("2", humanTurn.returnEmptyCellIndex("1"));
        assertEquals(2, spy.timesReadWasCalled());
    }

    @Test
    public void returnsRightIndex() {
        spy.setInputs("a", "20", "1", "2");
        board.setCell(1, "X");
        assertEquals(2, humanTurn.getCellIndex());
        assertEquals(4, spy.timesReadWasCalled());
    }

    @Test
    public void convertsStringIntoNumber() {
        assertEquals(1, humanTurn.stringToNumber("1"));
    }
}
