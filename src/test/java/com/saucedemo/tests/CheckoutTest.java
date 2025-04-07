package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.model.entities.CheckoutInfo;
import com.saucedemo.model.entities.Product;
import com.saucedemo.model.entities.User;
import com.saucedemo.model.testcasesmodels.CheckoutTestCaseModel;
import com.saucedemo.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void fullPurchaseFlow_shouldCompleteSuccessfully() {

        CheckoutTestCaseModel testCase = testCases.get("fullPurchaseFlow_shouldCompleteSuccessfully");
        User user = testCase.getUser();
        CheckoutInfo checkoutInfo = user.getCheckoutInfo();
        Product product = testCase.getProduct();


        // === Login ===
        new LoginPage(driver).loginAs(user.getUserCredentials().getUsername(), user.getUserCredentials().getPassword());

        // === Catálogo ===
        ProductsPage productsPage = new ProductsPage(driver);
        Assertions.assertTrue(productsPage.isLoaded());
        productsPage.addProductToCartByName(product.getName());
        productsPage.goToCart();

        // === Carrito ===
        CartPage cartPage = new CartPage(driver);
        Assertions.assertTrue(cartPage.isProductInCart(product.getName()), "Producto no está en el carrito");
        cartPage.clickCheckout();

        // === Checkout ===
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillCustomerInformation(checkoutInfo.getFirstName(), checkoutInfo.getLastName(), checkoutInfo.getZipCode());
        checkoutPage.finishOrder();

        // === Confirmación ===
        Assertions.assertTrue(checkoutPage.isOrderComplete(), "No se completó la orden correctamente");
    }
}