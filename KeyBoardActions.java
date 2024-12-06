package MouseHoverActions;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardActions {
    public static void main(String[] args) throws Throwable {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://text-compare.com/");

        WebElement Text1 = driver.findElement(By.id("inputText1"));
        WebElement Text2 = driver.findElement(By.id("inputText2"));

        Actions actions = new Actions(driver);

        Text1.sendKeys("Welcome");

        // CTRL + A
        actions.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();

        // CTRL + C
        actions.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();

        // Tab to shift to 2nd box
        actions.sendKeys(Keys.TAB).perform();

        // CTRL + V
        actions.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

        Thread.sleep(5000); // Just to observe the result, remove in production
        driver.close();
    }
}
