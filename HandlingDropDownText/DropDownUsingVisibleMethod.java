package HandlingDropDownText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownUsingVisibleMethod {
public static void main(String[] args) throws Throwable {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.opencart.com/index.php?route=account/register");
	Thread.sleep(50000);
	WebElement dropdownTextField = driver.findElement(By.id("input-country"));
	Select dropdown = new Select(dropdownTextField);
	dropdown.selectByVisibleText("Iceland");
	
	driver.manage().window().minimize();
	driver.quit();
	
}
}
