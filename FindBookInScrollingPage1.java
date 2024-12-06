package InterviewQuestion;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBookInScrollingPage1 {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.booksbykilo.in/new-books");
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//WebElement Book1 = driver.findElement(By.xpath("//img[@title='My Sister Lives on the Mantelpiece by Annabel Pitcher']"));
		//Book1.click();
		Thread.sleep(5000);

		WebElement book = driver.findElement(By.xpath("//img[@title='Queen Charlotte: A Bridgerton Story by Julia Quinn, Shonda Rhimes']"));
		book.click();

		Thread.sleep(7000);
		
		// js.executeScript("arguments[0].scrollIntoView();", Book);
		driver.quit();

	}

}
