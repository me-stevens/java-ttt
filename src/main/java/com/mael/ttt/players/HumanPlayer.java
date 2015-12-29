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
        return stringToNumber(cellIndex);
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

    private boolean isNotValidCellIndex(Board board, String cellIndex) {
        return !gameUI.getBoardIndexesAsStrings(board.getSize()).contains(cellIndex);
    }

    private String checkThatCellIsEmpty(Board board, String cellIndex) {
        while (board.isCellBusy(stringToNumber(cellIndex))) {
            gameUI.printCellIsBusyMessage();
            cellIndex = gameUI.getInput();
        }
        return cellIndex;
    }

    private int stringToNumber(String cellIndex) {
        return Integer.parseInt(cellIndex);
    }
}