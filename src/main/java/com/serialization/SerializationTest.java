package com.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;

public class SerializationTest {

    @SneakyThrows
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        //сериализация данных объекта в файл
        mapper.writeValue(new File("src/main/java/com/serialization/user.json"), new MyClass("John", "LA", 80));

        //дессериализация данных из файла в java обьект
        MyClass myClass = mapper.readValue(new File("src/main/java/com/serialization/user.json"), MyClass.class);
        System.out.println(myClass.age);//вывод на печать поля обьекта --> 80

        //дессериализация данных из файла в java обьект
        String json = "{\"name\":\"John\",\"address\":\"LA\",\"age\":60}";
        MyClass myClass2 = mapper.readValue(json, MyClass.class);
        System.out.println(myClass2.age);//вывод на печать поля обьекта --> 60
    }
}