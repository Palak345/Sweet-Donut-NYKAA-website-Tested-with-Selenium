package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://sweet-donut-1ca8e9.netlify.app/");
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
