package Selenium30DaysChallenge;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestionKeysDown {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);

        try {
            // Maximize window and set timeouts
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            // Navigate to Google
            driver.get("https://www.google.co.in/");
            
            // Enter text in search box
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium");

            // Use explicit wait to wait for the suggestions to appear
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']//li//div[@role='option']")));
            
            // Navigate through the options using Keys.DOWN
            for (int i = 0; i < 5; i++) { // Adjust the number based on the position of the desired option
                searchBox.sendKeys(Keys.DOWN);
                Thread.sleep(5000); // Small delay to see the navigation
            }
            searchBox.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the driver
            driver.quit();
        }
    }
}
