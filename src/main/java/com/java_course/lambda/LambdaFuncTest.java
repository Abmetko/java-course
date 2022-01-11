package com.java_course.lambda;

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

        //вариант использования метода 1 (с return в фигурных скобках)
        multiPurposeMethod((a, b) -> a * b, 10, 10);

        //вариант использования метода 2
        multiPurposeMethod((a, b) -> a / b, 10, 10);

        //вариант использования метода 3
        multiPurposeMethod((a, b) -> (int) Math.sqrt(a + b), 10, 10);

        //вариант использования метода 4
        System.out.println(multiPurposeMethod((a, b) -> a - b, 10, 10));


        //вариант развернутый - с реализацией анонимного класса, который реализует интерфейс MyInterface2
        MyInterface2 myInterface2 = new MyInterface2() {
            @Override
            public int calculate(int a, int b) {
                return a * b;
            }
        };
        myInterface2.calculate(10, 10);
    }
}