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

    public boolean checkWinnerInLine(String[] line) {

        for (int i=0; i<line.length-1; i++) {
            if ( line[i].equals("") || !line[i].equals(line[i+1]) ) {
                return false;
            }
        }

        return true;
    }

}
