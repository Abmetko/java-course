package com.java_course.properties;

import static com.java_course.properties.PropertyProvider.getProperty;

public class PropertyTest {

    public static void main(String[] args) {
        System.out.println(getProperty("test.type"));//статический импорт
    }
}