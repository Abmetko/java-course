package com.generics;

public class GenericClassTest<T> {

    private final T index;

    public GenericClassTest(T index) {
        this.index = index;
    }

    public static void main(String[] args) {
        GenericClassTest<Integer> obj_1 = new GenericClassTest<>(100);
        GenericClassTest<String> obj_2 = new GenericClassTest<>("qwerty");

        System.out.println(obj_1.getIndex() + 100);
        System.out.println(obj_2.getIndex() + "100");
    }

    public T getIndex() {
        return index;
    }
}