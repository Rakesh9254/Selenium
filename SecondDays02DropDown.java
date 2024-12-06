package Selenium30DaysChallenge;

import java.lang.classfile.ClassFile.Option;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SecondDays02DropDown {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement dropDown =driver.findElement(By.id("country"));
		Select select = new Select(dropDown);
		select.selectByVisibleText("Japan");
		
		List<WebElement> Option = select.getOptions();
		System.out.println("Number of Size:"+Option.size());
		
		driver.manage().window().minimize();
		driver.quit();
		
	}

}
