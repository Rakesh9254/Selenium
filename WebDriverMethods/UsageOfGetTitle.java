package WebDriverMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsageOfGetTitle {
public static void main(String[] args) {
	// Instantiate the browser specific class
	WebDriver driver = new ChromeDriver();
	// trigger the main url of the appln
	driver.get("https://www.facebook.com/");
	String expectedTitle = "Facebook – log in or sign up";
	System.out.println("expectedTitle = " + expectedTitle);
	// capture the title of the webpage
	String actualTitle = driver.getTitle();
	System.out.println("actualTitle = " + actualTitle);
	if (actualTitle.equals(expectedTitle)) {
		System.out.println("Pass: The Actual title is verified and found correct.");
	}else {
		System.out.println("Fail: The Actual title is verified and found incorrect.");
	}
}
}