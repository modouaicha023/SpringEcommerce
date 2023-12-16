package com.ecommerce.microcommerce.dto;

import java.util.List;

import com.ecommerce.microcommerce.model.Product;

public class UserDto {

    private Integer id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private List<Product> products;

    public UserDto() {
    }

    public UserDto(Integer id, String firstName, String lastName, String username, String password,
            List<Product> products) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.products = products;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
