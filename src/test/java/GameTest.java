import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;
    private SpyConsole spy;
    private int size;

    @Before
    public void setUp() {
        size   = 3;
        spy    = new SpyConsole();
        game   = new Game(new Board(size), new UserInterface(spy));
    }

    @Test
    public void repeatsUntilCellIsNumber() {
        spy.setInputs("a", "20", "1");
        assertEquals("1", game.returnValidCellIndex());
        assertEquals(3, spy.timesReadWasCalled());
    }

    @Test
    public void repeatsUntilEmptyCellIndex() {
        game.getBoard().setCell(1, "X");
        spy.setInputs("1", "2");
        assertEquals("2", game.returnEmptyCellIndex("1"));
        assertEquals(2, spy.timesReadWasCalled());
    }

    @Test
    public void humanTurnReturnsRightIndex() {
        spy.setInputs("a", "20", "1", "2");
        game.getBoard().setCell(1, "X");
        assertEquals(2, game.humanTurn());
        assertEquals(4, spy.timesReadWasCalled());
    }

    @Test
    public void convertsStringIntoNumber() {
        assertEquals(1, game.stringToNumber("1"));
    }

    @Test
    public void turnReturnsTrueIfNotWinOrFull() {
        spy.setInput("1");
        assertTrue(game.nextTurn());
    }

    @Test
    public void turnReturnsFalseIfWin() {
        spy.setInputs("1", "4", "2", "5", "3");
        playTurns(4);

        assertFalse(game.nextTurn());
    }

    @Test
    public void turnReturnsFalseIfFull() {
        spy.setInputs("1", "2", "3", "4", "5", "6", "8", "7", "9");
        playTurns(size*size - 1);

        assertFalse(game.nextTurn());
    }

    @Test
    public void markIsSwappedInEveryTurn() {
        spy.setInputs("1", "2", "3");
        playTurns(3);

        assertEquals("X", game.getBoard().getCell(1));
        assertEquals("O", game.getBoard().getCell(2));
        assertEquals("X", game.getBoard().getCell(3));
    }

    @Test
    public void startsAndEndsTheGameIfWin() {
        spy.setInputs("1", "4", "2", "5", "3");
        game.start();
        assertEquals(UserInterface.GAMEOVER, spy.lastPrintedMessage());
    }

    @Test
    public void startsAndEndsTheGameIfFull() {
        spy.setInputs("1", "2", "3", "4", "5", "6", "8", "7", "9");
        game.start();
        assertEquals(UserInterface.GAMEOVER, spy.lastPrintedMessage());
    }

    @Test
    public void replaysGameUntilNo() {
        spy.setInputs("1", "4", "2", "5", "3", "y", "1", "4", "2", "5", "3", "n");
        game.run();
        assertEquals(UserInterface.REPLAY, spy.lastPrintedMessage());
    }

    private void playTurns(int times) {
        for (int i = 0; i < times; i++) {
            game.nextTurn();
        }
    }
}
