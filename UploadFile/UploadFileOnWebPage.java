package UploadFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFileOnWebPage {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
		Thread.sleep(8000);
		//Using Sendkey()Method for upload the file
		driver.findElement(By.xpath("//input[@id='uploadFile']")).sendKeys("/Users/rakesh9254/Desktop/Rakesh Roshan.pdf");
		Thread.sleep(4000);
		driver.manage().window().minimize();
		
		driver.quit();

	}

}
