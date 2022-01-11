package com.java_course.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderTest {

    public static void readData() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/com/io/test.txt"));
            String lineWithText;
            while ((lineWithText = bufferedReader.readLine()) != null) {
                System.out.println(lineWithText);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readData();
    }
}