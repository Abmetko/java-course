package com.arrays;

import java.util.Arrays;

public class BubbleSorting {

    static int[] array = {1, 5, -9, 0, -12, 4, 6, 34};

    public static void main(String[] args) {
        createNewArrayWithEvenNumbers();
        bubbleSorting();
    }

    public static void bubbleSorting() {
        int buffer;
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    buffer = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buffer;
                    isSorted = false;
                }
            }
        }

        System.out.println(Arrays.toString(array));
    }

    /*
    Создать новый массив содержащий четные числа из первого массива
     */
    public static void createNewArrayWithEvenNumbers() {
        int arraySize = 0;

        for (int j : array) {
            if (j % 2 == 0) {
                arraySize++;
            }
        }

        int[] newArray = new int[arraySize];
        int counter = 0;

        for (int j : array) {
            if (j % 2 == 0) {
                newArray[counter] = j;
                counter++;
            }
        }

        System.out.println(Arrays.toString(newArray));
    }
}