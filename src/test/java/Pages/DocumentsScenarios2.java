package Pages;

import java.io.File;
import java.time.Duration;
import java.util.Set;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class DocumentsScenarios2 {

	WebDriver driver;

	public DocumentsScenarios2(WebDriver driver) {

		this.driver = driver;

	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void waitEle1(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).clear();
	}

	public void sendKeysToElement(By by, CharSequence keysToSend) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(keysToSend);
	}

	@SuppressWarnings("unused")
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

	public void blankurl() throws Exception {
		Thread.sleep(10000);
		driver.get("https://nsui.esigns.io/documents/upload");

	}

	public void DocScenario() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			System.out.println("Overlay not found or not invisible.");
		}

		By ad = By.xpath("//span[normalize-space()='Documents']");

		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			WebElement docu = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//h3[@class='fw-medium blue-dark mb-3 fs-6']")));
			Assert.notNull(docu, "Documents");
			System.out.println("Clicked On Documents using JS successfully");

		} catch (Exception e) {

			System.out.println("Element not clickable or not found: ");
		}
		Thread.sleep(10000);
		waitEle(By.xpath("//button[@class='el-button scaling-button el-button--primary create-btn px-4 ml-2']"));

	}

	public boolean ValidDocScenario() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[normalize-space()='Documents']")));
		System.out.println("click Document Successful");
		return Success.isDisplayed();
	}

	public void BlankDoc(String s) throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		waitEle(By.xpath("//img[@src='/img/Blank.1f314c3f.svg']"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		By Element2 = By.xpath("//input[@placeholder='Enter Document name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.sendKeys(s);

		waitEle(By.xpath("//input[@placeholder='Select number of pages']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		waitEle(By.xpath("(//span[normalize-space()='Continue'])[2]"));

	}

	public void Signorder() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Enforce Signature Order']"));
		System.out.println("Enforce signature order enabled successfully");

	}

	public void Saveuser() throws Exception {

		waitEle(By.xpath("//span[normalize-space()='Save Users']"));
		System.out.println("Clicked on save users successfull");

	}

	public void waitAndClick(Actions actions, WebElement sourceElement, WebElement targetElement, int xOffset,
			int yOffset) {
		actions.clickAndHold(sourceElement).moveToElement(targetElement, xOffset, yOffset).release().build().perform();
	}

	public void Copylink() throws Exception {

		waitEle(By.xpath("//button[@class='el-button el-tooltip manage-recipients ml-2 el-button--default is-plain']"));

		waitEle(By.xpath("(//img[@src='/img/more-icon.dca8767b.svg'])[1]"));

		Thread.sleep(10000);

		waitEle(By.xpath("(//ul[@class='el-dropdown-menu el-popper']//a[1])[2]"));

		waitEle(By.xpath("(//i[@class='el-dialog__close el-icon el-icon-close'])[6]"));

	}

	public void Viewcommenteddocument() throws Exception {

		String Parentwindowid1 = driver.getWindowHandle();
		waitEle(By.xpath("//a[text()=\"View the document\"]"));
		Thread.sleep(10000);
		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(1000);
				driver.switchTo().window(Parentwindowid1).close();
				driver.switchTo().window(childwindow);

				Thread.sleep(1000);
			}
		}
	}

	public void Changeruser() throws Exception {

		waitEle(By.xpath("//button[@class='el-button el-tooltip manage-recipients ml-2 el-button--default is-plain']"));

		waitEle(By.xpath("(//img[@src='/img/more-icon.dca8767b.svg'])[1]"));

		Thread.sleep(10000);

		waitEle(By.xpath("(//ul[@class='el-dropdown-menu el-popper']//a[2])[2]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter first name']")));
		element.clear();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter first name']"), "Prudvi");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Enter last name']")));
		element1.clear();

		sendKeysToElement(By.xpath("//input[@placeholder='Enter last name']"), "B");

		waitEle(By.xpath("//i[@class='el-select__caret el-input__icon el-icon-arrow-up']"));

		waitEle(By.xpath("//input[@placeholder='Enter email']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[2]"));
	}

	public void Deletepages() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//canvas[@id='0_canvas_page_2']"));

		waitEle(By.xpath(
				"(//button[@class='el-button el-tooltip item el-button--default el-button--mini is-plain is-circle'])[6]"));

		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']"));

		Thread.sleep(10000);

		System.out.println("Deleted existing page from the existed document");

	}

	public void Addpages() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("(//button[@class='el-button el-tooltip add-page-top item el-button--default is-plain'])[2]"));

		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']"));

		Thread.sleep(10000);

		waitEle(By.xpath("(//button[@class='el-button el-tooltip add-page-top item el-button--default is-plain'])[2]"));

		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']"));

		Thread.sleep(10000);

		System.out.println("Added pages succesfully for the uploaded document");

	}

	public void Lockfields() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//img[@src='/img/Icon-ellipsis-v.eb3a1342.svg']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//span[@class='el-checkbox__inner']"));

		Thread.sleep(10000);

		System.out.println("Locked fields successfully");

	}

	@SuppressWarnings("deprecation")
	public void changedoc(String imagePath) throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//img[@src='/img/Icon-ellipsis-v.eb3a1342.svg']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

		Thread.sleep(10000);
		File uploadFile = new File(imagePath);

		WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
		fileInput.sendKeys(uploadFile.getAbsolutePath());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", fileInput);

//		waitEle(By.xpath("//img[@src='/img/attachment-filling.da0448d7.svg']"));
//
//		Runtime.getRuntime().exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\fileupload.exe");
//
//		Thread.sleep(10000);

		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[8]"));

		Thread.sleep(10000);

	}

	public void otheroptionsdelete() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[9]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

		System.out.println("clicked on delete");

	}

	@SuppressWarnings("deprecation")
//	public void UploadMultipledocuments() throws Exception {
//		waitEle(By.xpath("//h4[@class='fw-normal blue pb-2']"));
//		Runtime.getRuntime()
//				.exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\multiple document.exe");
//
//		Thread.sleep(10000);
//	}

	public void PCOnedoc() throws Exception {

		waitEle(By.xpath("//span[@class='el-checkbox__inner']"));

		System.out.println("clicked on processitassingle");
	}

	public void SaveAsDraft() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Save Draft']"));
	}

	public void EntityMappingSettings() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//img[@src='/img/Icon-ellipsis-v.eb3a1342.svg']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		Thread.sleep(10000);

//	waitEle(By.xpath("(//span[normalize-space()='Secure E-Sign'])[1]"));

//	waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[2]"));

		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button type-2 el-button--default']"));

	}

	public void Finishdocument() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Finish Document']"));

		Thread.sleep(10000);

		System.out.println("Document completed");

	}

	public void Senddoc() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()=\"Send Document\"]"));
		System.out.println("click on send Doc after drag and drop done successfully");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By ele = By.xpath("//textarea[@placeholder='Subject']");
		WebElement sen = wait.until(ExpectedConditions.elementToBeClickable(ele));
		sen.sendKeys("Test Sample");

		By ele2 = By.xpath("//textarea[@placeholder=\"Type your text here\"]");
		WebElement sen2 = wait.until(ExpectedConditions.elementToBeClickable(ele2));
		sen2.sendKeys("Test Sample");
		Thread.sleep(5000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Send Document']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

	}

	public void switchEmail() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@class=\"_8ZYZKvxC8bvw1xgQGSkvvA==\"]"));
		waitEle(By.xpath("//div[text()=\"Sign in with a different account\"]"));

	}

	public void Outlooklogin(String email, String password) throws Exception {
		Thread.sleep(10000);
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
		switchEmail();
		sendKeysToElement(By.xpath("//input[@id=\"i0116\"]"), email);
		try {
			waitEle(By.xpath("//input[@id=\"idSIButton9\"]"));
		} catch (Exception e) {
			waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		}
		Thread.sleep(3000);
		sendKeysToElement(By.xpath("//input[@placeholder=\"Password\"]"), password);
		waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		Thread.sleep(3000);
		waitEle(By.xpath("//button[@id=\"declineButton\"]"));
		System.out.println("Email login Sucessfull");
//		System.out.printf("%s Login successfull", email);
	}

	public void DradAndDropSigAndFullName(int n, int x1, int y1, int x2, int y2) throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(5000);
		String xpath = String.format("//div[@x-placement=\"bottom-start\"]//li[%d]", n);
		waitEle(By.xpath(xpath));
		Thread.sleep(5000);
		Actions actions1 = new Actions(driver);

		WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		WebElement signElement = driver.findElement(By.xpath("//button[@id='signatureEle']"));

		waitAndClick(actions1, signElement, targetElement, x1, y1);
		System.out.println("Signature Element Drag and Drop Done");

		WebElement fullNameElement = driver.findElement(By.xpath("//button[@id='fullNameEle']"));
		waitAndClick(actions1, fullNameElement, targetElement, x2, y2);
		System.out.println("FullName Drag and Drop Done");

	}

//	public void autoFill(String dataValofChkBx) throws Exception {
//		Thread.sleep(1000);
//		driver.get("https://nsui.esigns.io/profilesettings/application-settings");
//		Thread.sleep(1000);
//
//		WebElement element = driver
//				.findElement(By.xpath("//span[text()=' Auto-complete sender if all fields filled']"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//
//		boolean isChecked = driver.findElement(By.xpath("(//span[@class='el-checkbox__inner'])[2]")).isSelected();
//
//		if (dataValofChkBx != null && dataValofChkBx.equalsIgnoreCase("Y")) {
//			if (!isChecked) {
//
//				driver.findElement(By.xpath("(//span[@class='el-checkbox__inner'])[2]")).click();
//				System.out.println("Checkbox checked.");
//			} else {
//				System.out.println("Checkbox already checked.");
//			}
//		} else if (dataValofChkBx != null && dataValofChkBx.equalsIgnoreCase("N")) {
//			if (isChecked) {
//				// Checkbox is already checked, click it to uncheck
//				Thread.sleep(10000);
//				driver.findElement(By.xpath("(//span[@class='el-checkbox__inner'])[2]")).click();
//				System.out.println("Checkbox unchecked.");
//			} else {
//				System.out.println("Checkbox already unchecked.");
//			}
//		} else {
//			throw new IllegalArgumentException("Invalid dataValofChkBx value: " + dataValofChkBx);
//		}
//
//		waitEle(By.xpath("//span[text()='Save Changes']"));
//	}

	public void SplitBox() throws Exception {

		Thread.sleep(10000);

		WebElement elementToHover2 = driver.findElement(By.xpath("(//textarea[@class='el-textarea__inner'])[2]"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).doubleClick().perform();
		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("(//span[@class='el-checkbox__input'])[2]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='el-input__inner'])[10]")));
		element1.clear();

		sendKeysToElement(By.xpath("(//input[@class='el-input__inner'])[10]"), "30");

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait1
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='el-input__inner'])[11]")));
		element.clear();

		sendKeysToElement(By.xpath("(//input[@class='el-input__inner'])[11]"), "3");

		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[4]"));
	}

	public void DradAndDropSigAndSingleline(int n, int x1, int y1, int x2, int y2) throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(5000);
		String xpath = String.format("//div[@x-placement=\"bottom-start\"]//li[%d]", n);
		waitEle(By.xpath(xpath));
		Thread.sleep(5000);
		Actions actions1 = new Actions(driver);

		WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		WebElement signElement = driver.findElement(By.xpath("//button[@id='signatureEle']"));

		waitAndClick(actions1, signElement, targetElement, x1, y1);
		System.out.println("Signature Element Drag and Drop Done");

		WebElement fullNameElement = driver.findElement(By.xpath("//button[@id='singleLineTextEle']"));
		waitAndClick(actions1, fullNameElement, targetElement, x2, y2);
		System.out.println("FullName Drag and Drop Done");

	}

	public void windowHandle() throws InterruptedException {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
	}

	public void AddRecipientforEntity(int id, String contactType, String Mail, String signerType) throws Exception {

		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));
		System.out.println("Click on Add recipient done Successfully");
		String xpath = String.format("//div[@id='user_%d']//input[@placeholder='Select contact type']", id);
		waitEle(By.xpath(xpath));
		String con = String.format("//div[@x-placement]//ul//li[normalize-space()='%s']", contactType);
		waitEle(By.xpath(con));
		System.out.println("Selected contact type Successfully");
		String xpath2 = String.format("//div[@id='user_%d']//input[@placeholder='Search with Email']", id);
		waitEle(By.xpath(xpath2));
		sendKeysToElement(By.xpath(xpath2), Mail);

		waitEle(By.xpath("//span[normalize-space()='Save Users']"));

		waitEle(By.xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']"));

		windowHandle();

		waitEle(By.xpath("//i[@class='el-icon-circle-plus-outline']"));

		windowHandle();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='el-radio__inner'])[1]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		waitEle(By.xpath("//div[@class=\"v-modal\"]"));

		Thread.sleep(3000);

		waitEle(By.xpath("//span[text()=' Add Account ']"));

		Thread.sleep(10000);
		waitEle(By.xpath("(//span[normalize-space()='Save'])[3]"));

		String xpath4 = String.format("//div[@id='user_%d']//input[@placeholder='Select Signer Type']", id);
		waitEle(By.xpath(xpath4));
		Thread.sleep(3000);
		String signertype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", signerType);
		waitEle(By.xpath(signertype));

		System.out.println("Selected Recipients Successfully");

	}

	public void RecipientSigner(int id, String contactType, String email, String signerType) throws Exception {
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));
		System.out.println("Click on Add recipient done Successfully");
		String xpath = String.format("//div[@id='user_%d']//input[@placeholder='Select contact type']", id);
		waitEle(By.xpath(xpath));
		String contacttype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", contactType);
		waitEle(By.xpath(contacttype));
		System.out.println("Selected contact type Successfully");
		String xpath2 = String.format("//div[@id='user_%d']//input[@placeholder='Search with Email']", id);
		waitEle(By.xpath(xpath2));
		Thread.sleep(3000);
		System.out.println("click on Search with email done Successfully");
		String xpath3 = String.format("//div[@x-placement]//li[text()=\" %s \"]", email);
		waitEle(By.xpath(xpath3));
		String xpath4 = String.format("//div[@id='user_%d']//input[@placeholder='Select Signer Type']", id);
		waitEle(By.xpath(xpath4));
		Thread.sleep(3000);
		String signertype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", signerType);
		waitEle(By.xpath(signertype));
		System.out.println("Selected Recipients Successfully");
	}

	public void clickSubmit() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(5000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Send Document']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		Thread.sleep(10000);
	}

	public boolean Verifysubmit() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement name = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=\"Document Sent \"]")));
		System.out.println("Sent Document Sucessfully");
		return name.isDisplayed();
	}

	public void Viewdocument() throws Exception {

		waitEle(By.xpath("//span[normalize-space()='View Document']"));

		System.out.println("View Document successfull");
	}

	public void Blankwithoutsenderautofill() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Edit']"));
		driver.findElement(By.xpath("//input[@placeholder='Enter signature']")).sendKeys("Meghana");

		waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));

		System.out.println("mySignatureEle Element opened With Double Click and Entered New Sign Data Successfully");

		waitEle(By.xpath("//span[normalize-space()='FINISH']"));
		System.out.println("Finish document successfull");

	}

	public void Checkbox() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("(//div[@class='el-tooltip tooltip']//input)[14]"));

	}

	public void autofilloff() throws Exception {

		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
//		waitEle(By.xpath("(//div[@class=\"icon-text\"])[1]"));
//		Thread.sleep(5000);
//		waitEle(By.xpath("//li[text()=\" Settings \"]"));
//		Thread.sleep(5000);
//		waitEle(By.xpath("//a[text()=\"Application Settings\"]"));
		driver.get("https://nsui.esigns.io/profilesettings/application-settings");
		Thread.sleep(5000);
		WebElement element = driver
				.findElement(By.xpath("//span[text()=\" Auto-complete sender if all fields filled\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			waitEle(By.xpath(
					"//label[@class=\"el-checkbox is-checked\"]//span[text()=\" Auto-complete sender if all fields filled\"]"));
			System.out.println("autofill is off");

		} catch (Exception e) {
			System.out.println("Autofill is already off");
		}

		Thread.sleep(5000);
		waitEle(By.xpath("//span[text()=\"Save Changes\"]"));

	}

	public void autofillon() throws Exception {
		Thread.sleep(10000);
//		waitEle(By.xpath("(//div[@class=\"icon-text\"])[1]"));
//		Thread.sleep(5000);
//		waitEle(By.xpath("//li[text()=\" Settings \"]"));
//		Thread.sleep(5000);
//		waitEle(By.xpath("//a[text()=\"Application Settings\"]"));
		driver.get("https://nsui.esigns.io/profilesettings/application-settings");
		Thread.sleep(5000);
		WebElement element = driver
				.findElement(By.xpath("//span[text()=\" Auto-complete sender if all fields filled\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			driver.findElement(By.xpath(
					"//label[@class=\"el-checkbox\"]//span[text()=\" Auto-complete sender if all fields filled\"]"))
					.click();
			System.out.println("autofill is on");

		} catch (Exception e) {
			System.out.println("Autofill is already on");
		}
		waitEle(By.xpath("//span[text()=\"Save Changes\"]"));
	}

	public void Nextbt() throws Exception {

		waitEle(By.xpath("//span[normalize-space()='Next']"));

		System.out.println("Next button clicked successfully");
		Thread.sleep(10000);
	}

	public void Selecttofillrec() throws Exception {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

	}

	public void Selectautofill() throws Throwable {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Add fields']"));
		Thread.sleep(20000);
	}

	public void PdfEditmode() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//span[@class='el-switch__core']"));

		waitEle(By.xpath("//img[@src='/img/eraser-icon.34c3de87.png']"));

		waitEle(By.xpath("//*[@id='svg']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//a[@class='text-icon el-link el-link--default']"));

		Thread.sleep(100000);

		waitEle(By.xpath("//a[@class='save-icon el-link el-link--default']"));

	}

	public void Chat() throws Exception {

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		waitEle(By.xpath("//span[normalize-space()='Chat']"));

		Thread.sleep(10000);

		By comment = By.xpath("//textarea[@placeholder='Enter comments here...']");
		WebElement comment2 = wait.until(ExpectedConditions.elementToBeClickable(comment));
		comment2.sendKeys("no comments");

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Post']"));
	}

	public void Logs() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Logs']"));

	}

	public void OtherOptions() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//div[@class='el-dropdown']//span//i"));

		System.out.println("clicked on other options");

	}

	public void otheroptionsvoiddoc() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[8]"));

		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Yes'])[2]"));
		Thread.sleep(10000);

		System.out.println("clicked on voiddocument");

	}

	public void Clonedocument() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("(//div[@class='el-dropdown']//span//i)[1]"));

		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[3]"));

		waitEle(By.xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']"));

		Thread.sleep(10000);

	}

	public void otheroptionssaveastem() throws Exception {
		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[7]"));

		System.out.println("clicked on saveastemplate");

	}

	public void otheroptionsCorrectdoc() throws Exception {

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[6]"));

		waitEle(By.xpath("(//span[normalize-space()='Yes'])[2]"));

		System.out.println("clicked on correctdocument");

		Thread.sleep(10000);

	}

	@SuppressWarnings("deprecation")
	public void otheroptionsprintandsign() throws Exception {

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[2]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button float-right mt-1 el-button--default']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button el-button--danger']"));

		waitEle(By.xpath("//button[@class='el-button el-button--default el-button--mini']"));
		Runtime.getRuntime().exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\fileupload.exe");

		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button el-button--danger']"));

		System.out.println("clicked on print and sign");
	}

	public void otheroptionssettings() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[5]"));

		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		WebElement checkbox = driver.findElement(By.xpath("(//span[@class='el-radio__inner'])[1]"));
		boolean isChecked = checkbox.isSelected();

		if (!isChecked) {
			checkbox.click();
			System.out.println("Checkbox was unchecked. Now it's checked.");
		} else {
			System.out.println("Checkbox was already checked. No action taken.");
		}

		waitEle(By.xpath("//button[@class='el-button type-2 el-button--default']"));

		System.out.println("clicked on settings");
	}

	public void otheroptionshistory() throws Exception {

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[4]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[2]"));

		System.out.println("clicked on history");

		waitEle(By.xpath("(//button[@class='el-dialog__headerbtn'])[19]"));
	}

	public void Otheroptionsdownload() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[3]"));

		Thread.sleep(10000);

		System.out.println("clicked on download");

	}

	public void otheroptionsfinishlater() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[1]"));

		System.out.println("clicked on finishlater");

	}

	public void Afterfinishlater() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='TRY IT']"));
		String Parentwindowid1 = driver.getWindowHandle();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver
				.findElement(By.xpath("(//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-edit-outline'])[1]"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).click().perform();
		Thread.sleep(10000);
		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(1000);
				driver.switchTo().window(Parentwindowid1).close();
				driver.switchTo().window(childwindow);

				Thread.sleep(1000);
			}
		}
	}

	@SuppressWarnings("deprecation")
	public void uploadFileWithSendKeys(String imagePath) throws InterruptedException {
		Thread.sleep(10000);
		File uploadFile = new File(imagePath);

		WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
		fileInput.sendKeys(uploadFile.getAbsolutePath());

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", fileInput);

	}

	public void Adddatatoemptypdf() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//div[@class='el-switch el-tooltip mr-1 item']//span"));

		Thread.sleep(10000);

		sendKeysToElement(By.xpath("//*[@id=\"svg\"]"),
				"This document is for texting purose we are adding data to an empty pdf document");

	}

	public void Clonedocumentforsinglesender() throws Exception {

		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}

		Thread.sleep(10000);
		waitEle(By.xpath("(//div[@class='el-dropdown']//span//i)[1]"));

		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement='bottom-end']//a[5]"));

		waitEle(By.xpath("//button[@class='el-button el-button--default el-button--small el-button--primary ']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//a[@class='el-icon-circle-plus el-link el-link--danger']"));
	}

	public void SendClonedoc() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath(
				"//button[@class='el-button type-2 ml-2 settigns-font button-type-one send-btn el-button--danger']"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Alert Message!'])[1]")));
		Assert.notNull(Message1, "Alert popup is not displayed");

	}

	public void FormTemplate() throws Exception {
		Thread.sleep(10000);

		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		Thread.sleep(10000);

		waitEle(By.xpath("//span[@class='el-icon-arrow-down text-white']"));

		Thread.sleep(3000);

		By Entities = By.xpath("(//img[@src='/img/Form_Inactive.622b7154.svg'])[1]");
		WebElement Entities1 = wait.until(ExpectedConditions.elementToBeClickable(Entities));
		Entities1.click();

		System.out.println("Clicked on Form template in profile completed");

	}

	private static int counter = 0;

	public static String generateUniqueString() {
		return "unique_string_sample" + UUID.randomUUID().toString().substring(0, 8) + counter++;

	}

	public void CreateFormtemplate(String s) throws Exception {

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
		Name1.sendKeys(s);

		sendKeysToElement(By.xpath("//textarea[@placeholder='Enter Template Description']"), "Test purpose");

		waitEle(By.xpath("(//span[normalize-space()='Submit'])[1]"));
	}

	public void BasicFields() throws Exception {
		waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));
		Thread.sleep(10000);
		// Single Line
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));
		Actions actions = new Actions(driver);
		WebElement Singlelinetext = driver.findElement(By.xpath("//span[text()=\"Single Line Text\"]"));
		waitAndClick(actions, Singlelinetext, Target);
		System.out.println("Singleline Drag and Drop Done");
		By SName = By.xpath("//input[@placeholder='Enter Field Title']");
		WebElement SName1 = wait.until(ExpectedConditions.elementToBeClickable(SName));
		SName1.sendKeys("Single line text");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Multiline
		WebElement Multiline = driver.findElement(By.xpath("//span[text()=\"Multi Line Text\"]"));
		waitAndClick(actions, Multiline, Target);
		System.out.println("Multiline Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Multiline");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Number Of Rows']"), "3");
		waitEle(By.xpath("(//input[@placeholder='Select'])[2]"));
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Select Field
		WebElement Select = driver.findElement(By.xpath("//span[text()=\"Select\"]"));
		waitAndClick(actions, Select, Target);
		System.out.println("Select Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Select");
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "Computer science");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "maths");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "Physics");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		Thread.sleep(10000);
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Number
		WebElement Number = driver.findElement(By.xpath("//span[text()=\"Number\"]"));
		waitAndClick(actions, Number, Target);
		System.out.println("Number Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Number");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// MultiSelect
		WebElement MultiSelect = driver
				.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[5]"));
		waitAndClick(actions, MultiSelect, Target);
		System.out.println("MultiSelect Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Multiselect");

		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "Computer science");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "maths");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "Physics");

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// List
		WebElement List = driver
				.findElement(By.xpath("(//button[@class='el-button field-element el-button--default'])[6]"));
		waitAndClick(actions, List, Target);
		System.out.println("List Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Number");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Name']"), "List");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Value']"), "123");
		waitEle(By.xpath("//button[@class='el-button f-weight-600 el-button--primary']"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		// Date
		WebElement Date = driver.findElement(By.xpath("//span[text()=\"Date\"]"));
		waitAndClick(actions, Date, Target);
		System.out.println("Date Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Date");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Time
		WebElement Time = driver.findElement(By.xpath("//span[text()=\"Time\"]"));
		waitAndClick(actions, Time, Target);
		System.out.println("Time Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Time");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Fixed Time
		WebElement FixedTime = driver.findElement(By.xpath("//span[text()=\"Fixed Time\"]"));
		waitAndClick(actions, FixedTime, Target);
		System.out.println("FixedTime Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "FixedTime");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Time Range
		WebElement TimeRange = driver.findElement(By.xpath("//span[text()=\"Time Range\"]"));
		waitAndClick(actions, TimeRange, Target);
		System.out.println("TimeRange Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "TimeRange");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// DateTime
		WebElement DateTime = driver.findElement(By.xpath("//span[text()=\"Date Time\"]"));
		waitAndClick(actions, DateTime, Target);
		System.out.println("DateTime Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DateTime");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// DateRange
		WebElement DateRange = driver.findElement(By.xpath("//span[text()=\"Date Range\"]"));
		waitAndClick(actions, DateRange, Target);
		System.out.println("DateRange Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DateRange");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		// Weekdays
		WebElement Weekdays = driver.findElement(By.xpath("//span[text()=\"Week Days\"]"));
		waitAndClick(actions, Weekdays, Target);
		System.out.println("Weekdays Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Weekdays");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		// YesorNo
		WebElement YesorNo = driver.findElement(By.xpath("//span[text()=\"Yes or No\"]"));
		waitAndClick(actions, YesorNo, Target);
		System.out.println("YesorNo Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "YesorNo");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// checkbox
		WebElement Checkbox = driver.findElement(By.xpath("//span[text()=\"Checkbox\"]"));
		waitAndClick(actions, Checkbox, Target);
		System.out.println("Checkbox Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Checkbox");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Checkbox Group
		WebElement Checkboxgroup = driver.findElement(By.xpath("//span[text()=\"Checkbox Group\"]"));
		waitAndClick(actions, Checkboxgroup, Target);
		System.out.println("Checkbox Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "CheckboxGroup");
		Thread.sleep(5000);
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "1");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "2");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("//input[@class='el-select__input']"), "3");
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		sendKeysToElement(By.xpath("(//div[@class=\"el-input\"]//input[@class=\"el-input__inner\"])[2]"), "1");
		sendKeysToElement(By.xpath("(//div[@class=\"el-input\"]//input[@class=\"el-input__inner\"])[3]"), "2");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Document
		WebElement Document = driver.findElement(By.xpath("//span[text()=\"Document\"]"));
		waitAndClick(actions, Document, Target);
		System.out.println("Document Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Document");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Radio
		WebElement Radio = driver.findElement(By.xpath("//span[text()=\"Radio\"]"));
		waitAndClick(actions, Radio, Target);
		System.out.println("Radio Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Radio");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// RadioGroup
		WebElement Radiogroup = driver.findElement(By.xpath("//span[text()=\"Radio Group\"]"));
		waitAndClick(actions, Radiogroup, Target);
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
		waitAndClick(actions, Phoneno, Target);
		System.out.println("Phoneno Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Phonono");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Signature
		WebElement Sign = driver.findElement(By.xpath("//span[text()=\"Signature\"]"));
		waitAndClick(actions, Sign, Target);
		System.out.println("Sign Element Drag and Drop Done");
		sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "Sign");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

	}

	public void Entity() throws Exception {
		Thread.sleep(10000);

		try {
			waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {

		}

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

	public void ClickCreateEntity() throws Exception {
		Thread.sleep(10000);

		By ad = By.xpath("//button[normalize-space()='Create Entity']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on ceate entity using JS.");

	}

	public void Createentity(String s, String EntityType, String CreateType) throws Exception {
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
		Title1.sendKeys(s);

		String entitytype = String.format("//span[contains(text(), '%s')]", EntityType);
		waitEle(By.xpath(entitytype));
		System.out.println("Selected entity type Successfully");

		String createtype = String.format("//p[contains(text(), '%s')]", CreateType);
		waitEle(By.xpath(createtype));
		System.out.println("Selected entity type Successfully");

//		waitEle(By.xpath("//span[contains(text(), '%s')]", EntityType));

		Thread.sleep(10000);

		waitEle(By.xpath("//i[@class='fa fa-check-square-o']"));

		System.out.println("Create entity successfull");
	}

	public void addtemplatetoentity() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@class='el-scrollbar__view']//button[normalize-space()='templateBasicFeilds']"));

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

		waitEle(By.xpath("//span[normalize-space()='Update & Next']"));

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

		RemoveWarning();

		RemoveWarning();

		RemoveWarning();

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='el-button mt-1 mr-1 el-button--primary']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		System.out.println("Document Done Sucessfully");

	}

	public void DragBasicFeildsCompanyProfile(int n) throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(5000);
		String xpath = String.format("//div[@x-placement=\"bottom-start\"]//li[%d]", n);
		waitEle(By.xpath(xpath));

		String feilds[] = { "Radio Group", "Date Range", "Sign", "Date Time", "Yes Or No", "Weekdays",
				"Single Line Text", "Date", "Document", "Fixed Time", "List", "Time", "Number", "Multi Select",
				"Phone no", "Select", "Multiline", "CheckBox" };
		int l = feilds.length;
		Thread.sleep(5000);
		waitEle(By.xpath("//div[text()=\"templateBasicFeilds\"]"));
		Thread.sleep(5000);
		int i = 1;
		for (int x = -250; x <= 250; x = x + 250) {
			for (int y = -80; y <= 210; y = y + 50) {
				String xpath1 = String.format("(//button[@class=\"el-tooltip field-element tooltip\"])[%d]", i++);
				if (i <= l + 1) {
					Actions actions = new Actions(driver);
					WebElement ele = driver.findElement(By.xpath(xpath1));
					WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
					waitAndClick(actions, ele, Target, x, y);
					System.out.printf("%s Field Drag and Drop Done\n", feilds[i - 2]);
				} else {
					break;
				}

			}
		}

	}

	public void documentsettings() throws Exception {
		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		WebElement checkbox = driver.findElement(By.xpath("(//span[@class='el-radio__inner'])[1]"));
		boolean isChecked = checkbox.isSelected();

		if (!isChecked) {
			checkbox.click();
			System.out.println("Checkbox was unchecked. Now it's checked.");
		} else {
			System.out.println("Checkbox was already checked. No action taken.");
		}

		waitEle(By.xpath("//span[text()='Save & Send ']"));

		System.out.println("clicked on settings");
	}

	public void Updateafterdocumentcompletionfromsettings() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[@class='el-icon-arrow-down text-white']"));

		Thread.sleep(10000);

		By ad = By.xpath("//li[normalize-space()='Settings'] ");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on Settings using JS.");

		waitEle(By.xpath(
				"//a[@class='router-link-exact-active router-link-active list-group-item list-group-item-action active']"));
	}

	public void Settings() throws Exception {

//		waitEle(By.xpath("//a[@class='router-link-exact-active router-link-active list-group-item list-group-item-action active']"));

		Thread.sleep(10000);

		WebElement checkbox = driver.findElement(By.xpath("(//span[@class='el-radio__inner'])[1]"));
		boolean isChecked = checkbox.isSelected();

		if (!isChecked) {
			checkbox.click();
			System.out.println("Checkbox was unchecked. Now it's checked.");
		} else {
			System.out.println("Checkbox was already checked. No action taken.");
		}

		waitEle(By.xpath("//button[@class='el-button type-2 el-button--default']"));

		Thread.sleep(10000);
	}

	public void Settings2() throws Exception {

		Thread.sleep(110000);

		WebElement checkbox = driver.findElement(By.xpath("(//span[@class='el-radio__input'])[2]"));
		boolean isChecked = checkbox.isSelected();

		if (!isChecked) {
			checkbox.click();
			System.out.println("Checkbox was unchecked. Now it's checked.");
		} else {
			System.out.println("Checkbox was already checked. No action taken.");
		}

		waitEle(By.xpath("//button[@class='el-button type-2 el-button--default']"));
	}

	@SuppressWarnings("deprecation")
	public void enteringdatatoentity() throws Exception {

		Thread.sleep(100000);

		waitEle(By.xpath("(//span[@class='el-radio__inner'])[1]"));

		waitEle(By.xpath("//input[@placeholder='Start date']"));

		waitEle(By.xpath(
				"(//div[@class='el-picker-panel__content el-date-range-picker__content is-left']//span[normalize-space()='4'])[1]"));

		waitEle(By.xpath(
				"(//div[@class='el-picker-panel__content el-date-range-picker__content is-right']//span[normalize-space()='4'])[1]"));

		waitEle(By.xpath("//i[@class='el-icon-edit']"));

		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));

		waitEle(By.xpath("//input[@placeholder='Date Time']"));

//		waitEle(By.xpath("(//span[normalize-space()='4'])[5]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

		waitEle(By.xpath("(//span[@class='el-radio__inner'])[4]"));

		waitEle(By.xpath("//input[@placeholder='Weekdays']"));

		waitEle(By.xpath("//div[@x-placement]//span[normalize-space()='Thursday']"));

		waitEle(By.xpath("//input[@placeholder='Date']"));

		waitEle(By.xpath("(//div[@class='el-picker-panel__content']//span[normalize-space()='4'])[3]"));

		sendKeysToElement(By.xpath("//input[@placeholder='Single Line Text']"), "Ramya");

		waitEle(By.xpath("//img[@src='/img/upload-icon.30a8f8f6.svg']"));

		Runtime.getRuntime()
				.exec("\"C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\blankupload..exe\"");

		waitEle(By.xpath("//input[@placeholder='Please select...']"));

		waitEle(By.xpath("//div[@x-placement]//li[normalize-space()='list']"));

		waitEle(By.xpath("//input[@placeholder='Fixed Time']"));

		waitEle(By.xpath("//div[normalize-space()='01:30']"));

		waitEle(By.xpath("//input[@placeholder='Multi Select']"));

		waitEle(By.xpath("//div[@x-placement]//span[normalize-space()='2']"));

		waitEle(By.xpath("//i[@class='el-select__caret el-input__icon el-icon-arrow-up is-reverse']"));

		sendKeysToElement(By.xpath("//input[@placeholder='Number']"), "123456");

		waitEle(By.xpath("//input[@placeholder='Time']"));

		Thread.sleep(10000);

		waitEle(By.xpath("(//button[normalize-space()='OK'])[4]"));

		sendKeysToElement(By.xpath("//input[@placeholder='Phone no']"), "1234567890");

		sendKeysToElement(By.xpath("//textarea[@placeholder='Multiline']"), "qewrtryetuipilkjhgfdsaaxzcvbnm");

		waitEle(By.xpath("//input[@placeholder='Select']"));

		waitEle(By.xpath("//div[@x-placement]//li[normalize-space()='maths']"));

		waitEle(By.xpath("(//div[@class='el-tooltip tooltip']//input)[14]"));

	}

	public void Perform() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover2 = driver
				.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//span[normalize-space()='Actions']"));
		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).perform();

	}

	public void VerifyEntityData() throws Exception {

		driver.get("https://nsui.esigns.io/");

		Thread.sleep(10000);

		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("pmmeghana200@outlook.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Meghana@123");
		driver.findElement(By.xpath("//button[@class='el-button type-2 w-100 fs-6 el-button--danger']")).click();
		Thread.sleep(10000);

		ClickCreateEntity();

		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

	}

	public void verifyBasicFeildDataFillInIndividualEntity(String a) throws Exception {
		String feild[] = { "RadioGroup", "DateRange", "Document", "Multiline", "CheckboxGroup", "Phonono",
				"Single line text", "Select", "Number", "Multiselect", "list", "Date", "Time", "FixedTime", "DateTime",
				"Weekdays", "YesorNo" };
		String arr[] = a.split(",");
		int l = arr.length;

		for (int i = 2; i <= l; i++) {
			Thread.sleep(10000);
			String xpath = String.format(
					"//div[@class='el-table__body-wrapper is-scrolling-left']//table/tbody/tr[1]/td[%d]//p[normalize-space()=\"%s\"] | "
							+ "//div[@class='el-table__body-wrapper is-scrolling-left']//table/tbody/tr[1]/td[%d]//span[normalize-space()=\"%s\"]",
					i, arr[i - 2], i, arr[i - 2]);

			WebElement element = driver.findElement(By.xpath(xpath));
			try {
				if (element.isDisplayed()) {
					System.out.printf("%s Feild data %s displayed correctly\n", feild[i - 2], arr[i - 2]);
				} else {

					System.out.printf("%s Feild data %s not displayed or displayed incorrectly\n", feild[i - 2],
							arr[i - 2]);
				}
			} catch (Exception e) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({block: 'nearest', inline: 'start'});", xpath);
				if (element.isDisplayed()) {
					System.out.printf("%s Feild data %s displayed correctly after scroll\n", feild[i - 2], arr[i - 2]);
				} else {

					System.out.printf("%s Feild data %s not displayed or displayed incorrectly after scroll\n",
							feild[i - 2], arr[i - 2]);
				}
			}
		}
	}

	public void UpdateDatatoEntity() throws Exception {
		Thread.sleep(10000);

		waitEle1(By.xpath("//input[@placeholder='Phonono']"));

		sendKeysToElement(By.xpath("//input[@placeholder='Phonono']"), "0987654321");

		waitEle1(By.xpath("//input[@placeholder='Single line text']"));

		sendKeysToElement(By.xpath("//input[@placeholder='Single line text']"), "Ramyasri");

		waitEle1(By.xpath("//input[@placeholder='Number']"));

		sendKeysToElement(By.xpath("//input[@placeholder='Number']"), "54321");

		waitEle(By.xpath("//input[@placeholder='Select']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		waitEle(By.xpath("//input[@placeholder='Date']"));

		waitEle(By.xpath("(//span[normalize-space()='4'])[7]"));

		waitEle(By.xpath("//img[@src='/img/upload-icon.30a8f8f6.svg']"));

	}

	public void Rearranges(int id1, int id2) throws Exception {
		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@class='select-recipients']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 100;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();
		String xpath1 = String.format("//div[@id='user_%d']", id1);
		String xpath2 = String.format("//div[@id='user_%d']", id2);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement CC = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
		WebElement Signer = driver.findElement(By.xpath(xpath2));
		actions.clickAndHold(CC).moveToElement(Signer).release().build().perform();
		System.out.println("Rearrangement done");
	}

	public void BulkDelete() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[1]"));

		waitEle(By.xpath(
				"//button[@class='el-button el-dropdown-link px-2 el-button--default el-button--mini el-dropdown-selfdefine ']"));

		waitEle(By.xpath("//ul[@x-placement]//li[1]"));

		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[1]"));

	}

	public void clickondocuments() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Documents']"));
	}

	public void DraftStatus() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Documents']"));

		waitEle(By.xpath("//input[@placeholder='Select Status']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

	}

	public boolean VerifyDraft() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Draft = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Draft'])[1]")));
		System.out.println("Draft Status Successful");
		return Draft.isDisplayed();
	}

	public void DraftSentDocument() throws Exception {

		Perform();
		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

	}

	public boolean ValidDraftSendDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Send Document Successful");
		return Success.isDisplayed();
	}

	public void DraftSaveAsTemplate() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

	}

	public boolean ValidDraftSaveasTemplate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Save as Template Successful");
		return Success.isDisplayed();
	}

	public void DraftrenameDocument() throws Exception {
		Perform();
		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document3 = wait.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("Rename2");
		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Confirm'])[2]"));

	}

	public boolean ValidDraftRenameDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Rename Document Successful");
		return Success.isDisplayed();
	}

	public void Draftdocumentsetting() throws Exception {
		Perform();
		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

		waitEle(By.xpath("//span[normalize-space()='Save']"));

	}

	public boolean ValidDraftDocumentSettings() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Document settings Successful");
		return Success.isDisplayed();
	}

	public void Documentsettings() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//img[@src='/img/Icon-ellipsis-v.eb3a1342.svg']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[1]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//button[@class='el-button type-2 el-button--default']"));

	}

	public void DraftDeletedocument() throws Exception {
		Perform();
		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[5]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

	}

	public boolean ValidDraftDeleteDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Delete Document Successful");
		return Success.isDisplayed();
	}

	public void SentStatus() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Documents']"));

		waitEle(By.xpath("//input[@placeholder='Select Status']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

	}

	public boolean ValidSent() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Sent = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Sent'])[1]")));
		System.out.println("Sent Status Successful");
		return Sent.isDisplayed();
	}

	public void SentcorrectDocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

	}

	public boolean ValidSentcorrectDocument() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Correct Document Successful");
		return Success.isDisplayed();
	}

	public void SentResenddocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		waitEle(By.xpath("(//span[normalize-space()='Resend'])[1]"));

		waitEle(By.xpath("//button[@class='close-button']"));

	}

	public boolean ValidSentResenddocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Resend Document Successful");
		return Success.isDisplayed();
	}

	public void SentsavetoTemplate() throws Exception {
		Thread.sleep(10000);
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

	}

	public boolean ValidSentsavetoTemplate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Save To Template Successful");
		return Success.isDisplayed();
	}

	public void SentVoiddocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[5]"));

		waitEle(By.xpath("//span[normalize-space()='Yes']"));

	}

	public boolean ValidSentVoiddocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Void Document Successful");
		return Success.isDisplayed();
	}

	public void SentRenamedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[6]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document3 = wait.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("Rename");

		waitEle(By.xpath("(//span[normalize-space()='Confirm'])[2]"));

	}

	public boolean ValidSentRenamedocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Rename Document Successful");
		return Success.isDisplayed();
	}

	public void Sentdocumentsettings() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[7]"));

		waitEle(By.xpath("//span[normalize-space()='Save']"));

	}

	public boolean ValidSentdocumentsettings() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Document Settings Successful");
		return Success.isDisplayed();
	}

	public void SentDeletedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[8]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

	}

	public boolean ValidSentDeletedocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Delete Document Successful");
		return Success.isDisplayed();
	}

	public void SentDownloaddocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[9]"));

		System.out.println("Download Original Document Successful");
	}

	public void ApprovedStatus() throws Exception {

		waitEle(By.xpath("//span[normalize-space()='Documents']"));

		waitEle(By.xpath("//input[@placeholder='Select Status']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		Thread.sleep(10000);

	}

	public void VerifySelectStatus() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement ApprovedDocuments = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Approved'])[1]")));

		Assert.notNull(ApprovedDocuments, "Approveddocuments is not presents it is failed");
		System.out.println("Approved Document Select Status Successful");
	}

	public void ApprovedCorrectdocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

	}

	public boolean ValidApprovedCorrectdocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Error = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Correct Document Successful");
		return Error.isDisplayed();
	}

	public void ApprovedResenddocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Resend'])[2]"));

	}

	public boolean ValidResendDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Resend Document Successful");
		return Success.isDisplayed();
	}

	public void ApprovedSaveastemplate() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

	}

	public boolean ValidSaveAsTemplate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Save As Template Successful");
		return Success.isDisplayed();
	}

	public void ApprovedVoiddocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[5]"));

		waitEle(By.xpath("//span[normalize-space()='Yes']"));

	}

	public boolean ValidVoidDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("VoidDocument Successful");
		return Success.isDisplayed();
	}

	public void ApprovedRenamedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[6]"));

		waitEle(By.xpath("//span[normalize-space()='Yes']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document3 = wait.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("approve");

		waitEle(By.xpath("(//span[normalize-space()='Confirm'])[2]"));

	}

	public boolean ValidRenameDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Rename Successful");
		return Success.isDisplayed();
	}

	public void ApprovedDocumentsettings() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[7]"));

		waitEle(By.xpath("//span[normalize-space()='Save']"));

	}

	public boolean ValidDocumentSettings() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Documentsettings Successful");
		return Success.isDisplayed();
	}

	public void ApprovedDeletedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[8]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

	}

	public boolean ValidDeleteDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Delete document Successful");
		return Success.isDisplayed();
	}

	public void DeclinedStatus() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Documents']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select Status']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[5]"));

		Thread.sleep(10000);

	}

	public boolean VerifyDeclined() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Declined = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Declined'])[1]")));
		System.out.println("Declined Status Successful");
		return Declined.isDisplayed();
	}

	public void DeclinedSaveastemplate() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

	}

	public boolean ValidDeclinedSaveastemplate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Save As Template Successful");
		return Success.isDisplayed();
	}

	public void DeclinedVoiddocument() throws Exception {
		Perform();
		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Yes']"));

	}

	public boolean ValidDeclinedVoiddocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Void Document Successful");
		return Success.isDisplayed();
	}

	public void DeclinedRenamedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();
		Thread.sleep(10000);

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document3 = wait.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("Decline");
		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Confirm'])[2]"));

	}

	public boolean ValidDeclinedRenamedocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Rename Document Successful");
		return Success.isDisplayed();
	}

	public void DeclinedDocumentsettings() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[5]"));

		waitEle(By.xpath("//span[normalize-space()='Save']"));

	}

	public boolean ValidDeclinedDocumentSettings() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Document Settings Successful");
		return Success.isDisplayed();
	}

	public void DeclinedDeletedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[6]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

	}

	public boolean ValidDeclinedDeleteDocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Delete Document Successful");
		return Success.isDisplayed();
	}

	public void VoidStatus() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Documents']"));
		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select Status']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[6]"));

		Thread.sleep(10000);

	}

	public boolean ValidVoid() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Void = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Voided'])[1]")));
		System.out.println("Void Status Successful");
		return Void.isDisplayed();
	}

	public void VoidSaveastemplate() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

	}

	public boolean ValidVoidSaveastemplate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Save As Template Successful");
		return Success.isDisplayed();
	}

	public void VoidClonedocument() throws Exception {
		Perform();

		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

	}

	public boolean ValidVoidClonedocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Clone Document Successful");
		return Success.isDisplayed();
	}

	public void VoidDeletedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

	}

	public boolean ValidVoidDeletedocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Delete Document Successful");
		return Success.isDisplayed();
	}

	public void ArchievdStatus() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Documents']"));

		waitEle(By.xpath("//input[@placeholder='Select Status']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[7]"));

	}

	public boolean VerifyArchieved() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Archieved = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Archived'])[1]")));
		System.out.println("Archieved Status Successful");
		return Archieved.isDisplayed();

	}

	public void ArchivedRenamedocuments() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();
		Thread.sleep(10000);

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document3 = wait.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("Archieved");
		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Confirm'])[2]"));

	}

	public boolean ValidRenamedocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Rename Document Successful");
		return Success.isDisplayed();
	}

	public void ArchivedUndodocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

	}

	public boolean ValidUndodocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Undo Document Successful");
		return Success.isDisplayed();
	}

	public void ArchivedPermanentdelete() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

	}

	public boolean ValidPermanentDelete() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Permanet Delete Document Successful");
		return Success.isDisplayed();
	}

	public void CompletedStatus() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Documents']"));

		waitEle(By.xpath("//input[@placeholder='Select Status']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[8]"));

	}

	public boolean VerifyCompleted() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Completed = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Completed'])[1]")));
		System.out.println("completed Status Successful");
		return Completed.isDisplayed();
	}

	public void CompletedSaveastemplate() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

	}

	public boolean ValidSaveastemplate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Save As Template Document Successful");
		return Success.isDisplayed();

	}

	public void CompletedSharewithothers() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[normalize-space()='ramyasibbala200@outlook.com']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

		waitEle(By.xpath("//span[normalize-space()='Save & Update']"));

	}

	public boolean ValidCompletedSharewithothers() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Share With Users Successful");
		return Success.isDisplayed();
	}

	public void CompletedClonedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

	}

	public boolean ValidCompletedClonedocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Clone Document Successful");
		return Success.isDisplayed();
	}

	public void CompletedRenamedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[5]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();
		Thread.sleep(10000);

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document3 = wait.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("test");
		Thread.sleep(10000);

		waitEle(By.xpath("(//span[normalize-space()='Confirm'])[2]"));

	}

	public boolean ValidCompletedRenamedocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Rename Document Successful");
		return Success.isDisplayed();
	}

	public void CompletedDownloaddocuement() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[6]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//td[@class='el-table_3_column_17   el-table__cell']"));

		System.out.println("Download Document Successful");
		Thread.sleep(10000);
	}

	public void CompletedDeletedocuement() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[7]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

	}

	public boolean ValidCompletedDeletedocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Delete Document Successful");
		return Success.isDisplayed();
	}

	public void CompletedSenttomail() throws Exception {
		Perform();

		Thread.sleep(10000);

		waitEle(By.xpath("//ul[@x-placement]//a[8]"));

		waitEle(By.xpath("//input[@class='el-select__input']"));

		waitEle(By.xpath("//ul//li[text()=' ramyasibbala200@outlook.com ']"));
		Thread.sleep(1000);

		waitEle(By.xpath("//input[@class='el-select__input']"));

		waitEle(By.xpath("//span[normalize-space()='Send']"));

	}

	public boolean ValidCompletedSenttomail() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Sent to mail Successful");
		return Success.isDisplayed();
	}

	public void WaitingformeStatus() throws Exception {

		waitEle(By.xpath("//span[normalize-space()='Documents']"));

		waitEle(By.xpath("//input[@placeholder='Select Status']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[9]"));

		Thread.sleep(10000);

	}

	public boolean ValidWaitingforme() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[normalize-space()='Sent'])[1]")));
		System.out.println("Waitingforme Successful");
		return Success.isDisplayed();
	}

	public void WaitformeWaitforme() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

	}

	public void Waitingforotherstatus() throws Exception {

		waitEle(By.xpath("//span[normalize-space()='Documents']"));

		waitEle(By.xpath("//input[@placeholder='Select Status']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[10]"));

	}

	public boolean ValidWaitingforothers() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Void = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@x-placement]//ul//li[10]")));
		System.out.println("waiting for other Status Successful");
		return Void.isDisplayed();

	}

	public void WaitingForOthersCorrectdocument() throws Exception {

		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[2]"));

		Thread.sleep(10000);

	}

	public boolean ValidWaitingForOthersCorrectdocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Correct Document Successful");
		return Success.isDisplayed();
	}

	public void WaitingForOthersResenddocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[3]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Resend']"));
		//
//			waitTill(By.xpath("(//button//i)[15]"));

	}

	public boolean ValidWaitingForOthersResenddocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Resend Document Successful");
		return Success.isDisplayed();
	}

	public void WaitingForOthersSaveastemplate() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[4]"));

	}

	public boolean ValidWaitingForOthersSaveastemplate() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Save As Template Successful");
		return Success.isDisplayed();
	}

	public void WaitingForOthersVoiddocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[5]"));

		waitEle(By.xpath("//span[normalize-space()='Yes']"));

	}

	public boolean ValidWaitingForOthersVoiddocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Void Document Successful");
		return Success.isDisplayed();
	}

	public void WaitingForOthersRenamedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[6]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebElement document3 = wait.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("hfsdbjhdk");

		waitEle(By.xpath("(//span[normalize-space()='Confirm'])[2]"));

	}

	public boolean ValidWaitingForOthersRenamedocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Rename Document Successful");
		return Success.isDisplayed();
	}

	public void WaitingForOthersDocumentsettings() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[7]"));

		waitEle(By.xpath("//span[normalize-space()='Save']"));

	}

	public boolean ValidWaitingForOthersDocumentsettings() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Document Settings Successful");
		return Success.isDisplayed();
	}

	public void WaitingForOthersDeletedocument() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[8]"));

		waitEle(By.xpath("//span[normalize-space()='OK']"));

	}

	public boolean ValidWaitingForOthersDeletedocument() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Success = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='el-notification right']")));
		System.out.println("Delete Document Successful");
		return Success.isDisplayed();
	}

	public void WaitingForOthersDownloadoriginal() throws Exception {
		Perform();

		waitEle(By.xpath("//ul[@x-placement]//a[9]"));

		System.out.println("Download Original Successful");
	}

//		public void clickondocuments() throws InterruptedException {
//			
//			Thread.sleep(10000);
//			waitEle(By.xpath("//span[normalize-space()='Documents']"));
//		}
	public void BuldDelete() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[1]"));

		waitEle(By.xpath(
				"//button[@class='el-button el-dropdown-link px-2 el-button--default el-button--mini el-dropdown-selfdefine ']"));

		waitEle(By.xpath("//ul[@x-placement]//li[1]"));

		waitEle(By.xpath("(//button[@class='el-button el-button--primary'])[1]"));

	}
}
