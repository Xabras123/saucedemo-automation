package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.model.entities.Product;
import com.saucedemo.model.entities.User;
import com.saucedemo.model.testcasesmodels.CartTestCaseModel;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.utils.TestDataLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.saucedemo.constants.ErrorMessages.PRODUCT_NOT_IN_CART;
import static com.saucedemo.constants.ErrorMessages.PRODUCT_PAGE_NOT_LOADED;

public class CartTest extends BaseTest<CartTestCaseModel> {

    public CartTest() {
        super("cartCases.json", CartTestCaseModel.class);
    }

    @Test
    public void productShouldAppearInCartAfterAdding() {

        CartTestCaseModel testCase = testCases.get("productShouldAppearInCartAfterAdding");
        User user = testCase.getUser();
        Product product = testCase.getProduct();

        // Login
        new LoginPage(driver).loginAs(user.getUserCredentials().getUsername(), user.getUserCredentials().getPassword());

        // Catalog
        ProductsPage productsPage = new ProductsPage(driver);
        Assertions.assertTrue(productsPage.isLoaded(), PRODUCT_PAGE_NOT_LOADED.get());
        productsPage.addProductToCartByName(product.getName());
        productsPage.goToCart();

        // Cart
        CartPage cartPage = new CartPage(driver);
        boolean isInCart = cartPage.isProductInCart(product.getName());
        Assertions.assertTrue(isInCart, PRODUCT_NOT_IN_CART.get());
    }
}
