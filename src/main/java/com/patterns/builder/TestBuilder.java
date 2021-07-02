package com.patterns.builder;

import com.enums.Colors;
import com.enums.OperationSystem;
import com.enums.SystemVersion;

public class TestBuilder {

    public static void main(String[] args) {
        PhoneBuilder phoneBuilder = new PhoneBuilder();

        MobilePhone mobilePhone = phoneBuilder
                .setColor(Colors.GREY.getValue())
                .setOsType(OperationSystem.ANDROID.getValue())
                .setOsVersion(SystemVersion.OREO.getValue())
                .setTablet(false)
                .build();

        System.out.printf("Android version is '%s' %n", mobilePhone.osVersion);

        phoneBuilder.setOsVersion(SystemVersion.NOUGAT.getValue());

        /* check object is changed by means of builder */
        System.out.printf("Android version is '%s' %n", mobilePhone.osVersion);
    }
}