package com.homework;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
Извлечь данные из файла с помощью stream API, поместить их в новую коллекцию.
Далее, с помощью stream API вывести каждый элемент коллекции на печать.
 */
public class HomeWork_1 {

    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/com/homework/names.txt"));

        bufferedReader.readLine();//skip header

        bufferedReader
                .lines()
                .forEach(list::add);
        bufferedReader.close();

        list.forEach(System.out::println);
    }
}
