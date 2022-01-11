package com.java_course.patterns.strategy;

public class SignUpScreen {

    private final Strategy signUpStrategy;

    public SignUpScreen(Strategy signUpStrategy) {
        this.signUpStrategy = signUpStrategy;
    }

    public void signUp() {
        signUpStrategy.signUp();
    }
}