import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;
    private ConsoleUI gameUI;
    private SpyConsole spy;
    private int size;

    @Before
    public void setUp() {
        size   = 3;
        spy    = new SpyConsole();
        gameUI = new ConsoleUI(spy);
        game   = new Game(new Board(size), gameUI);
    }

    @Test
    public void repeatsUntilCellIsNumber() {
        spy.setInputs("a", "20", "1");
        assertEquals("1", game.returnValidCellIndex());
        assertEquals(3, spy.timesReadWasCalled());
    }

    @Test
    public void repeatsUntilEmptyCellIndex() {
        game.getBoard().setCell(0, 0, "X");
        spy.setInputs("1", "2");
        assertEquals("2", game.returnEmptyCellIndex("1"));
        assertEquals(2, spy.timesReadWasCalled());
    }


    @Test
    public void humanTurnReturnsRightIndex() {
        spy.setInputs("a", "20", "1", "2");
        game.getBoard().setCell(0, 0, "X");
        assertEquals(2, game.humanTurn());
        assertEquals(4, spy.timesReadWasCalled());
    }

    @Test
    public void convertsStringIntoNumber() {
        assertEquals(1, game.stringToNumber("1"));
    }

    @Test
    public void getsMark() {
        assertEquals("X", game.getMark(true));
        assertEquals("O", game.getMark(false));
    }

    @Test
    public void updatesBoard() {
        game.updateBoard(1, "X");
        assertEquals("X", game.getBoard().getCell(0, 0));
    }

    @Test
    public void turnReturnsTrueIfNotWinOrFull() {
        spy.setInput("1");
        assertTrue(game.nextTurn());
    }

    @Test
    public void turnReturnsFalseIfWin() {
        spy.setInputs("1", "4", "2", "5", "3");
        for (int i = 0; i < 4; i++) {
            game.nextTurn();
        }

        assertFalse(game.nextTurn());
    }

    @Test
    public void turnReturnsFalseIfFull() {
        spy.setInputs("1", "2", "3", "4", "5", "6", "7", "8", "9");
        for (int i = 1; i < size*size; i++) {
            game.nextTurn();
        }

        assertFalse(game.nextTurn());
    }

    @Test
    public void markIsSwappedInEveryTurn() {
        spy.setInputs("1", "2", "3");
        for (int i = 0; i < 3; i++) {
            game.nextTurn();
        }

        assertEquals("X O X \n4 5 6 \n7 8 9 \n", gameUI.printBoard(game.getBoard()));
    }
}
