package WebDriverMethods;

import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleMultipleWindows {
public static void main(String[] args) throws InterruptedException {
	// istantiate the browser specific class
	WebDriver driver = new ChromeDriver();
	// pre-condn
	driver.manage().window().maximize();
	// trigger the main url of the appln
	driver.get("https://www.facebook.com/");
	driver.switchTo().newWindow(WindowType.WINDOW);
	driver.get("https://www.facebook.com/signup/");
	Set<String> allWid = driver.getWindowHandles();
	System.out.println(allWid);
	for (String wid : allWid) {
		String widTitle = driver.switchTo().window(wid).getTitle();
		System.out.println(widTitle);
		if (widTitle.equals("Facebook – log in or sign up")) {
			
		}else if (widTitle.equals("Sign up for Facebook | Facebook")) {
			Dimension sizeOfTheWindow = driver.manage().window().getSize();
			int heightOfTheWindow = sizeOfTheWindow.getHeight();
			System.out.println("heightOfTheWindow = " + heightOfTheWindow);
			int widthOfTheWindow = sizeOfTheWindow.getWidth();
			System.out.println("widthOfTheWindow = " + widthOfTheWindow);
			
			Point positionOfTheWindow = driver.manage().window().getPosition();
			int startX = positionOfTheWindow.getX();
			System.out.println("startX = " + startX);
			int startY = positionOfTheWindow.getY();
			System.out.println("startY = " + startY);
			
			Dimension definedSize = new Dimension(200, 350);
			driver.manage().window().setSize(definedSize);
			
			Point definedPosition = new Point(30, 90);
			driver.manage().window().setPosition(definedPosition);
			Thread.sleep(2000);
			//driver.close();
		}
	}
	driver.quit();
}
}