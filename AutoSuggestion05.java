package Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestion05 {
    public static void main(String[] args) throws Throwable {
        // Set up the ChromeDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // Launch Chrome
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        // Open the website
        driver.get("https://www.w3schools.com/");
        
        // Find the search input box and type "Java"
        driver.findElement(By.id("tnb-google-search-input")).sendKeys("Java");

        // Wait for suggestions to appear (explicit wait)
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tnb-search-suggestions")));
        
        // Find the auto-suggestion elements (correct the XPath to target <a> elements inside the suggestions div)
        List<WebElement> autoSuggestions = driver.findElements(By.xpath("//a[@class='search_item search-suggestion-link']"));

        // Print all suggestions and click on the desired one
        for (WebElement suggestion : autoSuggestions) {
        	
            System.out.println("Suggestion: " + suggestion.getText());

            // If the suggestion matches the target text, click it
            if (suggestion.getText().equals("Java Reference")) {
            	
                suggestion.click();
                
                // Wait for the page to load completely (you could also use WebDriverWait here)
                wait.until(ExpectedConditions.titleContains("Java Reference"));
                break;  // Stop the loop after clicking the suggestion
            }
        }

        // Wait a few seconds to let the new page load completely
        Thread.sleep(4000);
        
        // Quit the browser
        driver.quit();
    }
}
