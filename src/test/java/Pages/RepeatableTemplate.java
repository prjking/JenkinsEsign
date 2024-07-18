package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RepeatableTemplate {
	WebDriver driver;
	MethodActions methodActions;
	private String name;

	public RepeatableTemplate(WebDriver driver) {

		this.driver = driver;
		methodActions = new MethodActions(driver);
	}

	public void entity() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		Thread.sleep(10000);

		MethodActions.waitEle(By.xpath("//div[@class='icon-text']"));

		Thread.sleep(3000);

		By Entities = By.xpath("//li[normalize-space()=\"Entities\"]");
		WebElement Entities1 = wait.until(ExpectedConditions.elementToBeClickable(Entities));
		Entities1.click();

		System.out.println("Clicked on entities in profile completed");

	}

	public void ClickCreateEntity() throws Exception {

		By ad = By.xpath("//button[normalize-space()='Create Entity']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on ceate entity using JS.");

	}

	public void CreateEntityFromScratch(String s, String ET) throws Exception {
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
		String name = MethodActions.generateUniqueString();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Title']"), name);

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

	public void primaryFeild() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement FullName = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class=\"dropBox\"]//ul[@class=\"list-group\"]//li[text()=\" Single line text \"]")));

		WebElement Target = driver.findElement(By.xpath("(//ul[@class=\"list-group\"])[2]"));

		Actions actions = new Actions(driver);

		MethodActions.waitAndClick(actions, FullName, Target);

		System.out.println("primary feild Drag and Drop Done");

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Update & Next']"));

	}

	public void addtemplate(String t) throws Exception {

		String temp = String.format("//p[text()= '%s']", t);
		MethodActions.waitEle(By.xpath(temp));

		System.out.println("Form template added successfully");

		MethodActions.waitEle(By.xpath("//span[text()=\"Update & Next\"]"));
//		try {
//			primaryFeild();
//		} catch (Exception e) {
//		}
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));
		MethodActions.waitEle(By.xpath("//div[text()=\"Actions\"]"));

		MethodActions.waitEle(By.xpath("//span[text()=\"Done\"]"));

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
					System.out.printf("%s Field data %s displayed correctly\n", field, fieldValue);
				} else {
					System.out.printf(RED + "%s Field data %s not displayed or displayed incorrectly\n" + RESET, field,
							fieldValue);
				}
			} catch (Exception e) {
				try {
					WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'start'});", element);
					if (element.isDisplayed()) {
						System.out.printf("%s Field data %s displayed correctly after scroll\n", field, fieldValue);
					} else {
						System.out.printf(
								RED + "%s Field data %s not displayed or displayed incorrectly after scroll\n" + RESET,
								field, fieldValue);
					}
				} catch (Exception ex) {
					System.out.printf(RED + "%s Field data %s not found in the DOM\n" + RESET, field, fieldValue);
				}
			}
		}
	}

	public void DocScenario() throws Exception {

		MethodActions.waitEle(By.xpath("//span[text()=\"Create Document\"]"));
		System.out.println("Click on create Document Done Successfully");

	}

	public void Blankloginaccount(String name) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		try {
			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//img[@src='/img/Blank.1f314c3f.svg']"));
		MethodActions.switchToNewWindow();
		Thread.sleep(10000);

		By Docname1 = By.xpath("//input[@placeholder='Enter Document name']");
		WebElement Docnameen = wait.until(ExpectedConditions.elementToBeClickable(Docname1));
		Docnameen.sendKeys(name);

		driver.findElement(By.xpath("//span[normalize-space()='Continue']")).click();
		WebElement doc = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='fw-bold fs-24']")));
		Assert.assertNotNull(doc, "Add Recepient element is not present Create document failed");
		System.out.println("Selected BlankDocument successfully");

	}

	public void addContactAtAddrecipient(int id, String contactType, String email, String Fname, String Lname,
			String signerType) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Add Recipient')]")))
					.click();
		} catch (Exception E) {

		}
		System.out.println("Click on Add recipient done Successfully");
		String xpath = String.format("//div[@id='user_%d']//input[@placeholder='Select contact type']", id);
		MethodActions.waitEle(By.xpath(xpath));
		String con = String.format("//div[@x-placement]//ul//li[normalize-space()='%s']", contactType);
		MethodActions.waitEle(By.xpath(con));
		System.out.println("Selected contact type Successfully");

		String xpath2 = String.format("//div[@id='user_%d']//input[@placeholder='Search with Email']", id);
		MethodActions.waitEle(By.xpath(xpath2));
		MethodActions.sendKeysToElement(By.xpath(xpath2), email);

		String xpath3 = String.format("//span[text()='%s']", email);
		MethodActions.waitEle(By.xpath(xpath3));

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save Users']"));

		MethodActions.waitEle(
				By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]"));
		MethodActions.switchToNewWindow();
		driver.findElement(By.xpath("//input[@placeholder=\"First name \"]")).clear();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder=\"First name \"]"), Fname);
		driver.findElement(By.xpath("//input[@placeholder=\"Last name\"]")).clear();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder=\"Last name\"]"), Lname);
		MethodActions.waitEle(By.xpath("//span[text()=\" Save \"]"));
		Thread.sleep(5000);
		String xpath4 = String.format("//div[@id='user_%d']//input[@placeholder='Select Signer Type']", id);
		MethodActions.waitEle(By.xpath(xpath4));
		Thread.sleep(3000);
		String signertype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", signerType);
		MethodActions.waitEle(By.xpath(signertype));
		System.out.println("Selected Recipients Successfully");

	}

	public void Saveuser() throws Exception {

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save Users']"));
		System.out.println("Recipients added successfully");

	}

	public void SubDocScenarios(String s) throws Exception {
		try {
			MethodActions.waitEle(By.xpath("//span[normalize-space()=\"Send Document\"]"));
		} catch (Exception e) {
			MethodActions.waitEle(By.xpath("//span[text()=\"Finish Document\"]"));
		}

		System.out.println("click on send Doc after drag and drop done successfully");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By ele = By.xpath("//textarea[@placeholder='Subject']");
		WebElement sen = wait.until(ExpectedConditions.elementToBeClickable(ele));
		sen.sendKeys(s);
	}

	public void clickSubmit() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(5000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Send Document']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public void DragAndDropFeildsInDocument(String templateName, String arr[]) throws Exception {
		String feilds[] = arr;
		int l = feilds.length;
		System.out.println(l);
		Thread.sleep(5000);

		String TName = String.format("//div[text()=\"%s\"]", templateName);
		MethodActions.waitEle(By.xpath(TName));
		Thread.sleep(5000);
		int i = 1;
		for (int x = -350; x <= 250; x = x + 250) {
			for (int y = -180; y <= 210; y = y + 50) {
				if (i >= l) {
					break;
				}
				String xpath = String
						.format("//div[@class=\"fieldSet__box\"]//div[@class=\"dragArea-field-element\"][%d]", i);
				WebElement element = driver.findElement(RelativeLocator.with(By.xpath(xpath)).below(By.xpath(TName)));

				Actions actions = new Actions(driver);
				WebElement target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
				waitAndClick(actions, element, target, x, y);
				System.out.printf("%s Field Drag and Drop Done\n", feilds[i - 1]);
				i++;
			}
		}
		MethodActions.waitEle(By.xpath(TName));
	}

	public void waitAndClick(Actions actions, WebElement sourceElement, WebElement targetElement, int xOffset,
			int yOffset) {
		actions.clickAndHold(sourceElement).moveToElement(targetElement, xOffset, yOffset).release().build().perform();
	}

}
