package com.mael.ttt;

import com.mael.ttt.players.FakePlayer;
import com.mael.ttt.players.Player;
import com.mael.ttt.ui.UserInterfaceSpy;
import org.junit.Before;
import org.junit.Test;

import static com.mael.ttt.Mark.*;
import static org.junit.Assert.*;

public class TurnTest {
    private Board board;
    private Turn turn;
    private Player player;
    private Mark X, O, E;
    private UserInterfaceSpy uiSpy;
    private int size;

    @Before
    public void setUp() {
        size   = 3;
        board  = new Board(size);
        uiSpy  = new UserInterfaceSpy();
        player = new FakePlayer(1);
        turn   = new Turn(board, new BoardChecker(board), uiSpy);
        X      = PLAYER;
        O      = OPPONENT;
        E      = EMPTY;
    }

    @Test
    public void printsTheBoardInEveryTurn() {
        turn.placeMark(player);
        assertTrue(uiSpy.printBoardWasCalled());
    }

    @Test
    public void updatesTheBoardInEveryTurn() {
        turn.placeMark(player);
        assertEquals(X, board.getCell(1));
    }

    @Test
    public void canBePlayedIfNoWinnerOrFull() {
        turn.placeMark(player);
        assertTrue(turn.canBePlayed());
    }

    @Test
    public void cannotBePlayedIfBoardHasWinner() {
        board = new Board(X, X, X,
                          O, O, E,
                          E, E, E);
        turn  = new Turn(board, new BoardChecker(board), uiSpy);
        assertFalse(turn.canBePlayed());
    }

    @Test
    public void cannotBePlayedIfBoardIsFull() {
        board = new Board(X, O, X,
                          O, X, X,
                          O, X, O);
        turn  = new Turn(board, new BoardChecker(board), uiSpy);
        assertFalse(turn.canBePlayed());
    }

    @Test
    public void printsBoardIfBoardHasWinner() {
        board = new Board(X, X, X,
                          O, O, E,
                          E, E, E);
        turn  = new Turn(board, new BoardChecker(board), uiSpy);
        turn.printResults(PLAYER);
        assertTrue(uiSpy.printBoardWasCalled());
    }

    @Test
    public void printsBoardIfBoardIsFull() {
        board = new Board(X, O, X,
                          O, X, X,
                          O, X, O);
        turn  = new Turn(board, new BoardChecker(board), uiSpy);
        turn.printResults(PLAYER);
        assertTrue(uiSpy.printBoardWasCalled());
    }

    @Test
    public void printsWinningMessageIfBoardHasWinner() {
        board = new Board(X, X, X,
                          O, O, E,
                          E, E, E);
        turn  = new Turn(board, new BoardChecker(board), uiSpy);
        turn.printResults(PLAYER);
        assertTrue(uiSpy.printHasWinnerMessageWasCalled());
        assertFalse(uiSpy.printIsFullMessageWasCalled());
    }

    @Test
    public void printsFullMessageIfBoardIsFull() {
        board = new Board(X, O, X,
                          O, X, X,
                          O, X, O);
        turn  = new Turn(board, new BoardChecker(board), uiSpy);
        turn.printResults(PLAYER);
        assertTrue(uiSpy.printIsFullMessageWasCalled());
        assertFalse(uiSpy.printHasWinnerMessageWasCalled());
    }

    @Test
    public void ifNoWinnerAndBoardIsNotFullJustPrintsTheBoard() {
        board = new Board(X, X, E,
                          O, O, E,
                          E, E, E);
        turn  = new Turn(board, new BoardChecker(board), uiSpy);
        turn.printResults(PLAYER);
        assertTrue(uiSpy.printBoardWasCalled());
        assertFalse(uiSpy.printHasWinnerMessageWasCalled());
        assertFalse(uiSpy.printIsFullMessageWasCalled());
    }

    @Test
    public void announcesTheCorrectWinnerForPlayer() {
        board = new Board(X, X, X,
                          O, O, E,
                          E, E, E);
        turn  = new Turn(board, new BoardChecker(board), uiSpy);
        turn.printResults(PLAYER);
        assertEquals(PLAYER, uiSpy.announcedWinner());
    }


    @Test
    public void announcesTheCorrectWinnerForOpponent() {
        board = new Board(O, O, O,
                          X, X, E,
                          E, E, E);
        turn  = new Turn(board, new BoardChecker(board), uiSpy);
        turn.printResults(OPPONENT);
        assertEquals(OPPONENT, uiSpy.announcedWinner());
    }
}
