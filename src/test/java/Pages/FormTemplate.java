package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		MethodActions.waitEle(By.xpath("//span[@class='el-icon-arrow-down text-white']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[4]"));

	}

	public void Createtemp() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@class='right-create-button']"));
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Template Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Template Description']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[2]"));
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[2]"));
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

	public void BasicFieldssingleline() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		Thread.sleep(10000);
		WebElement Singleline = driver.findElement(By.xpath("//span[text()=\"Single Line Text\"]"));
		Thread.sleep(10000);
		Actions builder = new Actions(driver);
		MethodActions.waitAndClick(builder, Singleline, dropLocation);
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Description Here']"),
				MethodActions.generateUniqueString());
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement dropdownTrigger = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='el-select input_type']")));
		dropdownTrigger.click();
		List<WebElement> dropdownItems = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@x-placement]//ul//li")));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		for (WebElement item : dropdownItems) {
			try {
				executor.executeScript("arguments[0].click();", item);
				Thread.sleep(10000);

			} catch (Exception e) {

			}
		}
		// MethodActions.waitEle(By.xpath("//span[@class='el-radio__label' and
		// text()='No']"));
		MethodActions.waitEle(By.xpath("//div[@class='el-select input_type']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//i[@class='el-icon-info']"));
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
		MethodActions.waitEle(By.xpath("//span[text()='Global Variable']"));
		MethodActions.waitEle(By.xpath("//span[text()='Update Field']"));

	}

	public void Multiline() throws Exception {
		Thread.sleep(10000);
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement Multiline = driver.findElement(By.xpath("//span[text()=\"Multi Line Text\"]"));
		Thread.sleep(10000);
		Actions builder = new Actions(driver);
		MethodActions.waitAndClick(builder, Multiline, dropLocation);
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
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

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
				// TODO: handle exception
			}
			MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public void Multipleactions() {

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
		MethodActions.waitAndClick(builder, HTML, dropLocation);
		MethodActions.waitAndClick(builder, Paragraph, dropLocation);
		MethodActions.waitAndClick(builder, SingleLineContent, dropLocation);
		MethodActions.waitAndClick(builder, Image, dropLocation);
		MethodActions.waitAndClick(builder, Video, dropLocation);
		MethodActions.waitAndClick(builder, ActionButton, dropLocation);
		MethodActions.waitAndClick(builder, HorizontalLine, dropLocation);
		MethodActions.waitAndClick(builder, Division, dropLocation);
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
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter content']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// SingleLineContent
		Thread.sleep(10000);
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter content']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Image
		Thread.sleep(10000);
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

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save']"));
	}

	public void AdvancedFields() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()=\"Advanced Fields\"]"));
		Thread.sleep(10000);
		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));
		WebElement AutoIncrementNumber = driver.findElement(By.xpath("//span[text()='Auto Increment Number']"));
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
		MethodActions.waitAndClick(builder, AutoIncrementNumber, dropLocation);
		MethodActions.waitAndClick(builder, Location, dropLocation);
		MethodActions.waitAndClick(builder, Currency, dropLocation);
		MethodActions.waitAndClick(builder, Question, dropLocation);
		// MethodActions.waitAndClick(builder, AuthorizedSignature, dropLocation);
		MethodActions.waitAndClick(builder, Entity, dropLocation);
		MethodActions.waitAndClick(builder, EntityVariable, dropLocation);
		MethodActions.waitAndClick(builder, Formula, dropLocation);
		MethodActions.waitAndClick(builder, AggregateFunction, dropLocation);
		MethodActions.waitAndClick(builder, DataTable, dropLocation);
		MethodActions.waitAndClick(builder, ChildEntityTable, dropLocation);
		MethodActions.waitAndClick(builder, PayButtons, dropLocation);
		MethodActions.waitAndClick(builder, PaymentVariable, dropLocation);
		MethodActions.waitAndClick(builder, StarRating, dropLocation);
		MethodActions.waitAndClick(builder, Concatenate, dropLocation);
		MethodActions.waitAndClick(builder, Audio, dropLocation);
		MethodActions.waitAndClick(builder, QRCode, dropLocation);
		MethodActions.waitAndClick(builder, QRReader, dropLocation);
		Thread.sleep(10000);
		// Auto Increment Number

		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//textarea[@placeholder='Enter Description Here']"));
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Prifix']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Location
		Thread.sleep(10000);
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
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[1]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.sendKeysToElement(By.xpath("(//input[@class='el-input__inner'])[3]"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("(//textarea[@class='el-textarea__inner'])[1]"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("(//input[@class='el-input__inner'])[4]"),
				MethodActions.generateUniqueString());
		MethodActions.sendKeysToElement(By.xpath("(//textarea[@class='el-textarea__inner'])[2]"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[text()='Yes']"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Entity yet
		Thread.sleep(10000);
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

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save']"));
	}

}
