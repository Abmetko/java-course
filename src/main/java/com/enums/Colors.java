package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Colors {
    GREY("grey"),
    GREEN("green");

    private final String value;
}