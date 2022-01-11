package com.java_course;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetTest {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("firstName","Nick");
        map.put("lastName","Long");
        testMeth(map);
    }

    public static void testMeth(Map<String,String> args){
        System.out.printf("My name is %s %s%n", args.get("firstName"), args.get("lastName"));
    }
}
