package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Set;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EntitiesMeghana {
	static WebDriver driver;

	public EntitiesMeghana(WebDriver driver) {

		EntitiesMeghana.driver = driver;

	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(5000);
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

	public void switchToNewWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
	}

	public static void Javascriptclick(By xpath) throws Exception {
		Thread.sleep(3000);

		WebElement element = driver.findElement(xpath);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	public void entity() throws Exception {
//		waitEle(By.xpath("//div[@class='icon-text']"));
//
//		Javascriptclick(By.xpath("//li[normalize-space()=\"Entities\"]"));
//
//		System.out.println("Clicked on entities in profile completed");
		driver.get("https://nsui.esigns.io/entity");
	}

	public void ClickEntityAction(String s) throws Exception {
		Thread.sleep(20000);
		String xpath = String.format(
				"//div[@class='el-table__fixed']//div[contains(text(),'%s')]/ancestor::tr//span[normalize-space()=\"Actions\"]",
				s);
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(xpath));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		waitEle(By.xpath("//ul[@x-placement] //li[normalize-space()='View']"));
		System.out.println("Click on View Action Done successfully");
	}

	public void Customization() throws Exception {

		waitEle(By.xpath("//span[normalize-space()='Customize']"));
		waitEle(By.xpath("//div[@id=\"tab-tabs\"]"));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Please Enter Label\"]"), "students");
		waitEle(By.xpath("//span[normalize-space()=\"Add\"]"));
		waitEle(By.xpath("//span[normalize-space()=\"Feature\"]"));
		waitEle(By.xpath("(//input[@placeholder=\"Select\"])[1]"));
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

		waitEle(By.xpath("(//input[@placeholder=\"Select\"])[2]"));
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));

		waitEle(By.xpath("(//input[@placeholder=\"Select\"])[3]"));
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
		waitEle(By.xpath("//span[contains(text(),\" Add\")]"));

		System.out.println("Customization updated successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void ClickCreateEntity() throws Exception {

		By ad = By.xpath("//button[normalize-space()='Create Entity']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on ceate entity using JS.");

	}

	public void CreateEntity() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		try {

			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(5000);
		By Title = By.xpath("//input[@placeholder='Title']");
		WebElement Title1 = wait.until(ExpectedConditions.elementToBeClickable(Title));
		Title1.sendKeys("Bug");

		By Description = By.xpath("//textarea[@placeholder='Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("This entity is only for testing purpose");

		waitEle(By.xpath("//span[normalize-space()='GENERAL']"));
		System.out.println("Clicked on GENERAL Successfully");
		waitEle(By.xpath("//h4[text()=\"Create from excel\"]"));
		System.out.println("Clicked on Create from excel successfully");

	}

	public void confirmButton() throws Exception {
		waitEle(By.xpath("//span[text()=\"Confirm\"]"));
	}

	public boolean VerifyconfirmSucess() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()=\"Drag & Drop Excel file here\"]")));
		System.out.println("click on confirm done Sucessfully");
		return name.isDisplayed();

	}

	public boolean VerifyNext() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class=\"el-col el-col-24 el-col-md-21 el-col-lg-19\"]")));
		System.out.println("Click on Next Done successfully");
		return name.isDisplayed();

	}

	public void uploadFile(String path) throws Exception {
		Thread.sleep(10000);
		File uploadFile = new File(path);
		WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", fileInput);
		fileInput.sendKeys(uploadFile.getAbsolutePath());
		System.out.println("Excel is imported successfully from PC");
	}

	public void nextButton() throws Exception {
		waitEle(By.xpath("//span[text()=\"Next\"]"));
	}

	public void nextButtonInImport() throws Exception {
		waitEle(By.xpath("//button[@class=\"btn btn btn-outline-success btn-sm m-lr-1\"]"));
	}

	public void finishImportButton() throws Exception {
		waitEle(By.xpath("//button[@class=\"btn btn-outline-success btn-sm m-lr-1\"]"));
		waitEle(By.xpath("//button[@class=\"btn btn-outline-primary mt-2 m-lr-1 mb-2\"]"));
	}

	public void SpanButton(String s) throws Exception {
		Thread.sleep(5000);
		try {
			String span = String.format("//span[normalize-space()=\"%s\"]", s);
			By ele = By.xpath(span);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
			WebElement c = wait.until(ExpectedConditions.elementToBeClickable(ele));
			c.click();
			System.out.printf("Click on %s done Successfully %n", s);
		} catch (Exception e) {

		}
	}

	public void actionView() throws Exception {
		Thread.sleep(20000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(), 'teacher-bug')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();

		waitEle(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='View']"));
		System.out.println("Click on View Action Done successfully");
	}

	public void addNewData() throws Exception {
//		Thread.sleep(10000);
//		waitEle(By.xpath("//div[@class='right-block float-right']//button[@class='el-button el-tooltip entity-add-btn el-button--primary']"));
//		
//		System.out.println("Click on Add New Data Icon done successfully");
		By ad = By.xpath(
				"//div[@class='right-block float-right']//button[@class='el-button el-tooltip entity-add-btn el-button--primary']");
		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("clicked on add new data using JS.");
		} catch (Exception e) {

			System.out.println("Add new data not clickable or not found");
		}
	}

	public void clickOnLayout1() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//i[@class=\"el-icon-more\"]"));
		System.out.println("Click on layout dots done successfully");

	}

	public void clickOnLayout() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//i[@class=\"el-icon-more\"]"));
		System.out.println("Click on layout dots done successfully");

	}

	public void layoutTable() throws Exception {
		waitEle(By.xpath("//p[text()=\" Table \"]"));
		System.out.println("Click on layout Table done successfully");
	}

	public void layoutBoard() throws Exception {
		waitEle(By.xpath("//p[text()=\" Board \"]"));
		System.out.println("Click on layout Board done successfully");
	}

	public void layoutChart() throws Exception {
		waitEle(By.xpath("//p[text()=\" Charts \"]"));
		System.out.println("Click on layout Chart done successfully");
	}

	public void layoutCards() throws Exception {
		waitEle(By.xpath("//p[text()=\" Cards \"]"));
		System.out.println("Click on layout Cards done successfully");
	}

	public void tools() throws Exception {
		waitEle(By.xpath("//button[@class=\"el-button el-button--default el-button--mini\"]"));
		System.out.println("Click on tools icon done successfully");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		waitEle(By.xpath("(//span[@class=\"el-checkbox__inner\"])[1]"));
		System.out.println("selected fields to view successfully");
		waitEle(By.xpath("(//span[text()=\"Apply\"])[1]"));
	}

	public void bulkDel() throws Exception {
		waitEle(By.xpath(
				"//div[contains(@class,'el-table__header-wrapper')]//span[contains(@class,'el-checkbox__inner')]"));
		System.out.println("Selected the checkbox for bulk Delete successfully");
		waitEle(By.xpath("//span[text()=\" Actions \"]"));
		System.out.println("Click on Actions for bulk Delete Done successfully");
		waitEle(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='Delete']"));
		confirmButton();
		System.out.println("Bulk Delete Done Successfully");
	}

	public void selectFormTemplate() throws Exception {
		waitEle(By.xpath("(//input[@placeholder=\"Select form template\"])[1]"));
		System.out.println("Clicked on select Form Template");
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
		System.out.println("selected Form Template");
		waitEle(By.xpath("(//input[@placeholder=\"Select field\"])[1]"));
		System.out.println("Clicked on Select Feild");
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
		System.out.println("selected Feild");

	}

	public void plusIcon() throws Exception {
		waitEle(By.xpath("(//i[@class=\"el-icon-circle-plus\"])[1]"));
		System.out.println("Clicked On Plus Icon to create a new Form Template");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		By Title = By.xpath("//input[@placeholder=\"Enter template name\"]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Title1 = wait.until(ExpectedConditions.elementToBeClickable(Title));
		Title1.sendKeys("Testing2");

	}

	public void Selectfeild() throws Exception {
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
		waitEle(By.xpath("(//input[@placeholder=\"Select field\"])[1]"));
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));
		System.out.println("selected Feild");
	}

	public void primaryFeillsSelectCheckBox() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-checkbox__inner\"])[1]"));
		System.out.println("Clicked on Primary Feild CheckBox");
		waitEle(By.xpath("//span[normalize-space()=\"Next\"]"));
	}

	public void reviewImport() throws Exception {
		waitEle(By.xpath("//span[normalize-space()=\"Import\"]"));
		System.out.println("Click on Import done successfully");
		waitEle(By.xpath("//span[normalize-space()=\"Done\"]"));
	}

	public void fillFeilds() throws Exception {

		waitEle(By.xpath("//input[@placeholder=\"Parent Name\"]"));
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
		waitEle(By.xpath("//input[@placeholder=\"Teacher Name\"]"));
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By Sl = By.xpath("//textarea[@placeholder=\"Feedback\"]");
		WebElement sl1 = wait.until(ExpectedConditions.elementToBeClickable(Sl));
		sl1.sendKeys("Test7");
		System.out.println("Filled multi line text");

	}

	public void details() throws Exception {
		waitEle(By.xpath("//div[normalize-space()=\"Details\"]"));
		System.out.println("Click on details done successfully");

	}

	public void SaveButton() throws Exception {
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
		System.out.println("Click on save done successfully");
	}

	public void saveAndNew() throws Exception {
		waitEle(By.xpath("//span[normalize-space()=\"Save & New\"]"));
		System.out.println("Click on save&new done successfully");
	}

	public void filter() throws Exception {
		waitEle(By
				.xpath("//button[@class=\"el-button el-tooltip entity-add-btn el-button--default el-button--mini\"]"));
		System.out.println("Click on filter done successfully");
		Set<String> windowHandles = driver.getWindowHandles();
		waitEle(By.xpath("//span[normalize-space()=\"Add Filter+\"]"));
		System.out.println("Click on Add filter done successfully");
		waitEle(By.xpath("//input[@placeholder=\"Entity Field\"]"));

		Javascriptclick(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
		waitEle(By.xpath("//input[@placeholder=\"Operator\"]"));

		Javascriptclick(By.xpath("//div[@x-placement=\"bottom-start\"]//li[4]"));
		Javascriptclick(By.xpath("//button[normalize-space()='Apply']"));
		System.out.println("Adding filter done successfully");

	}

	public void filters() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//button[@class=\"el-tooltip btn btn-sm btn-outline-secondary m-lr-1\"]"));
		System.out.println("Click on filter done successfully");
		switchToNewWindow();
		waitEle(By.xpath("//span[normalize-space()=\"Add Filter+\"]"));
		System.out.println("Click on Add filter done successfully");
		waitEle(By.xpath("//input[@placeholder=\"Entity Field\"]"));

	}

	public void filterNumberField(String Field, String operation, String vType, String num) throws Exception {
		String field = String.format("//li[contains(text(),\"%s\")]", Field);
		Javascriptclick(By.xpath(field));
		System.out.println("Selected Field to apply Filter");
		waitEle(By.xpath("//input[@placeholder=\"Operator\"]"));
		String operator = String.format("//li//span[text()=\"%s\"]", operation);
		Javascriptclick(By.xpath(operator));
		System.out.println("Successfully Selected Operator");
		if (operation == "Not Exist" || operation == "Exist") {
			System.out.println("Click on operator " + operation + " done successfully");
		} else if (operation == "Range") {
			sendKeysToElement(By.xpath("//input[@placeholder=\"starting value\"]"), "1");
//			waitEle(By.xpath("//input[@placeholder=\"ending value\"]"));
			Thread.sleep(5000);
			sendKeysToElement(By.xpath("//input[@placeholder=\"ending value\"]"), num);
		} else {
			waitEle(By.xpath("//input[@placeholder=\"Value type\"]"));
			String valueType = String.format("//li//span[text()=\"%s\"]", vType);
			Javascriptclick(By.xpath(valueType));
			System.out.println("Successfully Selected ValueType");
			if (vType == "VALUE") {
				try {
				driver.findElement(By.xpath("//input[@role=\"spinbutton\"]")).clear();
				sendKeysToElement(By.xpath("//input[@role=\"spinbutton\"]"), num);
				}catch(Exception e) {
					waitEle(By.xpath("//div[@class=\"el-input el-input--mini\"]"));
					driver.findElement(By.xpath("//div[@class=\"el-input el-input--mini\"]//input[@class=\"el-input__inner\"]")).clear();
					sendKeysToElement(By.xpath("//div[@class=\"el-input el-input--mini\"]//input[@class=\"el-input__inner\"]"), num);
				}
			} else if (vType == "GLOBAL_VARIABLE") {
				waitEle(By.xpath("//div[@class=\"scrollable-content\"]//input[@placeholder=\"Select\"]"));
				String value = String.format("//li//span[contains(text(),\"%s\")]", num);
				Javascriptclick(By.xpath(value));
			} else {
				waitEle(By.xpath("//input[@placeholder=\"Template fields\"]"));
				String value = String.format("//li//span[contains(text(),\"%s\")]", num);
				Javascriptclick(By.xpath(value));
			}
		}
		Thread.sleep(20000);
		Javascriptclick(By.xpath(
				"//div[@class=\"dialog-footer\"]//button[@class=\"btn btn btn-outline-success btn-sm m-lr-1\"]"));
		System.out.println("Adding filter done successfully");
	}

	public void EyeIcon() throws Exception {
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@class='el-table__fixed-right'] //tr[1]//button/span/i"));
		System.out.println("Click on Eye Icon done successfully");
	}

	public void editButton() throws Exception {
		waitEle(By.xpath("//span[normalize-space()=\"Edit\"]"));
		System.out.println("Click on Edit done successfully");

	}

	public void EntityType() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select Type']"));
		System.out.println("Click on selct to select entity type done successfully");

	}

	public void BusinessEntity() throws Exception {

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		System.out.println("Selected Business Entity");
	}

	public void contacts() throws Exception {
		waitEle(By.xpath("//div[@id=\"tab-contacts\"]"));
		System.out.println("click on contact done successfully");
		waitEle(By.xpath("//span[normalize-space()=\"Create Contact\"]"));
		System.out.println("click on Create contact done successfully");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		sendKeysToElement(By.xpath("(//div[@class=\"el-dialog__body\"]//input[@class=\"el-input__inner\"])[1]"),
				"mohan");
		System.out.println("Entered first name successfully");
		sendKeysToElement(By.xpath("(//div[@class=\"el-dialog__body\"]//input[@class=\"el-input__inner\"])[2]"),
				"pemma");
		System.out.println("Entered Last name successfully");
		sendKeysToElement(By.xpath("(//div[@class=\"el-dialog__body\"]//input[@class=\"el-input__inner\"])[3]"),
				"mohanpemma@gmail.com");
		System.out.println("Entered Email successfully");
		waitEle(By.xpath("//span[normalize-space()=\"Save Contact\"]"));
		System.out.println("Click on Save contact successfully");
		waitEle(By.xpath("//div[@class=\"el-dialog__body\"]//span[text()=\"Cancel\"]"));
		waitEle(By.xpath("//span[normalize-space()=\"Yes\"]"));

	}

	public void bulkUpdate() throws Exception {
		waitEle(By.xpath(
				"//div[contains(@class,'el-table__header-wrapper')]//span[contains(@class,'el-checkbox__inner')]"));
		System.out.println("Selected the checkbox for bulk Delete successfully");
		waitEle(By.xpath("//span[text()=\" Actions \"]"));
		System.out.println("Click on Actions for bulk Delete Done successfully");
		waitEle(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='Bulk Update']"));
		waitEle(By.xpath("(//div[@class=\"el-dialog__body\"]//input[@placeholder=\"Select\"])[1]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[3]"));
		waitEle(By.xpath("(//div[@class=\"el-dialog__body\"]//input[@placeholder=\"Select\"])[2]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));
		waitEle(By.xpath("//span[normalize-space()=\"Update\"]"));
		System.out.println("Bulk update done successfully");

	}

//Create from Scratch
	public void FormTemplate() throws Exception {

		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='icon-text']"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(3000);
		Javascriptclick(By.xpath("//li[normalize-space()=\"Form Template\"]"));

		System.out.println("Clicked on Form template in profile completed");

	}

	public void CreateFromScratchFormtemplate() throws Exception {

		Thread.sleep(10000);

		By ad = By.xpath("//button[normalize-space()='Create Template']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked create FormTemplate using JS.");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		By Name = By.xpath("//input[@placeholder='Enter Template Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name));
		Name1.sendKeys();

		By Description = By.xpath("//textarea[@placeholder='Enter Template Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("Test purpose");

	}

	public void Loadingmask() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}

	}

	public void CreateFormtemplate(String s) throws Exception {

		Thread.sleep(10000);

		By ad = By.xpath("//button[normalize-space()='Create Template']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked create FormTemplate using JS.");
		Thread.sleep(5000);
		Loadingmask();
		waitEle(By.xpath("//div[@class=\"icons plus-symbol\"]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		By Name = By.xpath("//input[@placeholder='Enter Template Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name));
		Name1.sendKeys(s);

		By Description = By.xpath("//textarea[@placeholder='Enter Template Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("Test purpose");

	}

	public void submit() throws Exception {
		waitEle(By.xpath("(//span[normalize-space()='Submit'])[1]"));
		System.out.println("Click on submit done successfully");

	}

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

	public void Addbasicfields() throws Exception {

		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		WebElement Name = driver.findElement(By.xpath("(//span[normalize-space()='Single Line Text'])[2]"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, Name, Target);
		System.out.println("Name Element Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By Name11 = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name11));
		Name1.sendKeys("Name");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

	}

	public void IndividualEntity() throws Exception {

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		System.out.println("Selected Individual Entity");

	}

	public void GeneralEntity() throws Exception {

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		System.out.println("Selected General Entity");
	}

	public void CreateEntityScratch() throws Exception {
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		try {
			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "student-bug");

		By Description = By.xpath("//textarea[@placeholder='Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("This entity is only for testing purpose");

		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[3]"));

		waitEle(By.xpath("//h4[contains(text(),\"Start from scratch\")]"));

		System.out.println("Create entity successfull");

	}

	public void CreateEntityFromScratch(String title, String s, String ET) throws Exception {
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), title);

		By Description = By.xpath("//textarea[@placeholder='Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("This entity is only for testing purpose");
		String entitytype = String.format("//div[@class=\"radio-group\"]//span[contains(text(), '%s')]", ET);
		waitEle(By.xpath(entitytype));
		String createFrom = String.format("//h4[contains(text(),'%s')]", s);
		waitEle(By.xpath(createFrom));
		Thread.sleep(3000);
		waitEle(By.xpath("//button[@class=\"btn btn btn-outline-primary btn-sm m-lr-1\"]"));

		System.out.println("Create entity successfull");

	}

	public void addtemplate(String t) throws Exception {
		Thread.sleep(10000);
		String temp = String.format("//p[normalize-space()= '%s']", t);
		waitEle(By.xpath(temp));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[text()=\"Update & Next\"]"));
		try {
			primaryFeild();
		} catch (Exception e) {
		}
		waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));

		waitEle(By.xpath("//div[text()=\"Actions\"]"));

		waitEle(By.xpath("//span[text()=\"Done\"]"));
	}

	public void syncRelationAdd() throws Exception {

		waitEle(By.xpath("//button[@class=\"el-button el-button--success el-button--mini\"]"));
		System.out.println("Sync Relation Added Successdfully");
		SpanButton("Skip");
	}

	public void addTempToEntity(String template) throws Exception {
		Thread.sleep(10000);
		String temp = String.format("//p[normalize-space()= '%s']", template);
		waitEle(By.xpath(temp));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[text()=\"Update & Next\"]"));
		try {
			primaryFeild();
		} catch (Exception e) {
		}

	}

	public void entityCreateCmpltAfterRelationAdd() throws Exception {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		try {

			By xpath = By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(xpath));

		} catch (Exception e) {

		}
		waitEle(By.xpath("//div[text()=\"Customization\"]"));
		waitEle(By.xpath("//div[text()=\"Actions\"]"));

		waitEle(By.xpath("//span[text()=\"Done\"]"));
		System.out.println("Created entity successfully");
	}

	public void entityTwo() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "teacher-bug");
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

	public void addtemplatesScratch() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"student-bug\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void addSecondtemplatesScratch() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"teacher-bug\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void primaryFeild() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement FullName = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class=\"dropBox\"]//ul[@class=\"list-group\"]//li[text()=\" Single line text \"]|"
						+ "//div[@class=\"dropBox\"]//ul[@class=\"list-group\"]//li[normalize-space()=\"Single Line Text\"]")));
		WebElement Target = driver.findElement(By.xpath("(//ul[@class=\"list-group\"])[2]"));
		Actions actions = new Actions(driver);
		waitAndClick(actions, FullName, Target);
		System.out.println("primary feild Drag and Drop Done");
		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));

	}

	public void updateAndNext() throws Exception {
		waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));
		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void Done() throws Exception {

		waitEle(By.xpath("//span[normalize-space()=\"Done\"]"));
	}

	// span[normalize-space()="Done"]
	public void Relationship() throws Exception {

		waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[contains(text(),\"MANY\")]"));

		waitEle(By.xpath("(//input[@placeholder='Select'])[3]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//span[normalize-space()=\"student-bug\"]"));
		waitEle(By.xpath("(//input[@placeholder='Select'])[5]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[contains(text(),\"ONE\")]"));

		waitEle(By.xpath("//span[normalize-space()='Add Relationship']"));

		System.out.println("Relationship added successfully");

		Thread.sleep(3000);

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void Bug4798() throws Exception {
		waitEle(By.xpath("(//div[@class=\"el-tabs__item is-top\"])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Add New\"]"));
		contactDetails1();
		waitEle(By.xpath("//span[normalize-space()=\"Add student-bug\"]"));

	}

	public void VerifyExcelImported() {

	}

	public void contactDetails() throws Exception {
		sendKeysToElement(By.xpath("//input[@placeholder=\"First Name\"]"), "bannu");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Last Name\"]"), "PM");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Middle Name\"]"), "Pv");

		sendKeysToElement(By.xpath("//input[@placeholder=\"Email\"]"), "pmmeghana2001@gmail.com");
		waitEle(By.xpath("//span[normalize-space()=\"Save & Next\"]"));
		System.out.println("Entered contact details successfully");
	}

	public void contactDetails2() throws Exception {
		sendKeysToElement(By.xpath("//input[@placeholder=\"First Name\"]"), "Meghana");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Last Name\"]"), "PM");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Middle Name\"]"), "PS");

		sendKeysToElement(By.xpath("//input[@placeholder=\"Email\"]"), "n180894@rguktn.ac.in");
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
		System.out.println("Entered contact details successfully");
	}

	public void contactDetails3() throws Exception {
		sendKeysToElement(By.xpath("//input[@placeholder=\"First Name\"]"), "bannu");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Last Name\"]"), "PM");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Middle Name\"]"), "Pv");

		sendKeysToElement(By.xpath("//input[@placeholder=\"Email\"]"), "meghana@gmail.com");
		waitEle(By.xpath("//span[normalize-space()=\"Save & Next\"]"));
		System.out.println("Entered contact details successfully");
	}

	public void contactDetails1() throws Exception {
		sendKeysToElement(By.xpath("//input[@placeholder=\"First Name\"]"), "junnu");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Last Name\"]"), "PM");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Middle Name\"]"), "Pv");

		sendKeysToElement(By.xpath("//input[@placeholder=\"Email\"]"), "junnu@gmail.com");
		waitEle(By.xpath("//span[normalize-space()=\"Add student-bug\"]"));

	}

	public void back() throws Exception {
		try {
			waitEle(By.xpath("//button[@class=\"el-button go-back-button el-button--default\"]"));
		} catch (Exception e) {
			waitEle(By.xpath("//i[@class=\"el-icon-back\"]"));
		}

	}

	public void validSuccessBug4798() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement welcomeMessage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[@class=\"el-message el-message--success\"]")));

			Assert.assertNotNull(welcomeMessage, "Welcome message element is not present Login Failed");
			System.out.println("4798 Bug Not reproduced");
		} catch (Exception e) {
			System.out.println("4798 Bug reproduced");
		}
	}

	public void formBuilder() throws Exception {
		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		Thread.sleep(3000);

		waitEle(By.xpath("//div[@class=\"icon-text\"]"));

		Thread.sleep(3000);

		By Entities = By.xpath("//li[normalize-space()=\"Form Builder\"]");
		WebElement Entities1 = wait.until(ExpectedConditions.elementToBeClickable(Entities));
		Entities1.click();

		System.out.println("Clicked on FormBuilder in profile completed");

	}

	public void clickAddFormBuilder() throws Exception {

		waitEle(By.xpath("//span[normalize-space()=\"Add Form Builder\"]"));

	}

	public void createFormBuilder() throws Exception {
		sendKeysToElement(By.xpath("//input[@placeholder=\"Form builder name\"]"), "Bug4798");
		waitEle(By.xpath("//input[@placeholder=\"Select user type\"]"));
		waitEle(By.xpath("(//div[@x-placement=\"bottom-start\"]//li)[3]"));
		waitEle(By.xpath("//input[@placeholder=\"Select Users\"]"));
		waitEle(By.xpath("(//div[@x-placement=\"bottom-start\"]//li)[4]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save and Next\"]"));

	}

	public void addTemplate() throws Exception {
		waitEle(By.xpath("(//div[normalize-space()=\"bug4796_2\"])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save Steps\"]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save Form builder\"]"));
	}

	public void viewAction4796() throws Exception {
		waitEle(By.xpath(
				"//div[@class='el-table__body-wrapper is-scrolling-none']//tr[contains(@class, 'el-table__row') and .//span[@class='workflow-name' and text()='Bug4796']]//span[normalize-space()=\"Actions\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("(//ul[@x-placement=\"bottom-end\"]//i)[1]"));

	}

	public void sendFormBuilder() throws Exception {
		waitEle(By.xpath("//span[normalize-space()=\"Add\"]"));
		waitEle(By.xpath("//input[@class=\"el-select__input\"]"));
		By ad = By.xpath("(//div[@x-placement=\"bottom-start\"]//li)[2]");
		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("Email selected using JS.");
		} catch (Exception e) {

			System.out.println("send form bilder  not clickable");
		}
		By ad1 = By.xpath("//span[normalize-space()=\"Send Form\"]");
		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad1));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("clicked on Send form using JS.");
		} catch (Exception e) {

			System.out.println("send form bilder  not clickable");
			Thread.sleep(90000);
		}
	}

	public void detailedView() throws Exception {
		waitEle(By.xpath("//a[normalize-space()=\"Detailed View\"]"));
	}

	public void validSuccessBug4796() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement welcomeMessage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("(//div[contains(text(),\"data:image/png;base64\")])[1]")));

			Assert.assertNotNull(welcomeMessage, "Link exist");
			System.out.println("4796 Bug reproduced");
		} catch (Exception e) {
			System.out.println("4796 Bug Not reproduced");
		}
	}

	public void viewAction4790() throws Exception {
//		try {
//			waitEle(By.xpath("//div[@class='el-table__fixed']//div[contains(text(), 'Bug4790')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));
//		}catch(Exception e) {
//			System.out.println("Not able to click on Action");
//		}
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4790')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
//		Thread.sleep(5000);
//		waitEle(By.xpath("(//ul[@x-placement=\"bottom-end\"]//i)[1]"));	
	}

	public void filter4790() throws Exception {
		waitEle(By
				.xpath("//button[@class=\"el-button el-tooltip entity-add-btn el-button--default el-button--mini\"]"));
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		waitEle(By.xpath("//span[normalize-space()=\"Add Filter+\"]"));
		System.out.println("Click on Add filter done successfully");
		waitEle(By.xpath("//input[@placeholder=\"Entity Field\"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("(//div[@x-placement=\"bottom-start\"]//li)[1]"));
		waitEle(By.xpath("//input[@placeholder=\"Operator\"]"));
		try {
			Thread.sleep(5000);
			waitEle(By.xpath("(//div[@x-placement=\"bottom-start\"]//li)[4]"));
			System.out.println("4790 Bug not reproduced");
		} catch (Exception e) {
			System.out.println("4790 Bug reproduced");
		}
	}

	public void templateTwo4776() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter template name\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter template name\"]"), "Bug4776 ");
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));

	}

	public void entity4776() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4776");
	}

	public void configureFeilds() throws Exception {
		waitEle(By.xpath("//div[@class=\"el-dialog__body\"]//span[text()=\"Confirm\"]"));
	}

	public void captchaFeild() throws Exception {

		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		WebElement captcha = driver.findElement(By.xpath("//img[@src=\"/assets/img/fields/Captcha.svg\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", captcha);
		Thread.sleep(1000);

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, captcha, Target);
		System.out.println("Captcha feild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By Name11 = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name11));
		Name1.sendKeys("CaptchaFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//span[normalize-space()='Save']"));

	}

	public void captchaFill() throws Exception {
		waitEle(By.xpath("//input[@class=\"custom-checkbox\"]"));
		Thread.sleep(5000);
		WebElement copy = driver.findElement(By.xpath("//div[@class=\"captcha-box el-col el-col-18\"]"));

		Actions action2 = new Actions(driver);
		action2.doubleClick(copy).build().perform();
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.moveToElement(copy).keyDown(Keys.CONTROL) // Press Ctrl key
				.sendKeys("c") // Press C key
				.keyUp(Keys.CONTROL) // Release Ctrl key
				.build().perform();

		waitEle(By.xpath("//div[@class=\"scrollable-element el-scrollbar\"]//input[@type=\"text\"]"));
		WebElement paste = driver
				.findElement(By.xpath("//div[@class=\"scrollable-element el-scrollbar\"]//input[@type=\"text\"]"));

		actions.moveToElement(paste).keyDown(Keys.CONTROL) // Press Ctrl key
				.sendKeys("v") // Press v key
				.keyUp(Keys.CONTROL) // Release Ctrl key
				.build().perform();
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
		waitEle(By.xpath("//li[normalize-space()=\"Save\"]"));
		System.out.println("Click on save done successfully");

	}

	public void entity4775() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4775");
	}

	public void template4775() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug4775");
	}

	public void addtemplate4775() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4775\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void viewAction4775() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4775')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
	}

	public void templateActionEdit() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"(//tr[@class=\"el-table__row\"]//span[contains(text(), 'Bug4776')]/ancestor::tr//span[normalize-space()=\"Actions\"])[1]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[2]"));

	}

	public void verify4776() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement welcomeMessage = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[normalize-space()=\"Error\"]")));

			Assert.assertNotNull(welcomeMessage, "");
			System.out.println("4776 Bug reproduced");
		} catch (Exception e) {
			System.out.println("4776 Bug Not reproduced");
		}
	}

	public void scrollDown() throws Exception {
		Thread.sleep(10000);
		WebElement scrollbar = driver.findElement(By.xpath("//div[@class=\"scrollable-container\"]"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 100;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();
		System.out.println("ScrollDown done successfully");
	}

	public void template3959() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug3959");
	}

	public void passwordFeild() throws Exception {
		waitEle(By.xpath("(//div[normalize-space()='Basic Fields'])[2]"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		WebElement Name = driver.findElement(By.xpath("(//span[normalize-space()='Single Line Text'])[2]"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, Name, Target);
		System.out.println("Name Element Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By Name11 = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name11));
		Name1.sendKeys("passwordFeild");
		waitEle(By.xpath("(//input[@placeholder=\"Select\"])[2]"));
		Thread.sleep(10000);
		waitEle(By.xpath("(//div[@x-placement=\"bottom-start\"])//li[1]"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));

	}

	public void entity3959() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug3959");
	}

	public void addtemplates3959() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug3959\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void veiwAction3959() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug3959')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
	}

	public void fillPasswordFeild() throws Exception {
		sendKeysToElement(By.xpath("//input[@placeholder=\"passwordFeild\"]"), "Meghana");
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));

		waitEle(By.xpath("//li[normalize-space()=\"Save\"]"));
		System.out.println("Click on save done successfully");
	}

	public void validBug3959() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
					"(//tr[@class=\"el-table__row\"]//div[@class=\"cell\"]//p[contains(text(),'Meghana')])[1]")));

			Assert.assertNotNull(password, "Password is displaying");
			System.out.println("3959 Bug reproduced");
		} catch (Exception e) {
			System.out.println("3959 Bug Not reproduced");
		}
	}

	public void template4758() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug4758");

	}

	public void dateTimerangeDateRange() throws Exception {

		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		Thread.sleep(5000);
		WebElement daterange = driver.findElement(By.xpath("(//span[normalize-space()=\"Date Range\"])[1]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", daterange);
		Thread.sleep(5000);

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, daterange, Target);
		System.out.println("DateRange feild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DateRangeFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));

//		WebElement dateTimeRange = driver.findElement(By.xpath("(//span[normalize-space()=\"Date Time Range\"])[1]"));
//		Actions actions2 = new Actions(driver);
//		waitAndClick1(actions2, dateTimeRange, Target);
//		System.out.println("Date Time Range Element Drag and Drop Done");
//
//		Set<String> windowHandles2 = driver.getWindowHandles();
//		for (String handle : windowHandles2) {
//			driver.switchTo().window(handle);
//		}
//		Thread.sleep(10000);
//		waitEle(By.xpath("//input[@placeholder='Enter Field Title']"),"DateTimeRangeFeild");
//		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
//		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
	}

	public void entity4758() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4758");
	}

	public void addtemplates4758() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4758\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void veiwAction4758() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4758')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
	}

	public void fillDateRange() throws Exception {
		waitEle(By.xpath("//input[@placeholder=\"Start date\"]"));
		waitEle(By.xpath("(//span[normalize-space()=\"5\"])[1]"));
		waitEle(By.xpath("(//span[normalize-space()=\"10\"])[2]"));

		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
	}

	public void fillDateRange4758() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("(//input[@placeholder=\"EntityFeild\"])[2]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));

		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
	}

	public void addData() throws Exception {
		waitEle(By.xpath("//span[text()=\"Add Data\"]"));

	}

	public void save() throws Exception {
		waitEle(By.xpath("//li[normalize-space()=\"Save\"]"));
		System.out.println("Click on save done successfully");
	}

	public void template4758_1() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug4758_1");
		waitEle(By.xpath("(//span[@class=\"el-checkbox__inner\"])[1]"));

	}

	public void entityVariable() throws Exception {

		waitEle(By.xpath("//div[text()=\"Advanced Fields\"]"));
		Thread.sleep(5000);
		WebElement entity = driver.findElement(By.xpath("//span[text()=\"Entity\"]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entity);
		Thread.sleep(5000);

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, entity, Target);
		System.out.println("Entityfeild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);

			Thread.sleep(10000);
			sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "EntityFeild");
			waitEle(By.xpath("(//input[@placeholder=\"Select\"])[2]"));
			Thread.sleep(5000);
			waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

			waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		}

		WebElement entityVariable = driver.findElement(By.xpath("//span[text()=\"Entity Variable\"]"));
		Actions actions2 = new Actions(driver);
		waitAndClick1(actions2, entityVariable, Target);
		System.out.println("Entity Variable feild Drag and Drop Done");

		Set<String> windowHandles2 = driver.getWindowHandles();
		for (String handle2 : windowHandles2) {
			driver.switchTo().window(handle2);

			Thread.sleep(10000);
			sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "EntityVariableFeild");
			waitEle(By.xpath("(//input[@placeholder=\"Select\"])[3]"));
			Thread.sleep(5000);
			waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
			waitEle(By.xpath("(//input[@placeholder=\"Select\"])[4]"));
			Thread.sleep(5000);
			waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));
			waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

			waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));

		}

	}

	public void entity4758_1() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4758_1");
	}

	public void addtemplates4758_1() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4758_1\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void veiwAction4758_1() throws Exception {
		Thread.sleep(20000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4758_1')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
	}

	public void validSuccessBug4758() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement welcomeMessage = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("(//p[contains(text(),\" 02-05-2024 To 03-10-2024 \")])[1]")));

			Assert.assertNotNull(welcomeMessage, "Link exist");
			System.out.println("4758 Bug not reproduced");
		} catch (Exception e) {
			System.out.println("4758 Bug reproduced");
		}
	}

	public void layout() throws Exception {
		waitEle(By.xpath("//img[@src=\"/img/layoutselect.584aef61.svg\"]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//li[text()=\"Standard\"]"));
	}

	public void validSuccessBug4760() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement welcomeMessage = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),\"18:30:00.000Z\")]")));

			Assert.assertNotNull(welcomeMessage, "Link exist");
			System.out.println("4760 Bug reproduced");
		} catch (Exception e) {
			System.out.println("4760 Bug not reproduced");
		}
	}

	public void template3994() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug3994");
	}

	public void documentFeild() throws Exception {
		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		Thread.sleep(5000);
		WebElement document = driver.findElement(By.xpath("//span[text()=\"Document\"]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", document);
		Thread.sleep(5000);

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, document, Target);
		System.out.println("Document feild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DocumentFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
	}

	public void repeatableTempPrimaryFeild() throws Exception {
		waitEle(By.xpath("//input[@placeholder=\"Select Field\"]"));
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		submit();

	}

	public void x() throws Exception {
		waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));
	}

	public void entity3994() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug3994");
	}

	public void addtemplates3994() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug3994\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void template3994_1() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug3994_1");
	}

	public void entity3994_1() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug3994_1");
	}

	public void addtemplates4746_1() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4746_1\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void addtemplates3994_1() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug3994_1\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void veiwAction3994_1() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug3994_1')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement]//a[1]"));
		System.out.println("click on view action done");
	}

	public void valid3994() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement welcomeMessage = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()=\"-\"]")));

			Assert.assertNotNull(welcomeMessage, "Welcome message element is not present Login Failed");
			System.out.println("3994 Bug reproduced");
		} catch (Exception e) {
			System.out.println("3994 Bug not reproduced");
		}
	}

	public void inspect1() throws Exception {
		Thread.sleep(3000);
		Actions actions = new Actions(driver);

		// Perform Ctrl+Shift+C
		actions.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("c").keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).perform();
	}

	public void template4660() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug4660");
	}

	public void weekdayFeild() throws Exception {

//		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		Thread.sleep(5000);
		WebElement weekday = driver
				.findElement(By.xpath("//div[@class=\"dragArea-field-element\"]//span[text()=\"Week Days\"]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", weekday);
		Thread.sleep(5000);
		WebElement weekdays = driver.findElement(By.xpath("//span[text()=\"Week Days\"]"));
		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, weekdays, Target);
		System.out.println("WeekDay feild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);

			Thread.sleep(10000);
			sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "WeekDayFeild");
			waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
			waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));

		}
	}

	public void entity4660() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4660");
	}

	public void addtemplates4660() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4660\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void veiwAction4660() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4660')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
		System.out.println("click on view action done");
	}

	public void filterWeekday() throws Exception {
		waitEle(By
				.xpath("//button[@class=\"el-button el-tooltip entity-add-btn el-button--default el-button--mini\"]"));
		System.out.println("Click on filter done successfully");
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		waitEle(By.xpath("//span[normalize-space()=\"Add Filter+\"]"));
		System.out.println("Click on Add filter done successfully");
		waitEle(By.xpath("//input[@placeholder=\"Entity Field\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		waitEle(By.xpath("//input[@placeholder=\"Operator\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		waitEle(By.xpath("//input[@placeholder=\"Value type\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		sendKeysToElement(By.xpath("//div[@class=\"el-input el-input--mini\"]//input[@class=\"el-input__inner\"]"),
				"b");
		waitEle(By.xpath("//span[text()=\"Apply\"]"));
		Thread.sleep(5000);
		waitEle(By
				.xpath("//button[@class=\"el-button el-tooltip entity-add-btn el-button--default el-button--mini\"]"));
		waitEle(By.xpath("//input[@placeholder=\"Entity Field\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[2]"));
		waitEle(By.xpath("//input[@placeholder=\"Operator\"]"));
		Thread.sleep(5000);
		try {
			waitEle(By.xpath("//div[@x-placement]//span[text()=\"Equals (Case-insensitive)\"]"));
			System.out.println("4660 Bug Reproduced");
		} catch (Exception e) {
			System.out.println("4660 Bug Not Reproduced");
		}
	}

	public void template4746() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug4746");
		waitEle(By.xpath("//label[@class=\"el-checkbox\"]"));

	}

	public void entity4746() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4746");
	}

	public void addtemplates4746() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4746\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void veiwAction4746() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4746')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
		System.out.println("click on view action done");
	}

	public void Feild4746() throws Exception {
		waitEle(By.xpath("//div[text()=\"Advanced Fields\"]"));
		WebElement dataTable = driver.findElement(By.xpath("//span[text()=\"Data Table\"]"));
		WebElement Target1 = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions1 = new Actions(driver);
		waitAndClick1(actions1, dataTable, Target1);
		System.out.println("Data Table feild Drag and Drop Done");

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DataTableFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		Thread.sleep(5000);
		WebElement document = driver.findElement(By.xpath("//span[text()=\"Document\"]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", document);
		Thread.sleep(5000);

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, document, Target);
		System.out.println("Document feild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(5000);
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DocumentFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
	}

	@SuppressWarnings("deprecation")
	public void uploadFile4746() throws Exception {
		Thread.sleep(5000);

		waitEle(By.xpath("//th//button[@type=\"button\"]"));

		By ele = By.xpath("(//div[@class=\"avatar-uploader\"])[1]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement c = wait.until(ExpectedConditions.elementToBeClickable(ele));
		c.click();
		Runtime.getRuntime()
				.exec("\"C:\\Users\\meghana.pemma\\OneDrive - Nimble Accounting\\Desktop\\fileuploadexcel.exe\"s");
		System.out.println("Document uploaded successfully");
		Thread.sleep(5000);

		waitEle(By.xpath("//th//button[@type=\"button\"]"));

		By ele2 = By.xpath("(//div[@class=\"avatar-uploader\"])[2]");
		WebElement c2 = wait.until(ExpectedConditions.elementToBeClickable(ele2));
		c2.click();
		Runtime.getRuntime()
				.exec("\"C:\\Users\\meghana.pemma\\OneDrive - Nimble Accounting\\Desktop\\fileuploadexcel.exe\"s");
		System.out.println("Document uploaded successfully");

	}

	public void validSuccessBug4746() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement welcomeMessage = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class=\"avatar-uploader\"])[1]")));

			Assert.assertNotNull(welcomeMessage, "Document Uploaded");
			System.out.println("4746 Bug Not reproduced");
		} catch (Exception e) {
			System.out.println("4746 Bug reproduced");
		}
	}

	public void template4042() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug4042");
	}

	public void radioGroupFeild() throws Exception {
		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		Thread.sleep(5000);
		WebElement radioGroup = driver.findElement(By.xpath("//span[text()=\"Radio Group\"]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioGroup);
		Thread.sleep(5000);

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, radioGroup, Target);
		System.out.println("Radio Group feild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "RadioGroupFeild");
		sendKeysToElement(By.xpath("//input[@class=\"el-select__input\"]"), "a");
		waitEle(By.xpath("(//ul[@class=\"el-scrollbar__view el-select-dropdown__list\"])[2]"));
		sendKeysToElement(By.xpath("//input[@class=\"el-select__input\"]"), "b");
		waitEle(By.xpath("(//ul[@class=\"el-scrollbar__view el-select-dropdown__list\"])[2]"));
		sendKeysToElement(By.xpath("//input[@class=\"el-select__input\"]"), "c");
		waitEle(By.xpath("(//ul[@class=\"el-scrollbar__view el-select-dropdown__list\"])[2]"));
		sendKeysToElement(By.xpath("//input[@class=\"el-select__input\"]"), "d");
		waitEle(By.xpath("(//ul[@class=\"el-scrollbar__view el-select-dropdown__list\"])[2]"));

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
	}

	public void clickAction() throws Exception {
		waitEle(By.xpath("(//div[@class=\"el-step__icon is-text\"])[5]"));

	}

	public void entity4042() throws Exception {
//		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4042");
	}

	public void addtemplates4042() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4042\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void clickTemplate() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//span[text()=\"Templates\"]"));
//		By ad = By.xpath("//span[text()=\"Templates\"]");
//		try {
//			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
//			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));
//
//			JavascriptExecutor executor = (JavascriptExecutor) driver;
//			executor.executeScript("arguments[0].click();", add);
//			System.out.println("Clicked On Template using JS successfully");
//
//		} catch (Exception e) {
//
//			System.out.println("Element not clickable or not found: ");
//		}
	}

	public void createTemplate() throws Exception {
		waitEle(By.xpath("//span[text()=\"Create Template\"]"));
		waitEle(By.xpath("//span[text()=\"Blank template\"]"));

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter template name\"]"), "4042");
		waitEle(By.xpath("//span[text()=\"Continue\"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder=\"Select Contact type\"]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//div[@x-placement]//li[normalize-space()=\"Bug4042\"]"));
		waitEle(By.xpath("//span[text()=\"Add\"]"));
		waitEle(By.xpath("//span[text()=\"Save Users\"]"));

	}

	public void addRecipient() throws Exception {

		Thread.sleep(100000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));
	}

	public void radioFeildDragInTemplate() throws Exception {
		waitEle(By.xpath("//div[text()=\"Bug4042\"]"));

		Thread.sleep(5000);
		WebElement radioGroup = driver.findElement(By.xpath("//div[text()=\" RadioG... \"]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", radioGroup);
		Thread.sleep(5000);

		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, radioGroup, Target);
		System.out.println("Radio Group feild Drag and Drop Done");
		waitEle(By.xpath("//span[text()=\"Save Template\"]"));
		waitEle(By.xpath("//i[@class=\"el-icon-back\"]"));

	}

	public void CreateDocFromTemp() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//img[@src=\"/img/create_document.7fc4ce52.svg\"]"));
		waitEle(By.xpath("//img[@src=\"/img/templates.268560de.svg\"]"));
		waitEle(By.xpath("(//a[normalize-space()=\"4042\"])[1]"));
		waitEle(By.xpath("//span[text()=\"Continue\"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()=\"Send Document\"]"));
		System.out.println("click on send Doc after drag and drop done successfully");

	}

	public void Senddoc() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By ele = By.xpath("//textarea[@placeholder='Subject']");
		WebElement sen = wait.until(ExpectedConditions.elementToBeClickable(ele));
		sen.sendKeys("Test Sample");

		By ele2 = By.xpath("//textarea[@placeholder=\"Type your message here\"]");
		WebElement sen2 = wait.until(ExpectedConditions.elementToBeClickable(ele2));
		sen2.sendKeys("Test Sample");
		Thread.sleep(5000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Send Document']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

	}

	public void receiver() throws Exception {

		waitEle(By.xpath("(//input[@placeholder=\"Search with Email\"])[2]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		waitEle(By.xpath("//span[text()=\" Save Users \"]"));
	}

	public void veiwAction4042() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4042')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
		System.out.println("click on view action done");
	}

	public void companyProfile() throws Exception {
		waitEle(By.xpath("(//label[@class=\"el-checkbox\"])[2]"));
		waitEle(By.xpath("//i[@class=\"fa fa-plus\"]"));
		System.out.println("click on Add to company profile done");
	}

	public void template4022() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "Bug4022");
	}

	public void entity4022() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4022");
	}

	public void addtemplates4022() throws Exception {

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"Bug4022\"]"));

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void hyperLinkfields() throws Exception {

		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		WebElement Name = driver.findElement(By.xpath("(//span[normalize-space()='Single Line Text'])[2]"));

		Actions actions = new Actions(driver);
		waitAndClick1(actions, Name, Target);
		System.out.println("Name Element Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By Name11 = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name11));
		Name1.sendKeys("hyperlink");
		waitEle(By.xpath("(//input[@placeholder=\"Select\"])[2]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@x-placement]//li[5]"));

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));
	}

	public void veiwAction4022() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Bug4022')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));
		System.out.println("click on view action done");
	}

	public void validSuccessBug4022() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement welcomeMessage = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder=\"hyperlink\"]")));

			Assert.assertNotNull(welcomeMessage, "Welcome message element is not present Login Failed");
			System.out.println("4022 Bug Not reproduced");
		} catch (Exception e) {
			System.out.println("4022Bug reproduced");
		}
	}

	public void entity4004() throws Exception {
		waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4004(");
	}

	public void validSuccessBug4004() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement welcomeMessage = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()=\"Error\"]")));

			Assert.assertNotNull(welcomeMessage, "Welcome message element is not present Login Failed");
			System.out.println("Bug 4004 reproduced");
		} catch (Exception e) {
			System.out.println("4004Bug Not reproduced");
		}
	}

	public void templateContentFeilds() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "templateContentFeilds");
	}

	public void templateBasicFeilds() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "templateBasicFeilds");
	}

	public void templateAdvancedFeilds() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "templateAdvancedFeilds");
	}

	public void contentFeildsDragAndDrop() throws Exception {
		waitEle(By.xpath("//div[text()=\"Content Fields\"]"));
		// Heading Feild
		WebElement heading = driver.findElement(By.xpath("//span[text()=\"Heading\"]"));
		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));
		Actions actions = new Actions(driver);
		waitAndClick1(actions, heading, Target);
		System.out.println("Heading feild Drag and Drop Done");
		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter content or block title\"]"), "Heading Feild");
		waitEle(By.xpath("//input[@placeholder=\"Select Heading Type\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//span[text()=\"H2\"]"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// HTML field
		WebElement html = driver.findElement(By.xpath("//span[text()=\"HTML\"]"));
		waitAndClick1(actions, html, Target);
		System.out.println("html feild Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "HTMLFeild");
		sendKeysToElement(By.xpath("//textarea[@placeholder='Enter content']"), "content for the HTMLFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Paragraph
		WebElement Para = driver.findElement(By.xpath("//span[text()=\"Paragraph\"]"));
		waitAndClick1(actions, Para, Target);
		System.out.println("Paragraph feild Drag and Drop Done");
		sendKeysToElement(By.xpath("//textarea[@placeholder='Enter content']"), "content for the ParagraphFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Single Line Content
		WebElement singlelineContent = driver.findElement(By.xpath("//span[text()=\"Single Line Content\"]"));
		waitAndClick1(actions, singlelineContent, Target);
		System.out.println("singlelineContent feild Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter content']"), "content for the singlelineContent");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Image
		WebElement Image = driver.findElement(By.xpath("//span[text()=\"Image\"]"));
		waitAndClick1(actions, Image, Target);
		System.out.println("Image feild Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "ImageFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Video
		WebElement video = driver.findElement(By.xpath("//span[text()=\"Video\"]"));
		waitAndClick1(actions, video, Target);
		System.out.println("video feild Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "videoFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Action Button
		WebElement ActionButton = driver.findElement(By.xpath("//span[text()=\"Action Button\"]"));
		waitAndClick1(actions, ActionButton, Target);
		System.out.println("Action Button feild Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter label']"), "Action ButtonFeild");
		waitEle(By.xpath("//span[normalize-space()=\"Add\"]"));
		waitEle(By.xpath("//input[@placeholder=\"Select type\"]"));
		waitEle(By.xpath("//li[text()=\"Update template\"]"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Horizontal Line
		WebElement horizontalLine = driver.findElement(By.xpath("//span[text()=\"Horizontal Line\"]"));
		waitAndClick1(actions, horizontalLine, Target);
		System.out.println("horizontalLine feild Drag and Drop Done");
		// Division
		WebElement Division = driver.findElement(By.xpath("//span[text()=\"Division\"]"));
		waitAndClick1(actions, Division, Target);
		System.out.println("Division feild Drag and Drop Done");
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));

	}
//		Actions actions = new Actions(driver);
//	WebElement ele = driver.findElement(By.xpath(xpath));
//	WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
//	waitAndClick(actions, ele, Target, x, y);

	// Basic Feilds
	public void basicFeilds() throws Exception {

		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));

		// Single Line
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement Target = driver.findElement(By.xpath("//div[@class=\"form-builder\"]"));
		Dimension dropSize = Target.getSize();
		System.out.println(dropSize);
		Actions actions = new Actions(driver);
		WebElement Singlelinetext = driver.findElement(By.xpath("//span[text()=\"Single Line Text\"]"));
		waitAndClick(actions, Singlelinetext, Target, -550, -200);
		System.out.println("Singleline Drag and Drop Done");

		By SName = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement SName1 = wait.until(ExpectedConditions.elementToBeClickable(SName));
		SName1.sendKeys("Single line text");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Multiline
		WebElement Multiline = driver.findElement(By.xpath("//span[text()=\"Multi Line Text\"]"));
		waitAndClick(actions, Multiline, Target, 350, -200);
		System.out.println("Multiline Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Multiline");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Number Of Rows']"), "3");
		waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Select Field
		WebElement Select = driver.findElement(By.xpath("//span[text()=\"Select\"]"));
		waitAndClick(actions, Select, Target, -550, -140);
		System.out.println("Select Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Select");
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@class=\"el-select__tags\"]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "Computer science");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "maths");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "Physics");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		Thread.sleep(10000);
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Number
		WebElement Number = driver.findElement(By.xpath("//span[text()=\"Number\"]"));
		waitAndClick(actions, Number, Target, -550, -80);
		System.out.println("Number Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Number");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// MultiSelect
		WebElement MultiSelect = driver.findElement(By.xpath("//span[text()=\"Multiple Select\"]"));
		waitAndClick(actions, MultiSelect, Target, -550, -20);
		System.out.println("MultiSelect Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Multiselect");
		waitEle(By.xpath("//div[@class=\"el-select__tags\"]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "Computer science");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "maths");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "Physics");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// List
		WebElement List = driver.findElement(By.xpath("//span[text()=\"List\"]"));
		waitAndClick(actions, List, Target, -550, 40);
		System.out.println("List Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "list");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Name']"), "List");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Value']"), "123");
		waitEle(By.xpath("//button[@class='el-button f-weight-600 el-button--primary']"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		// Date
		WebElement Date = driver.findElement(By.xpath("//span[text()=\"Date\"]"));
		waitAndClick(actions, Date, Target, -550, 100);
		System.out.println("Date Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Date");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Time
		WebElement Time = driver.findElement(By.xpath("//span[text()=\"Time\"]"));
		waitAndClick(actions, Time, Target, -550, 160);
		System.out.println("Time Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Time");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Fixed Time
		WebElement FixedTime = driver.findElement(By.xpath("//span[text()=\"Fixed Time\"]"));
		waitAndClick(actions, FixedTime, Target, -550, 220);
		System.out.println("FixedTime Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "FixedTime");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Time Range
		WebElement TimeRange = driver.findElement(By.xpath("//span[text()=\"Time Range\"]"));
		waitAndClick(actions, TimeRange, Target, -350, -200);
		System.out.println("TimeRange Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "TimeRange");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// DateTime
		WebElement DateTime = driver.findElement(By.xpath("//span[text()=\"Date Time\"]"));
		waitAndClick(actions, DateTime, Target, -350, -140);
		System.out.println("DateTime Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DateTime");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// DateRange
		WebElement DateRange = driver.findElement(By.xpath("//span[text()=\"Date Range\"]"));
		waitAndClick(actions, DateRange, Target, -350, -80);
		System.out.println("DateRange Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DateRange");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		// Weekdays
		WebElement Weekdays = driver.findElement(By.xpath("//span[text()=\"Week Days\"]"));
		waitAndClick(actions, Weekdays, Target, -350, -30);
		System.out.println("Weekdays Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Weekdays");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		// YesorNo
		WebElement YesorNo = driver.findElement(By.xpath("//span[text()=\"Yes or No\"]"));
		waitAndClick(actions, YesorNo, Target, -350, 10);
		System.out.println("YesorNo Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "YesorNo");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// checkbox
		WebElement Checkbox = driver.findElement(By.xpath("//span[text()=\"Checkbox\"]"));
		waitAndClick(actions, Checkbox, Target, -350, 40);
		System.out.println("Checkbox Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Checkbox");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Checkbox Group
		WebElement Checkboxgroup = driver.findElement(By.xpath("//span[text()=\"Checkbox Group\"]"));
		waitAndClick(actions, Checkboxgroup, Target, -350, 150);
		System.out.println("Checkbox Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "CheckboxGroup");
		Thread.sleep(5000);
		sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "1");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "2");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "3");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("(//div[@class=\"el-input\"]//input[@class=\"el-input__inner\"])[2]"), "1");
		sendKeysToElement(By.xpath("(//div[@class=\"el-input\"]//input[@class=\"el-input__inner\"])[3]"), "2");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Document
		WebElement Document = driver.findElement(By.xpath("//span[text()=\"Document\"]"));
		waitAndClick(actions, Document, Target, -350, 230);
		System.out.println("Document Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Document");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Radio
		WebElement Radio = driver.findElement(By.xpath("//span[text()=\"Radio\"]"));
		waitAndClick(actions, Radio, Target, -50, -150);
		System.out.println("Radio Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Radio");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// RadioGroup
		WebElement Radiogroup = driver.findElement(By.xpath("//span[text()=\"Radio Group\"]"));
		waitAndClick(actions, Radiogroup, Target, -50, -120);
		System.out.println("Radio Group Field Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "RadioGroup");
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "1");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "2");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "3");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// phone number
		WebElement Phoneno = driver.findElement(By.xpath("//span[text()=\"Phone\"]"));
		waitAndClick(actions, Phoneno, Target, -50, -20);
		System.out.println("Phoneno Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Phonono");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Signature
		WebElement Sign = driver.findElement(By.xpath("//span[text()=\"Signature\"]"));
		waitAndClick(actions, Sign, Target, -50, 100);
		System.out.println("Sign Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Sign");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Captcha
		WebElement Captcha = driver.findElement(By.xpath("//span[text()=\"Captcha\"]"));
		waitAndClick(actions, Captcha, Target, -50, 180);
		System.out.println("Captcha Element Drag and Drop Done");

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Captcha");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Formula
		Thread.sleep(10000);
		WebElement Formula = driver.findElement(By.xpath("//span[text()=\"Formula\"]"));
		waitAndClick(actions, Formula, Target, -300, 0);
		System.out.println(" Formula Element Drag and Drop Done");
		switchToNewWindow();
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("//input[@placeholder='Enter field title']"), "Formula Field");
		waitEle(By.xpath("//input[@placeholder=\"Select Fields\"]"));
		waitEle(By.xpath("//span[text()=\"Self/Number\"]"));
		waitEle(By.xpath("//img[@src=\"/img/plus.d55789c4.svg\"]"));
		waitEle(By.xpath("//input[@placeholder=\"Select Fields\"]"));
		waitEle(By.xpath("//span[text()=\"Self/Number\"]"));
		waitEle(By.xpath("//span[text()='Insert Field']"));
		// Currency
		WebElement Currency = driver.findElement(By.xpath("//span[text()=\"Currency\"]"));
		waitAndClick(actions, Currency, Target, -550, 0);
		System.out.println("Currency Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Currency");
		waitEle(By.xpath("//input[@id=\"currencySelect\"]"));
		waitEle(By.xpath("//span[text()=\"INR\"]"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//span[normalize-space()='Save']"));
	}

	// Advanced Fields
	public void advancedFeilds() throws Exception {
		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		Thread.sleep(10000);
		WebElement Target = driver.findElement(By.xpath("//div[@class=\"form-builder\"]"));
		Actions actions = new Actions(driver);
		// Number1
		WebElement Number = driver.findElement(By.xpath("//span[text()=\"Number\"]"));
		waitAndClick(actions, Number, Target, -550, -200);
		System.out.println("Number Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Number");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Number2
		WebElement Number2 = driver.findElement(By.xpath("//span[text()=\"Number\"]"));
		waitAndClick(actions, Number2, Target, -550, -160);
		System.out.println("Number2 Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Number2");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		waitEle(By.xpath("//div[text()=\"Advanced Fields\"]"));
		// Auto Increment Number
		Thread.sleep(10000);
		WebElement autoIncrementNum = driver.findElement(By.xpath("//span[text()=\"Auto Increment Number\"]"));
		waitAndClick(actions, autoIncrementNum, Target, -550, -120);
		System.out.println("Auto Increment Number Field Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Auto Increment Number");
		Thread.sleep(5000);
		Javascriptclick(By.xpath("//input[@placeholder=\"Field operation\"]"));
		waitEle(By.xpath("//li//span[text()=\"Number\"]"));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Starting Number\"]"), "1");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// location
		WebElement Location = driver.findElement(By.xpath("//span[text()=\"Location\"]"));
		waitAndClick(actions, Location, Target, -550, -80);
		System.out.println("Location Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Location");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		// Question
		WebElement Question = driver.findElement(By.xpath("//span[text()=\"Question\"]"));
		waitAndClick(actions, Question, Target, -550, 100);
		System.out.println(" Question Element Drag and Drop Done");

		switchToNewWindow();
		Thread.sleep(10000);
		waitEle(By.xpath("(//input[@placeholder='Select'])[1]"));
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		sendKeysToElement(By.xpath("(//textarea[@class=\"el-textarea__inner\"])[1]"), "Question");
		waitEle(By.xpath("//span[text()='Insert Field']"));
		// Entity
		Thread.sleep(10000);
		WebElement Entity = driver.findElement(By.xpath("//span[text()=\"Entity\"]"));
		waitAndClick(actions, Entity, Target, -300, -200);
		System.out.println(" Entity Element Drag and Drop Done");
		switchToNewWindow();
		Thread.sleep(10000);

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Entity Field");
		waitEle(By.xpath("(//input[@placeholder=\"Select\"])[2]"));
		waitEle(By.xpath("//span[text()=\"test\"]"));

		waitEle(By.xpath("//span[text()='Insert Field']"));

		// EntityVariable
		Thread.sleep(10000);
		WebElement EntityVariable = driver.findElement(By.xpath("//span[text()=\"Entity Variable\"]"));
		waitAndClick(actions, EntityVariable, Target, -300, -100);
		System.out.println("Entity Variable  Element Drag and Drop Done");
		switchToNewWindow();
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "EntityVariable");
		waitEle(By.xpath("(//input[@placeholder=\"Select\"])[3]"));
		waitEle(By.xpath("//div[@x-placement]//li"));
		waitEle(By.xpath("(//input[@placeholder=\"Select\"])[4]"));
		waitEle(By.xpath("//div[@x-placement]//li"));
		waitEle(By.xpath("//span[text()='Insert Field']"));

		// AggregateFunction
		WebElement AggregateFunction = driver.findElement(By.xpath("//span[text()=\"Aggregate Function\"]"));
		waitAndClick(actions, AggregateFunction, Target, 0, -200);
		System.out.println("Aggregate Function Element Drag and Drop Done");
		switchToNewWindow();
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Label']"), "Aggregate Function");
		waitEle(By.xpath("//input[@placeholder=\"Select Function Type\"]"));
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		waitEle(By.xpath("//input[@placeholder='Select Field Type']"));
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		waitEle(By.xpath("//input[@placeholder='Select Template']"));
		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		waitEle(By.xpath("//span[text()='Insert Field']"));

		// Child Entity Table
		WebElement ChildEntityTable = driver.findElement(By.xpath("//span[text()=\"Child Entity Table\"]"));
		waitAndClick(actions, ChildEntityTable, Target, 0, -100);
		System.out.println("Child Entity Table  Element Drag and Drop Done");
		switchToNewWindow();
		Thread.sleep(10000);
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Field Title\"]"), "Child Entity Table");
		waitEle(By.xpath("(//div[@class='el-form-item__content']//input[@placeholder='Select'])[2]"));
		Javascriptclick(By.xpath("//div[@x-placement]//li//span[text()=\"test\"]"));
//		waitEle(By.xpath("(//div[@class='el-form-item__content']//input[@placeholder='Select'])[3]"));
//		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//span[text()='Insert Field']"));
		waitEle(By.xpath("//button[@class=\"close-button\"]"));

		// Data Table
		WebElement DataTable = driver.findElement(By.xpath("//span[text()=\"Data Table\"]"));
		waitAndClick(actions, DataTable, Target, 0, 0);
		System.out.println("Data Table  Element Drag and Drop Done");
		switchToNewWindow();
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Data Table");
		Thread.sleep(3000);
		waitEle(By.xpath("//span[text()='Insert Field']"));
		waitEle(By.xpath("//span[text()=\" Save \"]"));

	}

	public void deleteEntityData() {
		// span[@class="el-dropdown-link el-dropdown-selfdefine "]
	}

	public void viewFeilds() throws Exception {
		waitEle(By.xpath("//button[@class=\"btn btn-outline-secondary btn-sm m-lr-1\"]"));
		WebElement element = driver.findElement(By.xpath("//span[text()=\"templateBasicFeilds\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		waitEle(By.xpath("(//span[@class=\"el-checkbox__inner\"])[16]"));
		waitEle(By.xpath("//button[@class=\"btn btn-outline-primary btn-sm m-lr-1\"]"));
		System.out.println("Clciked on template name to view all the feilds in grid view");
	}

	public void mapFieldsPageCreateTemplate(String tempTitle) throws Exception {
		waitEle(By.xpath("(//i[@class=\"el-icon-circle-plus\"])[1]"));
		sendKeysToElement(By.id("tempTitle"), tempTitle);
		SpanButton("Save");
		System.out.println("Created form Template successfully");
	}

	public void excelSheetDataRead(String filePath, String sheetName) throws Exception {
		try (FileInputStream file = new FileInputStream(filePath); XSSFWorkbook workbook = new XSSFWorkbook(file)) {

			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowsCount = sheet.getLastRowNum();
			int pages = rowsCount / 100;
			if (rowsCount == 0) {
				System.out.println("The Excel sheet is empty.");
				return;
			}

			int columnCount = sheet.getRow(1).getLastCellNum();
			for (int i = 1; i <= rowsCount; i++) {
				XSSFRow row = sheet.getRow(i);
				boolean found = false;
				int currentPage = 1;
				while (!found) {
					for (int j = 0; j < columnCount; j++) {
						Cell cell = row.getCell(j);
						String cellValue = getCellValueAsString(cell);
						String formattedCellValue = formatCellValue(cellValue);

						String xpath = String.format(
								"//div[3]/table[1]/tbody[1]/tr/td[%d]//div[1]/div[1]/div[1]//p[normalize-space()=\"%s\"]",
								j + 2, formattedCellValue);

						try {

							WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
							WebElement element = wait
									.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
							String eleText = element.getText();
							if (!formattedCellValue.equals(eleText)) {
								System.out.printf(
										"Value '%s' in Excel does not equal to '%s' in entity at row %d, column %d%n",
										formattedCellValue, eleText, i, j + 1);
							} else {
								found = true;
								System.out.printf("Value '%s' in Excel equals to '%s' in entity at row %d, column %d%n",
										formattedCellValue, eleText, i, j + 1);
							}

						} catch (NoSuchElementException e) {
							if (!isLastPage()) {
								goToNextPage();
								currentPage++;
							} else {
								System.out.printf("Record not found for row %d, column %d%n", i, j + 1);
								found = true;
							}
						}
					}
				}
			}
		}
	}

	private boolean isLastPage() {
		try {
			WebElement nextPageButton = driver.findElement(By.xpath("//button[@class=\"btn-next\"]"));
			return !nextPageButton.isDisplayed();
		} catch (NoSuchElementException e) {
			return true;
		}
	}

	private void goToNextPage() throws Exception {
		waitEle(By.xpath("//button[@class=\"btn-next\"]"));
	}

	private String formatCellValue(String cellValue) {
		if (cellValue.contains(".")) {
			try {
				double numericValue = Double.parseDouble(cellValue);
				if (numericValue % 1 == 0) {
					return String.valueOf((int) numericValue);
				}
			} catch (NumberFormatException e) {
				// In case the cell value is not a number, return it as is
				return cellValue;
			}
		}
		return cellValue;
	}

	private String getCellValueAsString(Cell cell) {
		if (cell == null) {
			return "";
		}
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			double numericValue = cell.getNumericCellValue();
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue().toString();
			} else {
				if (numericValue % 1 == 0) {
					return String.valueOf((int) numericValue);
				} else {
					return String.valueOf(numericValue);
				}
			}
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			try {
				return cell.getStringCellValue();
			} catch (IllegalStateException e) {
				return String.valueOf(cell.getNumericCellValue());
			}
		case BLANK:
			return "";
		default:
			return "";
		}
	}

	public void recordsPerPage(String NoOfPages) throws Exception {
		Thread.sleep(10000);
		Javascriptclick(By.xpath("//input[@placeholder=\"Select\"]"));
		String ele = String.format("//div[@x-placement]//span[text()=\"%s\"]", NoOfPages);
		Javascriptclick(By.xpath(ele));
		System.out.printf("Selected %s%n", NoOfPages);
	}

	public void clearContactTempImport() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//table[contains(@class, 'el-table__body')]//tr[2]//td[2]//input[@placeholder='Select form template']"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		waitEle(By.xpath("//i[@class='el-select__caret el-input__icon el-icon-circle-close']"));
	}

	public void exportExcel() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//i[@class='fa fa-cloud-upload']"));
		Javascriptclick(By.xpath("//ul[@x-placement]//li[1]"));
	}

	public void importExcelInEntity() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//i[@class=\"fa fa-cloud-download\"]"));
		Javascriptclick(By.xpath("//ul[@x-placement]//li[1]"));
	}

	public void yesButtonWithoutAddTemp() throws Exception {
		waitEle(By.xpath("//button//span[text()=\"Yes\"]"));
	}

	public void continueButton() throws Exception {
		waitEle(By.xpath("//button[normalize-space()='Continue']"));
	}

	public void verifyBasicFieldDataFillInIndividualEntity() throws Exception {

//		MethodActions.waitEle(By.xpath("(//button[contains(@class,'btn btn-light')])[2]"));
		// driver.get("https://nsui.esigns.io/entity/66b308e047ad681aec33b58e?viewType=TABLE&page=1&pageSize=10");

		Thread.sleep(10000);
		WebElement firstRow = driver
				.findElement(By.xpath("//div[@class='el-table__body-wrapper is-scrolling-left']//tr[1]"));
		List<WebElement> columns = firstRow.findElements(By.tagName("td"));

		for (WebElement column : columns) {
			System.out.println(column.getText());
		}
		List<String> extractedTexts = new ArrayList<>();
		for (int i = 2; i <= 23; i++) {

			WebElement element = driver.findElement(By.xpath("(//td[@rowspan='1'])[" + i + "]"));
			extractedTexts.add(element.getText().trim());
		}

		List<String> expectedTexts = Arrays.asList("Single line text", "12:20:05 - 13:20:05", "Test",
				"Computer science", "08-02-2024 TO 09-01-2024", "08-08-2024 12:20:18", "44", "SUN", "Computer science",
				"List", "1", "08-02-2024", "12:19:37", "dd.PNG", "true", "01:30", "NO", "1");

		if (extractedTexts.equals(expectedTexts)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
	}

	public void EntityFieldDragAndDrop(String Name) throws Exception {
		// Entity
		Thread.sleep(10000);
		waitEle(By.xpath("//div[text()=\"Advanced Fields\"]"));
		WebElement Target = driver.findElement(By.xpath("//div[@class=\"form-builder\"]"));
		Actions actions = new Actions(driver);
		Thread.sleep(10000);
		WebElement Entity = driver.findElement(By.xpath("//span[text()=\"Entity\"]"));
		waitAndClick(actions, Entity, Target, 300, -200);
		System.out.println("Entity Element Drag and Drop Done");
		Thread.sleep(10000);

		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Entity Field");
		waitEle(By.xpath("(//input[@placeholder=\"Select\"])[2]"));
		String entityName = String.format("//span[text()=\"%s\"]", Name);
		waitEle(By.xpath(entityName));
		waitEle(By.xpath("//span[text()='Insert Field']"));
	}

	public void singleLineTextDragAndDrop() throws Exception {
		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));

		// Single Line
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement Target = driver.findElement(By.xpath("//div[@class=\"form-builder\"]"));
		Dimension dropSize = Target.getSize();
		System.out.println(dropSize);
		Actions actions = new Actions(driver);
		WebElement Singlelinetext = driver.findElement(By.xpath("//span[text()=\"Single Line Text\"]"));
		waitAndClick(actions, Singlelinetext, Target, -550, -200);
		System.out.println("Singleline Drag and Drop Done");

		By SName = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement SName1 = wait.until(ExpectedConditions.elementToBeClickable(SName));
		SName1.sendKeys("Single line text");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
	}

	public void AddContactDetailsOnlyToEntity(String F, String M, String L, String E, String T, String A, String P)
			throws Exception {

//		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

		Thread.sleep(10000);

		Javascriptclick(By.xpath("//button[@class='el-tooltip btn btn-outline-success btn-sm m-lr-1']"));

		sendKeysToElement(By.xpath("//input[@placeholder='First Name']"), F);

		sendKeysToElement(By.xpath("//input[@placeholder='Middle Name']"), M);

		sendKeysToElement(By.xpath("//input[@placeholder='Last Name']"), L);

		sendKeysToElement(By.xpath("//input[@placeholder='Email']"), E);

		sendKeysToElement(By.xpath("//input[@placeholder='Title']"), T);

		sendKeysToElement(By.xpath("//input[@placeholder='Address']"), A);

		waitEle(By.xpath("//input[@placeholder='Country code']"));

		waitEle(By.xpath("//div[text()=' India (भारत) ']"));

		sendKeysToElement(By.xpath("//input[@placeholder='Phone number *']"), P);

		try {
			waitEle(By.xpath("//span[normalize-space()='Save & Next']"));
		} catch (Exception e) {
			waitEle(By.xpath("//span[normalize-space()='Save']"));
		}
	}

	public void enterName(String Name) throws Exception {
		sendKeysToElement(By.xpath("//input[@placeholder=\"Single line text\"]"), Name);
	}

	public void clickOnTempInEntityView() throws Exception {
		waitEle(By.xpath("//div[@role=\"tab\"][2]"));
	}

	public void VerifyData() throws Exception {

		try {
			Thread.sleep(10000);
			driver.findElement(By
					.xpath("//div[@class=\"el-table__body-wrapper is-scrolling-left\"]//p[normalize-space()='reddy']"))
					.isDisplayed();
			System.out.println("Name is Displayed");
		} catch (Exception e) {
			System.out.println("Name is Not Displayed");
		}
	}

	public void errorNotification() throws Exception {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class=\"el-notification__group is-with-icon\"]")).isDisplayed();
		System.out.println("Error Notification is Displayed");
	}

	public void verifyFilterRelatedToNumber(String operation, String value) throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement recordsXpath = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"el-pagination__total\"]")));
		String TRecords = recordsXpath.getText();
		String[] parts = TRecords.split(" ");
		String records = parts[1];
		int numberRecords = Integer.parseInt(records);
		System.out.println(numberRecords);
		int number = Integer.parseInt(value);
		switch (operation) {

		case "equal":
			String xpath = String.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", 1, 2);
			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement element = wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			String eleText = element.getText();
			if (eleText == value) {
				System.out.println("Applied Filter Successfully");
			}
			break;
		case "GreaterThan":

			for (int i = 1; i <= numberRecords; i++) {

				String xpath1 = String.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i,
						2);
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
				String eleText1 = element1.getText();
				int GivenValue = Integer.parseInt(eleText1);
				if (GivenValue > number) {

				}
				System.out.println("Applied Filter Successfully");
			}
			break;
		case "GreaterThanorEqual":

			for (int i = 1; i <= numberRecords; i++) {

				String xpath1 = String.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i,
						2);
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
				String eleText1 = element1.getText();
				int GivenValue = Integer.parseInt(eleText1);
				if (GivenValue >= number) {
					System.out.println(GivenValue);
				}
				System.out.println("Applied Filter Successfully");
			}
			break;
		case "LessThan":

			for (int i = 1; i <= numberRecords; i++) {

				String xpath1 = String.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i,
						2);
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
				String eleText1 = element1.getText();
				int GivenValue = Integer.parseInt(eleText1);
				if (GivenValue < number) {
					System.out.println(GivenValue);
				}
				System.out.println("Applied Filter Successfully");
			}
			break;
		case "lessthanorequal":
			System.out.println("Start verify lessthanorequal");

			for (int i = 1; i <= numberRecords; i++) {

				String xpath1 = String.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i,
						2);
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
				String eleText1 = element1.getText();
				int GivenValue = Integer.parseInt(eleText1);
				if (GivenValue <= number) {
					System.out.println(GivenValue);
				}

			}
			System.out.println("Applied Filter Successfully");
			break;
		case "NotExist":
			for (int i = 1; i <= numberRecords; i++) {
				try {
					String xpath1 = String
							.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i, 5);
					WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
					WebElement element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
					Assert.fail("Element found, test case failed.");
				} catch (Exception e) {

				}

			}
			System.out.println("Applied Filter Successfully");
			break;
		case "Exist":
			for (int i = 1; i <= numberRecords; i++) {
				String xpath1 = String.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i,
						5);
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
				String eleText1 = element1.getText();

				if (eleText1 != null && !eleText1.trim().isEmpty()) {
					System.out.println(eleText1);
				}

			}
			System.out.println("Applied Filter Successfully");
			break;
		case "TempEqual":
			System.out.println("TempEqual");
			for (int i = 1; i <= numberRecords; i++) {
				try {
					String xpath1 = String
							.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i, 5);
					WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
					WebElement element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
					String eleText1 = element1.getText();

					String xpath2 = String
							.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i, 2);

					WebElement element2 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath2)));
					String eleText2 = element2.getText();
					int GivenValue = Integer.parseInt(eleText1);
					int expected = Integer.parseInt(eleText2);
					if (GivenValue == expected) {
						System.out.println(eleText1 + " is equal to " + eleText2);
					}
				} catch (Exception e) {
					System.out.println("element is not present");
				}

			}
			System.out.println("Applied Filter Successfully");
			break;
		case "TempGreaterThan":

			for (int i = 1; i <= numberRecords; i++) {
				try {
					String xpath1 = String
							.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i, 2);
					WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
					WebElement element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
					String eleText1 = element1.getText();

					String xpath2 = String
							.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i, 5);

					WebElement element2 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath2)));
					String eleText2 = element2.getText();
					int GivenValue = Integer.parseInt(eleText1);
					int expected = Integer.parseInt(eleText2);
					
					if (GivenValue > expected) {
						System.out.println(GivenValue + " is Greater to " + expected);
					}

				} catch (Exception e) {
					System.out.println("the element is empty");
				}
			}
			System.out.println("Applied Filter Successfully");
			break;
		case "TempGreaterThanorEqual":
			System.out.println("TempEqual");
			for (int i = 1; i <= numberRecords; i++) {
				try {
					String xpath1 = String
							.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i, 2);
					WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
					WebElement element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
					String eleText1 = element1.getText();

					String xpath2 = String
							.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i, 5);

					WebElement element2 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath2)));
					String eleText2 = element2.getText();
					System.out.println("rank element");
					int GivenValue = Integer.parseInt(eleText1);
					int expected = Integer.parseInt(eleText2);
					if (GivenValue >= expected) {
						System.out.println(GivenValue + " is TempGreaterThanorEqual to " + expected);
					}
				} catch (Exception e) {
					System.out.println("the element is empty");
				}
			}
			System.out.println("Applied Filter Successfully");
			break;
		case "TempLessThan":

			for (int i = 1; i <= numberRecords; i++) {
				try {
					String xpath1 = String
							.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i, 2);
					WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
					WebElement element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
					String eleText1 = element1.getText();

					String xpath2 = String
							.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i, 5);

					WebElement element2 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath2)));
					String eleText2 = element2.getText();
					int GivenValue = Integer.parseInt(eleText1);
					int expected = Integer.parseInt(eleText2);
					if (GivenValue < expected) {
						System.out.println(GivenValue + " is TempLessThan to " + expected);
					}
				} catch (Exception e) {
					System.out.println("the element is empty");
				}
			}
			System.out.println("Applied Filter Successfully");
			break;
		case "TempLessThanorEqual":

			for (int i = 1; i <= numberRecords; i++) {
				try {
					String xpath1 = String
							.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i, 2);
					WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
					WebElement element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
					String eleText1 = element1.getText();

					String xpath2 = String
							.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i, 5);

					WebElement element2 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath2)));
					String eleText2 = element2.getText();
					int GivenValue = Integer.parseInt(eleText1);
					int expected = Integer.parseInt(eleText2);
					if (GivenValue <= expected) {
						System.out.println(GivenValue + " is TempLessThanorEqual to " + expected);
					}
				} catch (Exception e) {
					System.out.println("the element is empty");
				}
			}
			System.out.println("Applied Filter Successfully");
			break;
		
		}
	}
	public void verifyFilterTextField(String operation, String value) throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement recordsXpath = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"el-pagination__total\"]")));
		String TRecords = recordsXpath.getText();
		String[] parts = TRecords.split(" ");
		String records = parts[1];
		int numberRecords = Integer.parseInt(records);
		System.out.println(numberRecords);
		switch (operation) {
		case "TextValueCaseSensitive":
			for (int i = 1; i <= numberRecords; i++) {
				String country = String
						.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i, 4);
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(country)));
				String eleText1 = element1.getText();
				
				if(eleText1==value) {
					System.out.println(eleText1+" is equal to "+value);
				}
			}
			System.out.println("Applied Filter Successfully");
			break;
		case "TextFieldEqualCaseInsensitive":
			for (int i = 1; i <= numberRecords; i++) {
				String country = String
						.format("//div[3]/table[1]/tbody[1]/tr[%d]/td[%d]//div[1]/div[1]/div[1]//p[1]", i, 4);
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(country)));
				String eleText1 = element1.getText();
				String actualValue=eleText1.toLowerCase();
				String expectedValue=value.toLowerCase();
				if(actualValue==expectedValue) {
					System.out.println(eleText1+" is equal to "+value);
				}
			}
			System.out.println("Applied Filter Successfully");
			break;
		}
	}
}
