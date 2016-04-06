package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.Mark;
import com.mael.ttt.ui.UserInterface;

public class HumanPlayer implements Player {

    private UserInterface gameUI;
    private Mark mark;

    public HumanPlayer(UserInterface gameUI, Mark mark) {
        this.gameUI = gameUI;
        this.mark   = mark;
    }

    public int getMove(Board board) {
        String cellIndex = getValidCellIndex(board);
        return Integer.parseInt(cellIndex);
    }

    public Mark getMark() {
        return mark;
    }

    private String getValidCellIndex(Board board) {
        String cellIndex = gameUI.getInput();

        while (invalidInput(board, cellIndex)) {
            gameUI.printNotValidCellMessage();
            cellIndex = gameUI.getInput();
        }

        return cellIndex;
    }

    private boolean invalidInput(Board board, String cellIndex) {
        return !board.getEmptiesAsStrings().contains(cellIndex);
    }
}