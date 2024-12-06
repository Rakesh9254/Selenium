package InterviewQuestion;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
    public static void main(String[] args) throws Throwable {
        // Setup WebDriver and Chrome options
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        // Maximize browser window and set implicit wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the target URL
        driver.get("https://testautomationpractice.blogspot.com/");

        // Trigger the alert by clicking the button
        driver.findElement(By.id("alertBtn")).click();
        Thread.sleep(3000); // Wait for the alert to appear

        // --- Handling Alerts in Different Ways ---

        // 1. Traditional Approach (Commented Out)
        /*
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert Text: " + alert.getText()); // Print alert text
        alert.accept(); // Accept the alert (click OK)
        alert.dismiss(); // Dismiss the alert (click Cancel)
        alert.sendKeys("Ram"); // Send keys to the alert if applicable
        */

        // 2. Explicit Wait Approach (Commented Out)
        /*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert Text: " + alert.getText());
        alert.accept(); // Accept the alert
        */

        // 3. JavaScript Executor Approach
        JavascriptExecutor js = (JavascriptExecutor) driver;
        try {
            // Override the window.alert function to prevent the alert from appearing
            js.executeScript("window.alert=function(){};");
        } catch (Exception e) {
            e.printStackTrace(); // Handle potential exceptions
        }

        // Cleanup: Close the browser
        driver.quit();
    }
}
