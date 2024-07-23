package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Formtemplates_globalvariable {
	WebDriver driver;
	MethodActions methodActions;
	Login login;
	FormTemplate formTemplate;

	public Formtemplates_globalvariable(WebDriver driver) {
		this.driver = driver;
		methodActions = new MethodActions(driver);
		login = new Login(driver);
	}

	public void GlobalVariableActions() throws Exception {
		// Basic Fields
		String[] basicFieldsElementTypes = { "Single Line Text", "Multi Line Text", "Select", "Number",
				"Multiple Select", "List", "Date", "Time", "Time Range", "Date Time", "Week Days", "Date Time Range",
				"Date Range", "Checkbox Group", "Radio Group" };
		executeGlobalVariableActions("Basic Fields", basicFieldsElementTypes, -350, -180);
		MethodActions.waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		// Content Fields
		String[] contentFieldsElementTypes = { "HTML", "Image" };
		executeGlobalVariableActions("Content Fields", contentFieldsElementTypes, -450, -280);
		MethodActions.waitEle(By.xpath("//div[text()=\"Content Fields\"]"));

		// Advanced Fields
		String[] advancedFieldsElementTypes = { "Currency", "Star Rating" };
		executeGlobalVariableActions("Advanced Fields", advancedFieldsElementTypes, -550, -280);
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save']"));
		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[2]"));
		MethodActions.waitEle(By.xpath("//button[text()=' Add to company profile ']"));

	}

	public void executeGlobalVariableActions(String section, String[] elementTypes, int startX, int startY)
			throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()='" + section + "']"));

		Thread.sleep(5000);

		int x = startX;
		int y = startY;

		for (String elementType : elementTypes) {
			performGlobalVariableActions(elementType, x, y);

			x += 250;
			if (x > 250) {
				x = startX;
				y += 50;
			}
		}
	}

	public void performGlobalVariableActions(String elementType, int x, int y) throws Exception {
		WebElement sourceElement = driver.findElement(By.xpath("//span[text()='" + elementType + "']"));
		WebElement targetElement = driver.findElement(By.xpath("//div[@class='form-builder']"));
		int targetX = targetElement.getLocation().getX() + x;
		int targetY = targetElement.getLocation().getY() + y;
		Actions actions = new Actions(driver);
		actions.clickAndHold(sourceElement).moveToElement(targetElement, targetX, targetY).release().build().perform();
		waitForElements();

	}

	private void waitForElements() throws Exception {
		String[] xpaths = { "//span[normalize-space()='Global Variable']",
				"(//div[@class=\"form-group\"]//input[@placeholder='Select'])[1]", "//div[@x-placement]//li[1]",
				"//button[@class='el-button el-button--primary']" };
		Thread.sleep(5000);
		for (String xpath : xpaths) {
			MethodActions.waitEle(By.xpath(xpath));
		}

	}

	public void Recipient(int id, String contactType, String email, String signerType) throws Exception {
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));
		System.out.println("Click on Add recipient done Successfully");
		String xpath = String.format("//div[@id='user_%d']//input[@placeholder='Select contact type']", id);
		MethodActions.waitEle(By.xpath(xpath));
		String con = String.format("//div[@x-placement]//ul//li[normalize-space()='%s']", contactType);
		WebElement ele = driver.findElement(By.xpath(con));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);
		System.out.println("Selected contact type Successfully");
		String xpath2 = String.format("//div[@id='user_%d']//input[@placeholder='Search with Email']", id);
		MethodActions.waitEle(By.xpath(xpath2));
		Thread.sleep(3000);
		System.out.println("click on Search with email done Successfully");
		String xpath3 = String.format("//div[@x-placement]//li[text()=\" %s \"]", email);
		MethodActions.waitEle(By.xpath(xpath3));
		String xpath4 = String.format("//div[@id='user_%d']//input[@placeholder='Select Signer Type']", id);
		MethodActions.waitEle(By.xpath(xpath4));
		Thread.sleep(3000);
		String signertype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", signerType);
		MethodActions.waitEle(By.xpath(signertype));
		System.out.println("Selected Recipients Successfully");
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save Users']"));
	}

	public void blankdoc() throws Exception {
		Thread.sleep(5000);
		driver.get("https://nsui.esigns.io/documents/upload");
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("(//img[@class='el-tooltip upload-icon'])[1]"));
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Document name']"),
				MethodActions.generateUniqueString());
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Continue']"));
	}

	public void companyProfile() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//input[@placeholder='SENDER']"));
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[2]"));

		WebElement Sign = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='signatureEle']")));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		Actions actions = new Actions(driver);
		waitAndClick(actions, Sign, Target, 90, -180);
		Thread.sleep(5000);
		String[] fields = { "Field1", "Field2", "Field3", "Field4", "Field5", "Field6", "Field7", "Field8", "Field9",
				"Field10", "Field11", "Field12", "Field13", "Field14", "Field15", "Field16", "Field17", "Field18",
				"Field19" };

		int numberOfElements = fields.length;
		String targetXPath = "//*[@id=\"svg\"]";

		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("(//div[@role='button']//i)[2]"));

		Thread.sleep(5000);
		int[][] coordinates = { { -350, -180 }, { -350, -130 }, { -350, -80 }, { -350, -30 }, { -350, 20 },
				{ -100, -180 }, { -100, -130 }, { -100, -80 }, { -100, -30 }, { -100, 20 }, { 150, -180 },
				{ 150, -130 }, { 150, -80 }, { 150, -30 }, { 150, 20 }, { 400, -180 }, { 400, -130 }, { 400, -80 },
				{ 400, -30 } };

		for (int i = 0; i < numberOfElements; i++) {
			WebElement element = driver.findElement(By.xpath("(//div[@class='name'])[" + (i + 1) + "]"));
			WebElement target = driver.findElement(By.xpath(targetXPath));

			int x = coordinates[i][0];
			int y = coordinates[i][1];

			actions.clickAndHold(element).moveToElement(target, x, y).release().build().perform();

		}
	}

	public void addrecevier() throws Exception {

		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("(//input[@type='checkbox'])[3]"));
		MethodActions.waitEle(By.xpath("//div[@class='el-select__tags']//input[1]"));
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		MethodActions.waitEle(By.xpath("//input[@placeholder='List']"));
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[1]"));
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("//span[text()='Send Document']"));

	}

	public void waitAndClick(Actions actions, WebElement sourceElement, WebElement targetElement, int xOffset,
			int yOffset) {
		actions.clickAndHold(sourceElement).moveToElement(targetElement, xOffset, yOffset).release().build().perform();

	}

}