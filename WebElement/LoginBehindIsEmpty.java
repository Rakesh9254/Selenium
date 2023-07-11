package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginBehindIsEmpty {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	WebElement usernameTextField = driver.findElement(By.id("email"));
	String usernameValue = usernameTextField.getAttribute("Value");
	System.out.println(usernameValue);
	if (usernameValue.isEmpty()) {
		System.out.println("Method return true is not data. ");
		usernameTextField.sendKeys("admin");
		System.out.println("As per Application : The data should not be present.");
		
	} else {
		usernameTextField.clear();
		usernameTextField.sendKeys("Manager");
		System.out.println("Method returns false if there is data");
		System.out.println("As per Application : The data should be present");
	}
	driver.manage().window().minimize();
	driver.quit();
}
}