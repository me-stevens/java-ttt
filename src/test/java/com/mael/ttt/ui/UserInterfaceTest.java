package com.mael.ttt.ui;

import com.mael.ttt.Board;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.mael.ttt.Mark.*;
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
    public void formatsMenuOptions() {
        Map<String, String> options = new HashMap<>();
        options.put("a", "a value");
        options.put("b", "b value");

        assertEquals("a) a value\n" +
                     "b) b value\n", ui.formatMenuOptions(options));
    }

    @Test
    public void printsCellNumberIfCellIsEmpty() {
        Board board = new Board(3);
        ui.printBoard(board);
        assertEquals("1 2 3 \n4 5 6 \n7 8 9 \n", spy.printedMessage());
    }

    @Test
    public void printsMenu() {
        spy.setInput("1");
        ui.getMenuOption("menu");
        assertEquals("menu", spy.lastPrintedMessage());
    }

    @Test
    public void getsOptionFromMenu() {
        spy.setInput("1");
        assertEquals("1", ui.getMenuOption("menu"));
        assertTrue(spy.readMethodWasCalled());
    }

    @Test
    public void promptsTheUserForInput() {
        spy.setInput("");
        ui.getInput();
        assertEquals(ui.HUMANPROMPT, spy.lastPrintedMessage());
    }

    @Test
    public void readsUserInput() {
        spy.setInput("hi");
        assertEquals("hi", ui.getInput());
        assertTrue(spy.readMethodWasCalled());
    }

    @Test
    public void printsWinnerMessage() {
        ui.printHasWinnerMessage(PLAYER);
        assertEquals(UserInterface.HASWINNER + PLAYER.getString(), spy.firstPrintedMessage());
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
        assertTrue(ui.replay());
        assertTrue(spy.readMethodWasCalled());
    }

    @Test
    public void getsTheBoardIndexesAsString() {
        int size = 3;
        assertEquals(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"),
                     ui.getBoardIndexesAsStrings(size));
    }
}
