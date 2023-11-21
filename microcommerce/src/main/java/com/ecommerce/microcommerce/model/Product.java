package com.ecommerce.microcommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Product {
    private int id;
    private String name;
    private int price;
    @JsonIgnore
    private int purchasePrice;

    public Product() {
    }

    public Product(int id, String name, int price,int purchasePrice) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.purchasePrice = purchasePrice;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
