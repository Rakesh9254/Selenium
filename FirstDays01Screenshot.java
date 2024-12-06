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

public class FirstDays01Screenshot {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com");
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File desFile = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(desFile, new File("/Users/rakesh/Desktop/screenshot.png"));
			System.out.println("Screenshot captured and saved successfully!");

		} catch (IOException e) {
			System.out.println("An error occurred while saving the screenshot: " + e.getMessage());
		}
		driver.quit();
	}

}
