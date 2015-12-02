package com.mael.ttt.ui;

import com.mael.ttt.players.AlienPlayer;
import com.mael.ttt.players.HumanPlayer;
import com.mael.ttt.players.Player;
import com.mael.ttt.players.RobotPlayer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MenuTest {

    private SpyConsole spy;
    private Menu menu;

    @Before
    public void setUp() {
        spy  = new SpyConsole();
        menu = new Menu(new UserInterface(spy));
    }

    @Test
    public void showPlayersMenuUntilRightOption() {
        spy.setInputs("khgj", "0", "1");
        menu.createPlayers();
        assertEquals(3, spy.timesReadWasCalled());
    }

    @Test
    public void setsTwoHumanPlayers() {
        spy.setInput("1");
        List<Player> players = menu.createPlayers();
        assertTrue(players.get(0) instanceof HumanPlayer);
        assertTrue(players.get(1) instanceof HumanPlayer);
    }

    @Test
    public void setsOneRobotPlayer() {
        spy.setInput("2");
        List<Player> players = menu.createPlayers();
        assertTrue(players.get(0) instanceof HumanPlayer);
        assertTrue(players.get(1) instanceof RobotPlayer);
    }

    @Test
    public void setsTwoRobotPlayers() {
        spy.setInput("3");
        List<Player> players = menu.createPlayers();
        assertTrue(players.get(0) instanceof RobotPlayer);
        assertTrue(players.get(1) instanceof RobotPlayer);
    }

    @Test
    public void setsOneAlienPlayer() {
        spy.setInput("4");
        List<Player> players = menu.createPlayers();
        assertTrue(players.get(0) instanceof HumanPlayer);
        assertTrue(players.get(1) instanceof AlienPlayer);
    }
}
