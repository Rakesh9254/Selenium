package InterviewQuestion;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicRadioBtn {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.facebook.com/r.php");
		
		List<WebElement> radiobtn = driver.findElements(By.xpath("//span[@class='_5k_2 _5dba']"));
		
		for(WebElement sex : radiobtn) {
			System.out.println("sexlist : "+ sex.getText());
			if(sex.getText().equals("Female")) {
				sex.click();
			}
		}
		
		driver.quit();
	}

}
