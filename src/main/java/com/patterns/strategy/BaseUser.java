package com.patterns.strategy;

public abstract class BaseUser {

    private final SignUpStrategy SIGN_UP_STRATEGY;

    //устанавливаем тип стратегии которая в дальнейшем будет использована для метода регистрации
    public BaseUser(SignUpStrategy signUpStrategy) {
        this.SIGN_UP_STRATEGY = signUpStrategy;
    }

    public void makeSignIn() {
        System.out.println("Sign in");
    }

    //уникальный метод, характерный для выбранной стратегии
    public void makeSignUp() {
        SIGN_UP_STRATEGY.makeSignUp();
    }

    public void makeSignOut() {
        System.out.println("Sign out");
    }
}