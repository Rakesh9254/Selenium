package HandlingDropDownText;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownUsingByIndex {
    public static void main(String[] args) throws InterruptedException {
        

        // Instantiate the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the webpage
        driver.get("https://pgportal.gov.in/Registration");

        // Wait for the dropdown element to be visible
        Thread.sleep(20000);

        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("country")); // Assuming the ID of the select tag is "country"

        // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Select the option by index
        dropdown.selectByIndex(1);

        // Print the selected option
        System.out.println("Selected option: " + dropdown.getFirstSelectedOption().getText());

        // Minimize the browser window
        driver.manage().window().minimize();

        // Close the browser
        driver.quit();
    }
}
