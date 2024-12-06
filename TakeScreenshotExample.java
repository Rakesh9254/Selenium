package Screenshot;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TakeScreenshotExample {
    public static void main(String[] args) {
       // WebDriverManager.safaridriver().setup();
       // SafariOptions options = new SafariOptions();
        //options.a
        
        
        // Initialize WebDriver
        WebDriver  driver = new FirefoxDriver();

        try {
            // Navigate to a webpage (example)
            driver.get("https://www.example.com");

            // Create a timestamp for the screenshot filename
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

            // Define the screenshot file path with timestamp
            String screenshotPath = "/Users/rakesh/git/repository/Selenium/screenshots/screenshot_" + timestamp + ".png";

            // Take screenshot
            TakesScreenshot screenshotTaker = (TakesScreenshot) driver;
            File screenshot = screenshotTaker.getScreenshotAs(OutputType.FILE);
            // Save the screenshot to the defined path
            File destinationFile = new File(screenshotPath);
            FileHandler.copy(screenshot, destinationFile);

            System.out.println("Screenshot saved to: " + screenshotPath);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Quit the WebDriver
            driver.quit();
        }
    }
}
