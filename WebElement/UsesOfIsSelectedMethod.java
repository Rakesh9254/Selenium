package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsesOfIsSelectedMethod {
public static void main(String[] args) throws Throwable {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.actitime.com/login.do");
	Thread.sleep(2000);
	WebElement keepLoggedInCheckBox = driver.findElement(By.id("keepLoggedInCheckBox"));
	if (keepLoggedInCheckBox.isSelected()) {
		System.out.println("The keepLoggedInCheckBox is in the selected format ");
	} else {
		keepLoggedInCheckBox.click();
		Thread.sleep(2000);
		System.out.println("The keepLoggedInCheckBox is in the de-selected format");
	}
	driver.manage().window().minimize();
	driver.quit();
}
}
