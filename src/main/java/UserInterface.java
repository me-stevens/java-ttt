public class UserInterface {

    private static final String WELCOME      = "\n --- WELCOME ---\n";
    private static final String PROMPT       = "\nChoose a cell to put your mark: ";
    private static final String NOTVALIDCELL = "\nPlease enter a valid cell number.";
    private static final String CELLISBUSY   = "\nPlease enter an empty cell number.";
    public  static final String GAMEOVER     = "\nGAME OVER\n";

    private Console console;

    public UserInterface(Console console) {
        this.console = console;
    }

    public void print(String message) {
        console.write(message);
    }

    public String printBoard(Board board) {
        int cellIndex   = 0;
        String boardStr = "";

        for (String[] row : board.copy()) {
            for (String cell : row) {
                cellIndex++;
                boardStr += formatCell(cellIndex, cell);
            }

            boardStr += "\n";
        }

        print(boardStr);
        return boardStr;
    }

    private String formatCell(int cellIndex, String cell) {
        return (cell.equals("")) ? cellIndex + " " : cell + " ";
    }

    public String getInput(String playerName) {
        print(playerName + ": " + PROMPT);
        return console.read();
    }

    public void printWelcomeMessage() {
        print(WELCOME);
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
}
