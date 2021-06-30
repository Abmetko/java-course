package com.lambda;

import java.util.concurrent.TimeoutException;


public class Lambda {

    private static void sleep(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void whileTrue(int pollingIntervalMs, int timeoutMilliseconds, MyInterface<Boolean> myInterface, String exceptionMsg) throws TimeoutException {
        long timeStart = System.currentTimeMillis();
        while (myInterface.get()) {
            if (System.currentTimeMillis() - timeStart > timeoutMilliseconds) {
                throw new TimeoutException(String.format("Time out after %d ms: ", timeoutMilliseconds) + exceptionMsg);
            }
            sleep(pollingIntervalMs);
        }
    }

    public static void main(String[] args) throws TimeoutException {
        whileTrue(2000, 10000, () -> {
            if(3>2) {
                return true;
            }
            else return false;
        }, "failed...");
    }
}