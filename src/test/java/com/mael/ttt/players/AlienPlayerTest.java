package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Before;
import org.junit.Test;

import static com.mael.ttt.Mark.PLAYER;
import static com.mael.ttt.players.PlayerType.ALIEN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AlienPlayerTest {

    private SpyConsole spy;
    private AlienPlayer alienPlayer;
    private Board board;

    @Before
    public void setUp() {
        spy         = new SpyConsole();
        alienPlayer = new AlienPlayer(new UserInterface(spy), PLAYER);
        board       = new Board(3);
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
