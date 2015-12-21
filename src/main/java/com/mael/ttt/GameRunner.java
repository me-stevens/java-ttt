
package com.mael.ttt;

import com.mael.ttt.players.PlayerCreator;
import com.mael.ttt.ui.GameConsole;
import com.mael.ttt.ui.Menu;
import com.mael.ttt.ui.UserInterface;

public class GameRunner {

    public static void main(String[] args) {
        UserInterface gameUI = new UserInterface(new GameConsole(System.in, System.out));
        Board board          = new Board(3);
        GameSetup gameSetup  = new GameSetup(gameUI, new Menu(gameUI), board, new Turn(board, new BoardChecker(board), gameUI), new PlayerCreator(gameUI));
        gameSetup.playGame();
    }
}