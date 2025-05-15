package tests;

import mainTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class OrderConfirmationTest extends BaseTest {

    @Test
    public void orderConfirmationTest() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addProductToCart("bike-light");
        CartPage cartPage = inventoryPage.goToCart();

        CheckOutPage checkOutPage = cartPage.clickCheckout();
        checkOutPage.enterShippingDetails("John", "Kennedy", "9002");

        ReviewPage reviewPage = checkOutPage.clickContinue();

        String totalPrice = reviewPage.getTotalPriceText();
        System.out.println("Full price: " + totalPrice);

        OrderConfirmationPage confirmationPage = reviewPage.clickFinish();

        Assert.assertTrue(confirmationPage.isAt());
        Assert.assertTrue(confirmationPage.getOrderCompleteText().contains(
                        "Your order has been dispatched, " +
                        "and will arrive just as fast as the pony can get there!"),
                "Successful Order!");

        InventoryPage inventoryAfter = confirmationPage.clickBackHome();
        Assert.assertTrue(inventoryAfter.isAt(), "Inventory page should be displayed after returning home.");
    }
}
