public class HumanTurn implements Player {

    private final Board board;
    private final UserInterface gameUI;

    public HumanTurn(Board board, UserInterface ui, String mark) {
        this.board  = board;
        this.gameUI = ui;
    }

    public int getCellIndex() {
        String cellIndex = returnEmptyCellIndex(returnValidCellIndex());
        return stringToNumber(cellIndex);
    }

    private String returnValidCellIndex() {
        String cellIndex      = gameUI.getInput();
        String validCellIndex = "[1-9]";

        while (!cellIndex.matches(validCellIndex)) {
            gameUI.printNotValidCellMessage();
            cellIndex = gameUI.getInput();
        }

        return cellIndex;
    }

    private String returnEmptyCellIndex(String cellIndex) {
        while (board.isCellBusy(stringToNumber(cellIndex))) {
            gameUI.printCellIsBusyMessage();
            cellIndex = gameUI.getInput();
        }

        return cellIndex;
    }

    private int stringToNumber(String cellIndex) {
        return Integer.parseInt(cellIndex);
    }
}
