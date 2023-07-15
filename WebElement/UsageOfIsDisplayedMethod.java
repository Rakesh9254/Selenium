package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsageOfIsDisplayedMethod {
public static void main(String[] args) throws Throwable {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	Thread.sleep(2000);
	WebElement emailTextField = driver.findElement(By.id("email"));
	if (emailTextField.isDisplayed()) {
		emailTextField.sendKeys("Rakesh Roshan");
		Thread.sleep(2000);
		System.out.println("The emailTextField is visible in the webpage ");
	}else {
		System.out.println("The emailTextField is not visible in the webpage");
	}
	driver.manage().window().minimize();
	driver.quit();
}
}
