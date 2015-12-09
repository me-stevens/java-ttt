package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.BoardChecker;
import com.mael.ttt.ui.UserInterface;

import java.util.List;

import static com.mael.ttt.Marks.*;

public class RobotPlayer implements Player {

    private Board tempBoard;
    private UserInterface gameUI;
    private final String playerToOptimize;

    public RobotPlayer(UserInterface ui, String mark) {
        gameUI           = ui;
        playerToOptimize = mark;
    }

    public int getCellIndex(Board board) {
        tempBoard = board;
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
        tempBoard = currentBoard.getCopy();
        tempBoard.setCell(tempIndex, currentPlayer);
    }

    private boolean gameIsNotOver(String currentPlayer) {
        BoardChecker checker = new BoardChecker(tempBoard);
        return !checker.hasWinner(currentPlayer) && tempBoard.getEmptyCellIndexes().size() > 0;
    }

    private String swapMark(String currentPlayer) {
        return (currentPlayer.equals(PLAYER.getMark()) ? OPPONENT.getMark() : PLAYER.getMark());
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