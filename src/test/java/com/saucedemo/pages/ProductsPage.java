package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsPage {
    private WebDriver driver;

    // === Selectores ===
    private By inventoryItem = By.className("inventory_item");
    private By productName = By.className("inventory_item_name");
    private By addToCartButton = By.xpath(".//button[contains(text(),'Add to cart')]");
    private By shoppingCartLink = By.className("shopping_cart_link");

    // === Constructor ===
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // === Validación de que estamos en esta página ===
    public boolean isLoaded() {
        return driver.getCurrentUrl().contains("inventory.html");
    }

    // === Acciones ===

    public List<WebElement> getAllProducts() {
        return driver.findElements(inventoryItem);
    }

    public void addProductToCartByName(String name) {
        for (WebElement product : getAllProducts()) {
            String title = product.findElement(productName).getText();
            if (title.equalsIgnoreCase(name)) {
                product.findElement(addToCartButton).click();
                break;
            }
        }
    }

    public void goToCart() {
        driver.findElement(shoppingCartLink).click();
    }

    public boolean isProductInList(String name) {
        for (WebElement product : getAllProducts()) {
            if (product.findElement(productName).getText().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
}
