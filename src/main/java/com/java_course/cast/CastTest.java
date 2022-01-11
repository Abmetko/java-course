package com.java_course.cast;

public class CastTest {

    /**
     * byte = 1 байт
     * <p>
     * short = 2 байта
     * <p>
     * int = 4 байта
     * <p>
     * long = 8 байт
     * <p>
     * float = 4 байта
     * <p>
     * double = 8 байт
     * <p>
     * char = 2 байта
     */

    public static int intVariable = 10;
    public static long longVariable = 10;

    public static void main(String[] args) {

        //размещаем в больший контейнер содержимое меньшего контейнера - автоматическое приведение типов
        longVariable = intVariable;

        //размещаем в меньший контейнер содержимое большего контейнера - явное приведение типов
        intVariable = (int) longVariable;
    }
}