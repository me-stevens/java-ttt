package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.Mark;
import com.mael.ttt.ui.UserInterfaceSpy;
import org.junit.Before;
import org.junit.Test;

import static com.mael.ttt.Mark.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RobotPlayerTest {

    private Board board;
    private UserInterfaceSpy uiSpy;
    private RobotPlayer robotPlayer;
    private Mark X, O, E;

    @Before
    public void setUp() {
        uiSpy       = new UserInterfaceSpy();
        robotPlayer = new RobotPlayer(uiSpy, OPPONENT);
        X           = PLAYER;
        O           = OPPONENT;
        E           = EMPTY;
    }

    @Test
    public void promptMessageIsPrinted() {
        board = new Board(X, O, X,
                          X, O, X,
                          O, X, E);
        robotPlayer.getMove(board);
        assertTrue(uiSpy.printRobotPromptWasCalled());
    }

    @Test
    public void choosesWinningCombinationInARow() {
        board = new Board(O, O, E,
                          X, X, E,
                          E, E, E);
        assertEquals(3, robotPlayer.getMove(board));
    }

    @Test
    public void choosesWinningCombinationInAColumn() {
        board = new Board(O, X, E,
                          O, X, E,
                          E, E, E);
        assertEquals(7, robotPlayer.getMove(board));
    }

    @Test
    public void choosesWinningCombinationInDiagonal() {
        board = new Board(O, X, X,
                          X, O, E,
                          E, E, E);
        assertEquals(9, robotPlayer.getMove(board));
    }

    @Test
    public void choosesWinningCombinationInAntiDiagonal() {
        board = new Board(X, X, O,
                          E, O, X,
                          E, E, E);
        assertEquals(7, robotPlayer.getMove(board));
    }

    @Test
    public void blocksTheOpponentInARow() {
        board = new Board(X, X, E,
                          E, O, E,
                          E, E, E);
        assertEquals(3, robotPlayer.getMove(board));
    }

    @Test
    public void blocksTheOpponentInAColumn() {
        board = new Board(E, E, X,
                          E, O, E,
                          E, E, X);
        assertEquals(6, robotPlayer.getMove(board));
    }

    @Test
    public void blocksTheOpponentInDiagonal() {
        board = new Board(X, E, E,
                          E, X, E,
                          O, E, E);
        assertEquals(9, robotPlayer.getMove(board));
    }

    @Test
    public void blocksTheOpponentInAntiDiagonal() {
        board = new Board(E, E, X,
                          O, E, E,
                          X, E, E);
        assertEquals(5, robotPlayer.getMove(board));
    }

    @Test
    public void returnsMark() {
        assertEquals(OPPONENT, robotPlayer.getMark());
    }
}
