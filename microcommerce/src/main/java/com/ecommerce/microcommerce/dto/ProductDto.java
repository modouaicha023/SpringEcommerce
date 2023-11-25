package com.ecommerce.microcommerce.dto;


public class ProductDto {

    private int id;
    private String name;

    private int price;

    private int purchaseprice;

    public ProductDto( String name, int price, int purchaseprice) {
        this.name = name;
        this.price = price;
        this.purchaseprice = purchaseprice;
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

    public int getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(int purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

}