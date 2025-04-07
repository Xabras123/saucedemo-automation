package com.saucedemo.model.entities;

public class User {

    private UserCredentials userCredentials;
    private CheckoutInfo checkoutInfo;
    private boolean valid;

    public UserCredentials getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(UserCredentials userCredentials) {
        this.userCredentials = userCredentials;
    }

    public CheckoutInfo getCheckoutInfo() {
        return checkoutInfo;
    }

    public void setCheckoutInfo(CheckoutInfo checkoutInfo) {
        this.checkoutInfo = checkoutInfo;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}