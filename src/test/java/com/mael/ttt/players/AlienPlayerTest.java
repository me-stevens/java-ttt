package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Before;
import org.junit.Test;

import static com.mael.ttt.Mark.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlienPlayerTest {

    private SpyConsole spy;
    private AlienPlayer alienPlayer;
    private Board board;
    private int size;

    @Before
    public void setUp() {
        size        = 3;
        spy         = new SpyConsole();
        alienPlayer = new AlienPlayer(new UserInterface(spy), PLAYER);
        board       = new Board(size);
    }

    @Test
    public void printsPromptMessage() {
        alienPlayer.getMove(board);
        assertEquals(UserInterface.ALIENPROMPT, spy.lastPrintedMessage());
    }

    @Test
    public void getsAnExistingEmptyIndex() {
        assertTrue(board.getEmptyCellIndexes().contains(alienPlayer.getMove(board)));
    }

    @Test
    public void returnsMark() {
        assertEquals(PLAYER, alienPlayer.getMark());
    }
}
