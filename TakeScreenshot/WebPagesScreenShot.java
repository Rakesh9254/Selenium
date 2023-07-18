package TakeScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPagesScreenShot {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		driver.get("https://india.wcs.org/Programmes/Desert-Landscape");
		TakesScreenshot tc = (TakesScreenshot)driver;
		File tempFile = tc.getScreenshotAs(OutputType.FILE);
		File permFile = new File("./errorshots/indiaWCS.png");
		FileUtils.copyFile(tempFile, permFile);
		driver.manage().window().minimize();
		driver.quit();

	}

}
