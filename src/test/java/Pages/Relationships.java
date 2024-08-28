package Pages;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Relationships {
	WebDriver driver;
	MethodActions methodActions;
	Login login;

	public Relationships(WebDriver driver) {
		this.driver = driver;
		methodActions = new MethodActions(driver);
		login = new Login(driver);

	}

	public void add() throws Exception {
		Thread.sleep(1000);

		MethodActions.waitEle(By.xpath("//button[@type='primary']"));

	}

	public void contact(String FirstName, String LastName, String Email, String Student) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement field1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']")));
		field1.sendKeys(FirstName);

		WebElement field3 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']")));
		field3.sendKeys(LastName);

		WebElement field4 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email']")));
		field4.sendKeys(Email);

		MethodActions.waitEle(By.xpath("//button[contains(.,'Save & Next')]"));
		Thread.sleep(2000);
		WebElement field5 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Student Name']")));
		field5.sendKeys(Student);

		MethodActions.waitEle(By.xpath("(//button[contains(@class,'el-button scaling-button')])[1]"));

	}

	public void entiy(String Title, String type, String s) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		WebElement field1 = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Title']")));
		field1.sendKeys(Title);

		String entitytype = String.format("//div[@class=\"radio-group\"]//span[contains(text(), '%s')]", type);
		MethodActions.waitEle(By.xpath(entitytype));

		String createFrom = String.format("//h4[contains(text(),'%s')]", s);
		MethodActions.waitEle(By.xpath(createFrom));

		MethodActions.waitEle(By.xpath("//button[@class=\"btn btn btn-outline-primary btn-sm m-lr-1\"]"));

	}

	public void entityadd(String name) throws Exception {
		Thread.sleep(3000);
		String entityname = String.format("//p[text()=' %s ']", name);
		MethodActions.waitEle(By.xpath(entityname));
	}

	public void Sync() throws Exception {

		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//span[text()=\"Update & Next\"]"));
		try {
			MethodActions.waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));
		} catch (Exception e) {
		}
		MethodActions.waitEle(By.xpath("//span[text()=\"Update & Next\"]"));
		Thread.sleep(10000);
		try {
			driver.findElement(By.xpath("//button[@class='el-button el-button--success el-button--mini']"))
					.isDisplayed();
			System.out.println("Sync Relation Displayed");
		} catch (Exception e) {
			System.out.println("Sync Relation Not Displayed");
		}
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//button[@class='el-button el-button--success el-button--mini']"));
		MethodActions.waitEle(By.xpath("//span[text()='Skip']"));
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class='el-button el-button--danger el-button--mini']")).isDisplayed();
		System.out.println("Sync Relation Added");

	}

	public void Sync3() throws Exception {
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//span[text()='Update & Next']"));

		try {
			MethodActions.waitEle(By.xpath("//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}

		MethodActions.waitEle(By.xpath("//span[text()='Update & Next']"));
		Thread.sleep(10000);

		try {
			if (driver.findElement(By.xpath("(//button[@class='el-button el-button--success el-button--mini'])[1]"))
					.isDisplayed()) {
				System.out.println("Sync Relation Displayed");
			}
		} catch (Exception e) {
			System.out.println("Sync Relation Not Displayed");
		}

		Thread.sleep(10000);
		for (int i = 1; i <= 3; i++) {
			MethodActions
					.waitEle(By.xpath("(//button[@class='el-button el-button--success el-button--mini'])[" + i + "]"));
		}

		MethodActions.waitEle(By.xpath("//span[text()='Skip']"));
		Thread.sleep(10000);

		driver.findElement(By.xpath("(//button[@class='el-button el-button--danger el-button--mini'])[1]"))
				.isDisplayed();
		System.out.println("Sync Relation Added");
	}

	public void next() throws Exception {
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//span[text()=\"Update & Next\"]"));
		try {
			MethodActions.waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));
		} catch (Exception e) {
		}
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()=\"Actions\"]"));

		MethodActions.waitEle(By.xpath("//span[text()=\"Done\"]"));

	}

	public void Template(String s, String Name) throws Exception {
		Thread.sleep(1000);
		driver.get("https://nsui.esigns.io/template");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		MethodActions.waitEle(By.xpath("//button[@class='btn btn-sm btn-outline-primary m-lr-1']"));

		String start = String.format("//div[normalize-space(text())='%s']", s);
		MethodActions.waitEle(By.xpath(start));

		WebElement field1 = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter Template Title']")));
		field1.sendKeys(Name);

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Submit']"));

	}

//	public void TempActions(boolean use, String entityName, String optionToSelect, boolean processOnlyEntity)
//			throws Exception {
//
//		if (!processOnlyEntity) {
//			String[] basicFields = use ? new String[] { "Single Line Text" }
//					: new String[] { "Single Line Text", "Select", "Number" };
//			executeGlobalVariableActions("Basic Fields", basicFields, -350, -180, use, optionToSelect, optionToSelect);
//		}
//
//		String[] advancedFields = { "Entity" };
//		int advancedStartX = use ? -450 : -150;
//		executeGlobalVariableActions("Advanced Fields", advancedFields, advancedStartX, -280, use, entityName,
//				optionToSelect);
//
//		waitAndClick("//span[normalize-space()='Save']");
//	}

	public void TempActions(String section, String... elementTypes) throws Exception {
		if (elementTypes != null && elementTypes.length > 0) {
			executeGlobalVariableActions(section, elementTypes, -350, -180, false, null, null);
			MethodActions.waitEle(By.xpath("//div[text()=\"" + section + "\"]"));
		}
	}

	public void executeGlobalVariableActions(String section, String[] elementTypes, int startX, int startY,
			boolean useAltActions, String entityName, String optionToSelect) throws Exception {
		MethodActions.waitEle(By.xpath("//div[text()='" + section + "']"));
		Thread.sleep(5000);

		int x = startX;
		int y = startY;

		for (String elementType : elementTypes) {
			performGlobalVariableActions(elementType, x, y, useAltActions, entityName, optionToSelect);
			x = updateCoordinates(x, startX);
			if (x == startX) {
				y += 50;
			}
		}
		MethodActions.waitEle(By.xpath("//div[text()='" + section + "']"));
	}

	public void performGlobalVariableActions(String elementType, int x, int y, boolean use, String entityName,
			String optionToSelect) throws Exception {

		dragAndDropElement(elementType, x, y);

		switch (elementType) {
		case "Single Line Text":
			handleSingleLineText();
			break;
		case "Select": {
			handleSelect();
		}
			break;
		case "Entity":
			handleEntity(entityName, optionToSelect);
			break;

		}
	}

	private void dragAndDropElement(String elementType, int x, int y) throws Exception {
		WebElement sourceElement = driver.findElement(By.xpath("//span[text()='" + elementType + "']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='form-builder']"));
		int targetX = targetElement.getLocation().getX() + x;
		int targetY = targetElement.getLocation().getY() + y;

		new Actions(driver).clickAndHold(sourceElement).moveToElement(targetElement, targetX, targetY).release().build()
				.perform();
	}

	private void handleSingleLineText() throws Exception {
		enterFieldAndSubmit("Name", "//input[@placeholder='Enter Field Title']");
	}

	private void handleSelect() throws Exception {
		enterFieldWithMultipleOptions("Domain", new String[] { "Development", "Testing", "App-Development" });
	}

	private void handleEntity(String entityName, String optionToSelect) throws Exception {
		Thread.sleep(10000);
		WebElement fieldTitleElement = driver.findElement(By.xpath("//input[@placeholder='Enter Field Title']"));
		fieldTitleElement.sendKeys(entityName);

		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));

		String formattedXPath = String.format("//span[text()='%s']", optionToSelect);
		MethodActions.waitEle(By.xpath(formattedXPath));

		waitAndClick("//button[contains(@class,'el-button el-button--primary')]");
	}

	private void enterFieldAndSubmit(String fieldTitle, String inputXPath) throws Exception {
		sendKeysToField(inputXPath, fieldTitle);
		waitAndClick("//button[contains(@class,'el-button el-button--primary')]");
	}

	private void enterFieldWithMultipleOptions(String fieldTitle, String[] options) throws Exception {
		sendKeysToField("//input[@placeholder='Enter Field Title']", fieldTitle);
		for (String option : options) {
			sendKeysToField("(//label[normalize-space(text())='Options']/following::input)[1]", option);
			MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		}
		waitAndClick("//button[contains(@class,'el-button el-button--primary')]");
	}

	private void sendKeysToField(String xpath, String keys) throws Exception {
		MethodActions.sendKeysToElement(By.xpath(xpath), keys);
	}

	private void waitAndClick(String xpath) throws Exception {
		MethodActions.waitEle(By.xpath(xpath));
	}

	private int updateCoordinates(int x, int startX) {
		x += 250;
		return (x > 250) ? startX : x;
	}

	public void url() throws InterruptedException {
		Thread.sleep(1000);
		driver.get("https://nsui.esigns.io/entity");

	}

	public void enterDetails(String firstName, String middleName, String lastName, String email, String title,
			String address, String countryCode, String phoneNumber) throws Exception {
		Thread.sleep(10000);
		MethodActions.Javascriptclick(By.xpath("//button[@class='el-tooltip btn btn-outline-success btn-sm m-lr-1']"));
		Thread.sleep(3000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='First Name']"), firstName);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Middle Name']"), middleName);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Last Name']"), lastName);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Email']"), email);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Title']"), title);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Address']"), address);
		Thread.sleep(10000);
		MethodActions.Javascriptclick(By.xpath("//input[@placeholder='Country code']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath(String.format("//div[text()=' %s ']", countryCode)));

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Phone number *']"), phoneNumber);

		MethodActions
				.waitEle(By.xpath("//span[normalize-space()='Save'] | //span[normalize-space(text())='Save & Next']"));

	}

	public void back() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("(//i[@class='el-icon-back'])[2]"));

	}

	public void Team(String managerName, String name, String department) throws Exception {
		Thread.sleep(10000);
//		MethodActions.Javascriptclick(By.xpath("//button[@class='el-tooltip btn btn-outline-success btn-sm m-lr-1']"));
//		Thread.sleep(3000);
//		MethodActions.waitEle(By.xpath("//div[normalize-space(text())='Team lead']"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//input[@placeholder='Manager']"));
		Thread.sleep(3000);

		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[normalize-space()='" + managerName + "']"));

		MethodActions.sendKeysToElement(By.xpath("//div[contains(@class,'d-flex el-col')]//input[1]"), name);
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select']"));
		Thread.sleep(3000);

		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[normalize-space()='" + department + "']"));

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save']"));
	}

	public void Team1(String managerName, String name) throws Exception {
		Thread.sleep(10000);
//		MethodActions.Javascriptclick(By.xpath("//button[@class='el-tooltip btn btn-outline-success btn-sm m-lr-1']"));
//		Thread.sleep(3000);
//		MethodActions.waitEle(By.xpath("//div[normalize-space(text())='Team lead']"));

		MethodActions.waitEle(By.xpath("(//div[contains(@class,'d-flex el-col')]//input)[1]"));
		Thread.sleep(3000);

		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[normalize-space()='" + managerName + "']"));

		MethodActions.sendKeysToElement(By.xpath("(//div[contains(@class,'d-flex el-col')]//input)[2]"), name);

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save']"));
	}

	public void Team2(String managerName, String name) throws Exception {
		Thread.sleep(10000);
//		MethodActions.Javascriptclick(By.xpath("//button[@class='el-tooltip btn btn-outline-success btn-sm m-lr-1']"));
//		Thread.sleep(3000);
//		MethodActions.waitEle(By.xpath("//div[normalize-space(text())='Team lead']"));

		MethodActions.sendKeysToElement(By.xpath("(//div[contains(@class,'d-flex el-col')]//input)[1]"), managerName);
		Thread.sleep(3000);

		MethodActions.sendKeysToElement(By.xpath("(//div[contains(@class,'d-flex el-col')]//input)[2]"), name);

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save']"));
	}

	public void waitAndClick(Actions actions, WebElement sourceElement, WebElement targetElement, int xOffset,
			int yOffset) {
		actions.clickAndHold(sourceElement).moveToElement(targetElement, xOffset, yOffset).release().build().perform();
	}

	public void processEntityField(String entityName, String optionToSelect, boolean isFirstRun) throws Exception {

		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));

		WebElement Target = driver.findElement(By.xpath("//div[@class='form-builder']"));
		Actions actions = new Actions(driver);

		if (!isFirstRun) {
			WebElement Entity = driver.findElement(By.xpath("//span[text()='Entity']"));

			switch (entityName) {
			case "Manager":
				waitAndClick(actions, Entity, Target, -300, 300);
				Thread.sleep(10000);
				WebElement fieldTitleElement = driver
						.findElement(By.xpath("//input[@placeholder='Enter Field Title']"));
				fieldTitleElement.sendKeys(entityName);

				MethodActions.waitEle(By.xpath("(//label[normalize-space(text())='Entities']/following::input)[1]"));
				String formattedXPath = String.format("//span[text()='%s']", optionToSelect);
				MethodActions.waitEle(By.xpath(formattedXPath));

				MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));
				break;
			case "Employee":
				MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
				waitAndClick(actions, Entity, Target, -200, 200);
				Thread.sleep(3000);
				WebElement fieldTitleElement1 = driver
						.findElement(By.xpath("//input[@placeholder='Enter Field Title']"));
				fieldTitleElement1.sendKeys(entityName);

				MethodActions.waitEle(By.xpath("(//label[normalize-space(text())='Entities']/following::input)[1]"));
				String formattedXPath1 = String.format("//span[text()='%s']", optionToSelect);
				MethodActions.waitEle(By.xpath(formattedXPath1));

				MethodActions.waitEle(By.xpath("//span[normalize-space(text())='View Advanced Options']"));
				Thread.sleep(3000);
				MethodActions.waitEle(By.xpath("(//span[@class='el-radio__input']//span)[2]"));
				MethodActions.waitEle(By.xpath("//span[normalize-space()='Add +']"));
				MethodActions.waitEle(By.xpath("//input[@placeholder='Field']"));
				Thread.sleep(3000);
				MethodActions
						.waitEle(By.xpath("//div[@x-placement]//li[normalize-space(text())= 'Self - Related To #1']"));

				Thread.sleep(3000);
				MethodActions.waitEle(By.xpath("(//div[contains(@class,'el-input el-input--mini')]//input)[3]"));
				MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
				MethodActions.waitEle(By.xpath("(//label[contains(.,'OR')]/following::input)[3]"));
				MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
				MethodActions.waitEle(By.xpath("//input[@placeholder='Template fields']"));

				MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
				MethodActions.waitEle(By.xpath("(//button[@class='close-button']//i)[2]"));
				MethodActions.waitEle(By.xpath("//span[normalize-space(text())= 'Insert Field']"));
				break;
			case "TeamLead":
				MethodActions.waitEle(By.xpath("//div[text()='Advanced Fields']"));
				waitAndClick(actions, Entity, Target, -100, 100);
				Thread.sleep(3000);
				WebElement fieldTitleElement11 = driver
						.findElement(By.xpath("//input[@placeholder='Enter Field Title']"));
				fieldTitleElement11.sendKeys(entityName);

				MethodActions.waitEle(By.xpath("(//label[normalize-space(text())='Entities']/following::input)[1]"));
				String formattedXPath11 = String.format("//span[text()='%s']", optionToSelect);
				MethodActions.waitEle(By.xpath(formattedXPath11));

				MethodActions.waitEle(By.xpath("//span[normalize-space(text())='View Advanced Options']"));
				Thread.sleep(3000);
				MethodActions.waitEle(By.xpath("(//span[@class='el-radio__input']//span)[2]"));
				MethodActions.waitEle(By.xpath("//span[normalize-space()='Add +']"));
				MethodActions.waitEle(By.xpath("//input[@placeholder='Field']"));
				Thread.sleep(3000);
				MethodActions
						.waitEle(By.xpath("//div[@x-placement]//li[normalize-space(text())= 'Self - Related To #1']"));

				Thread.sleep(3000);
				MethodActions.waitEle(By.xpath("(//div[contains(@class,'el-input el-input--mini')]//input)[3]"));
				MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
				MethodActions.waitEle(By.xpath("(//label[contains(.,'OR')]/following::input)[3]"));
				MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
				MethodActions.waitEle(By.xpath("//input[@placeholder='Template fields']"));
				MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
				MethodActions.waitEle(By.xpath("(//button[@class='close-button']//i)[2]"));
				MethodActions.waitEle(By.xpath("//span[normalize-space(text())= 'Insert Field']"));

				break;
			default:
				waitAndClick(actions, Entity, Target, -300, 300);
				break;

			}

			System.out.println(entityName + " Element Drag and Drop Done");
			Thread.sleep(10000);

		} else {
			System.out.println("Skipping actions for the first run.");
		}

	}

	public void save() throws Exception {
		MethodActions.waitEle(By.xpath("//span[normalize-space(text())= 'Save']"));
	}

	public void primary() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement FullName = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='dropBox'])[1]//li[normalize-space()='manager']")));

		WebElement Target = driver.findElement(By.xpath("(//div[@class='dropBox'])[2]"));

		Actions actions = new Actions(driver);

		waitAndClick(actions, FullName, Target);

		System.out.println("Name Drag and Drop Done");

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

	public void singleLineTextDragAndDrop(String Name) throws Exception {
		MethodActions.waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));

		// Single Line
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement Target = driver.findElement(By.xpath("//div[@class=\"form-builder\"]"));
//		Dimension dropSize = Target.getSize();
//		System.out.println(dropSize);
		Actions actions = new Actions(driver);

		Thread.sleep(1000);
		WebElement Singlelinetext = driver.findElement(By.xpath("(//span[normalize-space()='Single Line Text'])[1]"));

		waitAndClick(actions, Singlelinetext, Target, -550, -200);
		System.out.println("Single line text Drag and Drop Done");

		By SName = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement SName1 = wait.until(ExpectedConditions.elementToBeClickable(SName));
		SName1.sendKeys(Name);
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

//		By SName11 = By.xpath("//input[@placeholder='Enter Field Title']");
//		WebElement SName111 = wait.until(ExpectedConditions.elementToBeClickable(SName11));
//		SName111.sendKeys("Domain");
//		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
	}

	public void singleLineTextDragAndDrop1(String Name) throws Exception {

		// Single Line
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement Target = driver.findElement(By.xpath("//div[@class=\"form-builder\"]"));
//		Dimension dropSize = Target.getSize();
//		System.out.println(dropSize);
		Actions actions = new Actions(driver);

		Thread.sleep(1000);
		WebElement Singlelinetext = driver.findElement(By.xpath("(//span[normalize-space()='Single Line Text'])[1]"));

		waitAndClick(actions, Singlelinetext, Target, -250, 100);
		System.out.println("Single line text Drag and Drop Done");

		By SName = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement SName1 = wait.until(ExpectedConditions.elementToBeClickable(SName));
		SName1.sendKeys(Name);
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

//		By SName11 = By.xpath("//input[@placeholder='Enter Field Title']");
//		WebElement SName111 = wait.until(ExpectedConditions.elementToBeClickable(SName11));
//		SName111.sendKeys("Domain");
//		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
	}

	public void close() throws Exception {
		MethodActions.waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
	}

	public void Select() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement Target = driver.findElement(By.xpath("//div[@class=\"form-builder\"]"));
//		Dimension dropSize = Target.getSize();
//		System.out.println(dropSize);
		Actions actions = new Actions(driver);
		Thread.sleep(1000);
		WebElement Select = driver.findElement(By.xpath("(//span[normalize-space()='Select'])[1]"));
		waitAndClick(actions, Select, Target, -550, -100);
		System.out.println("Select Drag and Drop Done");

		handleSelect();
	}

	public void EntityFieldDragAndDrop(String Nam, String Name) throws Exception {
		// Entity
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()=\"Advanced Fields\"]"));
		WebElement Target = driver.findElement(By.xpath("//div[@class=\"form-builder\"]"));
		Actions actions = new Actions(driver);
		Thread.sleep(10000);
		WebElement Entity = driver.findElement(By.xpath("//span[text()=\"Entity\"]"));
		waitAndClick(actions, Entity, Target, -550, -30);
		System.out.println("Entity Element Drag and Drop Done");
		Thread.sleep(10000);

		String entityName1 = String.format("//input[@placeholder='Enter Field Title']", Nam);
		driver.findElement(By.xpath(entityName1)).sendKeys(Nam);

		MethodActions.waitEle(By.xpath("(//label[normalize-space(text())='Entities']/following::input)[1]"));
		String entityName = String.format("//span[text()=\"%s\"]", Name);
		MethodActions.waitEle(By.xpath(entityName));
		MethodActions.waitEle(By.xpath("//span[text()='Insert Field']"));

		// MethodActions.waitEle(By.xpath("//span[normalize-space()='Save']"));
	}

	public void relation(String name) throws Exception {
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//span[text()=\"Update & Next\"]"));
		try {
			MethodActions.waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));
		} catch (Exception e) {
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement FullName = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//div[@class='dropBox'])[1]//li[normalize-space()='Student Name333']")));

		WebElement Target = driver.findElement(By.xpath("(//div[@class='dropBox'])[2]"));

		Actions actions = new Actions(driver);

		waitAndClick(actions, FullName, Target);

		MethodActions.waitEle(By.xpath("//span[text()=\"Update & Next\"]"));

		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));

		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[normalize-space()='ONE']"));

		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[3]"));

		Thread.sleep(1000);
		String entityname = String.format("//div[@x-placement]//li[normalize-space()='%s']", name);
		MethodActions.waitEle(By.xpath(entityname));

		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[5]"));

		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[normalize-space()='MANY']"));

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Add Relationship']"));

		Thread.sleep(10000);

		driver.findElement(By.xpath("//button[@class='el-button el-button--danger el-button--mini']")).isDisplayed();
		System.out.println("Sync Relation Added");

	}

	public void assignCommonActions(int buttonIndex, int listItemIndex) throws Exception {
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("(//ul[@class='action-buttons']//button)[" + buttonIndex + "]"));
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("(//div[@class='el-tabs__nav is-top']//div)[2]"));
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//span[normalize-space(text())='Assign']"));
		Thread.sleep(3000);
		MethodActions.waitEle(By.xpath("//div[@class='el-select__tags']//input[1]"));
		Thread.sleep(3000);
		MethodActions.Javascriptclick(By.xpath("//div[@x-placement]//li[" + listItemIndex + "]"));
		MethodActions.Javascriptclick(By.xpath("(//span[@class='dialog-footer']//button)[2]"));
		MethodActions.waitEle(By.xpath("(//i[@class='el-icon-back'])[2]"));
	}

	public void assign1() throws Exception {
		assignCommonActions(1, 1);
	}

	public void assign2() throws Exception {
		assignCommonActions(2, 2);
	}

	public void assign3() throws Exception {
		assignCommonActions(3, 1);
	}

}
