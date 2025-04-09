package com.saucedemo.tests;

import com.saucedemo.base.BaseTest;
import com.saucedemo.model.entities.User;
import com.saucedemo.model.testcasesmodels.LoginTestCaseModel;
import com.saucedemo.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.saucedemo.constants.ErrorMessages.LOGIN_FAILED_LOGIN;
import static com.saucedemo.constants.ErrorMessages.PRODUCT_PAGE_NOT_LOADED;

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

        Assertions.assertTrue(loginPage.isOnProductsPage(),PRODUCT_PAGE_NOT_LOADED.get() );
    }

    @Test
    public void loginWithInvalidCredentials_shouldShowErrorMessage() {

        LoginTestCaseModel testCase = testCases.get("loginWithInvalidCredentials_shouldShowErrorMessage");
        User user = testCase.getUser();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs(user.getUserCredentials().getUsername(), user.getUserCredentials().getPassword());

        String expectedError = LOGIN_FAILED_LOGIN.get();
        Assertions.assertEquals(expectedError, loginPage.getErrorMessage());
    }
}
