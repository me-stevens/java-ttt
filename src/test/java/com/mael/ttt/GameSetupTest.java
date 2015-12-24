package com.mael.ttt;

import com.mael.ttt.players.PlayerCreator;
import com.mael.ttt.ui.UserInterfaceSpy;
import org.junit.Before;
import org.junit.Test;
import com.mael.ttt.ui.Menu;

import static org.junit.Assert.assertTrue;

public class GameSetupTest {

    private Board board;
    private UserInterfaceSpy uiSpy;
    private GameSetup gameSetup;

    @Before
    public void setUp() {
        int size  = 3;
        board     = new Board(size);
        uiSpy     = new UserInterfaceSpy();
        gameSetup = new GameSetup(uiSpy, new Menu(uiSpy), board, new Turn(board, new BoardChecker(board), uiSpy), new PlayerCreator(uiSpy));
        uiSpy.setUserOptions("1", "1");
    }

    @Test
    public void printsWelcomeMessage() {
        uiSpy.setUserInputs(1, 4, 2, 5, 3);
        uiSpy.setReplayAnswers(false);
        gameSetup.playGame();
        assertTrue(uiSpy.printWelcomeMessageWasCalled());
    }

    @Test
    public void replaysUntilNo() {
        uiSpy.setUserInputs(1, 4, 2, 5, 3,
                            1, 2, 3, 4, 5, 7, 6, 9, 8);
        uiSpy.setReplayAnswers(true, false);
        gameSetup.playGame();
        assertTrue(uiSpy.replayWasCalled());
    }
}
