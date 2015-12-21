package com.mael.ttt.ui;

import org.junit.Test;

import static com.mael.ttt.ui.MenuOption.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MenuOptionTest {

    @Test
    public void getsHumanVsHumanId() {
        assertEquals("1", HUMAN_HUMAN.getMenuOptionId());
    }

    @Test
    public void getsHumanVsHumanText() {
        assertEquals("Human vs. Human", HUMAN_HUMAN.getMenuOptionText());
    }

    @Test
    public void returnsMenuOptionGivenAnId() {
        assertEquals(HUMAN_ROBOT, MenuOption.idToOption("2"));
    }

    @Test
    public void returnsHumanVsHumanIfInvalidOption() {
        assertEquals(HUMAN_HUMAN, MenuOption.idToOption("asdfg"));
    }

    @Test
    public void returnsTrueIfIdExistsInEnumConstants() {
        assertTrue(MenuOption.contains("1"));
    }

    @Test
    public void returnsFalseIfUnexistingIdInEnumConstants() {
        assertFalse(MenuOption.contains("asdf"));
    }
}
