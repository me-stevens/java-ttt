package com.mael.ttt.players;

import com.mael.ttt.ui.SpyConsole;
import com.mael.ttt.ui.UserInterface;
import org.junit.Before;
import org.junit.Test;

import static com.mael.ttt.ui.MenuOption.*;
import static org.junit.Assert.assertTrue;

public class PlayerCreatorTest {

    private PlayerCreator playerCreator;
    private UserInterface gameUI;

    @Before
    public void setUp() {
        gameUI = new UserInterface(new SpyConsole());
        playerCreator = new PlayerCreator(gameUI);
    }

    @Test
    public void createsHumanAsPlayer() {
        assertTrue(playerCreator.createPlayer(HUMAN_HUMAN) instanceof HumanPlayer);
        assertTrue(playerCreator.createPlayer(HUMAN_ROBOT) instanceof HumanPlayer);
        assertTrue(playerCreator.createPlayer(HUMAN_ALIEN) instanceof HumanPlayer);
    }

    @Test
    public void createsHumanAsOpponent() {
        assertTrue(playerCreator.createOpponent(HUMAN_HUMAN) instanceof HumanPlayer);
    }

    @Test
    public void createsRobotAsPlayer() {
        assertTrue(playerCreator.createPlayer(ROBOT_ROBOT) instanceof RobotPlayer);
    }

    @Test
    public void createsRobotAsOpponent() {
        assertTrue(playerCreator.createOpponent(HUMAN_ROBOT) instanceof RobotPlayer);
    }

    @Test
    public void createsAlienAsOpponent() {
        assertTrue(playerCreator.createOpponent(HUMAN_ALIEN) instanceof AlienPlayer);
    }}
