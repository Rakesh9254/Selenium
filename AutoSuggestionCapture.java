package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TimeoutException;
import java.util.List;

public class AutoSuggestionCapture {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		try {

			driver.get("https://www.w3schools.com/");

			WebElement searchField = driver.findElement(By.id("tnb-google-search-input"));
			searchField.sendKeys("Java");

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tnb-search-suggestions")));

			List<WebElement> suggestions = driver
					.findElements(By.cssSelector("#tnb-search-suggestions a.search_item.search-suggestion-link"));

			for (WebElement suggestion : suggestions) {
				String suggestionText = suggestion.getText();
				System.out.println(suggestionText);

				if (suggestionText.contains("JAVA")) {
					suggestion.click();
					break;
				}
			}

		} catch (TimeoutException e) {
			System.out.println("Auto-suggestions did not appear in time.");
		} finally {

			driver.quit();
		}
	}
}
