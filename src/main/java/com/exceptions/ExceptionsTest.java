package com.exceptions;

public class ExceptionsTest {

    public static void calculate(int[] array, int index) {
        try {
            System.out.println(array[index]);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        calculate(new int[]{1, 4, 5, 6, 7}, 3);
    }
}