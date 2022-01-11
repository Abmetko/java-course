package com.java_course.patterns.builder;

public class PhoneBuilder {

    private final MobilePhone mobilePhone;

    public PhoneBuilder() {
        this.mobilePhone = new MobilePhone();
    }

    public PhoneBuilder setColor(String color) {
        this.mobilePhone.color = color;
        return this;
    }

    public PhoneBuilder setOsType(String osType) {
        this.mobilePhone.osType = osType;
        return this;
    }

    public PhoneBuilder isTablet(Boolean tablet) {
        this.mobilePhone.tablet = tablet;
        return this;
    }

    public PhoneBuilder setOsVersion(double osVersion) {
        this.mobilePhone.osVersion = osVersion;
        return this;
    }

    public PhoneBuilder setDpi(String dpi) {
        this.mobilePhone.dpi = dpi;
        return this;
    }

    public PhoneBuilder when() {
        return this;
    }

    public PhoneBuilder then() {
        return this;
    }

    public PhoneBuilder and() {
        return this;
    }

    public MobilePhone build() {
        return mobilePhone;
    }
}