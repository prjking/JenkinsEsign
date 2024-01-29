package Pages;

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
        Thread.sleep(10000);
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
					WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='consent-iframe']"));
					driver.switchTo().frame(iframeElement);
					By Element1 = By.id("accept_all_cookies_button");
					WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofSeconds(30));
					WebElement canc1 = hold1.until(ExpectedConditions.elementToBeClickable(Element1));
					canc1.click();
		
					
		
						By ad = By.xpath("//span[normalize-space()='Continue']");
						WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
						WebElement add = wait.until(ExpectedConditions.elementToBeClickable(ad));

						JavascriptExecutor executor = (JavascriptExecutor) driver;
						executor.executeScript("arguments[0].click();", add);
 
 
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
		
	

	public void uploadGdrive() throws Exception {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//img[@placeholder=\"top-start\"]")).click();
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		String Parentwindowid = driver.getWindowHandle();
		driver.findElement(By.xpath("//span[normalize-space()=\"Sign in with Google\"]")).click();
		Set<String> allwindowhandles = driver.getWindowHandles();
		for (String childwindow : allwindowhandles) {
			if (!childwindow.endsWith(Parentwindowid)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(10000);
				driver.findElement(By.xpath("//input[@id=\"identifierId\"]")).sendKeys("n180894@rguktn.ac.in");

				driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]")).click();
				Thread.sleep(10000);
				Set<String> windowHandles1 = driver.getWindowHandles();
				for (String handle : windowHandles1) {
					driver.switchTo().window(handle);

				}
				driver.findElement(By.xpath("//input[@name=\"Passwd\"]")).sendKeys("meghu@123");
				driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]")).click();
				Thread.sleep(10000);
				Set<String> windowHandles11 = driver.getWindowHandles();
				for (String handle : windowHandles11) {
					driver.switchTo().window(handle);

				}
				Thread.sleep(10000);
				driver.findElement(By.xpath("//span[normalize-space()=\"Allow\"]")).click();
				Thread.sleep(10000);
				Set<String> windowHandles111 = driver.getWindowHandles();
				for (String handle : windowHandles111) {
					driver.switchTo().window(handle);

				}
				driver.findElement(By.xpath("//span[normalize-space()=\"N180894-resume.pdf\"]")).click();
				Thread.sleep(10000);
				Set<String> windowHandles2 = driver.getWindowHandles();
				for (String handle : windowHandles2) {
					driver.switchTo().window(handle);

				}
				driver.findElement(By.xpath("//span[@class=\"fsp-button fsp-button--primary fsp-button-upload\"]"))
						.click();

			}
		}
	}
	
	public void oneDriveupload() throws Exception {
		// driver.findElement(By.xpath("//img[@src='/img/onedrive.cc38d634.svg']"));
		Thread.sleep(10000);
		By Onedrive = By.xpath("//img[@src='/img/onedrive.cc38d634.svg']");
		WebDriverWait file = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement Upload = file.until(ExpectedConditions.elementToBeClickable(Onedrive));
		Upload.click();
		Thread.sleep(3000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(5000);
		String Parentwindowid = driver.getWindowHandle();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[normalize-space()='Connect OneDrive']")).click();
		Thread.sleep(5000);
 
		Set<String> allwindowhandles = driver.getWindowHandles();
		for (String childwindow : allwindowhandles) {
			if (!childwindow.endsWith(Parentwindowid)) {
				driver.switchTo().window(childwindow);
				driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("bsrv.prudhviraju@outlook.com");
				driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
				Thread.sleep(10000);
				By password = By.xpath("//input[@id='i0118']");
				WebDriverWait file1 = new WebDriverWait(driver, Duration.ofMinutes(3));
				WebElement Upload1 = file1.until(ExpectedConditions.elementToBeClickable(password));
				Upload1.sendKeys("Prjking@99");
				driver.findElement(By.xpath("//input[@id='idSIButton9']")).click();
				By password1 = By.xpath("//input[@id='idSIButton9']");
				WebDriverWait file2 = new WebDriverWait(driver, Duration.ofMinutes(3));
				WebElement Upload2 = file2.until(ExpectedConditions.elementToBeClickable(password1));
				Upload2.click();
				Thread.sleep(5000);
				Set<String> windowHandles1 = driver.getWindowHandles();
				for (String handle :windowHandles1) { driver.switchTo().window(handle);
				}
				Thread.sleep(5000);
				driver.findElement(By.xpath("//span//span[normalize-space()='Document 1.docx']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//span[@title='Upload']")).click();
				Thread.sleep(10000);
				//driver.findElement(By.xpath(""))
				driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
			}
		}
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
