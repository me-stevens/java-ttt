package com.mael.ttt.ui;

import com.mael.ttt.Board;
import com.mael.ttt.Mark;
import org.junit.Before;
import org.junit.Test;

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
        assertEquals("1) Human vs. Human\n" +
                     "2) Human vs. Robot\n" +
                     "3) Robot vs. Robot\n" +
                     "4) Human vs. Alien\n", ui.formatMenuOptions());
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
        assertEquals(UserInterface.HASWINNER + "X", spy.firstPrintedMessage());
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
}
