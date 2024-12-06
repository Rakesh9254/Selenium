package InternshipDEALSDRAY;

import java.io.File;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TimeStampScreenshot {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.amazon.in/");
        
        // Get current time
        Calendar calendar = Calendar.getInstance();
        Date time = calendar.getTime();
        
        // Create timestamp
        String TimeStamp = time.toString().replace(":", "").replace(" ", "");
        System.out.println(time);
        System.out.println(TimeStamp);
        
        // Take a screenshot
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File tempFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        
        // Create the destination file path
        File perFile = new File("/Users/rakesh/Desktop/Workspace/Selenium/screenshots/screenshot_" + TimeStamp + ".png");
        
        
        
        
        try {
            // Copy the screenshot to the destination file
            FileUtils.copyFile(tempFile, perFile);
            System.out.println("Screenshot saved: " + perFile.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        driver.quit();
    }
}
