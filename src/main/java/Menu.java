public class Menu {

    private UserInterface gameUI;

    public Menu(UserInterface ui) {
        this.gameUI = ui;
    }

    public String setOption() {
        String option = "";
        while (!option.matches("[1-4]")) {
            option = gameUI.printPlayersMenu();
        }
        return option;
    }
}
