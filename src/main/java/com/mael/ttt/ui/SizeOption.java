package com.mael.ttt.ui;

import java.util.HashMap;
import java.util.Map;

public enum SizeOption {
    THREE_BY_THREE("3", "3x3 Board"),
    FOUR_BY_FOUR(  "4", "4x4 Board");

    private final String option;
    private final String text;

    SizeOption(String option, String text) {
        this.option = option;
        this.text   = text;
    }

    public String getOption() {
        return option;
    }

    public String getText() {
        return text;
    }

    public int getSize() {
        return Integer.parseInt(option);
    }

    public static Map<String, String> getSizeOptions() {
        Map<String, String> sizeOptions = new HashMap<>();
        for (SizeOption sizeOption : values()) {
            sizeOptions.put(sizeOption.getOption(), sizeOption.getText());
        }
        return sizeOptions;
    }

    public static SizeOption convertToOption(String input) {
        for (SizeOption sizeOption : values()) {
            if (sizeOption.getOption().equals(input)) {
                return sizeOption;
            }
        }
        return THREE_BY_THREE;
    }
}
