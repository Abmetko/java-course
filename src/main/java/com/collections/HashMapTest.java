package com.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("first name", "Jack");
        map.put("last name", "Black");
        map.put("age", "50");
        map.put("weight", "100");

        /*
         * A map entry (key-value pair). The Map.entrySet method returns a collection-view of the map,
         * whose elements are of this class. The only way to obtain a reference to a map entry is from
         * the iterator of this collection-view. These Map.Entry objects are valid only for the duration
         * of the iteration; more formally, the behavior of a map entry is undefined if the backing map
         * has been modified after the entry was returned by the iterator, except through the setValue
         * operation on the map entry.
         *
         * Map.Entry<String, String> - пара (key-value)
         *
         * map.entrySet() - представление в виде коллекции, которая содержит пары типа Map.Entry<String, String>
         */
        for (Map.Entry<String, String> set : map.entrySet()) {
            System.out.printf("%s: %s%n", set.getKey(), set.getValue());
        }
    }
}