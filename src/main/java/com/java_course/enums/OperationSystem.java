package com.java_course.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OperationSystem {

    ANDROID("Android"),
    IOS("iOS");

    private final String value;
}