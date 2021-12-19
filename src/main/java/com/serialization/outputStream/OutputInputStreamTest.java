package com.serialization.outputStream;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class OutputInputStreamTest {

    private static final String FILE_PATH = "src/main/java/com/serialization/outputStream/file.txt";

    @SneakyThrows
    public static void main(String[] args) {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
        objectOutputStream.writeObject(new MyClass("Tom", "CA", 80));
        objectOutputStream.close();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH));
        MyClass obj = (MyClass) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(obj.name);
        System.out.println(obj.address);
        System.out.println(obj.age);
    }
}