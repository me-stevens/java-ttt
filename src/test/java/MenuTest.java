import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuTest {

    private SpyConsole spy;
    private Menu menu;

    @Before
    public void setUp() {
        spy  = new SpyConsole();
        menu = new Menu(new UserInterface(spy));
    }

    @Test
    public void showPlayersMenuUntilRightOption() {
        spy.setInputs("khgj", "0", "1");
        assertEquals("1", menu.setOption());
        assertEquals(3, spy.timesReadWasCalled());
    }

    @Test
    public void setsTwoHumanPlayers() {
        Player[] players = menu.setPlayers("1");
        assertTrue(players[0] instanceof HumanPlayer);
        assertTrue(players[1] instanceof HumanPlayer);
    }

    @Test
    public void setsOneRobotPlayer() {
        Player[] players = menu.setPlayers("2");
        assertTrue(players[0] instanceof HumanPlayer);
        assertTrue(players[1] instanceof RobotPlayer);
    }

    @Test
    public void setsTwoRobotPlayers() {
        Player[] players = menu.setPlayers("3");
        assertTrue(players[0] instanceof RobotPlayer);
        assertTrue(players[1] instanceof RobotPlayer);
    }

    @Test
    public void setsOneAlienPlayer() {
        Player[] players = menu.setPlayers("4");
        assertTrue(players[0] instanceof HumanPlayer);
        assertTrue(players[1] instanceof AlienPlayer);
    }
}
