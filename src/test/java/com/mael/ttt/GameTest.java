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
        game.start();
        assertTrue(uiSpy.printHasWinnerMessageHasBeenCalled());
    }

    @Test
    public void endsTheGameIfFull() {
        UserInterfaceSpy uiSpy = new UserInterfaceSpy();
        game = new Game(new Turn(board, new BoardChecker(board), uiSpy),
                new FakePlayer(PLAYER, 1, 2, 5, 6, 7),
                new FakePlayer(OPPONENT, 4, 3, 9, 8));
        game.start();
        assertTrue(uiSpy.printIsFullMessageHasBeenCalled());
    }

    @Test
    public void markIsSwappedInEveryTurn() {
        UserInterfaceSpy uiSpy = new UserInterfaceSpy();
        game = new Game(new Turn(board, new BoardChecker(board), uiSpy),
                new FakePlayer(PLAYER, 1, 3, 5, 7),
                new FakePlayer(OPPONENT, 2, 4, 6));
        game.start();

        assertEquals(PLAYER.getString(),   board.getCell(1));
        assertEquals(OPPONENT.getString(), board.getCell(2));
        assertEquals(PLAYER.getString(),   board.getCell(3));
    }
}