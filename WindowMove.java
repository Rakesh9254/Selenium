import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowMove {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.w3schools.com/");
		driver.findElement(By.id("tnb-google-search-input")).sendKeys("Java");
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN)
		       .sendKeys(Keys.ARROW_DOWN)
		       .sendKeys(Keys.ARROW_DOWN)
		       .sendKeys(Keys.ENTER)
			   .perform();
		
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
