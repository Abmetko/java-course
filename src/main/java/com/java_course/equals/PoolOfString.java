package com.java_course.equals;

@SuppressWarnings({"StringOperationCanBeSimplified", "StringEquality"})
public class PoolOfString {

    public static String text_1 = "test";
    public static String text_2 = "test";
    public static String text_3 = new String("test");
    public static String text_4 = new String("test");

    //сссылка на одну и ту же область в случае с text_1 и text_2
    public static void main(String[] args) {
        System.out.println(text_1.equals(text_2)); //true
        System.out.println(text_1 == text_2); //true
        System.out.println(text_1 == text_3); //false - сравнение объекта и примитива из пула
        System.out.println(text_3.equals(text_4)); //true - сравнение объектов с переопределенныв методом equals в классе String
    }
}