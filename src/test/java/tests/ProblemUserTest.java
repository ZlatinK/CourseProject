package tests;

import mainTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProblemUserTest extends BaseTest {

    @Test
    public void productImageShouldBeDifferent() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("problem_user", "secret_sauce");

        List<WebElement> productImages = driver.findElements(By.cssSelector(".inventory_item_img img"));

        Set<String> imageSources = new HashSet<>();
        for (WebElement img : productImages) {
            imageSources.add(img.getAttribute("src"));
        }

        Assert.assertTrue(imageSources.size() > 1,
                "All product images should be different , but are the same!");
    }
}
