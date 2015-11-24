import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuTest {

    private SpyConsole spy;
    private Menu menu;

    @Before
    public void setUp() {
        int size = 3;
        spy  = new SpyConsole();
        menu = new Menu(new UserInterface(spy), size);
    }

    @Test
    public void showPlayersMenuUntilRightOption() {
        spy.setInputs("khgj", "0", "1");
        menu.createPlayers();
        assertEquals(3, spy.timesReadWasCalled());
    }

    @Test
    public void setsTwoHumanPlayers() {
        spy.setInput("1");
        Player[] players = menu.createPlayers();
        assertTrue(players[0] instanceof HumanPlayer);
        assertTrue(players[1] instanceof HumanPlayer);
    }

    @Test
    public void setsOneRobotPlayer() {
        spy.setInput("2");
        Player[] players = menu.createPlayers();
        assertTrue(players[0] instanceof HumanPlayer);
        assertTrue(players[1] instanceof RobotPlayer);
    }

    @Test
    public void setsTwoRobotPlayers() {
        spy.setInput("3");
        Player[] players = menu.createPlayers();
        assertTrue(players[0] instanceof RobotPlayer);
        assertTrue(players[1] instanceof RobotPlayer);
    }

    @Test
    public void setsOneAlienPlayer() {
        spy.setInput("4");
        Player[] players = menu.createPlayers();
        assertTrue(players[0] instanceof HumanPlayer);
        assertTrue(players[1] instanceof AlienPlayer);
    }
}
