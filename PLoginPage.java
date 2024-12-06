package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PLoginPage {
	WebDriver driver;

	PLoginPage(WebDriver driver) {
		this.driver = driver;

	}

	// locators
	By txt_userName = By.xpath("//input[@placeholder='Username']");
	By Txt_password = By.xpath("//input[@placeholder='Password']");
	By BtnLogin = By.xpath("//button[normalize-space()='Login']");

	// Actions

	public void SetUsername(String User) {
		driver.findElement(txt_userName).sendKeys(User);
	}

	public void Setpassword(String pwd) {
		driver.findElement(Txt_password).sendKeys(pwd);
	}

	public void ClickLogin() {
		driver.findElement(BtnLogin).click();
	}

}
