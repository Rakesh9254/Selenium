package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.awt.Color;

public class ColorCheck {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        WebElement loginButton = driver.findElement(By.name("login"));
        String backgroundColorOfLogin = loginButton.getCssValue("background-color");
        System.out.println("backgroundColorOfLogin = " + backgroundColorOfLogin);
        Color color = Color.decode(backgroundColorOfLogin);
        String hexaDecimalValue = "#" + Integer.toHexString(color.getRGB()).substring(2);
        System.out.println("hexaDecimalValue = " + hexaDecimalValue);
        driver.manage().window().minimize();
        driver.quit();
    }
}
