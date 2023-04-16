package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends org.example.BasePage {
    private By loginButton = By.id("login-button");
    private By searchBox = By.id("search-box");
    private By searchButton = By.id("search-button");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public void searchFor(String searchText) {
        type(searchBox, searchText);
        click(searchButton);
    }
}
