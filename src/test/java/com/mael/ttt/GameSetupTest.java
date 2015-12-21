package com.mael.ttt;

import com.mael.ttt.players.PlayerCreator;
import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Before;
import org.junit.Test;
import com.mael.ttt.ui.Menu;

import static org.junit.Assert.assertEquals;

public class GameSetupTest {

    private int size;
    private SpyConsole spy;
    private GameSetup gameSetup;
    private UserInterface gameUI;
    private Board board;

    @Before
    public void setUp() {
        size      = 3;
        spy       = new SpyConsole();
        gameUI    = new UserInterface(spy);
        board     = new Board(size);
        gameSetup = new GameSetup(gameUI, new Menu(gameUI), board, new Turn(board, new BoardChecker(board), gameUI), new PlayerCreator(gameUI));
    }

    @Test
    public void printsWelcomeMessage() {
        spy.setInputs("1",
                      "1", "4", "2", "5", "3",
                      "n");
        gameSetup.playGame();
        assertEquals(UserInterface.WELCOME, spy.firstPrintedMessage());
    }

    @Test
    public void replaysUntilNo() {
        spy.setInputs("1",
                      "1", "4", "2", "5", "3",
                      "y",
                      "1",
                      "1", "2", "3", "4", "5", "7", "6", "9", "8",
                      "n");
        gameSetup.playGame();
        assertEquals(UserInterface.REPLAY, spy.lastPrintedMessage());
    }
}
