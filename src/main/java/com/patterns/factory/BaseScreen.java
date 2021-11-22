package com.patterns.factory;

public class BaseScreen implements ScreenInterface{

    @Override
    public void openScreen() {
        System.out.println("this is \"Base\" screen method");
    }
}