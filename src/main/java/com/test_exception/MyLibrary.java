package com.test_exception;

public class MyLibrary {

    public static void iterateNumbers(int[] numbers) throws ZeroFoundException {
        for (int i : numbers) {
            if (i == 0) {
                throw new ZeroFoundException(String.format("Unexpectedly, number is equal to %d", i));
            }
        }
    }
}