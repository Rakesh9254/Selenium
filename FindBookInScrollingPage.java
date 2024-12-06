package InterviewQuestion;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindBookInScrollingPage {
	public static void main(String[] args) throws Throwable  {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.booksbykilo.in/new-books");
		Actions act = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// failed
		/*
		 * WebElement Book =
		 * driver.findElement(By.xpath("//h3[normalize-space()='The Vile Victorians']"))
		 * ; act.moveToElement(Book).perform();
		 */

		// failed
		
		  WebElement Book =
		  driver.findElement(By.xpath("//img[@title='Queen Charlotte: A Bridgerton Story by Julia Quinn, Shonda Rhimes']"));
		  Book.click();	
		  Thread.sleep(5000);
		  //js.executeScript("arguments[0].scrollIntoView();", Book);
		 

		/*
		boolean found = false;
		while (!found) {
			List<WebElement> books = driver.findElements(By.xpath("//div[@id='productsDiv']//h3"));
			for (WebElement book : books) {
				if (book.getText().equals("The Vile Victorians")) {
					System.out.println("Book found!");
					found = true;
					break;
				}
			}
			*/
			// js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			act.sendKeys(Keys.END).perform();
		}

	

	
}


