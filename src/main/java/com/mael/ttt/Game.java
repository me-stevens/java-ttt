package com.mael.ttt;

import com.mael.ttt.players.Player;

public class Game {

    private Turn turn;
    private Player lastPlayer;
    private Player currentPlayer;

    public Game(Turn turn, Player player, Player opponent) {
        this.turn          = turn;
        this.currentPlayer = player;
        this.lastPlayer    = opponent;
    }

    public void start() {
        while (turn.canBePlayed()) {
            turn.placeMark(getCurrentPlayer());
            swapPlayers();
        }

        turn.printResults(lastPlayer.getMark());
    }

    private Player getCurrentPlayer() {
        return currentPlayer;
    }

    private void swapPlayers() {
        Player temp   = currentPlayer;
        currentPlayer = lastPlayer;
        lastPlayer    = temp;
    }
}
