package tests;

import mainTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class CheckOutTest extends BaseTest {

    @Test
    public void purchaseTest() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(inventoryPage.isAt(), "User is not on inventory page!");

        inventoryPage.addProductToCart("bike-light");

        CartPage cartPage = inventoryPage.goToCart();
        Assert.assertTrue(cartPage.isAt(),"User is not on Cart Page.");

        CheckOutPage checkOutPage = cartPage.clickCheckout();
        Assert.assertTrue(checkOutPage.isAt(),"User is not on Checkout Page.");

        checkOutPage.enterShippingDetails("Zlatin", "HG", "HHH");

        ReviewPage reviewPage = checkOutPage.clickContinue();
        Assert.assertTrue(reviewPage.isAt(), "User is not on Review Page.");

        OrderConfirmationPage orderConfirmationPage = reviewPage.clickFinish();
        Assert.assertTrue(orderConfirmationPage.isAt(), "Order not completed successfully.");
    }
}
