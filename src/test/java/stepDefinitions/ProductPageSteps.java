package stepDefinitions;

import org.openqa.selenium.*;
import io.cucumber.java.en.*;
import pages.ProductPage;

import org.openqa.selenium.support.ui.*;
import static org.junit.Assert.*;

import java.time.Duration;

public class ProductPageSteps {
    WebDriver driver;
    ProductPage productPage;
    WebDriverWait wait;

    public ProductPageSteps() {
        this.productPage = new ProductPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I am on the product page")
    public void iAmOnTheProductPage() {
        driver.get("https://sweet-donut-1ca8e9.netlify.app/");  
        assertTrue(driver.getTitle().contains("Products"));
    }

    @When("I check if all products are visible")
    public void iCheckIfAllProductsAreVisible() {
        assertTrue("Not all products are visible", productPage.areProductsVisible());
    }

    @And("I select the {string} category")
    public void iSelectTheCategory(String categoryName) {
        assertTrue("Category selection failed", productPage.selectCategory(categoryName));
    }

    @And("I apply the {string} sorting option")
    public void iApplyTheSortingOption(String sortingOption) {
        assertTrue("Sorting option selection failed", productPage.selectSortingOption(sortingOption));
    }

    @Then("all prices should be visible for the products")
    public void allPricesShouldBeVisibleForTheProducts() {
        assertTrue("Not all prices are visible", productPage.arePricesVisible());
    }
}
