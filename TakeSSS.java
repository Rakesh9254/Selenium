package Selenium30DaysChallenge;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TakeSSS {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.flipkart.com/");
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File tempFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File pemFile = new File("/Users/rakesh/Desktop/screenshot.png");

		FileUtils.copyFile(tempFile, pemFile);
		driver.manage().window().minimize();
		driver.quit();
	}
}
