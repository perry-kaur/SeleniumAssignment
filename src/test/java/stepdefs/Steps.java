package stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.DetailsPage;
import pages.HomePage;
import pages.SearchPage;

public class Steps {
    private String BROWSER = System.getProperty("browser");
    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;
    DetailsPage detailsPage;

    @Before
    public void startUp() {
        if (BROWSER == null || BROWSER.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (BROWSER.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        }
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        detailsPage = new DetailsPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^User navigates to Amazon \"([^\"]*)\"$")
    public void userNavigatesToProductWebsite(String url) {
        homePage.navigateToHomePage(url);
    }

    @Given("^User search for \"([^\"]*)\"$")
    public void userSearchForProduct(String product) {
        homePage.searchForProduct(product);
    }

    @And("User sorts search list from highest to lowest price")
    public void userSortsSearchListFromHighestToLowest() {
        searchPage.sortHighestToLowest();
    }

    @Then("Results are displayed correctly")
    public void resultsAreDisplayedCorrectly() {
        searchPage.resultsDisplayedFromHighestToLowestPrice();
    }

    @Given("^Search and sort list is displayed for \"([^\"]*)\" and \"([^\"]*)\"$")
    public void searchAndSortListIsDisplayedFor(String url, String product) {
        userNavigatesToProductWebsite(url);
        userSearchForProduct(product);
        userSortsSearchListFromHighestToLowest();
        resultsAreDisplayedCorrectly();
    }

    @When("User click second item in sorted list")
    public void userClickSecondItemInSortedList() {
        searchPage.clickOnSecondItem();
    }

    @Then("^Verify details contains \"([^\"]*)\"$")
    public void verifyDetailsContains(String topic) {
        detailsPage.verifyDetailsContains(topic);
    }
}
