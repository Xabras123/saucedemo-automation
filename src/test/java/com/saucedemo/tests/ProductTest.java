package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.model.entities.Product;
import com.saucedemo.model.entities.User;
import com.saucedemo.model.testcasesmodels.ProductTestCaseModel;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductTest extends BaseTest<ProductTestCaseModel> {

    public ProductTest() {
        super("productCases.json", ProductTestCaseModel.class);
    }

    @Test
    public void productsPageShouldListAllItemsAndAddToCart() {

        ProductTestCaseModel testCase = testCases.get("productShouldAppearInCartAfterAdding");
        User user = testCase.getUser();
        Product product = testCase.getProduct();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(user.getUserCredentials().getUsername(), user.getUserCredentials().getPassword());

        ProductsPage productsPage = new ProductsPage(driver);
        Assertions.assertTrue(productsPage.isLoaded(), "No se cargó la página de productos");

        Assertions.assertTrue(productsPage.isProductInList(product.getName()), "Producto no encontrado en la lista");

        productsPage.addProductToCartByName(product.getName());
        productsPage.goToCart();

        // A futuro: validar que el producto está en el carrito.
    }

}
