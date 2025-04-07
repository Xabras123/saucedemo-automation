package com.saucedemo.model.entities;
import java.util.List;

public class TestData {
    public List<User> users;
    public List<Product> products;


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
