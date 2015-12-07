package com.mael.ttt;

public enum Marks {

    PLAYER {
        @Override
        public String toString() {
            return "X";
        }
    },

    OPPONENT {
        @Override
        public String toString() {
            return "O";
        }
    }
}
