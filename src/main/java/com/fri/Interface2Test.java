package com.fri;

@SuppressWarnings("all")
public class Interface2Test {

    public static void main(String[] args) {
        Interface anInterface = (x) -> System.out.println(x);
        anInterface.get(1);
        anInterface.get("hello world");
        anInterface.get(new Object());
    }
}