package TestBase;

import java.awt.Dimension;
import java.time.Duration;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testCaseBase {
	protected WebDriver driver;

	public void setup() {

		// driver = new FirefoxDriver();
//
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--disable-gpu");

		options.setBinary("/usr/bin/sgoogle-chrome-stable");

		options.addArguments("--no-sandbox");

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();


		// driver.get("https://preprod.esigns.io/signin");

		driver.get("https://dev.esigns.io/signin");

		driver.manage().window().maximize();

	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void startTest(String methodName, int priority) {
		System.out.println("Test method starting: " + methodName + " with priority: " + priority);
	}
}
