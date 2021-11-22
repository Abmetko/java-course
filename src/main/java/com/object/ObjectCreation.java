package com.object;

public class ObjectCreation {

    public static void main(String[] args) {
        ObjectCreation objectCreation = new ObjectCreation();
        objectCreation.createLinkToObject();
    }

    public void createLinkToObject() {
        Object obj1 = new Object();
        Object obj2 = obj1;

        System.out.println(obj1.equals(obj2));
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