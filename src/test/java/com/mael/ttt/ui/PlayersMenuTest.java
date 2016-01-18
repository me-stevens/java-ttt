package com.mael.ttt.ui;

import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PlayersMenuTest {

    private PlayersMenu menu;
    private UserInterfaceSpy uiSpy;

    @Before
    public void setUp() {
        uiSpy = new UserInterfaceSpy();
        menu  = new PlayersMenu(uiSpy);
    }

    @Test
    public void showPlayersMenuUntilRightOption() {
        uiSpy.setUserOptions("khgj", "0", "1");
        menu.getUserOption();
        assertEquals(3, uiSpy.timesGetMenuOptionWasCalled());
    }

    @Test
    public void returnsTheRightOption() {
        uiSpy.setUserOptions("1");
        assertEquals(MenuOption.inputToOption("1"), menu.getUserOption());
    }

    @Test
    public void printsMenuPrompt() {
        uiSpy.setUserOptions("1");
        menu.getUserOption();
        assertTrue(uiSpy.printMenuPromptWasCalled());
    }
}
