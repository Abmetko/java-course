package com.java_course.homework;

import java.util.function.Supplier;

public class HomeWork_3 {

    public static void tryDo(Supplier<Boolean> supplier) {
        while (!supplier.get()) {
            System.out.println("Try again...");
        }
        System.out.println("Finished.");
    }

    public static void main(String[] args) {
        tryDo(() -> Math.random() * 10 > 9);
    }
}