package com.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StreamAPI_Test {

    static List<Integer> list = Arrays.asList(10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    /*
    в начале, преобразовываем коллекцию в stream, далее коллекция фильтруется и на основе фильтра создается новая коллекция,
    далее производится маппинг(преобразование каждого элемента коллекции) и цикл forEach
     */
    public static void streamMappingTest() {
        list.stream().filter(i -> i % 2 != 0).collect(Collectors.toList()).stream().map(i -> i + 10).forEach(i -> {
            System.out.printf("%d ", i);
        });
    }

    //пример, терминальный метод orElseThrow() и конвейерный filter(), findAny()
    public static void streamThrowExceptionTest(int val) {
        list.stream().filter(i -> i.equals(val)).findAny()
                .orElseThrow(() -> new NullPointerException(String.format("there is no value: %d", val)));
        System.out.println("PASSED...");
    }

    //после выполнения фильтра, проверка что только один элемент присутствует, иначе выбрасывается исключение
    public static void streamReduceTest(int val) {
        System.out.println("PASSED: " + list.stream().filter(i -> i.equals(val)).reduce((a, b) -> {
            throw new IllegalStateException("FAILED: " + a + ", " + b);
        }).isPresent());
    }
}