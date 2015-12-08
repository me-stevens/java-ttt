package com.mael.ttt;

import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameSetupTest {

    private SpyConsole spy;
    private GameSetup gameSetup;

    @Before
    public void setUp() {
        spy       = new SpyConsole();
        gameSetup = new GameSetup(new UserInterface(spy));
    }

    @Test
    public void printsWelcomeMessage() {
        gameSetup.setUp();
        assertEquals(UserInterface.WELCOME, spy.printedMessage());
    }

    @Test
    public void replaysUntilNo() {
        spy.setInputs("1",
                      "1", "4", "2", "5", "3",
                      "y",
                      "1",
                      "1", "4", "2", "5", "3",
                      "n");
        gameSetup.playGame();
        assertEquals(UserInterface.REPLAY, spy.lastPrintedMessage());
    }
}
