package com.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Stasia");
        list.add("Andrey");

        list.add(0, "Margo");

        for (String s : list) {
            if (s.startsWith("A")) {
                System.out.println(s);
            }
        }

        System.out.println(list.size());
    }
}