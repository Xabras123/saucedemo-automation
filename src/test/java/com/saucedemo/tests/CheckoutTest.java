package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.model.entities.CheckoutInfo;
import com.saucedemo.model.entities.Product;
import com.saucedemo.model.entities.User;
import com.saucedemo.model.testcasesmodels.CheckoutTestCaseModel;
import com.saucedemo.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.saucedemo.constants.ErrorMessages.ORDER_NOT_COMPLETED;
import static com.saucedemo.constants.ErrorMessages.PRODUCT_PAGE_NOT_LOADED;


public class CheckoutTest extends BaseTest<CheckoutTestCaseModel>{

    public CheckoutTest() {
        super("checkoutCases.json", CheckoutTestCaseModel.class);
    }

    @Test
    public void fullPurchaseFlow_shouldCompleteSuccessfully() {

        CheckoutTestCaseModel testCase = (CheckoutTestCaseModel) testCases.get("fullPurchaseFlow_shouldCompleteSuccessfully");
        User user = testCase.getUser();
        CheckoutInfo checkoutInfo = user.getCheckoutInfo();
        Product product = testCase.getProduct();


        // === Login ===
        new LoginPage(driver).loginAs(user.getUserCredentials().getUsername(), user.getUserCredentials().getPassword());

        // === Catalog ===
        ProductsPage productsPage = new ProductsPage(driver);
        Assertions.assertTrue(productsPage.isLoaded());
        productsPage.addProductToCartByName(product.getName());
        productsPage.goToCart();

        // === Cart ===
        CartPage cartPage = new CartPage(driver);
        Assertions.assertTrue(cartPage.isProductInCart(product.getName()), PRODUCT_PAGE_NOT_LOADED.get());
        cartPage.clickCheckout();

        // === Checkout ===
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCustomerInformation(checkoutInfo.getFirstName(), checkoutInfo.getLastName(), checkoutInfo.getZipCode());
        checkoutPage.finishOrder();

        // === Confirmation ===
        Assertions.assertTrue(checkoutPage.isOrderComplete(), ORDER_NOT_COMPLETED.get());
    }

}