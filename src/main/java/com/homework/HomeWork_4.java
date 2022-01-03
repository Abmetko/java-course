package com.homework;

@SuppressWarnings("unchecked")
public class HomeWork_4<T> {

    private T value;

    public static void main(String[] args) {
        HomeWork_4 homeWork_4 = new HomeWork_4();
        homeWork_4.setValue(new Object());
        System.out.println(homeWork_4.geValue());
    }

    public T geValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}