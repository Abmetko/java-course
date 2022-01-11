package com.java_course.lambda;

public class Test {

    public static void test_2() {
        SimplestInterface simplestInterface1 = () -> {
            System.out.println("This is a simple implementation of lambda");
        };
        simplestInterface1.justDoIt();
    }

    public static void test(SimplestInterface simplestInterface) {
        while (Math.random() * 10 < 8) {
            simplestInterface.justDoIt();
        }
        System.out.println("Наконец то попал");
    }

    public static void main(String[] args) {
        test(() -> {
            System.out.println("Не попал");//fixme - to implement something
        });
    }
}