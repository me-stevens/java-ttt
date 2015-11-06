public class BoardChecker {

    private int size;
    private Board board;

    public BoardChecker(Board board) {
        this.board = board;
        size       = board.getSize();
    }

    public boolean checkWinnerInRow(int row, String mark) {
        for (int j = 0; j < size; j++) {
            if ( !board.getCell(row, j).equals(mark) ) {
                return false;
            }
        }

        return true;
    }

    public boolean checkWinnerInColumn(int col, String mark) {
        for (int i = 0; i < size; i++) {
            if ( !board.getCell(i, col).equals(mark) ) {
                return false;
            }
        }

        return true;
    }

    public boolean checkWinnerInDiagonal(String mark) {
        for (int i = 0, j = 0; i < size && j < size; i++, j++) {
            if ( !board.getCell(i, j).equals(mark) ) {
                return false;
            }
        }

        return true;
    }

    public boolean checkWinnerInAntiDiagonal(String mark) {
        for (int i = 0, j = size-1; i < size && j >= 0; i++, j--) {
            if ( !board.getCell(i, j).equals(mark) ) {
                return false;
            }
        }

        return true;
    }

    public boolean hasWinner(String mark) {

        for (int i = 0; i < size; i++) {
            if (checkWinnerInRow(i, mark)) {
                return true;
            }
        }

        for (int i = 0; i < size; i++) {
            if (checkWinnerInColumn(i, mark)) {
                return true;
            }
        }

        return checkWinnerInDiagonal(mark) || checkWinnerInAntiDiagonal(mark);
    }
}
