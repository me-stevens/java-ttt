package com.mael.ttt;

import com.mael.ttt.players.HumanPlayer;
import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static com.mael.ttt.Mark.*;

public class GameTest {

    private int size;
    private Board board;
    private SpyConsole spy;
    private Game game;
    private UserInterface gameUI;

    @Before
    public void setUp() {
        size   = 3;
        board  = new Board(size);
        spy    = new SpyConsole();
        gameUI = new UserInterface(spy);
        game   = new Game(new Turn(board, gameUI), new HumanPlayer(gameUI, PLAYER), new HumanPlayer(gameUI, OPPONENT));
    }

    @Test
    public void endsTheGameIfWin() {
        spy.setInputs("1", "4", "2", "5", "3");
        game.start();
        assertEquals(UserInterface.GAMEOVER, spy.lastPrintedMessage());
    }

    @Test
    public void endsTheGameIfFull() {
        spy.setInputs("1", "2", "3", "4", "5", "6", "8", "7", "9");
        game.start();
        assertEquals(UserInterface.GAMEOVER, spy.lastPrintedMessage());
    }

    @Test
    public void markIsSwappedInEveryTurn() {
        spy.setInputs("1", "2", "3", "4", "5", "6", "7");
        game.start();

        assertEquals(PLAYER.getMark(),   board.getCell(1));
        assertEquals(OPPONENT.getMark(), board.getCell(2));
        assertEquals(PLAYER.getMark(),   board.getCell(3));
    }
}