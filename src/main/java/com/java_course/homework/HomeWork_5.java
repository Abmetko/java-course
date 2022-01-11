package com.java_course.homework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class HomeWork_5 {

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("src/main/java/com/homework/letters.txt");

        char[] array = "Hello".toCharArray();

        for (char i : array) {
            outputStream.write(i);
        }
        outputStream.close();
    }
}