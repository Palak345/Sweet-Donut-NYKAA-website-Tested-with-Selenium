package pages;

import org.openqa.selenium.*;
import java.util.List;

public class NavigationPage {
    WebDriver driver;

    public NavigationPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNavigationTextVisible() {
        try {
            // Locate the navigation bar
            WebElement navBar = driver.findElement(By.xpath("//div[@id=\"navbar\"]"));

            // Get all menu items (links, spans, divs with text)
            List<WebElement> navTexts = navBar.findElements(By.xpath("//nav//a | //nav//span | //nav//li | //nav//div"));

            // Check if each navigation text is displayed
            for (WebElement text : navTexts) {
                if (!text.isDisplayed()) {
                    System.out.println("Hidden navigation text: " + text.getText());
                    return false;  // Return false if any text is hidden
                }
            }

            System.out.println("All navigation text is visible.");
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("Navigation bar not found: " + e.getMessage());
            return false;
        }
    }
}
