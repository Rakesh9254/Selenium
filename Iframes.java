package InterviewQuestion;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.timeout.TimeoutException;

public class Iframes {
    public static void main(String[] args) throws Throwable {
        // Setup WebDriver and Chrome options
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        // Maximize browser window and set implicit wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Navigate to the target URL containing iframes
        driver.get("https://ui.vision/demo/webtest/frames/");
        
        // 2. Explicit Wait Approach
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[@src='frame_1.html']")));
            // Interact with the input field inside the iframe
            driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Testing");
        } catch (TimeoutException e) {
            System.out.println("Iframe not found within the specified wait time.");
            e.printStackTrace(); // Log the exception for debugging
        }

        // Cleanup: Close the browser
        driver.quit();
    }
}
