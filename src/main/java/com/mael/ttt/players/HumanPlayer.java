package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.ui.UserInterface;

public class HumanPlayer implements Player {

    private UserInterface gameUI;

    public HumanPlayer(UserInterface ui) {
        this.gameUI = ui;
    }

    public int getCellIndex(Board board) {
        String cellIndex = returnEmptyCellIndex(board, returnValidCellIndex());
        return stringToNumber(cellIndex);
    }

    private String returnValidCellIndex() {
        String cellIndex      = gameUI.getInput();
        String validCellIndex = "[1-9]";

        while (!cellIndex.matches(validCellIndex)) {
            gameUI.printNotValidCellMessage();
            cellIndex = gameUI.getInput();
        }

        return cellIndex;
    }

    private String returnEmptyCellIndex(Board board, String cellIndex) {
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
