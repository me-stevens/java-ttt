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
        assertTrue(spyConsole.writeMethodWasCalled());
    }

    @Test
    public void printsBoard1x1() {
        Board board = new Board(1);
        board.setCell(0, 0, "X");
        ui.printBoard(board);
        assertEquals("X \n", spyConsole.printedMessage());
    }

    @Test
    public void printsBoard2x2() {
        Board board = new Board(2);
        board.setCell(0, 0, "X");
        board.setCell(0, 1, "X");
        board.setCell(1, 0, "X");
        board.setCell(1, 1, "X");
        ui.printBoard(board);
        assertEquals("X X \nX X \n", spyConsole.printedMessage());
    }

    @Test
    public void printsCellNumberIfCellIsEmpty() {
        Board board = new Board(3);
        ui.printBoard(board);
        assertEquals("1 2 3 \n4 5 6 \n7 8 9 \n", spyConsole.printedMessage());
    }

    @Test
    public void readsUserInput() {
        spyConsole.setInput("hi");
        assertEquals("hi", ui.getInput("name"));
        assertTrue(spyConsole.readMethodWasCalled());
    }
}
