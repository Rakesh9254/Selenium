package POMPractise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver; 
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize WebDriverWait
    }

    // Locators
    By txt_username_loc = By.xpath("//input[@placeholder='Username']");
    By txt_Password_loc = By.xpath("//input[@placeholder='Password']");
    By txt_Sbt_loc = By.xpath("//button[normalize-space()='Login']");

    // Add Employee Locators
    By add_Emp = By.xpath("//a[@class='oxd-main-menu-item active']");
    By add_Emp1 = By.xpath("//button[normalize-space()='Add']");
    By userRoleDropdown = By.xpath("//select[@name='user_role']");  
    By empNameField = By.xpath("//input[@placeholder='Type for hints...']");
    By statusDropdown = By.xpath("//select[@name='status']");  
    By usernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By passwordField = By.xpath("(//input[@type='password'])[1]");
    By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    By saveButton = By.xpath("//button[normalize-space()='Save']");

    // Actions
    public LoginPage setUserName(String username) {
        driver.findElement(txt_username_loc).sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        driver.findElement(txt_Password_loc).sendKeys(password);
        return this;
    }

    public LoginPage clickLogin() {
        driver.findElement(txt_Sbt_loc).click();
        return this;
    }

    // Add Employee Actions
    public LoginPage clickAdminMenu() {
        WebElement adminMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(add_Emp));
        adminMenu.click();
        return this;
    }

    public LoginPage clickAddButton() {
        driver.findElement(add_Emp1).click();
        return this;
    }

    public LoginPage selectUserRole(String role) {
        WebElement roleDropdown = driver.findElement(userRoleDropdown);
        Select select = new Select(roleDropdown);
        select.selectByVisibleText(role);
        return this;
    }

    public LoginPage setEmpName(String name) {
        driver.findElement(empNameField).sendKeys(name);
        return this;
    }

    public LoginPage selectStatus(String status) {
        WebElement statusDropdownElement = driver.findElement(statusDropdown);
        Select select = new Select(statusDropdownElement);
        select.selectByVisibleText(status);
        return this;
    }

    public LoginPage setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
        return this;
    }

    public LoginPage setPassword1(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage setConfirmPassword(String password) {
        driver.findElement(confirmPasswordField).sendKeys(password);
        return this;
    }

    public LoginPage clickSave() {
        driver.findElement(saveButton).click();
        return this;
    }
}
