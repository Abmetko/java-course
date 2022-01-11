package com.java_course.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class WriterTest {

    public static void writeData() {
        String[] array = {"one", "two", "three", "four", "five"};

        try {
            FileWriter fileWriter = new FileWriter("src/main/java/com/io/test.txt", true);
            for (String s : array) {
                fileWriter.write(s + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataWithBuffer() {
        String[] array = {"six", "seven", "eight", "nine", "ten"};

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/main/java/com/io/test.txt", true));
            for (String s : array) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataWithPrinter() {
        String[] array = {"1", "2", "3", "4", "5"};

        try {
            PrintStream printStream = new PrintStream("src/main/java/com/io/test.txt");
            for (String s : array) {
                printStream.println(s);
            }

            printStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeDataWithPrinter();
    }
}