package com.mael.ttt;

import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static com.mael.ttt.Marks.*;

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

        playerMark   = PLAYER.getMark();
        opponentMark = OPPONENT.getMark();
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
        assertThat(spy.printedMessage(), containsString(formattedBoard(playerMark,   playerMark,   playerMark,
                                                                       opponentMark, opponentMark, "6",
                                                                       "7", "8", "9") +
                                                        UserInterface.HASWINNER + playerMark +
                                                        UserInterface.GAMEOVER));
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
        assertThat(spy.printedMessage(), containsString(formattedBoard(playerMark,   opponentMark, playerMark,
                                                                       playerMark,   playerMark,   opponentMark,
                                                                       opponentMark, playerMark,   opponentMark) +
                                                        UserInterface.ISFULL +
                                                        UserInterface.GAMEOVER));
    }

    @Test
    public void replaysGameUntilNo() {
        spy.setInputs("1", "1", "4", "2", "5", "3", "y", "1", "1", "4", "2", "5", "3", "n");
        game.run();
        assertEquals(UserInterface.REPLAY, spy.lastPrintedMessage());
    }

    private String formattedBoard(String ... cells) {
        String formattedBoard = "";
        for (int i = 0; i < cells.length; i++) {
            formattedBoard += cells[i] + " ";
            if ((i+1) % 3 == 0) {
                formattedBoard += "\n";
            }
        }
        return formattedBoard;
    }
}
