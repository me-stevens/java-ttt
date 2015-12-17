package com.mael.ttt.ui;

import com.mael.ttt.Board;

public class UserInterfaceSpy extends UserInterface {
    private boolean printBoardWasCalled = false;
    private boolean printHasWinnerMessageWasCalled = false;
    private boolean printIsFullMessageWasCalled = false;
    private String winner = "";

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
    }

    @Override
    public String getMenuOption(String menu) {
        return "";
    }

    @Override
    public String getInput() {
        return "1";
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
    }

    @Override
    public void printHasWinnerMessage(String currentPlayer) {
        winner = currentPlayer;
        printHasWinnerMessageWasCalled = true;
    }

    @Override
    public void printIsFullMessage() {
        printIsFullMessageWasCalled = true;
    }

    @Override
    public String replay() {
        return "";
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

    public String announcedWinner() {
        return winner;
    }
}
