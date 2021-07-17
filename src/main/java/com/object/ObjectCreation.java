package com.object;

public class ObjectCreation {


    public void createNewObject(){
        Object obj1 = new Object();
    }

    public void createLinkToObject(){
        Object obj1 = new Object();
        Object obj2 = obj1;

        System.out.println(obj1.equals(obj2));
    }

    public void prepareObject1ToGarbageCollector(){
        Object obj1 = new Object();
        obj1 = null;
    }

    public void prepareObject2ToGarbageCollector(){
        Object obj1 = new Object();
        Object obj2 = new Object();
        obj2 = obj1;
    }

    public static void main(String[] args) {


    }
}