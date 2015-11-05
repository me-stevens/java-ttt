public class Board {

    private final int SIZE;
    private String[][] board;

    public Board (int size) {
        SIZE  = size;
        board = new String[SIZE][SIZE];
        reset();
    }

    public void setCell(int i, int j, String cellContent) throws IndexOutOfBoundsException, NullPointerException {
        if (cellContent == null) {
            throw new NullPointerException();
        }

        board[i][j] = cellContent;
    }

    public String getCell(int i, int j) throws IndexOutOfBoundsException {
        return board[i][j];
    }

    public int getSize() {
        return SIZE;
    }

    public String[][] copy () {
        String[][] copy = new String[SIZE][SIZE];

        for(int i=0; i<SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                copy[i][j] = board[i][j];
            }
        }

        return copy;
    }

    public void reset() {
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                board[i][j] = "";
            }
        }
    }

    //---------------------------------
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

    public boolean checkWinnerInRow(int row, String mark) {
        for (int j = 0; j < SIZE; j++) {
            if ( !board[row][j].equals(mark) ) {
                return false;
            }
        }

        return true;
    }

    public boolean checkWinnerInColumn(int col, String mark) {
        for (int i = 0; i < SIZE; i++) {
            if ( !board[i][col].equals(mark) ) {
                return false;
            }
        }

        return true;
    }

    public boolean checkWinnerInDiagonal(String mark) {
        for (int i = 0, j = 0; i < SIZE && j < SIZE; i++, j++) {
            if ( !board[i][j].equals(mark) ) {
                return false;
            }
        }

        return true;
    }

    public boolean checkWinnerInAntiDiagonal(String mark) {
        for (int i = 0, j = SIZE-1; i < SIZE && j >= 0; i++, j--) {
            if ( !board[i][j].equals(mark) ) {
                return false;
            }
        }

        return true;
    }

    public boolean hasWinner(String mark) {

        for (int i = 0; i < SIZE; i++) {
            if (checkWinnerInRow(i, mark)) {
                return true;
            }
        }

        for (int i = 0; i < SIZE; i++) {
            if (checkWinnerInColumn(i, mark)) {
                return true;
            }
        }

        return checkWinnerInDiagonal(mark) || checkWinnerInAntiDiagonal(mark);
    }

    public boolean isCellBusy(int i, int j) {
        if ( board[i][j].equals("") ) {
            return false;
        }

        return true;
    }
}
