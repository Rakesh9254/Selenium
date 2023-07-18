package SynchronizationIssue;

import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckTheLoadingTime {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(4));
	try {
		driver.get("https://www.amazon.com/");
	} catch (TimeoutException e) {
		System.out.println("The Application is not having the capacity to load within the given time.");
	}
	driver.manage().window().minimize();
	driver.quit();
}
}
