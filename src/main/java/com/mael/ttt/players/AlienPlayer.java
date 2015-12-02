package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.ui.UserInterface;

import java.util.List;
import java.util.Random;

public class AlienPlayer implements Player {
    private final UserInterface gameUI;

    public AlienPlayer(UserInterface gameUI, String mark) {
        this.gameUI = gameUI;
    }

    public int getCellIndex(Board board) {
        gameUI.printAlienPrompt();

        List<Integer> empties = board.getEmptyCellIndexes();
        return empties.get(new Random().nextInt(empties.size()));
    }
}
