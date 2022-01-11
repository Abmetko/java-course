package com.java_course.generics;

public class GenericClassTest<T> {

    private final T index;
    private final int index2;

    public GenericClassTest(T index, int index2) {
        this.index = index;
        this.index2 = index2;
    }

    public static void main(String[] args) {
        GenericClassTest<Integer> obj_1 = new GenericClassTest<>(100, 10);
        GenericClassTest<String> obj_2 = new GenericClassTest<>("qwerty", 10);

        System.out.println(obj_1.getIndex() + 100);
        System.out.println(obj_2.getIndex() + "100");
    }

    public T getIndex() {
        return index;
    }
}