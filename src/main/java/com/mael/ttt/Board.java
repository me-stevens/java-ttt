package com.mael.ttt;

import java.util.ArrayList;
import java.util.List;

import static com.mael.ttt.Mark.*;

public class Board {

    private final int SIZE;
    private Mark[][] board;

    public Board (int size) {
        SIZE  = size;
        board = new Mark[SIZE][SIZE];
        reset();
    }

    public Board (Board board) {
        this(board.getSize());
        for(int index = 1; index <= SIZE*SIZE; index++) {
            this.setCell(index, board.getCell(index));
        }
    }

    public Board(Mark ... cellContents) {
        this((int) Math.sqrt(cellContents.length));
        for (int index = 1; index <= SIZE*SIZE; index++) {
            setCell(index, cellContents[index - 1]);
        }
    }

    public int getSize() {
        return SIZE;
    }

    public void setCell(int index, Mark cellContent) {
        board[getRowFromIndex(index)][getColFromIndex(index)] = cellContent;
    }

    public Mark getCell(int index) {
        return board[getRowFromIndex(index)][getColFromIndex(index)];
    }

    public Board getCopy() {
        return new Board(this);
    }

    public void reset() {
        for (int index = 1; index <= SIZE*SIZE; index++) {
            setCell(index, EMPTY);
        }
    }

    public List<Integer> getEmptyCellIndexes() {
        List<Integer> empties = new ArrayList<>();
        for (int index = 1; index <= SIZE*SIZE; index++) {
            if (getCell(index) == EMPTY) {
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
        return !(board[getRowFromIndex(index)][getColFromIndex(index)] == EMPTY);
    }

    public List<String> getEmptiesAsStrings() {
        List<String> toString = new ArrayList<>();
        List<Integer> empties = getEmptyCellIndexes();

        for (Integer i : empties) {
            toString.add(Integer.toString(i));
        }

        return toString;
    }
}
