package QA;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BusTicketBookingAutomation {
	private WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.busonlineticket.com/booking/bus-tickets.aspx");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void testBusTicketBooking() {

		// Source location - Using sendKeys() for input field
		WebElement source = driver.findElement(By.id("txtOriginGeneral"));
		source.sendKeys("Cameron Highlands");

		// Destination location - Using sendKeys() for input field
		WebElement destination = driver.findElement(By.id("txtDestinationGeneral"));
		destination.sendKeys("Kuala Lumpur");

		// Choose date (using calendar selection)
		/*
		driver.findElement(By.id("txtDepartDateBooking")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ui-datepicker-div")));

		String aMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
		String aYear = driver.findElement(By.className("ui-datepicker-year")).getText();

		while (!(aMonth.equals("December") && aYear.equals("2024"))) {
			driver.findElement(By.xpath("//a[@data-handler='next']")).click();
			aMonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			aYear = driver.findElement(By.className("ui-datepicker-year")).getText();

		}
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='20']")).click();
		*/
		
		//Date
		driver.findElement(By.id("txtDepartDateBooking")).click();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("ui-datepicker-div")));
		driver.findElement(By.xpath("//a[@data-handler='next']")).click();
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='20']")).click();

		// Submit the search
		driver.findElement(By.id("btnBusSearchNewGeneral")).click();

		// Select the first available bus
		//driver.findElement(By.xpath("//button[@id='XB28309584']")).click();

		// Get all rows in the first tbody
		List<WebElement> rows = driver.findElements(By.xpath("//tbody[position()=1]//tr"));

		// Randomly select up to 6 seats
		int numberOfSeatsToSelect = Math.min(6, rows.size());
		Random random = new Random();

		for (int i = 0; i < numberOfSeatsToSelect; i++) {
			// Randomly select an index from the list
			int randomIndex = random.nextInt(rows.size());

			// Get the row (seat) at the random index
			WebElement selectedRow = rows.get(randomIndex);

			// Wait for the element to be visible and clickable
			// WebDriverWait wait = new WebDriverWait(driver, 10);
			//wait.until(ExpectedConditions.elementToBeClickable(selectedRow));

			// Scroll to the element to make sure it's in view
			Actions actions = new Actions(driver);
			actions.moveToElement(selectedRow).perform();

			// Click the selected row (seat)
			selectedRow.click();

			// Remove the selected row from the list to avoid selecting it again
			rows.remove(randomIndex);
		}
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
