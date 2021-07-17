package com.object.superTest;

import com.object.constructorChaining.TestClass_2;

public class TestSuper extends TestClass_2 {

    public TestSuper(){
        super();
    }

    public static void main(String[] args) {
        TestSuper obj = new TestSuper();
    }
}