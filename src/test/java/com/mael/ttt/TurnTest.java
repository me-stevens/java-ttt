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
        turn   = new Turn(board, new BoardChecker(board), uiSpy);
        player = new FakePlayer(1);
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
        board.setBoardContents(X, X, X,
                               O, O, E,
                               E, E, E);
        assertFalse(turn.canBePlayed());
    }

    @Test
    public void cannotBePlayedIfBoardIsFull() {
        board.setBoardContents(X, O, X,
                               O, X, X,
                               O, X, O);
        assertFalse(turn.canBePlayed());
    }

    @Test
    public void printsBoardIfBoardHasWinner() {
        board.setBoardContents(X, X, X,
                               O, O, E,
                               E, E, E);
        turn.printResults(PLAYER);
        assertTrue(uiSpy.printBoardWasCalled());
    }

    @Test
    public void printsBoardIfBoardIsFull() {
        board.setBoardContents(X, O, X,
                               O, X, X,
                               O, X, O);
        turn.printResults(PLAYER);
        assertTrue(uiSpy.printBoardWasCalled());
    }

    @Test
    public void printsWinningMessageIfBoardHasWinner() {
        board.setBoardContents(X, X, X,
                               O, O, E,
                               E, E, E);
        turn.printResults(PLAYER);
        assertTrue(uiSpy.printHasWinnerMessageWasCalled());
        assertFalse(uiSpy.printIsFullMessageWasCalled());

    }

    @Test
    public void printsFullMessageIfBoardIsFull() {
        board.setBoardContents(X, O, X,
                               O, X, X,
                               O, X, O);
        turn.printResults(PLAYER);
        assertTrue(uiSpy.printIsFullMessageWasCalled());
        assertFalse(uiSpy.printHasWinnerMessageWasCalled());

    }

    @Test
    public void ifNoWinnerAndBoardIsNotFullJustPrintsTheBoard() {
        board.setBoardContents(X, X, E,
                               O, O, E,
                               E, E, E);
        turn.printResults(PLAYER);
        assertTrue(uiSpy.printBoardWasCalled());
        assertFalse(uiSpy.printHasWinnerMessageWasCalled());
        assertFalse(uiSpy.printIsFullMessageWasCalled());
    }

    @Test
    public void announcesTheCorrectWinnerForPlayer() {
        board.setBoardContents(X, X, X,
                               O, O, E,
                               E, E, E);
        turn.printResults(PLAYER);
        assertEquals(PLAYER, uiSpy.announcedWinner());
    }


    @Test
    public void announcesTheCorrectWinnerForOpponent() {
        board.setBoardContents(O, O, O,
                               X, X, E,
                               E, E, E);
        turn.printResults(OPPONENT);
        assertEquals(OPPONENT, uiSpy.announcedWinner());
    }

}
