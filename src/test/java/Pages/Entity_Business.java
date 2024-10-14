package Pages;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class Entity_Business {
	WebDriver driver;
	MethodActions methodActions;
	Login login;

	public Entity_Business(WebDriver driver) {
		this.driver = driver;
		methodActions = new MethodActions(driver);
		login = new Login(driver);
	}

	public void FormTemplate() throws Exception {

		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='icon-text']"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(3000);
		MethodActions.Javascriptclick(By.xpath("//li[normalize-space()=\"Form Template\"]"));

		System.out.println("Clicked on Form template in profile completed");

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
		MethodActions.waitEle(By.xpath("//div[@class=\"icons plus-symbol\"]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		By Name = By.xpath("//input[@placeholder='Enter Template Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name));
		Name1.sendKeys(s);

		By Description = By.xpath("//textarea[@placeholder='Enter Template Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("Test purpose");

	}

	public void CreaterepeatFormtemplate(String s) throws Exception {

		Thread.sleep(10000);

		By ad = By.xpath("//button[normalize-space()='Create Template']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked create FormTemplate using JS.");
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//div[@class=\"icons plus-symbol\"]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		By Name = By.xpath("//input[@placeholder='Enter Template Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name));
		Name1.sendKeys(s);

		By Description = By.xpath("//textarea[@placeholder='Enter Template Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("Repeatable Test purpose");

		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[1]"));

	}

	public void submit() throws Exception {
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Submit'])[1]"));
		System.out.println("Click on submit done successfully");

	}

// Basic Feilds
	public void basicFeilds() throws Exception {

		MethodActions.waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));

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
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Multiline
		WebElement Multiline = driver.findElement(By.xpath("//span[text()=\"Multi Line Text\"]"));
		waitAndClick(actions, Multiline, Target, 350, -200);
		System.out.println("Multiline Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Multiline");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Number Of Rows']"), "3");
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Select Field
		WebElement Select = driver.findElement(By.xpath("//span[text()=\"Select\"]"));
		waitAndClick(actions, Select, Target, -550, -140);
		System.out.println("Select Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Select");
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//div[@class=\"el-select__tags\"]"));
		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "Computer science");
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "maths");
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "Physics");
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Number
		WebElement Number = driver.findElement(By.xpath("//span[text()=\"Number\"]"));
		waitAndClick(actions, Number, Target, -550, -80);
		System.out.println("Number Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Number");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// MultiSelect
		WebElement MultiSelect = driver.findElement(By.xpath("//span[text()=\"Multiple Select\"]"));
		waitAndClick(actions, MultiSelect, Target, -550, -20);
		System.out.println("MultiSelect Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Multiselect");
		MethodActions.waitEle(By.xpath("//div[@class=\"el-select__tags\"]"));
		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "Computer science");

		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "maths");

		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "Physics");

		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// List
		WebElement List = driver.findElement(By.xpath("//span[text()=\"List\"]"));
		waitAndClick(actions, List, Target, -550, 40);
		System.out.println("List Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "list");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Name']"), "List");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Value']"), "123");
		MethodActions.waitEle(By.xpath("//button[@class='el-button f-weight-600 el-button--primary']"));
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		// Date
		WebElement Date = driver.findElement(By.xpath("//span[text()=\"Date\"]"));
		waitAndClick(actions, Date, Target, -550, 100);
		System.out.println("Date Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Date");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Time
		WebElement Time = driver.findElement(By.xpath("//span[text()=\"Time\"]"));
		waitAndClick(actions, Time, Target, -550, 160);
		System.out.println("Time Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Time");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Fixed Time
		WebElement FixedTime = driver.findElement(By.xpath("//span[text()=\"Fixed Time\"]"));
		waitAndClick(actions, FixedTime, Target, -550, 220);
		System.out.println("FixedTime Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "FixedTime");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Time Range
		WebElement TimeRange = driver.findElement(By.xpath("//span[text()=\"Time Range\"]"));
		waitAndClick(actions, TimeRange, Target, -350, -200);
		System.out.println("TimeRange Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "TimeRange");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// DateTime
		WebElement DateTime = driver.findElement(By.xpath("//span[text()=\"Date Time\"]"));
		waitAndClick(actions, DateTime, Target, -350, -140);
		System.out.println("DateTime Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DateTime");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// DateRange
		WebElement DateRange = driver.findElement(By.xpath("//span[text()=\"Date Range\"]"));
		waitAndClick(actions, DateRange, Target, -350, -80);
		System.out.println("DateRange Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DateRange");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		// Weekdays
		WebElement Weekdays = driver.findElement(By.xpath("//span[text()=\"Week Days\"]"));
		waitAndClick(actions, Weekdays, Target, -350, -30);
		System.out.println("Weekdays Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Weekdays");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		// YesorNo
		WebElement YesorNo = driver.findElement(By.xpath("//span[text()=\"Yes or No\"]"));
		waitAndClick(actions, YesorNo, Target, -350, 10);
		System.out.println("YesorNo Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "YesorNo");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// checkbox
		WebElement Checkbox = driver.findElement(By.xpath("//span[text()=\"Checkbox\"]"));
		waitAndClick(actions, Checkbox, Target, -350, 40);
		System.out.println("Checkbox Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Checkbox");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Checkbox Group
		WebElement Checkboxgroup = driver.findElement(By.xpath("//span[text()=\"Checkbox Group\"]"));
		waitAndClick(actions, Checkboxgroup, Target, -350, 150);
		System.out.println("Checkbox Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "CheckboxGroup");
		Thread.sleep(5000);
		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "1");
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "2");
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input is-mini']"), "3");
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		MethodActions.sendKeysToElement(By.xpath("(//div[@class=\"el-input\"]//input[@class=\"el-input__inner\"])[2]"),
				"1");
		MethodActions.sendKeysToElement(By.xpath("(//div[@class=\"el-input\"]//input[@class=\"el-input__inner\"])[3]"),
				"2");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Document
		WebElement Document = driver.findElement(By.xpath("//span[text()=\"Document\"]"));
		waitAndClick(actions, Document, Target, -350, 230);
		System.out.println("Document Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Document");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Radio
		WebElement Radio = driver.findElement(By.xpath("//span[text()=\"Radio\"]"));
		waitAndClick(actions, Radio, Target, -50, -150);
		System.out.println("Radio Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Radio");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// RadioGroup
		WebElement Radiogroup = driver.findElement(By.xpath("//span[text()=\"Radio Group\"]"));
		waitAndClick(actions, Radiogroup, Target, -50, -120);
		System.out.println("Radio Group Field Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "RadioGroup");
		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "1");
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "2");
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		MethodActions.sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "3");
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// phone number
		WebElement Phoneno = driver.findElement(By.xpath("//span[text()=\"Phone\"]"));
		waitAndClick(actions, Phoneno, Target, -50, -20);
		System.out.println("Phoneno Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Phonono");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Signature
		WebElement Sign = driver.findElement(By.xpath("//span[text()=\"Signature\"]"));
		waitAndClick(actions, Sign, Target, -50, 100);
		System.out.println("Sign Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Sign");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Captcha
		WebElement Captcha = driver.findElement(By.xpath("//span[text()=\"Captcha\"]"));
		waitAndClick(actions, Captcha, Target, -50, 180);
		System.out.println("Captcha Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Captcha");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save']"));
	}

	// Basic Feilds
	public void basicFeilds1() throws Exception {

		MethodActions.waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));

		// Single Line
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement Target = driver.findElement(By.xpath("//div[@class=\"form-builder\"]"));
		Dimension dropSize = Target.getSize();
		// System.out.println(dropSize);
		Actions actions = new Actions(driver);
		WebElement Singlelinetext = driver.findElement(By.xpath("//span[text()=\"Single Line Text\"]"));
		waitAndClick(actions, Singlelinetext, Target, -550, -200);
		System.out.println("Singleline Drag and Drop Done");

		By SName = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement SName1 = wait.until(ExpectedConditions.elementToBeClickable(SName));
		SName1.sendKeys("Single line text");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		// Number
		WebElement Number = driver.findElement(By.xpath("//span[text()=\"Number\"]"));
		waitAndClick(actions, Number, Target, -550, -80);
		System.out.println("Number Element Drag and Drop Done");

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Number");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save']"));
	}

	public void Primary() throws Exception {
		Thread.sleep(1000);
		MethodActions.Loadingmask();
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Field']"));
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[normalize-space()='Number']"));

	}

// Advanced Fields
	public void advancedFeilds() throws Exception {
		MethodActions.waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		Thread.sleep(10000);
		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));
		Actions actions = new Actions(driver);
		// Number1
		WebElement Number = driver.findElement(By.xpath("//span[text()=\"Number\"]"));
		waitAndClick(actions, Number, Target, -550, -200);
		System.out.println("Number Element Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Number");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Number2
		WebElement Number2 = driver.findElement(By.xpath("//span[text()=\"Number\"]"));
		waitAndClick(actions, Number2, Target, -550, -160);
		System.out.println("Number2 Element Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Number2");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		MethodActions.waitEle(By.xpath("//div[text()=\"Advanced Fields\"]"));
		// Auto Increment Number
		Thread.sleep(10000);
		WebElement autoIncrementNum = driver.findElement(By.xpath("//span[text()=\"Auto Increment Number\"]"));
		waitAndClick(actions, autoIncrementNum, Target, -550, -120);
		System.out.println("Auto Increment Number Field Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Auto Increment Number");
		Thread.sleep(5000);
		MethodActions.Javascriptclick(By.xpath("//input[@placeholder=\"Field operation\"]"));
		MethodActions.waitEle(By.xpath("//li//span[text()=\"Number\"]"));
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder=\"Starting Number\"]"), "1");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// location
		WebElement Location = driver.findElement(By.xpath("//span[text()=\"Location\"]"));
		waitAndClick(actions, Location, Target, -550, -80);
		System.out.println("Location Element Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Location");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Currency
		WebElement Currency = driver.findElement(By.xpath("//span[text()=\"Currency\"]"));
		waitAndClick(actions, Currency, Target, -550, 0);
		System.out.println("Currency Element Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Currency");
		MethodActions.waitEle(By.xpath("//input[@id=\"currencySelect\"]"));
		MethodActions.waitEle(By.xpath("//span[text()=\"INR\"]"));
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Question
		WebElement Question = driver.findElement(By.xpath("//span[text()=\"Question\"]"));
		waitAndClick(actions, Question, Target, -550, 100);
		System.out.println(" Question Element Drag and Drop Done");

		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[1]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.sendKeysToElement(By.xpath("(//textarea[@class=\"el-textarea__inner\"])[1]"), "Question");
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
		// Entity
		Thread.sleep(10000);
		WebElement Entity = driver.findElement(By.xpath("//span[text()=\"Entity\"]"));
		waitAndClick(actions, Entity, Target, -300, -200);
		System.out.println(" Entity Element Drag and Drop Done");
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Entity Field");
		MethodActions.waitEle(By.xpath("(//input[@placeholder=\"Select\"])[2]"));
		MethodActions.waitEle(By.xpath("//span[text()=\"test\"]"));

		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// EntityVariable
		Thread.sleep(10000);
		WebElement EntityVariable = driver.findElement(By.xpath("//span[text()=\"Entity Variable\"]"));
		waitAndClick(actions, EntityVariable, Target, -300, -100);
		System.out.println("Entity Variable  Element Drag and Drop Done");
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "EntityVariable");
		MethodActions.waitEle(By.xpath("(//input[@placeholder=\"Select\"])[3]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li"));
		MethodActions.waitEle(By.xpath("(//input[@placeholder=\"Select\"])[4]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
		// Formula
		Thread.sleep(10000);
		WebElement Formula = driver.findElement(By.xpath("//span[text()=\"Formula\"]"));
		waitAndClick(actions, Formula, Target, -300, 0);
		System.out.println(" Formula Element Drag and Drop Done");
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter field title']"), "Formula Field");
		MethodActions.waitEle(By.xpath("//input[@placeholder=\"Select Fields\"]"));
		MethodActions.waitEle(By.xpath("//span[text()=\"Self/Number\"]"));
		MethodActions.waitEle(By.xpath("//img[@src=\"/img/plus.d55789c4.svg\"]"));
		MethodActions.waitEle(By.xpath("//input[@placeholder=\"Select Fields\"]"));
		MethodActions.waitEle(By.xpath("//span[text()=\"Self/Number2\"]"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// AggregateFunction
		WebElement AggregateFunction = driver.findElement(By.xpath("//span[text()=\"Aggregate Function\"]"));
		waitAndClick(actions, AggregateFunction, Target, 0, -200);
		System.out.println("Aggregate Function Element Drag and Drop Done");
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Label']"), "Aggregate Function");
		MethodActions.waitEle(By.xpath("//input[@placeholder=\"Select Function Type\"]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Field Type']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select Template']"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// Child Entity Table
		WebElement ChildEntityTable = driver.findElement(By.xpath("//span[text()=\"Child Entity Table\"]"));
		waitAndClick(actions, ChildEntityTable, Target, 0, -100);
		System.out.println("Child Entity Table  Element Drag and Drop Done");
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Field Title\"]"), "Child Entity Table");
		MethodActions.waitEle(By.xpath("(//div[@class='el-form-item__content']//input[@placeholder='Select'])[2]"));
		MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//li//span[text()=\"test\"]"));
//		waitEle(By.xpath("(//div[@class='el-form-item__content']//input[@placeholder='Select'])[3]"));
//		waitEle(By.xpath("//div[@x-placement]//li[1]"));
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
		MethodActions.waitEle(By.xpath("//button[@class=\"close-button\"]"));

		// Data Table
		WebElement DataTable = driver.findElement(By.xpath("//span[text()=\"Data Table\"]"));
		waitAndClick(actions, DataTable, Target, 0, -250);
		System.out.println("Data Table  Element Drag and Drop Done");
		MethodActions.switchToNewWindow();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Data Table");
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
		MethodActions.waitEle(By.xpath("//span[text()=\" Save \"]"));

	}

	public void contentFeildsDragAndDrop() throws Exception {
		MethodActions.waitEle(By.xpath("//div[text()=\"Content Fields\"]"));
		// Heading Feild
		WebElement heading = driver.findElement(By.xpath("//span[text()=\"Heading\"]"));
		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));
		Actions actions = new Actions(driver);
		waitAndClick(actions, heading, Target, 0, 150);
		System.out.println("Heading feild Drag and Drop Done");
		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder=\"Enter content or block title\"]"),
				"Heading Feild");
		MethodActions.waitEle(By.xpath("//input[@placeholder=\"Select Heading Type\"]"));
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//span[text()=\"H2\"]"));
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// HTML field
		WebElement html = driver.findElement(By.xpath("//span[text()=\"HTML\"]"));
		waitAndClick(actions, html, Target, -550, -200);
		System.out.println("html feild Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "HTMLFeild");
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter content']"),
				"content for the HTMLFeild");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Paragraph
		WebElement Para = driver.findElement(By.xpath("//span[text()=\"Paragraph\"]"));
		waitAndClick(actions, Para, Target, -350, -200);
		System.out.println("Paragraph feild Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter content']"),
				"content for the ParagraphFeild");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Single Line Content
		WebElement singlelineContent = driver.findElement(By.xpath("//span[text()=\"Single Line Content\"]"));
		waitAndClick(actions, singlelineContent, Target, -550, -100);
		System.out.println("singlelineContent feild Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter content']"),
				"content for the singlelineContent");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Image
		WebElement Image = driver.findElement(By.xpath("//span[text()=\"Image\"]"));
		waitAndClick(actions, Image, Target, -150, -100);
		System.out.println("Image feild Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "ImageFeild");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Video
		WebElement video = driver.findElement(By.xpath("//span[text()=\"Video\"]"));
		waitAndClick(actions, video, Target, -350, -150);
		System.out.println("video feild Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "videoFeild");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Action Button
		WebElement ActionButton = driver.findElement(By.xpath("//span[text()=\"Action Button\"]"));
		waitAndClick(actions, ActionButton, Target, -250, -180);
		System.out.println("Action Button feild Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter label']"), "Action ButtonFeild");
		MethodActions.waitEle(By.xpath("//span[normalize-space()=\"Add\"]"));
		MethodActions.waitEle(By.xpath("//input[@placeholder=\"Select type\"]"));
		MethodActions.waitEle(By.xpath("//li[text()=\"Update template\"]"));
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Horizontal Line
		WebElement horizontalLine = driver.findElement(By.xpath("//span[text()=\"Horizontal Line\"]"));
		waitAndClick(actions, horizontalLine, Target, 100, 200);
		System.out.println("horizontalLine feild Drag and Drop Done");
		// Division
		WebElement Division = driver.findElement(By.xpath("//span[text()=\"Division\"]"));
		waitAndClick(actions, Division, Target, 350, 550);
		System.out.println("Division feild Drag and Drop Done");
		MethodActions.waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));

	}

	public void waitAndClick(Actions actions, WebElement sourceElement, WebElement targetElement, int xOffset,
			int yOffset) {
		actions.clickAndHold(sourceElement).moveToElement(targetElement, xOffset, yOffset).release().build().perform();
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

		MethodActions.waitEle(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='View']"));
		System.out.println("Click on View Action Done successfully");
	}

	public void ClickCreateEntity() throws Exception {

		By ad = By.xpath("//button[normalize-space()='Create Entity']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on ceate entity using JS.");

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

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Title']"), title);

		By Description = By.xpath("//textarea[@placeholder='Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("This entity is only for testing purpose");
		String entitytype = String.format("//div[@class=\"radio-group\"]//span[contains(text(), '%s')]", ET);
		MethodActions.waitEle(By.xpath(entitytype));
		String createFrom = String.format("//h4[contains(text(),'%s')]", s);
		MethodActions.waitEle(By.xpath(createFrom));
		MethodActions.waitEle(By.xpath("//h4[contains(text(),\"Start from scratch\")]"));
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//button[@class=\"btn btn btn-outline-primary btn-sm m-lr-1\"]"));

		System.out.println("Create entity successfull");

	}

	public void addtemplate(String t) throws Exception {

		String temp = String.format("//p[normalize-space()= '%s']", t);
		MethodActions.waitEle(By.xpath(temp));

		System.out.println("Form template added successfully");

		MethodActions.waitEle(By.xpath("//span[text()=\"Update & Next\"]"));
		try {
			primaryFeild();
		} catch (Exception e) {
		}

		MethodActions.waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));
		MethodActions.waitEle(By.xpath("//div[text()=\"Actions\"]"));

		MethodActions.waitEle(By.xpath("//span[text()=\"Done\"]"));

	}

	public void addRepeattemplate(String t) throws Exception {

		String temp = String.format("//p[normalize-space()= 'Repeat Formtemplate3']");
		MethodActions.waitEle(By.xpath(temp));

		MethodActions.waitEle(By.xpath("//p[normalize-space()= 'SampleTemplate']"));

		Thread.sleep(10000);

		MethodActions.waitEle(By.xpath("(//i[@class='el-icon-info icon-class'])[1]"));

		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__input']//span)[2]"));

		MethodActions.waitEle(By.xpath("//input[@placeholder='TABLE']"));
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[2]"));

		submit();

		System.out.println("Form template added successfully");

		MethodActions.waitEle(By.xpath("//span[text()=\"Update & Next\"]"));
		try {
			primaryFeild();
		} catch (Exception e) {
		}

		MethodActions.waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));
		MethodActions.waitEle(By.xpath("//div[text()=\"Actions\"]"));

		MethodActions.waitEle(By.xpath("//span[text()=\"Done\"]"));

	}

	public void x() throws Exception {
		MethodActions.waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));

	}

	public void primaryFeild() throws Exception {

		try {
			x();
		} catch (Exception e) {

		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement FullName = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class=\"dropBox\"]//ul[@class=\"list-group\"]//li[text()=\" Single Line Text \"]|"
						+ "//div[@class=\"dropBox\"]//ul[@class=\"list-group\"]//li[normalize-space()=\" Single Line Text \"]")));

		WebElement Target = driver.findElement(By.xpath("(//ul[@class=\"list-group\"])[2]"));

		Actions actions = new Actions(driver);

		waitAndClick(actions, FullName, Target, 0, 0);

		System.out.println("primary feild Drag and Drop Done");

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Update & Next']"));

	}

	public void entity() throws Exception {

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
//
		Thread.sleep(10000);
//
//		MethodActions.waitEle(By.xpath("//div[@class='icon-text']"));
//
//		Thread.sleep(3000);
//
//		By Entities = By.xpath("//li[normalize-space()=\"Entities\"]");
//		WebElement Entities1 = wait.until(ExpectedConditions.elementToBeClickable(Entities));
//		Entities1.click();
//
//		System.out.println("Clicked on entities in profile completed");
		driver.get("https://nsui.esigns.io/entity");

	}

	public void selectFirstDropdownItem() throws Exception {
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
	}

	public void Adddata() throws Exception {

		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//i[@class='fa fa-plus-circle fa-lg']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//span[@class='el-switch__core']"));

		int i = 1;
		Random random = new Random();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		try {
			Thread.sleep(10000);
			WebElement Message = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//div[@role='alert']//p[contains(text(), 'Max number of records already added')]")));
			Message.isDisplayed();

			System.out.println("Max number of records already added. Can't add new data.");

		} catch (Exception e) {
			String text = "Test " + i;
			int numberValue = random.nextInt(100);

			MethodActions.waitEle(By.xpath("//span[text()='Add Data']"));

			driver.findElement(By.xpath("(//input[@placeholder='Single Line Text'])[2]")).sendKeys(text);
			MethodActions.waitEle(By.xpath("(//input[@placeholder='Date'])[2]"));
			Thread.sleep(1000);
			MethodActions.waitEle(By.xpath("//span[normalize-space(text())='14']"));

			driver.findElement(By.xpath("(//textarea[@placeholder='Multi Line Text'])[2]")).sendKeys(text);
			MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));
			selectFirstDropdownItem();

			MethodActions
					.waitEle(By.xpath("(//div[contains(@class,'country-selector input-country-selector')]//label)[2]"));

			Thread.sleep(3000);

			MethodActions.sendKeysToElement(By.xpath("(//input[@placeholder='Phone number *'])[2]"), "1234567890");

			driver.findElement(By.xpath("(//input[@placeholder='Number'])[2]")).sendKeys(String.valueOf(numberValue));
			driver.findElement(By.xpath("(//input[@placeholder='Currency'])[2]")).sendKeys(String.valueOf(numberValue));

			i++;
		}

		MethodActions.waitEle(By.xpath("//div[normalize-space()='SampleTemplate']"));
		Thread.sleep(3000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Single Line Text']"), "Single Line");

		MethodActions.waitEle(By.xpath("//input[@placeholder='Select']"));
		Thread.sleep(3000);
		selectFirstDropdownItem();
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save']"));

	}

	public void edit() throws Exception {
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("(//button[contains(@class,'btn btn-light')])[2]"));
		MethodActions.Loadingmask();
		MethodActions.waitEle(By.xpath("//a[contains(@class,'el-button el-button--primary')]"));

		Random random = new Random();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		if (isMaxRecordsReached(wait)) {
			System.out.println("Max number of records already added. Can't add new data.");
			return;
		}

		for (int i = 1; i <= 2; i++) {

			fillFormWithData("Test " + i, random.nextInt(100));
		}
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//span[normalize-space(text())='Update & Next']"));
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//button[contains(.,'Save')]"));

	}

	private boolean isMaxRecordsReached(WebDriverWait wait) {
		try {
			Thread.sleep(10000);
			WebElement message = wait.until(ExpectedConditions.presenceOfElementLocated(
					By.xpath("//div[@role='alert']//p[contains(text(), 'Max number of records already added')]")));
			return message.isDisplayed();
		} catch (Exception e) {

			return false;
		}
	}

	private void fillFormWithData(String text, int numberValue) throws Exception {
		MethodActions.waitEle(By.xpath("//span[text()='Add Data']"));

		driver.findElement(By.xpath("//input[@placeholder='Single Line Text']")).sendKeys(text);
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select date']"));
		Thread.sleep(1000);
		MethodActions.waitEle(By.xpath("(//td[@class='available today'])[1]"));

		driver.findElement(By.xpath("//textarea[@placeholder='Multi Line Text']")).sendKeys(text);
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select']"));
		selectFirstDropdownItem();

		MethodActions.waitEle(By.xpath("//div[contains(@class,'country-selector input-country-selector')]//label"));
		Thread.sleep(3000);

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Phone number *']"), "1234567890");

		driver.findElement(By.xpath("//input[@placeholder='Number']")).sendKeys(String.valueOf(numberValue));
		driver.findElement(By.xpath("//input[@placeholder='Currency']")).sendKeys(String.valueOf(numberValue));
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--primary']"));
	}

	public void icon() throws Exception {
		Thread.sleep(3000);
		// MethodActions.waitEle(By.xpath("//i[@class='fa fa-plus-circle fa-lg']"));
		Thread.sleep(3000);
		// Single line text
		MethodActions.waitEle(By.xpath("//input[@placeholder='Single line text']"));
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Single line text']"), "Single line text");

		// Select
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[1]"));
		Thread.sleep(3000);
		selectFirstDropdownItem();

		// Number
		MethodActions.waitEle(By.xpath("//input[@placeholder='Number']"));
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Number']"), "44");

		// Multiselect
		MethodActions.waitEle(By.xpath("(//label[normalize-space(text())='Multiselect']/following::input)[1]"));
		Thread.sleep(3000);
		selectFirstDropdownItem();

		// Select
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[3]"));
		Thread.sleep(3000);
		selectFirstDropdownItem();

		// Date
		MethodActions.waitEle(By.xpath("//input[@placeholder='Date']"));
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("(//div[@class='el-picker-panel__body']//td[@class='available'])[2]"));

		// Time
		MethodActions.waitEle(By.xpath("//input[@placeholder='Time']"));
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//button[@class='el-time-panel__btn confirm']"));

		// FixedTime
		MethodActions.waitEle(By.xpath("//input[@placeholder='FixedTime']"));
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//div[normalize-space(text())='01:30']"));

		Thread.sleep(3000);
		// Yes or No

		MethodActions.waitEle(By.xpath("(//span[@class='el-radio__input']//span)[3]"));

		// CheckBox

		MethodActions.waitEle(By.xpath("(//label[contains(@class,'el-checkbox el-checkbox')]//span)[1]"));

		// Time Range

		MethodActions.waitEle(By.xpath("//input[@placeholder='Start time']"));

		MethodActions.waitEle(By.xpath("(//button[@class='el-time-panel__btn confirm'])[2]"));
		// Date Time
		MethodActions.waitEle(By.xpath("//input[@placeholder='DateTime']"));
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath(
				"(//button[contains(@class,'el-button el-picker-panel__link-btn')]/following-sibling::button)[2]"));

		// Date Range
		MethodActions.waitEle(By.xpath("//input[@placeholder='Start date']"));
		MethodActions.waitEle(By.xpath(
				"(//div[@class='el-picker-panel__content el-date-range-picker__content is-left']//td[@class='available'])[2]"));
		MethodActions.waitEle(By.xpath(
				"(//div[@class='el-picker-panel__content el-date-range-picker__content is-right']//td[@class='available'])[1]"));

		// Week Days
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[7]"));

		// CheckBox Group
		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[1]"));

		// Radio Group

		MethodActions.waitEle(By.xpath("(//label[@class='el-radio is-bordered']//span)[1]"));

		// Radio
		MethodActions.waitEle(By.xpath("//span[@class='el-radio__input is-checked']//span[1]"));

		// Phone

		MethodActions.waitEle(By.xpath("//label[normalize-space()='Country code']"));

		MethodActions.waitEle(By.xpath("(//div[normalize-space()='India (भारत)'])[2]"));

		Thread.sleep(10000);

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Phone number *']"), "1234567890");

		// Signature
		MethodActions.waitEle(By.xpath("//div[normalize-space(text())='signature']"));
		Actions act = new Actions(driver);
		Thread.sleep(10000);
		act.clickAndHold(driver.findElement(By.xpath("//div[@aria-labelledby='tab-drawer']//canvas")))
				.moveToElement(driver.findElement(By.xpath("//div[@aria-labelledby='tab-drawer']//canvas")), 20, -50)
				.moveByOffset(50, 50).moveByOffset(80, -50).moveByOffset(100, 50).release().build().perform();
		MethodActions.waitEle(By.xpath("//span[normalize-space(text())='End Signature']"));
		MethodActions.waitEle(By.xpath("//span[normalize-space(text())='Save Signature']"));

		// Captcha
		MethodActions.waitEle(By.xpath("//label[@class='ml-1 checkbox-label']//input[1]"));

		Thread.sleep(5000);
		WebElement captchaBox = driver.findElement(By.cssSelector(".captcha-box.el-col.el-col-18"));

		List<WebElement> captchaElements = captchaBox.findElements(By.tagName("span"));

		StringBuilder captchaText = new StringBuilder();

		for (WebElement element : captchaElements) {
			captchaText.append(element.getText());
		}

		WebElement captchaInput = driver
				.findElement(By.xpath("(//label[normalize-space(text())='Captcha']/following::input)[1]"));
		captchaInput.sendKeys(captchaText.toString());

		// Multiline
		WebElement iframe = driver.findElement(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']"));
		driver.switchTo().frame(iframe);
		MethodActions.waitEle(By.xpath("//body[contains(@class,'document-editor cke_editable')]"));
		MethodActions.sendKeysToElement(By.xpath("//body[contains(@class,'document-editor cke_editable')]"), "Test");
		driver.switchTo().defaultContent();

		// Document

	}

	public void save() throws Exception {
		Thread.sleep(3000);
		WebElement save = driver.findElement(By.xpath(
				"//button[@class='el-button scaling-button el-button--primary el-button--mini']//span[text()=' Save ']"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -250);");

		js.executeScript("arguments[0].scrollIntoView(true);", save);

		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", save);

	}

	public void clickAndSendKeys(By locator, String value) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);

		js.executeScript("arguments[0].value = arguments[1];", element, value);
	}

	public void compareTableRowWithInputData() throws Exception {

		WebElement firstRow = driver
				.findElement(By.xpath("//div[@class='el-table__body-wrapper is-scrolling-left']//tr[1]"));
		List<WebElement> columns = firstRow.findElements(By.tagName("td"));

		List<String> tableRowData = new ArrayList<>();
		for (WebElement column : columns) {
			tableRowData.add(column.getText().trim());
		}

		List<String> inputData = Arrays.asList("Single line text", "12:20:05 - 13:20:05", "Test", "Computer science",
				"08-02-2024 TO 09-01-2024", "08-08-2024 12:20:18", "44", "SUN", "Computer science", "List", "1",
				"08-02-2024", "12:19:37", "dd.PNG", "true", "01:30", "NO", "1");

		boolean isMatch = tableRowData.equals(inputData);

		if (isMatch) {
			System.out.println("Table row data matches the input data.");
		} else {
			System.out.println("Table row data does not match the input data.");
			System.out.println("Table Row Data: " + tableRowData);
			System.out.println("Input Data: " + inputData);
		}
	}

	public void verifyBasicFieldDataFillInIndividualEntity() throws Exception {

//		MethodActions.waitEle(By.xpath("(//button[contains(@class,'btn btn-light')])[2]"));
		// driver.get("https://nsui.esigns.io/entity/66b308e047ad681aec33b58e?viewType=TABLE&page=1&pageSize=10");
		MethodActions.Loadingmask();
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
}
