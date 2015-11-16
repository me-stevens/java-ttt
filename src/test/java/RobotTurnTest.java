import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotTurnTest {

    private int size;
    private Board board;
    private RobotTurn robotTurn;
    private SpyConsole spy;

    @Before
    public void setUp() {
        size = 3;
        spy  = new SpyConsole();
    }

    @Test
    public void promptMessageIsPrinted() {
        board    = new Board(size);
        int temp = new RobotTurn(board, new UserInterface(spy), "O").getCellIndex();
        assertEquals(UserInterface.ROBOTPROMT, spy.firstPrintedMessage());
    }

    @Test
    public void choosesWinningCombinationInARow() {
        board = setBoard("O", "O", "",
                         "X", "X", "",
                          "",  "", "");

        robotTurn = new RobotTurn(board, new UserInterface(spy), "O");
        assertEquals(3, robotTurn.getCellIndex());
    }

    @Test
    public void choosesWinningCombinationInAColumn() {
        board = setBoard("X", "O", "",
                         "X", "O", "",
                          "",  "", "");

        robotTurn = new RobotTurn(board, new UserInterface(spy), "O");
        assertEquals(7, robotTurn.getCellIndex());
    }

    @Test
    public void choosesWinningCombinationInDiagonal() {
        board = setBoard("O", "X", "X",
                         "X", "O", "X",
                         "X",  "", "");

        robotTurn = new RobotTurn(board, new UserInterface(spy), "O");
        assertEquals(9, robotTurn.getCellIndex());
    }

    @Test
    public void choosesWinningCombinationInAntiDiagonal() {
        board = setBoard("X", "X", "O",
                         "X", "O", "X",
                         "",  "", "X");

        robotTurn = new RobotTurn(board, new UserInterface(spy), "O");
        assertEquals(7, robotTurn.getCellIndex());
    }

    @Test
    public void blocksTheOpponentInARow() {
        board = setBoard("X", "X", "",
                          "", "O", "",
                          "",  "", "");

        robotTurn = new RobotTurn(board, new UserInterface(spy), "O");
        assertEquals(3, robotTurn.getCellIndex());
    }

    @Test
    public void blocksTheOpponentInAColumn() {
        board = setBoard("", "", "X",
                         "", "O", "",
                         "", "", "X");

        robotTurn = new RobotTurn(board, new UserInterface(spy), "O");
        assertEquals(6, robotTurn.getCellIndex());
    }

    @Test
    public void blocksTheOpponentInDiagonal() {
        board = setBoard("X", "", "",
                         "", "X", "",
                         "O", "", "");

        robotTurn = new RobotTurn(board, new UserInterface(spy), "O");
        assertEquals(9, robotTurn.getCellIndex());
    }

    @Test
    public void blocksTheOpponentInAntiDiagonal() {
        board = setBoard("",  "", "X",
                         "O", "", "",
                         "X", "", "");

        robotTurn = new RobotTurn(board, new UserInterface(spy), "O");
        assertEquals(5, robotTurn.getCellIndex());
    }

    private Board setBoard(String... cellContents) {
        board = new Board(size);
        for (int index = 1; index <= size*size; index++) {
            board.setCell(index, cellContents[index-1]);
        }
        return board;
    }
}
