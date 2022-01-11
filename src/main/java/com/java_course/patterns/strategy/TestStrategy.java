package com.java_course.patterns.strategy;

import lombok.SneakyThrows;

import java.util.Scanner;

public class TestStrategy {

    public static void makeSignUp(Integer strategy) {
        if (strategy.equals(1)) {
            new SignUpScreen(new AdminStrategy()).signUp();
        } else if (strategy.equals(2)) {
            new SignUpScreen(new UserStrategy()).signUp();
        }
    }

    @SneakyThrows
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter user type: " + "\n" +
                "1 - admin" + "\n" +
                "2 - user" + "\n");
        makeSignUp(scanner.nextInt());
    }
}