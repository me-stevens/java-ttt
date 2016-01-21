import java.util.List;

public class RobotTurn {

    private Board tempBoard;
    private final String playerToOptimize;
    private int size;

    public RobotTurn(Board board, String currentPlayer) {
        tempBoard        = board;
        playerToOptimize = currentPlayer;
        size             = board.getSize();
    }

    public int getCellIndex() {
        UserInterface gameUI = new UserInterface(new GameConsole(System.in, System.out));
        gameUI.printRobotPrompt();

        int[] result = miniMax(tempBoard, playerToOptimize);
        return result[0];
    }

    private int[] miniMax(Board currentBoard, String currentPlayer) {
        int index = -1;
        int score = resetScore(currentPlayer);

        List<Integer> possibleMoves = currentBoard.getEmptyCellIndexes();

        for(int possibleMove : possibleMoves) {
            int tempScore = 0;

            placeMark(currentBoard, possibleMove, currentPlayer);

            if (gameIsNotOver(currentPlayer)) {
                int[] tempResult = miniMax(tempBoard, swapMark(currentPlayer));
                tempScore = tempResult[1];
            } else {
                tempScore = heuristics(currentPlayer);
            }

            if (betterScore(currentPlayer, score, tempScore)) {
                index = possibleMove;
                score = tempScore;
            }
        }

        return new int[] {index, score};
    }

    private int resetScore(String currentPlayer) {
        return (currentPlayer.equals(playerToOptimize)) ? -100 : 100;
    }

    private void placeMark(Board currentBoard, int tempIndex, String currentPlayer) {
        tempBoard = new Board(size);
        tempBoard.setContents(currentBoard.getContents());
        tempBoard.setCell(tempIndex, currentPlayer);
    }

    private boolean gameIsNotOver(String currentPlayer) {
        BoardChecker checker = new BoardChecker(tempBoard);
        return !checker.hasWinner(currentPlayer) && tempBoard.getEmptyCellIndexes().size() > 0;
    }

    private String swapMark(String currentPlayer) {
        return (currentPlayer.equals("X") ? "O" : "X");
    }

    private int heuristics(String currentPlayer) {
        boolean hasWinner = new BoardChecker(tempBoard).hasWinner(currentPlayer);

        if (hasWinner && currentPlayer.equals(playerToOptimize)) {
            return 10;
        }

        if (hasWinner && !currentPlayer.equals(playerToOptimize)) {
            return -10;
        }

        return 0;
    }

    private boolean betterScore(String currentPlayer, int score, int tempScore) {
        return (( currentPlayer.equals(playerToOptimize) ) && ( tempScore > score) ) ||
               ((!currentPlayer.equals(playerToOptimize) ) && ( tempScore < score) );
    }
}