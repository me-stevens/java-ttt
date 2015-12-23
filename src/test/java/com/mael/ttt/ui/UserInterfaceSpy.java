package com.mael.ttt.ui;

import com.mael.ttt.Board;
import com.mael.ttt.Mark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mael.ttt.Mark.*;

public class UserInterfaceSpy extends UserInterface {
    private boolean printBoardWasCalled = false;
    private boolean printHasWinnerMessageWasCalled = false;
    private boolean printIsFullMessageWasCalled = false;
    private Mark winner = EMPTY;
    private boolean printWelcomeMessageWasCalled = false;
    private List<Integer> userInputs = new ArrayList<>();
    private String menuOption = "";
    private boolean replayWasCalled = false;
    private List<Boolean> replayAnswers = new ArrayList<>();
    private boolean printAlienPromptWasCalled = false;

    public UserInterfaceSpy() {
        super(null);
    }

    @Override
    public void print(String message) {
    }

    @Override
    public void printMenuPrompt() {
    }

    @Override
    public String formatMenuOptions() {
        return "";
    }

    @Override
    public void printBoard(Board board) {
        printBoardWasCalled = true;
    }

    @Override
    public void printWelcomeMessage() {
        printWelcomeMessageWasCalled = true;
    }

    @Override
    public String getMenuOption(String menu) {
        return menuOption;
    }

    @Override
    public String getInput() {
        return userInputs.remove(0).toString();
    }

    @Override
    public void printNotValidCellMessage() {
    }

    @Override
    public void printCellIsBusyMessage() {
    }

    @Override
    public void printRobotPrompt() {
    }

    @Override
    public void printAlienPrompt() {
        printAlienPromptWasCalled = true;
    }

    @Override
    public void printHasWinnerMessage(Mark currentPlayer) {
        winner = currentPlayer;
        printHasWinnerMessageWasCalled = true;
    }

    @Override
    public void printIsFullMessage() {
        printIsFullMessageWasCalled = true;
    }

    @Override
    public boolean replay() {
        replayWasCalled = true;
        return replayAnswers.remove(0);
    }

    public boolean printBoardWasCalled() {
        return printBoardWasCalled;
    }

    public boolean printHasWinnerMessageWasCalled() {
        return printHasWinnerMessageWasCalled;
    }

    public boolean printIsFullMessageWasCalled() {
        return printIsFullMessageWasCalled;
    }

    public boolean printWelcomeMessageWasCalled() {
        return printWelcomeMessageWasCalled;
    }

    public Mark announcedWinner() {
        return winner;
    }

    public void setReplayAnswers(Boolean ... replayAnswers) {
        this.replayAnswers.addAll(Arrays.asList(replayAnswers));
    }

    public void setUserInputs(Integer ... userInputs) {
        this.userInputs.addAll(Arrays.asList(userInputs));
    }

    public void setMenuOption (String menuOption) {
        this.menuOption = menuOption;
    }

    public boolean replayWasCalled() {
        return replayWasCalled;
    }

    public boolean printAlienPromptWasCalled() {
        return printAlienPromptWasCalled;
    }
}
