package Pages;

import java.time.Duration;
import java.util.Map;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.APIUtils;
import utils.SessionManager;

public class Login {
	WebDriver driver;

	public Login(WebDriver driver) {

		this.driver = driver;

	}

	public void waitEle(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void Signin() throws Exception {
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"),
				"saikumar.basolutions@gmail.com");
		System.out.println("Email entered successfully");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Password']"), "Nimble#2022");
		System.out.println("Password entered successfully");

		waitEle(By.xpath("//span[normalize-space()='Log In']"));
		System.out.println("Login button clicked");
		Thread.sleep(10000);

	}

	public boolean Signindata(String username, String password) throws Exception {
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"), username);
		System.out.println("Email entered successfully");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Password']"), password);
		System.out.println("Password entered successfully");

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Log In']"));
		System.out.println("Login button clicked");
		Thread.sleep(10000);

		return isLoginSuccessful();
	}

	private boolean isLoginSuccessful() {

		return true;
	}

	public class LoginDataProvider {

		@DataProvider(name = "loginData")
		public Object[][] provideLoginData() {
			return new Object[][] { { "saikumar.basolutions@gmail.com", "Nimble#2022", true },
					{ "invalidUser@abc.com", "invalidPass", false }, { "", "Nimble#2022", false },
					{ "saikumar.basolutions@gmail.com", "", false }, { "invalidUser@abc.com", "Nimble#2022", false },
					{ "saikumar.basolutions@gmail.com", "invalidPass", false } };
		}
	}

	public void Signinprj() throws InterruptedException {
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("prudhviraju.buddharaju@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Nimble#2024");
		waitEle(By.xpath("//span[normalize-space()='Log In']"));
		Thread.sleep(10000);

	}

	public void SigninRamya() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']")).sendKeys("N180959@rguktn.ac.in");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Ramya@1234");
		driver.findElement(By.xpath("//span[normalize-space()='Log In']")).click();
		Thread.sleep(10000);

	}

	public void Signinr() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("ramya.sibbala@nimbleaccounting.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Ramyasri@123");
		driver.findElement(By.xpath("//button[@class='el-button type-2 w-100 fs-6 el-button--danger']")).click();
		Thread.sleep(10000);

	}

	public void SigninMeghana() throws InterruptedException {

		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']")).sendKeys("n180894@rguktn.ac.in");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Meghana@123");
		waitEle(By.xpath("//span[normalize-space()='Log In']"));
		Thread.sleep(10000);
	}

	public void login() throws Exception {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("pmmeghana2001@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Meghana@123");
		waitEle(By.xpath("//span[normalize-space()='Log In']"));
		Thread.sleep(10000);
	}

	public void VerifyLoginSucess() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement welcomeMessage = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class='fw-large blue-dark mb-3 fs-10']")));

		Assert.assertNotNull(welcomeMessage, "Welcome message element is not present Login Failed");
		System.out.println("Login Successful");
	}

	public void SigninNSUI() throws InterruptedException {

		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("pmmeghana200@outlook.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Meghana@123");
		waitEle(By.xpath("//span[text()=\"Log In\"]"));
		Thread.sleep(10000);

	}

	public void RamyaNsui() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("ramya.sibbala@nimbleaccounting.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Ramyasri@123");
		driver.findElement(By.xpath("//button[@class='el-button type-2 w-100 fs-6 el-button--danger']")).click();
		Thread.sleep(10000);

	}
//	public void jen() throws InterruptedException {
//  Thread.sleep(10000);
//
//  try {
//      // Sign in to get the authentication token
//      SessionManager sessionManager = new SessionManager(driver);
//
//      // Create the payload for the API call
//      JSONObject payload = new JSONObject();
//      payload.put("username", "automation");
//      payload.put("password", "Nimble#2023");
//      String uri = "https://at.esigns.io/";
//
//      // Get the authentication token using the API call
//      String authToken = new APIUtils().postCallGetCookies(payload, uri);
//
//      if (authToken != null) {
//          // Bypass the login using the authentication token
//          sessionManager.byPassLoginUsingCookies(authToken, "https://at.esigns.io/");
//      } else {
//          System.out.println("Failed to obtain authToken. Login bypass failed.");
//      }
//  } finally {
//      
//      driver.quit();
//  }
//}

}