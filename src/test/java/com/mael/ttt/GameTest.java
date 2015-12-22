package com.mael.ttt;

import com.mael.ttt.players.FakePlayer;
import com.mael.ttt.ui.UserInterfaceSpy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static com.mael.ttt.Mark.*;
import static org.junit.Assert.assertTrue;

public class GameTest {

    private Board board;
    private Game game;
    private UserInterfaceSpy uiSpy;

    @Before
    public void setUp() {
        board = new Board(3);
        uiSpy = new UserInterfaceSpy();
    }

    @Test
    public void endsTheGameIfWin() {
        game = new Game(new Turn(board, new BoardChecker(board), uiSpy),
                new FakePlayer(PLAYER, 1, 2, 3),
                new FakePlayer(OPPONENT, 4, 5));
        game.play();
        assertTrue(uiSpy.printHasWinnerMessageWasCalled());
    }

    @Test
    public void endsTheGameIfFull() {
        game = new Game(new Turn(board, new BoardChecker(board), uiSpy),
                new FakePlayer(PLAYER, 1, 2, 5, 6, 7),
                new FakePlayer(OPPONENT, 4, 3, 9, 8));
        game.play();
        assertTrue(uiSpy.printIsFullMessageWasCalled());
    }

    @Test
    public void playerIsSwappedInEveryTurn() {
        game = new Game(new Turn(board, new BoardChecker(board), uiSpy),
                new FakePlayer(PLAYER, 1, 3, 5, 7),
                new FakePlayer(OPPONENT, 2, 4, 6));
        game.play();

        assertEquals(PLAYER,   board.getCell(1));
        assertEquals(OPPONENT, board.getCell(2));
        assertEquals(PLAYER,   board.getCell(3));
    }
}