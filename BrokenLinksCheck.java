package Selenium30DaysChallenge;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksCheck {
    public static void main(String[] args) {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();

        // Find all links on the page
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("total Link is : "+links.size());

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null) {
                try {
                    HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();
                    int responseCode = connection.getResponseCode();
                    if (responseCode >= 400) {
                        System.out.println(url + " is a broken link.");
                    } else {
                        System.out.println(url + " is a valid link.");
                    }
                } catch (Exception e) {
                    System.out.println(url + " is a broken link.");
                }
            }
        }
        driver.manage().window().minimize();

        driver.quit();
        
    }
}

