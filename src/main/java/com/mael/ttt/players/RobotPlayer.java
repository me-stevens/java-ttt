package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.BoardChecker;
import com.mael.ttt.Mark;
import com.mael.ttt.ui.UserInterface;

import java.util.List;

public class RobotPlayer implements Player {

    private Board tempBoard;
    private UserInterface gameUI;
    private Mark mark;
    private Mark playerToOptimize;

    public RobotPlayer(UserInterface ui, Mark mark) {
        this.gameUI      = ui;
        this.mark        = mark;
        playerToOptimize = mark;
    }

    public int getMove(Board board) {
        tempBoard = board;
        gameUI.printRobotPrompt();

        int[] result = miniMax(tempBoard, playerToOptimize);
        return result[0];
    }

    public Mark getMark() {
        return mark;
    }

    private int[] miniMax(Board currentBoard, Mark currentPlayer) {
        int index = resetIndex();
        int score = resetScore(currentPlayer);

        List<Integer> empties = currentBoard.getEmptyCellIndexes();

        for (int i=0; i<empties.size(); i++) {
            int tempIndex = empties.get(i);
            int tempScore = 0;

            placeMark(currentBoard, tempIndex, currentPlayer);

            if (gameIsNotOver(currentPlayer)) {
                int[] tempResult = miniMax(tempBoard, currentPlayer.swapMark());
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

    private int resetScore(Mark currentPlayer) {
        return (currentPlayer.equals(playerToOptimize)) ? -100 : 100;
    }

    private void placeMark(Board currentBoard, int tempIndex, Mark currentPlayer) {
        tempBoard = currentBoard.getCopy();
        tempBoard.setCell(tempIndex, currentPlayer);
    }

    private boolean gameIsNotOver(Mark currentPlayer) {
        BoardChecker checker = new BoardChecker(tempBoard);
        return !checker.hasWinner(currentPlayer) && tempBoard.getEmptyCellIndexes().size() > 0;
    }

    private int heuristics(Mark currentPlayer) {
        boolean hasWinner = new BoardChecker(tempBoard).hasWinner(currentPlayer);

        if (hasWinner && currentPlayer.equals(playerToOptimize)) {
            return 10;
        }

        if (hasWinner && !currentPlayer.equals(playerToOptimize)) {
            return -10;
        }

        return 0;
    }

    private boolean betterScore(Mark currentPlayer, int score, int tempScore) {
        return (( currentPlayer.equals(playerToOptimize) ) && ( tempScore > score) ) ||
               ((!currentPlayer.equals(playerToOptimize) ) && ( tempScore < score) );
    }
}