package MouseHoverActions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenLinkNewTabs {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement RegLink = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		
	    Actions actions = new Actions(driver);
	    
	    // Control Registration Page
	    actions.keyDown(Keys.CONTROL).click(RegLink).keyUp(Keys.CONTROL).perform();
	    
	    //Switching the Registration Page
	    List<String> ids = new ArrayList(driver.getWindowHandles());
	    
	    //Reg Page
	    driver.switchTo().window(ids.get(1));
	    driver.findElement(By.id("FirstName")).sendKeys("Rakesh");
	    
	    //Home Page 
	    driver.switchTo().window(ids.get(0));
	    
	    
		
		driver.close();

	}

}
