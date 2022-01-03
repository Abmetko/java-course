package com.recursion;

public class RecursionTest {

    /*
    FINISH будет всегда больше на 1 чем TRY AGAIN...,
    т.к. отработают все вызовы метода находящиеся в стеке.
    */
    public static void testRecursion() {
        if (Math.random() * 10 < 8) {
            System.out.println("TRY AGAIN...");
            testRecursion();
        }
        System.out.println("FINISH.");
    }

    public static void main(String[] args) {
        testRecursion();
    }
}