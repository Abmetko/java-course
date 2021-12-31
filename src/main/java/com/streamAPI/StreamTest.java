package com.streamAPI;

import io.restassured.internal.common.assertion.Assertion;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
public class StreamTest {

    private static final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {
//        //реализация базовая
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        //реализация итератора с помощью продвинутого цикла for
//        for (Integer i : list) {
//            System.out.println(i);
//        }
//
//        //реализация с помощью Stream API - любую коллекцию, имплементирующую интерфейс Collection
//        list.stream().forEach(i -> System.out.println(i));
//


        List<Integer> list_1 = Arrays.asList(1, 2, 3, 4, 5, -1);


        System.out.println(list_1.stream()
                .filter(i -> i < 0)
//                .map(i -> i * 2)
                .findAny()
                .orElseThrow()
                .equals(-1));
//                .forEach(i -> System.out.println(100 + i));


    }
}