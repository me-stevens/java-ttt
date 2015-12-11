package com.mael.ttt.players;

import com.mael.ttt.Board;
import com.mael.ttt.Mark;

public interface Player {

    int getMove(Board board);
    Mark getMark();
}
