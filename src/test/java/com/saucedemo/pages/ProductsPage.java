package com.saucedemo.pages;

import com.saucedemo.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    private By inventoryItem = By.className("inventory_item");
    private By productName = By.className("inventory_item_name");
    private By addToCartButton = By.xpath(".//button[contains(text(),'Add to cart')]");
    private By shoppingCartLink = By.className("shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return WaitUtils.waitForUrlContains(driver, "inventory.html");
    }


    public List<WebElement> getAllProducts() {
        WaitUtils.waitForPresenceOfElement(driver, inventoryItem);
        return driver.findElements(inventoryItem);
    }

    public void addProductToCartByName(String name) {
        for (WebElement product : getAllProducts()) {
            String title = product.findElement(productName).getText();
            if (title.equalsIgnoreCase(name)) {
                WebElement addButton = product.findElement(addToCartButton);
                WaitUtils.waitForClickability(driver, addToCartButton);
                addButton.click();
                break;
            }
        }
    }

    public void goToCart() {
        WaitUtils.waitForClickability(driver, shoppingCartLink).click();
    }

    public boolean isProductInList(String name) {
        for (WebElement product : getAllProducts()) {
            String title = product.findElement(productName).getText();
            if (title.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
