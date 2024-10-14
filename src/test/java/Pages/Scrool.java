package Pages;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
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

	public void autofill(boolean isYes) {
		driver.get("https://dev.esigns.io/profilesettings/application-settings");
		if (isYes) {

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));

			WebElement yesElement = wait1.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//span[@class='el-checkbox__inner'])[2]")));
			yesElement.click();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yesElement);
			System.out.println("With Autofill");
		}

		else {

			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(1));

			WebElement noElement = wait2.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("(//div[@class='mb-1'])[1]//label//span[@class='el-checkbox__input is-checked']")));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", noElement);

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", noElement);

			System.out.println("Without Autofill");

		}
	}

	public void Signinram() throws InterruptedException {
		Thread.sleep(10000);
//		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
//				.sendKeys("N180959@rguktn.ac.in");
//		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Ramya@1234");
//		driver.findElement(By.xpath("//span[normalize-space()='Log In']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("ramya.sibbala@nimbleaccounting.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Ramyasri@123");
		driver.findElement(By.xpath("//button[@class='el-button type-2 w-100 fs-6 el-button--danger']")).click();
		Thread.sleep(10000);

	}

	public void Signinjp() throws InterruptedException {
		Thread.sleep(10000);
//		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
//				.sendKeys("N180959@rguktn.ac.in");
//		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Ramya@1234");
//		driver.findElement(By.xpath("//span[normalize-space()='Log In']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("jeevithapatnana06@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Nimble#20233");
		driver.findElement(By.xpath("//button[@class='el-button type-2 w-100 fs-6 el-button--danger']")).click();
		Thread.sleep(10000);

	}

	public void Addformbuilder() throws Exception {
		Thread.sleep(10000);
		driver.get("https://nsui.esigns.io/formBuilders/add");

		// waitEle(By.xpath("//span[normalize-space()='Add Form Builder']"));

		sendKeysToElement(By.xpath("//input[@placeholder='Form builder name']"), MethodActions.generateUniqueString());

		waitEle(By.xpath("//input[@placeholder='Select user type']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Anyone']"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select Group']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='QA']"));

		waitEle(By.xpath("//i[@class='el-select__caret el-input__icon el-icon-arrow-up is-reverse']"));

		waitEle(By.xpath("//span[normalize-space()='Save and Next']"));

		waitEle(By.xpath("(//div[normalize-space()='Contact details'])[1]"));

		waitEle(By.xpath("(//div[normalize-space()='templateBasicFeilds'])[1]"));

		waitEle(By.xpath("//span[normalize-space()='Save Steps']"));

		waitEle(By.xpath("//span[normalize-space()='Approval Settings']"));

		waitEle(By.xpath("(//span[@class='el-checkbox__input'])[3]"));

		waitEle(By.xpath("//input[@placeholder='Select user type']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Application Users']"));

		waitEle(By.xpath("//input[@placeholder='Select application user type']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		Thread.sleep(1000);

		waitEle(By.xpath("//input[@placeholder='Select preferred user']"));

		Thread.sleep(1000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='jeevitha.patnana@nimbleaccounting.com']"));

		Thread.sleep(1000);

		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//i[@class='el-select__caret el-input__icon el-icon-arrow-up is-reverse']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		waitEle(By.xpath("//span[normalize-space()='Save Form builder']"));

	}

	public void ViewFormbuilder() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement actionsElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[@class='el-table el-table--fit el-table--scrollable-x el-table--enable-row-transition']//tr[1]//span[text()=' Actions '])[1]")));
		actionsElement.click();

		WebElement dropdownLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@x-placement]//a[1]")));
		dropdownLink.click();

		Thread.sleep(10000);
		WebElement copyElement = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='el-icon-copy-document']")));
		copyElement.click();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("var input = document.createElement('input');" + "document.body.appendChild(input);"
				+ "input.value = window.getSelection().toString();" + "input.select();"
				+ "document.execCommand('copy');" + "document.body.removeChild(input);");

		String clipboardData = (String) js.executeScript(
				"return navigator.clipboard.readText().then(text => text).catch(err => 'Clipboard access denied');");

		System.out.println("Copied data: " + clipboardData);

		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(5000);
		driver.get(clipboardData);

	}

	public void Addmail(String F, String L, String s) throws Exception {

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter mail']"), s);

		MethodActions.waitEle(By.xpath("//button[@class='el-button type-2 w-100 fs-6 el-button--primary']"));
		try {
			Thread.sleep(10000);
			MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter first name']"), F);

			MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter last name']"), L);

			MethodActions.waitEle(By.xpath("//button[@class='el-button type-2 w-100 fs-6 el-button--primary']"));
		} catch (Exception e) {
			Thread.sleep(10000);
		}

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Continue']"));
	}

	public void DatatoFormbuilder() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Next'])[2]"));

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Single line text']"), "Ramya");

		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Multiline']"),
				"This is for testing purpose");

		Thread.sleep(1000);
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));

		Thread.sleep(1000);

		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[normalize-space()='1']"));

		Thread.sleep(1000);

		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[4]"));

		Thread.sleep(1000);

		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[normalize-space()='list']"));

		Thread.sleep(1000);

		MethodActions.waitEle(By.xpath("//input[@placeholder='FixedTime']"));

		Thread.sleep(1000);

		MethodActions.waitEle(By.xpath("//div[@x-placement]//div[normalize-space()='01:30']"));

//		waitEle(By.xpath("(//input[@placeholder='Start date'])[2]"));

		Thread.sleep(1000);

		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='A']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

	}

	public void Finishformbuilder() throws Exception {

		Thread.sleep(1000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Finish']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

	}

	public void Reviewandapproveformbuilder() throws Exception {

		String Parentwindowid1 = driver.getWindowHandle();

//		String parentWindowHandle = driver.getWindowHandle();
		MethodActions.waitEle(By.xpath("//a[text()='Review & Approve']"));

		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(1000);
				driver.switchTo().window(Parentwindowid1).close();

				driver.switchTo().window(childwindow);
				Thread.sleep(2000);

				String currentWindowHandle = driver.getWindowHandle();

				Set<String> allWindowHandles = driver.getWindowHandles();

				driver.close();

				allWindowHandles.remove(currentWindowHandle);

				for (String windowHandle : allWindowHandles) {

					driver.switchTo().window(windowHandle);
					break;
				}

				// driver.close();
				// driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
//
//				List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
//
//				if (windowHandles.size() == 3) {
//
//					String centerWindowHandle = windowHandles.get(1);
//					driver.switchTo().window(centerWindowHandle);
//
//				} else {
//
//				}

//				try {
//					
//					((JavascriptExecutor) driver).executeScript("window.open();");
//					Set<String> windowHandles = driver.getWindowHandles();
//					String newTabHandle = windowHandles.stream().skip(windowHandles.size() - 1)
//							.findFirst().orElseThrow(() -> new RuntimeException("No new tab found"));
//
//					driver.switchTo().window(newTabHandle);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}

				Thread.sleep(10000);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

				WebElement element = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Next']")));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

				MethodActions.waitEle(By.xpath("//span[normalize-space()='Approve']"));

				MethodActions.waitEle(By.xpath("//span[normalize-space()='OK']"));
//		driver.get("https://nsui.esigns.io/public/fb/formbuilder-1/669f5168da989782b1d5cf22/669f518fda989782b1d5d169/status/completed");

			}
		}
	}

	public void prudhvioutlooklogin() throws Exception {

		Thread.sleep(10000);
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
//			switchEmail();
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("//input[@id=\"i0116\"]"), "prudhvib200@outlook.com");
		try {
			waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		} catch (Exception e) {
			waitEle(By.xpath("//input[@id=\"idSIButton9\"]"));
		}

		sendKeysToElement(By.xpath("//input[@placeholder=\"Password\"]"), "Meghana@123");
		waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		waitEle(By.xpath("//button[@id=\"declineButton\"]"));
	}

	public void clickEmail(String s) throws Exception {
		Thread.sleep(10000);
		String xpath = String.format("(//span[contains(text(), '%s')])[1]", s);
		waitEle(By.xpath(xpath));
	}

	public void FineDueNotificationEntityActions() throws Exception {

		driver.get("https://nsui.esigns.io/entity/66b1f53c47ad681aec31f308/edit?key=76981");
		SigninNSUI("jeevithapatnana06@gmail.com", "Nimble#2023");
		Thread.sleep(10000);
		// ClickEntityAction("Fine");
		EntityWorkflowConditionStep("DueNotification", "Template-Fine", "Overdue", "Notification",
				"jeevithapatnana06@gmail.com", "Due-Notification", "@");
	}

	public void SigninNSUI(String Email, String Password) throws Exception {

		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']")).sendKeys(Email);
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys(Password);
		waitEle(By.xpath("//span[text()=\"Log In\"]"));
		Thread.sleep(10000);

	}

	public void ClickEntityAction(String EntityName) throws Exception {
		Thread.sleep(20000);
		String xpath = String.format(
				"//div[@class='el-table__fixed']//div[contains(text(),'%s')]/ancestor::tr//span[normalize-space()=\"Actions\"]",
				EntityName);
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(xpath));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		waitEle(By.xpath("//ul[@x-placement] //li[normalize-space()='Edit']"));
		System.out.println("Click on Edit Action Done successfully");
	}

	public void EntityWorkflowConditionStep(String Name, String WhenPoint, String Condition, String ActionType,
			String Email, String Subject, String Text) throws Exception {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@class=\"el-step__main\"]//div[contains(text(), 'Actions')]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Add new action']"));
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Action Name']"), Name);
		Thread.sleep(10000);
		waitEle(By.xpath("//button[@class=\"btn btn-outline-primary btn-sm\"]//i"));
		Thread.sleep(1000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"When point\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		String SelectField1 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", WhenPoint);
		waitEle(By.xpath(SelectField1));
		System.out.println("point Select done Successfully");
		waitEle(By.xpath("//span[normalize-space()='Condition step']"));
		Thread.sleep(1000);
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Condition\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		String SelectField2 = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", Condition);
		waitEle(By.xpath(SelectField2));
		System.out.println("Condition Select done Successfully");
		Thread.sleep(1000);
		waitEle(By.xpath("//button[@class=\"el-button left-add el-button--default el-button--mini is-circle\"]"));
		Thread.sleep(1000);
		WebElement element2 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Action type\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element2);

		String SelectField3 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", ActionType);
		waitEle(By.xpath(SelectField3));
		System.out.println("Action Select done Successfully");
		Thread.sleep(3000);
		waitEle(By.xpath("//button[@class=\"el-button email-config-button el-button--default\"]"));
		Thread.sleep(2000);
		waitEle(By.xpath("//div[@class=\"el-col el-col-12\"]//p[text()=' Email Subject ']"));
		System.out.println("Email Select done Successfully");
		sendKeysToElement(By.xpath("//textarea[@placeholder=\"Enter Subject\"]"), Subject);
		Thread.sleep(5000);
		WebElement element3 = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"User Types Emails\"]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element3);

		String SelectField4 = String.format("//div[@x-placement]//ul//li//span[contains(text(), '%s')]", Email);
		waitEle(By.xpath(SelectField4));
//		Thread.sleep(2000);
//		waitEle(By.xpath("//div[@class=\"el-col el-col-12\"]//p[text()=' Email Subject ']"));
//		System.out.println("Email Select done Successfully");
//		sendKeysToElement(By.xpath("//textarea[@placeholder=\"Enter Subject\"]"), Subject);
		WebElement iframeElement = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframeElement);
		Thread.sleep(3000);
		waitEle(By.xpath("//body/p"));
		sendKeysToElement(By.xpath("//body/p"), Text);
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).perform(); // Move down to the first item
		actions.sendKeys(Keys.ARROW_DOWN).perform(); // Move to the second item (if needed)
		actions.sendKeys(Keys.ARROW_DOWN).perform();
		actions.sendKeys(Keys.ENTER).perform();
//		WebElement element4 = wait.until(
//		ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"User Types Email\"]")));
//	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element4);
//		WebElement fieldElement = driver.findElement(By.xpath("//ul[contains(@class,'cke_autocomplete_panel')]//li[contains(@role, 'option')]//strong[normalize-space()='Fine - Fine Calculation']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fieldElement);
//		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(60));
//		WebElement clickableElement = wait1.until(ExpectedConditions.elementToBeClickable(fieldElement));
//		clickableElement.click();
		// waitEle(By.xpath("//li//strong[normalize-space()='Fine - Fine
		// Calculation']"));
		// waitEle(SelectField5);
		System.out.println("field Select done Successfully");
		// ul[@id="cke_83"]//li[@id="cke_1727"]
		Thread.sleep(10000);
//		WebElement scrollbar = driver.findElement(By.xpath("//div[@class=\"scrollable-container\"]"));
//
//		Actions actions1 = new Actions(driver);
//
//		actions1.clickAndHold(scrollbar).perform();
//
//		int offset = 100;
//		actions.moveByOffset(0, offset).perform();
//
//		actions.release().perform();
//		System.out.println("ScrollDown done successfully");
		driver.switchTo().defaultContent();

		WebElement save = driver
				.findElement(By.xpath("//div[@class=\"dialog-footer\"]//span[normalize-space()='Save']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
		save.click();

		// waitEle(By.xpath("//div[@class=\"dialog-footer\"]//span[normalize-space()='Save']"));

		System.out.println("Email configuration done successfully");
		Thread.sleep(3000);
		waitEle(By.xpath("//span[normalize-space()='Done']"));

	}
//	private static Map<String, Object> getClipBoardSettingsMap(int settingValue) throws JsonProcessingException {
//		Map<String, Object> map = new HashMap<>();
//		map.put("last_modified", String.valueOf(System.currentTimeMillis()));
//		map.put("setting", settingValue);
//
//		Map<String, Object> cbPreference = new HashMap<>();
//		cbPreference.put("[*.],*", map);
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		String json = objectMapper.writeValueAsString(cbPreference);
//		Logger.info("clipboardSettingJson: " + json);
//
//		return cbPreference;
//	}

//		  WebElement urlElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='el-icon-copy-document']")));
//	        
//	      
//	        urlElement.click();
//	        
//	        
//	        Thread.sleep(5000);
//
//	       
//	        driver.switchTo().newWindow(WindowType.TAB);
//	        Thread.sleep(5000);
//	       
//	        JavascriptExecutor js = (JavascriptExecutor) driver;
//	        String script = "navigator.clipboard.readText().then(text => { if (text) window.location.href = text; });";
//	        js.executeScript(script);
//
//	       
//	        Thread.sleep(5000); // Adjust as needed

//		WebElement copyElement = wait
//				.until(ExpectedConditions.elementToBeClickable(By.xpath("//i[@class='el-icon-copy-document']")));
//
//		copyElement.click();
//
//		
//		Thread.sleep(2000); 
//
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String clipboardData = (String) js.executeScript("return navigator.clipboard.readText().then(text => text);");
//
//		
//		System.out.println("Copied data: " + clipboardData);

}
