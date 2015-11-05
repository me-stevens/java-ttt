import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {
    @Test
    public void updatesBoard() {
        Game game = new Game();
        game.updateBoard(0, 0, "X");
        assertEquals("X", game.getBoard().getCell(0, 0));
    }

}
