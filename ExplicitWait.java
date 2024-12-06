package Synchronization;

import java.lang.annotation.ElementType;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.co.in/");
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("q")));
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.id("q")));
		WebElement element3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("q")));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		
		
		driver.close();
	}

}
