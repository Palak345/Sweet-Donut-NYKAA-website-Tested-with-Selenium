package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.FooterPage;

public class FooterSteps {
	 WebDriver driver = Hooks.driver; // Get driver from Hooks
	 FooterPage footerPage;

    @Then("I verify all footer text is visible")
    public void verifyFooterText() {
        footerPage = new FooterPage(driver);
        Assert.assertTrue("Some footer text is not visible!", footerPage.isFooterTextVisible());
    }
}
