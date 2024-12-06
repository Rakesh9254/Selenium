package FrameID;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame01 {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		
		WebElement frame01 = driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(frame01);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome");
		driver.switchTo().defaultContent();
		
		WebElement Frame02 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(Frame02);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Selenium");
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Java");
		driver.switchTo().parentFrame();
		
		
		Thread.sleep(1000);
		
		driver.quit();
	}

}
