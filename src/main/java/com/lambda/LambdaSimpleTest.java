package com.lambda;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LambdaSimpleTest {

    public static void someMethod2(SimpleInterface simpleInterface, int a) {
        if (simpleInterface.get(a)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
    }

    public static void someMethod1(SimplestInterface simplestInterface) {
        simplestInterface.justDoIt();
    }

    public static void main(String[] args) {
        someMethod2((a) -> Math.random() * 10 > a, 5);

        someMethod1(() -> {
            System.out.println("Nike, just do it");
        });

        someMethod1(() -> {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy, E HH:mm:ss");
            System.out.println(simpleDateFormat.format(date));
        });
    }
}