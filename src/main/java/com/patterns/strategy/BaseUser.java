package com.patterns.strategy;

public class BaseUser {

    private final SignUpStrategy SIGN_UP_STRATEGY;

    public BaseUser(SignUpStrategy signUpStrategy) {
        this.SIGN_UP_STRATEGY = signUpStrategy;
    }

    public void makeSignIn() {
        System.out.println("Sign in");
    }

    public void makeSignUp() {
        SIGN_UP_STRATEGY.makeSignUp();
    }

    public void makeSignOut() {
        System.out.println("Sign out");
    }
}