package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OneEndToEnd {

    public static void main(String[] args) throws Throwable {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");

        // Enter username
        WebElement usernameTextField = driver.findElement(By.id("email"));
        usernameTextField.sendKeys("rakeshkumarroshan62@gmail.com");

        // Enter password
        WebElement passwordTextField = driver.findElement(By.id("pass"));
        passwordTextField.sendKeys("Roshan@9254");

        // Click on login button
        WebElement loginButton = driver.findElement(By.xpath("(//button[normalize-space()='Log in'])[1]"));
        loginButton.click();

        // Wait for 500 milliseconds
        Thread.sleep(500);

        // Get the current URL
        String actualHomePageUrl = driver.getCurrentUrl();
        System.out.println("actualHomePageUrl: " + actualHomePageUrl);

        // Check if the current URL is the home page URL
        if (actualHomePageUrl.equals("https://www.facebook.com/")) {
            // Find the logout link
            WebElement logoutLink = driver.findElement(By.id("logoutLink"));

            // Check if the logout link is displayed
            if (logoutLink.isDisplayed()) {
                // Click on the logout link
                logoutLink.click();

                // Print a message to indicate that the logout link was clicked
                System.out.println("The logout link was clicked.");
            } else {
                // Print a message to indicate that the logout link was not displayed
                System.out.println("The logout link was not displayed.");
            }
        } else {
            // Print a message to indicate that the current URL is not the home page URL
            System.out.println("The current URL is not the home page URL.");
        }

        // Minimize the window
        driver.manage().window().minimize();

        // Quit the driver
        driver.quit();
    }
}
