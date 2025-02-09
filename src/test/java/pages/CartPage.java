package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locators 
    private By firstProduct = By.xpath("//div[@id='parent']//div[contains(@class, 'addToBagBtn')][1]");
    private By cartProduct = By.xpath("//section[@id='s_content_card']");

    // Actions
    public void addFirstProductToCart() {
    	 try {
             WebElement product = wait.until(ExpectedConditions.elementToBeClickable(firstProduct));

             // Scroll to product before clicking
             ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);

             // Using Actions class for better reliability
             Actions actions = new Actions(driver);
             actions.moveToElement(product).click().perform();

             System.out.println("Product added to cart successfully.");
         } catch (Exception e) {
             System.out.println("Error in adding product to cart: " + e.getMessage());
         }
    }

    public boolean isProductInCart() {
        return driver.findElement(cartProduct).isDisplayed();
    }
}
