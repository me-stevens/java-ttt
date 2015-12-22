package com.mael.ttt;

public enum Mark {

    PLAYER("X"),
    OPPONENT("O"),
    EMPTY("");

    private String mark;

    Mark(String mark) {
        this.mark = mark;
    }

    public String getString() {
        return mark;
    }

    public Mark swapMark() {
        if (this == EMPTY)
            return EMPTY;
        return (this == PLAYER) ? OPPONENT : PLAYER;
    }
}
