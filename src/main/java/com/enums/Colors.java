package com.enums;

public enum Colors {

    GREY("silver grey"),
    GREEN("light green");

    private final String value;

    Colors(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}