package SynchronizationIssue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class ImplicityWaitSelenium {
public static void main(String[] args) {
	System.out.println("ChromeDriver was started are allowed ");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://demo.actitime.com/login.do");
	WebElement usernameTextField = driver.findElement(By.id("username"));
	usernameTextField.sendKeys("admin");
	WebElement passwordtextField = driver.findElement(By.name("pwd"));
	passwordtextField.sendKeys("manager");
	WebElement LoginOption = driver.findElement(By.id("loginButton"));
	LoginOption.click();
	String actualHomePageUrl = driver.getCurrentUrl();
	Wait.until(ExpectedConditions.urlToBe(""));
	WebElement.logoutLink = driver.findElement(By.id("logoutlink"));
	Wait.until(ExpectedConditions.elementToBeClickable("logoutlink")T);
	logoutLink.click();
	
}
}
