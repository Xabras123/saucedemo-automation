package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    // === Selectores ===
    private By cartItems = By.className("cart_item");
    private By itemName = By.className("inventory_item_name");
    private By checkoutButton = By.id("checkout");

    // === Constructor ===
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInCart(String name) {
        List<WebElement> items = driver.findElements(cartItems);
        for (WebElement item : items) {
            if (item.findElement(itemName).getText().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
