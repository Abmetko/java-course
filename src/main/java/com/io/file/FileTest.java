package com.io.file;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileTest {

    @SneakyThrows
    @SuppressWarnings("ALL")
    public static void readWrite() {
        File file = new File("src/main/java/com/io/file/file_test.CSV");
        file.createNewFile();

        PrintWriter printWriter = new PrintWriter(file);

        List<Object[]> users = new ArrayList<>();

        Object[] user1 = {"Jack", "Black", 21};
        Object[] user2 = {"Nick", "White", 23};
        Object[] user3 = {"John", "Harris", 20};

        users.add(user1);
        users.add(user2);
        users.add(user3);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
                .append("first name")
                .append(",")
                .append("last name")
                .append(",")
                .append("age");

        for (Object[] user : users) {
            stringBuilder
                    .append("\n")
                    .append(user[0])
                    .append(",")
                    .append(user[1])
                    .append(",")
                    .append(user[2]);
        }
        printWriter.print(stringBuilder.toString());
        printWriter.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        Object string;
        bufferedReader.readLine();//skip the 1st line with columns headers
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }
        bufferedReader.close();
    }

    public static void main(String[] args) {
        readWrite();
    }
}