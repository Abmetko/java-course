package com.exceptions;

public class ExceptionsTest {

    public static void calculate(int[] array, int index) {
        try {
            System.out.println(array[index]);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void checkNumbers(int number) throws NumberFoundException {
        final int[] numbers = {0, 1, 2, 3, 4, 5};
        for (int n : numbers) {
            if (n == number) {
                throw new NumberFoundException(String.format("Unexpectedly, a number [%d] has been found...", n));
            }
        }
    }

    public static void main(String[] args) throws NumberFoundException {
//        calculate(new int[]{1, 4, 5, 6, 7}, 3);
        checkNumbers(0);
    }
}