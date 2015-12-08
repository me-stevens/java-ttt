package com.mael.ttt;

import com.mael.ttt.players.HumanPlayer;
import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static com.mael.ttt.Marks.*;

public class GameTest {

    private int size;
    private Board board;
    private SpyConsole spy;
    private UserInterface gameUI;
    private Game game;

    private String playerMark;
    private String opponentMark;

    @Before
    public void setUp() {
        size   = 3;
        board  = new Board(size);
        spy    = new SpyConsole();
        gameUI = new UserInterface(spy);
        game   = new Game(board, gameUI, Arrays.asList(new HumanPlayer(gameUI), new HumanPlayer(gameUI)));

        playerMark   = PLAYER.getMark();
        opponentMark = OPPONENT.getMark();
    }

    @Test
    public void endsTheGameIfWin() {
        spy.setInputs("1", "4", "2", "5", "3");
        game.start();
        assertEquals(UserInterface.GAMEOVER, spy.lastPrintedMessage());
    }

    @Test
    public void checkForWinnerPrintsBoardAndMsgs() {
        spy.setInputs("1", "4", "2", "5", "3");
        game.start();
        assertThat(spy.printedMessage(), containsString(formattedBoard(playerMark,   playerMark,   playerMark,
                                                                       opponentMark, opponentMark, "6",
                                                                       "7", "8", "9") +
                                                                       UserInterface.HASWINNER + playerMark +
                                                                       UserInterface.GAMEOVER));
    }

    @Test
    public void endsTheGameIfFull() {
        spy.setInputs("1", "2", "3", "4", "5", "6", "8", "7", "9");
        game.start();
        assertEquals(UserInterface.GAMEOVER, spy.lastPrintedMessage());
    }

    @Test
    public void checkForFullPrintsBoardAndMsgs() {
        spy.setInputs("1", "2", "3", "7", "4", "6", "5", "9", "8");
        game.start();
        assertThat(spy.printedMessage(), containsString(formattedBoard(playerMark,   opponentMark, playerMark,
                                                                       playerMark,   playerMark,   opponentMark,
                                                                       opponentMark, playerMark,   opponentMark) +
                                                                       UserInterface.ISFULL +
                                                                       UserInterface.GAMEOVER));
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