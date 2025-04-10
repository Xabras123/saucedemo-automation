package com.saucedemo.pages;

import com.saucedemo.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");

    private By finishButton = By.id("finish");
    private By confirmationMessage = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCustomerInformation(String first, String last, String zip) {
        WaitUtils.waitForClickability(driver, firstNameInput).sendKeys(first);
        WaitUtils.waitForVisibility(driver, lastNameInput).sendKeys(last);
        WaitUtils.waitForVisibility(driver, postalCodeInput).sendKeys(zip);
        WaitUtils.waitForClickability(driver, continueButton).click();
    }

    public void finishOrder() {
        WaitUtils.waitForClickability(driver, finishButton).click();
    }

    public String getConfirmationMessage() {
        return WaitUtils.waitForVisibility(driver, confirmationMessage).getText();
    }

    public boolean isOrderComplete() {
        return getConfirmationMessage().equalsIgnoreCase("Thank you for your order!");
    }
}
