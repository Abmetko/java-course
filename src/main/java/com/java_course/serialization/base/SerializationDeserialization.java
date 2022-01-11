package com.java_course.serialization.base;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationDeserialization {

    private static final String FILE_PATH = "src/main/java/com/serialization/base/file.txt";

    @SneakyThrows
    public static void main(String[] args) {
        //сериализация объекта в файл
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        objectOutputStream.writeObject(new Human("Tom", "CA", 80));
        objectOutputStream.close();

        //десериализация строковых данных из файла в объект типа Human
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH));
        Human obj = (Human) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(obj.name);
        System.out.println(obj.address);
        System.out.println(obj.age);
    }
}