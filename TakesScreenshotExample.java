package Practise;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakesScreenshotExample { // Renamed class to avoid confusion
    public static void main(String[] args) throws IOException {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        // Navigate to the URL
        driver.get("https://www.youtube.com/watch?v=VUrw5JddJ5U");

        // Generate timestamp for the screenshot filename
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        System.out.println(timeStamp);

        // Take screenshot
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver; // Correct casting
        File tempFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // Define the path for the screenshot file
        String filePath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + "screenshot_" + timeStamp + ".png";
        File permFile = new File(filePath);

        // Ensure the directory exists
        permFile.getParentFile().mkdirs();

        // Save the screenshot to the file
        try {
            FileUtils.copyFile(tempFile, permFile); // Correct method to copy a file
            System.out.println("Screenshot saved to: " + permFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.close();
    }
}
