
package Pages;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class clickWorkflow_meghana {

	static WebDriver driver;

	public clickWorkflow_meghana(WebDriver driver) {

		clickWorkflow_meghana.driver = driver;

	}

	public void sendKeysToElement(By by, CharSequence keysToSend) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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

	public static void highlight(WebElement element) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid blue;');", element);

	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public static void Loadingmask() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}

	}

	public void clickWF() throws Exception {
		Loadingmask();
		waitEle(By.xpath("//span[normalize-space()='Workflows']"));
	}

	public void VerifyclickWF() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[normalize-space()=\"All Workflows\"]")));

		Assert.assertNotNull(welcomeMessage, "workflow page not displayed");
		System.out.println("Clicked on Workflow done Successful");
	}

	public void createWFButton() throws Exception {
		waitEle(By.xpath("//span[text()=\" Create Workflow \"]"));

	}

	public void VerifycreateWFButton() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()=\"Workflow Name\"]")));

		Assert.assertNotNull(welcomeMessage, "workflow title page to enter wf related data not displayed");
		System.out.println("Clicked on Create Workflow done Successful");
	}

	public void createWF(String WorkflowName, String template1, String template2) throws Exception {

		Thread.sleep(20000);

		driver.findElement(By.xpath("//span[text()=\" Create Workflow \"]")).click();

		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {

			driver.switchTo().window(handle);

		}

		WebElement w = driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));
		w.sendKeys((WorkflowName));

		WebElement clickAllDoc = driver
				.findElement(By.xpath("//div[@class=\"dialog-footer\"]//span[contains(text(),'Confirm')]"));
		clickAllDoc.click();

		Thread.sleep(20000);
		String file = String.format("(//div[normalize-space()=\"%s\"])[2]", template1);

		Javascriptclick(By.xpath(file));

		String file2 = String.format("(//div[normalize-space()=\"%s\"])[2]", template2);
		Javascriptclick(By.xpath(file2));
		Thread.sleep(10000);
	}

	public void addTemplates(String template1, String template2) throws InterruptedException {
		Thread.sleep(10000);
		String file = String.format("//div[text()=\" %s \"]", template1);
		WebElement element = driver.findElement(By.xpath(file));
		element.click();

		String file2 = String.format("//div[text()=\" %s \"]", template2);
		WebElement element2 = driver.findElement(By.xpath(file2));
		element2.click();
		Thread.sleep(10000);
	}

	public void AddRecipient(int id, String email, String Fname, String Lname, String signerType) throws Exception {

		String xpath2 = String.format("//div[@id='user_%d']//input[@placeholder='Search with Email']", id);
		waitEle(By.xpath(xpath2));
		sendKeysToElement(By.xpath(xpath2), email);

		String xpath3 = String.format("//div[@x-placement]//span[text()='%s']", email);
		waitEle(By.xpath(xpath3));

		waitEle(By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]"));
		driver.findElement(By.xpath("//input[@placeholder=\"First name \"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"First name \"]"), Fname);
		driver.findElement(By.xpath("//input[@placeholder=\"Last name\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Last name\"]"), Lname);
		waitEle(By.xpath("//span[text()=\" Save \"]"));
		Thread.sleep(5000);
		System.out.printf("Added Recipient %s Successfully\n", email);

	}

	private boolean isElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void addRecipientLoop(String email, String firstName, String lastName, String signerType) throws Exception {
		final int MAX_RECIPIENTS = 5;
		final int WAIT_TIME_SECONDS = 1;

		for (int i = 0; i <= MAX_RECIPIENTS; i++) {
			try {
				String emailSearchXpath = String.format("//div[@id='user_%d']//input[@placeholder='Search with Email']",
						i);
				waitEle(By.xpath(emailSearchXpath));
				sendKeysToElement(By.xpath(emailSearchXpath), email);

				String emailOptionXpath = String.format("//div[@x-placement]//span[text()='%s']", email);
				waitEle(By.xpath(emailOptionXpath));

				By saveButtonXpath = By
						.xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']");

				if (isElementPresent(saveButtonXpath)) {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_SECONDS));
					WebElement saveButtonElement = wait.until(ExpectedConditions.elementToBeClickable(saveButtonXpath));
					saveButtonElement.click();

					driver.findElement(By.xpath("//input[@placeholder=\"First name \"]")).clear();
					sendKeysToElement(By.xpath("//input[@placeholder=\"First name \"]"), firstName);
					driver.findElement(By.xpath("//input[@placeholder=\"Last name\"]")).clear();
					sendKeysToElement(By.xpath("//input[@placeholder=\"Last name\"]"), lastName);

					waitEle(By.xpath("//span[text()=' Save ']"));
					Thread.sleep(5000);
					System.out.printf("Added Recipient %s Successfully\n", email);
				} else {
					continue;
				}
			} catch (Exception e) {
				System.err.printf("Failed to find email input for user_%d: %s\n", i, e.getMessage());
				break;
			}
		}
	}

	public void nextButtonAfterAddingRecipientInTemp() throws Exception {
		waitEle(By.xpath("//span[normalize-space()=\"Next\"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//button[@class='el-button doc-send-button el-button--danger']"));
	}

	// Check Status
	public void status(String statusSelect) throws Exception {
		Thread.sleep(10000);
		WebElement status = driver.findElement(By.xpath("//input[@placeholder=\"Select Status\"]"));

		status.click();
		String activeOrInactive = String.format("//span[normalize-space()=\"%s\"]", statusSelect);
		Javascriptclick(By.xpath(activeOrInactive));

	}

	// Search

	public void search(String WFName) {
		try {
			WebElement search = driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));
			search.click();
			search.sendKeys(WFName);
			Thread.sleep(2000);

			boolean found = false;
			for (int i = 1; i <= 10; i++) {
				String xpath = String.format(
						"//div[@class=\"el-table__body-wrapper is-scrolling-none\"]//tr[%d]//td[1]//span[1]//span//p[contains(text(),\"%s\")]",
						i, WFName);
				By row = By.xpath(xpath);
				if (isElementPresent(row)) {
					System.out.println("Found at row: " + i);
					found = true;

				} else {
					break;
				}
			}

			if (!found) {
				throw new AssertionError("Search did not find any matching element");
			}
		} catch (Exception e) {
			throw new RuntimeException("An error occurred during the search: " + e.getMessage());
		}
	}

	public void actions(String WFName, String action) throws Exception {

		String xpath = String.format(
				"(//div[@class=\"el-table__body-wrapper is-scrolling-none\"]//table//tr[1]//button[contains(@class,'el-button el-dropdown-link')]//span)[1]",
				WFName);

		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(xpath));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);
		String actionType = String.format("//ul[@x-placement] //li[normalize-space()='%s']", action);
		Javascriptclick(By.xpath(actionType));

	}

	// Actions

	// Edit

	public void actionEdit() throws Exception {

		Thread.sleep(10000);

		WebElement elementToDoubleClick = driver
				.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"));

		Actions actions1 = new Actions(driver);

		actions1.doubleClick(elementToDoubleClick).perform();

		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).sendKeys("Meghana");

		driver.findElement(By.xpath("//span[normalize-space()='Save Workflow']")).click();

	}

	// Rename

	public void actionRename() throws Exception {

		WebElement elementToDoubleClick = driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));

		Actions actions2 = new Actions(driver);

		actions2.doubleClick(elementToDoubleClick).perform();

		driver.findElement(By.xpath("//input[@placeholder=\"Title\"]")).sendKeys("WFRename");

		waitEle(By.xpath("//span[text()=\"Confirm\"]"));

	}

	// View Workflow Data

	public void actionViewData() throws Exception {

		WebElement elementToHover = driver.findElement(By.xpath("//div[3]/table/tbody/tr[1]/td[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='View Workflow Data']"))
				.click();

		Thread.sleep(10000);

	}

	// Inactive

	public void actionInactive() throws Exception {

		WebElement elementToHover = driver.findElement(By.xpath("//input[@placeholder=\"Select Status\"]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//ul[@x-placement] //li[normalize-space()='Inactive']")).click();

		Thread.sleep(10000);

	}

	// Preview click add data and send

	public void previewWF() throws Exception {

		Thread.sleep(10000);

		By Element = By.xpath("//span[normalize-space()='Workflows']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));

		canc.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//span[text()=\" Create Workflow \"]")).click();

		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {

			driver.switchTo().window(handle);

		}

		Thread.sleep(10000);

		WebElement w = driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));

		highlight(w);

		w.sendKeys(("TestingWF"));

		Thread.sleep(10000);

		WebElement clickAllDoc = driver
				.findElement(By.xpath("//div[@aria-label='Workflow Name']//span[contains(text(),'Confirm')]"));

		highlight(clickAllDoc);

		clickAllDoc.click();

		Thread.sleep(10000);

		WebElement file = driver.findElement(By.xpath("//div[text()=\" Payslip Nov 202 \"]"));

		highlight(file);

		file.click();

		Thread.sleep(10000);

		WebElement file2 = driver.findElement(By.xpath("//div[text()=\" Evaluation form (1) \"]"));

		highlight(file2);

		file2.click();

		Thread.sleep(10000);

		WebElement save = driver.findElement(By.xpath("//span[normalize-space()='Save & send']"));

		highlight(save);

		save.click();

		Thread.sleep(10000);

		WebElement next = driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]"));

		highlight(next);

		next.click();

		Thread.sleep(10000);

		WebElement prev = driver.findElement(By.xpath("//span[normalize-space()=\"Prev\"]"));

		highlight(prev);

		prev.click();

		Thread.sleep(10000);

		WebElement feild1 = driver
				.findElement(By.xpath("//input[@class=\"el-input__inner\"][@placeholder=\"Enter Template Title\"]"));

		highlight(feild1);

		feild1.sendKeys("N180894");

		Thread.sleep(10000);

		WebElement send = driver
				.findElement(By.xpath("//button[@class='el-button doc-send-button el-button--danger']"));

		highlight(send);

		send.click();

	}

	// Add group while creating workflow and check in groups module

	public void addGroup() throws Exception {

		Thread.sleep(10000);

		By Element = By.xpath("//span[normalize-space()='Workflows']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));

		canc.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//span[text()=\" Create Workflow \"]")).click();

		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {

			driver.switchTo().window(handle);

		}

		Thread.sleep(10000);

		WebElement w = driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));

		highlight(w);

		w.sendKeys(("TestingAdGroup"));

		Thread.sleep(10000);

		WebElement Group = driver.findElement(By.xpath("//i[@class=\"el-tooltip el-icon-circle-plus-outline\"]"));

		highlight(Group);

		Group.click();

		Thread.sleep(10000);

		WebElement groupTitle = driver.findElement(By.xpath("//input[@placeholder=\"Enter Title\"]"));

		highlight(groupTitle);

		groupTitle.sendKeys("testing1");

		Thread.sleep(10000);

		WebElement clickOnSave = driver.findElement(By.xpath("//i[@class='el-icon-check']"));

		highlight(clickOnSave);

		clickOnSave.click();

		Thread.sleep(10000);

		WebElement clickAllDoc = driver
				.findElement(By.xpath("//div[@aria-label='Workflow Name']//span[contains(text(),'Confirm')]"));

		highlight(clickAllDoc);

		clickAllDoc.click();

		Thread.sleep(10000);

		WebElement file = driver.findElement(By.xpath("//div[text()=\" Payslip Nov 202 \"]"));

		highlight(file);

		file.click();

		Thread.sleep(10000);

		WebElement file2 = driver.findElement(By.xpath("//div[text()=\" Evaluation form (1) \"]"));

		highlight(file2);

		file2.click();

		Thread.sleep(10000);

		WebElement save = driver.findElement(By.xpath("//span[normalize-space()='Save & send']"));

		highlight(save);

		save.click();

		Thread.sleep(10000);

		WebElement next = driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]"));

		highlight(next);

		next.click();

		Thread.sleep(10000);

		WebElement next1 = driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]"));

		highlight(next1);

		next1.click();

		WebElement send = driver
				.findElement(By.xpath("//button[@class='el-button doc-send-button el-button--danger']"));

		highlight(send);

		send.click();

	}

	// test enforce while adding multiple contacts

	public void enforce() throws Exception {

		By Element = By.xpath("//span[normalize-space()='Workflows']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));

		canc.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//span[text()=\" Create Workflow \"]")).click();

		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {

			driver.switchTo().window(handle);

		}

		Thread.sleep(10000);

		WebElement w = driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));

		highlight(w);

		w.sendKeys(("enforce"));

		Thread.sleep(10000);

		WebElement clickAllDoc = driver
				.findElement(By.xpath("//div[@aria-label='Workflow Name']//span[contains(text(),'Confirm')]"));

		highlight(clickAllDoc);

		clickAllDoc.click();

		Thread.sleep(10000);

		WebElement file = driver.findElement(By.xpath("//div[text()=\" Payslip Nov 202 \"]"));

		highlight(file);

		file.click();

		Thread.sleep(10000);

		WebElement file2 = driver.findElement(By.xpath("//div[text()=\" Evaluation form (1) \"]"));

		highlight(file2);

		file2.click();

		Thread.sleep(10000);

		WebElement save = driver.findElement(By.xpath("//span[normalize-space()='Save & send']"));

		highlight(save);

		save.click();

		Thread.sleep(10000);

		WebElement cont1 = driver
				.findElement(By.xpath("//div[@id=\"user_1\"]//input[@placeholder='Search with Email']"));

		highlight(cont1);

		cont1.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]")).click();

		WebElement cont2 = driver
				.findElement(By.xpath("//div[@id=\"user_2\"]//input[@placeholder='Search with Email']"));

		highlight(cont2);

		cont2.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@x-placement=\"bottom-start\"]//li[3]")).click();

		WebElement cont3 = driver
				.findElement(By.xpath("//div[@id=\"user_3\"]//input[@placeholder='Search with Email']"));

		highlight(cont3);

		cont3.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@x-placement=\"top-start\"]//li[5]")).click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//span[normalize-space()=\"Enforce Workflow Order\"]")).click();

		Thread.sleep(10000);

		WebElement next = driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]"));

		highlight(next);

		next.click();

		Thread.sleep(10000);

		WebElement prev = driver.findElement(By.xpath("//span[normalize-space()=\"Prev\"]"));

		highlight(prev);

		prev.click();

		Thread.sleep(10000);

		WebElement send = driver
				.findElement(By.xpath("//button[@class='el-button doc-send-button el-button--danger']"));

		highlight(send);

		send.click();

	}

	// Primary Users

	public void primaryUser() throws Exception {

		Thread.sleep(10000);

		By Element = By.xpath("//span[normalize-space()='Workflows']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));

		canc.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//span[text()=\" Create Workflow \"]")).click();

		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {

			driver.switchTo().window(handle);

		}

		Thread.sleep(10000);

		WebElement w = driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));

		highlight(w);

		w.sendKeys(("Testing"));

		Thread.sleep(10000);

		WebElement clickAllDoc = driver
				.findElement(By.xpath("//div[@aria-label='Workflow Name']//span[contains(text(),'Confirm')]"));

		highlight(clickAllDoc);

		clickAllDoc.click();

		Thread.sleep(10000);

		WebElement file = driver.findElement(By.xpath("//div[text()=\" PERMANENT ADDRESS_N180894 \"]"));

		highlight(file);

		file.click();

		Thread.sleep(10000);

		WebElement file2 = driver.findElement(By.xpath("//div[text()=\" address \"]"));

		highlight(file2);

		file2.click();

		Thread.sleep(10000);

		WebElement file3 = driver.findElement(By.xpath("//div[text()=\" practice \"]"));

		highlight(file3);

		file3.click();

		Thread.sleep(10000);

		WebElement save = driver.findElement(By.xpath("//span[normalize-space()='Save & send']"));

		highlight(save);

		save.click();

		Thread.sleep(10000);

		WebElement cont1 = driver
				.findElement(By.xpath("//div[@id=\"user_0\"]//input[@placeholder='Search with Email']"));

		highlight(cont1);

		cont1.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]")).click();

		WebElement cont2 = driver
				.findElement(By.xpath("//div[@id=\"user_1\"]//input[@placeholder='Search with Email']"));

		highlight(cont2);

		cont2.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]")).click();

		WebElement cont3 = driver
				.findElement(By.xpath("//div[@id=\"user_2\"]//input[@placeholder='Search with Email']"));

		highlight(cont3);

		cont3.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]")).click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("(//div[@id=\"user_1\"]//label)[1]")).click();

		Thread.sleep(10000);

		WebElement next = driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]"));

		highlight(next);

		next.click();

		Thread.sleep(10000);

		WebElement next1 = driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]"));

		highlight(next1);

		next1.click();

		WebElement send = driver
				.findElement(By.xpath("//button[@class='el-button doc-send-button el-button--danger']"));

		highlight(send);

		send.click();

	}

	public void saveAndSend() throws Exception {
		waitEle(By.xpath("//span[text()=\" Save & send \"]"));

	}

	public void sendWorkflow() throws Exception {
		waitEle(By.xpath("(//button[@class=\"el-button px-2 el-button--danger el-button--mini is-plain\"])[1]"));
	}

	public void verifySendWorkflow() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"flow-top-bar\"]")));

		Assert.assertNotNull(welcomeMessage, "workflow User page not displayed");
		System.out.println("Clicked on Send Workflow done Successful");
	}

	public void buildPage() throws Exception {
		Thread.sleep(20000);
//
//		WebElement elementToHover = driver.findElement(By.xpath(
//				"(//div[@class=\"icon-text\"]//span[@class=\"el-popover__reference-wrapper\"])[1]"));
//
//		Actions actions = new Actions(driver);
//
//		actions.moveToElement(elementToHover).perform();
//		Thread.sleep(10000);
		Javascriptclick(By.xpath("//div[@class='el-table__fixed']//tr[1]/td[1]//span[1]/span/p"));
	}

	public void verifybuildPageInWorkflow() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"workflow-steps\"]")));

		Assert.assertNotNull(welcomeMessage, "workflow build page not displayed");
		System.out.println("Clicked on doc name in Workflow done Successful to show build page");
	}

	public void verifyViewWFData() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class=\"el-table__fixed-header-wrapper\"]")));

		Assert.assertNotNull(welcomeMessage, "workflow View data page not displayed");
		System.out.println("Clicked on ViewWF in Workflow Actions done Successful to show build page");
	}

	public void verifyViewWFDataSearch() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//table[@class=\"el-table__body\"])[1]")));

		Assert.assertNotNull(welcomeMessage, "workflow search data with WF name data page not displayed");
		System.out.println("search of WF data in WF view data displayed successfully");
	}

	public void sendWF() throws Exception {
		waitEle(By.xpath("//span[text()=\"Send Workflow\"]"));
	}

	public void back() throws Exception {
		Thread.sleep(20000);
		Javascriptclick(By.xpath("(//span[normalize-space()='Back'])[1]"));
		System.out.println("Click on back button done successfully");
	}

	public void back2() throws Exception {
		Thread.sleep(20000);
		Javascriptclick(By.xpath("(//span[normalize-space()='Back'])[2]"));
		System.out.println("Click on back button done successfully");
	}

	public void deleteSuccessNotification() throws Exception {
		waitEle(By.xpath("//p[text()=\"Workflow Document Permanently Deleted Successfully\"]"));
	}

	public void checkboxInHeader() throws Exception {
		waitEle(By.xpath("//div[@class=\"el-table__fixed-header-wrapper\"]//span[@class=\"el-checkbox__inner\"]"));

	}

	public void bulkDelete() throws Exception {
		waitEle(By.xpath("//button[@title='Delete']"));
	}

	public void WFResponseDraft() throws Exception {

		boolean isElementFound = false;
		while (!isElementFound) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
						By.xpath("(//span[@class=\"mr-1 el-tag el-tag--mini el-tag--light\"]//span[text()=1])[1]")));
				element.click();
				isElementFound = true;
				System.out.println("Element found!");

			} catch (Exception e) {
				try {
					WebElement nextButton = driver
							.findElement(By.xpath("//*[@id='MainLayout']//button[@class='btn-next']"));
					nextButton.click();
					System.out.println("Element not found, clicking Next.");
					Thread.sleep(2000);

				} catch (Exception nextButtonException) {
					System.out.println("Next button not found or failed to click it.");
					throw nextButtonException;
				}
			}
		}
	}

	public void WFResponseInProgress() throws Exception {
		boolean isElementFound = false;
		while (!isElementFound) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"(//span[@class='mr-1 el-tag el-tag--warning el-tag--mini el-tag--light']//span[text()=1])[1]")));
				element.click();
				isElementFound = true;
				System.out.println("Element found!");

			} catch (Exception e) {
				try {
					WebElement nextButton = driver
							.findElement(By.xpath("//*[@id='MainLayout']//button[@class='btn-next']"));
					nextButton.click();
					System.out.println("Element not found, clicking Next.");
					Thread.sleep(2000);

				} catch (Exception nextButtonException) {
					System.out.println("Next button not found or failed to click it.");
					throw nextButtonException;
				}
			}
		}
	}

	public void WFResponseCompleted() throws Exception {

		boolean isElementFound = false;
		while (!isElementFound) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
						"(//span[@class=\"el-tag el-tag--success el-tag--mini el-tag--light\"]//span[text()=1])[1]")));
				element.click();
				isElementFound = true;
				System.out.println("Element found!");

			} catch (Exception e) {
				try {
					WebElement nextButton = driver
							.findElement(By.xpath("//*[@id='MainLayout']//button[@class='btn-next']"));
					nextButton.click();
					System.out.println("Element not found, clicking Next.");
					Thread.sleep(2000);

				} catch (Exception nextButtonException) {
					System.out.println("Next button not found or failed to click it.");
					throw nextButtonException;
				}
			}
		}
	}

	public void action(int n) throws Exception {
		Thread.sleep(10000);

		WebElement elementToHover = driver.findElement(By.xpath("(//span[contains(text(),'Actions')])[1]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();

		String xpath = String.format("//ul[@x-placement]//a[%d]", n);
		Javascriptclick(By.xpath(xpath));
		try {
			By ele = By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
			WebElement c = wait.until(ExpectedConditions.elementToBeClickable(ele));
			c.click();
		} catch (Exception e) {

		}

	}

	public void resendSuccessNotification() throws Exception {
		waitEle(By.xpath("//p[text()=\"Workflow resent successfully\"]"));
	}

	public void viewWorkflow() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("(//span[contains(text(),'Actions')])[1]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(5000);
		Javascriptclick(By.xpath("//div[@class=\"el-table__body-wrapper is-scrolling-none\"]//li[1]/button[1]"));
		System.out.println("Click on view Workflow done successfully");
	}

	public void verifyViewWF() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class=\"el-dialog__header\"]//span[text()=\"Documents\"]")));

		Assert.assertNotNull(welcomeMessage, "workflow documents not displayed");
		System.out.println("workflow documents displayed successfully");
	}

	public void popUpAction(int n) throws Exception {
		String xpath = String.format(
				"(//tr[@class=\"el-table__row\"]//button[@class=\"el-button el-button--default el-button--mini\"])[%d]",
				n);
		Javascriptclick(By.xpath(xpath));

	}

	public void viewWorkflowActions(int n) throws Exception {
		waitEle(By.xpath("(//img[@role=\"button\"])[1]"));
		String select = String.format("//ul[@x-placement]//a[%d]", n);
		waitEle(By.xpath(select));
		Thread.sleep(10000);

	}

//	public void deleteWF() throws Exception {
//		waitEle(By.xpath("//span[text()=\"Delete Workflow\"]"));
//	}

	public void verifyActionHistory(String s) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		String ss = String.format("//div[@class=\"el-dialog__header\"]//span[text()=\"%s\"]", s);
		WebElement welcomeMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ss)));

		Assert.assertNotNull(welcomeMessage, "workflow documents history not displayed");
		System.out.println("workflow documents history displayed successfully");
	}

//	public void downloadHistory() throws Exception {
//		waitEle(By.xpath("//span[text()=\"Download History\"]"));
//	}

//	public void yesButton() throws Exception {
//		waitEle(By.xpath("//span[normalize-space()=\"Yes\"]"));
//	}

	public void VerifycorrectDoc() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@id=\"drag-template-background\"]")));

		Assert.assertNotNull(welcomeMessage, "Correct Document click unsuccessful");
		System.out.println("Correct Document click done successfully");
	}

	public void WFTempAddActions(int n) throws Exception {
		String Action = String
				.format("(//button[@class=\"el-button setting-btn el-button--Primary el-button--mini\"])[%d]", n);
		waitEle(By.xpath(Action));
	}

	public void VerifyTempSettings() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class=\"dialog-header\"]//h2[text()=\"Document Expiration & Reminders\"]")));

		Assert.assertNotNull(welcomeMessage, "Setting Display unsuccessful");
		System.out.println("Setting Display done successfully");
	}

	public void deleteTempInWF() throws Exception {
		waitEle(By.xpath("(//button[@class=\"el-button delete-btn el-button--danger el-button--mini\"])[1]"));
	}

	public void rename() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"), "WF");
		System.out.println("Rename done successfully");
	}

//	public void enforceWF() throws Exception {
//		waitEle(By.xpath("//span[normalize-space()=\"Enforce Workflow Order\"]"));
//	}

	public void SelectDocAfterWFsend(int n) throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@class=\"inner-navbar\"]//input[@placeholder=\"Select\"]"));
		String s = String.format("//div[@x-placement]//ul//li[%d]", n);
		Javascriptclick(By.xpath(s));
	}

	public void VerifyTC33(String temp) throws Exception {
		String path = String.format("//div[@style=\"color: rgb(64, 158, 255);\"]//h4[text()=\" %s\"]", temp);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));

		Assert.assertNotNull(welcomeMessage, "navigation unsuccessful");
		System.out.println("navigation done successfully");
	}

	public void SpanButton(String s) throws Exception {
		Thread.sleep(5000);
		try {
			String span = String.format("//span[normalize-space()=\"%s\"]", s);
			By ele = By.xpath(span);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
			WebElement c = wait.until(ExpectedConditions.elementToBeClickable(ele));
			c.click();
			System.out.println("Click on %d done Successfully");
		} catch (Exception e) {

		}
	}

	public void verifyPreviewNextButton(String temp) {
		String path = String.format("//h3[normalize-space()=\"%s\"]", temp);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(path)));

		Assert.assertNotNull(welcomeMessage, "navigation unsuccessful");
		System.out.println("navigation done successfully");
	}

	public void WorkflowDocumentsettings() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		Thread.sleep(1000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Settings']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();",
				element);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(5000);
		waitEle(By.xpath("(//span[normalize-space()='Secure E-Sign'])[1]"));
		Thread.sleep(1000);

		WebElement element2 = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@class='dialog-footer']//span[normalize-space()='Save']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); arguments[0].click();",
				element2);
		Thread.sleep(20000);

	}

	public void SignatureAuthentication() throws Exception {
		try {
			Thread.sleep(5000);
			waitEle(By.xpath("//span[text()=' Send Otp To Email ']"));
			driver.switchTo().newWindow(WindowType.TAB);
		} catch (Exception e) {

		}

	}

	public void OtpAuthentication() throws Exception {
		Thread.sleep(10000);
		WebElement copy = driver.findElement(By.xpath("//td[@class=\"x_featured-story__copy\"]"));

		Actions action2 = new Actions(driver);
		action2.doubleClick(copy).build().perform();
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.moveToElement(copy).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
		Thread.sleep(10000);
		String Parentwindowid1 = driver.getWindowHandle();

		Thread.sleep(10000);
		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);

				Thread.sleep(10000);
				waitEle(By.xpath("//input[@phalceholder=\"Enter Verificaiton code\"]"));
				WebElement paste = driver.findElement(By.xpath("//input[@phalceholder=\"Enter Verificaiton code\"]"));

				actions.moveToElement(paste).keyDown(Keys.CONTROL) // Press Ctrl key
						.sendKeys("v") // Press v key
						.keyUp(Keys.CONTROL) // Release Ctrl key
						.build().perform();
				waitEle(By.xpath("//span[text()='Verify & Save Signature']"));
				System.out.println("Entered OTP successfully");
			}
		}
	}

	public void ClickSignatureFeild() throws Exception {
		Thread.sleep(10000);
		Javascriptclick(By.xpath("//button[text()=\" Signature \"]"));
	}

	public void closeChildWindow() throws InterruptedException {
		String Parentwindowid1 = driver.getWindowHandle();
		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow).close();
				driver.switchTo().window(Parentwindowid1);
			}
		}
	}

}
