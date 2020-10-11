package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailsPage extends BasePage {

    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    public void verifyDetailsContains(String topic) {
        WebElement title = new WebDriverWait(driver, 5000)
                .until(ExpectedConditions.visibilityOfElementLocated((By.id("productTitle"))));
        Assert.assertTrue(title.getText().contains(topic));
    }
}
