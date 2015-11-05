public class ConsoleUI {

    private SpyConsole console;

    public ConsoleUI(SpyConsole console) {
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
        return console.read();
    }

}
