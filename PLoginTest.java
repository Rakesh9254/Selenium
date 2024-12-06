package PageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PLoginTest {
	WebDriver driver;
	
	@BeforeClass
	void SetUp() {
		WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
	}
	
	@Test(invocationCount = 10)
	void Login() {
		PLoginPage pLoginPage=new PLoginPage(driver);
		pLoginPage.SetUsername("Admain");
		pLoginPage.Setpassword("admin123");
		pLoginPage.ClickLogin();
		
	}
	
	
	@AfterClass
	void teradown() {
		driver.quit();
	}

}
