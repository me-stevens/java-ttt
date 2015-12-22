package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.Mark;
import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Before;
import org.junit.Test;

import static com.mael.ttt.Mark.*;
import static org.junit.Assert.assertEquals;

public class RobotPlayerTest {

    private int size;
    private Board board;
    private RobotPlayer robotPlayer;
    private SpyConsole spy;
    private Mark X, O, E;

    @Before
    public void setUp() {
        size        = 3;
        board       = new Board(size);
        spy         = new SpyConsole();
        robotPlayer = new RobotPlayer(new UserInterface(spy), OPPONENT);
        X           = PLAYER;
        O           = OPPONENT;
        E           = EMPTY;
    }

    @Test
    public void promptMessageIsPrinted() {
        board = new Board(size);
        robotPlayer.getMove(board);
        assertEquals(UserInterface.ROBOTPROMT, spy.firstPrintedMessage());
    }

    @Test
    public void choosesWinningCombinationInARow() {
        board.setBoardContents( O, O, E,
                                X, X, E,
                                E, E, E);
        assertEquals(3, robotPlayer.getMove(board));
    }

    @Test
    public void choosesWinningCombinationInAColumn() {
        board.setBoardContents( X, O, E,
                                X, O, E,
                                E, E, E);
        assertEquals(7, robotPlayer.getMove(board));
    }

    @Test
    public void choosesWinningCombinationInDiagonal() {
        board.setBoardContents(O, X, X,
                               X, O, X,
                               X, E, E);
        assertEquals(9, robotPlayer.getMove(board));
    }

    @Test
    public void choosesWinningCombinationInAntiDiagonal() {
        board.setBoardContents(X, X, O,
                               X, O, X,
                               E, E, X);
        assertEquals(7, robotPlayer.getMove(board));
    }

    @Test
    public void blocksTheOpponentInARow() {
        board.setBoardContents(X, X, E,
                               E, O, E,
                               E, E, E);
        assertEquals(3, robotPlayer.getMove(board));
    }

    @Test
    public void blocksTheOpponentInAColumn() {
        board.setBoardContents(E, E, X,
                               E, O, E,
                               E, E, X);
        assertEquals(6, robotPlayer.getMove(board));
    }

    @Test
    public void blocksTheOpponentInDiagonal() {
        board.setBoardContents(X, E, E,
                               E, X, E,
                               O, E, E);
        assertEquals(9, robotPlayer.getMove(board));
    }

    @Test
    public void blocksTheOpponentInAntiDiagonal() {
        board.setBoardContents(E, E, X,
                               O, E, E,
                               X, E, E);
        assertEquals(5, robotPlayer.getMove(board));
    }

    @Test
    public void returnsMark() {
        assertEquals(OPPONENT, robotPlayer.getMark());
    }
}
