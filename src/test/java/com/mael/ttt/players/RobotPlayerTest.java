package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotPlayerTest {

    private int size;
    private Board board;
    private RobotPlayer robotPlayer;
    private SpyConsole spy;

    @Before
    public void setUp() {
        size        = 3;
        spy         = new SpyConsole();
        robotPlayer = new RobotPlayer(new UserInterface(spy), "O");

    }

    @Test
    public void promptMessageIsPrinted() {
        board = new Board(size);
        robotPlayer.getCellIndex(board);
        Assert.assertEquals(UserInterface.ROBOTPROMT, spy.firstPrintedMessage());
    }

    @Test
    public void choosesWinningCombinationInARow() {
        board = setBoard("O", "O", "",
                         "X", "X", "",
                          "",  "", "");
        Assert.assertEquals(3, robotPlayer.getCellIndex(board));
    }

    @Test
    public void choosesWinningCombinationInAColumn() {
        board = setBoard("X", "O", "",
                         "X", "O", "",
                          "",  "", "");
        Assert.assertEquals(7, robotPlayer.getCellIndex(board));
    }

    @Test
    public void choosesWinningCombinationInDiagonal() {
        board = setBoard("O", "X", "X",
                         "X", "O", "X",
                         "X",  "", "");
        Assert.assertEquals(9, robotPlayer.getCellIndex(board));
    }

    @Test
    public void choosesWinningCombinationInAntiDiagonal() {
        board = setBoard("X", "X", "O",
                         "X", "O", "X",
                         "",  "", "X");
        Assert.assertEquals(7, robotPlayer.getCellIndex(board));
    }

    @Test
    public void blocksTheOpponentInARow() {
        board = setBoard("X", "X", "",
                          "", "O", "",
                          "",  "", "");
        Assert.assertEquals(3, robotPlayer.getCellIndex(board));
    }

    @Test
    public void blocksTheOpponentInAColumn() {
        board = setBoard("", "", "X",
                         "", "O", "",
                         "", "", "X");
        Assert.assertEquals(6, robotPlayer.getCellIndex(board));
    }

    @Test
    public void blocksTheOpponentInDiagonal() {
        board = setBoard("X", "", "",
                         "", "X", "",
                         "O", "", "");
        Assert.assertEquals(9, robotPlayer.getCellIndex(board));
    }

    @Test
    public void blocksTheOpponentInAntiDiagonal() {
        board = setBoard("",  "", "X",
                         "O", "", "",
                         "X", "", "");
        Assert.assertEquals(5, robotPlayer.getCellIndex(board));
    }

    private Board setBoard(String... cellContents) {
        board = new Board(size);
        for (int index = 1; index <= size*size; index++) {
            board.setCell(index, cellContents[index-1]);
        }
        return board;
    }
}
