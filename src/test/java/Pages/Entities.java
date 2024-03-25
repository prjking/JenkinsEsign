package Pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Entities {
	WebDriver driver;

	public Entities(WebDriver driver) {

		this.driver = driver;

	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void Entity() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@class=\"icon-text\"]"));

		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[7]"));

		System.out.println("Clicked on entities in profile completed");

	}

	public void EntityType() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select Type']"));

	}

	public void IndividualEntity() throws Exception {

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		System.out.println("Selected Individual Entity");

	}

	public void BusinessEntity() throws Exception {

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		System.out.println("Selected Business Entity");
	}

	public void GeneralEntity() throws Exception {

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		System.out.println("Selected General Entity");
	}

	public void ExportAll() throws Exception {

		waitEle(By.xpath(
				"//button[@class='el-tooltip p-button-sm p-button-secondary p-button-outlined export-button p-button p-component']"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Ok']"));

		System.out.println("Exported all entities successfully");
	}

	public void SearchEntity() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Title = By.xpath("//input[@placeholder='Search']");
		WebElement Title1 = wait.until(ExpectedConditions.elementToBeClickable(Title));
		Title1.sendKeys("entities4");

		System.out.println("Entity Searched successfully");

	}

	public void CreateEntity() throws Exception {

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
		Thread.sleep(10000);
		By Title = By.xpath("//input[@placeholder='Title']");
		WebElement Title1 = wait.until(ExpectedConditions.elementToBeClickable(Title));
		Title1.sendKeys(generateUniqueString());

		By Description = By.xpath("//textarea[@placeholder='Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("This entity is only for testing purpose");

		waitEle(By.xpath("//span[normalize-space()='GENERAL']"));

		waitEle(By.xpath("//p[normalize-space()='Create a new app base with custom fields,tables, and filters.']"));

		WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Confirm']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

	}

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

	public void addtemplates() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button[1]"));

		System.out.println("Form template added successfully");
		Thread.sleep(10000);
		try {
			waitEle(By.xpath("//div[@class='el-notification__closeBtn el-icon-close']"));

		} catch (Exception e) {

		}
		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement FullName = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dropBox']//ul//li")));

		WebElement Target = driver.findElement(
				By.xpath("//div[@class='el-scrollbar__wrap el-scrollbar__wrap--hidden-default']//span//ul"));

		Actions actions = new Actions(driver);

		waitAndClick(actions, FullName, Target);

		System.out.println("Name Drag and Drop Done");
		try {
			waitEle(By.xpath("//div[@class='el-notification__closeBtn el-icon-close']"));

		} catch (Exception e) {

		}

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));

	}

	public void Relationship() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Sync Relationships']"));

		waitEle(By.xpath("(//input[@placeholder='Select'])[3]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("//span[normalize-space()='Add Relationship']"));

		System.out.println("Relationship added successfully");

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void Customization() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Customize']"));

		waitEle(By.xpath("(//span[@class='el-switch__core'])[3]"));

		waitEle(By.xpath("(//span[@class='el-switch__core'])[6]"));

		System.out.println("Customization updated successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void Action() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Add new action']"));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(3));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		By Action = By.xpath("//input[@placeholder='Enter Action Name']");
		WebElement Action1 = wait1.until(ExpectedConditions.elementToBeClickable(Action));
		Action1.sendKeys("Action1");

		waitEle(By.xpath("(//button[@class='el-button el-button--default'])[2]"));

		waitEle(By.xpath("//input[@placeholder='When point']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		waitEle(By.xpath("(//span[@class='el-radio__inner'])[2]"));

		waitEle(By.xpath("//input[@placeholder='Action type']"));

		waitEle(By.xpath("(//div[@x-placement]//ul//li[3])[1]"));

		waitEle(By.xpath("//button[@class='el-button email-config-button el-button--default']"));

		Thread.sleep(10000);

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By Subject = By.xpath("//textarea[@placeholder='Enter Subject']");
		WebElement Subject1 = wait1.until(ExpectedConditions.elementToBeClickable(Subject));
		Subject1.sendKeys("Testing purpose");

		waitEle(By.xpath("//input[@placeholder='Select Field to copy']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@element-loading-text='Fetching existed data']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 100;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();
		Thread.sleep(10000);

		WebElement iframe = wait1.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));

		// Switch to the iframe
		driver.switchTo().frame(iframe);

		try {
			driver.findElement(
					By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p"))
					.sendKeys(
							"Testing purpose1 please ignore this mail and continue the process,People who produce designs are called designers");

		} catch (Exception e) {

		}
		driver.switchTo().defaultContent();

		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[2]"));

		System.out.println("Entity Action added successfully");

		waitEle(By.xpath("//button[@class='el-button mt-1 mr-1 el-button--primary']"));

		System.out.println("Entity Updated successfully");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='el-button mt-1 mr-1 el-button--primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		System.out.println("Document Done Sucessfully");

	}

	public void Perform() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover2 = driver
				.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//span[normalize-space()='Actions']"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).perform();

	}

	public void Perform1() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[3]//i[@class='el-icon-arrow-down el-icon--right']"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).perform();

	}

	public void Businessentityindex() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[5]"));

		System.out.println("Selected business entity successfully");

		waitEle(By.xpath("//span[text()='Create new']"));

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select type']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Folder = By.xpath("//input[@placeholder='Enter name']");
		WebElement Folder1 = wait1.until(ExpectedConditions.elementToBeClickable(Folder));
		Folder1.sendKeys("Testing folder");

		waitEle(By.xpath("//input[@placeholder='Select entity']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		waitEle(By.xpath("(//span[normalize-space()='Save'])[1]"));

		System.out.println("shared file with entity successfully");
	}

	public void CheckSharedfileinEntity() throws Exception {

		waitEle(By.xpath("//i[@class='el-icon-arrow-left']"));

		Perform1();

		waitEle(By.xpath("//ul[@x-placement]//a[5]"));

		System.out.println("shared file is not showing");
		Thread.sleep(10000);
		
	}

	public void FormTemplate() throws Exception {
		Thread.sleep(10000);

		Thread.sleep(10000);

		waitEle(By.xpath("//div[@class=\"icon-text\"]"));

		Thread.sleep(3000);

		waitEle(By.xpath("//ul[@x-placement]//a[5]"));

		System.out.println("Clicked on Form template in profile completed");

	}

	private static int counter = 0;

	public static String generateUniqueString() {
		return "unique_string_sample" + UUID.randomUUID().toString().substring(0, 8) + counter++;

	}

	public void CreateFormtemplate() throws Exception {

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By ad = By.xpath("//button[normalize-space()='Create Template']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on ceate form template using JS.");

		By Name = By.xpath("//input[@placeholder='Enter Template Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name));
		Name1.sendKeys(generateUniqueString());

		By Description = By.xpath("//textarea[@placeholder='Enter Template Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("Test purpose");

		waitEle(By.xpath("(//span[normalize-space()='Submit'])[1]"));
	}

	public void Addbasicfields() throws Exception {

		waitEle(By.xpath("(//div[normalize-space()='Basic Fields'])[2]"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		WebElement Name = driver.findElement(By.xpath("(//span[normalize-space()='Single Line Text'])[2]"));

		Actions actions = new Actions(driver);

		waitAndClick(actions, Name, Target);

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

		WebElement Select = driver.findElement(By.xpath("(//span[normalize-space()='Select'])[1]"));

		waitAndClick(actions, Select, Target);

		System.out.println("Select Element Drag and Drop Done");

		Set<String> windowHandles11 = driver.getWindowHandles();
		for (String handle : windowHandles11) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By Name111 = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement Name1111 = wait.until(ExpectedConditions.elementToBeClickable(Name111));
		Name1111.sendKeys("Select");

		By Option = By.xpath("//input[@class='el-select__input']");
		WebElement Option1 = wait.until(ExpectedConditions.elementToBeClickable(Option));
		Option1.sendKeys("A");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		By Option2 = By.xpath("//input[@class='el-select__input']");
		WebElement Option22 = wait.until(ExpectedConditions.elementToBeClickable(Option2));
		Option22.sendKeys("B");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		waitEle(By.xpath("//span[normalize-space()='Save']"));

		Thread.sleep(10000);
	}

	public void ClickCreateEntity() throws Exception {
		Thread.sleep(10000);

		By ad = By.xpath("//button[normalize-space()='Create Entity']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on ceate entity using JS.");

	}

	public void CreateBusinessentity() throws Exception {
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
		Thread.sleep(10000);
		By Title = By.xpath("//input[@placeholder='Title']");
		WebElement Title1 = wait.until(ExpectedConditions.elementToBeClickable(Title));
		Title1.sendKeys(generateUniqueString());

		By Description = By.xpath("//textarea[@placeholder='Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("This entity is only for testing purpose");

		waitEle(By.xpath("//span[normalize-space()='BUSINESS']"));

		waitEle(By.xpath("//p[normalize-space()='Create a new app base with custom fields,tables, and filters.']"));

		waitEle(By.xpath("//button[@class='el-button el-button--primary']"));

		System.out.println("Create entity successfull");
	}

	public void RemoveWarning() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Update & Next']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		System.out.println("Document Updated Sucessfully");

		Thread.sleep(10000);
	}

	public void Updation() throws Exception {
		for (int i = 0; i < 3; i++) {
			RemoveWarning();
		}

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='el-button mt-1 mr-1 el-button--primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		System.out.println("Document Done Successfully");

	}

	public void actionView() throws Exception {

		Perform();

		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

		waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[1]"));

		waitEle(By.xpath("//span[normalize-space()='Actions']"));

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

		Set<String> windowHandles11 = driver.getWindowHandles();
		for (String handle : windowHandles11) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		waitEle(By.xpath("(//input[@placeholder='Select'])[3]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		waitEle(By.xpath("//span[normalize-space()='Update']"));

		waitEle(By.xpath("//img[@src='/img/Filter.0a98e59d.svg']"));

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
	}

	@SuppressWarnings("deprecation")
	public void ImportcontactFromspeadsheet() throws Exception {
		Thread.sleep(10000);
		Perform();
		Thread.sleep(10000);
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));

		waitEle(By.xpath("//div[@class='right-block float-right']//button//i"));

		waitEle(By.xpath("//div[normalize-space()='Contacts']"));

		waitEle(By.xpath("//span[normalize-space()='Import contacts']"));

		waitEle(By.xpath("//span[normalize-space()='Import from Spreadsheet']"));

		Set<String> windowHandles11 = driver.getWindowHandles();
		for (String handle : windowHandles11) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button download-csv ml-3 el-button--default el-button--mini']"));

		waitEle(By.xpath("//button[@class='el-button el-button--danger']"));

		waitEle(By.xpath("//span[normalize-space()='Import Contacts List']"));

		Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\Importexcel\"");

		Thread.sleep(10000);
		waitEle(By.xpath("(//span[normalize-space()='Import Contacts'])[3]"));

		Thread.sleep(10000);
		WebElement contactfailed = driver.findElement(By.xpath("//div[@class='result-row failed indent']//span[1]"));
		WebElement contactadded = driver.findElement(By.xpath("//div[@class='result-row failed indent']//span[1]"));

		String status;
		if (contactfailed.getText().equals("Contacts added:")) {
			status = "Contacts added:";
		} else if (contactadded.getText().equals("Contacts failed:")) {
			status = "Contacts failed:";
		} else {
			status = "unknown";
		}

		System.out.println("Status: " + status);
	}

	public void LoginAkhilpachiapala() throws InterruptedException {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("akhil.pachipala@nimbleaccounting.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Nimble#2023");
		driver.findElement(By.xpath("//span[normalize-space()='Log In']")).click();
		Thread.sleep(10000);

	}

	public void ValidEntityField() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__fixed']//div[contains(text(),'Book venue')]/ancestor::tr//span[normalize-space()=\"Actions\"]"));
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();

		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

		waitEle(By.xpath("(//td[@class='el-table_4_column_24   el-table__cell']//a//span)[1]"));

		Set<String> windowHandles11 = driver.getWindowHandles();
		for (String handle : windowHandles11) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='close-button']"));

		Thread.sleep(10000);
		WebElement EntityField = driver.findElement(By.xpath("//h3[@class='table-head-text']"));

		String status;
		if (EntityField.getText().equals("Book venue")) {
			status = "Resolved";
		} else {
			status = "Crash";
		}

		System.out.println("Status: " + status);
		
		Thread.sleep(10000);
		
	}

	public void Addbasicfields1() throws Exception {

		waitEle(By.xpath("(//div[normalize-space()='Basic Fields'])[2]"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		WebElement Name = driver
				.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[2]"));

		Actions actions = new Actions(driver);

		waitAndClick(actions, Name, Target);

		System.out.println("Multiline Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By Name11 = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name11));
		Name1.sendKeys("Rich text");

		By row1 = By.xpath("//input[@placeholder='Enter Number Of Rows']");
		WebElement row2 = wait.until(ExpectedConditions.elementToBeClickable(row1));
		row2.sendKeys("3");

		waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		waitEle(By.xpath("//span[normalize-space()='Save']"));

		try {
			waitEle(By.xpath("//div[@class='el-notification__closeBtn el-icon-close']"));

		} catch (Exception e) {

		}
	}

	public void addtemplatetogeneralentity() throws Exception {
		Thread.sleep(10000);
		By ad = By.xpath("(//div[@class='el-scrollbar__view'])[2]//button[1]");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);

		System.out.println("Form template added successfully");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement FullName = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='el-scrollbar__view'])[2]//ul//li[1]")));

		WebElement Target = driver.findElement(By.xpath("(//div[@class='el-scrollbar'])[4]"));

		Actions actions = new Actions(driver);

		waitAndClick(actions, FullName, Target);

		System.out.println("Name Drag and Drop Done");

		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}
		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));

	}

	public void enterdata() throws Exception {

		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[1]"));
		MethodActions.Loadingmask();

		waitEle(By.xpath("//button[@class='el-button el-tooltip entity-add-btn el-button--primary']"));

		scrol();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement iframe = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));

		// Switch to the iframe
		driver.switchTo().frame(iframe);

		try {
			driver.findElement(
					By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p"))
					.sendKeys("ramya; teju; meghana");

		} catch (Exception e) {

		}

		driver.switchTo().defaultContent();
		waitEle(By.xpath("//span[text()=' Save ']"));
		Thread.sleep(30000);
		waitEle(By.xpath("//ul[@x-placement]//a[1]"));
		waitEle(By.xpath("(//div[@class='ml-1 el-dropdown'])[2]"));
		waitEle(By.xpath("(//ul[@class='el-dropdown-menu el-popper'])[3]//a[1]"));

	}

	public void scrollDown() throws Exception {
		Thread.sleep(10000);
		WebElement scrollbar = driver.findElement(By.xpath("(//div[@class='el-scrollbar__bar is-vertical'])[4]"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 100;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();
		System.out.println("ScrollDown done successfully");
	}

	public void AllCombos() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Create Document']"));

	}

	public void ValidAllCombos() {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message = wait1.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h3[@class='text-center text-dark fw-normal fs-4 mb-1']")));
		Assert.assertNotNull(Message, "Upload document element is not present Create document failed");
		System.out.println("Create document successfull");
	}

	@SuppressWarnings("deprecation")
	public void Fileuploadfromdownloads() throws InterruptedException, Exception {

		By Element = By.xpath("//h4[@class='fw-normal blue pb-2']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(4));
		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));
		canc.click();
		Runtime.getRuntime()
				.exec("\"C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\fileupload.exe\"");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class='el-button text-center upload-btn el-button--danger']")).click();

	}

	public void ValidUploadDocument() throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Next']")));
		Assert.assertNotNull(Message1, "Next button not present Create document failed");
		System.out.println("Upload document successfull");

	}

	public void Nextbt() throws Exception {

		waitEle(By.xpath("//button[@class='el-button text-center upload-btn el-button--danger']"));
		Thread.sleep(10000);
	}

	public void ValidNextbtn() {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[normalize-space()='Add Recipients']")));
		Assert.assertNotNull(Message1, "Add Recipient not present Create document failed");
		System.out.println("Document successfull");

	}

	public void AddRep() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//img[@src='/img/Add Recipients.0f0af0e8.svg']"));

	}

	public void Addrepsigner1() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select contact type']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Search with Email']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select Signer Type']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
	}

	public void ValidAddRepSigner1() {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@x-placement]//ul//li[1]")));
		Assert.assertNotNull(Message1, "Signer present in Add Recipient failed");
		System.out.println("Signer  is successfull");
	}

	public void Saveuser() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Save Users']"));

	}

	public void scrol() throws Exception {
		Thread.sleep(5000);
		WebElement s = driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, editor2']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", s);
	}

	public void CreateIndividualentity() throws Exception {
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
		Thread.sleep(10000);
		By Title = By.xpath("//input[@placeholder='Title']");
		WebElement Title1 = wait.until(ExpectedConditions.elementToBeClickable(Title));
		Title1.sendKeys(generateUniqueString());

		By Description = By.xpath("//textarea[@placeholder='Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("This entity is only for testing purpose");

		waitEle(By.xpath("//span[normalize-space()='INDIVIDUAL']"));

		waitEle(By.xpath("//p[normalize-space()='Create a new app base with custom fields,tables, and filters.']"));

		waitEle(By.xpath("//span[normalize-space()='Confirm']"));

		System.out.println("Create entity successfull");
	}

	public void Done1() throws Exception {

		RemoveWarning();

		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='el-button mt-1 mr-1 el-button--primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		System.out.println("Document Done Sucessfully");

	}

	public void Entity1() throws Exception {
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		Thread.sleep(3000);

		waitEle(By.xpath("//div[@class=\"icon-text\"]"));

		Thread.sleep(3000);

		By Entities = By.xpath("(//img[@src='/img/Entities Inactive.4c2a8f0e.svg'])[1]");
		WebElement Entities1 = wait.until(ExpectedConditions.elementToBeClickable(Entities));
		Entities1.click();

		System.out.println("Clicked on entities in profile completed");

		Thread.sleep(10000);
	}

	public void scrol1() throws Exception {
		Thread.sleep(5000);
		WebElement s = driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, editor3']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", s);
	}

	public void AssignData() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

		waitEle(By.xpath("//button[@class='el-button el-tooltip entity-add-btn el-button--primary']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		By FirstName = By.xpath("//input[@placeholder='First Name']");
		WebElement FirstName1 = wait.until(ExpectedConditions.elementToBeClickable(FirstName));
		FirstName1.sendKeys("Ramya");

		By MiddleName = By.xpath("//input[@placeholder='Middle Name']");
		WebElement MiddleName1 = wait.until(ExpectedConditions.elementToBeClickable(MiddleName));
		MiddleName1.sendKeys("Sri");

		By LastName = By.xpath("//input[@placeholder='Last Name']");
		WebElement LastName1 = wait.until(ExpectedConditions.elementToBeClickable(LastName));
		LastName1.sendKeys("Sibbala");

		By Email = By.xpath("//input[@placeholder='Email']");
		WebElement Email1 = wait.until(ExpectedConditions.elementToBeClickable(Email));
		Email1.sendKeys("ramya@gmail.com");

		Thread.sleep(10000);
		By ad = By.xpath("//span[normalize-space()='Save & Next']");

		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("Element clicked using JS.");
		} catch (Exception e) {

			System.out.println("Element not clickable or not found: ");
		}

		Thread.sleep(10000);
		scrol11();

		WebElement iframe = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']")));

		// Switch to the iframe
		driver.switchTo().frame(iframe);

		try {
			driver.findElement(
					By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//p"))
					.sendKeys("ramya; teju; meghana");

		} catch (Exception e) {

		}

		driver.switchTo().defaultContent();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement element = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Save']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		System.out.println("clicked on save Sucessfully");

		Thread.sleep(10000);
		waitEle(By.xpath("(//button[@class='el-button px-2 ml-2 el-button--primary el-button--mini is-plain'])[2]"));

		waitEle(By.xpath("(//div[@class='el-tabs__item is-top'])[1]"));

		waitEle(By.xpath(
				"(//button[@class='el-button el-tooltip right-block float-right add-buttons mt-0 button-uppercase el-button--default'])[1]"));

		waitEle(By.xpath("//input[@class='el-select__input']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		WebElement element1 = wait1.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='el-button el-button--primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element1);
		System.out.println("clicked on save Sucessfully");

		Thread.sleep(10000);
		WebElement EntityField = driver
				.findElement(By.xpath("(//span//p[normalize-space()='ramya; teju; meghana'])[1]"));

		String status;
		if (EntityField.getText().equals("ramya; teju; meghana")) {
			status = "Resolved";
		} else {
			status = "Crash";
		}

		System.out.println("Status: " + status);
	}

	public void scrol11() throws Exception {
		Thread.sleep(5000);
		WebElement s = driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, editor3']"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", s);
	}

	public void Clickonmarketplace() throws Exception {
		Thread.sleep(10000);

		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		Thread.sleep(3000);

		waitEle(By.xpath("//div[@class=\"icon-text\"]"));

		Thread.sleep(3000);

		By Entities = By.xpath("//img[@src='/img/Marketplace.3a0154e5.svg']");
		WebElement Entities1 = wait.until(ExpectedConditions.elementToBeClickable(Entities));
		Entities1.click();

		System.out.println("Clicked on marketplace in profile completed");

		Thread.sleep(10000);

	}

	@SuppressWarnings("deprecation")
	public void createfromexcel() throws Exception {
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		waitEle(By.xpath("//button[@class='el-button el-button--default']"));

		waitEle(By.xpath("//button[@class='el-button create-btn px-4 ml-2 el-button--primary is-plain']"));

		waitEle(By.xpath("(//div[@class='entity-type-box'])[2]"));

		waitEle(By.xpath("//button[@class='el-button el-button--primary']"));

		waitEle(By.xpath("//button[@class='match_upload_button mt-0']"));

		Runtime.getRuntime()
				.exec("\"C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\createfromexcel.exe\"");
		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button el-button--danger']"));

		waitEle(By.xpath("(//i[@class='el-icon-circle-plus'])[1]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		By Title = By.xpath("//input[@placeholder='Enter Title']");
		WebElement Title1 = wait.until(ExpectedConditions.elementToBeClickable(Title));
		Title1.sendKeys("QA test");

		waitEle(By.xpath("//button[@class='el-button px-20 el-button--success']"));

		By group = By.xpath("//input[@placeholder='Enter Title']");
		WebElement group1 = wait.until(ExpectedConditions.elementToBeClickable(group));
		group1.clear();

		waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		waitEle(By.xpath("//div[@id='tab-Vendors']"));

		Creategroup();

		waitEle(By.xpath("//div[@id='tab-Invoices']"));

		Creategroup();

		waitEle(By.xpath("//div[@id='tab-Payments']"));

		Creategroup();

		waitEle(By.xpath("//div[@id='tab-Bills']"));

		Creategroup();

		waitEle(By.xpath("//div[@id='tab-Bill Payments']"));

		Creategroup();

		waitEle(By.xpath("//button[@class='el-button el-button--danger']"));

		waitEle(By.xpath("//span[normalize-space()='Create']"));

	}

	public void Creategroup() throws Exception {

		waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[4]"));
	}

	public void Repeatabletemplate() throws Exception {

		waitEle(By.xpath("(//div[normalize-space()='Basic Fields'])[2]"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		WebElement Name = driver.findElement(By.xpath("(//span[normalize-space()='Single Line Text'])[2]"));

		Actions actions = new Actions(driver);

		waitAndClick(actions, Name, Target);

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
		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button el-tooltip el-tooltips el-button--primary is-plain']"));

		Set<String> windowHandles4 = driver.getWindowHandles();
		for (String handle : windowHandles4) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select Field']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("//button[@class='el-button sub-btn el-button--default']"));
	}

	public void AddSelectField() throws Exception {
		waitEle(By.xpath("(//div[normalize-space()='Basic Fields'])[2]"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		WebElement Select1 = driver
				.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[3]"));

		Actions actions = new Actions(driver);

		waitAndClick(actions, Select1, Target);

		System.out.println("Select Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By Name11 = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name11));
		Name1.sendKeys("Subject");

		By Option = By.xpath("//input[@class='el-select__input']");
		WebElement Option1 = wait.until(ExpectedConditions.elementToBeClickable(Option));
		Option1.sendKeys("Computer science");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		By Option2 = By.xpath("//input[@class='el-select__input']");
		WebElement Option22 = wait.until(ExpectedConditions.elementToBeClickable(Option2));
		Option22.sendKeys("maths");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		By Option3 = By.xpath("//input[@class='el-select__input']");
		WebElement Option32 = wait.until(ExpectedConditions.elementToBeClickable(Option3));
		Option32.sendKeys("Physics");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement Number = driver
				.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[4]"));

		Actions actions1 = new Actions(driver);

		waitAndClick(actions1, Number, Target);

		System.out.println("Number Element Drag and Drop Done");

		Set<String> windowHandles11 = driver.getWindowHandles();
		for (String handle : windowHandles11) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By Name111 = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement Name1111 = wait.until(ExpectedConditions.elementToBeClickable(Name111));
		Name1111.sendKeys("marks");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		WebElement Name = driver.findElement(By.xpath("(//span[normalize-space()='Single Line Text'])[2]"));

		Actions actions3 = new Actions(driver);

		waitAndClick(actions3, Name, Target);

		System.out.println("Name Element Drag and Drop Done");

		Set<String> windowHandles3 = driver.getWindowHandles();
		for (String handle : windowHandles3) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By result = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement result1 = wait.until(ExpectedConditions.elementToBeClickable(result));
		result1.sendKeys("result");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
	}

	public void Formrule1() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		waitEle(By.xpath("//img[@src='/img/Icon-ellipsis-v.eb3a1342.svg']"));

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

		Set<String> windowHandles4 = driver.getWindowHandles();
		for (String handle : windowHandles4) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button add-rule el-button--danger el-button--mini is-plain']"));

		By rulename = By.xpath("//input[@placeholder='Rule name']");
		WebElement rulename1 = wait.until(ExpectedConditions.elementToBeClickable(rulename));
		rulename1.sendKeys("rule-1");

		waitEle(By.xpath("(//span[@class='el-input__suffix-inner'])[3]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("(//span[@class='el-input__suffix-inner'])[4]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		waitEle(By.xpath("(//span[@class='el-input__suffix-inner'])[5]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		By value = By.xpath("(//input[@class='el-input__inner'])[7]");
		WebElement value1 = wait.until(ExpectedConditions.elementToBeClickable(value));
		value1.clear();

		By valuee = By.xpath("(//input[@class='el-input__inner'])[7]");
		WebElement valuee1 = wait.until(ExpectedConditions.elementToBeClickable(valuee));
		valuee1.sendKeys("80");

		waitEle(By.xpath("(//span[@class='el-input__suffix-inner'])[7]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		waitEle(By.xpath("(//span[@class='el-input__suffix-inner'])[8]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[4]"));

		waitEle(By.xpath("(//span[@class='el-input__suffix-inner'])[9]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		By valueee = By.xpath("//input[@placeholder='Value']");
		WebElement valueee1 = wait.until(ExpectedConditions.elementToBeClickable(valueee));
		valueee1.sendKeys("F.C");

		waitEle(By.xpath("//button[@class='el-button el-button--primary el-button--mini']"));
	}

	public void Formrule2() throws Exception {

//		form rule-2
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		waitEle(By.xpath("//button[@class='el-button el-button--danger el-button--mini is-plain']"));

		By rulename = By.xpath("//input[@placeholder='Rule name']");
		WebElement rulename1 = wait.until(ExpectedConditions.elementToBeClickable(rulename));
		rulename1.sendKeys("rule-2");

		waitEle(By.xpath("(//span[@class='el-input__suffix-inner'])[3]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("(//span[@class='el-input__suffix-inner'])[4]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[5]"));

		waitEle(By.xpath("(//span[@class='el-input__suffix-inner'])[5]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		By value = By.xpath("(//input[@class='el-input__inner'])[7]");
		WebElement value1 = wait.until(ExpectedConditions.elementToBeClickable(value));
		value1.clear();

		By valuee = By.xpath("(//input[@class='el-input__inner'])[7]");
		WebElement valuee1 = wait.until(ExpectedConditions.elementToBeClickable(valuee));
		valuee1.sendKeys("50");

		waitEle(By.xpath("(//span[@class='el-input__suffix-inner'])[7]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		waitEle(By.xpath("//div[@class='el-scrollbar']//input[@placeholder='Query type']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[4]"));

		waitEle(By.xpath("(//span[@class='el-input__suffix-inner'])[9]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		By valueee = By.xpath("//input[@placeholder='Value']");
		WebElement valueee1 = wait.until(ExpectedConditions.elementToBeClickable(valueee));
		valueee1.sendKeys("T.C");

		waitEle(By.xpath("//button[@class='el-button el-button--primary el-button--mini']"));

		waitEle(By.xpath("//button[@class='close-button']"));

		waitEle(By.xpath("//button[@class='el-button el-tooltip el-tooltips el-button--primary is-plain']"));

		Set<String> windowHandles4 = driver.getWindowHandles();
		for (String handle : windowHandles4) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select Field']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("//button[@class='el-button sub-btn el-button--default']"));

	}

	public void CreateFormtemplate1() throws Exception {

		Thread.sleep(10000);

		By ad = By.xpath("//button[normalize-space()='Create Template']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on ceate entity using JS.");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Name = By.xpath("//input[@placeholder='Enter Template Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name));
		Name1.sendKeys(generateUniqueString());

		By Description = By.xpath("//textarea[@placeholder='Enter Template Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("Test purpose");

		waitEle(By.xpath("(//span[@class='el-checkbox__input'])[1]"));

		waitEle(By.xpath("(//span[normalize-space()='Submit'])[1]"));
	}

	public void AddTwotemplatestoData() throws Exception {
		Thread.sleep(10000);
		By ad = By.xpath("(//div[@class='el-scrollbar__view'])[2]//button[2]");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);

		System.out.println("Form template1 added successfully");

		Thread.sleep(10000);
		By ad1 = By.xpath("(//div[@class='el-scrollbar__view'])[2]//button[1]");

		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add1 = hold1.until(ExpectedConditions.elementToBeClickable(ad1));

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", add1);

		System.out.println("Form template2 added successfully");
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement FullName = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='el-scrollbar__view'])[2]//ul//li[1]")));

		WebElement Target = driver.findElement(By.xpath("(//div[@class='el-scrollbar'])[4]"));

		Actions actions = new Actions(driver);

		waitAndClick(actions, FullName, Target);

		System.out.println("Name Drag and Drop Done");

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void Adddatato3280() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

		waitEle(By.xpath("//button[@class='el-button el-tooltip entity-add-btn el-button--primary']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		By Description = By.xpath("//input[@placeholder='Name']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("Ramya");

		waitEle(By.xpath("//button[@class='el-button scaling-button el-button--primary el-button--mini']"));

		waitEle(By.xpath("//button[@class='el-button el-button--primary el-button--mini']"));

		waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		By Marks = By.xpath("(//input[@placeholder='marks'])[2]");
		WebElement Marks1 = wait.until(ExpectedConditions.elementToBeClickable(Marks));
		Marks1.sendKeys("80");

		waitEle(By.xpath("(//input[@placeholder='result'])[2]"));

		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button el-button--primary el-button--mini']"));

		waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		By Marks11 = By.xpath("(//input[@placeholder='marks'])[2]");
		WebElement Marks111 = wait.until(ExpectedConditions.elementToBeClickable(Marks11));
		Marks111.sendKeys("50");

		waitEle(By.xpath("(//input[@placeholder='result'])[2]"));

		waitEle(By.xpath("//span[@class='el-switch__core']"));

		Thread.sleep(10000);
		WebElement EntityField = driver.findElement(By.xpath("(//div[@class='execute-view el-col el-col-24'])[1]//p"));

		String status;
		if (EntityField.getText().equals("F.C")) {
			status = "Resolved";
		} else {
			status = "Crash";
		}

		System.out.println("Status: " + status);
	}

	public void AddNamefields() throws Exception {

		waitEle(By.xpath("(//div[normalize-space()='Basic Fields'])[2]"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		WebElement Name = driver.findElement(By.xpath("(//span[normalize-space()='Single Line Text'])[2]"));

		Actions actions1 = new Actions(driver);

		waitAndClick(actions1, Name, Target);

		System.out.println("Name Element Drag and Drop Done");

		Set<String> windowHandles11 = driver.getWindowHandles();
		for (String handle : windowHandles11) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By single = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement single1 = wait.until(ExpectedConditions.elementToBeClickable(single));
		single1.sendKeys("Name");

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		waitEle(By.xpath("//button[@class='el-button el-tooltip el-tooltips el-button--primary is-plain']"));

		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}

	}

	public void AddCurrField() throws Exception {

		waitEle(By.xpath("(//div[normalize-space()='Advanced Fields'])[3]"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		WebElement Currency = driver
				.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[35]"));

		Actions actions = new Actions(driver);

		waitAndClick(actions, Currency, Target);

		System.out.println("Currency Element Drag and Drop Done");

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By curr = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement curr1 = wait.until(ExpectedConditions.elementToBeClickable(curr));
		curr1.sendKeys("Cost");

		waitEle(By.xpath("//input[@id='currencySelect']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[4]"));

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		waitEle(By.xpath("//button[@class='el-button el-tooltip el-tooltips el-button--primary is-plain']"));
		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}

	}

	public void enterdata1() throws Exception {
		Thread.sleep(10000);
		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

		waitEle(By.xpath("//button[@class='el-button el-tooltip entity-add-btn el-button--primary']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		By Description = By.xpath("//input[@placeholder='Cost']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("20");

		waitEle(By.xpath("//button[@class='el-button el-button--primary el-button--mini el-dropdown-selfdefine']"));

		waitEle(By.xpath("//ul[@x-placement]//a[1]"));
	}

	public void AddDatato1553() throws Exception {
		Perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

		waitEle(By.xpath("//button[@class='el-button el-tooltip entity-add-btn el-button--primary']"));

		By FirstName = By.xpath("//input[@placeholder='First Name']");
		WebElement FirstName1 = wait.until(ExpectedConditions.elementToBeClickable(FirstName));
		FirstName1.sendKeys("Ramya");

		By MiddleName = By.xpath("//input[@placeholder='Middle Name']");
		WebElement MiddleName1 = wait.until(ExpectedConditions.elementToBeClickable(MiddleName));
		MiddleName1.sendKeys("Sri");

		By LastName = By.xpath("//input[@placeholder='Last Name']");
		WebElement LastName1 = wait.until(ExpectedConditions.elementToBeClickable(LastName));
		LastName1.sendKeys("Sibbala");

		By Email = By.xpath("//input[@placeholder='Email']");
		WebElement Email1 = wait.until(ExpectedConditions.elementToBeClickable(Email));
		Email1.sendKeys("ramya@gmail.com");

		Thread.sleep(10000);
		By ad = By.xpath("//span[normalize-space()='Save & Next']");

		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("Element clicked using JS.");
		} catch (Exception e) {

			System.out.println("Element not clickable or not found: ");
		}

		Thread.sleep(10000);

		By Fullname = By.xpath("//input[@placeholder='Name']");
		WebElement Fullname1 = wait.until(ExpectedConditions.elementToBeClickable(Fullname));
		Fullname1.sendKeys("Ramyasri");

		By ad1 = By.xpath("//button[@class='el-button scaling-button el-button--primary el-button--mini']");

		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad1));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("Element clicked using JS.");
		} catch (Exception e) {

			System.out.println("Element not clickable or not found: ");
		}

		waitEle(By.xpath("(//button[@class='el-button px-2 ml-2 el-button--primary el-button--mini is-plain'])[2]"));

		waitEle(By.xpath("(//div[@class='el-tabs__item is-top'])[1]"));

		waitEle(By.xpath(
				"(//button[@class='el-button el-tooltip right-block float-right add-buttons mt-0 button-uppercase el-button--default'])[2]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By curr = By.xpath("//input[@placeholder='Cost']");
		WebElement curr1 = wait.until(ExpectedConditions.elementToBeClickable(curr));
		curr1.sendKeys("20");

		waitEle(By.xpath("//button[@class='el-button el-button--primary']"));

		Thread.sleep(10000);

		WebElement EntityField = driver
				.findElement(By.xpath("(//td[@class='el-table_2_column_4   el-table__cell']//div//span)[1]"));

		String status;
		if (EntityField.getText().equals("₹20.00")) {
			status = "Resolved";
		} else {
			status = "Crash";
		}

		System.out.println("Status: " + status);

	}

	public void Repeatableformtemplate1() throws Exception {

		waitEle(By.xpath("(//div[normalize-space()='Basic Fields'])[2]"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		WebElement Document = driver
				.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[18]"));

		Actions actions1 = new Actions(driver);

		waitAndClick(actions1, Document, Target);

		System.out.println("Document Element Drag and Drop Done");

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		By title = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement title1 = wait.until(ExpectedConditions.elementToBeClickable(title));
		title1.sendKeys("Document");

		waitEle(By.xpath("//input[@class='el-select__input']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[7]"));

		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		waitEle(By.xpath("//button[@class='el-button el-tooltip el-tooltips el-button--primary is-plain']"));

		Set<String> windowHandles4 = driver.getWindowHandles();
		for (String handle : windowHandles4) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select Field']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("//button[@class='el-button sub-btn el-button--default']"));
	}

	@SuppressWarnings("deprecation")
	public void AddDatato1299() throws Exception {
		Thread.sleep(10000);
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}

		waitEle(By.xpath("//button[@class='el-button el-tooltip entity-add-btn el-button--primary']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		By Description = By.xpath("//input[@placeholder='Name']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("Ramya");

		waitEle(By.xpath("//button[@class='el-button scaling-button el-button--primary el-button--mini']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button el-button--primary el-button--mini']"));

		waitEle(By.xpath("(//div[@class='el-upload el-upload--text'])[2]"));

		Runtime.getRuntime()
				.exec("\"C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\multiple document.exe\"");

		waitEle(By.xpath("//button[@class='el-button el-button--primary el-button--mini']"));

		Thread.sleep(10000);

		WebElement EntityField = driver
				.findElement(By.xpath("(//td[@class='el-table_17_column_84   el-table__cell'])[1]"));

		String status;
		if (EntityField.getText().equals("Major proj...")) {
			status = "Resolved";
		} else {
			status = "Crash";
		}

		System.out.println("Status: " + status);
	}

	public void Screenshot() throws Exception {
		
		
		Thread.sleep(10000);
		MethodActions.takeScreenshot(driver);
		
	}
}
