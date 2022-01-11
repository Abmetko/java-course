package com.java_course.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class Car {

    public static final Logger rootLogger = LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
    private static final Logger log = LoggerFactory.getLogger(Car.class);

    public void driveCar() {
    }

    public void stopCar() {
        log.info("Car stopped.");
    }

    public void speedLimit() {
        double speed = Math.random() * 10 + 55;
        if (speed > 60) {
            rootLogger.error("Speed limit exceeded: {} {}", (int) speed, "km/h");
        } else {
            rootLogger.info("Speed limit is not exceeded: {} {}", (int) speed, "km/h");
        }
    }
}