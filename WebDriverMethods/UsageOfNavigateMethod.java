package WebDriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsageOfNavigateMethod {
public static void main(String[] args) throws InterruptedException {
	// Inatantiate the browser specific class
	WebDriver driver = new ChromeDriver();
	// pre-condition
	driver.manage().window().maximize();
	// trigger the main url of the appln
	driver.get("https://www.dassault-aviation.com/en/");
	Thread.sleep(2000);
	driver.navigate().to("https://www.dassault-aviation.com/en/group/");
	Thread.sleep(2000);
	driver.navigate().to("https://www.dassault-aviation.com/en/civil/");
	Thread.sleep(2000);
	driver.navigate().back();
	Thread.sleep(2000);
	driver.navigate().forward();
	Thread.sleep(2000);
	driver.navigate().to("https://www.dassault-aviation.com/en/space/");
	Thread.sleep(2000);
	driver.navigate().to("https://www.dassault-aviation.com/en/defense/");
	Thread.sleep(2000);
	driver.navigate().to("https://www.dassault-aviation.com/en/passion/");
	Thread.sleep(2000);
	driver.navigate().refresh();
	Thread.sleep(2000);
	// post-condition
	driver.manage().window().minimize();
	driver.quit();
}
}