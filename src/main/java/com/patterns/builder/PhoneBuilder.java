package com.patterns.builder;

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

    public PhoneBuilder setTablet(Boolean tablet) {
        this.mobilePhone.tablet = tablet;
        return this;
    }

    public PhoneBuilder setOsVersion(double osVersion) {
        this.mobilePhone.osVersion = osVersion;
        return this;
    }

    public MobilePhone build() {
        return mobilePhone;
    }
}