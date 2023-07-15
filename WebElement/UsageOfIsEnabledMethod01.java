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
		WebElement AcceptTermsOfService  = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/section/div/div/section/div/div/div/div[1]/div/div/div[17]/label/h6/button"));
		AcceptTermsOfService.click();
		Thread.sleep(2000);
		WebElement AcceptTermsOfServiceCheclBox = driver.findElement(By.id("confbtn"));
		AcceptTermsOfServiceCheclBox.click();
		Thread.sleep(2000);
		WebElement closeOption = driver.findElement(By.xpath("//button[@class='btn btn-secondary' and @data-dismiss='modal']"));
		closeOption.click();
		Thread.sleep(3000);
		System.out.println("The SubmitOption is inactive");
	}
	driver.manage().window().minimize();
	driver.quit();
}
}
