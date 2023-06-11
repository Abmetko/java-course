package com.java_course.equals;

public class PoolOfInt {

    private static final int ONE = 200;
    private static final int TWO = 127;
    private static final int THREE = 200;
    private static final Integer FOUR = 128;
    @SuppressWarnings("UnnecessaryBoxing")
    private static final Integer FIVE = Integer.valueOf(128);
    private static final Integer SIX = 127;

    @SuppressWarnings({"NumberEquality", "ConstantValue"})
    public static void main(String[] args) {
        System.out.println(FIVE == FOUR);//false, because not in pool [-128;127]

        System.out.println(TWO == SIX);//true

        System.out.println(ONE == THREE);//true
    }
}