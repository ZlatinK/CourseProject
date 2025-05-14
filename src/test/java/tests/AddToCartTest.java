package tests;

import mainTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartTest extends BaseTest {
    private static final String ITEM_ADD_BUTTON = "add-to-cart-sauce-labs-";

    @Test(dataProvider = "shoppingItems")
    public void addItemToTheCart(String addItemButton) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement userNameInput = driver.findElement(By.id("user-name"));
        userNameInput.click();
        userNameInput.clear();
        userNameInput.sendKeys("standard_user");

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.click();
        passwordInput.clear();
        passwordInput.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("[name=login-button"));
        loginButton.click();

        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(ITEM_ADD_BUTTON + addItemButton)));
        addButton.click();

        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));

        Assert.assertEquals(cartBadge.getText(), "1");
    }

    @DataProvider(name = "shoppingItems")
    public Object[] getShoppingItems(){
        return new Object[]{
                "onesie",
                "bolt-t-shirt",
                "bike-light"
        };
    }
}
