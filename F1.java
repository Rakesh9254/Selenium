package InternshipDEALSDRAY;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class F1 {

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

    @BeforeClass
    public void setUp() {
        // No setup code needed here anymore as we'll initialize the driver within each test
    }

    @Test
    public void takeScreenshotsAtDifferentResolutions() throws IOException {
        // Loop through each URL
        for (String url : urls) {
            // Initialize the driver for Firefox
            initializeDriver();

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
                String folderPath = "screenshots/firefox/" + url.replace("https://", "").replace("/", "_") + "/" + resolution.width + "x" + resolution.height;
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

    private void initializeDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/Applications/Firefox.app/Contents/MacOS/firefox");
        driver = new FirefoxDriver(options);
    }

    @AfterClass
    public void tearDown() {
        // Ensure the browser is closed at the end of the tests
        if (driver != null) {
            driver.quit();
        }
    }
}
