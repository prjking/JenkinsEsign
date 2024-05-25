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
import org.testng.Assert;

public class RecevierSide1 {
	static WebDriver driver;

	public RecevierSide1(WebDriver driver) {
		this.driver = driver;

	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void waitAndClick(Actions actions, WebElement sourceElement, WebElement targetElement, int xOffset,
			int yOffset) {
		actions.clickAndHold(sourceElement).moveToElement(targetElement, xOffset, yOffset).release().build().perform();
	}

	public void sendKeysToElement(By by, CharSequence keysToSend) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(keysToSend);
	}

	public static void Javascriptclick(By xpath) throws Exception {
		Thread.sleep(3000);

		WebElement element = driver.findElement(xpath);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	public void CheckRecevierSide() throws Exception {
		driver.get(
				"https://dev.esigns.io/emp-documents/preview/65c0a9b8aa64cfe3cd633374/pp/vp/659fc16a24885c89f0305d01?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbXBfZG9jdW1lbnRfaWQiOiI2NWMwYTliOGFhNjRjZmUzY2Q2MzMzNzQiLCJwYXNzY29kZSI6Im5kcnY2NiIsIndvcmtmbG93X2lkIjpudWxsLCJpYXQiOjE3MDcxMjUxNzcsImV4cCI6MTcwNzI5Nzk3N30.h6h0lc9gMNV8FYpDcayyMQbRhUaSP3R0HXqIxD_zWFw");
		By Element = By.xpath("//div//input[@placeholder='Enter 6 letters code']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));
		canc.sendKeys("ndrv66");
		waitEle(By.xpath("//div[@class='el-form-item__content']//span[normalize-space()='Submit']"));
		try {
			waitEle(By.xpath("//span[@class='el-checkbox__inner']"));

			waitEle(By.xpath("//span[normalize-space()='Continue']"));
		} catch (Exception e) {

		}

		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Company']")).sendKeys("HGT");
		waitEle(By.xpath("//span[normalize-space()='FINISH']"));

//		waitEle(By.xpath("//div[@class='card mb-3']//input[@placeholder='Select']"));
//
//		waitEle(By.xpath("//div[@x-placement]//ul//li[19]"));
//		driver.findElement(By.xpath("//input[@placeholder='Enter signature']")).sendKeys("Prj");
//		waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
//
//		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));
//
//		waitEle(By.xpath("//span[normalize-space()='Edit']"));
//
//		waitEle(By.id("tab-drawer"));
//		Actions act = new Actions(driver);
//		Thread.sleep(10000);
//		act.clickAndHold(driver.findElement(By.xpath("//div[@id='signature']//canvas")))
//				.moveToElement(driver.findElement(By.xpath("//div[@id='signature']//canvas")), 20, -50)
//				.moveByOffset(50, 50).moveByOffset(80, -50).moveByOffset(100, 50).release().build().perform();
//		Thread.sleep(10000);
//		driver.findElement(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']")).click();
//		Thread.sleep(10000);
//		By down = By.xpath("//span[normalize-space()='FINISH']");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
//		WebElement download = wait.until(ExpectedConditions.elementToBeClickable(down));
//		download.click();
//		Thread.sleep(10000);
//		WebElement elementToHover = driver.findElement(By.xpath("//span[normalize-space()='Download']"));
//
//		Actions actions = new Actions(driver);
//
//		actions.moveToElement(elementToHover).perform();
//		Thread.sleep(10000);
//		By down11 = By.xpath("//ul[@x-placement]//li[normalize-space()='TESTING (1)']");
//		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofMinutes(2));
//		WebElement download11 = wait11.until(ExpectedConditions.elementToBeClickable(down11));
//		download11.click();

	}

	public void Outlooklogin(String email, String password) throws Exception {
		Thread.sleep(10000);
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
		switchEmail();
		sendKeysToElement(By.xpath("//input[@id=\"i0116\"]"), email);
		try {
			waitEle(By.xpath("//input[@id=\"idSIButton9\"]"));
		} catch (Exception e) {
			waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		}
		Thread.sleep(3000);
		sendKeysToElement(By.xpath("//input[@placeholder=\"Password\"]"), password);
		waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//button[@id=\"declineButton\"]"));
		System.out.printf("%s Login successfull", email);
	}

	public void jeevithaOutlookloginPage() throws Exception {

		sendKeysToElement(By.xpath("//input[@id=\"i0116\"]"), "jeevithapatnana200@outlook.com");
		try {
			waitEle(By.xpath("//input[@id=\"idSIButton9\"]"));
		} catch (Exception e) {
			waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		}

		sendKeysToElement(By.xpath("//input[@placeholder=\"Password\"]"), "Meghana@123");
		try {
			waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));

		} catch (Exception e) {
			waitEle(By.xpath("//input[@id=\"idSIButton9\"]"));
		}
		waitEle(By.xpath("//button[@id=\"declineButton\"]"));
		System.out.println("Jeevitha login successfull");
	}

	public void jeevithaOutlooklogin() throws Exception {
		Thread.sleep(10000);
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
		sendKeysToElement(By.xpath("//input[@id=\"i0116\"]"), "jeevithapatnana200@outlook.com");
		waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));

		sendKeysToElement(By.xpath("//input[@placeholder=\"Password\"]"), "Meghana@123");
		waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		waitEle(By.xpath("//button[@id=\"declineButton\"]"));
		System.out.println("Jeevitha login successfull");
	}

	public void outlooksigninpage() throws InterruptedException {
		Thread.sleep(10000);
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
	}

	public void clickEmail(String s) throws Exception {
		Thread.sleep(10000);
		String xpath = String.format("//span[contains(text(), '%s')]", s);
		waitEle(By.xpath(xpath));
	}

	public void senderReviewandSign(String s) throws Exception {
		waitEle(By.xpath("//a[text()=\"Review & sign\"]"));
		try {
			Thread.sleep(10000);
			waitEle(By.xpath("//span[@class=\"el-checkbox__inner\"]"));
			waitEle(By.xpath("//span[text()=\"Continue\"]"));
//			waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
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
		sendKeysToElement(By.xpath("//input[@placeholder='Enter signature']"), "Meghana");

		waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));
		waitEle(By.xpath("//span[text()=\"FINISH\"]"));
		System.out.println("Sender Signature done Successfully");
	}

	public void reviewandSign(String s) throws Exception {
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
		String xpath = String.format("//a[text()='%s']", s);
		waitEle(By.xpath(xpath));

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
	}

	public void clickFinish() throws Exception {
		waitEle(By.xpath("//span[text()=\"FINISH\"]"));
		System.out.println("Review and Sign successful");
	}

	public void signaturefill() throws Exception {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
//	Javascriptclick(By.xpath("//span[normalize-space()='Edit']"));
//	sendKeysToElement(By.xpath("//input[@placeholder='Enter signature']"), "Meghana");
//
//	waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));
	}

	public void signloginAccount() throws Exception {
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
		sendKeysToElement(By.xpath("//input[@placeholder='Enter signature']"), "Meghana");

		waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));
		Thread.sleep(1000);
		waitEle(By.xpath("//span[text()=\"FINISH\"]"));
		System.out.println("Review and Sign successful");
	}

	public void reviewandSignApprover() throws Exception {
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
			Thread.sleep(5000);
			waitEle(By.xpath("//span[@class=\"el-checkbox__inner\"]"));
			waitEle(By.xpath("//span[text()=\"Continue\"]"));
//			waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
		} catch (Exception e) {
			Thread.sleep(10000);
			waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
		}
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
//		Javascriptclick(By.xpath("//span[normalize-space()='Edit']"));
//		sendKeysToElement(By.xpath("//input[@placeholder='Enter signature']"), "Prj");
//
//		waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));

		waitEle(By.xpath("//span[text()=\"Approve\"]"));
		System.out.println("Review and approve Done");
		Thread.sleep(5000);
	}

	public void clickApprove() throws Exception {
		waitEle(By.xpath("//span[text()=\"Approve\"]"));
		System.out.println("Review and approve Done");
	}

	public void switchEmail() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@class=\"_8ZYZKvxC8bvw1xgQGSkvvA==\"]"));
		waitEle(By.xpath("//div[text()=\"Sign in with a different account\"]"));

	}

	public void receiverSideCheck() throws Exception {
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
		sendKeysToElement(By.xpath("//input[@id=\"i0116\"]"), "pmmeghana200@outlook.com");
		waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));

		sendKeysToElement(By.xpath("//input[@placeholder=\"Password\"]"), "Meghana@123");
		waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		waitEle(By.xpath("//button[@id=\"declineButton\"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//span[text()=\"Test Sample\"]"));
		VerifyClickonEmailSucess();
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
		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(10000);
				waitEle(By.xpath("//input[@placeholder=\"Enter 6 letters code\"]"));
				WebElement paste = driver.findElement(By.xpath("//input[@placeholder=\"Enter 6 letters code\"]"));

				actions.moveToElement(paste).keyDown(Keys.CONTROL) // Press Ctrl key
						.sendKeys("v") // Press v key
						.keyUp(Keys.CONTROL) // Release Ctrl key
						.build().perform();
				waitEle(By.xpath("//div[@class=\"el-form-item__content\"]//span[text()=\"Submit\"]"));

			}
		}
		Thread.sleep(10000);
		waitEle(By.xpath("//span[@class=\"el-checkbox__inner\"]"));
		waitEle(By.xpath("//span[text()=\"Continue\"]"));
		Thread.sleep(10000);
//		waitEle(By.xpath("//button[text()=\" Signature \"]"));
//		try {
//			Thread.sleep(10000);
//			driver.findElement(By.xpath("//div[@class=\"el-form-item__content\"]//input[@placeholder=\"Enter signature\"]"));
//			driver.findElement(By.xpath("//span[text()=\"Verify & Save Secure Signature\"]"));
//			Thread.sleep(10000);
//		} catch (Exception e) {
//			Set<String> windowHandles = driver.getWindowHandles();
//			for (String handle : windowHandles) {
//				driver.switchTo().window(handle);  
//			}
//			Thread.sleep(50000);
//			waitEle(By.xpath("//span[text()=\"Verify & Save Secure Signature\"]"));
//			waitEle(By.xpath("//span[text()=\"FINISH\"]"));
		VerifyDocCompleteReceiverEnd();
//		}
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(20000);
		waitEle(By.xpath("//span[normalize-space()='Edit']"));
		driver.findElement(By.xpath("//input[@placeholder='Enter signature']")).sendKeys("Prj");

		waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));

	}

	public void VerifyClickonEmailSucess() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement welcomeMessage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[@role=\"heading\"]//span[text()=\"Test Sample\"]")));

			Assert.assertNotNull(welcomeMessage, "");
			System.out.println("Click successful on email");
		} catch (Exception e) {
			System.out.println("Unable to click on mail");
		}
	}

	public void VerifyDocCompleteReceiverEnd() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement welcomeMessage = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()=\"Document Completed! \"]")));

			Assert.assertNotNull(welcomeMessage, "");
			System.out.println("Document Signatures Completed At Receiver End Successfully");
			driver.close();
		} catch (Exception e) {
			System.out.println("Document not Completed At Receiver End");
		}
	}

	public void receiverSignatureFullNameFeild() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));
		Thread.sleep(10000);
		Actions actions1 = new Actions(driver);

		WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		WebElement signElement = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		waitAndClick(actions1, signElement, targetElement, 10, 10);
		System.out.println("Signature Element Drag and Drop Done");

		WebElement fullNameElement = driver.findElement(By.xpath("//button[@id='fullNameEle']"));
		waitAndClick(actions1, fullNameElement, targetElement, 50, 50);
		System.out.println("FullName Drag and Drop Done");
	}

	public void validateAtCC(String s) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(String.format("(//span[contains(text(),'%s')])[1]", s))));

		Assert.assertNotNull(welcomeMessage, "Not signed by all the signers");
		System.out.println("email received at cc");
	}

	public void validateAtCCTwo() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//span[text()=\"Getting started with OneDrive  Document completed\"]")));

		Assert.assertNotNull(welcomeMessage, "Not signed by all the signers");
		System.out.println("email received at cc");
	}

	public void DeleteMailAtcc(String s) throws Exception {
		String xpath = String.format("//span[contains(text(), '%s')]", s);
		waitEle(By.xpath(xpath));
		System.out.println("click on cc mail done");

		waitEle(By.xpath("//span[text()=\"Delete\"]"));
		System.out.println("Email Deleted");
//		driver.close();

	}

	public void validateAtCCGdrive() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[text()=\"N180894-resume  Document completed\"]")));

		Assert.assertNotNull(welcomeMessage, "Not signed by all the signers");
		System.out.println("email received at cc");
	}
	public void receiverSideBasicFeildsFill() throws Exception {
		//date Feild
		waitEle(By.xpath("//input[@placeholder=\"Date\"]"));
		waitEle(By.xpath("(//div[@class=\"el-picker-panel__content\"]//tr[@class=\"el-date-table__row\"])[1]//td[4]"));
		//time
		waitEle(By.xpath("//input[@placeholder=\"Time\"]"));
		waitEle(By.xpath("//button[text()=\"OK\"]"));
		//select
		waitEle(By.xpath("//input[@placeholder=\"Select\"]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//div[@x-placement]//span[text()=\"Computer science\"]"));
		//fixedTime
		waitEle(By.xpath("//input[@placeholder=\"FixedTime\"]"));
		waitEle(By.xpath("//div[@x-placement]//div[text()=\"01:00\"]"));
		//Multiline
		sendKeysToElement(By.xpath("//textarea[@placeholder=\"Multiline\"]"),"PemmaMohan ReddyMeghana");
		//TimeRange
		waitEle(By.xpath("placeholder=\"Start time\""));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));
		waitEle(By.xpath("//button[text()=\"OK\"]"));
		//Signature
		waitEle(By.xpath("//button[text()=\" Sign \"]"));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));waitEle(By.xpath(""));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));
		waitEle(By.xpath(""));
	}
}
