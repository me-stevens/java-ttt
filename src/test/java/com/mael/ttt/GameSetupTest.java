package com.mael.ttt;

import com.mael.ttt.players.PlayerCreator;
import com.mael.ttt.ui.PlayersMenu;
import com.mael.ttt.ui.UserInterfaceSpy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GameSetupTest {

    private UserInterfaceSpy uiSpy;
    private Board board;
    private GameSetup gameSetup;
    private PlayersMenu menu;
    private Turn turn;
    private PlayerCreator playerCreator;

    @Before
    public void setUp() {
        int size      = 3;
        uiSpy         = new UserInterfaceSpy();
        board         = new Board(size);
        gameSetup     = new GameSetup(uiSpy, board);
        menu          = new PlayersMenu(uiSpy);
        turn          = new Turn(uiSpy, board, new BoardChecker(board));
        playerCreator = new PlayerCreator(uiSpy);
        uiSpy.setUserOptions("1", "1");
    }

    @Test
    public void printsWelcomeMessage() {
        uiSpy.setUserInputs(1, 4, 2, 5, 3);
        uiSpy.setReplayAnswers(false);
        gameSetup.playGame(menu, turn, playerCreator);
        assertTrue(uiSpy.printWelcomeMessageWasCalled());
    }

    @Test
    public void replaysUntilNo() {
        uiSpy.setUserInputs(1, 4, 2, 5, 3,
                            1, 2, 3, 4, 5, 7, 6, 9, 8);
        uiSpy.setReplayAnswers(true, false);
        gameSetup.playGame(menu, turn, playerCreator);
        assertTrue(uiSpy.replayWasCalled());
    }
}
