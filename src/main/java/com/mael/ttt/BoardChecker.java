package com.mael.ttt;

public class BoardChecker {

    private int size;
    private Board board;

    public BoardChecker(Board board) {
        this.board = board;
        this.size  = board.getSize();
    }

    public boolean hasWinner(Mark mark) {
        return checkWinnerInRows(mark)     ||
               checkWinnerInCols(mark)     ||
               checkWinnerInDiagonal(mark) ||
               checkWinnerInAntiDiagonal(mark);
    }

    private boolean checkWinnerInCols(Mark mark) {
        for (int col = 0; col < size; col++) {
            if (checkWinnerInColumn(col, mark)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinnerInRow(int row, Mark mark) {
        for (int col = 0; col < size; col++) {
            if (cellIsNotMark(row, col, mark)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkWinnerInRows(Mark mark) {
        for (int row = 0; row < size; row++) {
            if (checkWinnerInRow(row, mark)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkWinnerInColumn(int col, Mark mark) {
        for (int row = 0; row < size; row++) {
            if (cellIsNotMark(row, col, mark)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkWinnerInDiagonal(Mark mark) {
        for (int row = 0, col = 0; row < size && col < size; row++, col++) {
            if (cellIsNotMark(row, col, mark)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkWinnerInAntiDiagonal(Mark mark) {
        for (int row = 0, col = size-1; row < size && col >= 0; row++, col--) {
            if (cellIsNotMark(row, col, mark)) {
                return false;
            }
        }
        return true;
    }

    private boolean cellIsNotMark(int row, int col, Mark mark) {
        return !(board.getCell(board.getIndexFromCoords(row, col)) == mark);
    }

    public boolean isFull() {
        return board.getEmptyCellIndexes().size() == 0;
    }
}
