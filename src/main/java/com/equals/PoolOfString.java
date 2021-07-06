package com.equals;

public class PoolOfString {

    public static String text_1 = "test";
    public static String text_2 = "test";
    public static String text_3 = new String("test");


    public static void main(String[] args) {
        System.out.println(text_1 == text_2); //true

        System.out.println(text_1 == text_3); //false
    }
}