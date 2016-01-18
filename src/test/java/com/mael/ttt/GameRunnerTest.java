package com.mael.ttt;

import com.mael.ttt.players.PlayerCreator;
import com.mael.ttt.ui.Menu;
import com.mael.ttt.ui.UserInterfaceSpy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameRunnerTest {

    private UserInterfaceSpy uiSpy;
    private GameRunner gameSetup;
    private Menu menu;
    private PlayerCreator playerCreator;

    @Before
    public void setUp() {
        uiSpy         = new UserInterfaceSpy();
        gameSetup     = new GameRunner(uiSpy);
        menu          = new Menu(uiSpy);
        playerCreator = new PlayerCreator(uiSpy);
        uiSpy.setUserOptions("1", "3", "1", "3");
    }

    @Test
    public void printsWelcomeMessage() {
        uiSpy.setUserInputs(1, 4, 2, 5, 3);
        uiSpy.setReplayAnswers(false);
        gameSetup.playGame(menu, playerCreator);
        assertTrue(uiSpy.printWelcomeMessageWasCalled());
    }

    @Test
    public void replaysUntilNo() {
        uiSpy.setUserInputs(1, 4, 2, 5, 3,
                            1, 2, 3, 4, 5, 7, 6, 9, 8);
        uiSpy.setReplayAnswers(true, false);
        gameSetup.playGame(menu, playerCreator);
        assertTrue(uiSpy.replayWasCalled());
    }
}
