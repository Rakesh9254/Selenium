package WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class SizeCheck {
    public static void main(String[] args) {    
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");        
        WebElement emailTextField = driver.findElement(By.id("email"));
        Dimension sizeOfEmailTextField = emailTextField.getSize();
        int emailHeight = sizeOfEmailTextField.getHeight();//emailHeight 52
        System.out.println("emailHeight " + emailHeight);
        int emailWidth = sizeOfEmailTextField.getWidth();//emailWidth 364
        System.out.println("emailWidth " + emailWidth);       
        WebElement passwordTextField = driver.findElement(By.id("pass"));
        Dimension sizeOfPasswordTextField = passwordTextField.getSize();
        int passwordHeight = sizeOfPasswordTextField.getHeight();//passwordHeight 22
        System.out.println("passwordHeight " + passwordHeight);
        int passwordWidth = sizeOfPasswordTextField.getWidth();//passwordWidth 300
        System.out.println("passwordWidth " + passwordWidth);       
        if (emailHeight == passwordHeight && emailWidth == passwordWidth) {
            System.out.println("Pass: The email and password size is verified and found correct.");
        } else {
            System.out.println("Fail: The email and password size is verified and found incorrect.");
        }
        //Fail: The email and password size is verified and found incorrect.
        driver.manage().window().minimize();
        
        driver.quit();
    }
}

