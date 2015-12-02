package com.mael.ttt;

public class HumanPlayer implements Player {

    private Board board;
    private UserInterface gameUI;

    public HumanPlayer(UserInterface ui, String mark) {
        this.gameUI = ui;
    }

    public int getCellIndex(Board board) {
        this.board = board;
        String cellIndex = returnEmptyCellIndex(returnValidCellIndex());
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

    private String returnEmptyCellIndex(String cellIndex) {
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
