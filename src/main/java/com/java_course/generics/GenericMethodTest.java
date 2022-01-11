package com.java_course.generics;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenericMethodTest {

    @SneakyThrows
    public static void main(String[] args) {
        System.out.println(someMethodWithReturn(100));
        System.out.println(someMethodWithReturn("qwerty"));
        System.out.println(someMethodWithReturn(new Object()));
        System.out.println(someMethodWithReturn(new SimpleDateFormat("hh:mm:ss").format(new Date())));
    }

    public static <T> void someVoidMethod(T arg) {
        System.out.println(arg);
    }

    public static <T> T someMethodWithReturn(T arg) {
        return arg;
    }
}