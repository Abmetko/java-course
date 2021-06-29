package com.patterns.singleton;

public class MySingleton {

    private static MySingleton instance = null;
    public int value;

    private MySingleton(int value) {
        this.value = value;
    }

    public static MySingleton getInstance(int value) {
        if (instance == null) {
            instance = new MySingleton(value);
        }
        return instance;
    }
}