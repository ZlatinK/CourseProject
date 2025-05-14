package tests;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import mainTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class FailedLoginTest extends BaseTest {

    @Test(dataProvider = "failedLogin")
    public void failedLoginTest(String username, String password) {

        enterCredentialsAndSubmit(username, password);

        WebElement errorMsg = driver.findElement(By.cssSelector(".error-message-container.error"));
        Assert.assertTrue(errorMsg.getText().contains("Username and password do not match"),
                "Expected error message not shown!");
    }

    private void enterCredentialsAndSubmit(String username, String password) {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.clear();
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.clear();
        passwordField.sendKeys(password);

        WebElement loginButton = driver.findElement(By.cssSelector("[name=login-button]"));
        loginButton.click();
    }

    @DataProvider(name = "failedLogin")
    public Object[][] readCSVData() {
        try {
            CSVReader reader =
                    new CSVReader(new FileReader("src/test/resources/failedLogin.csv"));

            List<String[]> records = reader.readAll();
            Object[][] data = new Object[records.size()][2];

            for (int i = 0; i < records.size(); i++){
                data[i] = records.get(i);
            }
            return data;
        } catch (IOException | CsvException e){
            System.out.println(e);
            return null;
        }
    }
}
