import java.util.List;

public class RobotTurn {

    private Board tempBoard;
    private int size;
    private UserInterface gameUI;
    private final String playerToOptimize;

    public RobotTurn(Board board, UserInterface ui, String currentPlayer) {
        tempBoard        = board;
        size             = board.getSize();
        gameUI           = ui;
        playerToOptimize = currentPlayer;
    }

    public int getCellIndex() {
        gameUI.printRobotPrompt();

        int[] result = miniMax(tempBoard, playerToOptimize);
        return result[0];
    }

    private int[] miniMax(Board currentBoard, String currentPlayer) {
        int index = resetIndex();
        int score = resetScore(currentPlayer);

        List<Integer> empties = currentBoard.getEmptyCellIndexes();

        for (int i=0; i<empties.size(); i++) {
            int tempIndex = empties.get(i);
            int tempScore = 0;

            placeMark(currentBoard, tempIndex, currentPlayer);

            if (gameIsNotOver(currentPlayer)) {
                int[] tempResult = miniMax(tempBoard, swapMark(currentPlayer));
                tempScore = tempResult[1];
            } else {
                tempScore = heuristics(currentPlayer);
            }

            if (betterScore(currentPlayer, score, tempScore)) {
                index = tempIndex;
                score = tempScore;
            }
        }

        return new int[] {index, score};
    }

    private int resetIndex() {
        return -1;
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