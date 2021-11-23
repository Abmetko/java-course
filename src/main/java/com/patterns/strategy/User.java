package com.patterns.strategy;

public class User extends BaseUser {

    //передаем в конструктор стратегию для юзера
    public User() {
        super(new UserSignUp());
    }
}