package com.collections.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsSorting {

    public static void sortingOfCollection() {
        List<Integer> integerList = Arrays.asList(1, 2, 4, 5, 3);
        Collections.sort(integerList);
        System.out.println(integerList);//выводим на печать отсортированную коллекцию

        Collections.reverse(integerList);
        System.out.println(integerList);//выводим на печать коллекцию в обратном порядке
    }

    public static void sortingOfCollectionWithCustomObjects() {
        List<Human> integerList = Arrays.asList(new Human(11), new Human(10), new Human(12));
        Collections.sort(integerList);
        integerList.forEach(System.out::println);
    }

    public static void sortingOfCollectionWhichCannotImplementComparable() {
        List<HomoSapiens> integerList = Arrays.asList(new HomoSapiens(11), new HomoSapiens(10), new HomoSapiens(12));
        integerList.sort(new HomoSapiensComparator());
        integerList.forEach(System.out::println);
    }

    public static void sortingOfArrayWithCollection() {
        Integer[] array = {1, 4, 5, 3, 2};
        List<Integer> integerList = Arrays.asList(array);
        Collections.sort(integerList);
        System.out.println(integerList);
    }

    public static void main(String[] args) {
        sortingOfCollection();
        sortingOfCollectionWithCustomObjects();
        sortingOfCollectionWhichCannotImplementComparable();
        sortingOfArrayWithCollection();
    }
}

class Human implements Comparable<Human> {
    public final int age;

    public Human(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Human o) {
        return this.age - o.age;//o.age - this.age (for reversed order)
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                '}';
    }
}

/*
В случае, если нет возможности для класса наших объектов имплементировать интерфейс
Comparable (например сторонняя библиотека)
*/
class HomoSapiens {
    public final int age;

    public HomoSapiens(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "HomoSapiens{" +
                "age=" + age +
                '}';
    }
}

class HomoSapiensComparator implements Comparator<HomoSapiens> {

    @Override
    public int compare(HomoSapiens o1, HomoSapiens o2) {
        return o1.age - o2.age;
    }
}