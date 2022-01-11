package com.java_course.exceptions;

public class NumberValidator {

    public static void validateNumber(int number) throws NumberFoundException {
        final int[] numbers = {0, 1, 2, 3, 4, 5};
        for (int n : numbers) {
            if (n == number) {
                throw new NumberFoundException(String.format("Unexpectedly, number [%d] has been found...", n));
            }
        }
    }
}