package com.java_course.test_exception;

public class TestException_1 {

    public static void main(String[] args) {
        try {
            MyLibrary.iterateNumbers(new int[]{1, 4, 67, -100, 0, 45});
        } catch (Throwable e) {
            System.out.println("Exception was generated");
        }
        System.out.println("Test completed successfully");
    }
}