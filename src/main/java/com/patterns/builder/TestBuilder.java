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

        /* check current value of object field */
        System.out.printf("Android version is '%s' %n", mobilePhone.osVersion);

        /* modify the object */
        phoneBuilder.setOsVersion(SystemVersion.NOUGAT.getValue());

        /* check modified object */
        System.out.printf("Android version is '%s' %n", mobilePhone.osVersion);
    }
}