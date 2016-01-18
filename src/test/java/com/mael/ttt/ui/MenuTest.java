package com.mael.ttt.ui;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuTest {

    private Menu menu;
    private UserInterfaceSpy uiSpy;

    @Before
    public void setUp() {
        uiSpy = new UserInterfaceSpy();
        menu  = new Menu(uiSpy);
    }

    @Test
    public void showsPlayersMenuUntilRightOption() {
        uiSpy.setUserOptions(null, "khgj", "0", "1");
        menu.getPlayerOption();
        assertEquals(4, uiSpy.timesGetMenuOptionWasCalled());
    }

    @Test
    public void returnsTheRightOption() {
        uiSpy.setUserOptions("1");
        assertEquals(PlayerOption.convertToOption("1"), menu.getPlayerOption());
    }

    @Test
    public void printsMenuPrompt() {
        uiSpy.setUserOptions("1");
        menu.getPlayerOption();
        assertTrue(uiSpy.printMenuPromptWasCalled());
    }

    @Test
    public void showsSizeMenuUntilRightOption() {
        uiSpy.setUserOptions(null, "ksdjfh", "1", "3");
        menu.getSizeOption();
        assertEquals(4, uiSpy.timesGetMenuOptionWasCalled());
    }

    @Test
    public void returnsTheRightSizeOption() {
        uiSpy.setUserOptions("3");
        assertEquals(SizeOption.convertToOption("3"), menu.getSizeOption());
    }

    @Test
    public void printsMenuPromptForSizeOptions() {
        uiSpy.setUserOptions("3");
        menu.getSizeOption();
        assertTrue(uiSpy.printMenuPromptWasCalled());
    }
}
