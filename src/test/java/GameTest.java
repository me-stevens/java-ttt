import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class GameTest {

    private Game game;
    Board board;
    private SpyConsole spy;
    private int size;

    @Before
    public void setUp() {
        size = 3;
        board = new Board(size);
        spy  = new SpyConsole();
        game = new Game(board, new UserInterface(spy));
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
        assertThat(spy.printedMessage(), containsString("X X X \nO O 6 \n7 8 9 \n" + UserInterface.HASWINNER + "X" + UserInterface.GAMEOVER));
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
        assertThat(spy.printedMessage(), containsString("X O X \nX X O \nO X O \n" + UserInterface.ISFULL + UserInterface.GAMEOVER));
    }

    @Test
    public void replaysGameUntilNo() {
        spy.setInputs("1", "1", "4", "2", "5", "3", "y", "1", "1", "4", "2", "5", "3", "n");
        game.run();
        assertEquals(UserInterface.REPLAY, spy.lastPrintedMessage());
    }


}
