package com.mael.ttt;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final int SIZE;
    private String[][] board;

    public Board (int size) {
        SIZE  = size;
        board = new String[SIZE][SIZE];
        reset();
    }

    public Board (Board board) {
        this(board.getSize());
        for(int index = 1; index <= SIZE*SIZE; index++) {
            this.setCell(index, board.getCell(index));
        }
    }

    public int getSize() {
        return SIZE;
    }

    public void setCell(int index, String cellContent) {
        board[getRowFromIndex(index)][getColFromIndex(index)] = cellContent;
    }

    public String getCell(int index) {
        return board[getRowFromIndex(index)][getColFromIndex(index)];
    }

    public Board getCopy() {
        return new Board(this);
    }

    public void reset() {
        for (int index = 1; index <= SIZE*SIZE; index++) {
            setCell(index, "");
        }
    }

    public List<Integer> getEmptyCellIndexes() {
        List<Integer> empties = new ArrayList<>();

        for (int index = 1; index <= SIZE*SIZE; index++) {
            if (getCell(index).equals("")) {
                empties.add(index);
            }
        }

        return empties;
    }

    public int getRowFromIndex(int index) {
        return (index - 1) / SIZE;
    }

    public int getColFromIndex(int index) {
        return (index - 1) % SIZE;
    }

    public int getIndexFromCoords(int row, int col) {
        return 1 + row*SIZE + col;
    }

    public boolean isCellBusy(int index) {
        return !board[getRowFromIndex(index)][getColFromIndex(index)].equals("");
    }

    public void setBoardContents(String... cellContents) {
        for (int index = 1; index <= SIZE*SIZE; index++) {
            setCell(index, cellContents[index-1]);
        }
    }
}
