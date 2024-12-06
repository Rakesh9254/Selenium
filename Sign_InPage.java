package Mini_Project;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sign_InPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://pgportal.gov.in/");
    }

    @Test
    public void testSignUp() {
        driver.findElement(By.xpath("//a[normalize-space()='Sign In']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Click here to sign up']")).click();
        
        driver.findElement(By.id("Name")).sendKeys("Rakesh");
        driver.findElement(By.id("Sex_M")).click();
        driver.findElement(By.id("Address1")).sendKeys("BLR");
        driver.findElement(By.id("Address2")).sendKeys("BLR");
        driver.findElement(By.id("Address3")).sendKeys("BLR");

        // Handling custom country dropdown
        WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-country-container")));
        countryDropdown.click();
        WebElement countryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='India']")));
        countryOption.click();

        // Handling custom state dropdown
        WebElement stateDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-state-container")));
        stateDropdown.click();
        WebElement stateOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Karnataka']")));
        stateOption.click();

        // Handling custom district dropdown
        WebElement districtDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-district-container")));
        districtDropdown.click();
        WebElement districtOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Bengaluru (Bangalore) Urban']")));
        districtOption.click();

        driver.findElement(By.id("Pincode")).sendKeys("560068");
        driver.findElement(By.id("MobileNo")).sendKeys("7631744096");
        driver.findElement(By.id("EmailAddress")).sendKeys("rakeshkumarroshan62@gmail.com");
        driver.findElement(By.id("Captcha")).click();

        // Wait for captcha to load, adjust as needed
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Submit']"))).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
