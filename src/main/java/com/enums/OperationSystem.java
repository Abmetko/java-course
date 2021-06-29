package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OperationSystem {
    ANDROID("Android"),
    IOS("iOS");

    private final String value;
}