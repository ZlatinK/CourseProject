package tests;

import mainTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.time.Duration;

public class ErrorUserTest extends BaseTest {
    private static final String ITEM_ADD_BUTTON = "add-to-cart-sauce-labs-";

    @Test
    public void errorUserAddItemsTest() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("error_user", "secret_sauce");

        Assert.assertTrue(inventoryPage.isAt(),
                "Inventory page should be loaded.");

        String[] itemsToTry = {
                "bike-light",
                "backpack",
                "bolt-t-shirt",
                "fleece-jacket",
                "onesie"};

        for (String item : itemsToTry) {
            try {
                WebElement addButton = driver.findElement(By.id(ITEM_ADD_BUTTON + item));
                addButton.click();
            } catch (Exception e) {
                System.out.println("Button not found for item: " + item);
            }
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));

        String actualCount = cartBadge.getText();

        Assert.assertEquals(actualCount, "5", "All 5 items should be added, but only 3 can.");
    }
}
