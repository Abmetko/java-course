package com.java_course.exceptions;

public class ExceptionsTest {

    public static void calculate(int[] array, int index) {
        try {
            System.out.println(array[index]);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NumberFoundException {
        calculate(new int[]{1, 4, 5, 6, 7}, 5);
        System.out.println("\n");
        NumberValidator.validateNumber(5);

//        NumberValidator.validateNumber(0);
//        calculate(new int[]{1, 4, 5, 6, 7}, 5);
    }
}