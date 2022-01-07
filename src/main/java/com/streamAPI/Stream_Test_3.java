package com.streamAPI;

import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class Stream_Test_3 {

    @SneakyThrows
    public static void main(String[] args) {
        //1
        System.out.println(getResultOfMultiplication(getIntegerStream(1, 10)));

        //2
        getStreamOfString("src/main/java/com/streamAPI/names.CSV")
                .forEach(name -> System.out.println(name));

        //3
        System.out.println(getMapFromStream().get("Parker"));
    }

    //инициализация Integer стрима
    public static IntStream getIntegerStream(int startInclusive, int endInclusive) {
        return IntStream.rangeClosed(startInclusive, endInclusive);
    }

    //получить результат перемножения всех элементов стрима
    public static int getResultOfMultiplication(IntStream intStream){
        return intStream
                .reduce((a, b) -> a * b)
                .getAsInt();
    }

    //получение String стрима из строк файла
    public static Stream<String> getStreamOfString(String url) throws IOException {
        return Files.lines(Paths.get(url));
    }

    //преобразование стрима в Map
    public static Map<String, String> getMapFromStream() {
        Stream<User> userStream = Stream
                .<User>builder()
                .add(new User(25, "male", "Jack", "Black"))
                .add(new User(21, "male", "Bill", "Clinton"))
                .add(new User(21, "female", "Sarah", "Parker"))
                .build();

        return userStream.collect(Collectors.toMap(
                user -> user.getLastName(),
                user -> String.format("Age: %d\nSex: %s", user.getAge(), user.getSex())
        ));
    }
}

class User {
    private final int age;
    private final String sex;
    private final String firstName;
    private final String lastName;

    public User(int age, String sex, String firstName, String lastName) {
        this.age = age;
        this.sex = sex;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}