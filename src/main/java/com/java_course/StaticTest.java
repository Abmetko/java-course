package com.java_course;

public class StaticTest {

    public static int a;

    static {
        System.out.println("1");
        a = 100;
    }

    public static void main(String[] args) {
        System.out.println("2");
    }
}