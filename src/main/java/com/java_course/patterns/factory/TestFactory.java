package com.java_course.patterns.factory;

import com.java_course.enums.Screen;

public class TestFactory {

    public static void main(String[] args) {
        ScreenFactory factory = new ScreenFactory();

        BaseScreen splashScreen = factory.getScreen(Screen.SPLASH);
        BaseScreen loginScreen = factory.getScreen(Screen.SIGN_IN);
        BaseScreen mainScreen = factory.getScreen(Screen.MAIN);


        splashScreen.openScreen();//использует метод базового класса
        loginScreen.openScreen();
        mainScreen.openScreen();
    }
}