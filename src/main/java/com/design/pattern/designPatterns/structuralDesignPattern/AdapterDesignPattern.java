package com.design.pattern.designPatterns.structuralDesignPattern;

/*
    Adapter Pattern is used when you want a legacy class to be compatible with incompatible interface.

    How to achieve :- Make a Wrapper/Adapter class which implements that interface and inside that use
    instance of legacy class and implements the interface methods accordingly
 */

class LegacyRectangle {
    public int calculateArea() {
        // Calculate area logic here
        return 10;
    }

    public void display() {
        // Display logic here
        System.out.println("Displaying a LegacyRectangle.");
    }
}

// Suppose this standard is followed in new code
interface Shape {
    int getArea();
    void draw();
}

class LegacyRectangleAdapter implements Shape {
    private LegacyRectangle legacyRectangle;

    public LegacyRectangleAdapter(LegacyRectangle legacyRectangle) {
        this.legacyRectangle = legacyRectangle;
    }

    @Override
    public int getArea() {
        return legacyRectangle.calculateArea();
    }

    @Override
    public void draw() {
        legacyRectangle.display();
    }
}

public class AdapterDesignPattern {
    public static void main(String[] args) {
        LegacyRectangle legacyRectangle = new LegacyRectangle();
        Shape adaptedRectangle = new LegacyRectangleAdapter(legacyRectangle);

        // Now you can use the adaptedRectangle with the new system
        System.out.println("Area: " + adaptedRectangle.getArea());
        adaptedRectangle.draw();
    }
}
