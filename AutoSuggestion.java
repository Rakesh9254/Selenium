package Selenium30DaysChallenge;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestion {
    public static void main(String[] args) {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        
        // Maximize window and set timeouts
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Navigate to Google
        driver.get("https://www.google.co.in/");
        
        // Enter text in search box
        driver.findElement(By.name("q")).sendKeys("Selenium");
        
        // Find suggestions
        List<WebElement> optionsList = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
        System.out.println(optionsList.size());
        
        // Loop through the options and click on the desired one
        for (WebElement option : optionsList) {
            try {
                System.out.println(option.getText());
                if (option.getText().equals("selenium webdriver")) {
                    option.click();
                    break; // Exit loop once the desired option is clicked
                }
            } catch (StaleElementReferenceException e) {
                // Re-find the element if it becomes stale
                optionsList = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
            }
        }
        
        // Close the browser
        driver.quit();
    }
}
