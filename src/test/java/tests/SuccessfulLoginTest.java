package tests;

import mainTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class SuccessfulLoginTest extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage =
                loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(inventoryPage.isInventoryLoaded(), "Inventory page did not load as expected");
    }
}
