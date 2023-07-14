package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Point;

public class CheckLeftAlignment {
    public static void main(String[] args) {
        
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        
        WebElement emailTextField = driver.findElement(By.id("email"));
        Point emailLocation = emailTextField.getLocation();
        int emailStartX = emailLocation.getX();
        System.out.println("emailStartX " + emailStartX);
        
        WebElement passwordTextField = driver.findElement(By.id("passContainer"));
        Point passwordLocation = passwordTextField.getLocation();
        int passwordStartX = passwordLocation.getX();
        System.out.println("passwordStartX " + passwordStartX);
        
        if (emailStartX == passwordStartX) {
            System.out.println("Pass: The email and password left verified and found correct.");
        } else {
            System.out.println("Fail: The email and password left verified and found incorrect.");
        }
        
        driver.quit();
    }
}
