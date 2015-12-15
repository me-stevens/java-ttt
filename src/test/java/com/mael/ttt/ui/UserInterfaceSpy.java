package com.mael.ttt.ui;

import com.mael.ttt.Board;

public class UserInterfaceSpy extends UserInterface {
    private boolean printBoardHasBeenCalled = false;
    private boolean printHasWinnerMessageHasBeenCalled = false;
    private boolean printIsFullMessageHasBeenCalled = false;
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
        printBoardHasBeenCalled = true;
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
        printHasWinnerMessageHasBeenCalled = true;
    }

    @Override
    public void printIsFullMessage() {
        printIsFullMessageHasBeenCalled = true;
    }

    @Override
    public String replay() {
        return "";
    }

    public boolean printBoardHasBeeCalled() {
        return printBoardHasBeenCalled;
    }

    public boolean printHasWinnerMessageHasBeenCalled() {
        return printHasWinnerMessageHasBeenCalled;
    }

    public boolean printIsFullMessageHasBeenCalled() {
        return printIsFullMessageHasBeenCalled;
    }

    public String announcedWinner() {
        return winner;
    }
}
