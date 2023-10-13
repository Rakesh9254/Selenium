import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLoginTestNG {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Test
    public void loginAndFillForm() throws InterruptedException {
        driver.get("https://tattvabooking.abhosting.co.in/login");

        WebElement emailTextField = driver.findElement(By.id("username"));
        emailTextField.sendKeys("superadmin");

        WebElement pwdTextField = driver.findElement(By.id("password"));
        pwdTextField.sendKeys("12345678");

        WebElement loginButton = driver.findElement(By.cssSelector("button.btn.btn-success.pull-right"));
        loginButton.click();

        String expectedTitle = "Demo Booking Login";
        String actualTitle = driver.getTitle();
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("Login is not Successfully!");
        } else {
            System.out.println("Login is Successfully!");
            Thread.sleep(10000);
            driver.findElement(By.xpath("//p[normalize-space()='User Management']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[@href='https://tattvabooking.abhosting.co.in/user-info']"))
                  .click();
            Thread.sleep(3000);
            driver.findElement(By.id("btnAddUser")).click();
            Thread.sleep(10000);

            driver.findElement(By.id("email")).sendKeys("Aryan@gmail.com");
            driver.findElement(By.id("username")).sendKeys("Aryan1234");
            driver.findElement(By.id("name")).sendKeys("Aryan Prakash");
            driver.findElement(By.id("password")).sendKeys("Aryan@123");
            driver.findElement(By.id("password_confirmation")).sendKeys("Aryan@123");

            // Click on the country dropdown to open it
            WebElement countryDropdown = driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(countryDropdown).click().perform();

            // Select the option "Spain" from the dropdown
            WebElement spainOption = driver.findElement(By.xpath("//li[text()='Spain']"));
            wait.until(ExpectedConditions.elementToBeClickable(spainOption)).click();

            Thread.sleep(3000);
            
            // Other dropdown selections and actions can be added here.

            // User Role
            WebElement userSelectField = driver.findElement(By.id("sec_role_id"));
            Select userSelect = new Select(userSelectField);
            userSelect.selectByVisibleText("QA");
            
            // Wait for the Save button to be clickable
            WebElement saveButton = driver.findElement(By.id("btnSave"));
            wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
        }
    }

    @AfterTest
    public void tearDown() {
        driver.manage().window().minimize();
        driver.quit();
    }
}