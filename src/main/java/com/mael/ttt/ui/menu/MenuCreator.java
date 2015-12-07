package com.mael.ttt.ui.menu;

import com.mael.ttt.ui.UserInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuCreator {

    public Menu createMenu(UserInterface gameUI) {
        List<String> menuOptionIds   = new ArrayList<>();
        List<Option> menuOptions     = new ArrayList<>();
        List<String> menuOptionTexts = new ArrayList<>();

        menuOptionIds.addAll(Arrays.asList("1", "2", "3", "4"));
        menuOptions.addAll(Arrays.asList(new TwoHumans(), new HumanAndRobot(), new TwoRobots(), new HumanAndAlien()));
        menuOptionTexts.addAll(Arrays.asList("Human vs. Human", "Human vs. Robot", "Robot vs. Robot", "Human vs. Alien"));

        return new Menu(gameUI, menuOptionIds, menuOptions, menuOptionTexts);
    }
}
