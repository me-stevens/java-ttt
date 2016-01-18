package com.mael.ttt.ui;

import org.junit.Test;

import java.util.Map;

import static com.mael.ttt.ui.MenuOption.HUMAN_HUMAN;
import static com.mael.ttt.ui.MenuOption.convertToOption;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        assertEquals(HUMAN_HUMAN, convertToOption("1"));
    }

    @Test
    public void returnsHumanVsHumanIfInvalidOption() {
        assertEquals(HUMAN_HUMAN, convertToOption("asdfg"));
    }

    @Test
    public void returnsHumanVsHumanIfNullOption() {
        assertEquals(HUMAN_HUMAN, convertToOption(null));
    }

    @Test
    public void getsPlayersMenuTexts() {
        Map<String, String> playerOptions = MenuOption.getPlayerOptions();
        assertTrue(playerOptions.containsKey("1"));
        assertTrue(playerOptions.containsValue("Human vs. Human"));
    }
}
