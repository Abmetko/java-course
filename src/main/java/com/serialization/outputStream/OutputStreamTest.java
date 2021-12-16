package com.serialization.outputStream;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OutputStreamTest {

    @SneakyThrows
    public static void main(String[] args) {
        FileOutputStream fileOutputStream = new FileOutputStream("temp");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(new MyClass("Tom", "CA", 80));
        objectOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("temp");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        MyClass obj = (MyClass) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(obj.name);
        System.out.println(obj.address);
        System.out.println(obj.age);
    }
}