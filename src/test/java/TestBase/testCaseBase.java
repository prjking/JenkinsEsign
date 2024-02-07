package TestBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testCaseBase {
	protected WebDriver driver;

	public void setup() {

		// driver = new FirefoxDriver();

		
 ChromeOptions options = new ChromeOptions();
//  options.addArguments("--no-sandbox", "--disable-gpu");
//		  driver = new ChromeDriver(options);
		 

		options.setCapability("pageLoadStrategy", "eager");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.esigns.io/signin");

	}
	
	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}
	
	
	
}
