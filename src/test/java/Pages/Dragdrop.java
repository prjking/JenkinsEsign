package Pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dragdrop {
	WebDriver driver;

	public Dragdrop(WebDriver driver) {
		this.driver = driver;

	}

	private void waitAndClick(Actions actions, WebElement element, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		try {

			WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

			actions.clickAndHold(clickableElement).moveToElement(target).release().build().perform();

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void waitEle(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void EssentialFields() throws Exception {
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		// Sign
		WebElement Sign = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='signatureEle']")));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		System.out.println("Signature Element Drag and Drop Done");

		// initial
		WebElement Intial = driver.findElement(By.xpath("//button[@id='initialEle']"));
		// fullNameEle
		WebElement fullName = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		// dateSingedEle
		WebElement dateSinged = driver.findElement(By.xpath("//button[@id='dateSingedEle']"));
		// companyEle
		WebElement company = driver.findElement(By.xpath("//button[@id='companyEle']"));
		// titleEle
		WebElement title = driver.findElement(By.xpath("//button[@id='titleEle']"));
		// singleLineTextEle
		WebElement singleLineText = driver.findElement(By.xpath("//button[@id='singleLineTextEle']"));
		// checkboxEle
		WebElement checkbox = driver.findElement(By.xpath("//button[@id='checkboxEle']"));
		// addressEle
		WebElement address = driver.findElement(By.xpath("//button[@id='addressEle']"));

		Actions actions = new Actions(driver);

		waitAndClick(actions, Intial, Target);
		System.out.println("Intial Element Drag and Drop Done");

		waitAndClick(actions, fullName, Target);
		System.out.println("Fullname Element Drag and Drop Done");

		waitAndClick(actions, dateSinged, Target);
		System.out.println("dateSinged Element Drag and Drop Done");

		waitAndClick(actions, company, Target);
		System.out.println("company Element Drag and Drop Done");

		waitAndClick(actions, title, Target);
		System.out.println("Title Element Drag and Drop Done");

		waitAndClick(actions, singleLineText, Target);
		System.out.println("singleLineText Element Drag and Drop Done");

		waitAndClick(actions, checkbox, Target);
		System.out.println("checkbox Element Drag and Drop Done");

		waitAndClick(actions, address, Target);
		System.out.println("Intial Element Drag and Drop Done");
	}

	public void Contentfields() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement mySignatureEle = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='mySignatureEle']")));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		Actions actions = new Actions(driver);
		waitAndClick(actions, mySignatureEle, Target);
		System.out.println("mySignatureEle Element Drag and Drop Done");

		Thread.sleep(3000);

		WebElement Doubleclick = driver.findElement(By.xpath("//img[@class='my-signature']"));
		Actions action = new Actions(driver);
		action.doubleClick(Doubleclick).build().perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		try {
			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Edit']"));
		driver.findElement(By.xpath("//input[@placeholder='Enter signature']")).sendKeys("Prj");

		waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
		waitEle(By.xpath(
				"//div[@aria-label='Field Properties']//div[@class='el-dialog__footer']//span[contains(text(),'Save')]"));

		System.out.println("mySignatureEle Element opened With Double Click and Entered New Sign Data Successfully");
	}

	public void Draw() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement mySignatureEle = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='mySignatureEle']")));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		Actions actions = new Actions(driver);

		waitAndClick(actions, mySignatureEle, Target);
		System.out.println("mySignatureEle Element Drag and Drop Done");

		Thread.sleep(3000);
		WebElement Doubleclick = driver.findElement(By.xpath("//img[@class='my-signature']"));
		Actions action = new Actions(driver);
		action.doubleClick(Doubleclick).build().perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		Thread.sleep(10000);
		try {
			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Edit']"));

		waitEle(By.id("tab-drawer"));

		Actions act = new Actions(driver);
		Thread.sleep(10000);
		act.clickAndHold(driver.findElement(By.xpath("//div[@id='signature']//canvas")))
				.moveToElement(driver.findElement(By.xpath("//div[@id='signature']//canvas")), 20, -50)
				.moveByOffset(50, 50).moveByOffset(80, -50).moveByOffset(100, 50).release().build().perform();

		waitEle(By.xpath(
				"//div[@aria-label='Field Properties']//div[@class='el-dialog__footer']//span[contains(text(),'Save')]"));

		WebDriverWait waitHeading = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement headingEle = waitHeading.until(ExpectedConditions.presenceOfElementLocated(By.id("headingEle")));
		Actions actionsHeading = new Actions(driver);
		actionsHeading.clickAndHold(headingEle).moveToElement(Target).release().build().perform();
		Thread.sleep(10000);

		System.out.println("Signature drawn Successfully");
	}

	public void image() throws InterruptedException, IOException {
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement tableEle = wait3.until(ExpectedConditions.presenceOfElementLocated(By.id("tableEle")));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		Actions actions3 = new Actions(driver);
		actions3.clickAndHold(tableEle).moveToElement(Target).release().build().perform();
		Thread.sleep(10000);

		WebElement Doubleclick = driver.findElement(By.xpath("//i[@class='el-icon-edit']"));
		Actions action = new Actions(driver);
		action.doubleClick(Doubleclick).build().perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		driver.findElement(By.className("ankaCropper__selectButton")).click();
		Runtime.getRuntime().exec("\"C:\\Work Space\\EsignTest\\src\\test\\resources\\image.exe\"");
		Thread.sleep(10000);
		WebElement Doubleclick2 = driver.findElement(By.xpath("//*[@id=\"drag-template-background\"]//div[9]//canvas"));
		Actions action2 = new Actions(driver);
		action2.doubleClick(Doubleclick2).build().perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath(
				"//div[@aria-label='Field Properties']//div[@class='el-dialog__footer']//span[contains(text(),'Save')]"))
				.click();

	}

	public void send() throws InterruptedException, IOException {

		// waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		// waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[3]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement Sign = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='signatureEle']")));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(Sign).moveToElement(Target).release().build().perform();

		waitEle(By.xpath("//span[normalize-space()='Send Document']"));
		Set<String> windowHandles3 = driver.getWindowHandles();
		for (String handle : windowHandles3) {
			driver.switchTo().window(handle);
		}

		waitEle(By.xpath("//span[normalize-space()='Send document']"));

	}

	/*
	 * public void Daterange() throws Exception { Thread.sleep(10000); WebDriverWait
	 * wait3 = new WebDriverWait(driver, Duration.ofMinutes(2));
	 *
	 * WebElement tableEle =
	 * wait3.until(ExpectedConditions.presenceOfElementLocated(By.
	 * xpath("//div[contains(text(),'Date Time Range')]"))); WebElement Target =
	 * driver.findElement(By.xpath("//*[@id=\"svg\"]")); Actions actions3 = new
	 * Actions(driver);
	 * actions3.clickAndHold(tableEle).moveToElement(Target).release().build().
	 * perform(); Thread.sleep(10000); WebElement Doubleclick =
	 * driver.findElement(By.
	 * xpath("//i[@class='el-input__icon el-range__icon el-icon-time']")); Actions
	 * action = new Actions(driver);
	 * action.doubleClick(Doubleclick).build().perform(); Set<String> windowHandles
	 * = driver.getWindowHandles(); for (String handle : windowHandles) {
	 * driver.switchTo().window(handle); } Thread.sleep(10000);
	 * driver.findElement(By.xpath("//td[@class='available today']")).click();
	 * Thread.sleep(10000);
	 * driver.findElement(By.xpath("//div[3]/table//tr[5]/td[3]/div/span")).click();
	 * Thread.sleep(20000); driver.findElement(By.
	 * xpath("//button[@class='el-button el-picker-panel__link-btn el-button--default el-button--mini is-disabled is-plain']//span[contains(text(),'OK')]"
	 * )).click();
	 *
	 *
	 * }
	 */
}
