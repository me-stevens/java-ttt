package com.mael.ttt.ui;

import com.mael.ttt.Board;
import com.mael.ttt.Mark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.mael.ttt.Mark.*;

public class UserInterfaceSpy extends UserInterface {
    private Mark winner = EMPTY;
    private boolean printWelcomeMessageWasCalled      = false;
    private boolean printMenuPromptWasCalled          = false;
    private boolean printBoardWasCalled               = false;
    private boolean printRobotPromptWasCalled         = false;
    private boolean printAlienPromptWasCalled         = false;
    private boolean printNotValidCellMessageWasCalled = false;
    private boolean printCellIsBusyMessageWasCalled   = false;
    private boolean printHasWinnerMessageWasCalled    = false;
    private boolean printIsFullMessageWasCalled       = false;
    private boolean replayWasCalled                   = false;
    private List<String>  menuOptions   = new ArrayList<>();
    private List<Integer> userInputs    = new ArrayList<>();
    private List<String>  userInputsStr = new ArrayList<>();
    private List<Boolean> replayAnswers = new ArrayList<>();
    private int timesGetInputWasCalled      = 0;
    private int timesGetMenuOptionWasCalled = 0;

    public UserInterfaceSpy() {
        super(null);
    }

    @Override
    public void print(String message) {
    }

    @Override
    public void printMenuPrompt() {
        printMenuPromptWasCalled = true;
    }

    @Override
    public String formatMenuOptions(Map<String, String> options) {
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
        timesGetMenuOptionWasCalled++;
        return menuOptions.remove(0);
    }

    @Override
    public String getInput() {
        timesGetInputWasCalled++;
        if (userInputs.size() != 0) {
            return userInputs.remove(0).toString();
        }
        else
            return userInputsStr.remove(0);
    }

    @Override
    public void printNotValidCellMessage() {
        printNotValidCellMessageWasCalled = true;
    }

    @Override
    public void printCellIsBusyMessage() {
        printCellIsBusyMessageWasCalled = true;
    }

    @Override
    public void printRobotPrompt() {
        printRobotPromptWasCalled = true;
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

    public boolean printWelcomeMessageWasCalled() {
        return printWelcomeMessageWasCalled;
    }

    public void setUserOptions(String ... menuOptions) {
        this.menuOptions.addAll(Arrays.asList(menuOptions));
    }

    public boolean printMenuPromptWasCalled() {
        return printMenuPromptWasCalled;
    }

    public int timesGetMenuOptionWasCalled() {
        return timesGetMenuOptionWasCalled;
    }

    public boolean printBoardWasCalled() {
        return printBoardWasCalled;
    }

    public boolean printRobotPromptWasCalled() {
        return printRobotPromptWasCalled;
    }

    public boolean printAlienPromptWasCalled() {
        return printAlienPromptWasCalled;
    }

    public void setUserInputs(Integer ... userInputs) {
        this.userInputs.addAll(Arrays.asList(userInputs));
    }

    public void setUserInputs(String ... userInputs) {
        this.userInputsStr.addAll(Arrays.asList(userInputs));
    }

    public int timesGetInputWasCalled() {
        return timesGetInputWasCalled;
    }

    public boolean printNotValidCellMessageWasCalled() {
        return printNotValidCellMessageWasCalled;
    }

    public boolean printCellIsBusyMessageWasCalled() {
        return printCellIsBusyMessageWasCalled;
    }

    public boolean printHasWinnerMessageWasCalled() {
        return printHasWinnerMessageWasCalled;
    }

    public boolean printIsFullMessageWasCalled() {
        return printIsFullMessageWasCalled;
    }

    public Mark announcedWinner() {
        return winner;
    }

    public void setReplayAnswers(Boolean ... replayAnswers) {
        this.replayAnswers.addAll(Arrays.asList(replayAnswers));
    }

    public boolean replayWasCalled() {
        return replayWasCalled;
    }
}
