package HandlingDropDownText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownUsingByIndex {
	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://pgportal.gov.in/Registration");
		Thread.sleep(20000);
		WebElement dropdownTextField = driver.findElement(By.className("select2-search__field"));
		Select dropdown = new Select(dropdownTextField);
		dropdown.selectByIndex(1);
		Thread.sleep(2000);
		driver.manage().window().minimize();
		driver.quit();
		
	}
}
