package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TemplateScenarios {
	WebDriver driver;
	MethodActions methodActions;

	public TemplateScenarios(WebDriver driver) {
		this.driver = driver;
		methodActions = new MethodActions(driver);

	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void switchToNewWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
	}

	public void sendKeysToElement(By by, CharSequence keysToSend) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(keysToSend);
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

	public void Creatempwithautofill() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitEle(By
				.xpath("//button[@class='el-button create-btn px-4 ml-2 scaling-button el-button--primary is-plain']"));
		waitEle(By.xpath("//span[normalize-space()='Blank template']"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);

		}
		By template = By.xpath("//input[@placeholder='Enter template name']");
		WebElement templatename = wait.until(ExpectedConditions.elementToBeClickable(template));
		templatename.sendKeys("Test");

		waitEle(By.xpath("//span[normalize-space()='Continue']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select Contact type']"));
		waitEle(By.xpath("//div[@x-placement='bottom-start']//li[2]"));
		waitEle(By.xpath("//span[normalize-space()='Add']"));
		waitEle(By.xpath("//span[normalize-space()='Save Users']"));

	}

	public void Creatdoc() throws Exception {
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By overlayLocator = By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			System.out.println("Overlay not found or not invisible.");
		}

		waitEle(By.xpath("//span[normalize-space()='Create Document']"));

		try {
			Thread.sleep(10000);
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));

		} catch (Exception e) {

			System.out.println("Overlay not found or not invisible.");
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Send Document']"));
	}

	public void AddRecipients() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
		System.out.println("Selected Recipients Successfully");

	}

	public void CreatingNewContactDocument() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[3]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[3]//ul/li[2]"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		WebElement subMenuItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[2]"));
		actions.click(subMenuItem).perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Create Contact']"));

		By adn = By.xpath("(//div[@class='el-input']//input)[1]");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement addnew = hold.until(ExpectedConditions.elementToBeClickable(adn));
		addnew.sendKeys("Unique");
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='el-input']//input)[2]")).sendKeys("User");
		Thread.sleep(10000);

		String uniqueEmail = MethodActions.generateUniqueEmail();
		driver.findElement(By.xpath("(//div[@class='el-input']//input)[3]")).sendKeys(uniqueEmail);

		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='el-input']//input)[7]")).sendKeys("HGT");
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Save Contact']"));
	}

	public void SendtoConatct() throws Exception {

		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[3]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[3]//ul/li[2]"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		WebElement subMenuItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[2]"));
		actions.click(subMenuItem).perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("(//div[@class='el-scrollbar']//span//span)[2]"));
		waitEle(By.xpath("//div[@aria-label='Send to selected contact type']//button[2]"));
		waitEle(By.xpath(
				"//div[@aria-label='Confirmation Alert']//div[@class='el-dialog__footer']//span[contains(text(),'Confirm')]"));

	}

	public void Bulksend() throws Exception {

		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[4]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[3]//ul/li[2]"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		WebElement subMenuItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[3]"));
		actions.click(subMenuItem).perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		waitEle(By.xpath("(//div[@role='button'])[1]"));
		waitEle(By.xpath("(//div[@role='button'])[2]"));
		waitEle(By.xpath("(//div[@role='button'])[2]"));
		waitEle(By.xpath("//button//span[normalize-space()='Download Blank CSV']"));
		waitEle(By.xpath("(//div[@role='button'])[1]"));
		waitEle(By.xpath("//button//span[normalize-space()='Continue']"));
		waitEle(By.xpath("//div//p[normalize-space()='Drag & Drop CSV file here']"));
		Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\excel.exe\"");

		waitEle(By.id("tab-error"));

		waitEle(By.id("tab-success"));

		waitEle(By.xpath("//button//span[normalize-space()='Continue']"));

		waitEle(By.xpath("//span[normalize-space()='Send documents']"));

	}

	public void GetlinkaccessToall() throws Exception {

		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[4]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[3]//ul/li[2]"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		WebElement subMenuItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[4]"));
		actions.click(subMenuItem).perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		waitEle(By.xpath("(//div[@class='link-main']//span[@class='el-checkbox__inner'])[1]"));

		waitEle(By.xpath("//span[normalize-space()='Publish']"));

	}

	public void ObserveStatofTheTemplate() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[3]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		waitEle(By.xpath(
				"//div[@class='el-table__fixed-right']//tr[3]//td[7]//span[@class='mr-1 el-tag el-tag--mini el-tag--light']"));
		waitEle(By.xpath("(//i[@class='el-dialog__close el-icon el-icon-close'])[9]"));
		Thread.sleep(10000);
		WebElement elementToHover1 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[3]"));

		Actions actions1 = new Actions(driver);

		actions1.moveToElement(elementToHover1).perform();
		Thread.sleep(10000);
		waitEle(By.xpath(
				"//div[@class='el-table__fixed-right']//tr[3]//td[7]//span[@class='mr-1 el-tag el-tag--warning el-tag--mini el-tag--light']"));

		String parentWindowHandle = driver.getWindowHandle();
		waitEle(By.xpath("//div[@class='el-dialog__body']//tr[1]//button[1]"));
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String handle : allWindowHandles) {
			if (!handle.equals(parentWindowHandle)) {

				driver.switchTo().window(handle);
				Thread.sleep(10000);
				driver.close();
				driver.switchTo().window(parentWindowHandle);
				waitEle(By.xpath("(//i[@class='el-dialog__close el-icon el-icon-close'])[9]"));
				Thread.sleep(10000);
				WebElement elementToHover11 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[3]"));

				Actions actions11 = new Actions(driver);

				actions11.moveToElement(elementToHover11).perform();
				Thread.sleep(10000);
				waitEle(By.xpath(
						"//div[@class='el-table__fixed-right']//tr[3]//td[7]//span[@class='el-tag el-tag--success el-tag--mini el-tag--light']"));

			}
		}
	}

	public void ShareWithNew() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[4]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[3]//ul/li[2]"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		WebElement subMenuItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[6]"));
		actions.click(subMenuItem).perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		WebElement element = driver
				.findElement(By.xpath("(//div[@id='pane-contacts']//span[@class='el-checkbox__inner'])[9]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@class='el-dialog__footer']//span[normalize-space()='Share']"));
	}

	public void ChangeOwner() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[4]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[3]//ul/li[2]"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		WebElement subMenuItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[8]"));
		actions.click(subMenuItem).perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);

		}
		Thread.sleep(10000);

		waitEle(By.xpath("//span[@class='el-radio__inner']"));

		waitEle(By.xpath("//span[normalize-space()='Change']"));

	}

	public void Viewdata() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement elementToHover1 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[4]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover1).perform();

		By elementToHover2Locator = By.xpath("//div[@class='el-table__fixed']//tr[3]//ul/li[2]");
		WebElement elementToHover2 = wait.until(ExpectedConditions.presenceOfElementLocated(elementToHover2Locator));

		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).perform();

		By subMenuItemLocator = By.xpath("//ul[@x-placement='bottom-end']//a[9]");
		WebElement subMenuItem = wait.until(ExpectedConditions.elementToBeClickable(subMenuItemLocator));

		actions.click(subMenuItem).perform();

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		waitEle(By.xpath(
				"//label[@class='el-checkbox el-tooltip checkbox mb-2 mr-2']//span[@class='el-checkbox__input']"));

		waitEle(By.xpath("//span[normalize-space()='Download CSV']"));

	}

	public void EditTheTemplate() throws Exception {

		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//ul/li[2]"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		WebElement subMenuItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[1]"));
		actions.click(subMenuItem).perform();

		By Select = By.xpath("//div[@class='el-scrollbar__view']//input[@placeholder='Select a Recipient']");
		WebElement Selectrec = wait.until(ExpectedConditions.elementToBeClickable(Select));

		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", Selectrec);
		Thread.sleep(10000);
		By Selectd = By.xpath("//div[@class='el-scrollbar']//ul//li[2]");

		WebElement Selectdrec = wait.until(ExpectedConditions.elementToBeClickable(Selectd));
		Selectdrec.click();

		WebElement Company = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='companyEle']")));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		Actions actions3 = new Actions(driver);
		actions3.clickAndHold(Company).moveToElement(Target).release().build().perform();
		By Crea = By.xpath("//span[text()='Create Document']");
		WebElement CreaDoc = wait.until(ExpectedConditions.elementToBeClickable(Crea));
		CreaDoc.click();

		try {
			By clo = By.xpath("//div[@class='el-notification__closeBtn el-icon-close']");
			WebElement close = wait.until(ExpectedConditions.elementToBeClickable(clo));
			close.click();

		} catch (Exception e) {
			By Send = By.xpath("//span[text()='Save Draft']");
			WebElement Senddoc = wait.until(ExpectedConditions.elementToBeClickable(Send));
			Senddoc.click();
			JavascriptExecutor executor2 = (JavascriptExecutor) driver;
			executor2.executeScript("arguments[0].click();", Senddoc);
			System.out.println("senddoc clicked using JS.");
		}

	}

	public void DuplicateTemplate() throws Exception {
		Thread.sleep(10000);

		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement((WebElement) elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[3]//ul/li[2]"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		WebElement subMenuItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[10]"));
		actions.click(subMenuItem).perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);

		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='Title']")).sendKeys("DuplicateTemplate");

		waitEle(By.xpath("(//span[text()='Confirm'])[3]"));

	}

	public void RenameTemplate() throws Exception {
		Thread.sleep(10000);

		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement((WebElement) elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[3]//ul/li[2]"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		WebElement subMenuItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[10]"));
		actions.click(subMenuItem).perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);

		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='Title']")).sendKeys("Renaming-SampleTemplate");
		Thread.sleep(10000);
		waitEle(By.xpath("(//span[text()='Confirm'])[3]"));
	}

	public void inactive() throws Exception {
		Thread.sleep(10000);

		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement((WebElement) elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[3]//ul/li[2]"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		WebElement subMenuItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[12]"));
		actions.click(subMenuItem).perform();

	}

	public void PDFfilling() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		waitEle(By
				.xpath("//button[@class='el-button create-btn px-4 ml-2 scaling-button el-button--primary is-plain']"));
		waitEle(By.xpath("//h4[@class='fw-normal blue pb-2']"));

		Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\Pdffilling.exe\"");

		Thread.sleep(10000);
		waitEle(By.xpath("//button[@class='el-button text-center upload-btn el-button--danger']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select Contact type']"));
		waitEle(By.xpath("//div[@x-placement='bottom-start']//li[2]"));
		waitEle(By.xpath("//span[normalize-space()='Add']"));
		waitEle(By.xpath("//span[normalize-space()='Save Users']"));
		Thread.sleep(10000);

		WebElement element = driver.findElement(By.xpath("//span[normalize-space()='Add fields']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(10000);
		try {
			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait1.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}
		Thread.sleep(10000);

		By value = By.xpath("//div[@data-text='SINGLE_LINE_TEXT5']");
		WebElement value1 = wait.until(ExpectedConditions.elementToBeClickable(value));
		value1.click();
		JavascriptExecutor executor2 = (JavascriptExecutor) driver;
		executor2.executeScript("arguments[0].click();", value1);

		Thread.sleep(10000);

		WebElement value11 = wait.until(ExpectedConditions.elementToBeClickable(value));
		value11.click();
		JavascriptExecutor executor3 = (JavascriptExecutor) driver;
		executor3.executeScript("arguments[0].click();", value11);

		sendKeysToElement(value, "Test");

//		try {
//			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
//		} catch (Exception e) {
//
//		}
//		Thread.sleep(10000);
//		switchToNewWindow();
//
//		WebElement value = driver.findElement(By.xpath("(//form//div[@class='el-input'])[3]"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", value);
//
//		WebDriverWait waitvalue = new WebDriverWait(driver, Duration.ofSeconds(150));
//		waitvalue.until(ExpectedConditions.elementToBeClickable(value));
//
//		value.sendKeys("Test");
//
////		WebElement value = driver.findElement(By.xpath("(//form//div[@class='el-input'])[3]"));
////		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", value);
////		Thread.sleep(10000);
////		value.sendKeys("Test");
//		waitEle(By.xpath("//div[@aria-label='Field Properties']//span[contains(text(),'Save')]"));
//
//		Thread.sleep(10000);
//		try {
//			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
//			WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofMinutes(1));
//			wait11.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
//		} catch (Exception e) {
//
//		}
//		Thread.sleep(10000);
//		WebElement element1 = driver.findElement(By.xpath("//div[@data-text='SINGLE_LINE_TEXT3']"));
//		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
//		executor1.executeScript(
//				"arguments[0].dispatchEvent(new MouseEvent('dblclick', { bubbles: true, cancelable: true }));",
//				element1);
//
//		switchToNewWindow();
//		try {
//			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
//		} catch (Exception e) {
//
//		}
//		Thread.sleep(10000);
//
//		WebElement value1 = driver.findElement(By.xpath("(//form//div[@class='el-input'])[3]"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", value);
//		Thread.sleep(10000);
//		value.sendKeys("Rjy");
//		waitEle(By.xpath("//div[@aria-label='Field Properties']//span[contains(text(),'Save')]"));
//
//		Thread.sleep(10000);
//		try {
//			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
//			WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofMinutes(1));
//			wait11.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
//		} catch (Exception e) {
//
//		}
//		Thread.sleep(10000);
//		WebElement elementsin = driver.findElement(By.xpath("//div[@data-text='SINGLE_LINE_TEXT4']"));
//		JavascriptExecutor executor11 = (JavascriptExecutor) driver;
//		executor11.executeScript(
//				"arguments[0].dispatchEvent(new MouseEvent('dblclick', { bubbles: true, cancelable: true }));",
//				elementsin);
//
//		switchToNewWindow();
//		try {
//			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
//		} catch (Exception e) {
//
//		}
//		Thread.sleep(10000);
//
//		WebElement value11 = driver.findElement(By.xpath("(//form//div[@class='el-input'])[3]"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", value);
//		Thread.sleep(10000);
//		value11.sendKeys("533101");
//
//		waitEle(By.xpath("//div[@aria-label='Field Properties']//span[contains(text(),'Save')]"));
//
//		Thread.sleep(10000);
//
//		WebElement elementche = driver.findElement(By.xpath("//div[@data-text='Checkbox 3']"));
//		JavascriptExecutor executorch = (JavascriptExecutor) driver;
//		executorch.executeScript("arguments[0].click();", elementche);

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));

		// fullNameEle
		WebElement fullName = driver.findElement(By.xpath("//button[@id='fullNameEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		Actions actions = new Actions(driver);
		waitAndClick(actions, fullName, Target);
		System.out.println("Fullname Element Drag and Drop Done");
		waitEle(By.xpath("//span[normalize-space()='Create Document']"));
	}

}
