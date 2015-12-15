package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.Mark;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mael.ttt.Mark.PLAYER;

public class FakePlayer implements Player {
    private Mark mark;
    private List<Integer> moves = new ArrayList<>();

    public FakePlayer(Integer ... moves) {
        this(PLAYER, moves);
    }

    public FakePlayer(Mark mark, Integer ... moves) {
        this.mark = mark;
        this.moves.addAll(Arrays.asList(moves));
    }

    @Override
    public int getMove(Board board) {
        return moves.remove(0);
    }

    @Override
    public Mark getMark() {
        return mark;
    }

    @Override
    public PlayerType getType() {
        return null;
    }
}
