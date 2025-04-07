package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    // === Paso 1: Datos del cliente ===
    private By firstNameInput = By.id("first-name");
    private By lastNameInput = By.id("last-name");
    private By postalCodeInput = By.id("postal-code");
    private By continueButton = By.id("continue");

    // === Paso 2: Resumen y final ===
    private By finishButton = By.id("finish");
    private By confirmationMessage = By.className("complete-header");

    // === Constructor ===
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCustomerInformation(String first, String last, String zip) {
        driver.findElement(firstNameInput).sendKeys(first);
        driver.findElement(lastNameInput).sendKeys(last);
        driver.findElement(postalCodeInput).sendKeys(zip);
        driver.findElement(continueButton).click();
    }

    public void finishOrder() {
        driver.findElement(finishButton).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }

    public boolean isOrderComplete() {
        return getConfirmationMessage().equalsIgnoreCase("Thank you for your order!");
    }
}
