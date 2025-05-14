package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage {
    private static final String ITEM_ADD_BUTTON = "add-to-cart-sauce-labs-";

    @FindBy(className = "title")
    private WebElement inventoryTitle;

//    @FindBy(id = "react-burger-menu-btn")
//    private WebElement menuButton;
//
//    @FindBy(id = "logout_sidebar_link")
//    private WebElement logoutLink;
//
//    @FindBy(className = "shopping_cart_badge")
//    private WebElement cartCounter;

    public InventoryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public boolean isAt() {
        return inventoryTitle.isDisplayed() && cartIcon.isDisplayed();
    }

    public void addProductToCart(String productName) {
        WebElement addItem = driver.findElement(By.id(ITEM_ADD_BUTTON + productName));
        addItem.click();
    }

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartIcon;

    public CartPage goToCart() {
        cartIcon.click();
        return new CartPage(driver);
    }

//    public String getCartItemCount() {
//        return cartCounter.getText();
//    }

//    public LoginPage logoutFromInventory() {
//        menuButton.click();
//        logoutLink.click();
//        return new LoginPage(driver);
//    }
}
