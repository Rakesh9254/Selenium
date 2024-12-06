package InterviewQuestion;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class allCookies {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        
        //Initialize the WebDriver
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/");
        driver.manage().addCookie(new Cookie("name", "value")); // Add cookie
        
        driver.manage().deleteCookieNamed("name"); // Delete specific cookie
        
        Set<Cookie> allCookies = driver.manage().getCookies(); // Get all cookies
        
        driver.quit();

	}

}
