package com.design.pattern.LLD.importantLearnings;

import java.util.ArrayList;
import java.util.List;

/*
    When you implements cloneable , then it do shallow copy ..
    to make deep copy you need to make a customClone function
 */

class BookShop implements Cloneable{
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

    //This will make a shallow copy of Object
    @Override
    public BookShop clone() throws CloneNotSupportedException {
        BookShop clone = (BookShop) super.clone();
        return clone;
    }

    public void loadBooks(){
        for(int i=0;i<10;i++){
            this.getBookNames().add("Book"+i);
        }
    }

    @Override
    public String toString() {
        return "BookShop{" +
                "storeName='" + storeName + '\'' +
                ", bookNames=" + bookNames +
                '}';
    }
}



public class ShallowCopyPrototypeDesign {
    public static void main(String[] args) throws CloneNotSupportedException {
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
