package com.mael.ttt;

import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GameTest {

    private Game game;
    Board board;
    private SpyConsole spy;
    private int size;
    private String playerMark;
    private String opponentMark;

    @Before
    public void setUp() {
        size  = 3;
        board = new Board(size);
        spy   = new SpyConsole();
        game  = new Game(board, new UserInterface(spy));

        playerMark   = Marks.PLAYER.toString();
        opponentMark = Marks.OPPONENT.toString();
    }

    @Test
    public void runPrintsWelcomeMessage() {
        spy.setInputs("1", "1", "4", "2", "5", "3", "n");
        game.run();
        assertEquals(UserInterface.WELCOME, spy.firstPrintedMessage());
    }

    @Test
    public void runEndsTheGameIfWin() {
        spy.setInputs("1", "1", "4", "2", "5", "3", "n");
        game.run();
        assertEquals(UserInterface.REPLAY, spy.lastPrintedMessage());
    }


    @Test
    public void checkForWinnerPrintsBoardAndMsgs() {
        spy.setInputs("1", "1", "4", "2", "5", "3", "n");
        game.run();
        assertThat(spy.printedMessage(), containsString(playerMark + " " + playerMark + " " + playerMark + " \n" + opponentMark + " " + opponentMark + " 6 \n7 8 9 \n" + UserInterface.HASWINNER + playerMark + UserInterface.GAMEOVER));
    }

    @Test
    public void runEndsTheGameIfFull() {
        spy.setInputs("1", "1", "2", "3", "4", "5", "6", "8", "7", "9", "n");
        game.run();
        assertEquals(UserInterface.REPLAY, spy.lastPrintedMessage());
    }

    @Test
    public void checkForFullPrintsBoardAndMsgs() {
        spy.setInputs("1", "1", "2", "3", "7", "4", "6", "5", "9", "8", "n");
        game.run();
        assertThat(spy.printedMessage(), containsString(playerMark + " " + opponentMark + " " + playerMark + " \n" + playerMark + " " + playerMark + " " + opponentMark + " \n" + opponentMark + " " + playerMark + " " + opponentMark + " \n" + UserInterface.ISFULL + UserInterface.GAMEOVER));
    }

    @Test
    public void replaysGameUntilNo() {
        spy.setInputs("1", "1", "4", "2", "5", "3", "y", "1", "1", "4", "2", "5", "3", "n");
        game.run();
        assertEquals(UserInterface.REPLAY, spy.lastPrintedMessage());
    }
}
