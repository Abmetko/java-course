package com.java_course.deserialization;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.SneakyThrows;

import java.io.File;

public class DeserializationTestClass {

    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
        objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

        User user = objectMapper.readValue(new File("src/main/java/com/java_course/deserialization/User.json"), User.class);

        objectMapper.writeValue(new File("src/main/java/com/java_course/deserialization/User3.json"), user);
    }
}

//RestAssured.config = RestAssuredConfig.config().objectMapperConfig(new ObjectMapperConfig().jackson2ObjectMapperFactory(
//new Jackson2ObjectMapperFactory() {
//        @Override
//        public ObjectMapper create(Class aClass, String s) {
//            FilterProvider filter = new SimpleFilterProvider().addFilter(...);
//            ObjectMapper objectMapper = new ObjectMapper();
//            objectMapper.setFilters(filter);
//            return objectMapper;
//        }
//    }
//));