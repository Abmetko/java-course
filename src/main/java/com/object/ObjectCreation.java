package com.object;

public class ObjectCreation {

    public static void main(String[] args) {

        // TODO - оператор new. Выделение памяти. Ссылка на объект. Реализация equals() в классе Object.
        Object obj1 = new Object();
        Object obj2 = obj1;

        System.out.println(obj1.equals(obj2)); //true
    }
}