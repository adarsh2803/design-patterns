package com.design.pattern.designPatterns.creationalDesignPattern;

/*
    Singleton Design Pattern is used when you want only 1 instance of this class ,
    no matter how many times you initialize the object

    How to achieve :- static field variable and static method with private constructor
 */

class Singleton {
    // Private static instance of the Singleton class
    private static Singleton instance;

    // Private constructor to prevent instantiation from other classes
    private Singleton() {
        // Initialization code (if needed)
    }

    // Public method to provide the global point of access to the Singleton instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello, I am a Singleton!");
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        // Get the Singleton instance
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();

        System.out.println("address of singleton :: " + singleton);
        System.out.println("address of singleton1 :: " + singleton1);
        singleton.showMessage();
    }
}
