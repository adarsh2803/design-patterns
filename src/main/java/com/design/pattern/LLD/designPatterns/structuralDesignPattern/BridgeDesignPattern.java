package com.design.pattern.LLD.designPatterns.structuralDesignPattern;

/*
     Bridge Pattern provides more flexibility of combination , here instead making 4 diff implementation combination
     like instead making 4 seperate SquareBlue , SquareRed , CircleBlue , CircleRed class and defining draw()
     we just defined 2 functions - 1 applyColor() , 1 draw()

     How to achieve :- Bridge Pattern says , whenever there in diff kind of common functionality then break it into seperate
     group or interface . Like here Shape and Color
*/

// Abstraction
interface ShapeDesign {
    void draw();
}

// Concrete Abstraction
class Circle implements ShapeDesign {
    private Color color;

    public Circle(Color color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.print("Drawing a Circle with " + color.applyColor());

    }
}

class Square implements ShapeDesign {
    private Color color;

    public Square(Color color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.print("Drawing a Square with " + color.applyColor());
    }
}

// Implementor
interface Color {
    String applyColor();
}

// Concrete Implementor
class RedColor implements Color {
    @Override
    public String applyColor() {
        return "Red color";
    }
}

class BlueColor implements Color {
    @Override
    public String applyColor() {
        return "Blue color";
    }
}

public class BridgeDesignPattern {
    public static void main(String[] args) {
        ShapeDesign redCircle = new Circle(new RedColor());
        ShapeDesign blueSquare = new Square(new BlueColor());

        redCircle.draw();  // Output: Drawing a Circle with Red color
        blueSquare.draw(); // Output: Drawing a Square with Blue color
    }
}
