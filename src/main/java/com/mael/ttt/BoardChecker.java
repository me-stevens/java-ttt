package com.mael.ttt;

public class BoardChecker {

    private int size;
    private Board board;

    public BoardChecker(Board board) {
        this.board = board;
        size       = board.getSize();
    }

    public boolean hasWinner(String mark) {
        return checkWinnerInRows(mark)     ||
               checkWinnerInCols(mark)     ||
               checkWinnerInDiagonal(mark) ||
               checkWinnerInAntiDiagonal(mark);
    }

    private boolean checkWinnerInCols(String mark) {
        for (int col = 0; col < size; col++) {
            if (checkWinnerInColumn(col, mark)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinnerInRow(int row, String mark) {
        for (int col = 0; col < size; col++) {
            if (cellIsNotMark(row, col, mark)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkWinnerInRows(String mark) {
        for (int row = 0; row < size; row++) {
            if (checkWinnerInRow(row, mark)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinnerInColumn(int col, String mark) {
        for (int row = 0; row < size; row++) {
            if (cellIsNotMark(row, col, mark)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkWinnerInDiagonal(String mark) {
        for (int row = 0, col = 0; row < size && col < size; row++, col++) {
            if (cellIsNotMark(row, col, mark)) {
                return false;
            }
        }

        return true;
    }

    private boolean checkWinnerInAntiDiagonal(String mark) {
        for (int row = 0, col = size-1; row < size && col >= 0; row++, col--) {
            if (cellIsNotMark(row, col, mark)) {
                return false;
            }
        }

        return true;
    }

    private boolean cellIsNotMark(int row, int col, String mark) {
        return !board.getCell(board.getIndexFromCoords(row, col)).equals(mark);
    }

    public boolean isFull() {
        return board.getEmptyCellIndexes().size() == 0;
    }
}
