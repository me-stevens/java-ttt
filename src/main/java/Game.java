public class Game {

    private Board board = new Board(2);

    public Board getBoard() {
        return board;
    }

    public void updateBoard(int i, int j, String mark) {
        board.setCell(i, j, mark);
    }


}
