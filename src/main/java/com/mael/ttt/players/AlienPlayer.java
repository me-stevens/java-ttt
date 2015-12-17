package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.Mark;
import com.mael.ttt.ui.UserInterface;

import java.util.List;
import java.util.Random;

public class AlienPlayer implements Player {
    private final UserInterface gameUI;
    private final Mark mark;

    public AlienPlayer(UserInterface gameUI, Mark mark) {
        this.gameUI = gameUI;
        this.mark   = mark;
    }

    public int getMove(Board board) {
        gameUI.printAlienPrompt();
        List<Integer> emptyCellIndexes = board.getEmptyCellIndexes();
        return emptyCellIndexes.get(new Random().nextInt(emptyCellIndexes.size()));
    }

    public Mark getMark() {
        return mark;
    }
}
