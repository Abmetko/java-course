package com.cast;

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

    public static short shortVariable = 10;
    public static int intVariable = 20;

    public static short shortVariable2 = 10;
    public static int intVariable2 = 20;

    public static void main(String[] args) {

        //размещаем в больший контейнер содержимое меньшего контейнера - автоматическое приведение типов
        intVariable = shortVariable;

        //размещаем в меньший контейнер содержимое большего контейнера - явное приведение типов
        shortVariable2 = (short) intVariable2;
    }
}