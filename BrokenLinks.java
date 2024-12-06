package InterviewQuestion;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL; // Import missing
import java.util.List;

import org.openqa.selenium.By; // Import missing
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        
        // Navigate to the target URL
        driver.get("https://www.brokenlinkcheck.com/"); // Replace with your URL
        
        // Find all links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        // Check each link
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            checkLink(url);
            
        }
        
        // Close the driver
        driver.quit();
    }

    public static void checkLink(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD"); // Use HEAD to check without downloading the page
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode >= 400) {
                System.out.println(url + " is a broken link. Response code: " + responseCode);
            } else {
                System.out.println(url + " is a valid link. Response code: " + responseCode);
            }
        } catch (IOException e) {
            System.out.println(url + " is a broken link. Error: " + e.getMessage());
        }
        
    }
    
}
