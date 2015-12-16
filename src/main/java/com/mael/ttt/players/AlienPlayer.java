package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.Mark;
import com.mael.ttt.ui.UserInterface;

import java.util.List;
import java.util.Random;

import static com.mael.ttt.players.PlayerType.ALIEN;

public class AlienPlayer implements Player {
    private final UserInterface gameUI;
    private final Mark mark;

    public AlienPlayer(UserInterface gameUI, Mark mark) {
        this.gameUI = gameUI;
        this.mark   = mark;
    }

    public int getMove(Board board) {
        gameUI.printAlienPrompt();

        List<Integer> empties = board.getEmptyCellIndexes();
        return empties.get(new Random().nextInt(empties.size()));
    }

    public Mark getMark() {
        return mark;
    }
}
