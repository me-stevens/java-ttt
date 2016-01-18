package com.mael.ttt.ui;

import java.util.ArrayList;
import java.util.List;

public enum SizeOption {
    THREE_BY_THREE("3", "3x3 Board"),
    FOUR_BY_FOUR(  "4", "4x4 Board");

    private final String input;
    private final String text;
    private static List<String> allInputs = new ArrayList<>();

    SizeOption(String input, String text) {
        this.input = input;
        this.text  = text;
    }

    public String getInput() {
        return input;
    }

    public String getText() {
        return text;
    }

    public static List<String> getAllInputs() {
        allInputs.clear();
        for (SizeOption sizeOption : values()) {
            allInputs.add(sizeOption.getInput());
        }
        return allInputs;
    }

    public static SizeOption inputToOption(String input) {
        for (SizeOption sizeOption : values()) {
            if (sizeOption.getInput().equals(input)) {
                return sizeOption;
            }
        }
        return THREE_BY_THREE;
    }

    public static boolean contains(String input) {
        for (SizeOption sizeOption : values()) {
            if (sizeOption.getInput().equals(input)) {
                return true;
            }
        }
        return false;
    }
}
