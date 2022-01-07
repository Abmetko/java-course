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
        //с явным объявлением типа интерфейса
        testLambdaGeneric_1((arg) -> {
            System.out.println(arg + 100);
            System.out.println(arg + 100);
        });

        //без явного объявление типа интерфейса - необходимо сделать приведение типа
        testLambdaGeneric_2((arg) -> System.out.println((Integer) arg + 100));

        testLambdaGeneric_3((arg) -> System.out.println(arg + "100"));
    }
}