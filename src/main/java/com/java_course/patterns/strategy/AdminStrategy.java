package com.java_course.patterns.strategy;

public class AdminStrategy implements Strategy {

    @Override
    public void signUp() {
        System.out.println("\"Admin\" sign up");
    }
}