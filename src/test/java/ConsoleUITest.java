import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ConsoleUITest {

    private SpyConsole spyConsole;
    private ConsoleUI cui;

    @Before
    public void setUp() throws Exception {
        spyConsole = new SpyConsole();
        cui        = new ConsoleUI(spyConsole);
    }
    @Test
    public void anyMessageIsPrinted() {
        cui.print("hi");
        assertEquals("hi", spyConsole.printedMessage());
        assertTrue(spyConsole.writeMethodWasCalled());
    }

    @Test
    public void printsBoard1x1() {
        Board board = new Board(1);
        board.setCell(0, 0, "X");
        cui.printBoard(board);
        assertEquals("X \n", spyConsole.printedMessage());
    }

    @Test
    public void printsBoard2x2() {
        Board board = new Board(2);
        board.setCell(0, 0, "X");
        board.setCell(0, 1, "X");
        board.setCell(1, 0, "X");
        board.setCell(1, 1, "X");
        cui.printBoard(board);
        assertEquals("X X \nX X \n", spyConsole.printedMessage());
    }

    @Test
    public void printsCellNumberIfCellIsEmpty() {
        Board board = new Board(3);
        cui.printBoard(board);
        assertEquals("1 2 3 \n4 5 6 \n7 8 9 \n", spyConsole.printedMessage());
    }

    @Test
    public void readsUserInput() {
        spyConsole.setInput("hi");
        assertEquals("hi", cui.getInput());
        assertTrue(spyConsole.readMethodWasCalled());
    }

    @Test
    public void printsGameOver() {
        cui.printGameOverMessage();
        assertEquals(ConsoleUI.GAMEOVER, spyConsole.printedMessage());
    }
}
