package com.patterns.factory;

import com.enums.Screen;

public class ScreenFactory {

    public BaseScreen getScreen(Screen type) {
        BaseScreen screen;
        switch (type) {
            case SPLASH:
                screen = new SplashScreen();
                break;
            case SIGN_IN:
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