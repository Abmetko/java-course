package com.patterns.strategy;

public class TestStrategy {

    public static void main(String[] args) {

        Admin admin = new Admin();
        User user = new User();

        admin.makeSignUp();
        admin.makeSignOut();
        admin.makeSignIn();

        System.out.print("\n");

        user.makeSignUp();
        user.makeSignOut();
        user.makeSignIn();
    }
}