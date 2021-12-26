package com.lambda;

public class Test {

    public static void test(SimplestInterface simplestInterface){
        while (Math.random() * 10 < 8){
            simplestInterface.justDoIt();
        }
        System.out.println("Наконец то попал");
    }

    public static void main(String[] args) {
        test(() -> {
            System.out.println("Не попал");
        });
    }
}