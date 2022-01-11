package com.java_course.streamAPI;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@SuppressWarnings("ALL")
public class StreamImplementation {

    private static final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {
        //реализация базовая
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        //реализация итератора с помощью продвинутого цикла for
        for (Integer i : list) {
            System.out.println(i);
        }

        //реализация с помощью Stream API - любая коллекция, имплементирующая интерфейс Collection
        list.stream().forEach(i -> System.out.println(i));
    }
}