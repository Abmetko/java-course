package com.java_course.collections;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();

        //добавляем элемент во мноджество
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println("Попытка добавить уже имеющийся элемент: " + set.add(1));

        System.out.println("Попытка удалить несуществующий элемент: " + set.remove(4));

        System.out.println("Содержит ли множество наш элемент: " + set.contains(3));

        System.out.println("Получить размер множества: " + set.size());

        //вывести на печать множество(Set)
        System.out.println(set);

        //проходимся по элементам с помощью цикла for
        for (int i : set) {
            System.out.println(i);
        }

        //удалить все элементы коллекции
        set.clear();

        //noinspection ConstantValue
        System.out.println("Получить размер множества: " + set.size());
    }
}