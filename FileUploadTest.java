package IntershipDEALSDRAY;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadTest {

    public static void main(String[] args) {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Navigate to the web page with the file upload form
            driver.get("https://demo.dealsdray.com/"); // Replace with the actual URL
            
            // username
            WebElement Username =driver.findElement(By.id("mui-1"));
            Username.sendKeys("prexo.mis@dealsdray.com");
            
            WebElement Password = driver.findElement(By.id("mui-2"));
            Password.sendKeys("prexo.mis@dealsdray.com");
            
            WebElement Sbt = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
            Sbt.click();
            
            WebElement order = driver.findElement(By.xpath("//span[.='chevron_right']"));
            order.click();
            
            WebElement order1 = driver.findElement(By.xpath("//a[@class='navItemActive false']//button[@name='child']"));
            order1.click();
            
            
            WebElement bulkElement = driver.findElement(By.xpath("//button[normalize-space()='Add Bulk Orders']"));
            bulkElement.click();

            // Locate the file input element
            WebElement uploadElement = driver.findElement(By.id("mui-18")); // Replace with the actual ID
            uploadElement.click();

            // Specify the file path on your macOS system
            String filePath = "'/Users/rakesh/Desktop/Screenshot/Screenshot 2024-08-06 at 11.25.57 PM.png'"; // Replace with your file path

            // Upload the file by sending the file path to the input element
          //button[normalize-space()='Import']
            
            uploadElement.sendKeys(filePath);

            // Optionally, submit the form if necessary
            // uploadElement.submit();

            // You can add assertions or further actions here to validate the upload
            System.out.println("File uploaded successfully!");

        } finally {
            // Clean up and close the browser
            driver.quit();
        }
    }
}
