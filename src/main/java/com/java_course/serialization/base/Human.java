package com.java_course.serialization.base;

import java.io.Serializable;

//для обеспечения возможности сериализации, класс должен имплементировать интерфейс Serializable
public class Human implements Serializable {

    public String name = "test";
    public String address = "test";
    public int age = 10;

    public Human() {
    }

    public Human(String name, String address, int age) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}