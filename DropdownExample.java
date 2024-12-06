package IntershipDEALSDRAY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownExample {
    public static void main(String[] args) {
        

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        // Open a webpage with a dropdown
        driver.get("https://example.com/dropdown");

        // Locate the dropdown element
        WebElement dropdownElement = driver.findElement(By.id("dropdownId"));

        // Create a Select object
        Select dropdown = new Select(dropdownElement);

        // Select an option by index
        dropdown.selectByIndex(0);

        // Select an option by value
        dropdown.selectByValue("value2");

        // Select an option by visible text
        dropdown.selectByVisibleText("Option 3");

        // Get all selected options
        System.out.println("All selected options: " + dropdown.getAllSelectedOptions());

        // Get the first selected option
        System.out.println("First selected option: " + dropdown.getFirstSelectedOption().getText());

        // Check if the dropdown is multi-select
        System.out.println("Is multiple select: " + dropdown.isMultiple());

        // Deselect options if it's a multi-select dropdown
        if (dropdown.isMultiple()) {
            dropdown.deselectByIndex(1);
            dropdown.deselectByValue("value2");
            dropdown.deselectByVisibleText("Option 3");
            dropdown.deselectAll();
        }

        // Close the WebDriver
        driver.quit();
    }
}
