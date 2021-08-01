package com.patterns.builder;

import com.enums.Colors;
import com.enums.Dpi;
import com.enums.OperationSystem;
import com.enums.SystemVersion;

public class TestBuilder {

    public static void main(String[] args) {
        PhoneBuilder phoneBuilder = new PhoneBuilder();

        MobilePhone mobilePhone = phoneBuilder
                .setColor(Colors.GREY.getValue())
                .setOsType(OperationSystem.ANDROID.getValue())
                .setOsVersion(SystemVersion.OREO.getValue())
                .isTablet(false)
                .setDpi(Dpi.XHDPI.name())
                .build();

        //TODO - текущее значение поля объекта
        System.out.printf("Android version is '%s' %n", mobilePhone.osVersion);

        //TODO - изменяем значение поля
        phoneBuilder.setOsVersion(SystemVersion.NOUGAT.getValue());

        //TODO - проверяем измененное значение поля
        System.out.printf("Android version is '%s' %n", mobilePhone.osVersion);
    }
}