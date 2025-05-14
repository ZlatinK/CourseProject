package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPage extends BasePage {

    @FindBy(className = "summary_total_label")
    private WebElement orderTotal;

    @FindBy(id = "finish")
    private WebElement finishButton;

    public ReviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

//    public String getTotalPriceText() {
//        return orderTotal.getText();
//    }

    public OrderConfirmationPage clickFinish() {
        finishButton.click();
        return new OrderConfirmationPage(driver);
    }

    public boolean isAt() {
        return finishButton.isDisplayed();
    }
}
