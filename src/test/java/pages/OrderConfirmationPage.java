package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BasePage {

    @FindBy(className = "complete-header")
    private WebElement thankYouMessage;

//    @FindBy(className = "complete-text")
//    private WebElement orderCompleteText;
//
//    @FindBy(id = "back-to-products")
//    private WebElement backHomeButton;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public boolean isAt() {
        return thankYouMessage.isDisplayed();
    }

}
