package com.patterns.singleton;

import static com.patterns.singleton.MySingleton.getInstance;

public class TestSingleton {

    public static void main(String[] args) {
        MySingleton mySingleton = getInstance();
        System.out.println(mySingleton.hashCode());

        MySingleton mySingleton2 = getInstance();
        //тем самым удостоверились, что две ссылочные переменные ссылаются на один и тот же объект
        System.out.println(mySingleton.equals(mySingleton2));
    }
}