package TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

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

	public void setup() {

		// WebDriver driver = new FirefoxDriver();

		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.managed_default_content_settings.images", 2);
		prefs.put("profile.default_content_setting_values.popups", 2);
		options.setExperimentalOption("prefs", prefs);
		// options.addArguments("--disk-cache-size=0");
		// options.addArguments("--media-cache-size=0");
//		options.addArguments("--headless");
//		options.addArguments("--disable-gpu");
//		options.addArguments("--disable-software-rasterizer");
//		options.addArguments("--window-size=1920,1080");
//		options.addArguments("--disable-dev-shm-usage");
//		options.addArguments("--no-sandbox");
//
//		options.addArguments("--enable-features=NetworkService,NetworkServiceInProcess");
//		options.addArguments(
//				"user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.6422.113 Safari/537.36");
//		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//		options.setBinary("/usr/bin/sgoogle-chrome-stable");
//      options.addArguments("--incognito");
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		// driver.get("http://localhost:8008/signin");
		// driver.get("https://preprod.esigns.io/signin");
		// driver.get("https://dev.esigns.io/signin");

		driver.get("https://nsui.esigns.io/signin");

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