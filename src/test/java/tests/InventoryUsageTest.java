package tests;

import mainTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class InventoryUsageTest extends BaseTest {

    @Test
    public void addItemAndLogout() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addProductToCart("bike-light");

        String cartCount = inventoryPage.getCartItemCount();
        Assert.assertEquals(cartCount, "1", "Cart item should be 1 !");

        LoginPage logoutPage = inventoryPage.logoutFromInventory();
        Assert.assertTrue(logoutPage.isAt(), "Should be on login page after logout !");
    }
}
