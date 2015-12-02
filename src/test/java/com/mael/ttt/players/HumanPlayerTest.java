package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.SpyConsole;
import com.mael.ttt.UserInterface;
import com.mael.ttt.players.HumanPlayer;
import org.junit.Assert;
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
        size      = 3;
        board     = new Board(size);
        spy       = new SpyConsole();
        humanPlayer = new HumanPlayer(new UserInterface(spy), "X");
    }

    @Test
    public void repeatsUntilCellIsNumber() {
        spy.setInputs("a", "20", "1");
        Assert.assertEquals(1, humanPlayer.getCellIndex(board));
        assertEquals(3, spy.timesReadWasCalled());
    }

    @Test
    public void repeatsUntilItGetsEmptyCellIndex() {
        board.setCell(1, "X");
        spy.setInputs("1", "2");
        Assert.assertEquals(2, humanPlayer.getCellIndex(board));
        assertEquals(2, spy.timesReadWasCalled());
    }

    @Test
    public void returnsRightIndex() {
        spy.setInputs("2");
        Assert.assertEquals(2, humanPlayer.getCellIndex(board));
    }
}
