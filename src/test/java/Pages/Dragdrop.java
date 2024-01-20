package Pages;

import java.awt.Desktop.Action;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

	public void EssentialFields() throws Exception {
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		// Sign
		WebElement Sign = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='signatureEle']")));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
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
		actions.clickAndHold(Intial).moveToElement(Target).release().build().perform();
		Thread.sleep(1000);
		actions.clickAndHold(fullName).moveToElement(Target).release().build().perform();
		Thread.sleep(1000);
		actions.clickAndHold(dateSinged).moveToElement(Target).release().build().perform();
		Thread.sleep(1000);
		actions.clickAndHold(company).moveToElement(Target).release().build().perform();
		Thread.sleep(1000);
		actions.clickAndHold(title).moveToElement(Target).release().build().perform();
		Thread.sleep(1000);
		actions.clickAndHold(singleLineText).moveToElement(Target).release().build().perform();
		Thread.sleep(1000);
		actions.clickAndHold(checkbox).moveToElement(Target).release().build().perform();
		Thread.sleep(1000);
		actions.clickAndHold(address).moveToElement(Target).release().build().perform();

		/*
		 * Thread.sleep(3000); WebElement Doubleclick =
		 * driver.findElement(By.xpath("//p[normalize-space()='Signature']")); Actions
		 * action = new Actions(driver);
		 * action.doubleClick(Doubleclick).build().perform(); Set<String> windowHandles
		 * = driver.getWindowHandles(); for (String handle : windowHandles) {
		 * driver.switchTo().window(handle); } Thread.sleep(10000);
		 * driver.findElement(By.
		 * xpath("//form[@class='el-form el-form--label-top']//input[@placeholder='Select']//li[@class='el-select-dropdown__item'][1]"
		 * )).click();
		 */

	}

	public void Contentfields() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		// Sign
		WebElement mySignatureEle = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='mySignatureEle']")));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(mySignatureEle).moveToElement(Target).release().build().perform();

		Thread.sleep(3000);
		WebElement Doubleclick = driver.findElement(By.xpath("//img[@class='my-signature']"));
		Actions action = new Actions(driver);
		action.doubleClick(Doubleclick).build().perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
		Thread.sleep(10000);
		// driver.findElement(By.xpath("//input[@placeholder='Select']")).click();
		// driver.findElement(By.xpath("//input//ul//li//span[normalize-space()='Segoe
		// Script']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter signature']")).sendKeys("Prj");
		driver.findElement(By.xpath("//div[@id='pane-letter']//button[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(
				"//div[@aria-label='Field Properties']//div[@class='el-dialog__footer']//span[contains(text(),'Save')]"))
				.click();

	}

	public void Draw() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement mySignatureEle = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='mySignatureEle']")));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(mySignatureEle).moveToElement(Target).release().build().perform();

		Thread.sleep(3000);
		WebElement Doubleclick = driver.findElement(By.xpath("//img[@class='my-signature']"));
		Actions action = new Actions(driver);
		action.doubleClick(Doubleclick).build().perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("tab-drawer")).click();

		Thread.sleep(10000);
		Actions act = new Actions(driver);
		Thread.sleep(10000);
		act.clickAndHold(driver.findElement(By.xpath("//div[@id='signature']//canvas")))
				.moveToElement(driver.findElement(By.xpath("//div[@id='signature']//canvas")), 20, -50)
				.moveByOffset(50, 50).moveByOffset(80, -50).moveByOffset(100, 50).release().build().perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath(
				"//div[@aria-label='Field Properties']//div[@class='el-dialog__footer']//span[contains(text(),'Save')]"))
				.click();
		// headingEle
		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement headingEle = wait11.until(ExpectedConditions.presenceOfElementLocated(By.id("headingEle")));
		Actions actions1 = new Actions(driver);
		actions1.clickAndHold(headingEle).moveToElement(Target).release().build().perform();
		Thread.sleep(100000);
		/*
		 * WebElement Doubleclick1 =
		 * driver.findElement(By.xpath("//div[contains(text(),'Heading 1')]")); Actions
		 * action1 = new Actions(driver);
		 * action1.doubleClick(Doubleclick1).build().perform(); Set<String>
		 * windowHandles1 = driver.getWindowHandles(); for (String handle :
		 * windowHandles1) { driver.switchTo().window(handle); } Thread.sleep(10000);
		 * driver.findElement(By.xpath(
		 * "//div[@class='el-select']//input[@placeholder='Select']")).click();
		 * driver.findElement(By.xpath("//ul//li//span[normalize-space()='h4']")).click(
		 * ); driver.findElement(By.xpath(
		 * "//div[@class='el-textarea']//textarea[@class='el-textarea__inner']")).
		 * sendKeys("Test"); driver.findElement(By.
		 * xpath("//div[@class='el-dialog__wrapper fields-dialog']//button[2]")).click()
		 * ;
		 */
		// paragraphEle
		/*
		 * WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		 * 
		 * WebElement paragraphEle = wait2
		 * .until(ExpectedConditions.presenceOfElementLocated(By.id("paragraphEle")));
		 * Actions actions2 = new Actions(driver);
		 * actions2.clickAndHold(paragraphEle).moveToElement(Target).release().build().
		 * perform(); Thread.sleep(10000); WebElement Doubleclick3 =
		 * driver.findElement(By.xpath("//div[contains(text(),' Paragraph 1')]"));
		 * Actions action2 = new Actions(driver);
		 * action2.doubleClick(Doubleclick3).build().perform(); Set<String>
		 * windowHandles2 = driver.getWindowHandles(); for (String handle :
		 * windowHandles2) { driver.switchTo().window(handle); } Thread.sleep(100000);
		 * driver.findElement(By.xpath(
		 * "//div[@class='el-select']//input[@placeholder='Select']")).click();
		 * driver.findElement(By.xpath("//ul//li//span[normalize-space()='h4']")).click(
		 * ); driver.findElement(By.xpath(
		 * "//div[@class='el-textarea']//textarea[@class='el-textarea__inner']")).
		 * sendKeys("Test Sample"); driver.findElement(By.
		 * xpath("//div[@class='el-dialog__wrapper fields-dialog']//button[2]")).click()
		 * ;
		 * 
		 */ // image

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

		By send = By.xpath("//input[@placeholder='Select a Recipient']");
		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement cli = wait11.until(ExpectedConditions.elementToBeClickable(send));
		cli.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//ul//li//span[normalize-space()='Receiver-1']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Send Document']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		for (String handle : windowHandles3) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Send document']")).click();

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
