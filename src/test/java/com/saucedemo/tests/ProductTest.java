package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.model.entities.Product;
import com.saucedemo.model.entities.User;
import com.saucedemo.model.testcasesmodels.ProductTestCaseModel;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.saucedemo.constants.ErrorMessages.PRODUCT_NOT_PRESENT;
import static com.saucedemo.constants.ErrorMessages.PRODUCT_PAGE_NOT_LOADED;


public class ProductTest extends BaseTest<ProductTestCaseModel> {

    public ProductTest() {
        super("productCases.json", ProductTestCaseModel.class);
    }

    @Test
    public void productsPageShouldListAllItemsAndAddToCart() {


        ProductTestCaseModel testCase = testCases.get("productShouldAppearInCartAfterAdding");
        User user = testCase.getUser();
        Product product = testCase.getProduct();

        // === Login ===

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(user.getUserCredentials().getUsername(), user.getUserCredentials().getPassword());

        // === Catalog ===

        ProductsPage productsPage = new ProductsPage(driver);
        Assertions.assertTrue(productsPage.isLoaded(), PRODUCT_PAGE_NOT_LOADED.get());
        Assertions.assertTrue(productsPage.isProductInList(product.getName()), PRODUCT_NOT_PRESENT.get());

        // === Cart ===
        productsPage.addProductToCartByName(product.getName());
        productsPage.goToCart();

    }

}
