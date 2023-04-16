package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends org.example.BasePage {
    private By cartItemName = By.className("cart-item-name");
    private By cartItemPrice = By.className("cart-item-price");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getCartItemName() {
        return getText(cartItemName);
    }

    public String getCartItemPrice() {
        return getText(cartItemPrice);
    }
}
