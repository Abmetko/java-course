package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Colors {
    GREY("silver grey"),
    GREEN("light green");

    private final String value;
}