package com.mael.ttt.ui;

import org.junit.Before;
import org.junit.Test;

import static com.mael.ttt.players.PlayerType.*;
import static com.mael.ttt.ui.MenuOption.*;
import static org.junit.Assert.assertEquals;

public class MenuOptionTest {

    private UserInterface gameUI;

    @Before
    public void setUp() {
        gameUI = new UserInterface(new SpyConsole());
    }

    @Test
    public void getsHumanVsHumanId() {
        assertEquals("1", HUMAN_HUMAN.getMenuOptionId());
    }

    @Test
    public void getsHumanVsHumanText() {
        assertEquals("Human vs. Human", HUMAN_HUMAN.getMenuOptionText());
    }

    @Test
    public void getsPlayerType() {
        assertEquals(HUMAN, HUMAN_ROBOT.getPlayerType());
    }

    @Test
    public void getsOpponentType() {
        assertEquals(ROBOT, HUMAN_ROBOT.getOpponentType());
    }

    @Test
    public void returnsMenuOptionGivenAnId() {
        assertEquals(HUMAN_ROBOT, MenuOption.idToOption("2"));
    }

    @Test
    public void returnsHumanVsHumanIfInvalidOption() {
        assertEquals(HUMAN_HUMAN, MenuOption.idToOption("asdfg"));
    }
}
