package com.anonymous.implemented;

@FunctionalInterface
interface Dog {

    public String getColor();
}

public class AnonymousTest {

    /*
    Мы не создаем новый класс, для реализации интерфейса, а лишь реализуем метод в анонимном классе.
    */

    public static void main(String[] args) {
        Dog dog = new Dog() {
            public String getColor() {
                return "Это метод, реализующий метод интерфейса";
            }
        };
        System.out.println(dog.getColor());


        //альтернативная реализация с помощью лямбда выражения
        Dog dog2 = () -> {
            return "Это метод, реализуемый с помощью лямбда выражения";
        };
        System.out.println(dog2.getColor());
    }
}