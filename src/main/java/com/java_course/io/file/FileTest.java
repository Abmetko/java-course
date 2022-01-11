package com.java_course.io.file;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class FileTest {

    public static final File FILE = new File("src/main/java/com/io/file/file_test.CSV");
    public static final StringBuilder STRING_BUILDER = new StringBuilder();

    @SneakyThrows
    public static void writeDataInFile() {
        PrintWriter printWriter = new PrintWriter(FILE);

        List<Object[]> users = new ArrayList<>();

        Object[] user1 = {"Jack", "Black", 21};
        Object[] user2 = {"Nick", "White", 23};
        Object[] user3 = {"John", "Harris", 20};

        users.add(user1);
        users.add(user2);
        users.add(user3);

        STRING_BUILDER
                .append("first name")
                .append(",")
                .append("last name")
                .append(",")
                .append("age");

        for (Object[] user : users) {
            STRING_BUILDER
                    .append("\n")
                    .append(user[0])
                    .append(",")
                    .append(user[1])
                    .append(",")
                    .append(user[2]);
        }
        printWriter.print(STRING_BUILDER);
        printWriter.close();
    }

    @SneakyThrows
    public static void createFile() {
        FILE.createNewFile();

        PrintWriter printWriter = new PrintWriter(FILE);

        List<Object[]> users = new ArrayList<>();

        Object[] user1 = {"Jack", "Black", 21};
        Object[] user2 = {"Nick", "White", 23};
        Object[] user3 = {"John", "Harris", 20};

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    @SneakyThrows
    public static void readDataFromFile() {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE));
        Object string;

        bufferedReader.readLine();//skip the 1st line with columns headers

        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }
        bufferedReader.close();
    }

    public static void main(String[] args) {
        createFile();
        writeDataInFile();
        readDataFromFile();
    }
}