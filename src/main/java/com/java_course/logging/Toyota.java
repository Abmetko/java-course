package com.java_course.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Toyota extends Car {

    private static final Logger log = LoggerFactory.getLogger(Toyota.class);

    public static void main(String[] args) {
        System.out.print("\n");
        Toyota toyota = new Toyota();
        toyota.driveCar();
        toyota.speedLimit();
        toyota.stopCar();
        toyota.closeToyota();
    }

    @Override
    public void driveCar() {
        log.info("Drive toyota.");
    }

    public void closeToyota() {
        rootLogger.info("Alarm is on.");//root logger
    }
}