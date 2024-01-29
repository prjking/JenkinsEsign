package TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class testCaseBase {
	protected WebDriver driver;

	public void setup() {

		// driver = new FirefoxDriver();

		
//	  ChromeOptions options = new ChromeOptions();
//		  options.addArguments("--headless"); driver = new ChromeDriver(options);
//		 


		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://dev.esigns.io/signin");

	}
}
