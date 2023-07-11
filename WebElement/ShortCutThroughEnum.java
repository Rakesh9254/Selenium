package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShortCutThroughEnum {
public static void main(String[] args) throws Throwable {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://crmaccess.vtiger.com/log-in/?mode=continue");
	Thread.sleep(2000);
    WebElement UsernameTextField = driver.findElement(By.name("username"));
    UsernameTextField.sendKeys(Keys.CONTROL+"a");
    Thread.sleep(2000);
    UsernameTextField.sendKeys(Keys.DELETE);
    Thread.sleep(2000);
    UsernameTextField.sendKeys(Keys.chord("admin"));
    Thread.sleep(2000);
    WebElement passwordTextField = driver.findElement(By.name("password"));
    passwordTextField.sendKeys(Keys.chord("Test@123"));
    Thread.sleep(2000);
    WebElement signInbutton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/button[1]"));
    signInbutton.sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    driver.manage().window().minimize();
    driver.quit();
}
}