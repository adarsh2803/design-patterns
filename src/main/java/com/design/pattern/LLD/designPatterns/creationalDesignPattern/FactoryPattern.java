package com.design.pattern.LLD.designPatterns.creationalDesignPattern;

/*
    Factory Design Pattern is used to create objects without specifying the exact class of object
    It is decided at the run-time , which actual class will be used for initialization

    How to achieve :- Parent Interface is used to create object - line no. 44/45
 */

// Define the Shape interface and its concrete implementations
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

// Create a ShapeFactory to produce Shape objects
class ShapeFactory {
    public Shape createShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("Circle")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("Rectangle")) {
            return new Rectangle();
        }
        return null; // Return null if an unsupported shape type is provided.
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();

        // Create shapes using the factory
        Shape circle = factory.createShape("Circle");
        Shape rectangle = factory.createShape("Rectangle");

        circle.draw();
        rectangle.draw();
    }
}

