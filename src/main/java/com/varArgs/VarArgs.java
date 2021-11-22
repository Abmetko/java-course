package com.varArgs;

import java.util.Arrays;

public class VarArgs {

    public static void varArgsTest(String... arg) {
        Arrays.stream(arg).forEach(System.out::println);
    }

    public static void main(String[] args) {
        varArgsTest("1", "2", "3");
        varArgsTest("100");
    }
}