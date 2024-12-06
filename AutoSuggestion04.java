package Selenium30DaysChallenge;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestion04 {
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
            driver.findElement(By.name("q")).sendKeys("Selenium");
            
            // Use explicit wait to wait for the suggestions to appear
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            List<WebElement> optionsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']//li//div[@role='option']")));
            
            // Print the size of options
            System.out.println("Size is: " + optionsList.size());
            
            // Loop through the options and click on the desired one
            for (WebElement option : optionsList) {
                
                if (option.getText().equals("selenium")) {
                    option.click();
                    break;
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the driver
            driver.quit();
        }
    }
}
