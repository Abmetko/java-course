package com.lambda;


public class Lambda {

    public static MyInterface myInterface = x -> x*x;

    public static int testMeth(MyInterface myInterface){
        return myInterface.accept(1);
    }


    public static void main(String[] args) {
        System.out.println(myInterface.accept(10));
        System.out.println(testMeth(x ->  x + 100));
    }
}