package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutSteps {
    WebDriver driver;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @Given("I have a product in the cart")
    public void productInCart() {
        cartPage = new CartPage(driver);
        cartPage.addFirstProductToCart();
    }

    @When("I proceed to checkout")
    public void proceedToCheckout() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.proceedToCheckout();
    }

    @Then("I should see the payment page")
    public void verifyPaymentPage() {
        Assert.assertTrue("Not on payment page!", checkoutPage.isOnPaymentPage());
        driver.quit();
    }
}
