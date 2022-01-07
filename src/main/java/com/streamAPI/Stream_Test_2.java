package com.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_Test_2 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 1);

        List<String> list3 = Arrays.asList("nick", "jack");

        list2.stream().forEach(element -> list.add(element));

        list.stream().forEach(element -> System.out.println(element));

        Stream stream = Stream.of(1, 2, 3, 4, 5, 6);

        List<String> emails = list3.stream().map((i) -> i + "@gmail.com").collect(Collectors.toList());
        System.out.println(emails.get(0));

        System.out.println(list2.stream().filter(i -> i % 2 != 0).count());

        list2.stream().filter(i -> i == 1).reduce((a, b) -> {
            throw new IllegalStateException();
        });

        System.out.println(list2.stream()
                .filter(i -> i == 7)
                .findAny()
                .orElseThrow());

        list2.stream().noneMatch((i) -> i == 1);
    }
}