package com.mael.ttt.ui;

import org.junit.Test;

import static com.mael.ttt.ui.SizeOption.*;
import static org.junit.Assert.assertEquals;

public class SizeOptionTest {

    @Test
    public void gets3x3Size() {
        assertEquals("3", THREE_BY_THREE.getInput());
    }

    @Test
    public void gets3x3Text() {
        assertEquals("3x3 Board", THREE_BY_THREE.getText());
    }
}
