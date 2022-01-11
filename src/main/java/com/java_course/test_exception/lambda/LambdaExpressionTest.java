package com.java_course.test_exception.lambda;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LambdaExpressionTest {

    public static void doSomething(MyInterface myInterface) {
        long startTime = System.currentTimeMillis();
        myInterface.get();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }

    public static void main(String[] args) {
        doSomething(() -> {
            System.out.println("TEST STARTED");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E hh:mm:ss");
            System.out.println(simpleDateFormat.format(new Date()));
            System.out.println("TEST FINISHED");
        });
    }
}