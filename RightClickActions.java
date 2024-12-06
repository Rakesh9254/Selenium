package MouseHoverActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickActions {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement Buttom =driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		
		WebElement Copy = driver.findElement(By.xpath("//span[normalize-space()='Copy']"));
		
		Actions actions = new Actions(driver);
		actions.contextClick(Buttom).build().perform();
		Copy.click();
		
		driver.switchTo().alert().accept();
		
		driver.close();

	}

}
