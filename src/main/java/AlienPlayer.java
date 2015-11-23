import java.util.List;
import java.util.Random;

public class AlienPlayer implements Player{
    private final UserInterface gameUI;

    public AlienPlayer(UserInterface gameUI, String mark) {
        this.gameUI = gameUI;
    }

    public int getCellIndex(Board board) {
        gameUI.printAlienPrompt();

        List<Integer> empties = board.getEmptyCellIndexes();
        Random random         = new Random();
        return empties.get(random.nextInt(empties.size()));
    }
}
