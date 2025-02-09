package stepDefinitions;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.*;
import pages.HomePage;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.List;

public class HomePageSteps {
    WebDriver driver;
    WebDriverWait wait;
	private HomePage homePage;

    public HomePageSteps() {
    	driver = new ChromeDriver();
       homePage = new HomePage(driver);
   	 WebDriver driver = Hooks.driver; // Get driver from Hooks
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        driver.get("https://sweet-donut-1ca8e9.netlify.app/");  
        assertTrue(driver.getTitle().contains("Home"));
    }

    @When("I check if the welcome banner is visible")
    public void iCheckIfTheWelcomeBannerIsVisible() {
        try {
            WebElement welcomeBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Welcome-banner")));
            assertTrue("Welcome banner is not visible", welcomeBanner.isDisplayed());
        } catch (NoSuchElementException e) {
            System.out.println("❌ Welcome banner not found: " + e.getMessage());
            assertFalse("Welcome banner not found", true);
        }
    }

    @And("I check if the sell banner is visible")
    public void iCheckIfTheSellBannerIsVisible() {
        try {
            WebElement sellBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[src=\\\"https://images-static.nykaa.com/uploads/6dd86f98-19ac-4e60-8aae-61849054d13a.jpg?tr=w-1200,cm-pad_resize\\\"]")));
            assertTrue("Sell banner is not visible", sellBanner.isDisplayed());
        } catch (NoSuchElementException e) {
            System.out.println("Sell banner not found: " + e.getMessage());
            assertFalse("Sell banner not found", true);
        }
    }

    @And("I check if the images are visible")
    public void iCheckIfTheImagesAreVisible() {
        try {
            List<WebElement> images = driver.findElements(By.tagName("img"));
            for (WebElement image : images) {
                assertTrue("Image is not visible", image.isDisplayed());
            }
        } catch (NoSuchElementException e) {
            System.out.println("Images not found: " + e.getMessage());
            assertFalse("Images not found", true);
        }
    }

    @Then("all homepage elements should be visible")
    public void allHomepageElementsShouldBeVisible() {
        // This step will automatically be covered by the individual visibility checks in the previous steps.
    }
}
