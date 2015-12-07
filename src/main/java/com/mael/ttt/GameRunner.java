package com.mael.ttt;

import com.mael.ttt.ui.GameConsole;
import com.mael.ttt.ui.UserInterface;

public class GameRunner {

    public static void main(String[] args) {
        Game game = new Game(new Board(3), new UserInterface(new GameConsole(System.in, System.out)));
        game.run();
    }
}
