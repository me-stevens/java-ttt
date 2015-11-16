import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserInterfaceTest {

    private SpyConsole spy;
    private UserInterface ui;

    @Before
    public void setUp() {
        spy = new SpyConsole();
        ui  = new UserInterface(spy);
    }

    @Test
    public void anyMessageIsPrinted() {
        ui.print("hi");
        assertEquals("hi", spy.printedMessage());
    }

    @Test
    public void printsCellNumberIfCellIsEmpty() {
        Board board = new Board(3);
        ui.printBoard(board);
        assertEquals("1 2 3 \n4 5 6 \n7 8 9 \n", spy.printedMessage());
    }

    @Test
    public void printsMenu() {
        spy.setInput("");
        ui.printPlayersMenu();
        assertEquals(ui.PLAYERSMENU, spy.lastPrintedMessage());
    }

    @Test
    public void choosesTwoHumansFromMenu() {
        spy.setInput("1");
        assertEquals("1", ui.printPlayersMenu());
        assertTrue(spy.readMethodWasCalled());
    }

    @Test
    public void promptsTheUserForInput() {
        spy.setInput("");
        ui.getInput();
        assertEquals(ui.PROMPT, spy.lastPrintedMessage());
    }

    @Test
    public void readsUserInput() {
        spy.setInput("hi");
        assertEquals("hi", ui.getInput());
        assertTrue(spy.readMethodWasCalled());
    }

    @Test
    public void printsWinnerMessage() {
        ui.printHasWinnerMessage("foo");
        assertEquals(UserInterface.HASWINNER + "foo", spy.firstPrintedMessage());
        assertEquals(UserInterface.GAMEOVER, spy.lastPrintedMessage());
    }

    @Test
    public void printsIsFullMessage() {
        ui.printIsFullMessage();
        assertEquals(UserInterface.ISFULL, spy.firstPrintedMessage());
        assertEquals(UserInterface.GAMEOVER, spy.lastPrintedMessage());
    }

    @Test
    public void printsReplayMessage() {
        spy.setInput("");
        ui.replay();
        assertEquals(ui.REPLAY, spy.lastPrintedMessage());
    }

    @Test
    public void readsReplayAnswer() {
        spy.setInput("y");
        assertEquals("y", ui.replay());
        assertTrue(spy.readMethodWasCalled());
    }
}
