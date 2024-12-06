package POMPractise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test
    void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setUserName("Admin")
                 .setPassword("admin123")  // Updated to use setPassword
                 .clickLogin();

        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
    }

    @Test
    void addEmployee() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickAdminMenu()
                 .clickAddButton()
                 .selectUserRole("Admin")
                 .setEmpName("Rakesh")
                 .selectStatus("Enabled")
                 .setUsername("Roshan9254")
                 .setPassword1("Rakesh@9254")  // Updated to use setPassword1
                 .setConfirmPassword("Rakesh@9254")
                 .clickSave();
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
