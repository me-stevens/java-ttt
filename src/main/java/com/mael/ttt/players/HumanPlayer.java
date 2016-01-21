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
        String cellIndex = checkThatCellIsEmpty(board, getValidCellIndex(board));
        return Integer.parseInt(cellIndex);
    }

    public Mark getMark() {
        return mark;
    }

    private String getValidCellIndex(Board board) {
        String cellIndex = gameUI.getInput();

        while (isNotValidCellIndex(board, cellIndex)) {
            gameUI.printNotValidCellMessage();
            cellIndex = gameUI.getInput();
        }
        return cellIndex;
    }

    private String checkThatCellIsEmpty(Board board, String cellIndex) {
        while (isCellBusy(board, cellIndex)) {
            gameUI.printCellIsBusyMessage();
            cellIndex = gameUI.getInput();
        }
        return cellIndex;
    }

    private boolean isNotValidCellIndex(Board board, String cellIndex) {
        return !gameUI.getValidIndexes(board.getSize()).contains(cellIndex);
    }

    private boolean isCellBusy(Board board, String cellIndex) {
        return board.isCellBusy(Integer.parseInt(cellIndex));
    }
}