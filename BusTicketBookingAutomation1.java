package QA;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BusTicketBookingAutomation1 {
    private WebDriver driver;

    // Setup method for initializing WebDriver
    @BeforeClass
    public void setUp() {
        // Setup WebDriver for Chrome
        WebDriverManager.chromedriver().setup();

        // Set ChromeOptions to allow for cross-origin requests
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--incognito");

        // Initialize WebDriver and open the Bus Online Ticket booking page
        driver = new ChromeDriver(options);
        driver.get("https://www.busonlineticket.com/booking/bus-tickets.aspx");

        // Maximize the browser window and set implicit wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Test method for booking bus tickets
    @Test
    public void testBusTicketBooking() throws InterruptedException {
        // Locate the source input field and enter the source location
        WebElement source = driver.findElement(By.id("txtOriginGeneral"));
        source.sendKeys("Cameron Highlands");

        // Locate the destination input field and enter the destination location
        WebElement destination = driver.findElement(By.id("txtDestinationGeneral"));
        destination.sendKeys("Kuala Lumpur");

        // Select the departure date by clicking the date input field and choosing the date
        WebElement dateInput = driver.findElement(By.id("txtDepartDateBooking"));
        dateInput.click();

        // Explicit wait for the "Next" button to be clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-handler='next']")));
        nextButton.click();

        // Wait for the date to be clickable
        WebElement selectDate = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//td[@data-handler='selectDay']/a[text()='20']")));
        selectDate.click();

        // Click the search button to submit the search for available buses
        WebElement searchButton = driver.findElement(By.id("btnBusSearchNewGeneral"));
        searchButton.click();

        // Wait until the available buses are loaded and ready for selection
        WebElement selectButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("(//b[contains(text(),'SELECT')])[1]")));
        selectButton.click();

        // Choose seats (optional: If you need to select seats dynamically, here is how to proceed)
        selectSeats();

    }

    // Method to select seats (assuming seat availability check is needed)
    private void selectSeats() throws InterruptedException {
        // Wait for the seats to load and become interactable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Find the list of available seats
        List<WebElement> seatList = driver.findElements(By.xpath("//small[@class='position-absolute']"));
        
        int selectedSeatsCount = 0;
        for (WebElement seat : seatList) {
            String seatText = seat.getText().trim();

            // Check if the seat is available (adjust the condition as per your case)
            if (!seatText.isEmpty() && !seatText.equals("Reserved")) {
                seat.click();  // Select the seat
                selectedSeatsCount++;

                // Stop after selecting 6 seats (or you can modify the number)
                if (selectedSeatsCount == 6) {
                    break;
                }
            }
        }

        // Optional: Log the selected seats count
        System.out.println("Selected " + selectedSeatsCount + " seats.");
    }

    // Teardown method to close the WebDriver after the test
    @AfterClass
    public void teardown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
