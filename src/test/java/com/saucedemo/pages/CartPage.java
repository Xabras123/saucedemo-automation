package com.saucedemo.pages;

import com.saucedemo.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    private By cartItems = By.className("cart_item");
    private By itemName = By.className("inventory_item_name");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductInCart(String name) {
        List<WebElement> items = WaitUtils.waitForPresenceOfAllElements(driver, cartItems);
        for (WebElement item : items) {
            String text = item.findElement(itemName).getText();
            if (text.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void clickCheckout() {
        WebElement button = WaitUtils.waitForClickability(driver, checkoutButton);
        button.click();
    }
}
