package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends HomePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void sortHighestToLowest() {
        WebElement sortButton = new WebDriverWait(driver, 5000)
                .until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"a-autoid-0-announce\"]"))));
        sortButton.click();

        WebElement highestToLowest = new WebDriverWait(driver, 5000)
                .until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[@id=\"s-result-sort-select_2\"]"))));

        highestToLowest.click();

    }

    public void resultsDisplayedFromHighestToLowestPrice() {
        List<WebElement> listSearchResults = new WebDriverWait(driver, 5000)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy((By.className("a-price-whole"))));
        int firstPrice = getPrice(listSearchResults.get(0));
        int secondPrice = getPrice(listSearchResults.get(1));
        // Sorted from highest to lowest
        Assert.assertTrue(firstPrice > secondPrice);
    }

    private int getPrice(WebElement priceWrapper) {
        int price = Integer.parseInt(priceWrapper.getText().replaceAll(",", ""));
        return price;
    }

    public void clickOnSecondItem() {
        List<WebElement> priceWrapper = driver.findElements(By.className("a-price-whole"));
        // Taking 0 index as first item in view always coming without price, so in effect this is second element in list with price
        WebElement secondItem = priceWrapper.get(0);
        secondItem.click();
    }


}
