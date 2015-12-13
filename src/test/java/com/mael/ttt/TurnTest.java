package com.mael.ttt;

import com.mael.ttt.players.HumanPlayer;
import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Before;
import org.junit.Test;

import static com.mael.ttt.Mark.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class TurnTest {

    private int size;
    private Board board;
    private SpyConsole spy;
    private String X, O;

    @Before
    public void setUp() {
        size   = 3;
        board  = new Board(size);
        spy    = new SpyConsole();
        X      = PLAYER.getString();
        O      = OPPONENT.getString();
    }

    @Test
    public void printsTheBoardInEveryTurn() {
        spy.setInputs("1");
        playTurns(1);
        assertEquals(true, spy.printedMessage().contains("1 2 3 \n4 5 6 \n7 8 9 \n"));
    }

    @Test
    public void updatesTheBoardInEveryTurn() {
        Board old = board.getCopy();
        spy.setInput("1");
        playTurns(1);
        assertNotEquals(old, board);
        assertEquals(X, board.getCell(1));
    }

    @Test
    public void returnsTrueIfNotWinOrFull() {
        spy.setInputs("1");
        assertEquals(true, playTurns(1));
    }

    @Test
    public void returnsFalseIfWin() {
        spy.setInputs("1", "4", "2", "5", "3");
        assertEquals(false, playTurns(5));
    }

    @Test
    public void returnsFalseIfFull() {
        spy.setInputs("1", "2", "3", "4", "5", "7", "6", "9", "8");
        assertEquals(false, playTurns(size*size));
    }

    @Test
    public void printsBoardIfWin() {
        spy.setInputs("1", "4", "2", "5", "3");
        playTurns(5);
        assertThat(spy.printedMessage(), containsString(formattedBoard(  X,   X,   X,
                                                                         O,   O, "6",
                                                                       "7", "8", "9")));
    }

    @Test
    public void printsWinningMessageIfWin() {
        spy.setInputs("1", "4", "2", "5", "3");
        playTurns(5);
        assertThat(spy.printedMessage(), containsString(UserInterface.HASWINNER + X +
                                                        UserInterface.GAMEOVER));
    }

    @Test
    public void printsBoardIfFull() {
        spy.setInputs("1", "2", "3", "4", "5", "7", "6", "9", "8");
        playTurns(size*size);
        assertThat(spy.printedMessage(), containsString(formattedBoard(X, O, X,
                                                                       O, X, X,
                                                                       O, X, O)));
    }

    @Test
    public void printsFullMessageIfFull() {
        spy.setInputs("1", "2", "3", "4", "5", "7", "6", "9", "8");
        playTurns(size*size);
        assertThat(spy.printedMessage(), containsString(UserInterface.ISFULL + UserInterface.GAMEOVER));
    }

    private boolean playTurns(int times) {
        Turn turn           = new Turn(board, new BoardChecker(board), new UserInterface(spy));
        Mark mark           = PLAYER;
        boolean keepPlaying = true;

        for (int i = 0; i < times; i++) {
            keepPlaying = turn.keepPlaying(new HumanPlayer(new UserInterface(spy), mark));
            mark = mark.swapMark();
        }

        return keepPlaying;
    }

    private String formattedBoard(String ... cells) {
        String formattedBoard = "";
        int i = 0;
        for(String cell : cells) {
            formattedBoard += cell + " " + endOfLine(++i);
        }
        return formattedBoard;
    }

    private String endOfLine(int i) {
        return (i % size == 0) ? "\n" : "";
    }
}
