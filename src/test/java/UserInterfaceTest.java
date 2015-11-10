import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserInterfaceTest {

    private SpyConsole spyConsole;
    private UserInterface ui;

    @Before
    public void setUp() {
        spyConsole = new SpyConsole();
        ui = new UserInterface(spyConsole);
    }

    @Test
    public void anyMessageIsPrinted() {
        ui.print("hi");
        assertEquals("hi", spyConsole.printedMessage());
    }

    @Test
    public void printsCellNumberIfCellIsEmpty() {
        Board board = new Board(3);
        ui.printBoard(board);
        assertEquals("1 2 3 \n4 5 6 \n7 8 9 \n", spyConsole.printedMessage());
    }

    @Test
    public void promptsTheUserForInput() {
        spyConsole.setInput("");
        ui.getInput();
        assertEquals(ui.PROMPT, spyConsole.lastPrintedMessage());
    }

    @Test
    public void readsUserInput() {
        spyConsole.setInput("hi");
        assertEquals("hi", ui.getInput());
        assertTrue(spyConsole.readMethodWasCalled());
    }

    @Test
    public void printsWinnerMessage() {
        ui.printHasWinnerMessage("foo");
        assertEquals(UserInterface.HASWINNER + "foo", spyConsole.firstPrintedMessage());
        assertEquals(UserInterface.GAMEOVER, spyConsole.lastPrintedMessage());
    }

    @Test
    public void printsIsFullMessage() {
        ui.printIsFullMessage();
        assertEquals(UserInterface.ISFULL,   spyConsole.firstPrintedMessage());
        assertEquals(UserInterface.GAMEOVER, spyConsole.lastPrintedMessage());
    }

    @Test
    public void printsReplayMessage() {
        spyConsole.setInput("");
        ui.replay();
        assertEquals(ui.REPLAY, spyConsole.lastPrintedMessage());
    }

    @Test
    public void readsReplayAnswer() {
        spyConsole.setInput("y");
        assertEquals("y", ui.replay());
        assertTrue(spyConsole.readMethodWasCalled());
    }
}
