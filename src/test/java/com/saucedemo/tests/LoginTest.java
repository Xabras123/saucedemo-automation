package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials_shouldNavigateToProducts() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("standard_user", "secret_sauce");

        Assertions.assertTrue(loginPage.isOnProductsPage(), "No se redireccionó a la página de productos");
    }

    @Test
    public void loginWithInvalidCredentials_shouldShowErrorMessage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("invalid_user", "wrong_password");

        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assertions.assertEquals(expectedError, loginPage.getErrorMessage());
    }
}
