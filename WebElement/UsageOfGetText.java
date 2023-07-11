package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsageOfGetText {
public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.facebook.com/");
	String expectedText = "Forgotten password?";
	System.out.println("Expected = " + expectedText);
	WebElement forgottenPasswordLink = driver.findElement(By.xpath("//a[contains(@href,'https://www.facebook.com/recover/initiate/?')]"));
	String actualText = forgottenPasswordLink.getText();
	if (actualText.equals(expectedText)) {
		forgottenPasswordLink.click();
		System.out.println("The Actual text is as per expected text. ");
	}
	else {
		System.out.println("The Actual text is not as per expected text.");
	}
	driver.manage().window().minimize();
	driver.quit();
}
}