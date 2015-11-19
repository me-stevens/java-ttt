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

    public Player[] setPlayers(String option) {
        Player player1;
        Player player2;

        switch (option.charAt(0)) {
            case '1':
                player1 = new HumanPlayer(gameUI, "X");
                player2 = new HumanPlayer(gameUI, "O");
                break;
            case '2':
                player1 = new HumanPlayer(gameUI, "X");
                player2 = new RobotPlayer(gameUI, "O");
                break;
            case '3':
                player1 = new RobotPlayer(gameUI, "X");
                player2 = new RobotPlayer(gameUI, "O");
                break;
            case '4':
                player1 = new HumanPlayer(gameUI, "X");
                player2 = new AlienPlayer(gameUI, "O");
                break;
            default:
                player1 = null;
                player2 = null;
                break;
        }

        return new Player[] {player1, player2};
    }
}
