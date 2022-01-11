package com.java_course.object;

public class GarbageCollectorTest {

    public static void main(String[] args) {
        GarbageCollectorTest garbageCollectorTest = new GarbageCollectorTest();
        garbageCollectorTest.createLinkToObject();
    }

    public void createLinkToObject() {
        Object obj1 = new Object();
        Object obj2 = obj1;

        System.out.println(obj1.equals(obj2)); //true

        Object obj3 = new Object();

    }

    //ссылка obj1 терет смысл и будет удалена сборщиком мусора
    public void prepareObject1ToGarbageCollector() {
        Object obj1 = new Object();
        obj1 = null;
    }

    //ссылка obj2 терет смысл и будет удалена сборщиком мусора
    public void prepareObject2ToGarbageCollector() {
        Object obj1 = new Object();
        Object obj2 = new Object();
        obj2 = obj1;
    }
}