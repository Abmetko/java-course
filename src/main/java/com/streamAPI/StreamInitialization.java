package com.streamAPI;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamInitialization {

    @SneakyThrows
    public static void main(String[] args) {
        //0
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Stream<Integer> intStream1 = list.stream();

        //1
        Stream<Integer> intStream2 = IntStream.rangeClosed(1, 10).mapToObj(i -> new Integer(i));

        Stream<Integer> intStream3 = IntStream.rangeClosed(1, 10).boxed();

        //2
        Stream<Integer> intStream4 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        //3
        Stream<String> strStream1 = Files.lines(Paths.get("src/main/java/com/streamAPI/names.CSV"));

        //4
        Stream<String> strStream2 = Arrays.stream(new String[]{"1", "2", "3"});

        //5
        Stream<String> strStream3 = Stream
                .<String>builder()
                .add("1")
                .add("2")
                .build();
    }
}