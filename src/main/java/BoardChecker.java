public class BoardChecker {

    private int size;
    private Board board;

    public BoardChecker(Board board) {
        this.board = board;
        size       = board.getSize();
    }

    public boolean hasWinner(String mark) {

        for (int row = 0; row < size; row++) {
            if (checkWinnerInRow(row, mark)) {
                return true;
            }
        }

        for (int col = 0; col < size; col++) {
            if (checkWinnerInColumn(col, mark)) {
                return true;
            }
        }

        return checkWinnerInDiagonal(mark) || checkWinnerInAntiDiagonal(mark);
    }

    private boolean checkWinnerInRow(int row, String mark) {
        for (int col = 0; col < size; col++) {
            if (cellIsNotMark(row, col, mark)) {
                return false;
            }
        }

        return true;
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
}
