package ProjectMini;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import Utility.All_Links;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Automation implements All_Links {
	WebDriver driver;
	@BeforeClass
	void open_Browser() {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test
	void Home_page() {
		WebElement we = driver.findElement(
				By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]"));
		String text = we.getText();
		System.out.println(text);

		if (text.equals(Act_rest)) {
			System.out.println("Home Page successfully Open");
		} else {
			System.out.println("Home Page is Not Open");
		}

	}

	@AfterClass
	void teardown() {
		driver.quit();
	}
}