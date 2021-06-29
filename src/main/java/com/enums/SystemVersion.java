package com.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SystemVersion {

    NOUGAT(7.0),
    OREO(8.0),
    PIE(9.0),
    ANDROID_10(10.0),
    ANDROID_11(11.0);

    private final Double value;
}