package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.ui.UserInterfaceSpy;
import org.junit.Before;
import org.junit.Test;

import static com.mael.ttt.Mark.PLAYER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlienPlayerTest {

    private Board board;
    private UserInterfaceSpy uiSpy;
    private AlienPlayer alienPlayer;

    @Before
    public void setUp() {
        int size    = 3;
        board       = new Board (size);
        uiSpy       = new UserInterfaceSpy();
        alienPlayer = new AlienPlayer(uiSpy, PLAYER);
    }

    @Test
    public void printsPromptMessage() {
        alienPlayer.getMove(board);
        assertTrue(uiSpy.printAlienPromptWasCalled());
    }

    @Test
    public void getsAnExistingEmptyIndex() {
        int alienMove = alienPlayer.getMove(board);
        assertTrue(board.getEmptyCellIndexes().contains(alienMove));
    }

    @Test
    public void returnsMark() {
        assertEquals(PLAYER, alienPlayer.getMark());
    }
}
