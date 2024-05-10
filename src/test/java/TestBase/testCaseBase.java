package TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class testCaseBase {
	protected WebDriver driver;

//	  private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
//
//    @BeforeMethod
//    @Parameters("browser")
//    public void setup(@Optional("chrome") String browser) {
//        WebDriver driver = null;
//        switch (browser.toLowerCase()) {
//            case "chrome":
//                driver = new ChromeDriver();
//                break;
//            case "firefox":
//                driver = new FirefoxDriver();
//                break;
//            case "edge":
//                driver = new EdgeDriver();
//                break;
//            default:
//                throw new IllegalArgumentException("Unsupported browser: " + browser);
//        }
//        driverThreadLocal.set(driver);
//        driver.manage().window().maximize();
//        driver.get("https://dev.esigns.io/signin");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//    }
//
//    public WebDriver getDriver() {
//        return driverThreadLocal.get();
//    }
//
//    @AfterMethod
//    public void tearDown() {
//        WebDriver driver = getDriver();
//        if (driver != null) {
//            driver.quit();
//        }
//        driverThreadLocal.remove();
//    }
	public void setup() {

		// driver = new FirefoxDriver();
//
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--disable-gpu");
//
		options.setBinary("/usr/bin/sgoogle-chrome-stable");
//
		options.addArguments("--no-sandbox");
		driver = new ChromeDriver(options);
//		options.addArguments("start-maximized");
//		driver.manage().window().maximize();
//		String hubUrl = "http://192.168.0.107:4444";
//		DesiredCapabilities ds = new DesiredCapabilities();
//		ds.setCapability("browserName", "chrome");
//		try {
//			driver = new RemoteWebDriver(new URL(hubUrl), ds);
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		}

//		assert driver != null;
		driver.manage().window().maximize();
		// driver.get("http://localhost:8008/signin");

		// driver.get("https://preprod.esigns.io/signin");

		driver.get("https://dev.esigns.io/signin");

		// driver.get("https://nsui.esigns.io/signin");

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
