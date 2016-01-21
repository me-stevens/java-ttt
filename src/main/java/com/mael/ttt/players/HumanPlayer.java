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
            printFeedback(board, cellIndex);
            cellIndex = gameUI.getInput();
        }

        return cellIndex;
    }

    private boolean invalidInput(Board board, String cellIndex) {
        return isNotValidCellIndex(board, cellIndex) || isCellBusy(board, cellIndex);
    }

    private boolean isNotValidCellIndex(Board board, String cellIndex) {
        return !board.getValidIndexes().contains(cellIndex);
    }

    private boolean isCellBusy(Board board, String cellIndex) {
        return board.isCellBusy(Integer.parseInt(cellIndex));
    }

    private void printFeedback(Board board, String cellIndex) {
        if (isNotValidCellIndex(board, cellIndex)) {
            gameUI.printNotValidCellMessage();
        } else if (isCellBusy(board, cellIndex)) {
            gameUI.printCellIsBusyMessage();
        }
    }
}