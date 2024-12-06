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

public class AutoSuggestion02 {
    public static void main(String[] args) throws Throwable {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        
        // Enter the search term
        driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("Selenium");
        
        // Wait until the suggestion list appears
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@role='listbox']")));

        // Get the list of suggestions
        List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']/li"));

        // Iterate over the list and click the desired option
        for (WebElement lists : list) {
        	Thread.sleep(2000);
            System.out.println("Lists : " + lists.getText());
            
            // If the required suggestion is found, click on it
            if (lists.getText().equals("selenium dev")) {
                lists.click();
                break; // Exit the loop once the suggestion is clicked
            }
        }

        // Close the browser after the action
        driver.close();
    }
}
