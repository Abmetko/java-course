package com.patterns.strategy;

public abstract class BaseUser {

    private final SignUpStrategy signUpStrategy;

    //устанавливаем тип стратегии которая в дальнейшем будет использована для метода регистрации
    public BaseUser(SignUpStrategy signUpStrategy) {
        this.signUpStrategy = signUpStrategy;
    }

    public void makeSignIn() {
        System.out.println("Sign in");
    }

    //уникальный метод, характерный для выбранной стратегии
    public void makeSignUp() {
        signUpStrategy.makeSignUp();
    }

    public void makeSignOut() {
        System.out.println("Sign out");
    }
}