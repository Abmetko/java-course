package com.patterns.strategy;

public class UserStrategy implements Strategy {

    @Override
    public void signUp() {
        System.out.println("\"User\" sign up");
    }
}