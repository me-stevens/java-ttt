package com.mael.ttt;

import java.util.ArrayList;

public class Board {

    private final int SIZE;
    private String[][] board;

    public Board (int size) {
        SIZE  = size;
        board = new String[SIZE][SIZE];
        reset();
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
        Board copy = new Board(SIZE);

        for(int index = 1; index <= SIZE*SIZE; index++) {
            copy.setCell(index, this.getCell(index));
        }

        return copy;
    }

    public void reset() {
        for (int index = 1; index <= SIZE*SIZE; index++) {
            setCell(index, "");
        }
    }

    public ArrayList<Integer> getEmptyCellIndexes() {
        ArrayList<Integer> empties = new ArrayList();

        for (int index = 1; index <= SIZE*SIZE; index++) {
            if (getCell(index).equals("")) {
                empties.add(index);
            }
        }

        return empties;
    }

    public boolean isFull() {
        return getEmptyCellIndexes().size() == 0;
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
        if ( board[getRowFromIndex(index)][getColFromIndex(index)].equals("") ) {
            return false;
        }

        return true;
    }
}
