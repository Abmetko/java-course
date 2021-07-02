package com.patterns.singleton;

import static com.patterns.singleton.MySingleton.getInstance;

public class TestSingleton {

    public static void main(String[] args) {
        MySingleton mySingleton = getInstance();
        System.out.println(mySingleton.hashCode());

        MySingleton mySingleton2 = getInstance();
        /* check both entity are equals */
        System.out.println(mySingleton.equals(mySingleton2));
    }
}