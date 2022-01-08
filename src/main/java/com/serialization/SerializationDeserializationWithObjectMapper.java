package com.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.File;

//библиотека Jackson для работы с сериализацией/десериализацией объектов JSON
public class SerializationDeserializationWithObjectMapper {

    @SneakyThrows
    public static void main(String[] args) {

        //ObjectMapper API
        ObjectMapper mapper = new ObjectMapper();

        //сериализация данных объекта в файл
        mapper.writeValue(new File("src/main/java/com/serialization/user.json"), new Human("John", "LA", 80));

        //десериализация данных из файла в java объект
        Human human = mapper.readValue(new File("src/main/java/com/serialization/user.json"), Human.class);
        System.out.println(human.age);//вывод на печать поля объекта --> 80

        //десериализация данных из строки в java объект
        String json = "{\"name\":\"John\",\"address\":\"LA\",\"age\":60}";
        Human human2 = mapper.readValue(json, Human.class);
        System.out.println(human2.age);//вывод на печать поля объекта --> 60
    }
}