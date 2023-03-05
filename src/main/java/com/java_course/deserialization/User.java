package com.java_course.deserialization;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@JsonRootName(value = "user")
@Data
public class User {
    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private int age;
}