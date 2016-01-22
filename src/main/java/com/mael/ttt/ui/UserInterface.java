package com.mael.ttt.ui;

import com.mael.ttt.Board;
import com.mael.ttt.Mark;

import java.util.Map;

import static com.mael.ttt.Mark.EMPTY;

public class UserInterface {

    public static final String WELCOME      = "\n --- WELCOME ---\n";
    public static final String MENUPROMPT   = "\nChoose an option:\n";
    public static final String HUMANPROMPT  = "\nChoose a cell to put your mark: ";
    public static final String ROBOTPROMT   = "\nComputer chooses a cell...\n";
    public static final String ALIENPROMPT  = "\nAlien chooses a cell\n";
    public static final String NOTVALIDCELL = "\nPlease enter a valid cell number.";
    public static final String HASWINNER    = "\nCongratulations, ";
    public static final String ISFULL       = "\nIt's a draw!";
    public static final String GAMEOVER     = "\n\n --- GAME OVER --- \n";
    public static final String REPLAY       = "\nReplay? (y/n): ";

    private Console console;

    public UserInterface(Console console) {
        this.console = console;
    }

    public void print(String message) {
        console.write(message);
    }

    public void printWelcomeMessage() {
        print(WELCOME);
    }

    public void printMenuPrompt() {
        print(MENUPROMPT);
    }

    public String formatMenuOptions(Map<String, String> options) {
        String menu = "";
        for (Map.Entry<String, String> option : options.entrySet()) {
            menu += formatOption(option);
        }
        return menu;
    }

    private String formatOption(Map.Entry<String, String> option) {
        return option.getKey()   + ") " +
               option.getValue() + "\n";
    }

    public String getMenuOption(String menu) {
        print(menu);
        return console.read();
    }

    public void printBoard(Board board) {
        int size = board.getSize();
        for (int index = 1; index <= size*size; index++) {
            print(formatCell(index, board.getCell(index)));

            if (index % size == 0) {
                print("\n");
            }
        }
    }

    private String formatCell(int index, Mark cell) {
        return (cell == EMPTY) ? index + " " : cell.getString() + " ";
    }

    public String getInput() {
        print(HUMANPROMPT);
        return console.read();
    }

    public void printNotValidCellMessage() {
        print(NOTVALIDCELL);
    }

    public void printRobotPrompt() {
        print(ROBOTPROMT);
    }

    public void printAlienPrompt() {
        print(ALIENPROMPT);
    }

    public void printHasWinnerMessage(Mark currentPlayer) {
        print(HASWINNER + currentPlayer.getString());
        print(GAMEOVER);
    }

    public void printIsFullMessage() {
        print(ISFULL);
        print(GAMEOVER);
    }

    public boolean replay() {
        print(REPLAY);
        return console.read().equals("y");
    }
}
