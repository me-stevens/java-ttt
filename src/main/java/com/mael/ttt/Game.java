package com.mael.ttt;

import com.mael.ttt.players.Player;

import static com.mael.ttt.Mark.*;

public class Game {

    private Turn turn;
    private Player player;
    private Player opponent;
    private Mark currentMark;

    public Game(Turn turn, Player player, Player opponent) {
        this.turn     = turn;
        this.player   = player;
        this.opponent = opponent;
        currentMark   = PLAYER;
    }

    public void start() {
        while (turn.keepPlaying(getCurrentPlayer(), getCurrentMark())) {
            currentMark = currentMark.swapMark();
        }
    }

    private Player getCurrentPlayer() {
        return (currentMark == PLAYER) ? player : opponent;
    }

    private Mark getCurrentMark() {
        return currentMark;
    }

}