package InternshipDEALSDRAY;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SS {

    private WebDriver driver;

    private String baseUrl = "https://example.com"; // Replace with the target website

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox"); // Path to Firefox binary
            driver = new FirefoxDriver(options);
        }
        // Add more browsers if needed
    }

    @Test
    public void takeScreenshotsAtDifferentResolutions() throws IOException {
        // Array of resolutions to test
        Dimension[] resolutions = {
                new Dimension(1920, 1080),
                new Dimension(1366, 768),
                new Dimension(1536, 864)
        };

        // Array of URLs to test
        String[] urls = {
        		"https://www.getcalley.com/",
                "https://www.getcalley.com/calley-lifetime-offer/",
                "https://www.getcalley.com/see-a-demo/",
                "https://www.getcalley.com/calley-teams-features/",
                "https://www.getcalley.com/calley-pro-features/"
        };

        // Iterate over each URL
        for (String url : urls) {
            // Navigate to the website
            driver.get(url);

            // Iterate over each resolution
            for (Dimension resolution : resolutions) {
                // Set browser window size to the current resolution
                driver.manage().window().setSize(resolution);

                // Take a screenshot
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                // Format the timestamp for the filename
                String timeStamp = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());

                String browser = null;
				// Create the folder structure for saving screenshots
                String folderPath = "screenshots/" + browser + "/" + url.replace("https://", "").replace("/", "_") + "/" + resolution.width + "x" + resolution.height;
                Files.createDirectories(Paths.get(folderPath));

                // Save the screenshot to the specified directory
                File destFile = new File(folderPath + "/Screenshot-" + timeStamp + ".png");
                Files.copy(screenshot.toPath(), destFile.toPath());

                System.out.println("Screenshot saved: " + destFile.getAbsolutePath());
            }
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

