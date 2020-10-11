package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage(String url) {
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    public void searchForProduct(String product) {
        WebElement searchField = driver.findElement(By.id("twotabsearchtextbox"));
        searchField.sendKeys(product);
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-text\"]/input"));
        submitButton.click();
    }
}
