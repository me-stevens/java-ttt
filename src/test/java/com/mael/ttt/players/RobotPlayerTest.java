package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Before;
import org.junit.Test;

import static com.mael.ttt.Mark.OPPONENT;
import static com.mael.ttt.Mark.PLAYER;
import static com.mael.ttt.players.PlayerType.ROBOT;
import static org.junit.Assert.assertEquals;

public class RobotPlayerTest {

    private int size;
    private Board board;
    private RobotPlayer robotPlayer;
    private SpyConsole spy;
    private String X, O;

    @Before
    public void setUp() {
        size        = 3;
        board       = new Board(size);
        spy         = new SpyConsole();
        robotPlayer = new RobotPlayer(new UserInterface(spy), OPPONENT);
        X           = PLAYER.getString();
        O           = OPPONENT.getString();
    }

    @Test
    public void promptMessageIsPrinted() {
        board  =new Board(size);
        robotPlayer.getMove(board);
        assertEquals(UserInterface.ROBOTPROMT, spy.firstPrintedMessage());
    }

    @Test
    public void choosesWinningCombinationInARow() {
        board.setBoardContents( O,  O, "",
                                X,  X, "",
                               "", "", "");
        assertEquals(3, robotPlayer.getMove(board));
    }

    @Test
    public void choosesWinningCombinationInAColumn() {
        board.setBoardContents( X,  O, "",
                                X,  O, "",
                               "", "", "");
        assertEquals(7, robotPlayer.getMove(board));
    }

    @Test
    public void choosesWinningCombinationInDiagonal() {
        board.setBoardContents(O,  X,  X,
                               X,  O,  X,
                               X, "", "");
        assertEquals(9, robotPlayer.getMove(board));
    }

    @Test
    public void choosesWinningCombinationInAntiDiagonal() {
        board.setBoardContents( X,  X, O,
                                X,  O, X,
                               "", "", X);
        assertEquals(7, robotPlayer.getMove(board));
    }

    @Test
    public void blocksTheOpponentInARow() {
        board.setBoardContents( X,  X, "",
                               "",  O, "",
                               "", "", "");
        assertEquals(3, robotPlayer.getMove(board));
    }

    @Test
    public void blocksTheOpponentInAColumn() {
        board.setBoardContents("", "",  X,
                               "",  O, "",
                               "", "",  X);
        assertEquals(6, robotPlayer.getMove(board));
    }

    @Test
    public void blocksTheOpponentInDiagonal() {
        board.setBoardContents( X, "", "",
                               "",  X, "",
                                O, "", "");
        assertEquals(9, robotPlayer.getMove(board));
    }

    @Test
    public void blocksTheOpponentInAntiDiagonal() {
        board.setBoardContents("", "",  X,
                                O, "", "",
                                X, "", "");
        assertEquals(5, robotPlayer.getMove(board));
    }

    @Test
    public void returnsMark() {
        assertEquals(OPPONENT, robotPlayer.getMark());
    }
}
