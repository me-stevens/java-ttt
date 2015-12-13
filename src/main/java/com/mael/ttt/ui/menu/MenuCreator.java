package com.mael.ttt.ui.menu;

import com.mael.ttt.ui.UserInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuCreator {
    private final UserInterface gameUI;

    public MenuCreator(UserInterface gameUI) {
        this.gameUI = gameUI;
    }

    public Menu createMenu() {
        List<Option> menuOptions = new ArrayList<>();

        menuOptions.addAll(Arrays.asList(new TwoHumans(), new HumanAndRobot(), new TwoRobots(), new HumanAndAlien()));

        return new Menu(gameUI, menuOptions);
    }
}
