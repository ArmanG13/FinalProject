import junit.framework.TestListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.example.CartPage;
import org.example.HomePage;
import org.example.LoginPage;
import org.example.AssertionMessages;
import org.example.Locators;

@Listeners(TestListener.class)
public class SearchAndAddToTestCart extends BaseTest {

    @Test
    public void searchForItemAndAddToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.searchFor("Laptop");
        driver.findElement(Locators.ADD_TO_CART_BUTTON).click();
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCartItemName(), "Laptop", AssertionMessages.ITEM_NOT_ADDED_TO_CART);
    }

    @Test
    public void loginAndAddToCart() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user", "password");
        driver.findElement(Locators.SEARCH_BOX).sendKeys("Smartphone");
        driver.findElement(Locators.SEARCH_BUTTON).click();
        driver.findElement(Locators.ADD_TO_CART_BUTTON).click();
        CartPage cartPage = new CartPage(driver);
        Assert.assertNotEquals(cartPage.getCartItemName(), "", AssertionMessages.CART_IS_EMPTY);
    }

    @Test
    public void searchAndAddToCartFromCartPage() {
        HomePage homePage = new HomePage(driver);
        homePage.searchFor("Tablet");
        driver.findElement(Locators.ADD_TO_CART_BUTTON).click();
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCartItemName(), "Tablet", AssertionMessages.ITEM_NOT_ADDED_TO_CART);
    }

    @Test
    public void loginAndSearchFromHomePageAndCartPage() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginButton();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("user", "password");
        homePage.searchFor("Laptop");
        driver.findElement(Locators.ADD_TO_CART_BUTTON).click();
        homePage.searchFor("Smartphone");
        driver.findElement(Locators.ADD_TO_CART_BUTTON).click();
        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.getCartItemName(), "Laptop", AssertionMessages.ITEM_NOT_ADDED_TO_CART);
        homePage.searchFor("Tablet");
        driver.findElement(Locators.ADD_TO_CART_BUTTON).click();
        Assert.assertEquals(cartPage.getCartItemName(), "Smartphone", AssertionMessages.ITEM_NOT_ADDED_TO_CART);
        Assert.assertEquals(cartPage.getCartItemPrice(), "$500", AssertionMessages.ITEM_NOT_ADDED_TO_CART);
    }
}
