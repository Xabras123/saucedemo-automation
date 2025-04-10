package com.saucedemo.pages;

import com.saucedemo.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterUsername(String username) {
        WaitUtils.waitForVisibility(driver, usernameInput).sendKeys(username);
    }

    public void enterPassword(String password) {
        WaitUtils.waitForVisibility(driver, passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        WaitUtils.waitForClickability(driver, loginButton).click();
    }

    public void loginAs(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
        return WaitUtils.waitForVisibility(driver, errorMessage).getText();
    }

    public boolean isOnProductsPage() {
        return WaitUtils.waitForUrlContains(driver, "inventory.html");
    }
}
