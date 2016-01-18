package com.mael.ttt.ui;

import org.junit.Test;

import java.util.Map;

import static com.mael.ttt.ui.SizeOption.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SizeOptionTest {

    @Test
    public void gets3x3Size() {
        assertEquals("3", THREE_BY_THREE.getOption());
    }

    @Test
    public void gets3x3Text() {
        assertEquals("3x3 Board", THREE_BY_THREE.getText());
    }

    @Test
    public void returnsValidSizeGivenAnInput() {
        assertEquals(FOUR_BY_FOUR, convertToOption("4"));
    }

    @Test
    public void returns3x3IfInvalidOption() {
        assertEquals(THREE_BY_THREE, convertToOption("dfasda"));
    }

    @Test
    public void returns3x3IfNullOption() {
        assertEquals(THREE_BY_THREE, convertToOption(null));
    }

    @Test
    public void knowsAllOptions() {
        Map<String, String> options = SizeOption.getSizeOptions();

        assertTrue(options.containsKey("3"));
        assertTrue(options.containsValue("3x3 Board"));
    }

    @Test
    public void returnsBoardSize() {
        assertEquals(3, THREE_BY_THREE.getBoardSize());
        assertEquals(4, FOUR_BY_FOUR.getBoardSize());
    }
}
