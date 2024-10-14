package Pages;

import java.io.File;
import java.time.Duration;
import java.util.HashSet;
import java.util.Random;
//import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DocumentsScenarios1 {
	public static WebDriver driver;

	public DocumentsScenarios1(WebDriver driver) {

		DocumentsScenarios1.driver = driver;

	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public static void Javascriptclick(By xpath) throws Exception {
		Thread.sleep(3000);

		WebElement element = driver.findElement(xpath);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

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
	public void windowHandle() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
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

	public void waitAndClick(Actions actions, WebElement sourceElement, WebElement targetElement, int xOffset,
			int yOffset) {
		actions.clickAndHold(sourceElement).moveToElement(targetElement, xOffset, yOffset).release().build().perform();
	}

	public void sendKeysToElement(By by, CharSequence keysToSend) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(keysToSend);
	}

	public void nsui() {
		driver.get("https://nsui.esigns.io/signin");
	}

	public void SigninNSUIJeevitha() throws Exception {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("jeevithapatnana200@outlook.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Meghana@123");
		waitEle(By.xpath("//span[normalize-space()='Log In']"));
		Thread.sleep(10000);
	}

	public String generateUniqueId() {
		final int ID_LENGTH = 4;
		final int MAX_ID = (int) Math.pow(10, ID_LENGTH) - 1;
		final int MIN_ID = (int) Math.pow(10, ID_LENGTH - 1);
		Set<Integer> generatedIds = new HashSet<>();
		Random random = new Random();
		String prefix = null;
		if (generatedIds.size() >= (MAX_ID - MIN_ID + 1)) {
			throw new IllegalStateException("All possible IDs have been generated");
		}

		int newId;
		do {
			newId = random.nextInt((MAX_ID - MIN_ID) + 1) + MIN_ID;
		} while (generatedIds.contains(newId));

		generatedIds.add(newId);
		return prefix + newId;
	}

	public void clickLogout() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("(//div[@class=\"icon-text\"])[1]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//li[text()=\" Logout \"]"));
		Thread.sleep(10000);
	}

	public void SendDocumentInDocument() throws Exception {
		Thread.sleep(10000);
		try {
			waitEle(By.xpath("//span[normalize-space()=\"Send Document\"]"));
		} catch (Exception e) {
			waitEle(By.xpath("//span[text()=\"Fill fields\"]"));
		}
	}

	public void SubDoc(String s) throws Exception {

		System.out.println("click on send Doc after drag and drop done successfully");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By ele = By.xpath("//textarea[@placeholder='Subject']");
		WebElement sen = wait.until(ExpectedConditions.elementToBeClickable(ele));
		sen.sendKeys(s);
	}

	public void SubDocScenarios(String s) throws Exception {
		try {
			waitEle(By.xpath("//span[normalize-space()=\"Send Document\"]"));
		} catch (Exception e) {
			waitEle(By.xpath("//span[text()=\"Finish Document\"]"));
		}

		System.out.println("click on send Doc after drag and drop done successfully");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By ele = By.xpath("//textarea[@placeholder='Subject']");
		WebElement sen = wait.until(ExpectedConditions.elementToBeClickable(ele));
		sen.sendKeys(s);
	}

	public void DocScenario() throws Exception {
//		Thread.sleep(10000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
//		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
//
//		try {
//			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
//		} catch (Exception e) {
//
//			System.out.println("Overlay not found or not invisible.");
//		}
//		Thread.sleep(10000);
//		By ad = By.xpath("//span[normalize-space()='Documents']");
//
//		try {
//			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
//			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));
//
//			JavascriptExecutor executor = (JavascriptExecutor) driver;
//			executor.executeScript("arguments[0].click();", add);
//			WebElement docu = wait.until(ExpectedConditions
//					.presenceOfElementLocated(By.xpath("//h3[@class='fw-medium blue-dark mb-3 fs-6']")));
//			Assert.assertNotNull(docu, "Documents");
//			System.out.println("Clicked On Documents using JS successfully");
//
//		} catch (Exception e) {
//
//			System.out.println("Element not clickable or not found: ");
//		}
//		waitEle(By.xpath("//span[text()=\" Create Document \"]"));
//		System.out.println("Click on create Document Done Successfully");
		waitEle(By.xpath("//span[text()=\"Create Document\"]"));
		System.out.println("Click on create Document Done Successfully");

	}
	public void blankurl() throws Exception {
		Thread.sleep(2000);
		driver.get("https://nsui.esigns.io/documents/upload");

	}
	public void Blankloginaccount(String s) throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		try {
			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}
		Thread.sleep(10000);
		waitEle(By.xpath("//img[@src='/img/Blank.1f314c3f.svg']"));
		windowHandle();
		Thread.sleep(10000);

		By Docname1 = By.xpath("//input[@placeholder='Enter Document name']");
		WebElement Docnameen = wait.until(ExpectedConditions.elementToBeClickable(Docname1));
		Docnameen.sendKeys(s);

		driver.findElement(By.xpath("//span[normalize-space()='Continue']")).click();
		WebElement doc = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='fw-bold fs-24']")));
		Assert.assertNotNull(doc, "Add Recepient element is not present Create document failed");
		System.out.println("Selected BlankDocument successfully");

	}

	public void Recipient(int id, String contactType, String email, String signerType) throws Exception {
		try {
			waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));
			System.out.println("Click on Add recipient done Successfully");
			String xpath = String.format("//div[@id='user_%d']//input[@placeholder='Select contact type']", id);
			waitEle(By.xpath(xpath));
			String con = String.format("//div[@x-placement]//ul//li[normalize-space()='%s']", contactType);
			WebElement ele = driver.findElement(By.xpath(con));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", ele);
			System.out.println("Selected contact type Successfully");
		} catch (Exception e) {

		}
		String xpath2 = String.format("//div[@id='user_%d']//input[@placeholder='Search with Email']", id);
		waitEle(By.xpath(xpath2));
		Thread.sleep(3000);
		System.out.println("click on Search with email done Successfully");
		String xpath3 = String.format("//div[@x-placement]//li[normalize-space()=\"%s\"]", email);
		waitEle(By.xpath(xpath3));
		try {
			String xpath4 = String.format("//div[@id='user_%d']//input[@placeholder='Select Signer Type']", id);
			waitEle(By.xpath(xpath4));
			Thread.sleep(3000);
			String signertype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", signerType);
			waitEle(By.xpath(signertype));
			System.out.println("Selected Recipients Successfully");
		} catch (Exception e) {

		}
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
		waitEle(By.xpath(xpath));
		String con = String.format("//div[@x-placement]//ul//li[normalize-space()='%s']", contactType);
		waitEle(By.xpath(con));
		System.out.println("Selected contact type Successfully");

		String xpath2 = String.format("//div[@id='user_%d']//input[@placeholder='Search with Email']", id);
		waitEle(By.xpath(xpath2));
		sendKeysToElement(By.xpath(xpath2), email);

		String xpath3 = String.format("//span[text()='%s']", email);
		waitEle(By.xpath(xpath3));

		waitEle(By.xpath("//span[normalize-space()='Save Users']"));

		waitEle(By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]"));
		windowHandle();
		driver.findElement(By.xpath("//input[@placeholder=\"First name \"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"First name \"]"), Fname);
		driver.findElement(By.xpath("//input[@placeholder=\"Last name\"]")).clear();
		sendKeysToElement(By.xpath("//input[@placeholder=\"Last name\"]"), Lname);
		waitEle(By.xpath("//span[text()=\" Save \"]"));
		Thread.sleep(5000);
		String xpath4 = String.format("//div[@id='user_%d']//input[@placeholder='Select Signer Type']", id);
		waitEle(By.xpath(xpath4));
		Thread.sleep(3000);
		String signertype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", signerType);
		waitEle(By.xpath(signertype));
		System.out.println("Selected Recipients Successfully");

	}

	public void addContactAtAddrecipient2(int id, String contactType, String email, String Fname, String Lname,
			String signerType) throws Exception {
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));
		System.out.println("Click on Add recipient done Successfully");
		String xpath = String.format("//div[@id='user_%d']//input[@placeholder='Select contact type']", id);
		waitEle(By.xpath(xpath));
		String con = String.format("//div[@x-placement]//ul//li[normalize-space()='%s']", contactType);
		waitEle(By.xpath(con));
		System.out.println("Selected contact type Successfully");

		String xpath2 = String.format("//div[@id='user_%d']//input[@placeholder='Search with Email']", id);
		waitEle(By.xpath(xpath2));
		sendKeysToElement(By.xpath(xpath2), email);

		String xpath3 = String.format("//span[text()='%s']", email);
		waitEle(By.xpath(xpath3));

		waitEle(By.xpath("//span[normalize-space()='Save Users']"));
	}

	public void Signorder() throws Exception {

		waitEle(By.xpath("//span[normalize-space()='Enforce Signature Order']"));
		System.out.println("Click on enforce signature done");
	}

	public void EssentialFields() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

		Actions actions = new Actions(driver);

		WebElement Sign = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions, Sign, Target);
		System.out.println("Sign Element Drag and Drop Done");

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		waitEle(By.xpath("//div[@x-placement]//li[2]"));

		// fullNameEle
		WebElement fullName = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		// companyEle
		WebElement company = driver.findElement(By.xpath("//button[@id='companyEle']"));

		waitAndClick(actions, fullName, Target);
		System.out.println("Fullname Element Drag and Drop Done");

		waitAndClick(actions, company, Target);
		System.out.println("company Element Drag and Drop Done");

	}

	public void clickFinishDoc() throws Exception {
		Thread.sleep(5000);
		waitEle(By.xpath("//span[text()=\"Finish Document\"]"));
	}

	public void clickSubmit() throws Exception {
		Javascriptclick(By.xpath("//span[normalize-space()='Send Document']"));
	}

	public boolean Verifysubmit() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement name = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()=\"Document Sent \"]")));
		System.out.println("Sent Document Sucessfully");
		return name.isDisplayed();
	}

	public void Saveuser() throws Exception {

		waitEle(By.xpath("//span[normalize-space()='Save Users']"));
		System.out.println("Recipients added successfully");

	}

	public void DocscenarioOnedrive() throws Exception {
		Thread.sleep(20000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		waitEle(By.xpath("//img[@src='/img/onedrive.cc38d634.svg']"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(5000);
		String Parentwindowid = driver.getWindowHandle();

		waitEle(By.xpath("//button[normalize-space()='Connect OneDrive']"));
		Thread.sleep(5000);

		Set<String> allwindowhandles = driver.getWindowHandles();
		for (String childwindow : allwindowhandles) {
			if (!childwindow.endsWith(Parentwindowid)) {
				driver.switchTo().window(childwindow);
				driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("bsrv.prudhviraju@outlook.com");

				waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));

				Thread.sleep(10000);

				By password = By.xpath("//input[@id='i0118']");
				WebElement Upload1 = wait.until(ExpectedConditions.elementToBeClickable(password));
				Upload1.sendKeys("Prjking@99");

				waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
				try {
					waitEle(By.xpath("//button[normalize-space()='Yes']"));
				} catch (Exception e) {
					// TODO: handle exception
				}

				Thread.sleep(5000);
				Set<String> windowHandles1 = driver.getWindowHandles();
				for (String handle : windowHandles1) {
					driver.switchTo().window(handle);
				}

				waitEle(By.xpath("//span//span[normalize-space()='Getting started with OneDrive.pdf']"));

				waitEle(By.xpath("//span[@class=\"fsp-footer__nav--right\"]"));

				waitEle(By.xpath("//span[normalize-space()='Next']"));

			}
		}
	}

	public void DocscenariosGdrive() throws Exception {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//img[@placeholder=\"top-start\"]")).click();
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		String Parentwindowid = driver.getWindowHandle();
		driver.findElement(By.xpath("//span[normalize-space()=\"Sign in with Google\"]")).click();
		Set<String> allwindowhandles = driver.getWindowHandles();
		for (String childwindow : allwindowhandles) {
			if (!childwindow.endsWith(Parentwindowid)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(10000);
				driver.findElement(By.xpath("//input[@id=\"identifierId\"]")).sendKeys("n180894@rguktn.ac.in");

				driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]")).click();
				Thread.sleep(10000);
				Set<String> windowHandles1 = driver.getWindowHandles();
				for (String handle : windowHandles1) {
					driver.switchTo().window(handle);

				}
				driver.findElement(By.xpath("//input[@name=\"Passwd\"]")).sendKeys("meghu@123");
				driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]")).click();
				Thread.sleep(10000);
				Set<String> windowHandles11 = driver.getWindowHandles();
				for (String handle : windowHandles11) {
					driver.switchTo().window(handle);

				}
				Thread.sleep(10000);
				driver.findElement(By.xpath("//span[normalize-space()=\"Continue\"]")).click();
				driver.findElement(By.xpath("//span[normalize-space()=\"Allow\"]")).click();
				Thread.sleep(10000);
				Set<String> windowHandles111 = driver.getWindowHandles();
				for (String handle : windowHandles111) {
					driver.switchTo().window(handle);

				}
				driver.findElement(By.xpath("//span[normalize-space()=\"N180894-resume.pdf\"]")).click();
				Thread.sleep(10000);
				Set<String> windowHandles2 = driver.getWindowHandles();
				for (String handle : windowHandles2) {
					driver.switchTo().window(handle);

				}
				driver.findElement(By.xpath("//span[@class=\"fsp-button fsp-button--primary fsp-button-upload\"]"))
						.click();
				Thread.sleep(10000);
				waitEle(By.xpath("//span[normalize-space()='Next']"));

			}
		}
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

	public void selectRecipientForDragAndDrop(int n) throws Exception {
		Thread.sleep(20000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(5000);
		String xpath = String.format("//div[@x-placement]//li[%d]", n);
		Javascriptclick(By.xpath(xpath));

	}

	public void SignatureAndFullNameFeilds() throws Exception {
		Thread.sleep(5000);
		Actions actions1 = new Actions(driver);

		WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		WebElement signElement = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		waitAndClick(actions1, signElement, targetElement, 10, -100);
		System.out.println("Signature Element Drag and Drop Done");

		WebElement fullNameElement = driver.findElement(By.xpath("//button[@id='fullNameEle']"));
		waitAndClick(actions1, fullNameElement, targetElement, 10, -70);
		System.out.println("FullName Drag and Drop Done");
	}

	public void Rearranges(int id1, int id2) throws Exception {
		String xpath1 = String.format("//div[@id='user_%d']", id1);
		String xpath2 = String.format("//div[@id='user_%d']", id2);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement CC = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath1)));
		WebElement Signer = driver.findElement(By.xpath(xpath2));
		Actions actions = new Actions(driver);

		actions.clickAndHold(CC).moveToElement(Signer).release().build().perform();
		System.out.println("Rearrangement done");
	}

	public void scrollDown() throws Exception {

		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@class='select-recipients']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 100;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();
		System.out.println("ScrollDown done successfully");
	}

	public void scrollUp() {
		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@class='select-recipients']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 0;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();
		System.out.println("ScrollUp done successfully");
	}

	public void scrollToCertainPosition(int n) throws Exception {
		Thread.sleep(10000);
		String xpath = String.format("(//input[@placeholder=\"Phoneno\"])[%d]", n);
		WebElement scroll = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scroll);

		System.out.println("ScrollDown done successfully");
	}

	public void nextButton() throws Exception {
		Thread.sleep(5000);
		try {
			driver.findElement(By.xpath("//button[@class='el-button text-center upload-btn el-button--danger']"))
					.click();
		} catch (Exception e) {
			System.out.println("File Unable to upload");

		}
	}

	@SuppressWarnings("deprecation")
	public void Fileuploads(String s) throws InterruptedException, Exception {
		Thread.sleep(10000);
		By Element = By.xpath("//h4[@class='fw-normal blue pb-2']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));
		canc.click();
		Runtime.getRuntime().exec(s);

	}

	public void VerifyFileUploadSucess() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()=\"Add Recipients\"]")));

		Assert.assertNotNull(welcomeMessage, "Welcome message element is not present upload Failed");
		System.out.println("File Upload Successful");
	}

	public void changeDoc() throws Exception {
		Thread.sleep(5000);
		waitEle(By.xpath("//img[@src=\"/img/Icon-ellipsis-v.eb3a1342.svg\"]"));
		waitEle(By.xpath("//li[normalize-space()=\"Change Document\"]"));
		waitEle(By.xpath("//div[@class=\"el-upload el-upload--text\"]"));

	}

	public void clickContinue() throws Exception {
		waitEle(By.xpath("//span[contains(text(),\"Continue\")]"));
	}

	public void dragRequestDocFeild() throws Exception {
		Thread.sleep(5000);
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		Actions actions = new Actions(driver);
		WebElement reqDoc = driver.findElement(By.id("requestEle"));
		Thread.sleep(10000);
		actions.clickAndHold(reqDoc).moveToElement(Target).release().build().perform();
		WebElement Doubleclick = driver.findElement(By.xpath("//p[contains(text(),\" Attachment 1 \")]"));
		Actions action = new Actions(driver);
		action.doubleClick(Doubleclick).build().perform();

		WebElement upload = driver.findElement(By.xpath("//div[@class=\"el-upload el-upload--text\"]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", upload);
		Thread.sleep(5000);
		upload.click();

	}

	public void save() throws Exception {
		waitEle(By.xpath("(//span[text()=\"Save\"])[2]"));

	}

	public void viewDocandDownload() throws Exception {
//		waitEle(By.xpath("//span[contains(text(),\"View Document\")]"));
		waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));
		waitEle(By.xpath("//span[contains(text(),\"Attachments \")]"));

		Thread.sleep(5000);
		waitEle(By.xpath(
				"//tr[@class=\"el-table__row\"]//td[@class=\"el-table_3_column_22   el-table__cell\"]//span[normalize-space()=\"Download\"]"));
		System.out.println("Download Succesfull");
	}

	public void DragContentFeildsCompanyProfile() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//div[text()=\"templateContentFeilds\"]"));
		// paragraph
		Actions actions = new Actions(driver);
		WebElement para = driver.findElement(By.xpath("//div[text()=\" paragraph \"]"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		waitAndClick(actions, para, Target, 0, -40);
		System.out.println("paragraph Field Drag and Drop Done");
		System.out.println(Target.getSize());
		// Image
		WebElement image = driver.findElement(By.xpath("//div[text()=\" ImageF... \"]"));
		waitAndClick(actions, image, Target, -200, -30);
		System.out.println("Image Field Drag and Drop Done");
		// Video
		WebElement video = driver.findElement(By.xpath("//div[text()=\" videoF... \"]"));
		waitAndClick(actions, video, Target, 0, 0);
		System.out.println("video Field Drag and Drop Done");
		// HTML
		WebElement html = driver.findElement(By.xpath("//div[text()=\" HTMLFe... \"]"));
		waitAndClick(actions, html, Target, 0, 30);
		System.out.println("HTML Field Drag and Drop Done");
		// division
		WebElement division = driver.findElement(By.xpath("//div[text()=\" division \"]"));
		waitAndClick(actions, division, Target, 0, 60);
		System.out.println("Division Field Drag and Drop Done");
		// Heading
		WebElement heading = driver.findElement(By.xpath("//div[text()=\" Headin... \"]"));
		waitAndClick(actions, heading, Target, 0, 90);
		System.out.println("heading Field Drag and Drop Done");
		// Single line Content
		WebElement SingleLineContent = driver.findElement(By.xpath("//div[text()=\" single_line_content \"]"));
		waitAndClick(actions, SingleLineContent, Target, 0, 120);
		System.out.println("SingleLineContent Field Drag and Drop Done");
		// Horizontalline
		WebElement Hline = driver.findElement(By.xpath("//div[text()=\" horizontal_line \"]"));
		waitAndClick(actions, Hline, Target, 0, 150);
		System.out.println("Horizontal Line Field Drag and Drop Done");
		// Action
		WebElement action = driver.findElement(By.xpath("//div[text()=\" Action... \"]"));
		waitAndClick(actions, action, Target, 0, 180);
		System.out.println("Action Field Drag and Drop Done");

	}

	public void DragAndDropContentFeildsInDocument() throws Exception {
		String feilds[] = { "Paragraph", "ImageFeild", "VideoFeild", "HTMLfeild", "Division", "HeadingFeild",
				"SingleLineContent", "HorizontalLine", "Action" };
		int l = feilds.length;
		Thread.sleep(5000);

		WebElement element = driver.findElement(By.xpath("//div[text()=\"templateContentFeilds\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		waitEle(By.xpath("//div[text()=\"templateContentFeilds\"]"));
		Thread.sleep(5000);
		int i = 1;
		for (int x = -250; x <= 250; x = x + 250) {
			for (int y = -80; y <= 210; y = y + 50) {
				String xpath = String.format("(//button[@class=\"el-tooltip field-element tooltip\"])[%d]", i++);
				if (i <= l + 1) {
					Actions actions = new Actions(driver);
					WebElement ele = driver.findElement(By.xpath(xpath));
					WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
					waitAndClick(actions, ele, Target, x, y);
					System.out.printf("%s Field Drag and Drop Done\n", feilds[i - 2]);
				} else {
					break;
				}
			}
		}
	}

	public void DragAndDropBasicFeildsInDocument() throws Exception {
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
				String xpath = String.format("(//button[@class=\"el-tooltip field-element tooltip\"])[%d]", i++);
				if (i <= l + 1) {
					Actions actions = new Actions(driver);
					WebElement ele = driver.findElement(By.xpath(xpath));
					WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
					waitAndClick(actions, ele, Target, x, y);
					System.out.printf("%s Field Drag and Drop Done\n", feilds[i - 2]);
				} else {
					break;
				}
			}
		}
	}

	public void DragAndDropFeildsInDocument(String templateName, String arr[]) throws Exception {
		String feilds[] = arr;
		int l = feilds.length;
		System.out.println(l);
		Thread.sleep(5000);

		String TName = String.format("//div[text()=\"%s\"]", templateName);
		waitEle(By.xpath(TName));
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
		waitEle(By.xpath(TName));
	}

	public void DragAndDropFeildsInDocumentUsingId(String arr[]) throws Exception {
		String feilds[] = arr;
		int l = feilds.length;
//		System.out.println(l);
		Thread.sleep(10000);
		int i = 1;
		for (int x = -250; x <= 250; x = x + 250) {
			for (int y = -80; y <= 210; y = y + 50) {
				if (i > l) {
					break;
				}
				String xpath = String.format("//button[@id='%s']", feilds[i - 1]);
				WebElement element = driver.findElement((By.xpath(xpath)));

				Actions actions = new Actions(driver);
				WebElement target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
				waitAndClick(actions, element, target, x, y);
				System.out.printf("%s Field Drag and Drop Done\n", feilds[i - 1]);
				i++;
			}
		}
	}

	public void DragBasicFeildsCompanyProfile() throws Exception {
		Thread.sleep(5000);
		waitEle(By.xpath("//div[text()=\"templateBasicFeilds\"]"));
		Thread.sleep(5000);
		// Document
		Actions actions = new Actions(driver);
		WebElement Document = driver.findElement(By.xpath("//div[text()=\" Docume... \"]"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		waitAndClick(actions, Document, Target, 0, -80);
		System.out.println("Document Field Drag and Drop Done");

		// multiline
		WebElement multiline = driver.findElement(By.xpath("//div[text()=\" Multil... \"]"));
		waitAndClick(actions, multiline, Target, 0, 0);
		System.out.println("multiline Field Drag and Drop Done");
		// sign
		WebElement sign = driver.findElement(By.xpath("//div[text()=\" Sign \"]"));
		waitAndClick(actions, sign, Target, 0, 30);
		System.out.println("sign Field Drag and Drop Done");
		// phoneno
		WebElement phoneno = driver.findElement(By.xpath("//div[text()=\" Phonen... \"]"));
		waitAndClick(actions, phoneno, Target, 0, 60);
		System.out.println("phoneno Field Drag and Drop Done");
		// captcha
//		WebElement captcha = driver.findElement(By.xpath("//div[text()=\" Captch... \"]"));
//		waitAndClick(actions, captcha, Target, 0, 90);
//		System.out.println("captcha Field Drag and Drop Done");
		// singleLine
		WebElement singleLine = driver.findElement(By.xpath("//div[text()=\" Single... \"]"));
		waitAndClick(actions, singleLine, Target, 0, 120);
		System.out.println("singleLine Field Drag and Drop Done");
		// checkbox
		WebElement checkboxGroup = driver.findElement(By.xpath("//div[text()=\" checkb... \"]"));
		waitAndClick(actions, checkboxGroup, Target, 0, 150);
		System.out.println("checkboxGroup Field Drag and Drop Done");
		// list
		WebElement list = driver.findElement(By.xpath("//div[text()=\" list \"]"));
		waitAndClick(actions, list, Target, 0, 180);
		System.out.println("list Field Drag and Drop Done");
		// Multiselect
		WebElement Multiselect = driver.findElement(By.xpath("//div[text()=\" Multis... \"]"));
		waitAndClick(actions, Multiselect, Target, -250, 90);
		System.out.println("Multiselect Field Drag and Drop Done");
		// Radio Group
		WebElement RadioGroup = driver.findElement(By.xpath("//div[text()=\" RadioG... \"]"));
		waitAndClick(actions, RadioGroup, Target, -250, -80);
		System.out.println("Radio Group Field Drag and Drop Done");
		// Date
		WebElement Date = driver.findElement(By.xpath("//div[text()=\" Date \"]"));
		waitAndClick(actions, Date, Target, -250, -30);
		System.out.println("Date Field Drag and Drop Done");

		// Time
		WebElement Time = driver
				.findElement(By.xpath("//button[@class=\"el-tooltip field-element tooltip\"]//div[text()=\" Time \"]"));
		waitAndClick(actions, Time, Target, -250, 0);
		System.out.println("Time Field Drag and Drop Done");
		// Select
		WebElement Select = driver.findElement(
				By.xpath("//button[@class=\"el-tooltip field-element tooltip\"]//div[text()=\" Select \"]"));
		waitAndClick(actions, Select, Target, -250, 30);
		System.out.println("Select  Field Drag and Drop Done");
		// FixedTime
		WebElement FixedTime = driver.findElement(By.xpath("//div[text()=\" FixedT... \"]"));
		waitAndClick(actions, FixedTime, Target, -250, 60);
		System.out.println("FixedTime Field Drag and Drop Done");
		// TimeRange
//		WebElement TimeRange = driver.findElement(By.xpath("//div[text()=\" TimeRa... \"]"));
//		waitAndClick(actions, TimeRange, Target, -250, 90);
//		System.out.println("TimeRange Field Drag and Drop Done");
		// number
		WebElement number = driver.findElement(
				By.xpath("//button[@class=\"el-tooltip field-element tooltip\"]//div[text()=\" Number \"]"));
		waitAndClick(actions, number, Target, 250, -80);
		System.out.println("number Field Drag and Drop Done");
		// Checkbox group
		WebElement Checkbox = driver.findElement(By.xpath("//div[text()=\" Checkb... \"]"));
		waitAndClick(actions, Checkbox, Target, 250, 40);
		System.out.println("Checkbox Field Drag and Drop Done");
		// Radio
//		WebElement Radio = driver.findElement(By.xpath("//div[text()=\" Radio \"]"));
//		waitAndClick(actions, Radio, Target, 250, 70);
//		System.out.println("Radio Field Drag and Drop Done");

		// yesOrNo
		WebElement yesOrNo = driver.findElement(By.xpath("//div[text()=\" YesorN... \"]"));
		waitAndClick(actions, yesOrNo, Target, 250, 100);
		System.out.println("yesOrNo Field Drag and Drop Done");
		// DateTime
		WebElement DateTime = driver.findElement(By.xpath("//div[text()=\" DateTi... \"]"));
		waitAndClick(actions, DateTime, Target, 250, 130);
		System.out.println("DateTime Field Drag and Drop Done");
		// DateRange
		Thread.sleep(2000);
		WebElement DateRange = driver.findElement(By.xpath("//div[text()=\" DateRa... \"]"));
		waitAndClick(actions, DateRange, Target, 250, 160);
		System.out.println("DateRange Field Drag and Drop Done");
		// Weekday
		WebElement Weekday = driver.findElement(By.xpath("//div[text()=\" Weekda... \"]"));
		waitAndClick(actions, Weekday, Target, 250, 190);
		System.out.println("Weekday Field Drag and Drop Done");
		waitEle(By.xpath("//div[text()=\"templateBasicFeilds\"]"));
	}

	public void Viewdocument() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='View Document']"));

		System.out.println("View Document successfull");
		Thread.sleep(10000);
	}

	public void Blankwithoutsenderautofill() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));

		System.out.println("mySignatureEle Element opened With Double Click and Entered New Sign Data Successfully");

		waitEle(By.xpath("//span[normalize-space()='FINISH']"));
		System.out.println("Finished document successfully on sender side");
		Thread.sleep(10000);
	}

	public void loginAccountDocumentClick() throws Exception {
		waitEle(By.xpath("//p[text()=\"Waiting for Me\"]"));
		Thread.sleep(20000);
		String path = String.format(
				"//div[@class='el-table__fixed-body-wrapper']//tr[@class='el-table__row']//a[contains(text(), ' DocScenarios ')]");
		Javascriptclick(By.xpath(path));

	}

	public void autofilloff() throws Exception {
		Thread.sleep(5000);
		waitEle(By.xpath("(//div[@class=\"icon-text\"])[1]"));
		Thread.sleep(5000);
		Javascriptclick(By.xpath("//li[text()=\" Settings \"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//a[text()=\"Application Settings\"]"));
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
		waitEle(By.xpath("(//div[@class=\"icon-text\"])[1]"));
		Thread.sleep(5000);
		Javascriptclick(By.xpath("//li[text()=\" Settings \"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//a[text()=\"Application Settings\"]"));
		Thread.sleep(5000);
		WebElement element = driver
				.findElement(By.xpath("//span[text()=\" Auto-complete sender if all fields filled\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			waitEle(By.xpath(
					"//label[@class=\"el-checkbox\"]//span[text()=\" Auto-complete sender if all fields filled\"]"));
			System.out.println("autofill is on");

		} catch (Exception e) {
			System.out.println("Autofill is already on");
		}
		waitEle(By.xpath("//span[text()=\"Save Changes\"]"));
	}

	public void Updateafterdocumentcompletionfromsettings(int num) throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//div[text()=\" Meghana PM \"]"));

		Thread.sleep(10000);

		By ad = By.xpath("//li[normalize-space()='Settings'] ");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on Settings using JS.");

		waitEle(By.xpath("//a[text()=\"Application Settings\"]"));
		Thread.sleep(5000);
		SettingsExpirationAndRemainder(num);

	}

	public void SettingsExpirationAndRemainder(int num) throws Exception {
		Thread.sleep(20000);
		String s = String.format("(//span[@class=\"el-radio__inner\"])[%d]", num);

		WebElement checkbox = driver.findElement(By.xpath(s));
		boolean isChecked = checkbox.isSelected();

		if (!isChecked) {
			checkbox.click();
			System.out.println("Checkbox was unchecked. Now it's checked.");
		} else {
			System.out.println("Checkbox was already checked. No action taken.");
		}

		waitEle(By.xpath("//span[text()=\"Save Changes\"]"));
	}

//	public void FileuploadTwo() throws InterruptedException, Exception {
//		Thread.sleep(5000);
//
//		Runtime.getRuntime()
//				.exec("\"C:\\Users\\meghana.pemma\\OneDrive - Nimble Accounting\\Desktop\\fileupload.exe\"");
//		Thread.sleep(5000);
//
//		System.out.println("Uploaded file successfully");
//	}

	public void uploadFileWithSendKeys(String Path) throws InterruptedException {
		Thread.sleep(10000);
		File uploadFile = new File(Path);

		WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = '';", fileInput);
		fileInput.sendKeys(uploadFile.getAbsolutePath());

	}

	public void uploadFileTwoWithSendKeys(String imagePath) throws InterruptedException {
		Thread.sleep(10000);
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		fileInput.sendKeys(imagePath);
	}

	public void uploadFileTwoWithSendKeyss(String imagePath) throws InterruptedException {
		Thread.sleep(10000);

		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		fileInput.clear();
		fileInput.sendKeys(imagePath);

	}

	public void reviewandSignSigner() throws Exception {
		Thread.sleep(10000);
		WebElement copy = driver.findElement(By.xpath("//td[@class=\"x_featured-story__content-inner\"]//span"));

		Actions action2 = new Actions(driver);
		action2.doubleClick(copy).build().perform();
		Thread.sleep(10000);
		Actions actions = new Actions(driver);
		actions.moveToElement(copy).keyDown(Keys.CONTROL) // Press Ctrl key
				.sendKeys("c") // Press C key
				.keyUp(Keys.CONTROL) // Release Ctrl key
				.build().perform();

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		String Parentwindowid1 = driver.getWindowHandle();
		waitEle(By.xpath("//a[text()=\"Review & sign\"]"));
		Thread.sleep(10000);
		Set<String> allwindowhandles1 = driver.getWindowHandles();
		for (String childwindow : allwindowhandles1) {
			if (!childwindow.endsWith(Parentwindowid1)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(10000);
				driver.switchTo().window(Parentwindowid1).close();
				driver.switchTo().window(childwindow);

				Thread.sleep(10000);
				waitEle(By.xpath("//input[@placeholder=\"Enter 6 letters code\"]"));
				WebElement paste = driver.findElement(By.xpath("//input[@placeholder=\"Enter 6 letters code\"]"));

				actions.moveToElement(paste).keyDown(Keys.CONTROL) // Press Ctrl key
						.sendKeys("v") // Press v key
						.keyUp(Keys.CONTROL) // Release Ctrl key
						.build().perform();
				waitEle(By.xpath("//div[@class=\"el-form-item__content\"]//span[text()=\"Submit\"]"));

			}
		}

		try {
			Thread.sleep(10000);
			waitEle(By.xpath("//span[@class=\"el-checkbox__inner\"]"));
			waitEle(By.xpath("//span[text()=\"Continue\"]"));
//			waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
		} catch (Exception e) {
			Thread.sleep(10000);
			waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
		}
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
//		Javascriptclick(By.xpath("//span[normalize-space()='Edit']"));
//		sendKeysToElement(By.xpath("//input[@placeholder='Enter signature']"), "Meghana");
//
//		waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));
		Thread.sleep(5000);
		waitEle(By.xpath("//span[text()=\"FINISH\"]"));
		System.out.println("Review and Sign successful");

	}

	public void ramyaOutlooklogin() throws Exception {
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
		switchEmail();
		sendKeysToElement(By.xpath("//input[@id=\"i0116\"]"), "ramyasibbala200@outlook.com");
		try {
			waitEle(By.xpath("//input[@id=\"idSIButton9\"]"));
		} catch (Exception e) {
			waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		}

		sendKeysToElement(By.xpath("//input[@placeholder=\"Password\"]"), "Meghana@123");
		waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		waitEle(By.xpath("//button[@id=\"declineButton\"]"));
		System.out.println("Ramya200 Login successfull");
	}

	public void meghana894Outlooklogin() throws Exception {
		Thread.sleep(10000);
		driver.get(
				"https://login.live.com/login.srf?wa=wsignin1.0&rpsnv=150&ct=1714114815&rver=7.0.6738.0&wp=MBI_SSL&wreply=https%3a%2f%2foutlook.live.com%2fowa%2f%3fnlp%3d1%26cobrandid%3dab0455a0-8d03-46b9-b18b-df2f57b9e44c%26culture%3den-us%26country%3dus%26RpsCsrfState%3d1425546c-12db-9db8-7947-044bdf3da8dc&id=292841&aadredir=1&whr=outlook.com&CBCXT=out&lw=1&fl=dob%2cflname%2cwld&cobrandid=ab0455a0-8d03-46b9-b18b-df2f57b9e44c");
		switchEmail();
		sendKeysToElement(By.xpath("//input[@id=\"i0116\"]"), "meghanan180894@outlook.com");
		try {
			waitEle(By.xpath("//input[@id=\"idSIButton9\"]"));
		} catch (Exception e) {
			waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		}

		sendKeysToElement(By.xpath("//input[@placeholder=\"Password\"]"), "Meghana@123");
		waitEle(By.xpath("//button[@id=\"idSIButton9\"]"));
		waitEle(By.xpath("//button[@id=\"declineButton\"]"));
		System.out.println("Meghana894 Login Successfull");
	}

	private void switchEmail() {
		// TODO Auto-generated method stub

	}

	public void addPageAndClickOnPageTwoInDoc() throws Exception {
		waitEle(By.xpath("//button[@class=\"el-button el-tooltip add-page-bottom item el-button--default is-plain\"]"));
		waitEle(By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//canvas[@id='0_canvas_page_2']"));

	}

	public void fillEssentialFieldsInDocBeforeSendDoc(int n) throws Exception {
		Thread.sleep(10000);
		// single line text
		String a = String.format("//div[@class=\"form-fields-holder\"]//div[@data-text=\"Single Line Text %d\"]", n);
		waitEle(By.xpath(a));
		Thread.sleep(10000);
		waitEle(By.xpath(a));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "arguments[0].value='Your text here';";
		js.executeScript(script, a);
		// check box
		String b = String.format("(//div[@class=\"form-fields-holder\"]//input[@type=\"checkbox\"])[%d]", n);
		waitEle(By.xpath(b));
		// title
		String c = String.format("//div[@class=\"form-fields-holder\"]//div[@data-text=\"Title %d\"]", n);
		driver.findElement(By.xpath(c)).clear();
		sendKeysToElement(By.xpath(c), "Manager");
		// company
		try {
			String d = String.format("//div[@class=\"form-fields-holder\"]//div[@data-text=\"Company %d\"]", n);
			driver.findElement(By.xpath(d)).clear();
			sendKeysToElement(By.xpath(d), "Meghana Solutions");
		} catch (Exception e) {

		}
		// address
		String addressField = String.format("//div[@class=\"form-fields-holder\"]//div[@data-text=\"Address %d\"]", n);
		driver.findElement(By.xpath(addressField)).clear();
		sendKeysToElement(By.xpath(addressField), "6/17,BalijagaddaStreet,gurramkonda,annamyya District,Ap.");

	}

	public void FillDocumentField() throws Exception {
		waitEle(By.xpath("//p[text()=\" Attachment 1 \"]"));

		String pdffile = System.getProperty("user.dir") + "\\src\\test\\resources\\TESTING.pdf";
		Thread.sleep(10000);
		WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		fileInput.sendKeys(pdffile);
		System.out.println("Uploaded file successfully");
	}

	public void FillRequestDocument() throws Exception {
		waitEle(By.xpath("//div[@data-text=\"Attachment 1\"]"));
		WebElement Doubleclick = driver.findElement(By.xpath("//div[@data-text=\"Attachment 1\"]"));
		Actions action = new Actions(driver);
		action.doubleClick(Doubleclick).build().perform();
		WebElement upload = driver.findElement(By.xpath("//div[@class=\"el-upload el-upload--text\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", upload);
		String pdffile = System.getProperty("user.dir") + "\\src\\test\\resources\\TESTING.pdf";
		Thread.sleep(10000);
		WebElement fileInput = driver.findElement(By.xpath("//input[@type=\"file\"]"));
		fileInput.sendKeys(pdffile);
		Thread.sleep(5000);
		waitEle(By.xpath("(//span[text()=\"Save\"])[2]"));
		System.out.println("Uploaded file successfully");
	}

	public void fillableFieldsDragAndDrop() throws Exception {

		Thread.sleep(20000);
		try {
			WebElement filableFields = driver
					.findElement(By.xpath("(//div[@class=\"el-collapse-item is-active\"])[3]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", filableFields);
		} catch (Exception e) {
			WebElement filableFields = driver
					.findElement(By.xpath("(//div[@class=\"el-collapse-item is-active\"])[2]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", filableFields);

		}

		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		Actions actions = new Actions(driver);
		// fillable fields
		// Request Document
		WebElement reqDoc = driver.findElement(By.id("requestEle"));
		waitAndClick(actions, reqDoc, Target, -300, -80);
		System.out.println("Request Document field drag and drop done successfully");
		// Date
		WebElement date = driver.findElement(By.id("dateEle"));
		waitAndClick(actions, date, Target, -300, -50);
		System.out.println("Date field drag and drop done successfully");
		// select
		WebElement Select = driver.findElement(By.xpath("//button[@id=\"dropdownEle\"]"));
		waitAndClick(actions, Select, Target, -300, -20);
		sendKeysToElement(By.xpath("//input[@placeholder=\"options\"]"), "a");
		Javascriptclick(By.xpath("//div[@x-placement]//li"));
		try {
			sendKeysToElement(By.xpath("//input[@class=\"el-select__input\"]"), "b");
		} catch (Exception e) {
			sendKeysToElement(By.xpath("(//input[@class=\"el-select__input\"])[2]"), "b");

		}
		Javascriptclick(By.xpath("//div[@x-placement]//li"));
		try {
			sendKeysToElement(By.xpath("//input[@class=\"el-select__input\"]"), "c");
		} catch (Exception e) {
			sendKeysToElement(By.xpath("(//input[@class=\"el-select__input\"])[2]"), "c");

		}
		Javascriptclick(By.xpath("//div[@x-placement]//li"));
		try {
			sendKeysToElement(By.xpath("//input[@class=\"el-select__input\"]"), "d");
		} catch (Exception e) {
			sendKeysToElement(By.xpath("(//input[@class=\"el-select__input\"])[2]"), "d");

		}
		Javascriptclick(By.xpath("//div[@x-placement]//li"));
		Javascriptclick(By.xpath("//div[@class='el-dialog__wrapper fields-dialog']//button[2]"));
		System.out.println("select field drag and drop done successfully");
		// number
		WebElement num = driver.findElement(By.id("numberEle"));
		waitAndClick(actions, num, Target, -300, 10);
		System.out.println("number field drag and drop done successfully");
		// yesOrNo
		WebElement yesOrNoEle = driver.findElement(By.id("yesOrNoEle"));
		waitAndClick(actions, yesOrNoEle, Target, -300, 40);
		System.out.println("yesOrNo field drag and drop done successfully");
		// multiLineText
		WebElement multiLineTextEle = driver.findElement(By.id("multiLineTextEle"));
		waitAndClick(actions, multiLineTextEle, Target, -300, 100);
		System.out.println("multiLineText field drag and drop done successfully");
		// multiSlecte

		WebElement multiSlectedEle = driver.findElement(By.id("multiSlectedEle"));
		waitAndClick(actions, multiSlectedEle, Target, -300, 140);
		sendKeysToElement(
				By.xpath("//div[@class='el-col el-col-22']//div[@class='el-select__tags']//input[@type='text']"), "a");
		Javascriptclick(By.xpath("//div[@x-placement]//li"));
		sendKeysToElement(
				By.xpath("//div[@class='el-col el-col-22']//div[@class='el-select__tags']//input[@type='text']"), "b");
		Javascriptclick(By.xpath("//div[@x-placement]//li"));
		sendKeysToElement(
				By.xpath("//div[@class='el-col el-col-22']//div[@class='el-select__tags']//input[@type='text']"), "c");
		Javascriptclick(By.xpath("//div[@x-placement]//li"));
		sendKeysToElement(
				By.xpath("//div[@class='el-col el-col-22']//div[@class='el-select__tags']//input[@type='text']"), "d");
		Javascriptclick(By.xpath("//div[@x-placement]//li"));
		waitEle(By.xpath("//div[@class='el-dialog__wrapper fields-dialog']//button[2]"));
		System.out.println("multiSlecte field drag and drop done successfully");
		// formula

		WebElement num1 = driver.findElement(By.id("numberEle"));
		waitAndClick(actions, num1, Target, -300, 170);
		WebElement num2 = driver.findElement(By.id("numberEle"));
		waitAndClick(actions, num2, Target, -300, 200);
		WebElement formulaEle = driver.findElement(By.id("formulaEle"));
		waitAndClick(actions, formulaEle, Target, -300, 230);
		waitEle(By.xpath("//input[@placeholder='Select Fields']"));
		Javascriptclick(By.xpath("//span[normalize-space()=\"Number 1\"]"));
		waitEle(By.xpath("//img[@src=\"/img/close.526eeae8.svg\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//input[@placeholder=\"Select Fields\"]"));
		Thread.sleep(5000);
		Javascriptclick(By.xpath("//div[@x-placement]//span[normalize-space()=\"Number 1\"]"));
		waitEle(By.xpath("//div[@aria-label='Field Properties']//span[contains(text(),'Save')]"));
		System.out.println("formula field drag and drop done successfully");
		// currency
		WebElement currencyEle = driver.findElement(By.id("currencyEle"));
		waitAndClick(actions, currencyEle, Target, 10, -80);
		System.out.println("currency field drag and drop done successfully");
		// addDateTime
		WebElement addDateTimeEl = driver.findElement(By.id("addDateTimeEle"));
		waitAndClick(actions, addDateTimeEl, Target, 10, -50);
		System.out.println("addDateTime field drag and drop done successfully");
		// addDateTimeRange
		WebElement addDateTimeRangeEle = driver.findElement(By.id("addDateTimeRangeEle"));
		waitAndClick(actions, addDateTimeRangeEle, Target, 10, 0);
		System.out.println("addDateTimeRange field drag and drop done successfully");
		// addDateRange
		WebElement addDateRangeEle = driver.findElement(By.id("addDateRangeEle"));
		waitAndClick(actions, addDateRangeEle, Target, 10, 50);
		System.out.println("addDateRange field drag and drop done successfully");
		// addTime
		WebElement addTimeEle = driver.findElement(By.id("addTimeEle"));
		waitAndClick(actions, addTimeEle, Target, 10, 80);
		System.out.println("addTime field drag and drop done successfully");
		// addList
		WebElement addListEle = driver.findElement(By.id("addListEle"));
		waitAndClick(actions, addListEle, Target, 10, 120);
		Set<String> windowHandles2 = driver.getWindowHandles();
		for (String handle : windowHandles2) {
			driver.switchTo().window(handle);

		}
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Name\"]"), "a");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Value\"]"), "1");
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()=\"Add\"]"));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Name\"]"), "b");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Value\"]"), "2");
		waitEle(By.xpath("//span[normalize-space()=\"Add\"]"));
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Name\"]"), "c");
		sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Value\"]"), "3");
		waitEle(By.xpath("//span[normalize-space()=\"Add\"]"));
		waitEle(By
				.xpath("//div[@class='el-dialog__wrapper fields-dialog']//div[@class='el-dialog__footer']//button[1]"));
		System.out.println("addList field drag and drop done successfully");
		// addTimeRange
		WebElement addTimeRangeEle = driver.findElement(By.id("addTimeRangeEle"));
		waitAndClick(actions, addTimeRangeEle, Target, 10, 150);
		System.out.println("addTimeRange field drag and drop done successfully");
		// addFixedTime
		WebElement addFixedTimeEle = driver.findElement(By.id("addFixedTimeEle"));
		waitAndClick(actions, addFixedTimeEle, Target, 10, 180);
		System.out.println("addFixedTime field drag and drop done successfully");
		// weekdays
		WebElement weekdaysEle = driver.findElement(By.id("weekdaysEle"));
		waitAndClick(actions, weekdaysEle, Target, 10, 210);
		System.out.println("weekdays field drag and drop done successfully");

	}

	public void sendDocument() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//span[text()=\"Send document\"]"));

	}

	public void DradAndDropSingleline(int n, int x1, int y1, String Fieldtype, String Entity) throws Exception {

		Thread.sleep(10000);

		Actions actions1 = new Actions(driver);

		WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		WebElement SingleElement = driver.findElement(By.xpath("//button[@id='singleLineTextEle']"));

		waitAndClick(actions1, SingleElement, targetElement, x1, y1);
		Thread.sleep(5000);
		WebElement singleelement2 = driver
				.findElement(By.xpath("//div[@class='form-fields-holder']//div[@data-text='Single Line Text 1']"));

		waitEle(By.xpath("//div[@class='form-fields-holder']//div[@data-text='Single Line Text 1']"));
		Thread.sleep(5000);
		actions1.moveToElement(singleelement2).doubleClick().perform();

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		} // div[@class="el-dialog__body"]//input[@placeholder="Select a Recipient"]
		Thread.sleep(5000);
		waitEle(By.xpath("//div[@class=\"el-form-item\"]//input[@placeholder=\"Select a Recipient\"]"));
		String con = String.format("//div[@x-placement]//ul//li//span[normalize-space()=\"%s\"][1]", Fieldtype);
		Javascriptclick(By.xpath(con));
		waitEle(By.xpath("(//div[@class=\"el-form-item\"]//input[@placeholder=\"Select\"])[1]"));
		String Sel = String.format("//div[@x-placement]//ul//li[normalize-space()='%s']", Entity);
		Javascriptclick(By.xpath(Sel));
		Thread.sleep(5000);
		waitEle(By.xpath("//span[normalize-space()=\"Allow To Add New Data\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("(//span[text()='Save'])[3]"));
		Thread.sleep(5000);
	}

	public void updateWithParentBadicFields(int n, int x1, int y1, String Fieldtype, String SelectTemplate,
			String SelectField) throws Exception {
		Thread.sleep(20000);
		Actions actions1 = new Actions(driver);
		WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		WebElement SingleElement = driver.findElement(By.xpath("//button[@id='singleLineTextEle']"));

		waitAndClick(actions1, SingleElement, targetElement, x1, y1);
		Thread.sleep(10000);
//		WebElement singleelement2 = driver.findElement(By.xpath("//div[@class='form-fields-holder']//div[@data-text='Single Line Text %d']"));
		String singleline = String.format("//div[@class='form-fields-holder']//div[@data-text='Single Line Text %d']",
				n);
		Javascriptclick(By.xpath(singleline));
		Thread.sleep(5000);
		WebElement singleelement2 = driver.findElement(By.xpath(singleline));
		actions1.doubleClick(singleelement2).build().perform();

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
			Thread.sleep(10000);
			waitEle(By.xpath("//div[@class=\"el-form-item\"]//input[@placeholder=\"Select a Recipient\"]"));
			String con = String.format("//div[@x-placement]//ul//li//span[contains(text(),\"%s\"]", Fieldtype);
			Javascriptclick(By.xpath(con));
			Thread.sleep(10000);
			waitEle(By.xpath("(//div[@class=\"el-select\"]//input[@placeholder=\"Select\"])[1]"));
			String sel = String.format("//div[@x-placement]//ul//li//span[normalize-space()=\"%s\"]", SelectTemplate);
			Javascriptclick(By.xpath(sel));
			Thread.sleep(10000);
			waitEle(By.xpath("(//div[@class=\"el-select\"]//input[@placeholder=\"Select\"])[2]"));
			String selent = String.format("//div[@x-placement]//ul//li[contains(text(), \"%s\")]", SelectField);
			Javascriptclick(By.xpath(selent));
			Thread.sleep(10000);
			waitEle(By.xpath("//span[normalize-space()=\"Update Parent\"]"));
			Thread.sleep(10000);
			waitEle(By.xpath("(//div[@class=\"el-dialog__footer\"]//span[text()=\"Save\"])[2]"));
		}
	}

	public void updateWithParentBasicFieldsLoop(String Fieldtype, String SelectTemplate) throws Exception {
		int n = 1;
		int i = 1;
		Thread.sleep(15000);
		for (int x = -300; x <= 250; x = x + 250) {
			for (int y = -120; y <= 210; y = y + 50) {
				if (i >= 20) {
					break;
				} else {

					Actions actions1 = new Actions(driver);

					WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

					WebElement SingleElement = driver.findElement(By.xpath("//button[@id='singleLineTextEle']"));

					waitAndClick(actions1, SingleElement, targetElement, x, y);
					Thread.sleep(5000);
					String singleline = String
							.format("//div[@class='form-fields-holder']//div[@data-text='Single Line Text %d']", n);
					Javascriptclick(By.xpath(singleline));
					Thread.sleep(5000);
					WebElement singleelement2 = driver.findElement(By.xpath(singleline));
					actions1.doubleClick(singleelement2).build().perform();

					Set<String> windowHandles = driver.getWindowHandles();
					for (String handle : windowHandles) {
						driver.switchTo().window(handle);
						Thread.sleep(5000);
						waitEle(By.xpath("//div[@class=\"el-form-item\"]//input[@placeholder=\"Select a Recipient\"]"));
						String con = String.format("//div[@x-placement]//ul//li//span[contains(text(),\"%s\")]",
								Fieldtype);
						Javascriptclick(By.xpath(con));
						Thread.sleep(5000);
						waitEle(By.xpath(
								"(//div[@class=\"el-dialog__body\"]//div[@class=\"el-select\"]//input[@placeholder=\"Select\"])[1]"));
						String sel = String.format("//div[@x-placement]//ul//li//span[normalize-space()=\"%s\"]",
								SelectTemplate);
						Javascriptclick(By.xpath(sel));
						Thread.sleep(5000);
						waitEle(By.xpath(
								"(//div[@class=\"el-dialog__body\"]//div[@class=\"el-select\"]//input[@placeholder=\"Select\"])[2]"));
						String select = String.format("//div[@x-placement]//ul//li[%d]", i);
						Javascriptclick(By.xpath(select));
						WebElement element = driver.findElement(By.xpath(select));
						String text = element.getText();
						System.out.println(text);
						if (text.equals("Single line text") || text.equals("Phoneno")) {
							n = n + 1;
						}
						if (text.equals("Document")) {
							String pdffile = System.getProperty("user.dir") + "/src/test/resources/TESTING.pdf";
							uploadFileWithSendKeys(pdffile);
						}
						System.out.println(n);
						Thread.sleep(5000);
						waitEle(By.xpath("//span[normalize-space()=\"Update Parent\"]"));

						waitEle(By.xpath("(//div[@class=\"el-dialog__footer\"]//span[text()=\"Save\"])[2]"));
						i++;
					}
				}
			}
		}
	}

	public void basicFieldsLoopWithAndWithoutUpdateParent(String updateType, String Fieldtype, String SelectTemplate)
			throws Exception {
		int n = 1;
		int i = 1;
		for (int x = -300; x <= 250; x = x + 250) {
			for (int y = -120; y <= 210; y = y + 50) {
				if (i > 20) {
					break;
				} else {
					Thread.sleep(3000);
					Actions actions1 = new Actions(driver);

					WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

					WebElement SingleElement = driver.findElement(By.xpath("//button[@id='singleLineTextEle']"));

					waitAndClick(actions1, SingleElement, targetElement, x, y);
					Thread.sleep(3000);
					String singleline = String
							.format("//div[@class='form-fields-holder']//div[@data-text='Single Line Text %d']", n);
					Javascriptclick(By.xpath(singleline));
					Thread.sleep(3000);
					WebElement singleelement2 = driver.findElement(By.xpath(singleline));
					actions1.doubleClick(singleelement2).build().perform();

					Set<String> windowHandles = driver.getWindowHandles();
					for (String handle : windowHandles) {
						driver.switchTo().window(handle);
						Thread.sleep(3000);
						waitEle(By.xpath("//div[@class=\"el-form-item\"]//input[@placeholder=\"Select a Recipient\"]"));
						String con = String.format("//div[@x-placement]//ul//li//span[contains(text(),\"%s\")]",
								Fieldtype);
						Javascriptclick(By.xpath(con));

						waitEle(By.xpath(
								"(//div[@class=\"el-dialog__body\"]//div[@class=\"el-select\"]//input[@placeholder=\"Select\"])[1]"));
						String sel = String.format("//div[@x-placement]//ul//li//span[normalize-space()=\"%s\"]",
								SelectTemplate);
						Javascriptclick(By.xpath(sel));
						Thread.sleep(3000);
						waitEle(By.xpath(
								"(//div[@class=\"el-dialog__body\"]//div[@class=\"el-select\"]//input[@placeholder=\"Select\"])[2]"));
						String select = String.format("//div[@x-placement]//ul//li[%d]", i);
						Javascriptclick(By.xpath(select));
						WebElement element = driver.findElement(By.xpath(select));
						String text = element.getText();
						System.out.println(text);
						if (text.equals("Single line text") || text.equals("Phoneno")) {
							n = n + 1;
						}
						if (text.equals("Document")) {
							String pdffile = System.getProperty("user.dir") + "/src/test/resources/TESTING.pdf";
							uploadFileWithSendKeys(pdffile);
						}
						System.out.println(n);
						Thread.sleep(3000);
						if (updateType.equals("Update Parent")) {
							try {
								waitEle(By.xpath("//span[normalize-space()=\"Update Parent\"]"));
							} catch (Exception e) {

							}
						}
						waitEle(By.xpath("(//div[@class=\"el-dialog__footer\"]//span[text()=\"Save\"])[2]"));
						i++;
					}
				}
			}
		}
	}

	public void addNewEntityDataInDocByClickOnPlus(String s) throws Exception {
		waitEle(By.xpath("//a[@class=\"el-link el-link--default\"]"));
		sendKeysToElement(By.xpath("//div[@class=\"el-dialog__body\"]//input[@placeholder=\"Single line text\"]"), s);
		waitEle(By.xpath("//span[text()=\"Add\"]"));

	}

	public void Templatesceanario() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			System.out.println("Overlay not found or not invisible.");
		}

		Javascriptclick(By.xpath("//span[normalize-space()='Templates']"));

		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//button[@class='el-button create-btn px-2 ml-2 p-05 el-button--primary el-button--medium']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

	}

	public void RecipientSignerToTemplate(String contactType, String signerType) throws Exception {

		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(1000);
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select Contact type']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//		String xpath = String.format("//input[@placeholder='Select Contact type']");
//		waitEle(By.xpath(xpath));
		String contacttype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", contactType);
		waitEle(By.xpath(contacttype));
		System.out.println("Selected contact type Successfully");
		String xpath4 = String.format("//input[@placeholder='Select Signer Type']");
		waitEle(By.xpath(xpath4));
		Thread.sleep(3000);
		String signertype = String.format("//div[@x-placement]//ul//li[contains(text(), '%s')]", signerType);
		waitEle(By.xpath(signertype));
		System.out.println("Selected Recipients Successfully");

		Thread.sleep(1000);

		waitEle(By.xpath("(//span[normalize-space()='Add'])[2]"));

	}

	public void CreateBlankTemplate(String templateName) throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Blank template']"));

		waitEle(By.xpath("//span[normalize-space()='Continue as Blank Template']"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		sendKeysToElement(By.xpath("//input[@placeholder='Enter template name']"), templateName);

		waitEle(By.xpath("//span[normalize-space()='Continue']"));

	}

	public void saveTemplate() throws Exception {
		waitEle(By.xpath("//span[text()=\"Save Template\"]"));

	}

	public void back() throws Exception {
		waitEle(By.xpath("//i[@class=\"el-icon-back\"]"));
	}

	public static void highlight(WebElement element) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid blue;');", element);

	}

}