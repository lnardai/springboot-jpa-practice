package com.nardai.practice.model;

public enum SoulsStone {

    MIND(13),
    REALITY(39),
    SOUL(60),
    SPACE(21),
    TIME(32),
    POWER(5);

    private final int value;

    SoulsStone(int s) {
        value=s;
    }

    public int getValue() {
        return value;
    }
}
