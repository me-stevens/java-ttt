package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.Mark;
import com.mael.ttt.ui.UserInterface;

import static com.mael.ttt.players.PlayerType.HUMAN;

public class HumanPlayer implements Player {

    private UserInterface gameUI;
    private Mark mark;

    public HumanPlayer(UserInterface ui, Mark mark) {
        this.gameUI = ui;
        this.mark   = mark;
    }

    public int getMove(Board board) {
        String cellIndex = returnEmptyCellIndex(board, returnValidCellIndex());
        return stringToNumber(cellIndex);
    }

    public Mark getMark() {
        return mark;
    }

    @Override
    public PlayerType getType() {
        return HUMAN;
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
