package com.nardai.practice.model;

public enum SoulsStone {

    //-minus2,minus3, backwards
    MIND(11),
    REALITY(37),
    SOUL(58),
    SPACE(18),
    TIME(29),
    POWER(2);

    private final int value;

    SoulsStone(int s) {
        value=s;
    }

    public int getValue() {
        return value;
    }
}
