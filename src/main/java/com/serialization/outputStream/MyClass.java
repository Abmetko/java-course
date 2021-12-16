package com.serialization.outputStream;

import java.io.Serializable;

public class MyClass implements Serializable {
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
