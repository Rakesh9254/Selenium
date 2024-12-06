package Screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://chatgpt.com/c/8715c583-13df-4ada-b04a-9efd9724f5c3");
		
		TakesScreenshot takesScreenshot =(TakesScreenshot)driver;
		File temFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File perFile = new File("//Users//rakesh//git//repository//Selenium//ScreenshotEroor//"+ System.currentTimeMillis() +"err01.png");
		FileUtils.copyDirectory(temFile, perFile);
		
		driver.quit();

	}

}
