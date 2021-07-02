package com.patterns.factory;

import com.enums.Screens;

public class TestFactory {

    public static void main(String[] args) {
        ScreenFactory factory = new ScreenFactory();

        BaseScreen loginScreen = factory.getScreen(Screens.LOGIN);
        BaseScreen mainScreen = factory.getScreen(Screens.MAIN);

        loginScreen.openScreen();
        mainScreen.openScreen();
    }
}
