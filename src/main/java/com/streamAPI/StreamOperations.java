package com.streamAPI;

import lombok.SneakyThrows;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class StreamOperations {

    //преобразование каждого элемента стрима
    public static Stream streamElementMapping() {
        return Stream.of(1, 2, 3).map(element -> element - 1);
    }

    //foreach
    public static void foreachStream() {
        streamElementMapping().forEach(element -> System.out.println(element));
    }

    //фильтр
    public static Stream streamFiltering() {
        return Stream.of(1, 2, 3).filter(element -> element % 2 != 0);
    }

    //получить результат перемножения всех элементов стрима
    public static int getResultOfMultiplication() {
        return Stream.of(1, 2, 3, 2)
                .reduce((left, right) -> left * right)
                .get();
    }

    //преобразование стрима в List
    public static List<String> getListFromStream() {
        return Stream.of("Tom", "Nick", "Charlie")
                .collect(Collectors.toList());
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
                user -> user.getLastName(),//определили ключ
                user -> String.format("Age: %d\nSex: %s", user.getAge(), user.getSex())//определили значение
        ));
    }

    public static void streamTerminalOperation() {
        Stream<String> stream = Stream.of("Tom", "Nick", "Charlie");
        stream.count();//терминальная операция для объекта стрим
        stream.forEach(i -> System.out.println(i));//IllegalStateException: stream has already been operated upon or closed
    }

    public static void streamThrowExceptionTest(int val) {
        IntStream.rangeClosed(1, 10)
                .filter(i -> i == val)
                .findAny()
                .orElseThrow(() -> new NullPointerException(String.format("Элемента с таким значением нет: %d", val)));
        System.out.println("PASSED...");
    }

    //в случае если в стриме будет более одного элемента, то метод reduce() выполнится и в теле лямбда выражения сгенерится exception
    public static void streamOnlyOneElementInStream() {
        Stream.of(1,3)
                .reduce((left, right) -> {
                    throw new IllegalStateException("Элементов оказывается более одного...");
                });
    }

    @SneakyThrows
    public static void main(String[] args) {
//        System.out.println(getMapFromStream().get("Parker"));
//
//        streamTerminalOperation();
//
//        streamOnlyOneElementInStream();

        streamOnlyOneElementInStream();
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