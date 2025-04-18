package com.saucedemo.model.testcasesmodels;

import com.saucedemo.model.entities.CheckoutInfo;
import com.saucedemo.model.entities.Product;
import com.saucedemo.model.entities.User;

public class CheckoutTestCaseModel extends LoginTestCaseModel {
    private Product product;
    private CheckoutInfo checkoutInfo;
    private String expectedResult;



    public Product getProduct() {
        return product;
    }

    public CheckoutInfo getCheckoutInfo() {
        return checkoutInfo;
    }

    public String getExpectedResult() {
        return expectedResult;
    }
}
