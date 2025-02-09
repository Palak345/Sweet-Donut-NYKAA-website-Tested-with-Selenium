package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.SearchPage;

public class SearchSteps {
    WebDriver driver;
    SearchPage searchPage;

    @Given("I open the Nykaa demo website")
    public void openNykaaWebsite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://sweet-donut-1ca8e9.netlify.app/");
        searchPage = new SearchPage(driver);
    }

    @When("I search for {string}")
    public void searchForProduct(String product) {
        searchPage.enterSearchTerm(product);
        searchPage.clickSearchButton();
    }

    @Then("I should see relevant search results")
    public void verifySearchResults() {
        Assert.assertTrue("Search results are not displayed!", searchPage.verifySearchResults());
        driver.quit();
    }
}
