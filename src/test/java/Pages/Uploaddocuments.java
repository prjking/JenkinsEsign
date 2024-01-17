package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Uploaddocuments {
	WebDriver driver;

	public Uploaddocuments(WebDriver driver) {
		this.driver = driver;

	}

	public void Fileupload() throws InterruptedException, Exception {

		By Element = By.xpath("//h4[@class='fw-normal blue pb-2']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));
		canc.click();
		Runtime.getRuntime().exec("\"C:\\Work Space\\EsignTest\\src\\test\\resources\\upload.exe\"");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class='el-button text-center upload-btn el-button--danger']")).click();

	}

	public void Dropbox() throws Exception {
		By Element = By.xpath("//img[@src='/img/dropbox.203cef8e.svg']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));
		canc.click();

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		String Parentwindowid = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[normalize-space()='Connect Dropbox']")).click();
		Set<String> allwindowhandles = driver.getWindowHandles();
		for (String childwindow : allwindowhandles) {
			if (!childwindow.endsWith(Parentwindowid)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(10000);
				driver.findElement(By.xpath("//input[@type='email']")).sendKeys("prudhviraju9701@gmail.com");
				try {

					By Element1 = By.id("accept_all_cookies_button");
					WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofSeconds(30));
					WebElement canc1 = hold1.until(ExpectedConditions.elementToBeClickable(Element1));
					canc1.click();
					Thread.sleep(10000);

				} catch (Exception e) {
					Thread.sleep(10000);
					driver.findElement(By.xpath("//span[normalize-space()='Continue']")).click();

				}
			}
		}

		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Prjking@99");
		try {

			By Element1 = By.id("accept_all_cookies_button");
			WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement canc1 = hold.until(ExpectedConditions.elementToBeClickable(Element1));
			canc1.click();
			Thread.sleep(10000);

		} catch (Exception e) {
			Thread.sleep(10000);
			driver.findElement(By.xpath("//span[normalize-space()='Log in']")).click();

		}
		driver.switchTo().window(Parentwindowid);
		driver.findElement(By.xpath("//span//span[normalize-space()='01 2160 Pineneedle Row.jpg']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[@data-e2e='upload']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class='el-button text-center upload-btn el-button--danger']")).click();
	}
	

	/*
	 * public void fg() throws InterruptedException, Exception {
	 * 
	 * By Element = By.xpath("img[src=\"/img/google-drive.19977565.svg\"]");
	 * WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
	 * WebElement canc =
	 * hold.until(ExpectedConditions.elementToBeClickable(Element)); canc.click();
	 * Thread.sleep(3000);
	 * 
	 * Set<String> windowHandles = driver.getWindowHandles(); for (String handle :
	 * windowHandles) { driver.switchTo().window(handle); } Thread.sleep(5000);
	 * String ParentWindowID =driver.getWindowHandle(); driver.findElement(By.
	 * xpath("//span[normalize-space()=\"Sign in with Google\"]")).click();
	 * 
	 * Set<String> allwindowHandles = driver.getWindowHandles(); for(String
	 * childwindow: allwindowHandles) { if(!childwindow.equals(ParentWindowID)); By
	 * Ema = By.xpath("//input[@id='identifierId']"); WebDriverWait ent = new
	 * WebDriverWait(driver, Duration.ofMinutes(2)); WebElement enter =
	 * ent.until(ExpectedConditions.elementToBeClickable(Ema));
	 * enter.sendKeys("prudhviraju.buddharaju@gmail.com");
	 * 
	 * driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
	 * 
	 * }
	 */

	/*
	 * Runtime.getRuntime().exec(
	 * "\"C:\\Java_Workspace\\Opp\\src\\test\\resources\\upload.exe\"");
	 * Thread.sleep(10000); driver.findElement(By.
	 * xpath("//button[@class='el-button text-center upload-btn el-button--danger']"
	 * )).click();
	 */

	public void VerifyUpload() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement DocMessage = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='fw-bold fs-24']")));

		Assert.assertEquals(DocMessage.getText(), "Add Recipients");

		System.out.println("File Sucessfully Uploaded Add Recepinets Page Displayed");

	}
}
