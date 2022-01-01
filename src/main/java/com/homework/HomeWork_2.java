package com.homework;

interface MyInt<T> {

    void get(T arg);
}

@SuppressWarnings({"unchecked"})
public class HomeWork_2 {

    //явное объявление типа интерфейса
    public static void testLambdaGeneric_1(MyInt<Integer> myInt) {
        myInt.get(100);
    }

    //без явного объявление типа интерфейса
    public static void testLambdaGeneric_2(MyInt myInt) {
        myInt.get(100);
    }

    //без явного объявление типа интерфейса
    public static void testLambdaGeneric_3(MyInt myInt) {
        myInt.get("100");
    }

    public static void main(String[] args) {
        testLambdaGeneric_1((arg) -> System.out.println(arg + arg));

        testLambdaGeneric_2((arg) -> System.out.println((Integer) arg + (Integer) arg));

        testLambdaGeneric_3((arg) -> System.out.println(arg + (String) arg));
    }
}