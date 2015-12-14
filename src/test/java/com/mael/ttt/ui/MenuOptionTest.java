package com.mael.ttt.ui;

import com.mael.ttt.players.AlienPlayer;
import com.mael.ttt.players.HumanPlayer;
import com.mael.ttt.players.RobotPlayer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static com.mael.ttt.ui.MenuOption.*;
import static com.mael.ttt.Mark.*;

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
        assertEquals("human", HUMAN_ROBOT.getPlayerType());
    }

    @Test
    public void getsOpponentType() {
        assertEquals("robot", HUMAN_ROBOT.getOpponentType());
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
    public void createsAHuman() {
        assertEquals(true, MenuOption.createPlayer("human", gameUI, PLAYER) instanceof HumanPlayer);
    }

    @Test
    public void createsARobot() {
        assertEquals(true, MenuOption.createPlayer("robot", gameUI, PLAYER) instanceof RobotPlayer);
    }

    @Test
    public void createsAnAlien() {
        assertEquals(true, MenuOption.createPlayer("alien", gameUI, PLAYER) instanceof AlienPlayer);
    }
}
