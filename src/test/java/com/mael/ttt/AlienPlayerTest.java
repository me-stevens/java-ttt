package com.mael.ttt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlienPlayerTest {

    private SpyConsole spy;
    private AlienPlayer alienPlayer;
    private Board board;

    @Before
    public void setUp() {
        spy         = new SpyConsole();
        alienPlayer = new AlienPlayer(new UserInterface(spy), "O");
        board       = new Board(3);
    }

    @Test
    public void printsPromptMessage() {
        alienPlayer.getCellIndex(board);
        Assert.assertEquals(UserInterface.ALIENPROMPT, spy.lastPrintedMessage());
    }

    @Test
    public void getsAnExistingEmptyIndex() {
        assertTrue(board.getEmptyCellIndexes().contains(alienPlayer.getCellIndex(board)));
    }
}
