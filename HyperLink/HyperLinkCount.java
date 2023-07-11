package HyperLink;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HyperLinkCount {
    public static void main(String[] args) throws Throwable {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.calculator.net/");
        Thread.sleep(2000);

        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        System.out.println("Total Number of Links on the Webpage: " + linkElements.size());
        Thread.sleep(2000);
        for (WebElement link : linkElements) {
            System.out.println(link.getText());
        }
        Thread.sleep(10000);
        driver.manage().window().minimize();
        driver.close();
        driver.quit();
    }
}
