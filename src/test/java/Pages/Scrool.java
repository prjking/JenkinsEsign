package Pages;

import java.time.Duration;
import java.util.Set;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scrool {

	WebDriver driver;

	public Scrool(WebDriver driver) {

		this.driver = driver;

	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void sendKeysToElement(By by, CharSequence keysToSend) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(keysToSend);
	}

	private void waitAndClick(Actions actions, WebElement element, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		try {

			WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

			actions.clickAndHold(clickableElement).moveToElement(target).release().build().perform();

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void pagenation() throws Exception {

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		int pageNumber = 1;
		do {
			try {

				waitEle(By.xpath(
						"//div[@class='el-table__fixed-right']//div[normalize-space()='akhil.pachipala@nimbleaccounting.com']/ancestor::tr//button[@title='View Document']"));

				System.out.println("Element found on page ");
			} catch (Exception e) {
				System.out.println("Element not found on page " + pageNumber);
			}

			try {
				WebElement nextPageButton = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-next']")));
				nextPageButton.click();
				pageNumber++;
			} catch (Exception e) {
				System.out.println("Next page button not found or timeout, ending loop.");
				break;
			}
		} while (true);

	}

	public void scrool() throws Exception {

		WebElement element = driver.findElement(By.xpath("(//div[normalize-space()='EMPLOYEE FORM'])[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement CC = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class='name'][normalize-space()='NAME']")));
		WebElement Signer = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(CC).moveToElement(Signer).release().build().perform();
		System.out.println("Rearranged Fields Successfully");
	}

	private static int counter = 0;

	public static String generateUniqueString(WebElement element) {
		String uniqueString = "unique_string_sample" + UUID.randomUUID().toString().substring(0, 5) + counter++;
		element.sendKeys(uniqueString);
		return uniqueString;
	}

	public void ent() throws Exception {

		WebElement titleElement = driver.findElement(By.xpath("//input[@placeholder='Title']"));
		String savedString = generateUniqueString(titleElement);

		Thread.sleep(10000);
		WebElement element1 = driver.findElement(By.xpath("//button[@class=\"el-button el-button--primary\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		Thread.sleep(1000);
		element1.click();

	}

	public void drop() throws InterruptedException {
		Thread.sleep(10000);
		Actions actions1 = new Actions(driver);

		WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		WebElement signElement = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		waitAndClick1(actions1, signElement, targetElement, 10, 10);
		System.out.println("Signature Element Drag and Drop Done");

		WebElement fullNameElement = driver.findElement(By.xpath("//button[@id='fullNameEle']"));
		waitAndClick1(actions1, fullNameElement, targetElement, 50, 50);
		System.out.println("FullName Drag and Drop Done");

		WebElement initialElement = driver.findElement(By.xpath("//button[@id='initialEle']"));
		waitAndClick1(actions1, initialElement, targetElement, 90, 90);
		System.out.println("Initial Drag and Drop Done");

		WebElement dateSingedEle = driver.findElement(By.xpath("//button[@id='dateSingedEle']"));
		waitAndClick1(actions1, initialElement, targetElement, 130, 130);
		System.out.println("Initial Drag and Drop Done");

		WebElement companyEle = driver.findElement(By.xpath("//button[@id='companyEle']"));
		waitAndClick1(actions1, initialElement, targetElement, 170, 170);
		System.out.println("Initial Drag and Drop Done");

		WebElement titleEle = driver.findElement(By.xpath("//button[@id='titleEle']"));
		waitAndClick1(actions1, initialElement, targetElement, 210, 210);
		System.out.println("Initial Drag and Drop Done");

	}

	public void waitAndClick1(Actions actions, WebElement sourceElement, WebElement targetElement, int xOffset,
			int yOffset) {
		actions.clickAndHold(sourceElement).moveToElement(targetElement, xOffset, yOffset).release().build().perform();
	}

	public void AllCombos() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Create Document']"));

		System.out.println("Create document successfull");

	}

	public void BlankDoc() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		waitEle(By.xpath("//img[@src='/img/Blank.1f314c3f.svg']"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		By Element2 = By.xpath("//input[@placeholder='Enter Document name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.sendKeys("test");

		waitEle(By.xpath("//input[@placeholder='Select number of pages']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		waitEle(By.xpath("(//span[normalize-space()='Continue'])[2]"));

		System.out.println("Upload document successfull");

	}

	public void AddRep() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//img[@src='/img/Add Recipients.0f0af0e8.svg']"));

	}

	public void AddSigner() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select contact type']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[12]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Search with Email']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select Signer Type']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		System.out.println("Signer added successfull");

	}

	public void Saveuser() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Save Users']"));

	}

	@SuppressWarnings("unused")
	private void waitAndClick1(Actions actions, WebElement element, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		try {

			WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

			actions.clickAndHold(clickableElement).moveToElement(target).release().build().perform();

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public void Receiverfields() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(1000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		Thread.sleep(10000);
		Actions actions1 = new Actions(driver);

		WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		WebElement signElement = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		waitAndClick1(actions1, signElement, targetElement, 10, 10);
		System.out.println("Signature Element Drag and Drop Done");

		WebElement initialElement = driver.findElement(By.xpath("//button[@id='initialEle']"));
		waitAndClick1(actions1, initialElement, targetElement, 130, 130);
		System.out.println("Initial Drag and Drop Done");

	}

	public void waitAndClick(Actions actions, WebElement sourceElement, WebElement targetElement, int xOffset,
			int yOffset) {
		actions.clickAndHold(sourceElement).moveToElement(targetElement, xOffset, yOffset).release().build().perform();
	}

	public void Senddocument() throws InterruptedException {
		Thread.sleep(1000);

		By ad = By.xpath("//span[normalize-space()='Send Document']");

		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("Element clicked using JS.");
		} catch (Exception e) {

			System.out.println("Element not clickable or not found: ");
		}

		System.out.println("click on send Doc after drag and drop done successfully");
		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By ele = By.xpath("//textarea[@placeholder='Subject']");
		WebElement sen = wait.until(ExpectedConditions.elementToBeClickable(ele));
		sen.sendKeys("Test Sample");

		By ele2 = By.xpath("//textarea[@placeholder='Type your text here']");
		WebElement sen2 = wait.until(ExpectedConditions.elementToBeClickable(ele2));
		sen2.sendKeys("Test Sample");
		Thread.sleep(5000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Send Document']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

	}

	public void Yahoomail() throws Exception {
		Thread.sleep(1000);
		driver.get("https://email.ionos.com/");

		sendKeysToElement(By.xpath("//input[@id='username']"), "*@abccorp.org");

		waitEle(By.xpath("//button[@class='button button--primary button--full-width button--with-loader']"));

		sendKeysToElement(By.xpath("//input[@id='password']"), "Itserve123#");

		waitEle(By.xpath("//button[@class='button button--primary button--full-width button--with-loader']"));

		System.out.println("Signin successfull");

		waitEle(By.xpath("(//div[@class='abs list-view-control toolbar-top-visible']//ul//li[2])[4]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement iframeElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='mail-detail-frame']")));
		driver.switchTo().frame(iframeElement);

		Thread.sleep(10000);

		WebElement copy = driver.findElement(By.xpath("//tbody//span[text()]"));

		Thread.sleep(10000);
		Actions action = new Actions(driver);
		action.doubleClick(copy).perform();
		action.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[normalize-space()='Review & sign']//a")));
		element.click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String windowHandle : allWindows) {
			if (!windowHandle.equals(parentWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		driver.switchTo().defaultContent();
		WebElement paste = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter 6 letters code']")));
		paste.sendKeys(Keys.CONTROL + "v");

		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@class='el-button type-2 w-100 fs-6 el-button--primary is-disabled']")));
		button.click();

		driver.switchTo().window(parentWindow);

		waitEle(By.xpath("//span[@class='el-checkbox__inner']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//span[text()='Continue']"));
		Thread.sleep(10000);

		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[1]"));
		waitEle(By.xpath("//button[@class='el-button finish-drawer-finish el-button--danger el-button--mini']"));

	}

}