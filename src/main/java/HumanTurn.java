public class HumanTurn {

    private final Board board;
    private final UserInterface gameUI;

    public HumanTurn(Board board, UserInterface ui) {
        this.board  = board;
        this.gameUI = ui;
    }

    public int getCellIndex() {
        String cellIndex = returnEmptyCellIndex(returnValidCellIndex());
        return stringToNumber(cellIndex);
    }

    public String returnValidCellIndex() {
        String cellIndex      = gameUI.getInput();
        String validCellIndex = "[1-9]";

        while (!cellIndex.matches(validCellIndex)) {
            gameUI.printNotValidCellMessage();
            cellIndex = gameUI.getInput();
        }

        return cellIndex;
    }

    public String returnEmptyCellIndex(String cellIndex) {
        while (board.isCellBusy(stringToNumber(cellIndex))) {
            gameUI.printCellIsBusyMessage();
            cellIndex = gameUI.getInput();
        }

        return cellIndex;
    }

    public int stringToNumber(String cellIndex) {
        return Integer.parseInt(cellIndex);
    }
}
