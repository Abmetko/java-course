package com.boxing;

@SuppressWarnings("all")
public class Autoboxing {

    Integer iOb1 = new Integer(7);
    Double dOb1 = new Double(7.0);
    Character cOb1 = new Character('a');
    Boolean bOb1 = new Boolean(true);

    //автоматическая инкапсуляция примитивного типа в эквивалентную ему класс-обёртку
    Integer iOb2 = 7;
    Double dOb2 = 7.0;
    Character cOb2 = 'a';
    Boolean bOb2 = true;

    public static void main(String[] args) {
        //при передаче в метод без автоупаковки
        method(new Integer(7));

        //то же самое с автоупаковкой
        method(7);
    }

    public static void method(Integer iOb) {
        System.out.println("Integer: " + iOb);
    }

    public static void method(int iOb) {
        System.out.println("Integer: " + iOb);
    }
}