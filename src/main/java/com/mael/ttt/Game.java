package com.mael.ttt;

import com.mael.ttt.players.Player;

import static com.mael.ttt.Mark.*;

public class Game {

    private Turn turn;
    private Player player;
    private Player opponent;
    private Player currentPlayer;

    public Game(Turn turn, Player player, Player opponent) {
        this.turn     = turn;
        this.player   = player;
        this.opponent = opponent;
        currentPlayer = player;
    }

    public void start() {
        while (turn.keepPlaying(getCurrentPlayer())) {
            swapPlayers();
        }
    }

    private Player getCurrentPlayer() {
        return currentPlayer;
    }

    private void swapPlayers() {
        currentPlayer = (currentPlayer.getMark() == PLAYER) ? opponent : player;
    }
}