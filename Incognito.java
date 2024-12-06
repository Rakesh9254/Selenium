package BrowserSetting;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Incognito {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		options.addArguments("--headless");
		options.addArguments("--disable-extensions");
		options.addArguments("--start-maximized");
		options.addArguments("user-agent=your-custom-user-agent");

		HashMap<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.notifications", 2); // Block notifications
		options.setExperimentalOption("prefs", prefs);

		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.youtube.com/@QAFox/videos");
		driver.quit();

	}

}
