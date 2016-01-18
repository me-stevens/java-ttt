package com.mael.ttt.ui;

import org.junit.Test;

import java.util.List;

import static com.mael.ttt.ui.MenuOption.*;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class MenuOptionTest {

    @Test
    public void getsHumanVsHumanId() {
        assertEquals("1", HUMAN_HUMAN.getOption());
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
    public void getsPlayersMenuValues() {
        List<String> menuInputs = asList("1", "2", "3", "4");
        assertEquals(menuInputs, getAllInputs());
    }
}
