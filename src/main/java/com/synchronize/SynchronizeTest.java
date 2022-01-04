package com.synchronize;

@SuppressWarnings("all")
public class SynchronizeTest {

    private static Long currentTime;

    /*
    Если метод синхронизирован, то первый отработавший по скорости поток, отработав, проинициализировал поле currentTime,
    и все последующие потоки будут дожидаться пока предыдущий не отработал - и, соответственно, не попадут в условие.

    Это необходимо если надо держать единственный вызов например создания сессионного id юзера, чтобы не плодить несколько.
    */
    public static synchronized void setCurrentTime() {
        if (currentTime == null) {
            currentTime = System.currentTimeMillis();
            System.out.println(currentTime);
        }
    }

    /*
    При отсутствии синхронизации, метод может переопределить поле от 1 до 6 раз, попадая в блок if.
    */
//    public static void setCurrentTime() {
//        if (currentTime == null) {
//            currentTime = System.currentTimeMillis();
//            System.out.println(currentTime);
//        }
//    }

    public static void main(String[] args) {
        Thread thread_1 = new Thread(() -> setCurrentTime());
        Thread thread_2 = new Thread(() -> setCurrentTime());
        Thread thread_3 = new Thread(() -> setCurrentTime());
        Thread thread_4 = new Thread(() -> setCurrentTime());
        Thread thread_5 = new Thread(() -> setCurrentTime());
        Thread thread_6 = new Thread(() -> setCurrentTime());

        thread_1.start();
        thread_2.start();
        thread_3.start();
        thread_4.start();
        thread_5.start();
        thread_6.start();
    }
}