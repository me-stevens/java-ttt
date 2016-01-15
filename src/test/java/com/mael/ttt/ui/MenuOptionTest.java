package com.mael.ttt.ui;

import org.junit.Test;

import static com.mael.ttt.ui.MenuOption.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MenuOptionTest {

    @Test
    public void getsHumanVsHumanId() {
        assertEquals("1", HUMAN_HUMAN.getInput());
    }

    @Test
    public void getsHumanVsHumanText() {
        assertEquals("Human vs. Human", HUMAN_HUMAN.getText());
    }

    @Test
    public void returnsMenuOptionGivenAnId() {
        assertEquals(HUMAN_HUMAN, inputToOption("1"));
    }

    @Test
    public void returnsHumanVsHumanIfInvalidOption() {
        assertEquals(HUMAN_HUMAN, inputToOption("asdfg"));
    }

    @Test
    public void returnsHumanVsHumanIfNullOption() {
        assertEquals(HUMAN_HUMAN, inputToOption(null));
    }

    @Test
    public void returnsTrueIfIdExistsInEnumConstants() {
        assertTrue(contains("1"));
    }

    @Test
    public void returnsFalseIfUnexistingIdInEnumConstants() {
        assertFalse(contains("asdf"));
    }
    @Test
    public void returnsFalseIfNullOption() {
        assertFalse(contains(null));
    }
}
