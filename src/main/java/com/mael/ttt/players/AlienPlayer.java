package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.ui.UserInterface;

import java.util.List;
import java.util.Random;

public class AlienPlayer implements Player {
    private final UserInterface gameUI;

    public AlienPlayer(UserInterface gameUI) {
        this.gameUI = gameUI;
    }

    public int getMove(Board board) {
        gameUI.printAlienPrompt();

        List<Integer> empties = board.getEmptyCellIndexes();
        return empties.get(new Random().nextInt(empties.size()));
    }
}
