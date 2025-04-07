package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CartTest extends BaseTest {

    @Test
    public void productShouldAppearInCartAfterAdding() {
        String product = "Sauce Labs Backpack";

        // Login
        new LoginPage(driver).loginAs("standard_user", "secret_sauce");

        // Catálogo
        ProductsPage productsPage = new ProductsPage(driver);
        Assertions.assertTrue(productsPage.isLoaded(), "La página de productos no cargó.");
        productsPage.addProductToCartByName(product);
        productsPage.goToCart();

        // Carrito
        CartPage cartPage = new CartPage(driver);
        boolean isInCart = cartPage.isProductInCart(product);
        Assertions.assertTrue(isInCart, "El producto no está en el carrito después de agregarlo.");
    }

    // Si quieres agregar esta prueba opcional para eliminar producto:
    /*
    @Test
    public void productShouldBeRemovableFromCart() {
        String product = "Sauce Labs Backpack";

        new LoginPage(driver).loginAs("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.addProductToCartByName(product);
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        Assertions.assertTrue(cartPage.isProductInCart(product));

        cartPage.removeProductByName(product); // Este método aún no está en CartPage

        Assertions.assertFalse(cartPage.isProductInCart(product), "El producto aún aparece después de removerlo.");
    }
    */
}
