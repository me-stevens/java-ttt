package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.ui.UserInterfaceSpy;
import org.junit.Before;
import org.junit.Test;

import static com.mael.ttt.Mark.PLAYER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HumanPlayerTest {

    private Board board;
    private UserInterfaceSpy uiSpy;
    private HumanPlayer humanPlayer;

    @Before
    public void setUp() {
        int size    = 3;
        board       = new Board(size);
        uiSpy       = new UserInterfaceSpy();
        humanPlayer = new HumanPlayer(uiSpy, PLAYER);
    }

    @Test
    public void repeatsUntilCellIsNumber() {
        uiSpy.setUserInputs("a", "20", "1");
        assertEquals(1, humanPlayer.getMove(board));
        assertEquals(3, uiSpy.timesGetInputWasCalled());
    }

    @Test
    public void repeatsUntilItGetsEmptyCellIndex() {
        board.setCell(1, PLAYER);
        uiSpy.setUserInputs(1, 2);
        assertEquals(2, humanPlayer.getMove(board));
        assertEquals(2, uiSpy.timesGetInputWasCalled());
    }

    @Test
    public void returnsRightIndex() {
        uiSpy.setUserInputs(1);
        assertEquals(1, humanPlayer.getMove(board));
    }

    @Test
    public void printsNotValidCellMessage() {
        uiSpy.setUserInputs("a", "1");
        humanPlayer.getMove(board);
        assertTrue(uiSpy.printNotValidCellMessageWasCalled());
    }
}
