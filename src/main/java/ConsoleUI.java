public class ConsoleUI {

    private static final String PROMPT   = "Choose a cell to put your mark";
    public static final String GAMEOVER  = "GAME OVER";
    private Console console;

    public ConsoleUI(Console console) {
        this.console = console;
    }

    public void print(String message) {
        console.write(message);
    }

    public void printBoard(Board board) {
        int cellIndex = 0;

        for (String[] row : board.copy()) {
            for (String cell : row) {
                cellIndex++;
                printCell(cellIndex, cell);
            }
            print("\n");
        }
    }

    private void printCell(int cellIndex, String cell) {
        if (cell.equals("")) {
            print(cellIndex + " ");
        }
        else {
            print(cell + " ");
        }
    }

    public String getInput() {
        print(PROMPT);
        return console.read();
    }

    public void printGameOverMessage() {
        print(GAMEOVER);
    }


    public String checkUserInput(String regex) {
        String cellNumber = "";

        while( !cellNumber.matches(regex) ) {
            cellNumber = getInput();
        }

        return cellNumber;
    }
}
