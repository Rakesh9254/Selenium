package WebDriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pre_PostCondition {
public static void main(String[] args) throws Throwable {
	// instantiate the browser specific class
	WebDriver driver = new ChromeDriver();
	// pre-condition
	driver.manage().window().maximize();
	Thread.sleep(2000);
	// trigger the main url of the appln
	driver.get("https://www.dassault-aviation.com/en/");
	Thread.sleep(2000);
	driver.manage().window().fullscreen();
	Thread.sleep(2000);
	// post-condition
	driver.manage().window().minimize();
	driver.quit();
}
}