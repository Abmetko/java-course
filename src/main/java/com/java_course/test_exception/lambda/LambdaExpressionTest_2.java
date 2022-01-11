package com.java_course.test_exception.lambda;

@SuppressWarnings("all")
public class LambdaExpressionTest_2 {

    public static void doSomething_1(int a, int b) {
        System.out.println(a * Math.random() < b * Math.random());
    }

    public static void doSomething_2(int a, int b) {
        System.out.println(a * a < b * b);
    }

    public static void doSomething_3(int a, int b) {
        System.out.println((a + a) < (b + b));
    }

    public static void doSomething(MyInterface_2 myInterface_2, int a, int b) {
        System.out.println(
                myInterface_2
                        .calculate(a, b)//lambda method
        );
    }

    public static void main(String[] args) {
        doSomething((arg1, arg2) -> {
            return arg1 * Math.random() < arg2 * Math.random();
        }
        , 10, 20);
    }
}