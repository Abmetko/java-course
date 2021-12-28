package com.anonymous.extended;

public class AnonymousTest {

    /*
    Мы не создаем новый класс, наследующий класс Dog, а лишь переопределяем метод в анонимном классе.
    */

    static Dog dog = new Dog("brown") {
        @Override
        public String getColor() {
            return this.color + " - это переопределенный метод анонимного класса";
        }
    };

    public static void main(String[] args) {
        System.out.println(dog.getColor());
    }
}

class Dog {

    public String color;

    public Dog(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }
}