package com.design.pattern.LLD.designPatterns.structuralDesignPattern;

/*
        Proxy design design pattern is used when you want to filter the request based on ips ,
        implement a caching system , lazing loading . instead of giving real object , give the proxy object

 */

interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading image: " + filename);
    }

    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

class ImageProxy implements Image {
    private RealImage realImage;
    private String filename;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

public class ProxyDesignPattern {
    public static void main(String[] args) {
        Image image1 = new ImageProxy("image1.jpg");
        Image image2 = new ImageProxy("image2.jpg");

        // Images are loaded only when displayed
        image1.display();
        image2.display();

        //image not reloaded
        image1.display();
        image2.display();
    }
}
