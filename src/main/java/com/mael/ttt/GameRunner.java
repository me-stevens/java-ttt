package com.mael.ttt;

import com.mael.ttt.ui.GameConsole;
import com.mael.ttt.ui.UserInterface;

public class GameRunner {

    public static void main(String[] args) {
        GameSetup gameSetup = new GameSetup(new UserInterface(new GameConsole(System.in, System.out)));
        gameSetup.setUp();
        gameSetup.playGame();
    }
}
