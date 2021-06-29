package com.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamTest {

    static List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void streamTest() {
        list.stream().filter(i -> i % 2 != 0).collect(Collectors.toList()).stream().map(i -> i + 10).forEach(i -> {
            System.out.printf("%d ", i);
        });
    }

    public static void main(String[] args) {
        streamTest();
    }
}