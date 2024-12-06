package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	WebDriver driver;

	LoginPage2(WebDriver driver) {
		// Assign the driver
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	// using Using pageFactory Approach

	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement txt_usernamElement;
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement txt_Password;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement Txt_Btn;

	// Actions

	public void SetUserName(String User) {
		txt_usernamElement.sendKeys(User);
	}

	public void SetPassword(String pwd) {
		txt_Password.sendKeys(pwd);
	}

	public void ClickLogin() {
		Txt_Btn.click();
	}
}
