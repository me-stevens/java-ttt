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

    public boolean checkWinnerInRow(int row) {
        for (int j = 0; j < SIZE-1; j++) {
            if ( checkCells(board[row][j], board[row][j+1]) ) {
                return false;
            }
        }

        return true;
    }

    public boolean checkWinnerInColumn(int col) {
        for (int i = 0; i < SIZE-1; i++) {
            if ( checkCells(board[i][col], board[i+1][col]) ) {
                return false;
            }
        }

        return true;
    }

    public boolean checkWinnerInDiagonal() {
        for (int i = 0, j = 0; i < SIZE-1 && j < SIZE-1; i++, j++) {
            if ( checkCells(board[i][j], board[i+1][j+1]) ) {
                return false;
            }
        }

        return true;
    }

    public boolean checkWinnerInAntiDiagonal() {
        for (int i = 0, j = SIZE-1; i < SIZE-1 && j > 0; i++, j--) {
            if ( checkCells(board[i][j], board[i+1][j-1]) ) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCells(String c1, String c2) {
        return c1.equals("") || !c1.equals(c2);
    }

    public boolean hasWinner() {

        for (int i = 0; i < SIZE; i++) {
            if (checkWinnerInRow(i)) {
                return true;
            }
        }

        for (int i = 0; i < SIZE; i++) {
            if (checkWinnerInColumn(i)) {
                return true;
            }
        }

        return checkWinnerInDiagonal() || checkWinnerInAntiDiagonal();
    }
}
