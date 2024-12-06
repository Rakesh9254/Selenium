package InterviewQuestion;

import java.awt.Dimension;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AllLinks {
    public static void main(String[] args) {
        // Set up the ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Navigate to the desired webpage
        driver.get("http://www.deadlinkcity.com/");
        
        // Find all anchor elements on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        // Iterate through the list of links
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            // Only print valid URLs
            if (url != null) {
                System.out.println("URL of WebPage: " + url);
                org.openqa.selenium.Dimension size = link.getSize();
                System.out.println("Size of link (width x height): " + size.getWidth() + " x " + size.getHeight());
            }
        }
        
        // Close the browser
        driver.quit();
    }
}
