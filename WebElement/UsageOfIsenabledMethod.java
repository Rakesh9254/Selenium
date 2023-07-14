package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsageOfIsenabledMethod {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	WebElement LoginButton = driver.findElement(By.name("login"));
	if (LoginButton.isEnabled()) {
		System.out.println("The LoginButtom is active");
		LoginButton.click();
	} else {
		System.out.println("The LoginButtom is In-active");
	}
	driver.manage().window().minimize();
	driver.quit();
}
}
