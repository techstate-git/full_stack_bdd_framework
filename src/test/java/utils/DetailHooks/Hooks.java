package utils.DetailHooks;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import pages.BaseClass;
import utils.DriverHelpers.DriverFactory;
import cucumber.api.java.Before;

import java.io.IOException;

public class Hooks extends BaseClass {
    private WebDriver driver = DriverFactory.getDriver();

    public Hooks() throws IOException {
    }


    @Before
    public void setupScenario() throws IOException {
        String browser = System.getProperty("browser", "chrome"); // default to chrome
        if (browser.equalsIgnoreCase("chrome")) {
            driver.manage().window().maximize();
        }
    }

    @After
    public void teardownScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take screenshot and save it
            // Assume you have a method for taking screenshots in the DriverFactory
            DriverFactory.takeScreenshot(driver, scenario.getName());
            driver.quit();
        }

        // Quit the browser
        if (driver != null) {
            driver.quit();
        }
    }
}