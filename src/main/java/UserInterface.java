public class UserInterface {

    private static final String WELCOME      = "\n --- WELCOME ---\n";
    private static final String PROMPT       = "\nChoose a cell to put your mark: ";
    private static final String NOTVALIDCELL = "\nPlease enter a valid cell number.";
    private static final String CELLISBUSY   = "\nPlease enter an empty cell number.";
    public  static final String GAMEOVER     = "\nGAME OVER\n";
    public  static final String REPLAY       = "\nReplay? ";

    private Console console;

    public UserInterface(Console console) {
        this.console = console;
    }

    public void print(String message) {
        console.write(message);
    }

    public void printBoard(Board board) {
        int cellIndex = 0;

        for (String[] row : board.getContents()) {
            for (String cell : row) {
                cellIndex++;
                print(formatCell(cellIndex, cell));
            }

            print("\n");
        }
    }

    private String formatCell(int cellIndex, String cell) {
        return (cell.equals("")) ? cellIndex + " " : cell + " ";
    }

    public void printWelcomeMessage() {
        print(WELCOME);
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

    public void printGameOverMessage() {
        print(GAMEOVER);
    }

    public String replay() {
        print(REPLAY);
        return console.read();
    }
}
