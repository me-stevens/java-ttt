public class Board {

    private final int SIZE;
    private String[][] board;

    public Board (int size) {
        SIZE  = size;
        board = new String[SIZE][SIZE];
        reset();
    }

    public void setCell(int index, String cellContent) {
        board[getRowFromIndex(index)][getColFromIndex(index)] = cellContent;
    }

    public String getCell(int index) {
        return board[getRowFromIndex(index)][getColFromIndex(index)];
    }

    public int getSize() {
        return SIZE;
    }

    public String[][] copy() {
        String[][] copy = new String[SIZE][SIZE];

        for(int row=0; row<SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                copy[row][col] = board[row][col];
            }
        }

        return copy;
    }

    public void reset() {
        for (int row=0; row<SIZE; row++) {
            for (int col=0; col<SIZE; col++) {
                board[row][col] = "";
            }
        }
    }

    public boolean isFull() {
        return numberOfEmpties() == 0;
    }

    private int numberOfEmpties() {
        int empties = 0;

        for (String[] row : board) {
            for (String cell : row) {
                if (cell.equals("")) {
                    empties++;
                }
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
        if ( board[getRowFromIndex(index)][getColFromIndex(index)].equals("") ) {
            return false;
        }

        return true;
    }
}
