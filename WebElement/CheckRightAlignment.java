package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Rectangle;

public class CheckRightAlignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        
        WebElement emailTextField = driver.findElement(By.id("email"));
        Rectangle emailRect = emailTextField.getRect();
        int emailStartX = emailRect.getX();
        System.out.println("emailStartX: " + emailStartX);
        int emailWidth = emailRect.getWidth();
        System.out.println("emailWidth: " + emailWidth);
        int emailEnd = emailStartX + emailWidth;
        System.out.println("emailEnd: " + emailEnd);
        
        WebElement passwordTextField = driver.findElement(By.id("pass"));
        Rectangle passwordRect = passwordTextField.getRect();
        int passwordStartX = passwordRect.getX();
        System.out.println("passwordStartX: " + passwordStartX);
        int passwordWidth = passwordRect.getWidth();
        System.out.println("passwordWidth: " + passwordWidth);
        int passwordEnd = passwordStartX + passwordWidth;
        System.out.println("passwordEnd: " + passwordEnd);
        
        if (passwordEnd == emailEnd) {
            System.out.println("Pass: The email and password right alignment verified and found correct.");
        } else {
            System.out.println("Fail: The email and password right alignment verified and found incorrect.");
        }
        
        driver.quit();
    }
}
