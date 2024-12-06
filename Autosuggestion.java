package Automation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Autosuggestion {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--incognito");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-infobars");
		options.addArguments("--enable-automation");
		options.addArguments("--disable-infobars"); // This may still work in some versions
		options.addArguments("--disable-automation"); // Disable automation warning
		options.addArguments("--start-maximized"); // Optional: Start maximized
		options.addArguments("--incognito"); // Open Chrome in Incognito Mode
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.findElement(By.id("APjFqb")).sendKeys("selenium");

		// Approach
		/*
		 * 
		 * List<WebElement> list =
		 * driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		 * 
		 * for (WebElement lists : list) { if (lists.getText().equals("selenium dev")) {
		 * lists.click(); }
		 */

		// Approach
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN)
		       .sendKeys(Keys.ARROW_DOWN)
		       .sendKeys(Keys.ARROW_DOWN)
		       .sendKeys(Keys.ENTER)
			   .perform();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.close();

	}

}
