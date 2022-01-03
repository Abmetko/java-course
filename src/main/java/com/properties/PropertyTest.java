package com.properties;

import static com.properties.PropertyLoader.getProperty;

public class PropertyTest {

    public static void main(String[] args) {
        System.out.println(getProperty("test.type"));//статический импорт
    }
}