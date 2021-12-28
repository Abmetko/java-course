package com.lambda;

public class LambdaFuncTest {

    public static int method_1(int a, int b) {
        return a * b;
    }

    public static int method_2(int a, int b) {
        return a / b;
    }

    public static int method_3(int a, int b) {
        return (int) Math.sqrt(a + b);
    }

    public static int method_4(int a, int b) {
        return a - b;
    }












    public static int multiPurposeMethod(MyInterface2 myInterface, int a, int b) {
        return myInterface.calculate(a, b);
    }

    public static void main(String[] args) {
        //вариант использования метода 1
        multiPurposeMethod((a, b) -> {
            return a * b;
        }, 10, 10);

        //вариант использования метода 2
        multiPurposeMethod((a, b) -> {
            return a / b;
        }, 10, 10);

        //вариант использования метода 3
        multiPurposeMethod((a, b) -> {
            return (int) Math.sqrt(a + b);
        }, 10, 10);

        //вариант использования метода 4
        multiPurposeMethod((a, b) -> {
            return a - b;
        }, 10, 10);
    }
}