package com.mael.ttt;

import com.mael.ttt.players.AlienPlayer;
import com.mael.ttt.players.HumanPlayer;
import com.mael.ttt.players.RobotPlayer;
import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Before;
import org.junit.Test;

import static com.mael.ttt.Mark.PLAYER;
import static com.mael.ttt.players.PlayerType.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameSetupTest {

    private SpyConsole spy;
    private GameSetup gameSetup;
    private UserInterface gameUI;

    @Before
    public void setUp() {
        int size  = 3;
        spy       = new SpyConsole();
        gameUI    = new UserInterface(spy);
        gameSetup = new GameSetup(new Board(size), gameUI);
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

    @Test
    public void createsAHuman() {
        assertTrue(gameSetup.createPlayerOfType(HUMAN, PLAYER) instanceof HumanPlayer);
    }

    @Test
    public void createsARobot() {
        assertTrue(gameSetup.createPlayerOfType(ROBOT, PLAYER) instanceof RobotPlayer);
    }

    @Test
    public void createsAnAlien() {
        assertTrue(gameSetup.createPlayerOfType(ALIEN, PLAYER) instanceof AlienPlayer);
    }
}
