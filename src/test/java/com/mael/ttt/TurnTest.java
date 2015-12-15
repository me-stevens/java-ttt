package com.mael.ttt;

import com.mael.ttt.players.HumanPlayer;
import com.mael.ttt.players.Player;
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
    private Turn turn;
    private Player player;
    private String X, O;

    @Before
    public void setUp() {
        size   = 3;
        board  = new Board(size);
        spy    = new SpyConsole();
        turn   = new Turn(board, new BoardChecker(board), new UserInterface(spy));
        player = new HumanPlayer(new UserInterface(spy), PLAYER);
        X      = PLAYER.getString();
        O      = OPPONENT.getString();
    }

    @Test
    public void printsTheBoardInEveryTurn() {
        spy.setInputs("1");
        turn.placeMark(player);
        assertEquals(true, spy.printedMessage().contains("1 2 3 \n4 5 6 \n7 8 9 \n"));
    }

    @Test
    public void updatesTheBoardInEveryTurn() {
        spy.setInput("1");
        turn.placeMark(player);
        assertEquals(X, board.getCell(1));
    }

    @Test
    public void returnsTrueIfNotWinOrFull() {
        spy.setInputs("1");
        turn.placeMark(player);
        assertEquals(true, turn.isNotGameOver(player));
    }

    @Test
    public void returnsFalseIfWin() {
        board.setBoardContents( X,  X,  X,
                                O,  O, "",
                               "", "", "");
        assertEquals(false, turn.isNotGameOver(player));
    }

    @Test
    public void returnsFalseIfFull() {
        board.setBoardContents( X,  O,  X,
                                O,  X,  X,
                                O,  X,  O);
        assertEquals(false, turn.isNotGameOver(player));
    }

    @Test
    public void printsBoardIfWin() {
        board.setBoardContents( X,  X, X,
                                O,  O, "",
                               "", "", "");
        turn.isNotGameOver(player);
        assertThat(spy.printedMessage(), containsString(formattedBoard(  X,   X,   X,
                                                                         O,   O, "6",
                                                                       "7", "8", "9")));
    }

    @Test
    public void printsBoardIfFull() {
        board.setBoardContents( X,  O,  X,
                                O,  X,  X,
                                O,  X,  O);
        turn.isNotGameOver(player);
        assertThat(spy.printedMessage(), containsString(formattedBoard(X, O, X,
                                                                       O, X, X,
                                                                       O, X, O)));
    }

    @Test
    public void printsWinningMessageIfWin() {
        board.setBoardContents( X,  X, X,
                                O,  O, "",
                               "", "", "");
        turn.isNotGameOver(player);
        assertThat(spy.printedMessage(), containsString(UserInterface.HASWINNER + X +
                                                        UserInterface.GAMEOVER));
    }


    @Test
    public void printsFullMessageIfFull() {
        board.setBoardContents( X,  O,  X,
                                O,  X,  X,
                                O,  X,  O);
        turn.isNotGameOver(player);
        assertThat(spy.printedMessage(), containsString(UserInterface.ISFULL + UserInterface.GAMEOVER));
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
