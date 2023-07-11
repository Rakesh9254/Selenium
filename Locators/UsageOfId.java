package Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsageOfId {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	driver.getCurrentUrl();
	System.out.println(driver.getTitle());
	driver.manage().window().minimize();
	driver.close();
	driver.quit();
}
}