package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamTest {

    static List<Integer> list = Arrays.asList(10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void streamTest_1() {
        list.stream().filter(i -> i % 2 != 0).collect(Collectors.toList()).stream().map(i -> i + 10).forEach(i -> {
            System.out.printf("%d ", i);
        });
    }

    public static void streamTest_2(int val) {
        list.stream().filter(i -> i.equals(val)).findAny()
                .orElseThrow(() -> new AssertionError(String.format("there is no value: %d", val)));
        System.out.println("PASSED...");
    }

    /* check element is present and then check it's a single object */
    public static void streamTest_3(int val) {
        System.out.println("PASSED: " + list.stream().filter(i -> i.equals(val)).reduce((a, b) -> {
            throw new IllegalStateException("FAILED: " + a + ", " + b);
        }).isPresent());
    }

    public static void main(String[] args) {
        streamTest_3(11);
    }
}