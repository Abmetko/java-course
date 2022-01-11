package com.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class Car {

    private static final Logger log = LoggerFactory.getLogger(Car.class.getName());

    public void driveCar() {
    }

    public void stopCar() {
        log.debug("Stop car.");
    }

    public void speedLimit() {
        if(log.isDebugEnabled()) System.out.println("asdhaskdjasldjalsjdasdas");
        if ((Math.random() * 10 + 55) > 60) {
            log.error("Speed limit exceeded...");
        }
    }
}