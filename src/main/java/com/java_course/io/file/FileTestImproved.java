package com.java_course.io.file;

import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
public class FileTestImproved {

    private static final File FILE = new File("src/main/java/com/io/file/file_test2.CSV");
    private static final StringBuilder STRING_BUILDER = new StringBuilder();

    @SneakyThrows
    public static void createFile() {
        FILE.createNewFile();
    }

    public static List<Object[]> generateTestData() {
        List<Object[]> list = new ArrayList<>();

        Object[] user1 = {"Jack", "Black", 23};
        Object[] user2 = {"Nick", "White", 21};
        Object[] user3 = {"Chuck", "Norris", 25};

        list.add(user1);
        list.add(user2);
        list.add(user3);

        return list;
    }

    @SneakyThrows
    public static void writeDataInFile(List<Object[]> data) {
        PrintWriter printWriter = new PrintWriter(FILE);

        STRING_BUILDER
                .append("first name")
                .append(",")
                .append("last name")
                .append(",")
                .append("age");

        for (Object[] user : data) {
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


    public static void readDataFromFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE));

        bufferedReader.readLine();//skip the 1st line with columns headers

        while (bufferedReader.ready()) {
            System.out.println(bufferedReader.readLine());
        }
        bufferedReader.close();
    }

    public static void handleException() throws IOException {
        readDataFromFile();
    }

    public static void main(String[] args) throws IOException {
        createFile();
        writeDataInFile(generateTestData());
        handleException();
    }
}