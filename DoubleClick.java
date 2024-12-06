package MouseHoverActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClick {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
        
        driver.switchTo().frame("iframeResult");
        
        WebElement Box1 = driver.findElement(By.xpath("//input[@id='field1']"));
        WebElement Box2 = driver.findElement(By.xpath("//input[@id='field2']"));
        
        WebElement Copy = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
        
        Box1.clear();
        Box1.sendKeys("Welcome");
        
        Actions actions = new Actions(driver);
        actions.doubleClick(Copy).perform();
        
        String Box2Text = Box2.getAttribute("value");
        
        if(Box2Text.equals("Welcome")) {
            System.out.println("Same.....");
        } else {
            System.out.println("Difference...");
        }
        
        driver.quit();
    }
}
