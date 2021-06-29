package com.patterns.singleton;

import static com.patterns.singleton.MySingleton.getInstance;

public class TestSingleton {

    public static void main(String[] args) {
        MySingleton mySingleton = getInstance(10);
        System.out.println(mySingleton.value);
    }
}