package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyValueAttribute {
public static void main(String[] args) throws Throwable {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://crmaccess.vtiger.com/log-in/?mode=continue");
	Thread.sleep(2000);
	WebElement usernameTextField = driver.findElement(By.id("username"));
	String valueOfUsername = usernameTextField.getAttribute("value");
	System.out.println("valueOfUsername = " + valueOfUsername);
	if (valueOfUsername.isEmpty()) {
		usernameTextField.sendKeys("admin");
	}else {
		usernameTextField.clear();
		Thread.sleep(2000);
		usernameTextField.sendKeys("ADMIN");
	}
	driver.manage().window().minimize();
	driver.quit();
 	
}
}