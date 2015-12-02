package com.mael.ttt;

public class UserInterface {

    public static final String WELCOME      = "\n --- WELCOME ---\n";
    public static final String PROMPT       = "\nChoose a cell to put your mark: ";
    public static final String ROBOTPROMT   = "\nComputer chooses a cell...\n";
    public static final String ALIENPROMPT  = "\nAlien chooses a cell\n";
    public static final String NOTVALIDCELL = "\nPlease enter a valid cell number.";
    public static final String CELLISBUSY   = "\nPlease enter an empty cell number.";
    public static final String ISFULL       = "\nIt's a draw!";
    public static final String GAMEOVER     = "\n\n --- GAME OVER --- \n";
    public static final String REPLAY       = "\nReplay? (y/n): ";
    public static final String HASWINNER    = "\nCongratulations, ";

    private Console console;

    public UserInterface(Console console) {
        this.console = console;
    }

    public void print(String message) {
        console.write(message);
    }

    public void printBoard(Board board) {

        int size = board.getSize();
        for (int index = 1; index<= size * size; index++) {
            print(formatCell(index, board.getCell(index)));

            if (index % size == 0) {
                print("\n");
            }
        }
    }

    private String formatCell(int index, String cell) {
        return (cell.equals("")) ? index + " " : cell + " ";
    }

    public void printWelcomeMessage() {
        print(WELCOME);
    }

    public String getMenuOption(String menu) {
        print(menu);
        return console.read();
    }

    public String getInput() {
        print(PROMPT);
        return console.read();
    }

    public void printNotValidCellMessage() {
        print(NOTVALIDCELL);
    }

    public void printCellIsBusyMessage() {
        print(CELLISBUSY);
    }

    public void printRobotPrompt() {
        print(ROBOTPROMT);
    }

    public void printAlienPrompt() {
        print(ALIENPROMPT);
    }

    public void printHasWinnerMessage(String currentPlayer) {
        print(HASWINNER + currentPlayer);
        print(GAMEOVER);
    }

    public void printIsFullMessage() {
        print(ISFULL);
        print(GAMEOVER);
    }

    public String replay() {
        print(REPLAY);
        return console.read();
    }
}
