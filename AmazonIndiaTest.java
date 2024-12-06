package EscrowStack;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.Set;

public class AmazonIndiaTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://www.amazon.in/");
    }

    @Test
    public void testAmazonSearchAndAddToCart() throws Throwable {
        // Search for Wrist Watches 
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        searchBox.sendKeys("Wrist Watches");
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        // Filter Leather
        WebElement leatherFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Leather']")));
        leatherFilter.click();

        // Filter Fastrack
        WebElement fastrackFilter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//a[@aria-label='Apply the filter Fastrack to narrow results']//i[@class='a-icon a-icon-checkbox']")));
        fastrackFilter.click();

        // Navigate to 2nd page of results
        WebElement nextPageButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='2']")));
        nextPageButton.click();

        // Click the 1st product in the 1st row
        WebElement firstProductInFirstRow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h2/a)[1]")));
        firstProductInFirstRow.click();

        // Switchr to the new tab
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String windowHandle : allWindows) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Add to the cart
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='submit.add-to-cart']")));
        addToCart.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
