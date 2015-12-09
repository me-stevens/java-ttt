package com.mael.ttt;

public enum Marks {

    PLAYER("X"),
    OPPONENT("O");

    private String mark;

    Marks(String mark) {
        this.mark = mark;
    }

    public String getMark() {
        return mark;
    }
}
