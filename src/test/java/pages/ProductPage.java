package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Check if all products are visible
    public boolean areProductsVisible() {
        try {
            List<WebElement> products = driver.findElements(By.xpath("//div[@id='PRODUCT']"));
            for (WebElement product : products) {
                if (!product.isDisplayed()) {
                    System.out.println("Hidden product: " + product.getText());
                    return false;  // Return false if any product is hidden
                }
            }
            System.out.println("All products are visible.");
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Products not found: " + e.getMessage());
            return false;
        }
    }

    // Select a category from the dropdown
    public boolean selectCategory(String categoryName) {
        try {
            WebElement categoryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("category-dropdown")));
            Select categorySelect = new Select(categoryDropdown);
            categorySelect.selectByVisibleText(categoryName);
            System.out.println("Category '" + categoryName + "' selected.");
            return true;
        } catch (Exception e) {
            System.out.println("Error selecting category: " + e.getMessage());
            return false;
        }
    }

    // Select a sorting option
    public boolean selectSortingOption(String sortingOption) {
        try {
            WebElement sortingDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sorting-dropdown")));
            Select sortingSelect = new Select(sortingDropdown);
            sortingSelect.selectByVisibleText(sortingOption);
            System.out.println("✅ Sorting option '" + sortingOption + "' selected.");
            return true;
        } catch (Exception e) {
            System.out.println("❌ Error selecting sorting option: " + e.getMessage());
            return false;
        }
    }

    // Verify that price is visible for all products
    public boolean arePricesVisible() {
        try {
            List<WebElement> prices = driver.findElements(By.cssSelector(".product-price"));
            for (WebElement price : prices) {
                if (!price.isDisplayed()) {
                    System.out.println("Hidden price for product: " + price.getText());
                    return false;  // Return false if any price is hidden
                }
            }
            System.out.println("All prices are visible.");
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Prices not found: " + e.getMessage());
            return false;
        }
    }

    // Run all the checks together
    public boolean verifyProductPage() {
        return areProductsVisible() && selectCategory("Electronics") && selectSortingOption("Price: Low to High") && arePricesVisible();
    }
}
