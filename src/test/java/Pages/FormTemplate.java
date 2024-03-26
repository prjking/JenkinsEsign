package Pages;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import dev.failsafe.function.CheckedFunction;

public class FormTemplate {
	WebDriver driver;
	MethodActions methodActions;

	public FormTemplate(WebDriver driver) {
		this.driver = driver;
		methodActions = new MethodActions(driver);

	}

	public void Template() throws Exception {
		Thread.sleep(10000);
		MethodActions.Loadingmask();
		MethodActions.waitEle(By.xpath("//div[@class='icon-text']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//li[normalize-space()='Form Template']"));

	}

	public void Createtemp() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@class='right-create-button']"));
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Template Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Template Description']"),
				MethodActions.generateUniqueString());
		// MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[2]"));
//		MethodActions.waitEle(By.xpath("//input[@placeholder='Select']"));
//		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[2]"));
		MethodActions.waitEle(By.xpath("//div[@class='last-row-in-form']//span[normalize-space()='Submit']"));

	}

	public void Validpopup() throws Exception {
		Thread.sleep(10000);
		WebElement popup = driver.findElement(By.xpath("//div[@class='dialog-container']"));
		boolean isPopupDisplayed = popup.isDisplayed();
		MethodActions.waitEle(By.xpath("//div[@class='dialog-container']//button[@class='close-button']"));
		if (isPopupDisplayed) {
			System.out.println("Popup did not open in front of the existing window.");
		} else {

			System.out.println("Popup opened in front of the existing window.");
		}
	}

	public void clickElementWithScrollIntoView(By locator) {
		WebElement element = driver.findElement(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		element.click();
	}

	// Single-Line
	public void addFieldSENDERORRECEIVER(String fieldType, WebElement sourceElement, WebElement targetElement,
			boolean isYes) throws Exception {
		Thread.sleep(10000);
		MethodActions.dragAndDrop(sourceElement, targetElement);

		Thread.sleep(10000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		if (isYes) {

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement yesElement = wait1.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='Yes']")));
			yesElement.click();

			System.out.println("With Field Required! Yes");
		}

		else {

			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement noElement = wait2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='No']")));
			noElement.click();
			System.out.println("With Field Required! NO");

		}
		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[3]"));
		MethodActions.waitEle(By.xpath("//div[@class='el-select input_type']"));

		switch (fieldType) {
		case "PASSWORD":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[1]"));
			WebElement ListdElementpwd = driver.findElement(By.xpath("//span[text()='PASSWORD']"));
			Assert.assertTrue(ListdElementpwd.isDisplayed(), "List is not selected successfully");
			System.out.println("PASSWORD  With SENDER OR RECEIVER from Field Type Selected Sucessully ");
			break;
		case "EMAIL":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[2]"));
			WebElement ListdElementemail = driver.findElement(By.xpath("//span[text()='EMAIL']"));
			Assert.assertTrue(ListdElementemail.isDisplayed(), "List is not selected successfully");
			System.out.println("EMAIL With SENDER OR RECEIVER from Field Type Selected Sucessully ");
			break;
		case "TEXT":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[3]"));
			WebElement ListdElementTEXT = driver.findElement(By.xpath("//span[text()='TEXT']"));
			Assert.assertTrue(ListdElementTEXT.isDisplayed(), "List is not selected successfully");
			System.out.println("TEXT With SENDER OR RECEIVER from Field Type Selected Sucessully ");
			break;
		case "MASKED":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[4]"));
			WebElement ListdElementMASKED = driver.findElement(By.xpath("//span[text()='MASKED']"));
			Assert.assertTrue(ListdElementMASKED.isDisplayed(), "List is not selected successfully");
			System.out.println("MASKED With SENDER OR RECEIVER from Field Type Selected Sucessully ");
			break;
		case "HYPER LINK":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[5]"));
			WebElement ListdElementHYPER = driver.findElement(By.xpath("//span[text()='HYPER LINK']"));
			Assert.assertTrue(ListdElementHYPER.isDisplayed(), "List is not selected successfully");
			System.out.println("HYPER LINK With SENDER OR RECEIVER from Field Type Selected Sucessully ");
			break;
		default:

			break;
		}
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--primary']"));
	}

	public void addFieldRECEIVER(String fieldType, WebElement sourceElement, WebElement targetElement, boolean isYes)
			throws Exception {
		Thread.sleep(10000);
		MethodActions.dragAndDrop(sourceElement, targetElement);
		Thread.sleep(10000);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		if (isYes) {

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement yesElement = wait1.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='Yes']")));
			yesElement.click();

			System.out.println("With Field Required! Yes");
		}

		else {

			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement noElement = wait2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='No']")));
			noElement.click();
			System.out.println("With Field Required! NO");

		}
		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[2]"));
		MethodActions.Javascriptclick(By.xpath("//div[@class='el-select input_type']"));

		switch (fieldType) {
		case "PASSWORD":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[1]"));
			Thread.sleep(10000);
			WebElement ListdElementpwd = driver.findElement(By.xpath("//span[text()='PASSWORD']"));
			Assert.assertTrue(ListdElementpwd.isDisplayed(), "List is not selected successfully");
			System.out.println("PASSWORD  With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "EMAIL":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[2]"));
			Thread.sleep(10000);
			WebElement ListdElementemail = driver.findElement(By.xpath("//span[text()='EMAIL']"));
			Assert.assertTrue(ListdElementemail.isDisplayed(), "List is not selected successfully");
			System.out.println("EMAIL With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "TEXT":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[3]"));
			Thread.sleep(10000);
			WebElement ListdElementTEXT = driver.findElement(By.xpath("//span[text()='TEXT']"));
			Assert.assertTrue(ListdElementTEXT.isDisplayed(), "List is not selected successfully");
			System.out.println("TEXT With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "MASKED":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[4]"));
			Thread.sleep(10000);
			WebElement ListdElementMASKED = driver.findElement(By.xpath("//span[text()='MASKED']"));
			Assert.assertTrue(ListdElementMASKED.isDisplayed(), "List is not selected successfully");
			System.out.println("MASKED With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "HYPER LINK":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[5]"));
			Thread.sleep(10000);
			WebElement ListdElementHYPER = driver.findElement(By.xpath("//span[text()='HYPER LINK']"));
			Assert.assertTrue(ListdElementHYPER.isDisplayed(), "List is not selected successfully");
			System.out.println("HYPER LINK With RECEIVER from Field Type Selected Sucessully ");
			break;
		default:

			break;
		}
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--primary']"));
	}

	public void addField(String fieldType, WebElement sourceElement, WebElement targetElement, boolean isYes)
			throws Exception {
		Thread.sleep(10000);
		MethodActions.dragAndDrop(sourceElement, targetElement);
		Thread.sleep(10000);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());

		if (isYes) {

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement yesElement = wait1.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='Yes']")));
			yesElement.click();

			System.out.println("With Field Required! Yes");
		}

		else {

			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement noElement = wait2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='No']")));
			noElement.click();
			System.out.println("With Field Required! NO");

		}

		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[1]"));
		MethodActions.Javascriptclick(By.xpath("//div[@class='el-select input_type']"));

		switch (fieldType) {
		case "PASSWORD":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[1]"));
			WebElement ListdElementpwd = driver.findElement(By.xpath("//span[text()='PASSWORD']"));
			Assert.assertTrue(ListdElementpwd.isDisplayed(), "List is not selected successfully");
			System.out.println("PASSWORD  With Sender from Field Type Selected Sucessully ");
			break;
		case "EMAIL":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[2]"));
			WebElement ListdElementemail = driver.findElement(By.xpath("//span[text()='EMAIL']"));
			Assert.assertTrue(ListdElementemail.isDisplayed(), "List is not selected successfully");
			System.out.println("EMAIL With Sender from Field Type Selected Sucessully ");
			break;
		case "TEXT":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[3]"));
			WebElement ListdElementTEXT = driver.findElement(By.xpath("//span[text()='TEXT']"));
			Assert.assertTrue(ListdElementTEXT.isDisplayed(), "List is not selected successfully");
			System.out.println("TEXT With Sender from Field Type Selected Sucessully ");
			break;
		case "MASKED":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[4]"));
			WebElement ListdElementMASKED = driver.findElement(By.xpath("//span[text()='MASKED']"));
			Assert.assertTrue(ListdElementMASKED.isDisplayed(), "List is not selected successfully");
			System.out.println("MASKED With Sender from Field Type Selected Sucessully ");
			break;
		case "HYPER LINK":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[5]"));
			WebElement ListdElementHYPER = driver.findElement(By.xpath("//span[text()='HYPER LINK']"));
			Assert.assertTrue(ListdElementHYPER.isDisplayed(), "List is not selected successfully");
			System.out.println("HYPER LINK With Sender from Field Type Selected Sucessully ");
			break;
		default:

			break;
		}
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--primary']"));
	}

	public void SingleLineWithSENDER() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement sourceElement = driver.findElement(By.xpath("//span[text()='Single Line Text']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		MethodActions.dragAndDrop(sourceElement, targetElement);
		Thread.sleep(10000);
		WebElement ListdElementHYPER = driver.findElement(By.xpath("//h2[text()='Add Single Line Text']"));
		Assert.assertTrue(ListdElementHYPER.isDisplayed(), "List is not selected successfully");
		System.out.println("Add Single Line Text Inserted Sucessully ");
		Thread.sleep(10000);
		//// With yes
		addField("PASSWORD", sourceElement, targetElement, true);
		addField("EMAIL", sourceElement, targetElement, true);
		addField("TEXT", sourceElement, targetElement, true);
		addField("MASKED", sourceElement, targetElement, true);
		addField("HYPER LINK", sourceElement, targetElement, true);
		// With No
		addField("PASSWORD", sourceElement, targetElement, false);
		addField("EMAIL", sourceElement, targetElement, false);
		addField("TEXT", sourceElement, targetElement, false);
		addField("MASKED", sourceElement, targetElement, false);
		addField("HYPER LINK", sourceElement, targetElement, false);
	}

	public void SingleLineWithRECEIVER() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement sourceElement = driver.findElement(By.xpath("//span[text()='Single Line Text']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		MethodActions.dragAndDrop(sourceElement, targetElement);
		Thread.sleep(10000);
		WebElement ListdElementHYPER = driver.findElement(By.xpath("//h2[text()='Add Single Line Text']"));
		Assert.assertTrue(ListdElementHYPER.isDisplayed(), "List is not selected successfully");
		System.out.println("Add Single Line With RECEIVER DRAG and DROP Sucessully ");

		Thread.sleep(10000);
		// Yes
		addFieldRECEIVER("PASSWORD", sourceElement, targetElement, true);
		addFieldRECEIVER("EMAIL", sourceElement, targetElement, true);
		addFieldRECEIVER("TEXT", sourceElement, targetElement, true);
		addFieldRECEIVER("MASKED", sourceElement, targetElement, true);
		addFieldRECEIVER("HYPER LINK", sourceElement, targetElement, true);
		// No
		addFieldRECEIVER("PASSWORD", sourceElement, targetElement, false);
		addFieldRECEIVER("EMAIL", sourceElement, targetElement, false);
		addFieldRECEIVER("TEXT", sourceElement, targetElement, false);
		addFieldRECEIVER("MASKED", sourceElement, targetElement, false);
		addFieldRECEIVER("HYPER LINK", sourceElement, targetElement, false);
	}

	public void SingleLineWithSENDERORRECEIVER() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement sourceElement = driver.findElement(By.xpath("//span[text()='Single Line Text']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		MethodActions.dragAndDrop(sourceElement, targetElement);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		Thread.sleep(10000);
		WebElement ListdElementHYPER = driver.findElement(By.xpath("//h2[text()='Add Single Line Text']"));
		Assert.assertTrue(ListdElementHYPER.isDisplayed(), "List is not selected successfully");
		System.out.println("Add Single Line DRAG and DROP WithcSENDER OR RECEIVER Sucessully ");
		Thread.sleep(10000);
		// Yes
		addFieldSENDERORRECEIVER("PASSWORD", sourceElement, targetElement, true);
		addFieldSENDERORRECEIVER("EMAIL", sourceElement, targetElement, true);
		addFieldSENDERORRECEIVER("TEXT", sourceElement, targetElement, true);
		addFieldSENDERORRECEIVER("MASKED", sourceElement, targetElement, true);
		addFieldSENDERORRECEIVER("HYPER LINK", sourceElement, targetElement, true);
		// No
		addFieldSENDERORRECEIVER("PASSWORD", sourceElement, targetElement, false);
		addFieldSENDERORRECEIVER("EMAIL", sourceElement, targetElement, false);
		addFieldSENDERORRECEIVER("TEXT", sourceElement, targetElement, false);
		addFieldSENDERORRECEIVER("MASKED", sourceElement, targetElement, false);
		addFieldSENDERORRECEIVER("HYPER LINK", sourceElement, targetElement, false);
	}

	public void closeingleline() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement sourceElement = driver.findElement(By.xpath("//span[text()='Single Line Text']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		MethodActions.dragAndDrop(sourceElement, targetElement);
		MethodActions.waitEle(By.xpath("//button[@class='close-button']"));
		System.out.println("Single Line Text Field - Closed  Button  by clicking X");

	}

	public void SinglelineGlobalVariable() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement sourceElement = driver.findElement(By.xpath("//span[text()='Single Line Text']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		MethodActions.dragAndDrop(sourceElement, targetElement);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString() + "Singleline Global Variable");
		driver.findElement(By.xpath("//input[@placeholder='Enter Number Of Rows']")).sendKeys("3");

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		WebElement global = driver
				.findElement(By.xpath("//div[@class='el-form-item']//label[normalize-space()='Global Variable']"));
		Assert.assertTrue(global.isDisplayed(), "Unable to Click On Global ariable");
		System.out.println("Clicked on the Global Variable the pop up tab is changed to Global variables");
		System.out.println("data is fetched To The Global Variables");
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--primary']"));

	}

//MultiLine

	public void MultilineRecevier() throws Exception {
		Thread.sleep(10000);
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement sourceElement = driver.findElement(By.xpath("//span[text()=\"Multi Line Text\"]"));
		Thread.sleep(10000);
		Actions builder = new Actions(driver);
		MethodActions.waitAndClick(builder, sourceElement, targetElement);
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();

		Thread.sleep(10000);
		// Yes
		addFieldMultilineRecevier("RICH TEXT", sourceElement, targetElement, true);
		addFieldMultilineRecevier("EMAIL", sourceElement, targetElement, true);
		addFieldMultilineRecevier("PASSWORD", sourceElement, targetElement, true);
		addFieldMultilineRecevier("EMAIL", sourceElement, targetElement, true);
		addFieldMultilineRecevier("TEXT", sourceElement, targetElement, true);
		addFieldMultilineRecevier("NUMBER", sourceElement, targetElement, true);
		addFieldMultilineRecevier("CURRENCY", sourceElement, targetElement, true);
		addFieldMultilineRecevier("MULTI LINE TEXT", sourceElement, targetElement, true);

		// No
		addFieldMultilineRecevier("RICH TEXT", sourceElement, targetElement, false);
		addFieldMultilineRecevier("EMAIL", sourceElement, targetElement, false);
		addFieldMultilineRecevier("PASSWORD", sourceElement, targetElement, false);
		addFieldMultilineRecevier("EMAIL", sourceElement, targetElement, false);
		addFieldMultilineRecevier("TEXT", sourceElement, targetElement, false);
		addFieldMultilineRecevier("NUMBER", sourceElement, targetElement, false);
		addFieldMultilineRecevier("CURRENCY", sourceElement, targetElement, false);
		addFieldMultilineRecevier("MULTI LINE TEXT", sourceElement, targetElement, false);
	}

	public void addFieldMultilineRecevier(String fieldType, WebElement sourceElement, WebElement targetElement,
			boolean isYes) throws Exception {
		Thread.sleep(10000);
		MethodActions.dragAndDrop(sourceElement, targetElement);
		Thread.sleep(10000);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString() + "Multilie");

		if (isYes) {

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement yesElement = wait1.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='Yes']")));
			yesElement.click();

			System.out.println("With Field Required! Yes");
		}

		else {

			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement noElement = wait2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='No']")));
			noElement.click();
			System.out.println("With Field Required! NO");

		}
		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[1]"));
		MethodActions.waitEle(By.xpath("//div[@class='el-select input_type']"));

		switch (fieldType) {
		case "RICH TEXT":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
			Thread.sleep(10000);
			WebElement ListdElementpwd = driver.findElement(By.xpath("//span[text()='PASSWORD']"));
			Assert.assertTrue(ListdElementpwd.isDisplayed(), "List is not selected successfully");
			System.out.println("RICH TEXT  With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "PASSWORD":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
			Thread.sleep(10000);
			WebElement ListdElementemail = driver.findElement(By.xpath("//span[text()='EMAIL']"));
			Assert.assertTrue(ListdElementemail.isDisplayed(), "List is not selected successfully");
			System.out.println("PASSWORD With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "EMAIL":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));
			Thread.sleep(10000);
			WebElement ListdElementTEXT = driver.findElement(By.xpath("//span[text()='TEXT']"));
			Assert.assertTrue(ListdElementTEXT.isDisplayed(), "List is not selected successfully");
			System.out.println("EMAIL With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "TEXT":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[4]"));
			Thread.sleep(10000);
			WebElement ListdElementMASKED = driver.findElement(By.xpath("//span[text()='MASKED']"));
			Assert.assertTrue(ListdElementMASKED.isDisplayed(), "List is not selected successfully");
			System.out.println("TEXT With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "NUMBER":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[5]"));
			Thread.sleep(10000);
			WebElement ListdElementHYPER = driver.findElement(By.xpath("//span[text()='HYPER LINK']"));
			Assert.assertTrue(ListdElementHYPER.isDisplayed(), "List is not selected successfully");
			System.out.println("NUMBER With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "CURRENCY":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[5]"));
			Thread.sleep(10000);
			WebElement ListdElementCURRENCY = driver.findElement(By.xpath("//span[text()='HYPER LINK']"));
			Assert.assertTrue(ListdElementCURRENCY.isDisplayed(), "List is not selected successfully");
			System.out.println("CURRENCY With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "MULTI LINE TEXT":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[5]"));
			Thread.sleep(10000);
			WebElement ListdElementMULTILINETEXT = driver.findElement(By.xpath("//span[text()='HYPER LINK']"));
			Assert.assertTrue(ListdElementMULTILINETEXT.isDisplayed(), "List is not selected successfully");
			System.out.println("MULTI LINE TEXT With RECEIVER from Field Type Selected Sucessully ");
			break;
		default:

			break;
		}
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--primary']"));
	}

	public void addFieldMultilineSender(String fieldType, WebElement sourceElement, WebElement targetElement,
			boolean isYes) throws Exception {
		Thread.sleep(10000);
		MethodActions.dragAndDrop(sourceElement, targetElement);
		Thread.sleep(10000);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString() + "Multilie");

		if (isYes) {

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement yesElement = wait1.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='Yes']")));
			yesElement.click();

			System.out.println("With Field Required! Yes");
		}

		else {

			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement noElement = wait2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='No']")));
			noElement.click();
			System.out.println("With Field Required! NO");

		}
		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[2]"));
		MethodActions.waitEle(By.xpath("//div[@class='el-select input_type']"));

		switch (fieldType) {
		case "RICH TEXT":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
			Thread.sleep(10000);
			WebElement ListdElementpwd = driver.findElement(By.xpath("//span[text()='PASSWORD']"));
			Assert.assertTrue(ListdElementpwd.isDisplayed(), "List is not selected successfully");
			System.out.println("RICH TEXT  With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "PASSWORD":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
			Thread.sleep(10000);
			WebElement ListdElementemail = driver.findElement(By.xpath("//span[text()='EMAIL']"));
			Assert.assertTrue(ListdElementemail.isDisplayed(), "List is not selected successfully");
			System.out.println("PASSWORD With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "EMAIL":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));
			Thread.sleep(10000);
			WebElement ListdElementTEXT = driver.findElement(By.xpath("//span[text()='TEXT']"));
			Assert.assertTrue(ListdElementTEXT.isDisplayed(), "List is not selected successfully");
			System.out.println("EMAIL With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "TEXT":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[4]"));
			Thread.sleep(10000);
			WebElement ListdElementMASKED = driver.findElement(By.xpath("//span[text()='MASKED']"));
			Assert.assertTrue(ListdElementMASKED.isDisplayed(), "List is not selected successfully");
			System.out.println("TEXT With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "NUMBER":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[5]"));
			Thread.sleep(10000);
			WebElement ListdElementHYPER = driver.findElement(By.xpath("//span[text()='HYPER LINK']"));
			Assert.assertTrue(ListdElementHYPER.isDisplayed(), "List is not selected successfully");
			System.out.println("NUMBER With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "CURRENCY":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[5]"));
			Thread.sleep(10000);
			WebElement ListdElementCURRENCY = driver.findElement(By.xpath("//span[text()='HYPER LINK']"));
			Assert.assertTrue(ListdElementCURRENCY.isDisplayed(), "List is not selected successfully");
			System.out.println("CURRENCY With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "MULTI LINE TEXT":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[5]"));
			Thread.sleep(10000);
			WebElement ListdElementMULTILINETEXT = driver.findElement(By.xpath("//span[text()='HYPER LINK']"));
			Assert.assertTrue(ListdElementMULTILINETEXT.isDisplayed(), "List is not selected successfully");
			System.out.println("MULTI LINE TEXT With RECEIVER from Field Type Selected Sucessully ");
			break;
		default:

			break;
		}
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--primary']"));
	}

	public void MultilineSender() throws Exception {
		Thread.sleep(10000);
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement sourceElement = driver.findElement(By.xpath("//span[text()=\"Multi Line Text\"]"));
		Thread.sleep(10000);
		Actions builder = new Actions(driver);
		MethodActions.waitAndClick(builder, sourceElement, targetElement);
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();

		Thread.sleep(10000);
		// Yes
		addFieldMultilineSender("RICH TEXT", sourceElement, targetElement, true);
		addFieldMultilineSender("EMAIL", sourceElement, targetElement, true);
		addFieldMultilineSender("PASSWORD", sourceElement, targetElement, true);
		addFieldMultilineSender("EMAIL", sourceElement, targetElement, true);
		addFieldMultilineSender("TEXT", sourceElement, targetElement, true);
		addFieldMultilineSender("NUMBER", sourceElement, targetElement, true);
		addFieldMultilineSender("CURRENCY", sourceElement, targetElement, true);
		addFieldMultilineSender("MULTI LINE TEXT", sourceElement, targetElement, true);

		// No
		addFieldMultilineSender("RICH TEXT", sourceElement, targetElement, false);
		addFieldMultilineSender("EMAIL", sourceElement, targetElement, false);
		addFieldMultilineSender("PASSWORD", sourceElement, targetElement, false);
		addFieldMultilineSender("EMAIL", sourceElement, targetElement, false);
		addFieldMultilineSender("TEXT", sourceElement, targetElement, false);
		addFieldMultilineSender("NUMBER", sourceElement, targetElement, false);
		addFieldMultilineSender("CURRENCY", sourceElement, targetElement, false);
		addFieldMultilineSender("MULTI LINE TEXT", sourceElement, targetElement, false);
	}

	public void addFieldMultilineSENDERORRECEIVER(String fieldType, WebElement sourceElement, WebElement targetElement,
			boolean isYes) throws Exception {
		Thread.sleep(10000);
		MethodActions.dragAndDrop(sourceElement, targetElement);
		Thread.sleep(10000);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString() + "Multilie");

		if (isYes) {

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement yesElement = wait1.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='Yes']")));
			yesElement.click();

			System.out.println("With Field Required! Yes");
		}

		else {

			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement noElement = wait2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='No']")));
			noElement.click();
			System.out.println("With Field Required! NO");

		}
		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[2]"));
		MethodActions.waitEle(By.xpath("//div[@class='el-select input_type']"));

		switch (fieldType) {
		case "RICH TEXT":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
			Thread.sleep(10000);
			WebElement ListdElementpwd = driver.findElement(By.xpath("//span[text()='PASSWORD']"));
			Assert.assertTrue(ListdElementpwd.isDisplayed(), "List is not selected successfully");
			System.out.println("RICH TEXT  With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "PASSWORD":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
			Thread.sleep(10000);
			WebElement ListdElementemail = driver.findElement(By.xpath("//span[text()='EMAIL']"));
			Assert.assertTrue(ListdElementemail.isDisplayed(), "List is not selected successfully");
			System.out.println("PASSWORD With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "EMAIL":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));
			Thread.sleep(10000);
			WebElement ListdElementTEXT = driver.findElement(By.xpath("//span[text()='TEXT']"));
			Assert.assertTrue(ListdElementTEXT.isDisplayed(), "List is not selected successfully");
			System.out.println("EMAIL With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "TEXT":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[4]"));
			Thread.sleep(10000);
			WebElement ListdElementMASKED = driver.findElement(By.xpath("//span[text()='MASKED']"));
			Assert.assertTrue(ListdElementMASKED.isDisplayed(), "List is not selected successfully");
			System.out.println("TEXT With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "NUMBER":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[5]"));
			Thread.sleep(10000);
			WebElement ListdElementHYPER = driver.findElement(By.xpath("//span[text()='HYPER LINK']"));
			Assert.assertTrue(ListdElementHYPER.isDisplayed(), "List is not selected successfully");
			System.out.println("NUMBER With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "CURRENCY":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[5]"));
			Thread.sleep(10000);
			WebElement ListdElementCURRENCY = driver.findElement(By.xpath("//span[text()='HYPER LINK']"));
			Assert.assertTrue(ListdElementCURRENCY.isDisplayed(), "List is not selected successfully");
			System.out.println("CURRENCY With RECEIVER from Field Type Selected Sucessully ");
			break;
		case "MULTI LINE TEXT":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[5]"));
			Thread.sleep(10000);
			WebElement ListdElementMULTILINETEXT = driver.findElement(By.xpath("//span[text()='HYPER LINK']"));
			Assert.assertTrue(ListdElementMULTILINETEXT.isDisplayed(), "List is not selected successfully");
			System.out.println("MULTI LINE TEXT With RECEIVER from Field Type Selected Sucessully ");
			break;
		default:

			break;
		}
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--primary']"));
	}

	public void MultilineSENDERORRECEIVER() throws Exception {
		Thread.sleep(10000);
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement sourceElement = driver.findElement(By.xpath("//span[text()=\"Multi Line Text\"]"));
		Thread.sleep(10000);
		Actions builder = new Actions(driver);
		MethodActions.waitAndClick(builder, sourceElement, targetElement);
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();

		Thread.sleep(10000);
		// Yes
		addFieldMultilineSender("RICH TEXT", sourceElement, targetElement, true);
		addFieldMultilineSender("EMAIL", sourceElement, targetElement, true);
		addFieldMultilineSender("PASSWORD", sourceElement, targetElement, true);
		addFieldMultilineSender("EMAIL", sourceElement, targetElement, true);
		addFieldMultilineSender("TEXT", sourceElement, targetElement, true);
		addFieldMultilineSender("NUMBER", sourceElement, targetElement, true);
		addFieldMultilineSender("CURRENCY", sourceElement, targetElement, true);
		addFieldMultilineSender("MULTI LINE TEXT", sourceElement, targetElement, true);

		// No
		addFieldMultilineSender("RICH TEXT", sourceElement, targetElement, false);
		addFieldMultilineSender("EMAIL", sourceElement, targetElement, false);
		addFieldMultilineSender("PASSWORD", sourceElement, targetElement, false);
		addFieldMultilineSender("EMAIL", sourceElement, targetElement, false);
		addFieldMultilineSender("TEXT", sourceElement, targetElement, false);
		addFieldMultilineSender("NUMBER", sourceElement, targetElement, false);
		addFieldMultilineSender("CURRENCY", sourceElement, targetElement, false);
		addFieldMultilineSender("MULTI LINE TEXT", sourceElement, targetElement, false);
	}

	public void Select() throws Exception {
		Thread.sleep(10000);
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Select = driver.findElement(By.xpath("//span[text()=\"Select\"]"));
		Thread.sleep(10000);
		Actions builder = new Actions(driver);
		MethodActions.waitAndClick(builder, Select, dropLocation);
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		Thread.sleep(10000);

		MethodActions.waitEle(By.xpath("//div[@class='el-select input_type']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//div[@class='mt-2']//span[@class='el-checkbox__inner']"));
		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

	}

	public void MultipleSelect() throws Exception {
		Thread.sleep(10000);
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement MultipleSelect = driver.findElement(By.xpath("//span[text()=\"Multiple Select\"]"));
		Thread.sleep(10000);
		Actions builder = new Actions(driver);
		MethodActions.waitAndClick(builder, MultipleSelect, dropLocation);
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		Thread.sleep(10000);

		MethodActions.waitEle(By.xpath("//div[@class='el-select input_type']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[2]"));
		MethodActions.waitEle(By.xpath("//div[@class='mt-2']//span[@class='el-checkbox__inner']"));
		MethodActions.waitEle(By.xpath("//div[@class='mt-1']//span[@class='el-checkbox__inner']"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

	}

	public void List() throws Exception {
		Thread.sleep(10000);
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement List = driver.findElement(By.xpath("//span[text()=\"List\"]"));
		Thread.sleep(10000);
		Actions builder = new Actions(driver);
		MethodActions.waitAndClick(builder, List, dropLocation);
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Name']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Value']"), "55");
		MethodActions.waitEle(By.xpath("//button[@class='el-button f-weight-600 el-button--primary']"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

	}

	public void Checkboxgroup() throws Exception {
		Thread.sleep(10000);
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement List = driver.findElement(By.xpath("//span[text()=\"Checkbox Group\"]"));
		Thread.sleep(10000);
		Actions builder = new Actions(driver);
		MethodActions.waitAndClick(builder, List, dropLocation);
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());

		MethodActions.sendKeysToElement(By.xpath("(//input[@max='Infinity'])[1]"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("(//input[@max='Infinity'])[2]"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input']"),
				MethodActions.generateUniqueString());
		driver.findElement(By.xpath("(//input[@max='Infinity'])[1]")).sendKeys("1");
		driver.findElement(By.xpath("(//input[@max='Infinity'])[2]")).sendKeys("4");
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

	}

	public void Radiogroup() throws Exception {
		Thread.sleep(10000);
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement List = driver.findElement(By.xpath("//span[text()=\"Radio Group\"]"));
		Thread.sleep(10000);
		Actions builder = new Actions(driver);
		MethodActions.waitAndClick(builder, List, dropLocation);
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());

		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

	}

	public boolean performAction(String elementXPath, boolean useJavaScriptClick) {
		try {
			Thread.sleep(10000);
			WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
			WebElement element = driver.findElement(By.xpath(elementXPath));
			Thread.sleep(10000);
			Actions builder = new Actions(driver);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
			Thread.sleep(10000);
			if (useJavaScriptClick) {
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				MethodActions.waitAndClick(builder, element, dropLocation);
			}
			Thread.sleep(10000);
			MethodActions.switchToNewWindow();
			MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
					MethodActions.generateUniqueString());
			MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
					MethodActions.generateUniqueString());
			Thread.sleep(10000);

			try {
				MethodActions.waitEle(By.xpath("//div[@class='el-select input_type']"));
				Thread.sleep(10000);
				MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
			} catch (Exception e) {

			}
			try {
				MethodActions.waitEle(By.xpath("//input[@class='el-select__input']"));
				MethodActions.waitEle(By.xpath("//div[@x-placement]//li[5]"));
				MethodActions.waitEle(By.xpath("//div[@class='avatar-uploader']"));
				Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\image.exe\"");

			} catch (Exception e) {

			}

			try {
				MethodActions.waitEle(By.xpath("//input[@class='el-select__input']"));
				MethodActions.waitEle(By.xpath("//div[@x-placement]//li"));

			} catch (Exception e) {

			}
			MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void Multipleactions() throws Exception {

		boolean Number = performAction("//span[text()='Number']", false);
		boolean Date = performAction("//span[text()='Date']", false);
		boolean Time = performAction("//span[text()='Time']", false);
		boolean Fixedtime = performAction("//span[text()='Fixed Time']", false);
		boolean Timerange = performAction("//span[text()='Time Range']", false);
		boolean Datetime = performAction("//span[text()='Date Time']", false);
		boolean Weekdays = performAction("//span[text()='Week Days']", false);
		boolean Datetimerange = performAction("//span[text()='Date Time Range']", false);
		boolean Yes = performAction("//span[text()='Yes or No']", false);
		boolean Document = performAction("//span[text()='Document']", false);
		boolean Radio = performAction("//span[text()='Radio']", false);
		boolean phone = performAction("//span[text()='Phone']", false);
		boolean Signature = performAction("//span[text()='Signature']", false);
		boolean Captcha = performAction("//span[text()='Captcha']", false);

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save']"));
	}

	public void Contentfields() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()=\"Content Fields\"]"));
		Thread.sleep(10000);
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Heading = driver.findElement(By.xpath("//span[text()='Heading']"));
		WebElement HTML = driver.findElement(By.xpath("//span[text()='HTML']"));
		WebElement Paragraph = driver.findElement(By.xpath("//span[text()='Paragraph']"));
		WebElement SingleLineContent = driver.findElement(By.xpath("//span[text()='Single Line Content']"));
		WebElement Image = driver.findElement(By.xpath("//span[text()='Image']"));
		WebElement Video = driver.findElement(By.xpath("//span[text()='Video']"));
		WebElement ActionButton = driver.findElement(By.xpath("//span[text()='Action Button']"));
		WebElement HorizontalLine = driver.findElement(By.xpath("//span[text()='Horizontal Line']"));
		WebElement Division = driver.findElement(By.xpath("//span[text()='Division']"));
		Thread.sleep(10000);
		Actions builder = new Actions(driver);
		MethodActions.waitAndClick(builder, Heading, dropLocation);
		// MethodActions.waitAndClick(builder, HorizontalLine, dropLocation);
		// MethodActions.waitAndClick(builder, Division, dropLocation);
		Thread.sleep(10000);
		// Heading
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter content or block title']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Heading Type']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// HTML
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, HTML, dropLocation);
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter content']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Paragraph
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, Paragraph, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter content']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// SingleLineContent
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, SingleLineContent, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter content']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Image
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, Image, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//div[@class='el-upload__text']"));
		Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\image.exe\"");
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Video
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, Video, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//div[@class='el-upload__text']"));
		Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\image.exe\"");
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Action Button
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, ActionButton, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter label']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Button Type']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--primary el-button--mini']"));
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select type']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[2]"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
		// Division
		MethodActions.waitAndClick(builder, Division, dropLocation);
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save']"));
	}

	public void AdvancedFields() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()=\"Advanced Fields\"]"));
		Thread.sleep(10000);
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		// WebElement AutoIncrementNumber =
		// driver.findElement(By.xpath("//span[text()='Auto Increment Number']"));
		WebElement Location = driver.findElement(By.xpath("//span[text()='Location']"));
		WebElement Currency = driver.findElement(By.xpath("//span[text()='Currency']"));
		WebElement Question = driver.findElement(By.xpath("//span[text()='Question']"));
		// WebElement AuthorizedSignature =
		// driver.findElement(By.xpath("//span[text()='Authorized Signature']"));
		WebElement Entity = driver.findElement(By.xpath("//span[text()='Entity']"));
		WebElement EntityVariable = driver.findElement(By.xpath("//span[text()='Entity Variable']"));
		WebElement Formula = driver.findElement(By.xpath("//span[text()='Formula']"));
		WebElement AggregateFunction = driver.findElement(By.xpath("//span[text()='Aggregate Function']"));
		WebElement DataTable = driver.findElement(By.xpath("//span[text()='Data Table']"));
		WebElement ChildEntityTable = driver.findElement(By.xpath("//span[text()='Child Entity Table']"));
		WebElement PayButtons = driver.findElement(By.xpath("//span[text()='Pay Buttons']"));
		WebElement PaymentVariable = driver.findElement(By.xpath("//span[text()='Payment Variable']"));
		WebElement StarRating = driver.findElement(By.xpath("//span[text()='Star Rating']"));
		WebElement Concatenate = driver.findElement(By.xpath("//span[text()='Concatenate']"));
		WebElement Audio = driver.findElement(By.xpath("//span[text()='Audio']"));
		WebElement QRCode = driver.findElement(By.xpath("//span[text()='QR Code']"));
		WebElement QRReader = driver.findElement(By.xpath("//span[text()='QR Reader']"));
		Thread.sleep(10000);
		Actions builder = new Actions(driver);

		// MethodActions.waitAndClick(builder, AuthorizedSignature, dropLocation);

		// MethodActions.waitAndClick(builder, PayButtons, dropLocation);
		// Auto Increment Number
//		Thread.sleep(10000);
//		MethodActions.waitAndClick(builder, AutoIncrementNumber, dropLocation);
//		MethodActions.switchToNewWindow();
//		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
//				MethodActions.generateUniqueString());
//		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
//				MethodActions.generateUniqueString());
//		Thread.sleep(10000);
//		driver.findElement(By.xpath("//input[@placeholder='Prifix']")).sendKeys("prifix");
//		Thread.sleep(10000);
//		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Location
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, Location, dropLocation);
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("(//span[@class='el-switch__core'])[1]"));
		MethodActions.waitEle(By.xpath("(//span[@class='el-switch__core'])[2]"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Currency
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, Currency, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//input[@id='currencySelect']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[2]"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Question
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, Question, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[1]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.sendKeysToElement(By.xpath("(//input[@class='el-input__inner'])[3]"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("(//textarea[@class='el-textarea__inner'])[1]"),
				MethodActions.generateUniqueString());
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("(//input[@class='el-input__inner'])[4]"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("(//textarea[@class='el-textarea__inner'])[2]"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[text()='Yes']"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Entity
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, Entity, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[normalize-space()='entity-t3']"));
		MethodActions.waitEle(By.xpath("//input[@placeholder='Sorting order']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[7]"));
		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[1]"));
		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[2]"));
		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[3]"));
		WebElement element = driver.findElement(By.xpath("(//span[@class='el-checkbox__inner'])[4]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();
		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[5]"));
		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[6]"));
		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[7]"));
		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[8]"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// EntityVariable
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, EntityVariable, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[3]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li"));
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[4]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//span[text()='ALL FIELDS-EUR']"));
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[3]"));
		MethodActions.waitEle(By.xpath("//input[@placeholder='Field operation']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Formula
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, Formula, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter field title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter description here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Fields']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[4]"));
		MethodActions
				.waitEle(By.xpath("//button[@class='el-button btn-operation el-button--success el-button--mini']"));
		driver.findElement(By.xpath("//input[@placeholder='Enter Number']")).sendKeys("49");
		MethodActions.waitEle(By.xpath("//i[@class='el-icon-plus']"));
		MethodActions.waitEle(By.xpath("//div[@class='el-form-item']//input[@placeholder='Select']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[2]"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// AggregateFunction
		MethodActions.waitAndClick(builder, AggregateFunction, dropLocation);
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Label']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Function Type']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Field Type']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Template']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Data Table
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, DataTable, dropLocation);
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Child Entity Table
		Thread.sleep(10000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ChildEntityTable);
		MethodActions.waitAndClick(builder, ChildEntityTable, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("(//div[@class='el-form-item__content']//input[@placeholder='Select'])[2]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[4]"));
		MethodActions.waitEle(By.xpath("(//div[@class='el-form-item__content']//input[@placeholder='Select'])[3]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[2]"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Add Payment Variable
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, PaymentVariable, dropLocation);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());

		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		try {
			MethodActions.waitEle(By.xpath("(//div[@class='el-form-item__content']//input[@placeholder='Select'])[2]"));
			MethodActions.waitEle(By.xpath("//div[@x-placement]//li[2]"));
		} catch (Exception e) {
			//
		}
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Star Rating
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, StarRating, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Concatenate
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, Concatenate, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Field']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[3]"));
		MethodActions.waitEle(By.xpath("//span[text()=' Add ']"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Audio
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, Audio, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// QR Code
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, QRCode, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// QRReader
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, QRReader, dropLocation);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save']"));

	}

}
