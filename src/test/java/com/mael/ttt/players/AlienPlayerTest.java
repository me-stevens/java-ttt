package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.ui.UserInterfaceSpy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.mael.ttt.Mark.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class AlienPlayerTest {

    private int size;
    private Board board;
    private UserInterfaceSpy uiSpy;
    private AlienPlayer alienPlayer;

    public AlienPlayerTest(int boardSize) {
        size        = boardSize;
        board       = new Board(size);
        uiSpy       = new UserInterfaceSpy();
        alienPlayer = new AlienPlayer(uiSpy, PLAYER);
    }

    @Parameterized.Parameters
    public static Collection dataSetup() {
        return Arrays.asList(new Object[][]{ {3}, {4} });
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
