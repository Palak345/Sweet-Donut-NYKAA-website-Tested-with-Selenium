package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.NavigationPage;

public class NavigationSteps {
	 WebDriver driver = Hooks.driver;
	NavigationPage navigationPage;

    @Then("I verify all navigation text is visible")
    public void verifyNavigationText() {

        navigationPage = new NavigationPage(driver);
        Assert.assertTrue("Some navigation text is not visible!", navigationPage.isNavigationTextVisible());
    }
}
