package Flipkart;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart01 {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		WebElement SearchBox = driver.findElement(By.xpath("//input[@name='q']"));
		SearchBox.sendKeys("iphone 15 pro max");
		SearchBox.submit();

		String mainPage = driver.getWindowHandle();
		System.out.println("Main Page:" + mainPage);
		driver.findElement(By.xpath("//div[.='Apple iPhone 15 Pro Max (Blue Titanium, 256 GB)']")).click();

		Set<String> allpages = driver.getWindowHandles();

		for (String page : allpages) {
			if (!page.equals(mainPage)) {
				driver.switchTo().window(page);
				break;
			}
		}
		System.out.println("URL" + driver.getCurrentUrl());
		List<WebElement> products = driver.findElements(By.className("rgWa7D"));
		System.out.println("Size: " + products.size());

		for (WebElement product : products) {
			System.out.println("Description: " + product.getText());

		}

		driver.close();
		driver.quit();
	}

}
