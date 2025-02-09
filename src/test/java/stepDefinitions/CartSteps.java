package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.SearchPage;

public class CartSteps {
	 WebDriver driver = Hooks.driver; // Get driver from Hooks
    SearchPage searchPage;
    CartPage cartPage;

    @And("I add the first product to the cart")
    public void addFirstProductToCart() {
        cartPage = new CartPage(driver);
        cartPage.addFirstProductToCart(); // Handles alert internally
    }

    @Then("I should see the product in the cart")
    public void verifyProductInCart() {
        Assert.assertTrue("Product not found in cart!", cartPage.isProductInCart());
        driver.quit();
    }
}
