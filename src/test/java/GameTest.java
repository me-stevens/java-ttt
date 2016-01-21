import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;
    private SpyConsole spy;
    private int size;

    @Before
    public void setUp() {
        size = 3;
        spy  = new SpyConsole();
        game = new Game(new Board(size), new UserInterface(spy));
    }

    @Test
    public void checkForWinnerPrintsBoardAndMsgs() {
        for (int index = 1; index <= size; index++) {
            game.getBoard().setCell(index, "X");
        }

        game.checkForWinner();
        assertEquals("X X X \n4 5 6 \n7 8 9 \n" + UserInterface.HASWINNER + "X" + UserInterface.GAMEOVER, spy.printedMessage());
    }

    @Test
    public void checkForFullPrintsBoardAndMsgs() {
        for (int index = 1; index <= size*size; index++) {
            game.getBoard().setCell(index, "X");
        }

        game.checkForFull();
        assertEquals("X X X \nX X X \nX X X \n" + UserInterface.ISFULL + UserInterface.GAMEOVER, spy.printedMessage());
    }

    @Test
    public void turnPrintsTheBoardInEveryTurn() {
        spy.setInputs("1");
        playTurns(1);
        assertEquals("1 2 3 \n4 5 6 \n7 8 9 \n" + UserInterface.PROMPT, spy.printedMessage());
    }

    @Test
    public void turnUpdatesTheBoardInEveryTurn() {
        String[][] old = game.getBoard().getContents();
        spy.setInput("1");
        playTurns(1);

        assertEquals("X", game.getBoard().getCell(1));
    }

    @Test
    public void turnReturnsTrueIfNotWinOrFull() {
        spy.setInput("1");
        assertTrue(game.nextTurn());
    }

    @Test
    public void turnReturnsFalseIfWin() {
        spy.setInputs("1", "4", "2", "5", "3");
        playTurns(4);

        assertFalse(game.nextTurn());
    }

    @Test
    public void turnReturnsFalseIfFull() {
        spy.setInputs("1", "2", "3", "4", "5", "6", "8", "7", "9");
        playTurns(size*size - 1);

        assertFalse(game.nextTurn());
    }

    @Test
    public void markIsSwappedInEveryTurn() {
        spy.setInputs("1", "2", "3");
        playTurns(3);

        assertEquals("X", game.getBoard().getCell(1));
        assertEquals("O", game.getBoard().getCell(2));
        assertEquals("X", game.getBoard().getCell(3));
    }

    @Test
    public void showPlayersMenuUntilRightOption() {
        spy.setInputs("khgj", "0", "1");
        assertEquals("1", game.showPlayersMenu());
        assertEquals(3, spy.timesReadWasCalled());
    }

    @Test
    public void setsTwoHumanPlayers() {
        game.setPlayers("1");
        assertTrue(game.getHumanity1());
        assertTrue(game.getHumanity2());
    }

    @Test
    public void setsOneRobotPlayer() {
        game.setPlayers("2");
        assertTrue( game.getHumanity1());
        assertFalse(game.getHumanity2());
    }

    @Test
    public void setsTwoRobotPlayers() {
        game.setPlayers("3");
        assertFalse(game.getHumanity1());
        assertFalse(game.getHumanity2());
    }

    @Test
    public void startPrintsWelcomeMessage() {
        spy.setInputs("1", "1", "4", "2", "5", "3");
        game.start();
        assertEquals(UserInterface.WELCOME, spy.firstPrintedMessage());
    }

    @Test
    public void startsAndEndsTheGameIfWin() {
        spy.setInputs("1", "1", "4", "2", "5", "3");
        game.start();
        assertEquals(UserInterface.GAMEOVER, spy.lastPrintedMessage());
    }

    @Test
    public void startsAndEndsTheGameIfFull() {
        spy.setInputs("1", "1", "2", "3", "4", "5", "6", "8", "7", "9");
        game.start();
        assertEquals(UserInterface.GAMEOVER, spy.lastPrintedMessage());
    }

    @Test
    public void replaysGameUntilNo() {
        spy.setInputs("1", "1", "4", "2", "5", "3", "y", "1", "1", "4", "2", "5", "3", "n");
        game.run();
        assertEquals(UserInterface.REPLAY, spy.lastPrintedMessage());
    }

    @Test
    public void robotPlays() {
        spy.setInput("1");
        game.setHumanity2(false);
        playTurns(2);
        assertEquals("O", game.getBoard().getCell(5));
    }

    private void playTurns(int times) {
        for (int i = 0; i < times; i++) {
            game.nextTurn();
        }
    }
}
