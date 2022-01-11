package com.java_course.patterns.strategy;

public class UserStrategy implements Strategy {

    @Override
    public void signUp() {
        System.out.println("\"User\" sign up");
    }
}