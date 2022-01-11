package com.java_course.lambda.lambda_generic;

@FunctionalInterface
interface Interface<T> {

    void get(T i);
}

@SuppressWarnings("all")
public class InterfaceWithGenericTypeTest {

    public static void main(String[] args) {
        Interface anInterface = (x) -> System.out.println(x);
        anInterface.get(1);
        anInterface.get("hello world");
        anInterface.get(new Object());
    }
}