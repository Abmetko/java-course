package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class StreamCounter {

    static List<Integer> list1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
    static List<Integer> list2 = Arrays.asList(2,5,10,11,12,100);
    static List<List<Integer>> commonList = new ArrayList<>();

    static {
        commonList.add(list1);
        commonList.add(list2);
    }

    public static int cycleTest(){
        int count = 0;
        for(List<Integer> l:commonList){
            for(int i:l){
                if(i%2==0){
                    count+=1;
                }
            }
        }
        return count;
    }

    public static int streamTest() {
        return commonList.stream().mapToInt(l -> (int) l.stream().filter(i -> i%2==0).count()).sum();
    }

    public static void main(String[] args) {
        System.out.println(streamTest());
        System.out.println(cycleTest());
    }
}