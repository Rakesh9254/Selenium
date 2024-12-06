package SeleniumYT;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PriceSort {
    public static void main(String[] args) {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Navigate to Amazon and search for iPhone 12
        driver.get("https://www.amazon.in/");
        WebElement SearchBox = driver.findElement(By.id("twotabsearchtextbox"));
        SearchBox.sendKeys("iphone12");
        driver.findElement(By.id("nav-search-submit-button")).click();
        
        // Find all price elements
        List<WebElement> iphone_Price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        
        // Store prices in a list
        List<Integer> prices = new ArrayList<>();
        for (WebElement priceElement : iphone_Price) {
            String priceText = priceElement.getText().replace(",", ""); // Remove commas
            try {
                int price = Integer.parseInt(priceText); // Convert to integer
                prices.add(price);
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid price: " + priceText);
            }
        }
        
        // Sort the list of prices
        Collections.sort(prices);
        
        // Print the sorted prices
        System.out.println("Sorted prices: " + prices);
        
        // Close the driver
        driver.close();
        
        
        
        
        
     // Setup WebDriver
        WebDriverManager.firefoxdriver().setup();
        
        WebDriver driver1 = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Navigate to Amazon and search for iPhone 12
        driver.get("https://www.amazon.in/");
        WebElement SearchBox1 = driver.findElement(By.id("twotabsearchtextbox"));
        SearchBox.sendKeys("iphone12");
        driver.findElement(By.id("nav-search-submit-button")).click();
        
        // Find all price elements
        List<WebElement> iphone_Price1 = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
        
        // Store prices in a list
        List<Integer> prices1 = new ArrayList<>();
        for (WebElement priceElement : iphone_Price) {
            String priceText = priceElement.getText().replace(",", ""); // Remove commas
            try {
                int price = Integer.parseInt(priceText); // Convert to integer
                prices.add(price);
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid price: " + priceText);
            }
        }
        
        // Sort the list of prices
        Collections.sort(prices);
        
        // Print the sorted prices
        System.out.println("Sorted prices: " + prices);
        
        // Close the driver
        driver.close();
        
        
        
    }
}
