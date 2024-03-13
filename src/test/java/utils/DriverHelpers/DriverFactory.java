package utils.DriverHelpers;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.BaseClass;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public  class DriverFactory extends BaseClass {
    private static WebDriver driver;

    public static WebDriver getDriver() throws IOException {

        configProp = new Properties();

        FileInputStream configPropfile = new FileInputStream("config.properties");
        configProp.load(configPropfile);

        String br = configProp.getProperty("browser");// default to chrome
        //Load properties file
        if (br == null) {
            {
                System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
                driver = new ChromeDriver();
            }
            return driver;
        }

        //Launching browser
        if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
            driver = new FirefoxDriver();
        } else if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
            driver = new ChromeDriver();
        } return driver;}

    public static void takeScreenshot(WebDriver driver, String scenarioName){
        TakesScreenshot tsDriver = (TakesScreenshot) driver;

        // Take screenshot as byte array
        byte[] screenshot = tsDriver.getScreenshotAs(OutputType.BYTES);

        try {
            // Define target folder
            Path targetFolder = Paths.get("target/screenshots");

            // Create the folder if it doesn't exist
            if (!Files.exists(targetFolder)) {
                Files.createDirectories(targetFolder);
            }

            // Define screenshot file name
            String screenshotName = scenarioName + "_" + System.currentTimeMillis() + ".png";

            // Define the path to save the screenshot
            Path screenshotPath = Paths.get(targetFolder.toString(), screenshotName);

            // Save the screenshot to the target folder
            Files.write(screenshotPath, screenshot);

            System.out.println("Screenshot saved: " + screenshotPath.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }}
