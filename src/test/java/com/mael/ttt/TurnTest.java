package com.mael.ttt;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class TurnTest {
/*

    @Ignore
    @Test
    public void turnPrintsTheBoardInEveryTurn() {
        spy.setInputs("1", "1");
        game.run();
        assertTrue(spy.printedMessage().contains("1 2 3 \n4 5 6 \n7 8 9 \n" + com.mael.ttt.ui.UserInterface.PROMPT));
    }

    @Ignore
    @Test
    public void turnUpdatesTheBoardInEveryTurn() {
        com.mael.ttt.Board old = board.getCopy();
        spy.setInput("1");
        playTurns(1);

        assertNotEquals(old, board);
        assertEquals("X", board.getCell(1));
    }

    @Ignore
    @Test
    public void turnReturnsTrueIfNotWinOrFull() {
        spy.setInputs("1", "1");
        game.run();
        //assertTrue(game.nextTurn());
    }

    @Ignore
    @Test
    public void turnReturnsFalseIfWin() {
        spy.setInputs("1", "1", "4", "2", "5", "3");
        playTurns(4);

        //assertFalse(game.nextTurn());
    }

    @Ignore
    @Test
    public void turnReturnsFalseIfFull() {
        spy.setInputs("1", "1", "2", "3", "4", "5", "6", "8", "7", "9");
        playTurns(size*size - 1);

        //assertFalse(game.nextTurn());
    }

    @Ignore
    @Test
    public void markIsSwappedInEveryTurn() {
        spy.setInputs("1", "1", "2", "3");
        playTurns(3);

        assertEquals("X", board.getCell(1));
        assertEquals("O", board.getCell(2));
        assertEquals("X", board.getCell(3));
    }

    @Ignore
    @Test
    public void robotPlays() {
        spy.setInputs("2", "1", "2", "9", "3", "4", "5", "6", "7", "8");
        game.run();

        System.out.println(spy.printedMessage());

        assertEquals("O", board.getCell(5));
    }

    private void playTurns(int times) {
        for (int i = 0; i < times; i++) {
            //game.nextTurn();
        }
    }*/
}
