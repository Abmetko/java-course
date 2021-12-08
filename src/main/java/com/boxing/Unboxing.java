package com.boxing;

@SuppressWarnings("all")
public class Unboxing {

    Integer iOb;
    Double dOb;
    Character cOb;
    Boolean bOb;

    //TODO - при присвоении

    //присвоение без автораспаковки
    int i = iOb.intValue();
    double d = dOb.doubleValue();
    char c = cOb.charValue();
    boolean b = bOb.booleanValue();

    //присвоение с автораспаковкой
    int i2 = iOb;
    double d2 = dOb;
    char c2 = cOb;
    boolean b2 = bOb;

    public static void main(String[] args) {
        //TODO - в выражениях
        Integer iOb1 = new Integer(5);
        Integer iOb2 = new Integer(7);

        //сравнение без автораспаковки
        System.out.println(iOb1.intValue() > iOb2.intValue());

        //сравнение с автораспаковкой
        System.out.println(iOb1 > iOb2);





        /*
        В первом случае фактически вызывается статичный метод java.lang.Integer.valueOf(int),
        который кэширует значения от -128 до 127 (верхнюю границу можно изменять) и
        при повторном использовании достает их из так называемого pool (набор инициализированных
        и готовых к использованию объектов) --> true. Во втором происходит явное создание объектов --> false,
        следовательно они имеют разные ссылки.
         */

        //#1
        Integer iOb3 = 100;
        Integer iOb4 = 100;
        System.out.println(iOb3 == iOb4);//true

        //#2
        Integer iOb5 = new Integer(120);
        Integer iOb6 = new Integer(120);
        System.out.println(iOb5 == iOb6);//false

        Integer iOb7 = 200;
        Integer iOb8 = 200;
        System.out.println(iOb7 == iOb8);//false

        //TODO - при передаче в метод с автораспаковкой
        Integer iOb = 10;

        method(iOb);
    }

    public static void method(int i) {
        System.out.println("int: " + i);
    }
}