package Selenium30DaysChallenge;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ThirdDays03AutoSuggestion {
	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        
        // Maximize window and set timeouts
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://www.google.co.in/");
        
        driver.findElement(By.name("q")).sendKeys("Selenium");
        Thread.sleep(5000);
        
        List<WebElement> Options = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
        System.out.println("Size is :"+Options.size());
        
        for(int i=0;i<Options.size();i++) {
        	System.out.println(Options.get(i).getText());
        	if(Options.get(i).getText().equals("Selenium")) {
        		Options.get(i).click();
        		break;
        	}
        }
        
        
        driver.close();
	}

}
