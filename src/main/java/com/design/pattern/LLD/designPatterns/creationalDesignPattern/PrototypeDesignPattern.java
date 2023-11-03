package com.design.pattern.LLD.designPatterns.creationalDesignPattern;

import java.util.ArrayList;
import java.util.List;

/*
    Prototype Design Pattern is used when object is initializion is time and resource intensive .
    ie. fetching data from DataBase for initializing object
 */

class BookShop implements Cloneable {
    private String storeName;
    private List<String> bookNames = new ArrayList<>();

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<String> getBookNames() {
        return bookNames;
    }

    public void setBookNames(List<String> bookNames) {
        this.bookNames = bookNames;
    }

    //This load data is copying data from DataBase
    public void loadBooks(){
        for(int i=0;i<10;i++){
            getBookNames().add("Book"+i);
        }
    }


    @Override
    public String toString() {
        return "BookShop{" +
                "storeName='" + storeName + '\'' +
                ", bookNames=" + bookNames +
                '}';
    }

    //Custom clone function which make a deep copy of object , here we will copy object step by step
    @Override
    public BookShop clone() {
        BookShop bookShop = new BookShop();
        bookShop.getBookNames().addAll(this.getBookNames());
        return bookShop;
    }
}

public class PrototypeDesignPattern {
    public static void main(String[] args) {
        BookShop shop = new BookShop();
        shop.setStoreName("Store 1");
        shop.loadBooks();
        BookShop cloneShop = shop.clone();
        cloneShop.setStoreName("Store 2");
        System.out.println(shop);
        System.out.println(cloneShop);

        shop.getBookNames().remove(1);
        System.out.println(shop);
        System.out.println(cloneShop);

    }
}
