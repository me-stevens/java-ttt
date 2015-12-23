package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.mael.ttt.Mark.PLAYER;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class HumanPlayerTest {

    private int size;
    private Board board;
    private SpyConsole spy;
    private HumanPlayer humanPlayer;

    public HumanPlayerTest(int boardSize) {
        size        = boardSize;
        board       = new Board(size);
        spy         = new SpyConsole();
        humanPlayer = new HumanPlayer(new UserInterface(spy), PLAYER);
    }

    @Parameterized.Parameters
    public static Collection dataSetup() {
        return Arrays.asList(new Object[][]{ {3}, {4} });
    }

    @Test
    public void repeatsUntilCellIsNumber() {
        spy.setInputs("a", "20", "1");
        assertEquals(1, humanPlayer.getMove(board));
        assertEquals(3, spy.timesReadWasCalled());
    }

    @Test
    public void repeatsUntilItGetsEmptyCellIndex() {
        board.setCell(1, PLAYER);
        spy.setInputs("1", "2");
        assertEquals(2, humanPlayer.getMove(board));
        assertEquals(2, spy.timesReadWasCalled());
    }

    @Test
    public void returnsRightIndex() {
        spy.setInputs("1");
        assertEquals(1, humanPlayer.getMove(board));
    }

    @Test
    public void printsNotValidCellMessage() {
        spy.setInputs("a", "1");
        humanPlayer.getMove(board);
        assertTrue(spy.printedMessage().contains(UserInterface.NOTVALIDCELL));
    }

    @Test
    public void printsCellIsBusyMessage() {
        board.setCell(1, PLAYER);
        spy.setInputs("1", "2");
        humanPlayer.getMove(board);
        assertTrue(spy.printedMessage().contains(UserInterface.CELLISBUSY));
    }
}
