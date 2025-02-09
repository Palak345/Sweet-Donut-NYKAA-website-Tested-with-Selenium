package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
    WebDriver driver;

    // Constructor
    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By searchBox = By.xpath("//input[@placeholder='Search on Nykaa']");
    private By searchButton = By.xpath("//body/div[@id='navbar']/div[@class='offers']/div[@class='dropdown_category']/ul/li[1]/a[1]");

    // Actions
    public void enterSearchTerm(String product) {
        driver.findElement(searchBox).sendKeys(product);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public boolean verifySearchResults() {
        WebElement results = driver.findElement(By.xpath("//div[@id='PRODUCT']"));
        return results.isDisplayed();
    }
}
