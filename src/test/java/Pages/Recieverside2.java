package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Recieverside2 {
	static WebDriver driver;

	public Recieverside2(WebDriver driver) {
		Recieverside2.driver = driver;
	}

	public void waitEle(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void sendKeysToElement(By by, CharSequence keysToSend) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(keysToSend);
	}

	public void AllCombos() throws InterruptedException {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Create Document']"));

		System.out.println("Create document successfull");

	}

	public void BlankDoc() throws InterruptedException {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

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

	public void AddRep() throws InterruptedException {

		Thread.sleep(10000);

		waitEle(By.xpath("//img[@src='/img/Add Recipients.0f0af0e8.svg']"));

	}

	public void AddSigner() throws InterruptedException {

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

	public void Receiverfields() throws InterruptedException {

		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(1000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		Thread.sleep(10000);
		Actions actions1 = new Actions(driver);

		WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		WebElement signElement = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		waitAndClick(actions1, signElement, targetElement, 10, 10);
		System.out.println("Signature Element Drag and Drop Done");

		WebElement initialElement = driver.findElement(By.xpath("//button[@id='initialEle']"));
		waitAndClick(actions1, initialElement, targetElement, 130, 130);
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

	public void ABCaccount() throws Exception {

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

		System.out.println("copied otp successfull");

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[normalize-space()='Review & sign']//a")));
		element.click();

		System.out.println("clicked on review and sign");

		String Parentwindowid1 = driver.getWindowHandle();

		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(10000);
				WebElement paste = wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter 6 letters code']")));
				paste.sendKeys(Keys.CONTROL + "v");

				System.out.println("pasted otp successfull");

				WebElement button = wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//button[@class='el-button type-2 w-100 fs-6 el-button--primary']")));
				button.click();

			}
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//span[@class='el-checkbox__inner']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//span[text()='Continue']"));

		System.out.println("clicked on continue");
		Thread.sleep(10000);

		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[1]"));

		System.out.println("signature successfull");

		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-tooltip tooltip active']"));

		Thread.sleep(10000);

		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[1]"));

		waitEle(By.xpath("//button[@class='el-button finish-drawer-finish el-button--danger el-button--mini']"));

	}

	public void switchEmail() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@class=\"_8ZYZKvxC8bvw1xgQGSkvvA==\"]"));
		waitEle(By.xpath("//div[text()=\"Sign in with a different account\"]"));

	}

	public void documentcompleted(String s) throws Exception {
		Thread.sleep(10000);
		String xpath = String.format("//span[contains(text(), '%s')]", s);
		waitEle(By.xpath(xpath));

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		String Parentwindowid1 = driver.getWindowHandle();
		waitEle(By.xpath("//td//a[normalize-space()='View Document']"));
		Thread.sleep(10000);
		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(10000);
				driver.switchTo().window(Parentwindowid1).close();
				driver.switchTo().window(childwindow);

				Thread.sleep(10000);

				System.out.println("Document completed");
			}
		}
	}

	public void SubDocScenarios(String s) throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()=\"Send Document\"]"));
		System.out.println("click on send Doc after drag and drop done successfully");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By ele = By.xpath("//textarea[@placeholder='Subject']");
		WebElement sen = wait.until(ExpectedConditions.elementToBeClickable(ele));
		sen.sendKeys(s);
	}

	public void clickEmail(String s) throws Exception {
		Thread.sleep(10000);
		try {
			String xpath = String.format("//span[contains(text(), '%s')]", s);
			waitEle(By.xpath(xpath));

		} catch (Exception e) {

		}

	}

	public void prudhvioutlooklogin() throws Exception {

		Thread.sleep(10000);
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
//		switchEmail();
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("//input[@id=\"i0116\"]"), "prudhvib200@outlook.com");
		try {
			waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		} catch (Exception e) {
			waitEle(By.xpath("//input[@id=\"idSIButton9\"]"));
		}

		sendKeysToElement(By.xpath("//input[@placeholder=\"Password\"]"), "Meghana@123");
		Thread.sleep(1000);
		waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		Thread.sleep(10000);
		try {
			waitEle(By.xpath("//button[@id=\"declineButton\"]"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Email login Sucessfull");
	}

	public void Meghanaesignslogin() throws Exception {

		Thread.sleep(10000);
		sendKeysToElement(By.xpath("(//textarea[@class='el-textarea__inner'])[2]"), "Number");

		Thread.sleep(10000);

		sendKeysToElement(By.xpath("(//textarea[@class='el-textarea__inner'])[3]"), "1234567890");

	}

	public static void Javascriptclick(By xpath) throws Exception {
		Thread.sleep(3000);

		WebElement element = driver.findElement(xpath);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	public void reviewSigner() throws Exception {
		Thread.sleep(10000);
		WebElement copy = driver.findElement(By.xpath("//td[@class=\"x_featured-story__content-inner\"]//span"));

		Actions action2 = new Actions(driver);
		action2.doubleClick(copy).build().perform();
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.moveToElement(copy).keyDown(Keys.CONTROL) // Press Ctrl key
				.sendKeys("c") // Press C key
				.keyUp(Keys.CONTROL) // Release Ctrl key
				.build().perform();

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		String Parentwindowid1 = driver.getWindowHandle();
		waitEle(By.xpath("//a[text()=\"Review & sign\"]"));
		Thread.sleep(10000);
		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(1000);
				driver.switchTo().window(Parentwindowid1).close();
				driver.switchTo().window(childwindow);

				Thread.sleep(1000);
				waitEle(By.xpath("//input[@placeholder=\"Enter 6 letters code\"]"));
				WebElement paste = driver.findElement(By.xpath("//input[@placeholder=\"Enter 6 letters code\"]"));

				actions.moveToElement(paste).keyDown(Keys.CONTROL) // Press Ctrl key
						.sendKeys("v") // Press v key
						.keyUp(Keys.CONTROL) // Release Ctrl key
						.build().perform();
				waitEle(By.xpath("//div[@class=\"el-form-item__content\"]//span[text()=\"Submit\"]"));

			}
		}

		try {
			Thread.sleep(10000);
			waitEle(By.xpath("//span[@class=\"el-checkbox__inner\"]"));
			waitEle(By.xpath("//span[text()=\"Continue\"]"));
		} catch (Exception e) {
			Thread.sleep(10000);
//			waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
		}
	}

	public void reviewandSign(String Sign) throws Exception {
		Thread.sleep(10000);
		;
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		
		MethodActions.Javascriptclick(By.xpath("//span[normalize-space()='Edit']"));
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("//input[@placeholder='Enter signature']"), Sign);

		waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));

	}

	public void FinishDocumentRecieverside() {
		waitEle(By.xpath("//span[text()=\"FINISH\"]"));
		System.out.println("Review and Sign successful");

//		waitEle(By.xpath("(//span[normalize-space()='OK'])[3]"));
	}

	public void reviewandSignSignerSplitbox() throws Exception {
		Thread.sleep(10000);
		WebElement copy = driver.findElement(By.xpath("//td[@class=\"x_featured-story__content-inner\"]//span"));

		Actions action2 = new Actions(driver);
		action2.doubleClick(copy).build().perform();
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.moveToElement(copy).keyDown(Keys.CONTROL) // Press Ctrl key
				.sendKeys("c") // Press C key
				.keyUp(Keys.CONTROL) // Release Ctrl key
				.build().perform();

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		String Parentwindowid1 = driver.getWindowHandle();
		waitEle(By.xpath("//a[text()=\"Review & sign\"]"));
		Thread.sleep(10000);
		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(1000);
				driver.switchTo().window(Parentwindowid1).close();
				driver.switchTo().window(childwindow);

				Thread.sleep(1000);
				waitEle(By.xpath("//input[@placeholder=\"Enter 6 letters code\"]"));
				WebElement paste = driver.findElement(By.xpath("//input[@placeholder=\"Enter 6 letters code\"]"));

				actions.moveToElement(paste).keyDown(Keys.CONTROL) // Press Ctrl key
						.sendKeys("v") // Press v key
						.keyUp(Keys.CONTROL) // Release Ctrl key
						.build().perform();
				waitEle(By.xpath("//div[@class=\"el-form-item__content\"]//span[text()=\"Submit\"]"));

			}
		}

		try {
			Thread.sleep(10000);
			waitEle(By.xpath("//span[@class=\"el-checkbox__inner\"]"));
			waitEle(By.xpath("//span[text()=\"Continue\"]"));
		} catch (Exception e) {
			Thread.sleep(10000);
			waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
		}
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		Javascriptclick(By.xpath("//span[normalize-space()='Edit']"));
		sendKeysToElement(By.xpath("//input[@placeholder='Enter signature']"), "Prudvi");

		waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));

		sendKeysToElement(By.xpath("(//div[@class='box']//input)[1]"), "1");

		sendKeysToElement(By.xpath("(//div[@class='box']//input)[2]"), "2");

		sendKeysToElement(By.xpath("(//div[@class='box']//input)[3]"), "3");
		waitEle(By.xpath("//span[text()=\"FINISH\"]"));
		System.out.println("Review and Sign successful");

	}

	public void Approvedocument() throws InterruptedException {

		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button finish-drawer-finish el-button--success el-button--mini']"));
	}

	public void reviewandSignApprover() throws Exception {
		Thread.sleep(10000);
		try {
			WebElement copy = driver.findElement(By.xpath("//td[@class=\"x_featured-story__content-inner\"]//span"));

			Actions action2 = new Actions(driver);
			action2.doubleClick(copy).build().perform();
			Thread.sleep(10000);
			Actions actions = new Actions(driver);
			actions.moveToElement(copy).keyDown(Keys.CONTROL) // Press Ctrl key
					.sendKeys("c") // Press C key
					.keyUp(Keys.CONTROL) // Release Ctrl key
					.build().perform();
		} catch (Exception e) {

		}
		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		String Parentwindowid1 = driver.getWindowHandle();
		Thread.sleep(10000);
		try {
			waitEle(By.xpath("//a[text()=\"Review & Approve\"]"));
		} catch (Exception e) {

		}

		Thread.sleep(10000);
		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(10000);
				driver.switchTo().window(Parentwindowid1).close();
				driver.switchTo().window(childwindow);

				Thread.sleep(10000);
				waitEle(By.xpath("//input[@placeholder=\"Enter 6 letters code\"]"));
				WebElement paste = driver.findElement(By.xpath("//input[@placeholder=\"Enter 6 letters code\"]"));
				Actions actions = new Actions(driver);
				actions.moveToElement(paste).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
				waitEle(By.xpath("//div[@class=\"el-form-item__content\"]//span[text()=\"Submit\"]"));
			}
		}
		try {
			Thread.sleep(10000);
			waitEle(By.xpath("//span[@class=\"el-checkbox__inner\"]"));
			Thread.sleep(5000);
			waitEle(By.xpath("//span[text()=\"Continue\"]"));
		} catch (Exception e) {
			Thread.sleep(10000);
			try {
				waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
			} catch (Exception e2) {
				
			}

		}
	}

	public void reviewandDeclineApprover1() throws Exception {
		Thread.sleep(10000);
		WebElement copy = driver.findElement(By.xpath("//td[@class=\"x_featured-story__content-inner\"]//span"));

		Actions action2 = new Actions(driver);
		action2.doubleClick(copy).build().perform();
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.moveToElement(copy).keyDown(Keys.CONTROL) // Press Ctrl key
				.sendKeys("c") // Press C key
				.keyUp(Keys.CONTROL) // Release Ctrl key
				.build().perform();

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		String Parentwindowid1 = driver.getWindowHandle();
		waitEle(By.xpath("//a[text()=\"Review & Approve\"]"));
		Thread.sleep(10000);
		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(10000);
				driver.switchTo().window(Parentwindowid1).close();
				driver.switchTo().window(childwindow);

				Thread.sleep(10000);
				waitEle(By.xpath("//input[@placeholder=\"Enter 6 letters code\"]"));
				WebElement paste = driver.findElement(By.xpath("//input[@placeholder=\"Enter 6 letters code\"]"));

				actions.moveToElement(paste).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
				waitEle(By.xpath("//div[@class=\"el-form-item__content\"]//span[text()=\"Submit\"]"));
			}
		}
		try {
			Thread.sleep(10000);
			waitEle(By.xpath("//span[@class=\"el-checkbox__inner\"]"));
			waitEle(By.xpath("//span[text()=\"Continue\"]"));
		} catch (Exception e) {
			Thread.sleep(10000);
			waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
		}
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		Javascriptclick(By.xpath("//span[normalize-space()='Edit']"));
		sendKeysToElement(By.xpath("//input[@placeholder='Enter signature']"), "Prj");

		waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));

	}

	public void Declinedocument() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("(//button[@class='el-button el-button--danger el-button--mini'])[1]"));

		sendKeysToElement(By.xpath("//textarea[@placeholder='Reason for Decline']"), "No reasons");

		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[2]"));

		System.out.println("Decline document is successful");
	}
}
