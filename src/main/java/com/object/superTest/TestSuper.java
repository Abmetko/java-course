package com.object.superTest;

import com.object.constructorChaining.TestClass_2;

public class TestSuper extends TestClass_2 {

    public TestSuper() {
        super();
    }

    //результат выполнения - созданный обьект использует конструктор суперкласса
    public static void main(String[] args) {
        TestSuper obj = new TestSuper();
    }
}