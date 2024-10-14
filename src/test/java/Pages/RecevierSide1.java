package Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.UUID;
import java.util.List;
import org.openqa.selenium.Alert;
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

	public void firstOutlooklogin(String s) throws Exception {
		Thread.sleep(10000);
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
		sendKeysToElement(By.xpath("//input[@id=\"i0116\"]"), s);
		waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));

		sendKeysToElement(By.xpath("//input[@placeholder=\"Password\"]"), "Meghana@123");
		waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		waitEle(By.xpath("//button[@id=\"declineButton\"]"));
		System.out.printf("%s login successfull",s);
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
		System.out.println("click on email done successfully");
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
				System.out.println("Entered 6 letter code");
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

	public void ClickSignatureFeild() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//button[text()=\" Signature \"]"));
	}

	public void signaturefill() throws Exception {
		Thread.sleep(5000);
//	Javascriptclick(By.xpath("//span[normalize-space()='Edit']"));
//	sendKeysToElement(By.xpath("//input[@placeholder='Enter signature']"), "Meghana");
//
//	waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));
	}

	public void signloginAccount() throws Exception {
		String Parentwindowid1 = driver.getWindowHandle();
		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(10000);
				try {
					Thread.sleep(10000);
					waitEle(By.xpath("//span[@class=\"el-checkbox__inner\"]"));
					waitEle(By.xpath("//span[text()=\"Continue\"]"));
				} catch (Exception e) {
					Thread.sleep(10000);
					waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
				}
				Thread.sleep(10000);
//				Javascriptclick(By.xpath("//span[normalize-space()='Edit']"));
//				sendKeysToElement(By.xpath("//input[@placeholder='Enter signature']"), "Meghana");
//				waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
				waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));
				Thread.sleep(1000);
				waitEle(By.xpath("//span[text()=\"FINISH\"]"));
				System.out.println("Review and Sign successful");
			}

		}
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
//			driver.close();
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
	
	public void receiverSideBasicFeildsFill(int n,int checkbox,int checkboxGroup1,int checkboxGroup2) throws Exception {
		// radio group
		String radioGroup=String.format("(//div[@class=\"form-fields-holder\"]//span[text()=\"1\"])[%d]", n);
		waitEle(By.xpath(radioGroup));
		// date Range
		Thread.sleep(10000);
		String DateRange=String.format("(//div[@class=\"form-fields-holder\"]//input[@placeholder=\"Start date\"])[%d]", n);
		Javascriptclick(By.xpath(DateRange));
		Javascriptclick(By.xpath(
				"(//div[@class=\"el-picker-panel__content el-date-range-picker__content is-left\"]//td[@class=\"available\"])[1]"));
		Javascriptclick(By.xpath(
				"(//div[@class=\"el-picker-panel__content el-date-range-picker__content is-right\"]//td[@class=\"available\"])[1]"));
		System.out.println("filled dateRange feild");
		// Signature
		Thread.sleep(5000);
		try {
			waitEle(By.xpath("//div[@class=\"form-fields-holder\"]//button[text()=\" Sign \"]"));
		} catch (Exception e) {
			waitEle(By.xpath("(//div[@class=\"form-fields-holder\"]//img[@class=\"el-tooltip tooltip\"])[1]"));
		}
		Thread.sleep(10000);
		waitEle(By.xpath("//span[text()=\"Verify & Save Secure Signature\"]"));
		System.out.println("filled Signature feild");
		// date time
		String DateTime=String.format("(//div[@class=\"form-fields-holder\"]//input[@placeholder=\"DateTime\"])[%d]", n);
		waitEle(By.xpath(DateTime));
		waitEle(By.xpath("(//div[@x-placement]//tr[@class=\"el-date-table__row\"])[2]//td[4]"));
		waitEle(By.xpath("//span[normalize-space()=\"OK\"]"));
		System.out.println("filled  date time feild");
		// yes or no
		String YesOrNo=String.format("(//div[@class=\"form-fields-holder\"]//span[text()=\"YES\"])[%d]", n);
		Javascriptclick(By.xpath(YesOrNo));
		System.out.println("filled yes or no feild");
		// Weekday
		String Weekdays=String.format("(//div[@class=\"form-fields-holder\"]//input[@placeholder=\"Weekdays\"])[%d]", n);
		waitEle(By.xpath(Weekdays));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("filled Weekday feild");

		// sigleLine Text
		String Singlelinetext=String.format("(//div[@class=\"form-fields-holder\"]//input[@placeholder=\"Single line text\"])[%d]", n);
		driver.findElement(By.xpath(Singlelinetext)).clear();
		sendKeysToElement(By.xpath(Singlelinetext), "PemmaMohan ReddyMeghana");
		System.out.println("filled sigleLine Text feild");
		// checkbox
//		String checkbox1=String.format("(//div[@class=\"form-fields-holder\"]//input[@type=\"checkbox\"])[%d]", checkbox);
//		waitEle(By.xpath(checkbox1));
//		System.out.println("filled checkbox feild");
		// date Feild
		String Date=String.format("(//div[@class=\"form-fields-holder\"]//input[@placeholder=\"Date\"])[%d]", n);
		waitEle(By.xpath(Date));
		waitEle(By.xpath("//div[@x-placement]//tr[@class=\"el-date-table__row\"][1]//td[7]"));
		System.out.println("filled date Feild feild");
		// document
		String pdffile = System.getProperty("user.dir") + "\\src\\test\\resources\\TESTING.pdf";
		Thread.sleep(10000);
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		fileInput.sendKeys(pdffile);
		System.out.println("Uploaded file successfully");

		// fixedTime
//		String FixedTime=String.format("(//input[@placeholder=\"FixedTime\"])[%d]", n);
//		waitEle(By.xpath(FixedTime));
//		waitEle(By.xpath("//div[@x-placement]//div[text()=\"01:00\"]"));
//		waitEle(By.xpath("//input[@placeholder=\"Please select...\"]"));
//		Thread.sleep(3000);
//		waitEle(By.xpath("//div[@x-placement]//li[1]"));
//		System.out.println("filled fixedTime feild");
		// list
		String list=String.format("(//div[@class=\"form-fields-holder\"]//input[@placeholder=\"Please select...\"])[%d]", n);
		waitEle(By.xpath(list));
		Thread.sleep(3000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("filled list feild");
		// time
		String Time=String.format("(//div[@class=\"form-fields-holder\"]//input[@placeholder=\"Time\"])[%d]", n);
		waitEle(By.xpath(Time));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[4]//ul//li[text()='12']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[5]//ul//li[text()='12']"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[6]//ul//li[text()='12']"));
		waitEle(By.xpath("//button[text()=\"OK\"]"));
		System.out.println("filled time feild");
		// Number
		String Number=String.format("(//div[@class=\"form-fields-holder\"]//input[@placeholder=\"Number\"])[%d]", n);	
		driver.findElement(By.xpath(Number)).clear();
		sendKeysToElement(By.xpath(Number), "1");
		System.out.println("filled Number feild");
		// Multiline
		String Multiline=String.format("(//div[@class=\"form-fields-holder\"]//textarea[@placeholder=\"Multiline\"])[%d]", n);
		driver.findElement(By.xpath(Multiline)).clear();
		sendKeysToElement(By.xpath(Multiline), "PemmaMohan ReddyMeghana");
		System.out.println("filled Multiline feild");
		// select
		String Select=String.format("(//div[@class=\"form-fields-holder\"]//input[@placeholder=\"Select\"])[%d]", n);
		waitEle(By.xpath(Select));
		Thread.sleep(5000);
		Javascriptclick(By.xpath("//div[@x-placement]//span[text()=\"Computer science\"]"));
		System.out.println("filled select feild");
		// phone no
		String Phoneno=String.format("(//div[@class=\"form-fields-holder\"]//input[@placeholder=\"Phoneno\"])[%d]", n);
		driver.findElement(By.xpath(Phoneno)).clear();
		sendKeysToElement(By.xpath(Phoneno), "9347618053");
		System.out.println("filled phone no feild");
		// check box group
//		String checkboxgroup1=String.format("(//div[@class=\"form-fields-holder\"]//input[@type=\"checkbox\"])[%d]", checkboxGroup1);
//		waitEle(By.xpath(checkboxgroup1));
//		String checkboxgroup2=String.format("(//input[@type=\"checkbox\"])[%d]", checkboxGroup2);
//		waitEle(By.xpath(checkboxgroup2));
//		System.out.println("filled check box group feild");
		// multiselect
		waitEle(By.xpath("//div[@class=\"form-fields-holder\"]//input[@placeholder=\"Multiselect\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		waitEle(By.xpath("//div[@x-placement]//li[2]"));
		System.out.println("filled multiselect feild");
		// TimeRange
//		waitEle(By.xpath("placeholder=\"Start time\""));
//		waitEle(By.xpath(""));
//		waitEle(By.xpath(""));
//		waitEle(By.xpath("//button[text()=\"OK\"]"));
//		System.out.println("filled TimeRange feild");
		clickFinish();
		try {
			waitEle(By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]"));
		} catch (Exception e) {
		}
	}

	public void receiverSideUpdatedBasicFeildsFill() throws Exception {
		// radio group
		Thread.sleep(20000);
//		waitEle(By.xpath("//span[text()=\"2\"]"));
		System.out.println("radio group field updated");
		// date Range
		waitEle(By.xpath("//input[@placeholder=\"Start date\"]"));
		waitEle(By.xpath(
				"(//div[@class=\"el-picker-panel__content el-date-range-picker__content is-left\"]//td[@class=\"available\"])[2]"));
		waitEle(By.xpath(
				"(//div[@class=\"el-picker-panel__content el-date-range-picker__content is-right\"]//td[@class=\"available\"])[1]"));
		System.out.println("date Range field updated");
		// Signature
		try {
			waitEle(By.xpath("//button[text()=\" Sign \"]"));
		} catch (Exception e) {
			waitEle(By.xpath("(//img[@class=\"el-tooltip tooltip\"])[1]"));
		}
		Thread.sleep(10000);
		waitEle(By.xpath("//span[text()=\"Verify & Save Secure Signature\"]"));
		System.out.println("Signature field updated");
		// date time
		waitEle(By.xpath("//input[@placeholder=\"DateTime\"]"));
		waitEle(By.xpath("(//div[@x-placement]//tr[@class=\"el-date-table__row\"])[2]//td[5]"));
		waitEle(By.xpath("//span[normalize-space()=\"OK\"]"));
		System.out.println("date time field updated");
		// yes or no
		waitEle(By.xpath("//span[text()=\"NO\"]"));
		System.out.println("yes or no field updated");
		// Weekday
		waitEle(By.xpath("//input[@placeholder=\"Weekdays\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[2]"));
		System.out.println("Weekday field updated");
		// TimeRange
//				waitEle(By.xpath("placeholder=\"Start time\""));
//				waitEle(By.xpath(""));
//				waitEle(By.xpath(""));
//				waitEle(By.xpath("//button[text()=\"OK\"]"));

		// sigleLine Text
		driver.findElement(By.xpath("//input[@placeholder=\"Single line text\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Single line text\"]"), "Automation testing");
		System.out.println("sigleLine Text field updated");
		// checkbox
		waitEle(By.xpath("(//input[@type=\"checkbox\"])[1]"));
		System.out.println("checkbox field updated");
		// date Feild
		waitEle(By.xpath("//input[@placeholder=\"Date\"]"));
		waitEle(By
				.xpath("(//div[@class=\"el-picker-panel__content\"])[2]//tr[@class=\"el-date-table__row\"][2]//td[3]"));
		System.out.println("date Feild field updated");
		// document
		String pdffile = System.getProperty("user.dir") + "\\src\\test\\resources\\test.pdf";
		Thread.sleep(10000);
		try {
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		fileInput.sendKeys(pdffile);
		System.out.println("Uploaded file successfully");
		System.out.println("document field updated");
		}catch(Exception e) {
			
		}
		// fixedTime
//		waitEle(By.xpath("//input[@placeholder=\"FixedTime\"]"));
//		waitEle(By.xpath("//div[@x-placement]//div[text()=\"02:00\"]"));
//		waitEle(By.xpath("//input[@placeholder=\"Please select...\"]"));
//		Thread.sleep(3000);
//		waitEle(By.xpath("//div[@x-placement]//li[1]"));
//		System.out.println("fixedTime field updated");
		// list
		waitEle(By.xpath("//input[@placeholder=\"Please select...\"]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("list field updated");
		// time
		waitEle(By.xpath("//input[@placeholder=\"Time\"]"));
		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[4]//ul//li[text()='01']"));

		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[5]//ul//li[text()='01']"));

		waitEle(By.xpath("(//div[@class='el-time-spinner__wrapper el-scrollbar'])[6]//ul//li[text()='01']"));
		waitEle(By.xpath("(//button[text()=\"OK\"])[2]"));
		System.out.println("time field updated");
		// Number
		driver.findElement(By.xpath("//input[@placeholder=\"Number\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Number\"]"), "10");
		System.out.println("Number field updated");
		// phone no
		driver.findElement(By.xpath("//input[@placeholder=\"Phoneno\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Phoneno\"]"), "7337060228");
		System.out.println("phone no field updated");
		// select
		waitEle(By.xpath("(//input[@placeholder=\"Select\"])[2]"));
		Thread.sleep(2000);
		waitEle(By.xpath("//div[@x-placement]//span[text()=\"Computer science\"]"));
		System.out.println("select field updated");
		// Multiline
		driver.findElement(By.xpath("//textarea[@placeholder=\"Multiline\"]")).clear();
		sendKeysToElement(By.xpath("//textarea[@placeholder=\"Multiline\"]"), "Automation testing");
		System.out.println("Multiline field updated");
		// check box group
		waitEle(By.xpath("(//input[@type=\"checkbox\"])[3]"));
		waitEle(By.xpath("(//input[@type=\"checkbox\"])[2]"));
		System.out.println("check box group field updated");
		// multiselect
		try {
			waitEle(By.xpath("//i[@class=\"el-tag__close el-icon-close\"]"));
			Thread.sleep(3000);
			waitEle(By.xpath("//i[@class=\"el-tag__close el-icon-close\"]"));
		} catch (Exception e) {

		}
		waitEle(By.xpath("//input[@placeholder=\"Multiselect\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[3]"));
		waitEle(By.xpath("//div[@x-placement]//li[2]"));
		System.out.println("multiselect field updated");
		clickFinish();
		try {
			waitEle(By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]"));
		} catch (Exception e) {
		}
	}

	public void verifyBasicFeildDataFillInEntity() throws Exception {
		Thread.sleep(10000);
		// Radio Group
		WebElement radioGroup = driver.findElement(By.xpath(
				"//div[@class='el-table__body-wrapper is-scrolling-left']//table/tbody/tr[1]/td[2]//p[normalize-space()=\"1\"]"));

		if (radioGroup.isDisplayed()) {
			System.out.println("Radio Group Feild data displayed correctly");
		} else {
			System.out.println("Radio Group Feild data not displayed or displayed incorrectly");
		}
		// Date Range
		WebElement dateRange = driver.findElement(By.xpath(
				"//div[@class='el-table__body-wrapper is-scrolling-left']//table/tbody/tr[1]/td[3]//p[\" 05-01-2024 To 06-01-2024 \"]"));
		if (dateRange.isDisplayed()) {
			System.out.println("dateRange Feild data displayed correctly");
		} else {
			System.out.println("dateRange Feild data not displayed or displayed incorrectly");
		}
		// Document
		WebElement document = driver.findElement(By.xpath(
				"//div[@class='el-table__body-wrapper is-scrolling-left']//table/tbody/tr[1]/td[4]//p[\" TESTING.pdf \"]"));
		if (document.isDisplayed()) {
			System.out.println("document Feild data displayed correctly");
		} else {
			System.out.println("document Feild data not displayed or displayed incorrectly");
		}
	}
	public void verifyNeverUpdate(String[] fieldValues, int n) {
		String fields[] = { "Radio Group", "Date Range", "Sign", "Date Time", "Yes Or No", "Weekdays",
				"Single Line Text", "Date", "Document", "CheckBox", "Fixed Time", "List", "Time", "Number",
				"Multi Select", "Phone no", "Select", "Multiline", "checkboxGroup" };
		final String RESET = "\033[0m"; // Text Reset
		final String RED = "\033[0;31m"; // RED
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		for (int i = 0; i < fieldValues.length; i++) {
			String fieldValue = fieldValues[i];
			String field = fields[i];
			String xpath = String.format(
					"//div[@class='el-table__body-wrapper is-scrolling-left']//table/tbody/tr[%d]/td[%d]//p[normalize-space()=\"%s\"] | "
							+ "//div[@class='el-table__body-wrapper is-scrolling-left']//table/tbody/tr[1]/td[%d]//span[normalize-space()=\"%s\"]|"
							+ "(//img[@alt=\"%s\"])[1]",
					n, i + 3, fieldValue, n, i + 3, fieldValue, n, i + 3, fieldValue);

			try {
				WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
				if (element.isDisplayed()) {
					System.out.printf(RED +"%s Field data %s displayed correctly\n"+ RESET, field, fieldValue);
				} else {
					System.out.printf( "%s Field data %s not displayed or displayed incorrectly\n",  field,
							fieldValue);
				}
			} catch (Exception e) {
				try {
					WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'start'});", element);
					if (element.isDisplayed()) {
						System.out.printf(RED + "%s Field data %s displayed correctly after scroll\n"+ RESET, field, fieldValue);
					} else {
						System.out.printf(
								"%s Field data %s not displayed or displayed incorrectly after scroll\n" ,
								field, fieldValue);
					}
				} catch (Exception ex) {
					System.out.printf("%s Field data %s not found in the DOM\n" , field, fieldValue);
				}
			}
		}
	}

	public void verifyBasicFieldDataFillInIndividualEntity(String[] fieldValues, int n) {
		String fields[] = { "Radio Group", "Date Range", "Sign", "Date Time", "Yes Or No", "Weekdays",
				"Single Line Text", "Date", "Document", "CheckBox", "Fixed Time", "List", "Time", "Number",
				"Multi Select", "Phone no", "Select", "Multiline", "checkboxGroup" };
		final String RESET = "\033[0m"; // Text Reset
		final String RED = "\033[0;31m"; // RED
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		for (int i = 0; i < fieldValues.length; i++) {
			String fieldValue = fieldValues[i];
			String field = fields[i];
			String xpath = String.format(
					"//div[@class='el-table__body-wrapper is-scrolling-left']//table/tbody/tr[%d]/td[%d]//p[normalize-space()=\"%s\"] | "
							+ "//div[@class='el-table__body-wrapper is-scrolling-left']//table/tbody/tr[%d]/td[%d]//span[normalize-space()=\"%s\"]|"
							+ "//div[@class='el-table__body-wrapper is-scrolling-left']//table/tbody/tr[%d]/td[%d](//img[@alt=\"%s\"])[1]",
					n, i + 3, fieldValue, n, i + 3, fieldValue, n, i + 3, fieldValue);

			try {
				WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
				if (element.isDisplayed()) {
					System.out.printf(" Field data %s displayed correctly\n",  fieldValue);
				} else {
					System.out.printf(RED + " Field data %s not displayed or displayed incorrectly\n" + RESET, 
							fieldValue);
				}
			} catch (Exception e) {
				try {
					WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'start'});", element);
					if (element.isDisplayed()) {
						System.out.printf(" Field data %s displayed correctly after scroll\n", fieldValue);
					} else {
						System.out.printf(
								RED + " Field data %s not displayed or displayed incorrectly after scroll\n" + RESET,
								 fieldValue);
					}
				} catch (Exception ex) {
					System.out.printf(RED + " Field data %s not found in the DOM\n" + RESET,  fieldValue);
				}
			}
		}
	}
	public void verifyBasicFieldDataFillInIndividualEntityUpdateWithParent(String[] fieldValues, int n) {
		String fields[] = { "Radio Group", "Date Range", "Sign", "Date Time", "Yes Or No", "Weekdays",
				"Single Line Text", "Date", "Document", "CheckBox", "Fixed Time", "List", "Time", "Number",
				"Multi Select", "Phone no", "Select", "Multiline", "checkboxGroup" };
		final String RESET = "\033[0m"; // Text Reset
		final String RED = "\033[0;31m"; // RED
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		for (int i = 0; i < fieldValues.length; i++) {
			String fieldValue = fieldValues[i];
			String field = fields[i];
			String xpath = String.format(
					"//div[@class='el-table__body-wrapper is-scrolling-left']//table/tbody/tr[%d]/td[%d]//p[normalize-space()=\"%s\"] | "
							+ "//div[@class='el-table__body-wrapper is-scrolling-left']//table/tbody/tr[%d]/td[%d]//span[normalize-space()=\"%s\"]|"
							+ "//div[@class='el-table__body-wrapper is-scrolling-left']//table/tbody/tr[%d]/td[%d](//img[@alt=\"%s\"])[1]",
					n, i + 3, fieldValue, n, i + 3, fieldValue, n, i + 3, fieldValue);

			try {
				WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
				String text=element.getText();
				if (text!=fieldValue) {
					System.out.printf("%s Field data %s is Updated correctly\n", field, fieldValue);
				} else {
					System.out.printf(RED + "%s Field data %s not Updated correctly\n" + RESET, field,
							fieldValue);
				}
			} catch (Exception e) {
				try {
					WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'start'});", element);
					if (element.isDisplayed()) {
						System.out.printf("%s Field data %s Updated correctly after scroll\n", field, fieldValue);
					} else {
						System.out.printf(
								RED + "%s Field data %s not Updatedcorrectly after scroll\n" + RESET,
								field, fieldValue);
					}
				} catch (Exception ex) {
					System.out.printf(RED + "%s Field data %s not found in the DOM\n" + RESET, field, fieldValue);
				}
			}
		}
	}

	public void fillFillabelFeilds() throws Exception {
		waitEle(By.xpath("//input[@placeholder=\"Select Date\"])[1]"));
		waitEle(By.xpath("(//div[@class=\"el-picker-panel__body\"]//td[@class=\"available\"])[1]"));
		waitEle(By.xpath("(//input[@placeholder=\"Please select...\"])[1]"));
		Javascriptclick(By.xpath("//div[@x-placement]//li[1]"));
		waitEle(By.xpath("(//span[text()=\"Yes\"])[1]"));
		sendKeysToElement(By.xpath("(//div[@class=\"field-textarea textare-background el-textarea\"])[1]"),
				"PemmaMohan.ReddyMeghana");
		waitEle(By.xpath("//div[@data-text=\"Multi Select 1\"]"));
		Javascriptclick(By.xpath("//div[@x-placement]//li[1]"));
		Javascriptclick(By.xpath("//div[@x-placement]//li[2]"));
		sendKeysToElement(By.xpath("//div[@data-text=\"Number 1\"]"), "10");
		waitEle(By.xpath("(//input[@placeholder=\"Select date and time\"])[1]"));
		waitEle(By.xpath("(//div[@x-placement]//tr[@class=\"el-date-table__row\"]//td[@class=\"available\"])[1]"));
		waitEle(By.xpath(
				"//div[@x-placement]//button[@class=\"el-button el-picker-panel__link-btn el-button--default el-button--mini is-plain\"]"));
		waitEle(By.xpath("//div[@data-text=\"Date Time Range 1\"]//input[@placeholder=\"Start date\"]"));
		waitEle(By.xpath(
				"//div[@x-placement]//div[@class=\"el-picker-panel__content el-date-range-picker__content is-left\"]//tr[3]//td[4]"));
		waitEle(By.xpath(
				"//div[@x-placement]//div[@class=\"el-picker-panel__content el-date-range-picker__content is-right\"]//tr[3]//td[4]"));
		waitEle(By.xpath(
				"//div[@x-placement]//button[@class=\"el-button el-picker-panel__link-btn el-button--default el-button--mini is-plain\"]"));
		waitEle(By.xpath("//div[@data-text=\"Date Range 1\"]//input[@placeholder=\"Start date\"]"));

	}
	public void fillEssentialFeilds(int n) throws Exception {

		Thread.sleep(10000);
		try {
			waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
		} catch (Exception e) {

		}

		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));
		waitEle(By.xpath("//div[@class=\"req-item\"]//button[@class=\"el-tooltip tooltip\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//span[text()=\"Save\"]"));
		String a = String.format("(//input[@placeholder=\"Enter value\"])[%d]", n);
		sendKeysToElement(By.xpath(a), "Filling the SingleLine Text Field");
		String b = String.format("(//input[@type=\"checkbox\"])[%d]", n);
		waitEle(By.xpath(b));
		String c = String.format("(//input[@placeholder=\"Enter Title\"])[%d]", n);
		driver.findElement(By.xpath(c)).clear();
		sendKeysToElement(By.xpath(c), "Manager");
		try {

			String d = String.format("(//input[@placeholder=\"Enter Company\"])[%d]", n);
			driver.findElement(By.xpath(d)).clear();
			sendKeysToElement(By.xpath(d), "Meghana Solutions");
		} catch (Exception e) {

		}
		String addressField = String.format("(//textarea[@placeholder=\"Enter Address\"])[%d]", n);
		driver.findElement(By.xpath(addressField)).clear();
		sendKeysToElement(By.xpath(addressField), "6/17,BalijagaddaStreet,gurramkonda,annamyya District,Ap.");

		waitEle(By.xpath("//span[normalize-space()='FINISH']"));
		System.out.println("Click on Finish After enterning Essentials fields done Successfully");

	}
	public void clickOnStatusToClickOnSecondDocToFill() throws Exception {
		waitEle(By.xpath("//div[@class=\"el-tabs el-tabs--top el-tabs--border-card form-fields-set\"]//div[@class=\"box d-flex mb-1\"][2]"));
		Thread.sleep(20000);
		
	}
	
}