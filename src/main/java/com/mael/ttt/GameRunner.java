package com.mael.ttt;

public class GameRunner {

    public static void main(String[] args) {
        Game game = new Game(new Board(3), new UserInterface(new GameConsole(System.in, System.out)));
        game.run();
    }

}
