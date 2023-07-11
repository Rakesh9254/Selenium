package WebDriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsageOfGetCurrentUrl {
public static void main(String[] args) throws Throwable {
	// Instantiate the btowser specific class
	WebDriver driver = new ChromeDriver();
	// trigger the main url of the appln
	driver.get("https://www.facebook.com/");
	String expectedUrl = "https://www.facebook.com/";
	Thread.sleep(2000);
	System.out.println("expectedUrl = " + expectedUrl);
	String actualUrl = driver.getCurrentUrl();
	System.out.println("actualUrl = " + actualUrl);
	if (actualUrl.equals(expectedUrl)) {
		System.out.println("Pass: The Actual url is verified and found correct.");
	}else {
		System.out.println("Fail: The Actual url is verified and found incorrect.");
	}
	driver.quit();
}
}