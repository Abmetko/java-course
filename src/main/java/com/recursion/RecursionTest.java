package com.recursion;

@SuppressWarnings("all")
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

    /*
    В данном примере реализован бесконечный цикл, который приведет к переполнению стека.
    */
    public static void dangerousTestRecursion() {
        dangerousTestRecursion();
    }

    public static void main(String[] args) {
        try {
            dangerousTestRecursion();
        } catch (StackOverflowError e) {
            System.out.println("А я ведь предупреждал о переполнении стека...");
        }
    }
}