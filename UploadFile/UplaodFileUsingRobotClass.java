package UploadFile;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;

public class UplaodFileUsingRobotClass {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
		WebElement UploadButton = driver.findElement(By.xpath("//input[@id='uploadFile']"));
		Actions action = new Actions(driver);
		action.moveToElement(UploadButton).click().perform();
		
		Robot robot = new Robot();
		robot.delay(2000);
		StringSelection ss = new StringSelection("/Users/rakesh9254/Desktop/Rakesh Roshan.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
		
		driver.manage().window().minimize();
		driver.quit();

	}

}
