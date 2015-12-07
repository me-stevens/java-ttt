package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.Marks;
import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {

    private HumanPlayer humanPlayer;
    private SpyConsole spy;
    private int size;
    private Board board;

    @Before
    public void setUp() {
        size        = 3;
        board       = new Board(size);
        spy         = new SpyConsole();
        humanPlayer = new HumanPlayer(new UserInterface(spy));
    }

    @Test
    public void repeatsUntilCellIsNumber() {
        spy.setInputs("a", "20", "1");
        assertEquals(1, humanPlayer.getCellIndex(board));
        assertEquals(3, spy.timesReadWasCalled());
    }

    @Test
    public void repeatsUntilItGetsEmptyCellIndex() {
        board.setCell(1, Marks.PLAYER.toString());
        spy.setInputs("1", "2");
        assertEquals(2, humanPlayer.getCellIndex(board));
        assertEquals(2, spy.timesReadWasCalled());
    }

    @Test
    public void returnsRightIndex() {
        spy.setInputs("2");
        assertEquals(2, humanPlayer.getCellIndex(board));
    }
}
