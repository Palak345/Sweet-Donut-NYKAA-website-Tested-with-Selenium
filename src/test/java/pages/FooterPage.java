package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class FooterPage {
    WebDriver driver;
    WebDriverWait wait;

    public FooterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isFooterTextVisible() {
        try {
            // Scroll to footer
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Wait for footer to be visible
            WebElement footer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("footer")));

            // Get all text elements in footer
            List<WebElement> footerTexts = footer.findElements(By.xpath("(//div[@id='gry'])[1]"));

            // Check if each footer text is displayed
            for (WebElement text : footerTexts) {
                if (!text.isDisplayed()) {
                    System.out.println("Hidden footer text: " + text.getText());
                    return false;  // Return false if any text is hidden
                }
            }

            System.out.println("All footer text is visible.");
            return true;
        } catch (Exception e) {
            System.out.println("Error checking footer text visibility: " + e.getMessage());
            return false;
        }
    }
}
