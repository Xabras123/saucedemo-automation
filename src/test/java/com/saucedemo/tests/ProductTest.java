package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest extends BaseTest {

    @Test
    public void productsPageShouldListAllItemsAndAddToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        Assertions.assertTrue(productsPage.isLoaded(), "No se cargó la página de productos");

        String productToAdd = "Sauce Labs Backpack";
        Assertions.assertTrue(productsPage.isProductInList(productToAdd), "Producto no encontrado en la lista");

        productsPage.addProductToCartByName(productToAdd);
        productsPage.goToCart();

        // A futuro: validar que el producto está en el carrito.
    }
}
