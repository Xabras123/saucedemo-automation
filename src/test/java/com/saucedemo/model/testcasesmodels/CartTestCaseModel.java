package com.saucedemo.model.testcasesmodels;

import com.saucedemo.model.entities.Product;

public class CartTestCaseModel extends LoginTestCaseModel {
    private Product product;
    private String expectedResult;

    public Product getProduct() {
        return product;
    }

    public String getExpectedResult() {
        return expectedResult;
    }
}
