package Selenium30DaysChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;

public class AutoSuggestionHandler {
    public static void main(String[] args) {
    	WebDriverManager.chromedriver().setup();
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");

        // Locate the search input field
        WebElement searchBox = driver.findElement(By.name("q"));

        // Enter the search text
        searchBox.sendKeys("selenium");

        // Wait for suggestions to appear
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By suggestionLocator = By.xpath("//ul[@role='listbox']//li[@role='presentation']");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(suggestionLocator));

        // Find all suggestion elements
        List<WebElement> suggestions = driver.findElements(suggestionLocator);

        // Loop through suggestions and click on the desired one
        for (WebElement suggestion : suggestions) {
            if (suggestion.getText().contains("selenium webdriver")) {
                suggestion.click();
                break;
            }
        }

        // Don't forget to close the browser
        driver.quit();
    }
}