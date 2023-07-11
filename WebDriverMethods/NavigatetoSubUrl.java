package WebDriverMethods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigatetoSubUrl {
public static void main(String[] args) throws MalformedURLException, InterruptedException {
    // instantaite the browser specific class
    WebDriver driver = new ChromeDriver();
    // pre-condn
    driver.manage().window().maximize();
    // trigger the main url of the appln
    driver.get("https://www.dassault-aviation.com/en/");
    Thread.sleep(2000);
    URL mainUrl = new URL("https://www.dassault-aviation.com/en/");// url(string spec)
    URL groupsPage = new URL(mainUrl, "group/");// url(context, spec)
    driver.navigate().to(groupsPage);
    Thread.sleep(2000);
    URL spacePage = new URL(mainUrl, "space/");
    driver.navigate().to(spacePage);
    Thread.sleep(2000);
    // post - condn
    driver.manage().window().minimize();
    driver.quit();
}
}