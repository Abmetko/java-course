package com.patterns.factory;

import com.enums.Screens;


public class ScreenFactory {

    public BaseScreen getScreen(Screens type) {
        BaseScreen screen;
        switch (type) {
            case LOGIN:
                screen = new LoginScreen();
                break;
            case MAIN:
                screen = new MainScreen();
                break;
            default:
                throw new IllegalArgumentException("screen name is incorrect:" + type);
        }
        return screen;
    }
}