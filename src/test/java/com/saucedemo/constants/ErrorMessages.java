package com.saucedemo.constants;

public enum ErrorMessages {

    LOGIN_PAGE_NOT_LOADED("Not redirected to login page"),
    PRODUCT_PAGE_NOT_LOADED("Not redirected to products page"),
    LOGIN_FAILED_LOGIN("Epic sadface: Username and password do not match any user in this service"),
    PRODUCT_NOT_IN_CART("Product not in cart"),
    PRODUCT_NOT_PRESENT("Product not present inf list"),
    ORDER_NOT_COMPLETED("Purchased failed");
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }


}
