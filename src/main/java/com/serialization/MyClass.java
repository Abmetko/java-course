package com.serialization;

public class MyClass {

    public String name = "test";
    public String address = "test";
    public int age = 10;

    public MyClass() {
    }

    public MyClass(String name, String address, int age) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}