package IntershipDEALSDRAY;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotTest {

    private WebDriver driver;

    // List of URLs to test
    private String[] urls = {
            "https://www.getcalley.com/",
            "https://www.getcalley.com/calley-lifetime-offer/",
            "https://www.getcalley.com/see-a-demo/",
            "https://www.getcalley.com/calley-teams-features/",
            "https://www.getcalley.com/calley-pro-features/"
    };

    // Array of resolutions to test
    private Dimension[] resolutions = {
            new Dimension(1920, 1080),
            new Dimension(1366, 768),
            new Dimension(1536, 864)
    };

    @BeforeMethod
	@BeforeClass
    public void setUp() {
        // No setup code needed here anymore as we'll initialize the driver within each test
    }

    @Test
    public void takeScreenshotsAtDifferentResolutions() throws IOException {
        // Loop through each browser
        String[] browsers = {"chrome", "firefox", "safari"};
        for (String browser : browsers) {
            // Loop through each URL
            for (String url : urls) {
                // Initialize the driver for the current browser
                initializeDriver(browser);

                // Loop through each resolution
                for (Dimension resolution : resolutions) {
                    // Set browser window size to the current resolution
                    driver.manage().window().setSize(resolution);

                    // Navigate to the website
                    driver.get(url);

                    // Take a screenshot
                    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                    // Format the timestamp for the filename
                    String timeStamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());

                    // Create the folder structure for saving screenshots
                    String folderPath = "screenshots/" + browser + "/" + url.replace("https://", "").replace("/", "_") + "/" + resolution.width + "x" + resolution.height;
                    Files.createDirectories(Paths.get(folderPath));

                    // Save the screenshot to the specified directory
                    File destFile = new File(folderPath + "/Screenshot-" + timeStamp + ".png");
                    Files.copy(screenshot.toPath(), destFile.toPath());

                    System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
                }
                // Close the browser after each URL
                if (driver != null) {
                    driver.quit();
                }
            }
        }
    }

    private void initializeDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                firefoxOptions.setBinary("/Applications/Firefox.app");
                break;
            case "safari":
                // Safari driver doesn't require setup like Chrome or Firefox
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }

    @AfterMethod
	@AfterClass
    public void tearDown() {
        // Ensure the browser is closed at the end of the tests
        if (driver != null) {
            driver.quit();
        }
    }
}
