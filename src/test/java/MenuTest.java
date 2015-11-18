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

}
