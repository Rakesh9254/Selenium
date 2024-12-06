package Selenium30DaysChallenge;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropDown {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//span[@class='multiselect-selected-text']")).click();
		//select singal element
		
		//driver.findElement(By.xpath("//input[@value='Java']")).click();
		
		List<WebElement> options1 = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		System.out.println("Options:"+options1.size());
		
		//printing all options 
		for(WebElement op:options1) {
//			System.out.println(op.getText());
			
			// select multiple Options 
			String options2 =op.getText();
			if(options2.equals("Java") || options2.equals("CSS") || options2.equals("Bootstrap"));
			op.click();
		}
		
		//Select Multiple Actions 
		
		driver.close();

}
}