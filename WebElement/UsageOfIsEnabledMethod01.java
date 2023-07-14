package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsageOfIsEnabledMethod01 {
public static void main(String[] args) throws Throwable {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://sandbox.abdm.gov.in/applications/cowin/Home/cowin_signup_form");
	Thread.sleep(3000);
	WebElement SubmitOption = driver.findElement(By.name("submit"));
	if (SubmitOption.isEnabled()) {
		System.out.println("The SubmitOption is enabled/active");
	} else {
		System.out.println();
	}
}
}
