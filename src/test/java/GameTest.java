import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void convertsStringIntoNumber() {
        assertEquals(1, game.stringToNumber("1"));
    }

    @Test
    public void getsRowFromCellIndex() {
        assertEquals(1 / game.getBoard().getSize(), game.getRowFromIndex(1));
    }

    @Test
    public void getsColFromCellIndex() {
        assertEquals(1 % game.getBoard().getSize(), game.getColFromIndex(1));
    }

    @Test
    public void getsMark() {
        assertEquals("X", game.getMark(true));
        assertEquals("O", game.getMark(false));
    }

    @Test
    public void updatesBoard() {
        game.updateBoard(0, 0, "X");
        assertEquals("X", game.getBoard().getCell(0, 0));
    }

}
