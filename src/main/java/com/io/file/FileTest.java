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
    public static void main(String[] args) {
        File file = new File("src/main/java/com/io/file/file_test.txt");
        file.createNewFile();

        PrintWriter printWriter = new PrintWriter(file);

        List<Object[]> users = new ArrayList<>();

        Object[] tom = {"Tom", 21};
        Object[] nick = {"Nick", 23};
        Object[] john = {"John", 20};

        users.add(tom);
        users.add(nick);
        users.add(john);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Name");
        stringBuilder.append(",");
        stringBuilder.append("Age");

        for (Object[] user : users) {
            stringBuilder.append("\n");
            stringBuilder.append(user[0]);
            stringBuilder.append(",");
            stringBuilder.append(user[1]);
        }
        printWriter.print(stringBuilder);
        printWriter.close();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        Object string;
        bufferedReader.readLine();//skip the 1st line with columns headers
        while ((string = bufferedReader.readLine()) != null) {
            System.out.println(string);
        }
        bufferedReader.close();
    }
}