package com.patterns.builder;

import com.enums.Colors;
import com.enums.Dpi;
import com.enums.OperationSystem;
import com.enums.SystemVersion;

public class TestBuilder {

    public static void main(String[] args) {
        PhoneBuilder phoneBuilder = new PhoneBuilder();

        MobilePhone mobilePhone = phoneBuilder
                .when()
                .setColor(Colors.GREY.getValue())
                .setOsType(OperationSystem.ANDROID.getValue())
                .setOsVersion(SystemVersion.OREO.getValue())
                .isTablet(false)
                .setDpi(Dpi.XHDPI.name())
                .then()
                .build();

        //текущее значение поля объекта
        System.out.printf("Android version is '%s' %n", mobilePhone.osVersion);

        //изменяем значение поля - тем самым вносим изменение в существующий объект класса MobilePhone
        phoneBuilder.setOsVersion(SystemVersion.NOUGAT.getValue());

        //проверяем измененное значение поля
        System.out.printf("Android version is '%s' %n", mobilePhone.osVersion);
    }
}