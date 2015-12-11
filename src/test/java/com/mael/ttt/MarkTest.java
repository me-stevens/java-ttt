package com.mael.ttt;

import org.junit.Test;

import static com.mael.ttt.Mark.*;
import static org.junit.Assert.assertEquals;

public class MarkTest {

    @Test
    public void convertsPlayerMarkToString() {
        assertEquals("X", PLAYER.getString());
    }

    @Test
    public void convertsOpponentMarkToString() {
        assertEquals("O", OPPONENT.getString());
    }

}
