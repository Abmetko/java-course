package com.java_course.patterns.object_pool;

import java.util.ArrayList;
import java.util.List;

public class ObjectPoolTest {

    private final List<Object> free = new ArrayList<>();
    private final List<Object> used = new ArrayList<>();

    public static void main(String[] args) {
        ObjectPoolTest objectPoolTest = new ObjectPoolTest();
        //помещаем в пул два объекта
        objectPoolTest.free.add(new Object());
        objectPoolTest.free.add(new Object());
        System.out.println(objectPoolTest);
        System.out.println("\n");

        //извлекли объект из пула
        Object obj = objectPoolTest.getPoolObject();
        System.out.println(objectPoolTest);
        System.out.println("\n");

        //вернули объект в пул
        objectPoolTest.releasePoolObject(obj);
        System.out.println(objectPoolTest);
        System.out.println("\n");

        //извлекли объект из пула
        obj = objectPoolTest.getPoolObject();
        System.out.println(objectPoolTest);
        System.out.println("\n");

        //извлекли объект из пула
        obj = objectPoolTest.getPoolObject();
        System.out.println(objectPoolTest);
    }

    public Object getPoolObject() {
        Object obj;
        if (free.isEmpty()) {
            obj = new Object();
            used.add(obj);
        } else {
            obj = free.get(0);
            used.add(obj);
            free.remove(obj);
        }
        return obj;
    }

    public void releasePoolObject(Object obj) {
        free.add(obj);
        used.remove(obj);
    }

    @Override
    public String toString() {
        getHashCodes(free, "free");
        getHashCodes(used, "used");
        return "ObjectPoolTest{" +
                "free=" + free.size() +
                ", used=" + used.size() +
                '}';
    }

    public void getHashCodes(List<Object> list, String name) {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append("[");
        for (Object o : list) {
            sb.append(o.hashCode());
            sb.append(",");
        }

        if (!list.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("]");
        System.out.println(sb);
    }
}