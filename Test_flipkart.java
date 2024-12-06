package ProjectMini;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utility.All_Links;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_flipkart implements All_Links {

	WebDriver driver;
	@BeforeClass
	void open_webPage() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	@Test
	void Search_Product() {
		WebElement Product =driver.findElement(By.xpath("//input[@name='q']"));
		Product.sendKeys("Mobile");
		Product.sendKeys(Keys.ENTER);
		
		List<WebElement> ListMobile = driver.findElements(By.xpath("(//div[@class='_5OesEi'])"));
		int length = ListMobile.size();
		System.out.println(length);
		
		if(length!=0) {
			for(WebElement we : ListMobile) {
				String Mobile=we.getText();
				System.out.println(Mobile);
			}
		}
		
	}
	
	@AfterClass
	void teraDown() {
		driver.quit();
	}

}
