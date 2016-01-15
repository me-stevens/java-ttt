package com.mael.ttt.ui;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class SizeMenuTest {

    private UserInterfaceSpy uiSpy;
    private SizeMenu menu;

    @Before
    public void setUp() {
        uiSpy = new UserInterfaceSpy();
        menu  = new SizeMenu(uiSpy);
    }

    @Test
    public void showMenuUntilRightOption() {
        uiSpy.setUserOptions("khjjkh", "0", "3");
        menu.getUserOption();
        assertEquals(3, uiSpy.timesGetMenuOptionWasCalled());
    }

    @Test
    public void returnsTheRightOption() {
        uiSpy.setUserOptions("3");
        assertEquals(SizeOption.inputToOption("3"), menu.getUserOption());
    }

    @Test
    public void printsMenuPrompt() {
        uiSpy.setUserOptions("3");
        menu.getUserOption();
        assertTrue(uiSpy.printMenuPromptWasCalled());
    }
}
