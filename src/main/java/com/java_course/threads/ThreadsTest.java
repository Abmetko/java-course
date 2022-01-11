package com.java_course.threads;

public class ThreadsTest extends Thread {

    public static void main(String[] args) {
        ThreadsTest threadsTest = new ThreadsTest();
        threadsTest.start();
    }

    @Override
    public void run() {
        System.out.println(System.currentTimeMillis());
    }
}