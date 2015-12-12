package com.mael.ttt.ui;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static com.mael.ttt.ui.menu.MenuOption.*;

public class MenuOptionsTest {

    @Test
    public void getsHumanVsHumanId() {
        assertEquals("1", HUMAN_HUMAN.getMenuOptionId());
    }

    @Test
    public void getsHumanVsHumanText() {
        assertEquals("Human vs. Human", HUMAN_HUMAN.getMenuOptionText());
    }
}
