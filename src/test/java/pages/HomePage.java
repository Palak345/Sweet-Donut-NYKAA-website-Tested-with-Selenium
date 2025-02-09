package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators for the elements on the homepage
    By welcomeBannerLocator = By.id("Welcome-banner");  // Replace with actual selector for welcome banner
    By sellBannerLocator = By.cssSelector("img[src=\"https://images-static.nykaa.com/uploads/6dd86f98-19ac-4e60-8aae-61849054d13a.jpg?tr=w-1200,cm-pad_resize\"]");        // Replace with actual selector for sell banner
    By imageLocator = By.tagName("img");                 // Looks for all <img> tags on the page

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Check if the welcome banner is visible
    public boolean isWelcomeBannerVisible() {
        try {
            WebElement welcomeBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeBannerLocator));
            return welcomeBanner.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Welcome banner not found: " + e.getMessage());
            return false;
        }
    }

    // Check if the sell banner is visible
    public boolean isSellBannerVisible() {
        try {
            WebElement sellBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(sellBannerLocator));
            return sellBanner.isDisplayed();
        } catch (NoSuchElementException e) {
            System.out.println("Sell banner not found: " + e.getMessage());
            return false;
        }
    }

    // Check if all images are visible
    public boolean areImagesVisible() {
        try {
            List<WebElement> images = driver.findElements(imageLocator);
            for (WebElement image : images) {
                if (!image.isDisplayed()) {
                    System.out.println("Image not visible: " + image.getAttribute("src"));
                    return false;
                }
            }
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Images not found: " + e.getMessage());
            return false;
        }
    }
}
