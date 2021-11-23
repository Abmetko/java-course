package com.patterns.strategy;

public class Admin extends BaseUser {

    //передаем в конструктор стратегию для админа
    public Admin() {
        super(new AdminSignUp());
    }
}