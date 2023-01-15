package com.java_course.io.streams;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamTest {

    public static void main(String[] args) throws IOException {
        String str = "Hello world";
        byte[] buffer = str.getBytes();

        FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/com/java_course/io/streams/file.txt");
        fileOutputStream.write(buffer, 0, buffer.length);
        fileOutputStream.close();
    }
}