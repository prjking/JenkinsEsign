package Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormTemplate {
	WebDriver driver;
	MethodActions methodActions;
	Login login;
	FormTemplate formTemplate;

	public FormTemplate(WebDriver driver) {
		this.driver = driver;
		methodActions = new MethodActions(driver);
		login = new Login(driver);

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
	public void SingleLine() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));

		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement SingleLine = driver.findElement(By.xpath("//span[text()='Single Line Text']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(SingleLine));

		Dimension dropSize = dropLocation.getSize();

		int targetX = dropLocation.getLocation().getX() + (dropSize.getWidth() / 2);
		int targetY = dropLocation.getLocation().getY() + (dropSize.getHeight() / 2);

		builder.dragAndDropBy(SingleLine, targetX, targetY).perform();

		// Yes

		FieldSingleLine("SENDER", SingleLine, dropLocation, true, "PASSWORD");
		FieldSingleLine("RECEIVER", SingleLine, dropLocation, true, "PASSWORD");
		FieldSingleLine("SENDERORRECEIVER", SingleLine, dropLocation, true, "PASSWORD");

		FieldSingleLine("SENDER", SingleLine, dropLocation, true, "EMAIL");
		FieldSingleLine("RECEIVER", SingleLine, dropLocation, true, "EMAIL");
		FieldSingleLine("SENDERORRECEIVER", SingleLine, dropLocation, true, "EMAIL");

		FieldSingleLine("SENDER", SingleLine, dropLocation, true, "TEXT");
		FieldSingleLine("RECEIVER", SingleLine, dropLocation, true, "TEXT");
		FieldSingleLine("SENDERORRECEIVER", SingleLine, dropLocation, true, "TEXT");

		FieldSingleLine("SENDER", SingleLine, dropLocation, true, "MASKED");
		FieldSingleLine("RECEIVER", SingleLine, dropLocation, true, "MASKED");
		FieldSingleLine("SENDERORRECEIVER", SingleLine, dropLocation, true, "MASKED");

		FieldSingleLine("SENDER", SingleLine, dropLocation, true, "HYPER LINK");
		FieldSingleLine("RECEIVER", SingleLine, dropLocation, true, "HYPER LINK");
		FieldSingleLine("SENDERORRECEIVER", SingleLine, dropLocation, true, "HYPER LINK");

		// No
		FieldSingleLine("SENDER", SingleLine, dropLocation, false, "PASSWORD");
		FieldSingleLine("RECEIVER", SingleLine, dropLocation, false, "PASSWORD");
		FieldSingleLine("SENDERORRECEIVER", SingleLine, dropLocation, false, "PASSWORD");

		FieldSingleLine("SENDER", SingleLine, dropLocation, false, "EMAIL");
		FieldSingleLine("RECEIVER", SingleLine, dropLocation, false, "EMAIL");
		FieldSingleLine("SENDERORRECEIVER", SingleLine, dropLocation, false, "EMAIL");

		FieldSingleLine("SENDER", SingleLine, dropLocation, false, "TEXT");
		FieldSingleLine("RECEIVER", SingleLine, dropLocation, false, "TEXT");
		FieldSingleLine("SENDERORRECEIVER", SingleLine, dropLocation, false, "TEXT");

		FieldSingleLine("SENDER", SingleLine, dropLocation, false, "MASKED");
		FieldSingleLine("RECEIVER", SingleLine, dropLocation, false, "MASKED");
		FieldSingleLine("SENDERORRECEIVER", SingleLine, dropLocation, false, "MASKED");

		FieldSingleLine("SENDER", SingleLine, dropLocation, false, "HYPER LINK");
		FieldSingleLine("RECEIVER", SingleLine, dropLocation, false, "HYPER LINK");
		FieldSingleLine("SENDERORRECEIVER", SingleLine, dropLocation, false, "HYPER LINK");
		driver.close();
	}

	public void FieldSingleLine(String fieldType, WebElement singleline, WebElement targetElement, boolean isYes,
			String field) throws Exception {
		int index;
		String label;
		Thread.sleep(10000);
		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(singleline));
		MethodActions.dragAndDrop(singleline, targetElement);

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
		Wait<WebDriver> wait11 = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		WebElement del = wait11
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='el-select filledby']//input")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);

		Thread.sleep(1000);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		Thread.sleep(1000);

		MethodActions.Javascriptclick(By.xpath("//div[@class='el-select input_type']"));

		switch (field) {
		case "PASSWORD":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[1]"));
			System.out.println("Single Line With PASSWORD " + label + " Selected Successfully");
			break;
		case "EMAIL":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[2]"));
			System.out.println("Single Line With EMAIL " + label + " Selected Successfully");
			break;
		case "TEXT":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[3]"));
			System.out.println("Single Line With TEXT " + label + " Selected Successfully");
			break;
		case "MASKED":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[4]"));
			System.out.println("Single Line With MASKED " + label + " Selected Successfully");
			break;
		case "HYPER LINK":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[5]"));
			System.out.println("Single Line With HYPER LINK " + label + " Selected Successfully");
			break;
		default:

			break;
		}
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--primary']"));
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
		// MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement sourceElement = driver.findElement(By.xpath("//span[text()='Single Line Text']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Point targetLocation = targetElement.getLocation();
		int xOffset = 50;

		int targetX = targetLocation.getX() + xOffset;
		int targetY = targetLocation.getY();

		Actions actions = new Actions(driver);
		actions.clickAndHold(sourceElement).moveToElement(targetElement, targetX, targetY).release().build().perform();

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString() + "Singleline Global Variable");
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		System.out.println("data is fetched To The Global Variables");
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--primary']"));

	}

	public void MultilineGlobalVariable() throws Exception {
		Thread.sleep(10000);
		// MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement sourceElement = driver.findElement(By.xpath("//span[text()='Multi Line Text']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		actions.clickAndHold(sourceElement).moveToElement(targetElement).release().build().perform();
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		MethodActions.sendKeysToElement(By.xpath("//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("data is fetched To The Global Variables");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	public void SelectGlobalVariable() throws Exception {
		Thread.sleep(10000);
		// MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement Select = driver.findElement(By.xpath("//span[text()='Select']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		actions.clickAndHold(Select).moveToElement(targetElement).release().build().perform();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		MethodActions.sendKeysToElement(By.xpath("//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("data is fetched To The Global Variables");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	public void NumberGlobalVariable() throws Exception {
		Thread.sleep(10000);
		// MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement Number = driver.findElement(By.xpath("//span[text()='Number']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		actions.clickAndHold(Number).moveToElement(targetElement).release().build().perform();
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		MethodActions.sendKeysToElement(By.xpath("//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("data is fetched To The Global Variables");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	public void MultipleGlobalVariable() throws Exception {
		Thread.sleep(10000);
		// MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement MultipleSelect = driver.findElement(By.xpath("//span[text()='Multiple Select']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		actions.clickAndHold(MultipleSelect).moveToElement(targetElement).release().build().perform();
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		MethodActions.sendKeysToElement(By.xpath("//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("data is fetched To The Global Variables");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	public void ListGlobalVariable() throws Exception {
		Thread.sleep(10000);
		// MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement List = driver.findElement(By.xpath("//span[text()='List']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		actions.clickAndHold(List).moveToElement(targetElement).release().build().perform();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		MethodActions.sendKeysToElement(By.xpath("//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("data is fetched To The Global Variables");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	public void DateGlobalVariable() throws Exception {
		Thread.sleep(10000);
		// MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement Date = driver.findElement(By.xpath("//span[text()='Date']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		actions.clickAndHold(Date).moveToElement(targetElement).release().build().perform();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		MethodActions.sendKeysToElement(By.xpath("//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("data is fetched To The Global Variables");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	public void TimeGlobalVariable() throws Exception {
		Thread.sleep(10000);
		// MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement Time = driver.findElement(By.xpath("//span[text()='Time']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		actions.clickAndHold(Time).moveToElement(targetElement).release().build().perform();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		MethodActions.sendKeysToElement(By.xpath("//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("data is fetched To The Global Variables");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	public void TimerangeGlobalVariable() throws Exception {
		Thread.sleep(10000);
		// MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement TimeRange = driver.findElement(By.xpath("//span[text()='Time Range']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.clickAndHold(TimeRange).moveToElement(targetElement).release().build().perform();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		MethodActions.waitEle(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("data is fetched To The Global Variables");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	public void WeekDaysGlobalVariable() throws Exception {
		Thread.sleep(10000);
		// MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement WeekDays = driver.findElement(By.xpath("//span[text()='Week Days']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		actions.clickAndHold(WeekDays).moveToElement(targetElement).release().build().perform();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		MethodActions.waitEle(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("data is fetched To The Global Variables");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	public void CheckBoxGroupGlobalVariable() throws Exception {
		Thread.sleep(10000);
		// MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement WeekDays = driver.findElement(By.xpath("//span[text()='Week Days']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.clickAndHold(WeekDays).moveToElement(targetElement).release().build().perform();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		MethodActions.waitEle(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("data is fetched To The Global Variables");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	public void RadioGroupGlobalVariable() throws Exception {
		Thread.sleep(10000);
		// MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement RadioGroup = driver.findElement(By.xpath("//span[text()='Radio Group']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.clickAndHold(RadioGroup).moveToElement(targetElement).release().build().perform();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		MethodActions.waitEle(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("data is fetched To The Global Variables");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	public void CurrencyGlobalVariable() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Currency = driver.findElement(By.xpath("//span[text()=\"Currency\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Currency);
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.clickAndHold(Currency).moveToElement(targetElement).release().build().perform();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		MethodActions.waitEle(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("data is fetched To The Global Variables");
		MethodActions.sendKeysToElement(By.xpath("//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	public void StarRatingGlobalVariable() throws Exception {
		Thread.sleep(10000);
		// MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement StarRating = driver.findElement(By.xpath("//span[text()=\"Star Rating\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", StarRating);
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.clickAndHold(StarRating).moveToElement(targetElement).release().build().perform();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		MethodActions.waitEle(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("data is fetched To The Global Variables");
		MethodActions.sendKeysToElement(By.xpath("//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	public void FixedTimeGlobalVariable() throws Exception {
		Thread.sleep(10000);
		// MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement FixedTime = driver.findElement(By.xpath("//span[text()='Fixed Time']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		actions.clickAndHold(FixedTime).moveToElement(targetElement).release().build().perform();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Global Variable']"));
		MethodActions.sendKeysToElement(By.xpath("//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		System.out.println("data is fetched To The Global Variables");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	public void StyleSettings() throws Exception {
		SinglelineGlobalVariable();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@id='each-field']"));
		MethodActions.waitEle(By.xpath("//div[@class='setting-icon el-row']"));
		MethodActions.waitEle(By.xpath("//div[@id='tab-second']"));
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[3]"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[2]"));
		MethodActions.waitEle(By.xpath("(//span[text()='Border Type']/following::input)[1]"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[3]"));
		System.out.println("Slected Dotted Boredrr Line ");
		MethodActions.waitEle(By.xpath("(//span[text()='Font Size']/following::input)[1]"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[9]"));
		MethodActions.waitEle(By.xpath("//div[@class='el-drawer__container el-drawer__open']"));
		MethodActions.waitEle(By.xpath("//div[@id='each-field']"));
		MethodActions.waitEle(By.xpath("//i[@class='el-icon-copy-document ']"));
		System.out.println("Field duplicating done");

	}

//MultiLine

	public void Multiline() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Multiline = driver.findElement(By.xpath("//span[text()=\"Multi Line Text\"]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Multiline));
		MethodActions.waitAndClick(builder, Multiline, targetElement);
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();

		Thread.sleep(10000);
		// Yes

		FieldMultiline("SENDER", Multiline, targetElement, true, "RICH TEXT");
		FieldMultiline("RECEIVER", Multiline, targetElement, true, "RICH TEXT");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, true, "RICH TEXT");

		FieldMultiline("SENDER", Multiline, targetElement, true, "EMAIL");
		FieldMultiline("RECEIVER", Multiline, targetElement, true, "EMAIL");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, true, "EMAIL");

		FieldMultiline("SENDER", Multiline, targetElement, true, "PASSWORD");
		FieldMultiline("RECEIVER", Multiline, targetElement, true, "PASSWORD");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, true, "PASSWORD");

		FieldMultiline("SENDER", Multiline, targetElement, true, "EMAIL");
		FieldMultiline("RECEIVER", Multiline, targetElement, true, "EMAIL");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, true, "EMAIL");

		FieldMultiline("SENDER", Multiline, targetElement, true, "TEXT");
		FieldMultiline("RECEIVER", Multiline, targetElement, true, "TEXT");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, true, "TEXT");

		FieldMultiline("SENDER", Multiline, targetElement, true, "NUMBER");
		FieldMultiline("RECEIVER", Multiline, targetElement, true, "NUMBER");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, true, "NUMBER");

		FieldMultiline("SENDER", Multiline, targetElement, true, "CURRENCY");
		FieldMultiline("RECEIVER", Multiline, targetElement, true, "CURRENCY");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, true, "CURRENCY");

		FieldMultiline("SENDER", Multiline, targetElement, true, "MULTI LINE TEXT");
		FieldMultiline("RECEIVER", Multiline, targetElement, true, "MULTI LINE TEXT");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, true, "MULTI LINE TEXT");

		// No
		FieldMultiline("SENDER", Multiline, targetElement, false, "RICH TEXT");
		FieldMultiline("RECEIVER", Multiline, targetElement, false, "RICH TEXT");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, false, "RICH TEXT");

		FieldMultiline("SENDER", Multiline, targetElement, false, "EMAIL");
		FieldMultiline("RECEIVER", Multiline, targetElement, false, "EMAIL");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, false, "EMAIL");

		FieldMultiline("SENDER", Multiline, targetElement, false, "PASSWORD");
		FieldMultiline("RECEIVER", Multiline, targetElement, false, "PASSWORD");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, false, "PASSWORD");

		FieldMultiline("SENDER", Multiline, targetElement, false, "EMAIL");
		FieldMultiline("RECEIVER", Multiline, targetElement, false, "EMAIL");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, false, "EMAIL");

		FieldMultiline("SENDER", Multiline, targetElement, false, "TEXT");
		FieldMultiline("RECEIVER", Multiline, targetElement, false, "TEXT");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, false, "TEXT");

		FieldMultiline("SENDER", Multiline, targetElement, false, "NUMBER");
		FieldMultiline("RECEIVER", Multiline, targetElement, false, "NUMBER");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, false, "NUMBER");

		FieldMultiline("SENDER", Multiline, targetElement, false, "CURRENCY");
		FieldMultiline("RECEIVER", Multiline, targetElement, false, "CURRENCY");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, false, "CURRENCY");

		FieldMultiline("SENDER", Multiline, targetElement, false, "MULTI LINE TEXT");
		FieldMultiline("RECEIVER", Multiline, targetElement, false, "MULTI LINE TEXT");
		FieldMultiline("SENDERORRECEIVER", Multiline, targetElement, false, "MULTI LINE TEXT");
		driver.close();
	}

	public void FieldMultiline(String fieldType, WebElement Multiline, WebElement targetElement, boolean isYes,
			String field) throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}

		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Multiline));
		MethodActions.dragAndDrop(Multiline, targetElement);

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
		WebElement del = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);
		Thread.sleep(10000);
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		Thread.sleep(10000);

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.xpath("//div[@class='el-select input_type']")));
		MethodActions.Javascriptclick(By.xpath("//div[@class='el-select input_type']"));

		Thread.sleep(10000);
		int fieldIndex = 0;
		String fieldLabel = null;
		switch (field) {
		case "RICH TEXT":
			fieldIndex = 1;
			fieldLabel = "Multi Line With RICH TEXT";
			break;
		case "PASSWORD":
			fieldIndex = 2;
			fieldLabel = "Multi Line With PASSWORD";
			break;
		case "EMAIL":
			fieldIndex = 3;
			fieldLabel = "Multi Line With EMAIL";
			break;
		case "TEXT":
			fieldIndex = 4;
			fieldLabel = "Multi Line With TEXT";
			break;
		case "NUMBER":
			fieldIndex = 5;
			fieldLabel = "Multi Line With NUMBER";
			break;
		case "CURRENCY":
			fieldIndex = 6;
			fieldLabel = "Multi Line With CURRENCY";
			break;
		case "MULTI LINE TEXT":
			fieldIndex = 7;
			fieldLabel = "Multi Line With MULTI LINE TEXT";
			break;
		default:
			break;
		}

		Thread.sleep(10000);
		Wait<WebDriver> wait1 = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement element1 = wait1.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + fieldIndex + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
		Thread.sleep(10000);
		System.out.println(fieldLabel + " " + label + " Selected Successfully");
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--primary']"));

	}

	// Select
	public void Select() throws Exception {

		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Select = driver.findElement(By.xpath("//span[text()=\"Select\"]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Select));
		Dimension dropSize = targetElement.getSize();

		int targetX = targetElement.getLocation().getX() + (dropSize.getWidth() / 2);
		int targetY = targetElement.getLocation().getY() + (dropSize.getHeight() / 2);

		builder.dragAndDropBy(Select, targetX, targetY).perform();

		Thread.sleep(10000);
		MethodActions.switchToNewWindow();

		// Yes

		FieldSelect("SENDER", Select, targetElement, true, "SELECT");
		FieldSelect("RECEIVER", Select, targetElement, true, "SELECT");
		FieldSelect("SENDERORRECEIVER", Select, targetElement, true, "SELECT");

		FieldSelect("SENDER", Select, targetElement, true, "MULTI SELECT");
		FieldSelect("RECEIVER", Select, targetElement, true, "MULTI SELECT");
		FieldSelect("SENDERORRECEIVER", Select, targetElement, true, "MULTI SELECT");

		// No

		FieldSelect("SENDER", Select, targetElement, false, "SELECT");
		FieldSelect("RECEIVER", Select, targetElement, false, "SELECT");
		FieldSelect("SENDERORRECEIVER", Select, targetElement, false, "SELECT");

		FieldSelect("SENDER", Select, targetElement, false, "MULTI SELECT");
		FieldSelect("RECEIVER", Select, targetElement, false, "MULTI SELECT");
		FieldSelect("SENDERORRECEIVER", Select, targetElement, false, "MULTI SELECT");
		driver.close();

	}

	public void FieldSelect(String fieldType, WebElement Select, WebElement targetElement, boolean isYes, String field)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}

		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Select));
		MethodActions.dragAndDrop(Select, targetElement);

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
				MethodActions.generateUniqueString() + "Add Select");
		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input']"),
				MethodActions.generateUniqueString());
		Thread.sleep(50000);
		MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//li"));

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
		Thread.sleep(10000);
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);
		WebElement element1 = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);

		MethodActions.waitEle(By.xpath("//div[@class='el-select input_type']"));

		switch (field) {
		case "SELECT":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
			Thread.sleep(10000);
			System.out.println("SELECT With " + label + " Selected Successfully");
			break;
		case "MULTI SELECT":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
			Thread.sleep(10000);
			System.out.println("MULTI SELECT With " + label + " Selected Successfully");
			break;
		default:

			break;
		}
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// Number
	public void Number() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Number = driver.findElement(By.xpath("//span[text()=\"Number\"]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Number));

		builder.dragAndDrop(Number, Number).perform();

		Thread.sleep(1000);

		// Yes

		FieldNumber("SENDER", Number, targetElement, true, "NUMBER");
		FieldNumber("RECEIVER", Number, targetElement, true, "PHONE");
		FieldNumber("SENDERORRECEIVER", Number, targetElement, true, "CURRENCY");

		// No
		FieldNumber("SENDER", Number, targetElement, false, "NUMBER");
		FieldNumber("RECEIVER", Number, targetElement, false, "PHONE");
		FieldNumber("SENDERORRECEIVER", Number, targetElement, false, "CURRENCY");
		driver.close();

	}

	public void FieldNumber(String fieldType, WebElement Number, WebElement targetElement, boolean isYes, String field)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Number));
		MethodActions.dragAndDrop(Number, targetElement);

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
				MethodActions.generateUniqueString() + "Add Number");

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

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementnum = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementnum);

		MethodActions.waitEle(By.xpath("//div[@class='el-select input_type']"));

		switch (field) {
		case "NUMBER":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
			Thread.sleep(10000);
			System.out.println("NUMBER With " + label + " Selected Successfully");
			break;
		case "PHONE":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//input[@placeholder=\"Country code\"]"));
			MethodActions.Javascriptclick(By.xpath("//div[text()=' India (भारत) ']"));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait1.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Phone number *']")));
			driver.findElement(By.xpath("//input[@placeholder='Phone number *']")).sendKeys("7894561230");
			Thread.sleep(10000);
			System.out.println("PHONE With " + label + " Selected Successfully");
			break;
		case "CURRENCY":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//input[@id='currencySelect']"));
			MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
			System.out.println("CURRENCY With " + label + " Selected Successfully");
			break;
		default:

			break;
		}
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// Mutltiple Select
	public void MultipleSelect() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement MultipleSelect = driver.findElement(By.xpath("//span[text()=\"Multiple Select\"]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(MultipleSelect));

		Dimension dropSize = targetElement.getSize();

		for (int i = 0; i < 2; i++) {
			int targetX = targetElement.getLocation().getX() + (dropSize.getWidth() / 4);
			int targetY = targetElement.getLocation().getY() + (dropSize.getHeight() / 4);

			builder.dragAndDropBy(MultipleSelect, targetX, targetY).perform();

			Thread.sleep(1000);
		}

		// Yes

		FieldMultipleSelect("SENDER", MultipleSelect, targetElement, true, "SELECT");
		FieldMultipleSelect("RECEIVER", MultipleSelect, targetElement, true, "SELECT");
		FieldMultipleSelect("SENDERORRECEIVER", MultipleSelect, targetElement, true, "SELECT");

		FieldMultipleSelect("SENDER", MultipleSelect, targetElement, true, "MULTI SELECT");
		FieldMultipleSelect("RECEIVER", MultipleSelect, targetElement, true, "MULTI SELECT");
		FieldMultipleSelect("SENDERORRECEIVER", MultipleSelect, targetElement, true, "MULTI SELECT");

		// No
		FieldMultipleSelect("SENDER", MultipleSelect, targetElement, false, "SELECT");
		FieldMultipleSelect("RECEIVER", MultipleSelect, targetElement, false, "SELECT");
		FieldMultipleSelect("SENDERORRECEIVER", MultipleSelect, targetElement, false, "SELECT");

		FieldMultipleSelect("SENDER", MultipleSelect, targetElement, false, "MULTI SELECT");
		FieldMultipleSelect("RECEIVER", MultipleSelect, targetElement, false, "MULTI SELECT");
		FieldMultipleSelect("SENDERORRECEIVER", MultipleSelect, targetElement, false, "MULTI SELECT");
		driver.close();

	}

	public void FieldMultipleSelect(String fieldType, WebElement MultipleSelect, WebElement targetElement,
			boolean isYes, String field) throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(MultipleSelect));
		MethodActions.dragAndDrop(MultipleSelect, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString() + "Add Number");
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@class='mt-2']//span[@class='el-checkbox__inner']"));
		MethodActions.waitEle(By.xpath("//div[@class='mt-1']//span[@class='el-checkbox__inner']"));

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

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);

		MethodActions.waitEle(By.xpath("//div[@class='el-select input_type']"));

		switch (field) {
		case "SELECT":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
			Thread.sleep(10000);
			System.out.println("SELECT With " + label + " Selected Successfully");
			break;
		case "MULTI SELECT":
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
			Thread.sleep(10000);
			System.out.println("MULTI SELECT With " + label + " Selected Successfully");
			break;
		default:

			break;
		}
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// Fixed Time
	public void FixedTime() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement FixedTime = driver.findElement(By.xpath("//span[text()=\"Fixed Time\"]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(FixedTime));

		for (int i = 0; i < 2; i++) {
			builder.dragAndDrop(FixedTime, targetElement).perform();

			Thread.sleep(1000);
		}

		// Yes
		FieldFixedTime("SENDER", FixedTime, targetElement, true);
		FieldFixedTime("RECEIVER", FixedTime, targetElement, true);
		FieldFixedTime("SENDERORRECEIVER", FixedTime, targetElement, true);
		// No
		FieldFixedTime("SENDER", FixedTime, targetElement, false);
		FieldFixedTime("RECEIVER", FixedTime, targetElement, false);
		FieldFixedTime("SENDERORRECEIVER", FixedTime, targetElement, false);
		driver.close();

	}

	public void FieldFixedTime(String fieldType, WebElement FixedTime, WebElement targetElement, boolean isYes)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(FixedTime));
		MethodActions.dragAndDrop(FixedTime, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"(//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text'])[1]"),
				MethodActions.generateUniqueString() + "Fixed Time Range");
		MethodActions.waitEle(
				By.xpath("//div[@class='el-date-editor el-range-editor el-input__inner el-date-editor--timerange']"));
		MethodActions.waitEle(By.xpath("(//div[@class='el-time-spinner has-seconds']//ul//li[text()='05'])[1]"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("(//div[@class='el-time-spinner has-seconds']//ul//li[text()='10'])[4]"));
		MethodActions.waitEle(By.xpath("//button[normalize-space()='OK']"));
		MethodActions.waitEle(By.xpath("//input[@Placeholder='Step time']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[5]"));
		if (isYes)

		{

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

		WebElement del = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementfixedtime = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementfixedtime);
		Thread.sleep(10000);
		System.out.println("TimeRange With " + label + " Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// WeekDays
	public void WeekDays() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement WeekDays = driver.findElement(By.xpath("//span[text()=\"Week Days\"]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(WeekDays));

		for (int i = 0; i < 2; i++) {
			builder.dragAndDrop(WeekDays, targetElement).perform();

			Thread.sleep(1000);
		}

		// Yes
		FieldWeekDays("SENDER", WeekDays, targetElement, true);
		FieldWeekDays("RECEIVER", WeekDays, targetElement, true);
		FieldWeekDays("SENDERORRECEIVER", WeekDays, targetElement, true);
		// No
		FieldWeekDays("SENDER", WeekDays, targetElement, false);
		FieldWeekDays("RECEIVER", WeekDays, targetElement, false);
		FieldWeekDays("SENDERORRECEIVER", WeekDays, targetElement, false);
		driver.close();

	}

	public void FieldWeekDays(String fieldType, WebElement WeekDays, WebElement targetElement, boolean isYes)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(WeekDays));
		MethodActions.dragAndDrop(WeekDays, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"(//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text'])[1]"),
				MethodActions.generateUniqueString() + "Week Days");
		MethodActions.waitEle(By.xpath("//input[@class='el-checkbox__original']"));
		if (isYes)

		{

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

		WebElement del = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementweekdays = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementweekdays);
		Thread.sleep(10000);
		System.out.println("TimeRange With " + label + " Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// Yes or No
	public void YesorNo() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement YesorNo = driver.findElement(By.xpath("//span[text()=\"Yes or No\"]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(YesorNo));
		builder.dragAndDrop(YesorNo, targetElement).perform();

		// Yes
		FieldYesorNo("SENDER", YesorNo, targetElement, true, true);
		FieldYesorNo("RECEIVER", YesorNo, targetElement, true, true);
		FieldYesorNo("SENDERORRECEIVER", YesorNo, targetElement, true, true);
		// No
		FieldYesorNo("SENDER", YesorNo, targetElement, false, false);
		FieldYesorNo("RECEIVER", YesorNo, targetElement, false, false);
		FieldYesorNo("SENDERORRECEIVER", YesorNo, targetElement, false, false);
		driver.close();

	}

	public void FieldYesorNo(String fieldType, WebElement YesorNo, WebElement targetElement, boolean isYes,
			boolean Field) throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(YesorNo));
		MethodActions.dragAndDrop(YesorNo, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());

		if (Field)

		{
			Thread.sleep(1000);
			MethodActions.Javascriptclick(
					By.xpath("//div[@class='form-group']//span[@class='el-radio__label' and text()='YES']"));
			System.out.println("Selectd Default Field YES");
		}

		else {

			Thread.sleep(1000);
			MethodActions.Javascriptclick(
					By.xpath("//div[@class='form-group']//span[@class='el-radio__label' and text()='NO']"));
			System.out.println("Selectd Default Field NO");

		}

		if (isYes)

		{

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

		WebElement del = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementyesorno = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementyesorno);
		Thread.sleep(10000);
		System.out.println("Yes OR No With " + label + " Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// Document
	public void Document() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Document = driver.findElement(By.xpath("//span[text()=\"Document\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Document);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(Document));
		builder.dragAndDrop(Document, targetElement).perform();

		Thread.sleep(10000);

		// Gif

		// Yes and Single
		FieldDocument("SENDER", "Gif", Document, targetElement, true, true);
		FieldDocument("RECEIVER", "Gif", Document, targetElement, true, true);
		FieldDocument("SENDERORRECEIVER", "Gif", Document, targetElement, true, true);
		// Yes and Multiple
		FieldDocument("SENDER", "Gif", Document, targetElement, true, false);
		FieldDocument("RECEIVER", "Gif", Document, targetElement, true, false);
		FieldDocument("SENDERORRECEIVER", "Gif", Document, targetElement, true, false);
		// No and Single
		FieldDocument("SENDER", "Gif", Document, targetElement, false, true);
		FieldDocument("RECEIVER", "Gif", Document, targetElement, false, true);
		FieldDocument("SENDERORRECEIVER", "Gif", Document, targetElement, false, true);
		// No and Multiple
		FieldDocument("SENDER", "Gif", Document, targetElement, false, false);
		FieldDocument("RECEIVER", "Gif", Document, targetElement, false, false);
		FieldDocument("SENDERORRECEIVER", "Gif", Document, targetElement, false, false);

		// JPEG

		// Yes and Single
		FieldDocument("SENDER", "JPEG", Document, targetElement, true, true);
		FieldDocument("RECEIVER", "JPEG", Document, targetElement, true, true);
		FieldDocument("SENDERORRECEIVER", "JPEG", Document, targetElement, true, true);
		// Yes and Multiple
		FieldDocument("SENDER", "JPEG", Document, targetElement, true, false);
		FieldDocument("RECEIVER", "JPEG", Document, targetElement, true, false);
		FieldDocument("SENDERORRECEIVER", "JPEG", Document, targetElement, true, false);
		// No and Single
		FieldDocument("SENDER", "JPEG", Document, targetElement, false, true);
		FieldDocument("RECEIVER", "JPEG", Document, targetElement, false, true);
		FieldDocument("SENDERORRECEIVER", "JPEG", Document, targetElement, false, true);
		// No and Multiple
		FieldDocument("SENDER", "JPEG", Document, targetElement, false, false);
		FieldDocument("RECEIVER", "JPEG", Document, targetElement, false, false);
		FieldDocument("SENDERORRECEIVER", "JPEG", Document, targetElement, false, false);

		// SVG

		// Yes and Single
		FieldDocument("SENDER", "SVG", Document, targetElement, true, true);
		FieldDocument("RECEIVER", "SVG", Document, targetElement, true, true);
		FieldDocument("SENDERORRECEIVER", "SVG", Document, targetElement, true, true);
		// Yes and Multiple
		FieldDocument("SENDER", "SVG", Document, targetElement, true, false);
		FieldDocument("RECEIVER", "SVG", Document, targetElement, true, false);
		FieldDocument("SENDERORRECEIVER", "SVG", Document, targetElement, true, false);
		// No and Single
		FieldDocument("SENDER", "SVG", Document, targetElement, false, true);
		FieldDocument("RECEIVER", "SVG", Document, targetElement, false, true);
		FieldDocument("SENDERORRECEIVER", "SVG", Document, targetElement, false, true);
		// No and Multiple
		FieldDocument("SENDER", "SVG", Document, targetElement, false, false);
		FieldDocument("RECEIVER", "SVG", Document, targetElement, false, false);
		FieldDocument("SENDERORRECEIVER", "SVG", Document, targetElement, false, false);

		// PNG

		// Yes and Single
		FieldDocument("SENDER", "PNG", Document, targetElement, true, true);
		FieldDocument("RECEIVER", "PNG", Document, targetElement, true, true);
		FieldDocument("SENDERORRECEIVER", "PNG", Document, targetElement, true, true);
		// Yes and Multiple
		FieldDocument("SENDER", "PNG", Document, targetElement, true, false);
		FieldDocument("RECEIVER", "PNG", Document, targetElement, true, false);
		FieldDocument("SENDERORRECEIVER", "PNG", Document, targetElement, true, false);
		// No and Single
		FieldDocument("SENDER", "PNG", Document, targetElement, false, true);
		FieldDocument("RECEIVER", "PNG", Document, targetElement, false, true);
		FieldDocument("SENDERORRECEIVER", "PNG", Document, targetElement, false, true);
		// No and Multiple
		FieldDocument("SENDER", "PNG", Document, targetElement, false, false);
		FieldDocument("RECEIVER", "PNG", Document, targetElement, false, false);
		FieldDocument("SENDERORRECEIVER", "PNG", Document, targetElement, false, false);

		// PPT

		// Yes and Single
		FieldDocument("SENDER", "PPT", Document, targetElement, true, true);
		FieldDocument("RECEIVER", "PPT", Document, targetElement, true, true);
		FieldDocument("SENDERORRECEIVER", "PPT", Document, targetElement, true, true);
		// Yes and Multiple
		FieldDocument("SENDER", "PPT", Document, targetElement, true, false);
		FieldDocument("RECEIVER", "PPT", Document, targetElement, true, false);
		FieldDocument("SENDERORRECEIVER", "PPT", Document, targetElement, true, false);
		// No and Single
		FieldDocument("SENDER", "PPT", Document, targetElement, false, true);
		FieldDocument("RECEIVER", "PPT", Document, targetElement, false, true);
		FieldDocument("SENDERORRECEIVER", "PPT", Document, targetElement, false, true);
		// No and Multiple
		FieldDocument("SENDER", "PPT", Document, targetElement, false, false);
		FieldDocument("RECEIVER", "PPT", Document, targetElement, false, false);
		FieldDocument("SENDERORRECEIVER", "PPT", Document, targetElement, false, false);

		// Xls

		// Yes and Single
		FieldDocument("SENDER", "Xls", Document, targetElement, true, true);
		FieldDocument("RECEIVER", "Xls", Document, targetElement, true, true);
		FieldDocument("SENDERORRECEIVER", "Xls", Document, targetElement, true, true);
		// Yes and Multiple
		FieldDocument("SENDER", "Xls", Document, targetElement, true, false);
		FieldDocument("RECEIVER", "Xls", Document, targetElement, true, false);
		FieldDocument("SENDERORRECEIVER", "Xls", Document, targetElement, true, false);
		// No and Single
		FieldDocument("SENDER", "Xls", Document, targetElement, false, true);
		FieldDocument("RECEIVER", "Xls", Document, targetElement, false, true);
		FieldDocument("SENDERORRECEIVER", "Xls", Document, targetElement, false, true);
		// No and Multiple
		FieldDocument("SENDER", "Xls", Document, targetElement, false, false);
		FieldDocument("RECEIVER", "Xls", Document, targetElement, false, false);
		FieldDocument("SENDERORRECEIVER", "Xls", Document, targetElement, false, false);

		// pdf

		// Yes and Single
		FieldDocument("SENDER", "pdf", Document, targetElement, true, true);
		FieldDocument("RECEIVER", "pdf", Document, targetElement, true, true);
		FieldDocument("SENDERORRECEIVER", "pdf", Document, targetElement, true, true);
		// Yes and Multiple
		FieldDocument("SENDER", "pdf", Document, targetElement, true, false);
		FieldDocument("RECEIVER", "pdf", Document, targetElement, true, false);
		FieldDocument("SENDERORRECEIVER", "pdf", Document, targetElement, true, false);
		// No and Single
		FieldDocument("SENDER", "pdf", Document, targetElement, false, true);
		FieldDocument("RECEIVER", "pdf", Document, targetElement, false, true);
		FieldDocument("SENDERORRECEIVER", "pdf", Document, targetElement, false, true);
		// No and Multiple
		FieldDocument("SENDER", "pdf", Document, targetElement, false, false);
		FieldDocument("RECEIVER", "pdf", Document, targetElement, false, false);
		FieldDocument("SENDERORRECEIVER", "pdf", Document, targetElement, false, false);

		// Doc

		// Yes and Single
		FieldDocument("SENDER", "Doc", Document, targetElement, true, true);
		FieldDocument("RECEIVER", "Doc", Document, targetElement, true, true);
		FieldDocument("SENDERORRECEIVER", "Doc", Document, targetElement, true, true);
		// Yes and Multiple
		FieldDocument("SENDER", "Doc", Document, targetElement, true, false);
		FieldDocument("RECEIVER", "Doc", Document, targetElement, true, false);
		FieldDocument("SENDERORRECEIVER", "Doc", Document, targetElement, true, false);
		// No and Single
		FieldDocument("SENDER", "Doc", Document, targetElement, false, true);
		FieldDocument("RECEIVER", "Doc", Document, targetElement, false, true);
		FieldDocument("SENDERORRECEIVER", "Doc", Document, targetElement, false, true);
		// No and Multiple
		FieldDocument("SENDER", "Doc", Document, targetElement, false, false);
		FieldDocument("RECEIVER", "Doc", Document, targetElement, false, false);
		FieldDocument("SENDERORRECEIVER", "Doc", Document, targetElement, false, false);
		driver.close();

	}

	@SuppressWarnings("deprecation")
	public void FieldDocument(String fieldType, String field, WebElement Document, WebElement targetElement,
			boolean isYes, boolean type) throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Document));
		MethodActions.dragAndDrop(Document, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		if (isYes)

		{

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
		if (type)

		{

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement yesElement = wait1.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='Single']")));
			yesElement.click();

			System.out.println("Upload Type! Single");
		}

		else {

			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement noElement = wait2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='Multiple']")));
			noElement.click();
			System.out.println("Upload Type! Multiple");
			MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Minium Files To upload']"), "1");
			MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Maximum Files To upload']"), "3");

		}
		Thread.sleep(10000);

		WebElement del = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementdocument = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementdocument);

		MethodActions.Javascriptclick(By.xpath("//input[@class='el-select__input']"));

		switch (field) {
		case "Gif":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[1]"));
			try {
				MethodActions.waitEle(By.xpath("//div[@class=\"el-upload el-upload--text\"]"));
				Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\excel.exe\"");
			} catch (Exception e) {
				System.out.println("RECEIVER Side Attachment Issue Not Solved ");
			}

			System.out.println("Document  With Gif " + label + " Selected Successfully");
			break;
		case "JPEG":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[2]"));
			try {
				MethodActions.Javascriptclick(By.xpath("//div[@class=\"el-upload el-upload--text\"]"));
				Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\excel.exe\"");
			} catch (Exception e) {
				System.out.println("RECEIVER Side Attachment Issue Not Solved ");
			}
			System.out.println("Document With JPEG " + label + " Selected Successfully");
			break;
		case "SVG":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[3]"));
			try {
				MethodActions.Javascriptclick(By.xpath("//div[@class=\"el-upload el-upload--text\"]"));
				Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\excel.exe\"");
			} catch (Exception e) {
				System.out.println("RECEIVER Side Attachment Issue Not Solved ");
			}
			System.out.println("Document With SVG " + label + " Selected Successfully");
			break;
		case "PNG":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[4]"));
			try {
				MethodActions.Javascriptclick(By.xpath("//div[@class=\"el-upload el-upload--text\"]"));
				Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\excel.exe\"");
			} catch (Exception e) {
				System.out.println("RECEIVER Side Attachment Issue Not Solved ");
			}
			System.out.println("Document With PNG " + label + " Selected Successfully");
			break;
		case "PPT":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[5]"));
			try {
				MethodActions.Javascriptclick(By.xpath("//div[@class=\"el-upload el-upload--text\"]"));
				Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\excel.exe\"");
			} catch (Exception e) {
				System.out.println("RECEIVER Side Attachment Issue Not Solved ");
			}
			System.out.println("Document With PPT " + label + " Selected Successfully");
			break;
		case "Xls":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[6]"));
			try {
				MethodActions.Javascriptclick(By.xpath("//div[@class=\"el-upload el-upload--text\"]"));
				Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\excel.exe\"");
			} catch (Exception e) {
				System.out.println("RECEIVER Side Attachment Issue Not Solved ");
			}
			System.out.println("Document With Xls " + label + " Selected Successfully");
			break;
		case "pdf":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[7]"));
			try {
				MethodActions.Javascriptclick(By.xpath("//div[@class=\"el-upload el-upload--text\"]"));
				Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\excel.exe\"");
			} catch (Exception e) {
				System.out.println("RECEIVER Side Attachment Issue Not Solved ");
			}
			System.out.println("Document With pdf " + label + " Selected Successfully");
			break;
		case "Doc":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[8]"));
			try {
				MethodActions.Javascriptclick(By.xpath("//div[@class=\"el-upload el-upload--text\"]"));
				Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\excel.exe\"");
			} catch (Exception e) {
				System.out.println("RECEIVER Side Attachment Issue Not Solved ");
			}
			System.out.println("Document With Doc " + label + " Selected Successfully");
			break;
		case "DocX":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[9]"));
			try {
				MethodActions.Javascriptclick(By.xpath("//div[@class=\"el-upload el-upload--text\"]"));
				Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\excel.exe\"");
			} catch (Exception e) {
				System.out.println("RECEIVER Side Attachment Issue Not Solved ");
			}
			System.out.println("Document With DocX " + label + " Selected Successfully");
			break;
		case "XlsX":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[10]"));
			try {
				MethodActions.Javascriptclick(By.xpath("//div[@class=\"el-upload el-upload--text\"]"));
				Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\excel.exe\"");
			} catch (Exception e) {
				System.out.println("RECEIVER Side Attachment Issue Not Solved ");
			}
			System.out.println("Document With XlsX " + label + " Selected Successfully");
			break;
		case "CSV":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[11]"));
			try {
				MethodActions.Javascriptclick(By.xpath("//div[@class=\"el-upload el-upload--text\"]"));
				Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\excel.exe\"");
			} catch (Exception e) {
				System.out.println("RECEIVER Side Attachment Issue Not Solved ");
			}
			System.out.println("Document With CSV " + label + " Selected Successfully");
			break;
		default:
			break;
		}

		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	// Time
	public void Time() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Time = driver.findElement(By.xpath("//span[text()=\"Time\"]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Time));

		Dimension dropSize = targetElement.getSize();

		for (int i = 0; i < 2; i++) {
			int targetX = targetElement.getLocation().getX() + (dropSize.getWidth() / 4);
			int targetY = targetElement.getLocation().getY() + (dropSize.getHeight() / 8);

			builder.dragAndDropBy(Time, targetX, targetY).perform();

			Thread.sleep(1000);
		}

		// Yes
		addFieldTime("SENDER", Time, targetElement, true);
		addFieldTime("RECEIVER", Time, targetElement, true);
		addFieldTime("SENDERORRECEIVER", Time, targetElement, true);
		// No
		addFieldTime("SENDER", Time, targetElement, false);
		addFieldTime("RECEIVER", Time, targetElement, false);
		addFieldTime("SENDERORRECEIVER", Time, targetElement, false);
		driver.close();

	}

	public void addFieldTime(String fieldType, WebElement Time, WebElement targetElement, boolean isYes)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);
		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Time));
		MethodActions.dragAndDrop(Time, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString() + "Time");
		Thread.sleep(10000);

		if (isYes)

		{

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

		WebElement del = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementtime = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementtime);
		Thread.sleep(10000);
		System.out.println("Time With " + label + " Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// Date
	public void Date() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Date = driver.findElement(By.xpath("//span[text()=\"Date\"]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Date));

		Dimension dropSize = dropLocation.getSize();

		for (int i = 0; i < 2; i++) {
			int targetX = dropLocation.getLocation().getX() + (dropSize.getWidth() / 4);
			int targetY = dropLocation.getLocation().getY() + (dropSize.getHeight() / 4);

			builder.dragAndDropBy(dropLocation, targetX, targetY).perform();

			Thread.sleep(1000);
		}

		// Yes
		FieldDate("SENDER", Date, dropLocation, true, "DATE");
		FieldDate("RECEIVER", Date, dropLocation, true, "DATE");
		FieldDate("SENDERORRECEIVER", Date, dropLocation, true, "DATE");

		FieldDate("SENDER", Date, dropLocation, true, "TIME");
		FieldDate("RECEIVER", Date, dropLocation, true, "TIME");
		FieldDate("SENDERORRECEIVER", Date, dropLocation, true, "TIME");

		FieldDate("SENDER", Date, dropLocation, true, "DATE TIME");
		FieldDate("RECEIVER", Date, dropLocation, true, "DATE TIME");
		FieldDate("SENDERORRECEIVER", Date, dropLocation, true, "DATE TIME");

		FieldDate("SENDER", Date, dropLocation, true, "DATE RANGE");
		FieldDate("RECEIVER", Date, dropLocation, true, "DATE RANGE");
		FieldDate("SENDERORRECEIVER", Date, dropLocation, true, "DATE RANGE");

		// No
		FieldDate("SENDER", Date, dropLocation, false, "DATE");
		FieldDate("RECEIVER", Date, dropLocation, false, "DATE");
		FieldDate("SENDERORRECEIVER", Date, dropLocation, false, "DATE");

		FieldDate("SENDER", Date, dropLocation, false, "TIME");
		FieldDate("RECEIVER", Date, dropLocation, false, "TIME");
		FieldDate("SENDERORRECEIVER", Date, dropLocation, false, "TIME");

		FieldDate("SENDER", Date, dropLocation, false, "DATE TIME");
		FieldDate("RECEIVER", Date, dropLocation, false, "DATE TIME");
		FieldDate("SENDERORRECEIVER", Date, dropLocation, false, "DATE TIME");

		FieldDate("SENDER", Date, dropLocation, false, "DATE RANGE");
		FieldDate("RECEIVER", Date, dropLocation, false, "DATE RANGE");
		FieldDate("SENDERORRECEIVER", Date, dropLocation, false, "DATE RANGE");
		driver.close();

	}

	public void FieldDate(String fieldType, WebElement Date, WebElement targetElement, boolean isYes, String field)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Date));
		MethodActions.dragAndDrop(Date, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString() + "Date");
		Thread.sleep(10000);
		if (isYes)

		{

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

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementdate = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementdate);
		MethodActions.Javascriptclick(By.xpath("//div[@class='el-select input_type']"));

		switch (field) {
		case "DATE":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[1]"));
			Thread.sleep(10000);
			System.out.println("DATE  With " + label + " from Field Type Selected Sucessully ");
			break;
		case "TIME":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[2]"));
			Thread.sleep(10000);
			System.out.println("TIME With " + label + " from Field Type Selected Sucessully ");
			break;
		case "DATE TIME":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[3]"));
			Thread.sleep(10000);
			System.out.println("DATE TIME With " + label + " from Field Type Selected Sucessully ");
			break;
		case "DATE TIME RANGE":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[4]"));
			Thread.sleep(10000);
			System.out.println("DATE TIME RANGE With " + label + " from Field Type Selected Sucessully ");
			break;
		case "DATE RANGE":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[5]"));
			Thread.sleep(10000);
			System.out.println("DATE RANGE With " + label + " from Field Type Selected Sucessully ");
			break;
		default:

			break;
		}
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--primary']"));
	}

	// List
	public void List() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement List = driver.findElement(By.xpath("//span[text()=\"List\"]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(List));

		Dimension dropSize = targetElement.getSize();

		for (int i = 0; i < 2; i++) {
			int targetX = targetElement.getLocation().getX() + (dropSize.getWidth() / 4);
			int targetY = targetElement.getLocation().getY() + (dropSize.getHeight() / 4);

			builder.dragAndDropBy(List, targetX, targetY).perform();

			Thread.sleep(1000);
		}

		// Yes
		FieldList("SENDER", List, targetElement, true);
		FieldList("RECEIVER", List, targetElement, true);
		FieldList("SENDERORRECEIVER", List, targetElement, true);

		// No
		FieldList("SENDER", List, targetElement, false);
		FieldList("RECEIVER", List, targetElement, false);
		FieldList("SENDERORRECEIVER", List, targetElement, false);
		driver.close();
	}

	public void FieldList(String fieldType, WebElement List, WebElement targetElement, boolean isYes) throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(List));
		MethodActions.dragAndDrop(List, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString() + "List");
		MethodActions.waitEle(By.xpath("//span[@class='el-checkbox__inner']"));
		Thread.sleep(10000);
		for (int i = 0; i < 2; i++) {
			MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Name']"),
					MethodActions.generateUniqueString());
			MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Value']"), "55");
			System.out.println("List Items Data added");
			MethodActions.waitEle(By.xpath("//button[@class='el-button f-weight-600 el-button--primary']"));

		}
		Thread.sleep(10000);

		WebElement element = driver
				.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']/table//tr[2]/td[3]//i"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();

		System.out.println("List Items Data Deleted");

		if (isYes)

		{

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

		WebElement del = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);

		Wait<WebDriver> wait1 = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementlist = wait1.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementlist);
		Thread.sleep(10000);
		System.out.println("List With " + label + " Selected Successfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// Time Range
	public void Timerange() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement TimeRange = driver.findElement(By.xpath("//span[text()=\"Time Range\"]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(TimeRange));

		builder.dragAndDrop(TimeRange, targetElement).perform();

		Thread.sleep(1000);

		// Yes
		FieldTimerange(TimeRange, targetElement, true, "SENDER");
		FieldTimerange(TimeRange, targetElement, true, "RECEIVER");
		FieldTimerange(TimeRange, targetElement, true, "SENDERORRECEIVER");

		// No
		FieldTimerange(TimeRange, targetElement, false, "SENDER");
		FieldTimerange(TimeRange, targetElement, false, "RECEIVER");
		FieldTimerange(TimeRange, targetElement, false, "SENDERORRECEIVER");
		driver.close();

	}

	public void FieldTimerange(WebElement TimeRange, WebElement targetElement, boolean isYes, String fieldType)
			throws Exception {
		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}

		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(TimeRange));
		MethodActions.dragAndDrop(TimeRange, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}

		if (isYes) {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement yesElement = wait1.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='Yes']")));
			yesElement.click();
			System.out.println("With Field Required! Yes");
		} else {
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement noElement = wait2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//span[@class='el-radio__label' and text()='No']")));
			noElement.click();
			System.out.println("With Field Required! NO");
		}

		Thread.sleep(10000);
		WebElement del = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementtimerange = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementtimerange);
		Thread.sleep(10000);
		System.out.println("Time Range With " + label + " Selected Successfully");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"(//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text'])[1]"),
				MethodActions.generateUniqueString() + "Time Range");
		MethodActions.sendKeysToElement(By.xpath(
				"(//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text'])[2]"),
				MethodActions.generateUniqueString());

		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// Check Box
	public void CheckBox() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Checkbox = driver.findElement(By.xpath("//span[text()=\"Checkbox\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Checkbox);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(Checkbox));
		builder.dragAndDrop(Checkbox, targetElement).perform();
		Thread.sleep(1000);

		// Yes
		FieldCheckbox("SENDER", Checkbox, targetElement, true);
		FieldCheckbox("RECEIVER", Checkbox, targetElement, true);
		FieldCheckbox("SENDERORRECEIVER", Checkbox, targetElement, true);
		// No
		FieldCheckbox("SENDER", Checkbox, targetElement, false);
		FieldCheckbox("RECEIVER", Checkbox, targetElement, false);
		FieldCheckbox("SENDERORRECEIVER", Checkbox, targetElement, false);
		driver.close();
	}

	public void FieldCheckbox(String fieldType, WebElement Checkbox, WebElement targetElement, boolean isYes)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Checkbox));
		MethodActions.dragAndDrop(Checkbox, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		if (isYes)

		{

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

		WebElement del = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementcheck = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementcheck);

		Thread.sleep(10000);

		System.out.println("CheckBox With " + label + " Selected Sucessfully");
//		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[2]"));
//		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter content']"),
//				MethodActions.generateUniqueString());

		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// Check Box
	public void CheckBoxGroup() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement CheckboxGroup = driver.findElement(By.xpath("//span[text()=\"Checkbox Group\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CheckboxGroup);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(CheckboxGroup));
		builder.dragAndDrop(CheckboxGroup, targetElement).perform();
		Thread.sleep(1000);

		// Yes
		FieldCheckBoxGroup("SENDER", CheckboxGroup, targetElement);
		FieldCheckBoxGroup("RECEIVER", CheckboxGroup, targetElement);
		FieldCheckBoxGroup("SENDERORRECEIVER", CheckboxGroup, targetElement);
		driver.close();

	}

	public void FieldCheckBoxGroup(String fieldType, WebElement CheckboxGroup, WebElement targetElement)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(CheckboxGroup));
		MethodActions.dragAndDrop(CheckboxGroup, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		Thread.sleep(10000);
		WebElement del = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementcheckbox = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementcheckbox);
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("(//input[@aria-valuemax='Infinity'])[1]"));
		MethodActions.sendKeysToElement(By.xpath("(//input[@aria-valuemax='Infinity'])[1]"), "3");
		int i = 3;
		for (i = 0; i < 3; i++) {
			MethodActions.waitEle(By.xpath("(//span[@class='el-input-number__increase'])[2]"));
		}
		MethodActions.sendKeysToElement(
				By.xpath("//textarea[@placeholder='Please enter a custom notification message.']"), "invalid details");
		// MethodActions.waitEle(By.xpath("//span[@class='el-checkbox__inner']"));
		MethodActions.waitEle(By.xpath("//span[@class='el-switch__core']"));
		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li"));
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
		System.out.println("CheckBox Group With " + label + " Selected Sucessfully");

	}

	// Radio
	public void Radio() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Radio = driver.findElement(By.xpath("//span[text()=\"Radio\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Radio);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(Radio));
		builder.dragAndDrop(Radio, targetElement).perform();
		Thread.sleep(1000);

		// Yes
		FieldRadio("SENDER", Radio, targetElement, true);
		FieldRadio("RECEIVER", Radio, targetElement, true);
		FieldRadio("SENDERORRECEIVER", Radio, targetElement, true);
		// No
		FieldRadio("SENDER", Radio, targetElement, false);
		FieldRadio("RECEIVER", Radio, targetElement, false);
		FieldRadio("SENDERORRECEIVER", Radio, targetElement, false);
		driver.close();

	}

	public void FieldRadio(String fieldType, WebElement Radio, WebElement targetElement, boolean isYes)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Radio));
		MethodActions.dragAndDrop(Radio, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		if (isYes)

		{

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

		WebElement del = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementradio = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementradio);

		Thread.sleep(10000);

		System.out.println("Radio With " + label + " Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// Radio Group
	public void RadioGroup() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement RadioGroup = driver.findElement(By.xpath("//span[text()=\"Radio Group\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", RadioGroup);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(RadioGroup));
		builder.dragAndDrop(RadioGroup, targetElement).perform();
		Thread.sleep(1000);

		// Yes
		FieldRadioGroup("SENDER", RadioGroup, targetElement, true);
		FieldRadioGroup("RECEIVER", RadioGroup, targetElement, true);
		FieldRadioGroup("SENDERORRECEIVER", RadioGroup, targetElement, true);
		// No
		FieldRadioGroup("SENDER", RadioGroup, targetElement, false);
		FieldRadioGroup("RECEIVER", RadioGroup, targetElement, false);
		FieldRadioGroup("SENDERORRECEIVER", RadioGroup, targetElement, false);
		driver.close();

	}

	public void FieldRadioGroup(String fieldType, WebElement RadioGroup, WebElement targetElement, boolean isYes)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(RadioGroup));
		MethodActions.dragAndDrop(RadioGroup, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		if (isYes)

		{

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

		WebElement del = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementradiogroup = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementradiogroup);
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input']"),
				MethodActions.generateUniqueString());
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li"));
		MethodActions.waitEle(By.xpath("//span[@class='el-switch__core']"));
		System.out.println("Horizontal View Selected");
		MethodActions.waitEle(By.xpath("//span[@aria-hidden='true']"));
		System.out.println("Vertical View Selected");
		System.out.println("Radio With " + label + " Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));

	}

	// Phone
	public void Phone() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Phone = driver.findElement(By.xpath("//span[text()=\"Phone\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Phone);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Phone));

		Dimension dropSize = dropLocation.getSize();

		for (int i = 0; i < 2; i++) {
			int targetX = dropLocation.getLocation().getX() + (dropSize.getWidth() / 4);
			int targetY = dropLocation.getLocation().getY() + (dropSize.getHeight() / 4);

			builder.dragAndDropBy(dropLocation, targetX, targetY).perform();

			Thread.sleep(1000);
		}

		// Yes
		FieldPhone("SENDER", Phone, dropLocation, true, "NUMBER");
		FieldPhone("RECEIVER", Phone, dropLocation, true, "NUMBER");
		FieldPhone("SENDERORRECEIVER", Phone, dropLocation, true, "NUMBER");

		FieldPhone("SENDER", Phone, dropLocation, true, "PHONE");
		FieldPhone("RECEIVER", Phone, dropLocation, true, "PHONE");
		FieldPhone("SENDERORRECEIVER", Phone, dropLocation, true, "PHONE");

		FieldPhone("SENDER", Phone, dropLocation, true, "CURRENCY");
		FieldPhone("RECEIVER", Phone, dropLocation, true, "CURRENCY");
		FieldPhone("SENDERORRECEIVER", Phone, dropLocation, true, "CURRENCY");

		// No
		FieldPhone("SENDER", Phone, dropLocation, false, "NUMBER");
		FieldPhone("RECEIVER", Phone, dropLocation, false, "NUMBER");
		FieldPhone("SENDERORRECEIVER", Phone, dropLocation, false, "NUMBER");

		FieldPhone("SENDER", Phone, dropLocation, false, "PHONE");
		FieldPhone("RECEIVER", Phone, dropLocation, false, "PHONE");
		FieldPhone("SENDERORRECEIVER", Phone, dropLocation, false, "PHONE");

		FieldPhone("SENDER", Phone, dropLocation, false, "CURRENCY");
		FieldPhone("RECEIVER", Phone, dropLocation, false, "CURRENCY");
		FieldPhone("SENDERORRECEIVER", Phone, dropLocation, false, "CURRENCY");
		driver.close();

	}

	public void FieldPhone(String fieldType, WebElement Phone, WebElement targetElement, boolean isYes, String field)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Phone));
		MethodActions.dragAndDrop(Phone, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString() + "Phone");
		Thread.sleep(10000);
		if (isYes)

		{

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

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		MethodActions.Javascriptclick(By.xpath("//div[@class='el-select input_type']"));

		switch (field) {
		case "NUMBER":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[1]"));
			Thread.sleep(10000);
			System.out.println("NUMBER  With " + label + " from Field Type Selected Sucessully ");
			break;
		case "PHONE":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[2]"));
			Thread.sleep(10000);
//			MethodActions.Javascriptclick(By.xpath("//input[@placeholder='Country code']"));
//			Thread.sleep(10000);
//			MethodActions.waitEle(By.xpath("//div[text()=' Sweden (Sverige) ']"));
//			Thread.sleep(10000);
			MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Phone number *']"), "1236549");
			System.out.println("PHONE With " + label + " from Field Type Selected Sucessully ");
			break;
		case "CURRENCY":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[3]"));
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//input[@id='currencySelect']"));
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//li[3]"));
			System.out.println("CURRENCY  With " + label + " from Field Type Selected Sucessully ");
			break;
		default:
			break;
		}
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--primary']"));
	}

	// Signature
	public void Signature() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Signature = driver.findElement(By.xpath("//span[text()=\"Signature\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Signature);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Signature));
		builder.dragAndDrop(Signature, targetElement).perform();
		Thread.sleep(1000);

		// Yes
		FieldSignature("SENDER", Signature, targetElement, true);
		FieldSignature("RECEIVER", Signature, targetElement, true);
		FieldSignature("SENDERORRECEIVER", Signature, targetElement, true);
		// No
		FieldSignature("SENDER", Signature, targetElement, false);
		FieldSignature("RECEIVER", Signature, targetElement, false);
		FieldSignature("SENDERORRECEIVER", Signature, targetElement, false);
		driver.close();

	}

	public void FieldSignature(String fieldType, WebElement Signature, WebElement targetElement, boolean isYes)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Signature));
		MethodActions.dragAndDrop(Signature, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		if (isYes)

		{

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

		WebElement del = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);

		Thread.sleep(10000);
		if (index == 1) {
			Thread.sleep(10000);
			WebElement canvas = driver.findElement(By.xpath(
					"//canvas[@width='1035' and @style='width: 100%; height: 300px; touch-action: none;' and @height='300']"));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", canvas);

			MethodActions.waitEle(By.xpath(
					"//canvas[@width='1035' and @style='width: 100%; height: 300px; touch-action: none;' and @height='300']"));
			Actions act = new Actions(driver);
			Thread.sleep(10000);
			act.clickAndHold(driver.findElement(By.xpath(
					"//canvas[@width='1035' and @style='width: 100%; height: 300px; touch-action: none;' and @height='300']")))
					.moveToElement(driver.findElement(By.xpath(
							"//canvas[@width='1035' and @style='width: 100%; height: 300px; touch-action: none;' and @height='300']")))
					.moveByOffset(10, 10).moveByOffset(0, 50).moveByOffset(0, -50).moveByOffset(20, 50)
					.moveByOffset(30, -30).moveByOffset(-30, 30).moveByOffset(20, 0).moveByOffset(-20, -30).release()
					.build().perform();
		}

		System.out.println("Signature With " + label + " Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// Captcha
	public void Captcha() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Captcha = driver.findElement(By.xpath("//span[text()=\"Captcha\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Captcha);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(Captcha));
		builder.dragAndDrop(Captcha, targetElement).perform();
		Thread.sleep(1000);
		try {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, Captcha, targetElement);
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		System.out.println("Captch Field Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
		driver.close();

	}

	// Content Fields
	// Heading
	public void Heading() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Content Fields']"));
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Heading = driver.findElement(By.xpath("//span[text()=\"Heading\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Heading);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Heading));

		Dimension dropSize = dropLocation.getSize();

		for (int i = 0; i < 2; i++) {
			int targetX = dropLocation.getLocation().getX() + (dropSize.getWidth() / 2);
			int targetY = dropLocation.getLocation().getY() + (dropSize.getHeight() / 2);

			builder.dragAndDropBy(dropLocation, targetX, targetY).perform();

			Thread.sleep(1000);
		}

		// Yes
		FieldHeading("H1", Heading, dropLocation);
		FieldHeading("H2", Heading, dropLocation);
		FieldHeading("H3", Heading, dropLocation);
		FieldHeading("H4", Heading, dropLocation);
		FieldHeading("H5", Heading, dropLocation);
		FieldHeading("H6", Heading, dropLocation);
		driver.close();

	}

	public void FieldHeading(String fieldType, WebElement Phone, WebElement targetElement) throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "H1":
			index = 1;
			label = "H1";
			break;
		case "H2":
			index = 2;
			label = "H2";
			break;
		case "H3":
			index = 3;
			label = "H3";
			break;
		case "H4":
			index = 1;
			label = "H4";
			break;
		case "H5":
			index = 2;
			label = "H5";
			break;
		case "H6":
			index = 3;
			label = "H6";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Phone));
		MethodActions.dragAndDrop(Phone, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter content or block title']"),
				MethodActions.generateUniqueString());

		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//input[@placeholder='Select Heading Type']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		System.out.println("Heading With " + label + " Selected Successfully");
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--primary']"));
	}

	// HTML
	public void HTML() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Content Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement HTML = driver.findElement(By.xpath("//span[text()=\"HTML\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", HTML);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(HTML));
		builder.dragAndDrop(HTML, targetElement).perform();
		Thread.sleep(1000);
		try {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, HTML, targetElement);
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter content']"),
				MethodActions.generateUniqueString());
		System.out.println("Html Field Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
		driver.close();

	}

	// Paragraph
	public void Paragraph() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Content Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Paragraph = driver.findElement(By.xpath("//span[text()=\"Paragraph\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Paragraph);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(Paragraph));
		builder.dragAndDrop(Paragraph, targetElement).perform();
		Thread.sleep(1000);
		try {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, Paragraph, targetElement);
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter content']"),
				MethodActions.generateUniqueString());
		System.out.println("Captch Field Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
		driver.close();

	}
	// Add Single Line Content

	public void SingleLineContent() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Content Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement SingleLineContent = driver.findElement(By.xpath("//span[text()=\"Single Line Content\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SingleLineContent);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(SingleLineContent));
		builder.dragAndDrop(SingleLineContent, targetElement).perform();
		Thread.sleep(1000);
		try {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, SingleLineContent, targetElement);
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter content']"),
				MethodActions.generateUniqueString());
		System.out.println("Captch Field Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
		driver.close();

	}
	// Image

	public void Image() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Content Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Image = driver.findElement(By.xpath("//span[text()=\"Image\"]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Image));
		builder.dragAndDrop(Image, targetElement).perform();

		// Yes
		Fieldimage("SENDER", Image, targetElement, true, true);
		Fieldimage("RECEIVER", Image, targetElement, true, true);
		Fieldimage("SENDERORRECEIVER", Image, targetElement, true, true);
		// No
		Fieldimage("SENDER", Image, targetElement, false, false);
		Fieldimage("RECEIVER", Image, targetElement, false, false);
		Fieldimage("SENDERORRECEIVER", Image, targetElement, false, false);
		driver.close();

	}

	@SuppressWarnings("deprecation")
	public void Fieldimage(String fieldType, WebElement YesorNo, WebElement targetElement, boolean isYes, boolean Field)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(YesorNo));
		MethodActions.dragAndDrop(YesorNo, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());

		if (Field)

		{
			Thread.sleep(1000);
			MethodActions.Javascriptclick(
					By.xpath("//div[@class='form-group']//span[@class='el-radio__label' and text()='Yes']"));
			System.out.println("Field Required! Yes");
		}

		else {

			Thread.sleep(1000);
			MethodActions.Javascriptclick(
					By.xpath("//div[@class='form-group']//span[@class='el-radio__label' and text()='No']"));
			System.out.println("Field Required! No");

		}
		WebElement del = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		try {
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@class='el-upload__text']"));
			Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\image.exe\"");
		} catch (Exception e) {

		}
		System.out.println("Image With " + label + " Seleceted Sucessfully");
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
	}
	// Video

	public void Video() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Content Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Video = driver.findElement(By.xpath("//span[text()=\"Video\"]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Video));
		builder.dragAndDrop(Video, targetElement).perform();

		// Yes
		Fieldimage("SENDER", Video, targetElement, true, true);
		Fieldimage("RECEIVER", Video, targetElement, true, true);
		Fieldimage("SENDERORRECEIVER", Video, targetElement, true, true);
		// No
		Fieldimage("SENDER", Video, targetElement, false, false);
		Fieldimage("RECEIVER", Video, targetElement, false, false);
		Fieldimage("SENDERORRECEIVER", Video, targetElement, false, false);
		driver.close();

	}

	@SuppressWarnings("deprecation")
	public void FieldVideo(String fieldType, WebElement YesorNo, WebElement targetElement, boolean isYes, boolean Field)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(YesorNo));
		MethodActions.dragAndDrop(YesorNo, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());

		if (Field)

		{
			Thread.sleep(1000);
			MethodActions.Javascriptclick(
					By.xpath("//div[@class='form-group']//span[@class='el-radio__label' and text()='Yes']"));
			System.out.println("With Field YES");
		}

		else {

			Thread.sleep(1000);
			MethodActions.Javascriptclick(
					By.xpath("//div[@class='form-group']//span[@class='el-radio__label' and text()='No']"));
			System.out.println("With Field NO");

		}
		WebElement del = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", del);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		Thread.sleep(10000);
		try {
			MethodActions.waitEle(By.xpath("//div[@class='el-upload__text']"));
			Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\image.exe\"");
		} catch (Exception e) {

		}
		System.out.println("Video With " + label + "Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
	}

	// HorizontalLine
	public void HorizontalLine() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Content Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement HorizontalLine = driver.findElement(By.xpath("//span[text()=\"Horizontal Line\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", HorizontalLine);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(HorizontalLine));
		builder.dragAndDrop(HorizontalLine, targetElement).perform();
		driver.close();

	}

	// Division
	public void Division() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Content Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Division = driver.findElement(By.xpath("//span[text()=\"Division\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Division);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(Division));
		builder.dragAndDrop(Division, targetElement).perform();
		driver.close();

	}

	// ActionButton
	public void ActionButton() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Content Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement ActionButton = driver.findElement(By.xpath("//span[text()=\"Action Button\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ActionButton);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(ActionButton));
		builder.dragAndDrop(ActionButton, targetElement).perform();
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, ActionButton, targetElement);
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
		driver.close();

	}

//Advanced Fields

	// AutoIncrementNumber
	public void AutoIncrementNumber() throws Exception {

		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement AutoIncrementNumber = driver.findElement(By.xpath("//span[text()=\"Auto Increment Number\"]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(AutoIncrementNumber));
		Dimension dropSize = targetElement.getSize();

		int targetX = targetElement.getLocation().getX() + (dropSize.getWidth() / 2);
		int targetY = targetElement.getLocation().getY() + (dropSize.getHeight() / 2);

		builder.dragAndDropBy(AutoIncrementNumber, targetX, targetY).perform();

		Thread.sleep(10000);
		MethodActions.switchToNewWindow();

		// Yes
		FieldAutoIncrementNumber("SENDER", AutoIncrementNumber, targetElement, true);
		FieldAutoIncrementNumber("RECEIVER", AutoIncrementNumber, targetElement, true);
		FieldAutoIncrementNumber("SENDERORRECEIVER", AutoIncrementNumber, targetElement, true);
		// No
		FieldAutoIncrementNumber("SENDER", AutoIncrementNumber, targetElement, false);
		FieldAutoIncrementNumber("RECEIVER", AutoIncrementNumber, targetElement, false);
		FieldAutoIncrementNumber("SENDERORRECEIVER", AutoIncrementNumber, targetElement, false);
		driver.close();

	}

	public void FieldAutoIncrementNumber(String fieldType, WebElement AutoIncrementNumber, WebElement targetElement,
			boolean isYes) throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}

		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(AutoIncrementNumber));
		MethodActions.dragAndDrop(AutoIncrementNumber, targetElement);

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
				MethodActions.generateUniqueString() + "Add Auto Increment Number");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Prifix']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Starting Number']"), "1");

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
		Thread.sleep(10000);
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		System.out.println("Auto Increment Number " + label + " Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// Location
	public void Location() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Location = driver.findElement(By.xpath("//span[text()=\"Location\"]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Location));
		Dimension dropSize = targetElement.getSize();

		int targetX = targetElement.getLocation().getX() + (dropSize.getWidth() / 2);
		int targetY = targetElement.getLocation().getY() + (dropSize.getHeight() / 2);

		builder.dragAndDropBy(Location, targetX, targetY).perform();

		Thread.sleep(10000);
		MethodActions.switchToNewWindow();

		// Yes
		FieldLocation("SENDER", Location, targetElement, true);
		FieldLocation("RECEIVER", Location, targetElement, true);
		FieldLocation("SENDERORRECEIVER", Location, targetElement, true);
		// No
		FieldLocation("SENDER", Location, targetElement, false);
		FieldLocation("RECEIVER", Location, targetElement, false);
		FieldLocation("SENDERORRECEIVER", Location, targetElement, false);
		driver.close();

	}

	public void FieldLocation(String fieldType, WebElement Location, WebElement targetElement, boolean isYes)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}

		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Location));
		MethodActions.dragAndDrop(Location, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("(//span[@class='el-switch__core'])[1]"));
		MethodActions.waitEle(By.xpath("(//span[@class='el-switch__core'])[2]"));

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
		Thread.sleep(10000);
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		System.out.println("Location " + label + " Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// Currency
	public void Currency() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Currency = driver.findElement(By.xpath("//span[text()=\"Currency\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Currency);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Currency));

		Dimension dropSize = dropLocation.getSize();

		for (int i = 0; i < 2; i++) {
			int targetX = dropLocation.getLocation().getX() + (dropSize.getWidth() / 4);
			int targetY = dropLocation.getLocation().getY() + (dropSize.getHeight() / 4);

			builder.dragAndDropBy(dropLocation, targetX, targetY).perform();

			Thread.sleep(1000);
		}

		// Yes
		FieldCurrency("SENDER", Currency, dropLocation, true, "NUMBER");
		FieldCurrency("RECEIVER", Currency, dropLocation, true, "NUMBER");
		FieldCurrency("SENDERORRECEIVER", Currency, dropLocation, true, "NUMBER");

		FieldCurrency("SENDER", Currency, dropLocation, true, "PHONE");
		FieldCurrency("RECEIVER", Currency, dropLocation, true, "PHONE");
		FieldCurrency("SENDERORRECEIVER", Currency, dropLocation, true, "PHONE");

		FieldCurrency("SENDER", Currency, dropLocation, true, "CURRENCY");
		FieldCurrency("RECEIVER", Currency, dropLocation, true, "CURRENCY");
		FieldCurrency("SENDERORRECEIVER", Currency, dropLocation, true, "CURRENCY");

		// No
		FieldCurrency("SENDER", Currency, dropLocation, false, "NUMBER");
		FieldCurrency("RECEIVER", Currency, dropLocation, false, "NUMBER");
		FieldCurrency("SENDERORRECEIVER", Currency, dropLocation, false, "NUMBER");

		FieldCurrency("SENDER", Currency, dropLocation, false, "PHONE");
		FieldCurrency("RECEIVER", Currency, dropLocation, false, "PHONE");
		FieldCurrency("SENDERORRECEIVER", Currency, dropLocation, false, "PHONE");

		FieldCurrency("SENDER", Currency, dropLocation, false, "CURRENCY");
		FieldCurrency("RECEIVER", Currency, dropLocation, false, "CURRENCY");
		FieldCurrency("SENDERORRECEIVER", Currency, dropLocation, false, "CURRENCY");
		driver.close();

	}

	public void FieldCurrency(String fieldType, WebElement Currency, WebElement targetElement, boolean isYes,
			String field) throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Currency));
		MethodActions.dragAndDrop(Currency, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString() + "Phone");
		Thread.sleep(10000);
		if (isYes)

		{

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

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		MethodActions.Javascriptclick(By.xpath("//div[@class='el-select input_type']"));

		switch (field) {
		case "NUMBER":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[1]"));
			Thread.sleep(10000);
			System.out.println("NUMBER  With " + label + " from Field Type Selected Sucessully ");
			break;
		case "PHONE":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[2]"));
			Thread.sleep(10000);
//			MethodActions.Javascriptclick(By.xpath("//input[@placeholder='Country code']"));
//			Thread.sleep(10000);
//			MethodActions.waitEle(By.xpath("//div[text()=' Sweden (Sverige) ']"));
//			Thread.sleep(10000);
			MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Phone number *']"), "1236549");
			System.out.println("PHONE With " + label + " from Field Type Selected Sucessully ");
			break;
		case "CURRENCY":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[3]"));
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//input[@id='currencySelect']"));
			Thread.sleep(10000);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//li[3]"));
			System.out.println("CURRENCY  With " + label + " from Field Type Selected Sucessully ");
			break;
		default:
			break;
		}
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
	}

	// Question
	public void Question() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Question = driver.findElement(By.xpath("//span[text()=\"Question\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Question);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Question));

		Dimension dropSize = dropLocation.getSize();

		for (int i = 0; i < 2; i++) {
			int targetX = dropLocation.getLocation().getX() + (dropSize.getWidth() / 4);
			int targetY = dropLocation.getLocation().getY() + (dropSize.getHeight() / 4);

			builder.dragAndDropBy(dropLocation, targetX, targetY).perform();

			Thread.sleep(1000);
		}

		// Yes
		FieldQuestion("SENDER", Question, dropLocation, true, "Yes Or No");
		FieldQuestion("RECEIVER", Question, dropLocation, true, "Yes Or No");
		FieldQuestion("SENDERORRECEIVER", Question, dropLocation, true, "Yes Or No");

		FieldQuestion("SENDER", Question, dropLocation, true, "MCQ");
		FieldQuestion("RECEIVER", Question, dropLocation, true, "MCQ");
		FieldQuestion("SENDERORRECEIVER", Question, dropLocation, true, "MCQ");

		FieldQuestion("SENDER", Question, dropLocation, true, "TEXT");
		FieldQuestion("RECEIVER", Question, dropLocation, true, "TEXT");
		FieldQuestion("SENDERORRECEIVER", Question, dropLocation, true, "TEXT");

		// No
		FieldQuestion("SENDER", Question, dropLocation, false, "Yes Or No");
		FieldQuestion("RECEIVER", Question, dropLocation, false, "Yes Or No");
		FieldQuestion("SENDERORRECEIVER", Question, dropLocation, false, "Yes Or No");

		FieldQuestion("SENDER", Question, dropLocation, false, "MCQ");
		FieldQuestion("RECEIVER", Question, dropLocation, false, "MCQ");
		FieldQuestion("SENDERORRECEIVER", Question, dropLocation, false, "MCQ");

		FieldQuestion("SENDER", Question, dropLocation, false, "TEXT");
		FieldQuestion("RECEIVER", Question, dropLocation, false, "TEXT");
		FieldQuestion("SENDERORRECEIVER", Question, dropLocation, false, "TEXT");
		driver.close();

	}

	public void FieldQuestion(String fieldType, WebElement Question, WebElement targetElement, boolean isYes,
			String field) throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Question));
		MethodActions.dragAndDrop(Question, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);

		MethodActions.sendKeysToElement(By.xpath("//div[normalize-space()='Before']//input[@type='text']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(
				By.xpath("//div[normalize-space()='Question Text']//textarea[@class='el-textarea__inner']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//div[normalize-space()='After']//input[@type='text']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(
				By.xpath("//div[normalize-space()='Description']//textarea[@class='el-textarea__inner']"),
				MethodActions.generateUniqueString());
		Thread.sleep(10000);
		if (isYes)

		{

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

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		MethodActions.Javascriptclick(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));

		switch (field) {
		case "Yes Or No":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[1]"));
			Thread.sleep(10000);
			System.out.println("Yes Or No  With " + label + " from Field Type Selected Sucessully ");
			break;
		case "MCQ":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[2]"));
			System.out.println("MCQ With " + label + " from Field Type Selected Sucessully ");
			break;
		case "TEXT":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[3]"));
			Thread.sleep(10000);
			System.out.println("TEXT  With " + label + " from Field Type Selected Sucessully ");
			break;
		default:
			break;
		}
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
	}

	// Authorized Signature
	public void AuthorizedSignature() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement AuthorizedSignature = driver.findElement(By.xpath("//span[text()=\"Authorized Signature\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AuthorizedSignature);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);

		wait.until(ExpectedConditions.elementToBeClickable(AuthorizedSignature));
		builder.dragAndDrop(AuthorizedSignature, targetElement).perform();
		Thread.sleep(1000);
		try {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.waitAndClick(builder, AuthorizedSignature, targetElement);
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter content']"),
				MethodActions.generateUniqueString());
		System.out.println("Authorized Signature Field Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
		driver.close();

	}

	// Entity
	public void Entity() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Entity = driver.findElement(By.xpath("//span[text()=\"Entity\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Entity);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Entity));

		builder.dragAndDrop(dropLocation, dropLocation).perform();

		// Yes
		FieldEntity("SENDER", Entity, dropLocation, true);
		FieldEntity("RECEIVER", Entity, dropLocation, true);
		FieldEntity("SENDERORRECEIVER", Entity, dropLocation, true);

		// No
		FieldEntity("SENDER", Entity, dropLocation, false);
		FieldEntity("RECEIVER", Entity, dropLocation, false);
		FieldEntity("SENDERORRECEIVER", Entity, dropLocation, false);

	}

	public void FieldEntity(String fieldType, WebElement Entity, WebElement targetElement, boolean isYes)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Entity));
		MethodActions.dragAndDrop(Entity, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);

		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li//span[text()='Testing']"));
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(
				By.xpath("//div[normalize-space()='Description']//textarea[@class='el-textarea__inner']"),
				MethodActions.generateUniqueString() + "Add Entity");
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//input[@placeholder='Sorting order']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		Thread.sleep(10000);

		if (isYes)

		{

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
		for (int i = 1; i <= 8; i++) {
			String xpath = String.format("(//span[@class='el-checkbox__inner'])[%d]", i);
			MethodActions.waitEle(By.xpath(xpath));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(xpath)));
		}

		WebElement element = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		MethodActions.Javascriptclick(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		Thread.sleep(10000);

		Thread.sleep(10000);
		System.out.println("Entity With " + label + " Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
	}

	// Entity Variable
	public void EntityVariable() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement target = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Entity = driver.findElement(By.xpath("//span[text()=\"Entity\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Entity);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Entity));

		builder.dragAndDrop(Entity, target).perform();

		FieldEntity("SENDER", Entity, target, true);

		Thread.sleep(10000);
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement EntityVariable = driver.findElement(By.xpath("//span[text()=\"Entity Variable\"]"));
		Thread.sleep(10000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder1 = new Actions(driver);
		wait1.until(ExpectedConditions.elementToBeClickable(EntityVariable));

		builder1.dragAndDrop(EntityVariable, dropLocation).perform();

		Thread.sleep(1000);

		// Yes
		FieldEntityVariable("SENDER", EntityVariable, dropLocation, true);
		FieldEntityVariable("RECEIVER", EntityVariable, dropLocation, true);
		FieldEntityVariable("SENDERORRECEIVER", EntityVariable, dropLocation, true);

		// No
		FieldEntityVariable("SENDER", EntityVariable, dropLocation, false);
		FieldEntityVariable("RECEIVER", EntityVariable, dropLocation, false);
		FieldEntityVariable("SENDERORRECEIVER", EntityVariable, dropLocation, false);
		driver.close();

	}

	public void FieldEntityVariable(String fieldType, WebElement EntityVariable, WebElement targetElement,
			boolean isYes) throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(EntityVariable));
		MethodActions.dragAndDrop(EntityVariable, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("(//input[@class='el-input__inner'])[2]"),
				MethodActions.generateUniqueString() + "Add Entity Variable");
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[3]"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//input[@placeholder='Field operation']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		Thread.sleep(10000);

		if (isYes)

		{

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
		if (index == 1) {
			MethodActions.waitEle(By.xpath("(//span[@class='el-radio__inner'])[3]"));
			System.out.println("Entity Variable With Read only " + label + " Read only Selected Sucessfully");

		}
		if (index == 2) {
			MethodActions.waitEle(By.xpath("(//span[@class='el-radio__inner'])[4]"));
			System.out.println("Entity Variable With Editable " + label + "  Selected Sucessfully");

		}
//		if (index == 3) {
//			MethodActions.waitEle(By.xpath("(//span[@class='el-radio__inner'])[5]"));
//			System.out.println("Entity Variable With  Update parent " + label + "  Selected Sucessfully");
//
//		}

		WebElement element = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		MethodActions.Javascriptclick(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		Thread.sleep(10000);

		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
	}

	// Formula
	public void Formula() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Basic Fields']"));
		WebElement targetElement1 = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Number = driver.findElement(By.xpath("//span[text()=\"Number\"]"));
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder1 = new Actions(driver);
		wait1.until(ExpectedConditions.elementToBeClickable(Number));
		builder1.dragAndDrop(Number, targetElement1).perform();
		Thread.sleep(1000);
		FieldNumber("SENDER", Number, targetElement1, true, "NUMBER");
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Formula = driver.findElement(By.xpath("//span[text()=\"Formula\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Formula);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Formula));
		builder.dragAndDrop(Formula, targetElement).perform();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter field title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter description here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Fields']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions
				.waitEle(By.xpath("//button[@class='el-button btn-operation el-button--success el-button--mini']"));
		driver.findElement(By.xpath("//input[@placeholder='Enter Number']")).sendKeys("49");
		MethodActions.waitEle(By.xpath("//i[@class='el-icon-plus']"));
		System.out.println("Formula Seleceted Sucessfully");
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
		driver.close();
	}

	// Aggregate Function
	public void AggregateFunction() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement AggregateFunction = driver.findElement(By.xpath("//span[text()=\"Aggregate Function\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AggregateFunction);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(AggregateFunction));
		builder.dragAndDrop(AggregateFunction, targetElement).perform();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Label']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Function Type']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Field Type']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Template']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
		driver.close();
	}

	// DataTable
	public void DataTable() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement DataTable = driver.findElement(By.xpath("//span[text()=\"Data Table\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", DataTable);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(DataTable));

		Dimension dropSize = dropLocation.getSize();

		for (int i = 0; i < 2; i++) {
			int targetX = dropLocation.getLocation().getX() + (dropSize.getWidth() / 4);
			int targetY = dropLocation.getLocation().getY() + (dropSize.getHeight() / 4);

			builder.dragAndDropBy(dropLocation, targetX, targetY).perform();

			Thread.sleep(1000);
		}
		FieldDataTable("SENDER", DataTable, dropLocation);
		FieldDataTable("RECEIVER", DataTable, dropLocation);
		// FieldDataTable("SENDERORRECEIVER", DataTable, dropLocation);
		driver.close();
	}

	public void FieldDataTable(String fieldType, WebElement DataTable, WebElement targetElement) throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
//		case "SENDERORRECEIVER":
//			index = 3;
//			label = "SENDER OR RECEIVER";
//			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(DataTable));
		MethodActions.dragAndDrop(DataTable, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());

		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		MethodActions.Javascriptclick(By.xpath("//div[@class='el-select']//input[@placeholder='Select']"));
		Thread.sleep(10000);

		System.out.println("Data Table With " + label + " Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
	}

	// ChildEntityTable
	public void ChildEntityTable() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement ChildEntityTable = driver.findElement(By.xpath("//span[text()=\"Child Entity Table\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ChildEntityTable);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(ChildEntityTable));

		Dimension dropSize = dropLocation.getSize();

		for (int i = 0; i < 2; i++) {
			int targetX = dropLocation.getLocation().getX() + (dropSize.getWidth() / 4);
			int targetY = dropLocation.getLocation().getY() + (dropSize.getHeight() / 4);

			builder.dragAndDropBy(dropLocation, targetX, targetY).perform();

			Thread.sleep(1000);
		}

		FieldChildEntityTable("SENDER", ChildEntityTable, dropLocation);
		FieldChildEntityTable("RECEIVER", ChildEntityTable, dropLocation);
		FieldChildEntityTable("SENDERORRECEIVER", ChildEntityTable, dropLocation);
		driver.close();

	}

	public void FieldChildEntityTable(String fieldType, WebElement ChildEntityTable, WebElement targetElement)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(ChildEntityTable));
		MethodActions.dragAndDrop(ChildEntityTable, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ChildEntityTable);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("(//div[@class='el-form-item__content']//input[@placeholder='Select'])[2]"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li//span[text()='Testing']"));
		MethodActions.waitEle(By.xpath("(//div[@class='el-form-item__content']//input[@placeholder='Select'])[3]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[2]"));

		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		System.out.println("Child Entity Table  With " + label + " Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
	}
	// PayButtons

	public void PayButtons() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Currency = driver.findElement(By.xpath("//span[text()=\"Currency\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Currency);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Currency));
		builder.dragAndDrop(Currency, dropLocation).perform();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Currency");
		MethodActions.waitEle(By.xpath("//input[@id=\"currencySelect\"]"));
		MethodActions.waitEle(By.xpath("//span[text()=\"INR\"]"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
		Thread.sleep(10000);
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement PayButtons = driver.findElement(By.xpath("//span[text()=\"Pay Buttons\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PayButtons);
		Thread.sleep(10000);
		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder1 = new Actions(driver);

		wait11.until(ExpectedConditions.elementToBeClickable(PayButtons));
		builder1.dragAndDrop(PayButtons, targetElement).perform();
		Thread.sleep(1000);
		try {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Methods']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Modes']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[2]"));
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Charge Field']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Redirection URL']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
		driver.close();

	}

	// PaymentVariable
	public void PaymentVariable() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement PaymentVariable = driver.findElement(By.xpath("//span[text()=\"Payment Variable\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PaymentVariable);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(PaymentVariable));

		Dimension dropSize = dropLocation.getSize();

		int targetX = dropLocation.getLocation().getX() + (dropSize.getWidth() / 4);
		int targetY = dropLocation.getLocation().getY() + (dropSize.getHeight() / 4);

		builder.dragAndDropBy(dropLocation, targetX, targetY).perform();

		Thread.sleep(1000);

		FieldPaymentVariable("SENDER", PaymentVariable, dropLocation, "Gateway");
		FieldPaymentVariable("RECEIVER", PaymentVariable, dropLocation, "Name");
		FieldPaymentVariable("SENDERORRECEIVER", PaymentVariable, dropLocation, "Phone Number");
		driver.close();

	}

	public void FieldPaymentVariable(String fieldType, WebElement PaymentVariable, WebElement targetElement,
			String field) throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(PaymentVariable));
		MethodActions.dragAndDrop(PaymentVariable, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", PaymentVariable);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		MethodActions.Javascriptclick(By.xpath("(//input[@placeholder='Select'])[3]"));
		switch (field) {
		case "Transaction Id":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[1]"));
			System.out.println("Transaction Id " + label + " Selected Successfully");
			break;
		case "Gateway":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[2]"));
			System.out.println("Gateway " + label + " Selected Successfully");
			break;
		case "Name":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[3]"));
			System.out.println("Name " + label + " Selected Successfully");
			break;
		case "Email":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[4]"));
			System.out.println("Email " + label + " Selected Successfully");
			break;
		case "Phone Number":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[5]"));
			System.out.println("Phone Number " + label + " Selected Successfully");
			break;
		case "Payment Type":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[5]"));
			System.out.println("Payment Type " + label + " Selected Successfully");
			break;
		case "Method":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[5]"));
			System.out.println("Method " + label + " Selected Successfully");
			break;
		case "Currency":
			Thread.sleep(10000);
			MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//ul//li[5]"));
			System.out.println("Currency " + label + " Selected Successfully");
			break;
		default:

			break;
		}
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
	}

	// Star Rating
	public void StarRating() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement StarRating = driver.findElement(By.xpath("//span[text()=\"Star Rating\"]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(StarRating));

		builder.dragAndDrop(StarRating, targetElement).perform();

		Thread.sleep(1000);

		// Yes

		FieldStarRating("SENDER", StarRating, targetElement, true);
		FieldStarRating("RECEIVER", StarRating, targetElement, true);
		FieldStarRating("SENDERORRECEIVER", StarRating, targetElement, true);

		// No
		FieldStarRating("SENDER", StarRating, targetElement, false);
		FieldStarRating("RECEIVER", StarRating, targetElement, false);
		FieldStarRating("SENDERORRECEIVER", StarRating, targetElement, false);
		driver.close();

	}

	public void FieldStarRating(String fieldType, WebElement StarRating, WebElement targetElement, boolean isYes)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(StarRating));
		MethodActions.dragAndDrop(StarRating, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString() + "Star Rating");
		Thread.sleep(10000);
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

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		System.out.println("Star Rating With " + label + " Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// Concatenate
	public void Concatenate() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Concatenate = driver.findElement(By.xpath("//span[text()=\"Concatenate\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Concatenate);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Concatenate));
		builder.dragAndDrop(Concatenate, targetElement).perform();

		// Yes

		FieldConcatenate("SENDER", Concatenate, targetElement, true);
		FieldConcatenate("RECEIVER", Concatenate, targetElement, true);
		FieldConcatenate("SENDERORRECEIVER", Concatenate, targetElement, true);

		// No
		FieldConcatenate("SENDER", Concatenate, targetElement, false);
		FieldConcatenate("RECEIVER", Concatenate, targetElement, false);
		FieldConcatenate("SENDERORRECEIVER", Concatenate, targetElement, false);
		driver.close();

	}

	public void FieldConcatenate(String fieldType, WebElement Concatenate, WebElement targetElement, boolean isYes)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Concatenate));
		MethodActions.dragAndDrop(Concatenate, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString() + "Add Concatenate");
		Thread.sleep(10000);
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

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		System.out.println("Concatenate With " + label + "Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// Audio
	public void Audio() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Audio = driver.findElement(By.xpath("//span[text()=\"Audio\"]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(Audio));

		builder.dragAndDrop(Audio, targetElement).perform();

		// Yes

		FieldAudio("SENDER", Audio, targetElement, true);
		FieldAudio("RECEIVER", Audio, targetElement, true);
		FieldAudio("SENDERORRECEIVER", Audio, targetElement, true);

		// No
		FieldAudio("SENDER", Audio, targetElement, false);
		FieldAudio("RECEIVER", Audio, targetElement, false);
		FieldAudio("SENDERORRECEIVER", Audio, targetElement, false);
		driver.close();

	}

	public void FieldAudio(String fieldType, WebElement Audio, WebElement targetElement, boolean isYes)
			throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(Audio));
		MethodActions.dragAndDrop(Audio, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString() + "Add Audio");
		Thread.sleep(10000);

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

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		System.out.println("Audio With " + label + " Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// QRCode
	public void QRCode() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement QRCode = driver.findElement(By.xpath("//span[text()=\"QR Code\"]"));
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(QRCode));

		builder.dragAndDrop(QRCode, targetElement).perform();

		// Yes

		FieldQRCode("SENDER", QRCode, targetElement);
		FieldQRCode("RECEIVER", QRCode, targetElement);
		FieldQRCode("SENDERORRECEIVER", QRCode, targetElement);
		driver.close();

	}

	public void FieldQRCode(String fieldType, WebElement QRCode, WebElement targetElement) throws Exception {

		int index;
		String label;
		Thread.sleep(10000);

		switch (fieldType) {
		case "SENDER":
			index = 1;
			label = "SENDER";
			break;
		case "RECEIVER":
			index = 2;
			label = "RECEIVER";
			break;
		case "SENDERORRECEIVER":
			index = 3;
			label = "SENDER OR RECEIVER";
			break;
		default:
			throw new IllegalArgumentException("Invalid fieldType: " + fieldType);
		}
		Thread.sleep(10000);
		WebDriverWait waitsource = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitsource.until(ExpectedConditions.elementToBeClickable(QRCode));
		MethodActions.dragAndDrop(QRCode, targetElement);

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dialog-overlay']")));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath(
				"//div[@class='el-col el-col-12']//div//div[@class='form-group']//div[@class='el-input']//input[@type='text']"),
				MethodActions.generateUniqueString() + "Add QR Code");
		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//div[@class='el-select filledby']//input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofMinutes(1))
				.pollingEvery(Duration.ofSeconds(30)).ignoring(NoSuchElementException.class);

		WebElement elementmultipleelect = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@x-placement]//ul//li[" + index + "] ")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", elementmultipleelect);
		if (index == 1) {

			MethodActions.waitEle(By.xpath("(//span[@class='el-radio__inner'])[1]"));

		}
		if (index == 2) {

			MethodActions.waitEle(By.xpath("(//span[@class='el-radio__inner'])[2]"));

		}
		if (index == 3) {

			MethodActions.waitEle(By.xpath("(//span[@class='el-radio__inner'])[3]"));

		}

		System.out.println("QR CODE With " + label + " Selected Sucessfully");
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
	}

	// QR Reader
	public void QRReader() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement QRReader = driver.findElement(By.xpath("//span[text()=\"QR Reader\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", QRReader);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Actions builder = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(QRReader));
		builder.dragAndDrop(QRReader, targetElement).perform();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Insert Field')]"));
		driver.close();

	}

}
