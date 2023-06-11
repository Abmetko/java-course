package com.java_course.deserialization;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.RestAssured;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.mapper.factory.Jackson2ObjectMapperFactory;
import lombok.SneakyThrows;

import java.lang.reflect.Type;

public class RestAssuredEnableWrapping {

    @SneakyThrows
    public static void main(String[] args) {
        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(new ObjectMapperConfig().jackson2ObjectMapperFactory(
                new Jackson2ObjectMapperFactory() {
                    @Override
                    public ObjectMapper create(Type type, String s) {
                        ObjectMapper mapper = new ObjectMapper();
                        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
                        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
                        return mapper;
                    }
                }
        ));
    }
}
