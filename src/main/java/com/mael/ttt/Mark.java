package com.mael.ttt;

public enum Mark {

    PLAYER("X"),
    OPPONENT("O");

    private String mark;

    Mark(String mark) {
        this.mark = mark;
    }

    public String getString() {
        return mark;
    }

    public Mark swapMark() {
        return (this == PLAYER) ? OPPONENT : PLAYER;
    }
}
