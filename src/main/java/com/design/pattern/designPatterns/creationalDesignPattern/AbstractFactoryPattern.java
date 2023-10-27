package com.design.pattern.designPatterns.creationalDesignPattern;

/*
    Abstract Factory Pattern is used to maintain consistency in the design (methods/functions) of the objects
    How to achieve - ensure objects created belong to common Parent Interface
 */

// Abstract Factory Interface
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory for Windows
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory for macOS
class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

// Abstract Product: Button
interface Button {
    void paint();
}

// Concrete Product for Windows
class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a Windows button");
    }
}

// Concrete Product for macOS
class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("Rendering a macOS button");
    }
}

// Abstract Product: Checkbox
interface Checkbox {
    void paint();
}

// Concrete Product for Windows
class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a Windows checkbox");
    }
}

// Concrete Product for macOS
class MacOSCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Rendering a macOS checkbox");
    }
}

// Client code
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        GUIFactory factory;

        // Create a UI for Windows
        factory = new WindowsFactory();
        Button windowsButton = factory.createButton();
        Checkbox windowsCheckbox = factory.createCheckbox();
        windowsButton.paint();
        windowsCheckbox.paint();

        // Create a UI for macOS
        factory = new MacOSFactory();
        Button macButton = factory.createButton();
        Checkbox macCheckbox = factory.createCheckbox();
        macButton.paint();
        macCheckbox.paint();
    }
}
