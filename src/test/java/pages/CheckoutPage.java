package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkoutButton = By.xpath("(//span[@id='shopping_bag'])[1]");
    private By paymentPage = By.xpath("#paymentMethod > :nth-child(5)");

    public void proceedToCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public boolean isOnPaymentPage() {
        return driver.findElement(paymentPage).isDisplayed();
    }
}
