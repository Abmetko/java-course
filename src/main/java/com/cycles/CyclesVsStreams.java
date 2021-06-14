package com.cycles;

import java.util.Arrays;
import java.util.List;


public class CyclesVsStreams {

    static List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    static List<Integer> list2 = Arrays.asList(0,5,10,100);


    public static void cycleTest(){
        for(int i:list2){
            if(list1.contains(i)) System.out.println(list1.get(list1.indexOf(i)));
        }
    }

    public static void streamTest() {
        list2.forEach(i -> {if(list1.contains(i)) System.out.println(i);});
    }

    public static void main(String[] args) {
        cycleTest();
        System.out.println("\n");
        streamTest();
    }

}
