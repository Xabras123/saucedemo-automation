package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.model.entities.User;
import com.saucedemo.model.testcasesmodels.LoginTestCaseModel;
import com.saucedemo.model.testcasesmodels.ProductTestCaseModel;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.utils.TestDataLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LoginTest extends BaseTest<LoginTestCaseModel> {
    public LoginTest() {
        super("loginCases.json", LoginTestCaseModel.class);
    }

    @Test
    public void loginWithValidCredentials_shouldNavigateToProducts() {



        LoginTestCaseModel testCase = testCases.get("loginWithValidCredentials_shouldNavigateToProducts");
        User user = testCase.getUser();


        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(user.getUserCredentials().getUsername(), user.getUserCredentials().getPassword());

        Assertions.assertTrue(loginPage.isOnProductsPage(), "No se redireccionó a la página de productos");
    }

    @Test
    public void loginWithInvalidCredentials_shouldShowErrorMessage() {

        LoginTestCaseModel testCase = testCases.get("loginWithInvalidCredentials_shouldShowErrorMessage");
        User user = testCase.getUser();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(user.getUserCredentials().getUsername(), user.getUserCredentials().getPassword());

        String expectedError = "Epic sadface: Username and password do not match any user in this service";
        Assertions.assertEquals(expectedError, loginPage.getErrorMessage());
    }
}
