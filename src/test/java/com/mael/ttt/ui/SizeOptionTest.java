package com.mael.ttt.ui;

import org.junit.Test;

import java.util.List;

import static com.mael.ttt.ui.SizeOption.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class SizeOptionTest {

    @Test
    public void gets3x3Size() {
        assertEquals("3", THREE_BY_THREE.getInput());
    }

    @Test
    public void gets3x3Text() {
        assertEquals("3x3 Board", THREE_BY_THREE.getText());
    }

    @Test
    public void returnsValidSizeGivenAnInput() {
        assertEquals(FOUR_BY_FOUR, inputToOption("4"));
    }

    @Test
    public void returns3x3IfInvalidOption() {
        assertEquals(THREE_BY_THREE, inputToOption("dfasda"));
    }

    @Test
    public void returns3x3IfNullOption() {
        assertEquals(THREE_BY_THREE, inputToOption(null));
    }

    @Test
    public void returnsTrueIdInputExistsInEnum() {
        assertTrue(contains("3"));
    }

    @Test
    public void returnsFalseIfUnexistingInputInEnum() {
        assertFalse(contains("asda"));
    }

    @Test
    public void returnsFalseIfNullInput() {
        assertFalse(contains(null));
    }


    @Test
    public void getsPlayersMenuValues() {
        List<String> menuInputs = asList("3", "4");
        assertEquals(menuInputs, getAllInputs());
    }
}
