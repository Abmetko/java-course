package com.java_course.enums;

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

    public static void main(String[] args) {
        System.out.println(Colors.GREY.getValue());
    }
}