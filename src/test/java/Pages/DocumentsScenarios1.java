package Pages;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Set;
import java.util.UUID;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DocumentsScenarios1 {
	static WebDriver driver;

	public DocumentsScenarios1(WebDriver driver) {

		DocumentsScenarios1.driver = driver;

	}

	public void waitEle(By by) throws Exception {

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
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
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

	public void clickLogout() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("(//div[@class=\"icon-text\"])[1]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//li[text()=\" Logout \"]"));
		Thread.sleep(10000);
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			System.out.println("Overlay not found or not invisible.");
		}
		Thread.sleep(10000);
		By ad = By.xpath("//span[normalize-space()='Documents']");

		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			WebElement docu = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//h3[@class='fw-medium blue-dark mb-3 fs-6']")));
			Assert.assertNotNull(docu, "Documents");
			System.out.println("Clicked On Documents using JS successfully");

		} catch (Exception e) {

			System.out.println("Element not clickable or not found: ");
		}
		waitEle(By
				.xpath("//button[@class='el-button scaling-button el-button--primary is-plain create-btn px-4 ml-2']"));
		System.out.println("Click on create Document Done Successfully");

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

		driver.findElement(By.xpath("(//span[normalize-space()='Continue'])[2]")).click();
		WebElement doc = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='fw-bold fs-24']")));
		Assert.assertNotNull(doc, "Add Recepient element is not present Create document failed");
		System.out.println("Selected BlankDocument successfully");

	}

	public void Recipient(int id, String contactType, String email, String signerType) throws Exception {
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));
		System.out.println("Click on Add recipient done Successfully");
		String xpath = String.format("//div[@id='user_%d']//input[@placeholder='Select contact type']", id);
		waitEle(By.xpath(xpath));
		String con = String.format("//div[@x-placement]//ul//li[normalize-space()='%s']", contactType);
		waitEle(By.xpath(con));
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

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));

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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(5000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Send Document']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	public boolean Verifysubmit() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
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

	public void SignatureAndFullNameFeilds() throws Exception {
		Thread.sleep(10000);
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
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(10));
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
		waitEle(By.xpath("//span[contains(text(),\"View Document\")]"));
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

	public void DragBasicFeildsCompanyProfile() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//div[text()=\"templateBasicFeilds\"]"));
		// Document
		Actions actions = new Actions(driver);
		WebElement Document = driver.findElement(By.xpath("//div[text()=\" Docume... \"]"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		waitAndClick(actions, Document, Target, 0, -80);
		System.out.println("Document Field Drag and Drop Done");
		// Radio Group
		WebElement RadioGroup = driver.findElement(By.xpath("//div[text()=\" RadioG... \"]"));
		waitAndClick(actions, RadioGroup, Target, -250, -30);
		System.out.println("Radio Group Field Drag and Drop Done");
		// multiline
		WebElement multiline = driver.findElement(By.xpath("//div[text()=\" Multil... \"]"));
		waitAndClick(actions, multiline, Target, 0, 0);
		System.out.println("multiline Field Drag and Drop Done");
		// sign
		WebElement sign = driver.findElement(By.xpath("//div[text()=\" Sign \"]"));
		waitAndClick(actions, sign, Target, 0, 30);
		System.out.println("sign Field Drag and Drop Done");
		// phoneno
		WebElement phoneno = driver.findElement(By.xpath("//div[text()=\" Phonon... \"]"));
		waitAndClick(actions, phoneno, Target, 0, 60);
		System.out.println("phoneno Field Drag and Drop Done");
		// captcha
		WebElement captcha = driver.findElement(By.xpath("//div[text()=\" Captch... \"]"));
		waitAndClick(actions, captcha, Target, 0, 90);
		System.out.println("captcha Field Drag and Drop Done");
		// singleLine
		WebElement singleLine = driver.findElement(By.xpath("//div[text()=\" Single... \"]"));
		waitAndClick(actions, singleLine, Target, 0, 120);
		System.out.println("singleLine Field Drag and Drop Done");
		// checkboxGroup
		WebElement checkboxGroup = driver.findElement(By.xpath("(//div[text()=\" Checkb... \"])[1]"));
		waitAndClick(actions, checkboxGroup, Target, 0, 180);
		System.out.println("checkboxGroup Field Drag and Drop Done");
		// Number
		WebElement Number = driver.findElement(By.xpath("(//div[text()=\" Number \"])[1]"));
		waitAndClick(actions, Number, Target, 0, 210);
		System.out.println("Number Field Drag and Drop Done");
		// Multiselect
		WebElement Multiselect = driver.findElement(By.xpath("//div[text()=\" Multis... \"]"));
		waitAndClick(actions, Multiselect, Target, 0, 240);
		System.out.println("Multiselect Field Drag and Drop Done");
		// Date
		WebElement Date = driver.findElement(By.xpath("//div[text()=\" Date \"]"));
		waitAndClick(actions, Date, Target, -250, -80);
		System.out.println("Date Field Drag and Drop Done");
		// Time
		WebElement Time = driver.findElement(By.xpath("(//div[text()=\" Time \"])[1]"));
		waitAndClick(actions, Time, Target, -250, 0);
		System.out.println("Time Field Drag and Drop Done");
		// FixedTime
		WebElement FixedTime = driver.findElement(By.xpath("//div[text()=\" FixedT... \"]"));
		waitAndClick(actions, FixedTime, Target, -250, 60);
		System.out.println("FixedTime Field Drag and Drop Done");
		// TimeRange
		WebElement TimeRange = driver.findElement(By.xpath("//div[text()=\" TimeRa... \"]"));
		waitAndClick(actions, TimeRange, Target, -250, 90);
		System.out.println("TimeRange Field Drag and Drop Done");
		// DateTime
		WebElement DateTime = driver.findElement(By.xpath("//div[text()=\" DateTi... \"]"));
		waitAndClick(actions, DateTime, Target, 250, 130);
		System.out.println("DateTime Field Drag and Drop Done");
		// DateRange
		WebElement DateRange = driver.findElement(By.xpath("//div[text()=\" DateRa... \"]"));
		waitAndClick(actions, DateRange, Target, 250, 160);
		System.out.println("DateRange Field Drag and Drop Done");
		// Weekday
		WebElement Weekday = driver.findElement(By.xpath("//div[text()=\" Weekda... \"]"));
		waitAndClick(actions, Weekday, Target, 250, 190);
		System.out.println("Weekday Field Drag and Drop Done");
		// yesOrNo
		WebElement yesOrNo = driver.findElement(By.xpath("//div[text()=\" YesorN... \"]"));
		waitAndClick(actions, yesOrNo, Target, 250, 100);
		System.out.println("yesOrNo Field Drag and Drop Done");
		// Checkbox
		WebElement Checkbox = driver.findElement(By.xpath("(//div[text()=\" Checkb... \"])[2]"));
		waitAndClick(actions, Checkbox, Target, 250, 40);
		System.out.println("Checkbox Field Drag and Drop Done");
		// Radio
		WebElement Radio = driver.findElement(By.xpath("//div[text()=\" Radio \"]"));
		waitAndClick(actions, Radio, Target, 250, 70);
		System.out.println("Radio Field Drag and Drop Done");
		// Select
		WebElement Select = driver.findElement(By.xpath("(//div[text()=\" Select \"])[1]"));
		waitAndClick(actions, Select, Target, -250, 30);
		System.out.println("Select  Field Drag and Drop Done");
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
		Thread.sleep(10000);
		waitEle(By.xpath("(//a[text()=\" DocScenarios sta... \"])[1]"));

	}

	public void autofilloff() throws Exception {
		Thread.sleep(5000);
		waitEle(By.xpath("(//div[@class=\"icon-text\"])[1]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//li[text()=\" Settings \"]"));
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
		waitEle(By.xpath("//li[text()=\" Settings \"]"));
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

		waitEle(By.xpath("//a[text()=\"Application Settings\"]"));
		WebElement checkbox = driver.findElement(By.xpath("(//span[@class=\"el-radio__inner\"])[1]"));
		boolean isChecked = checkbox.isSelected();

		if (!isChecked) {
			checkbox.click();
			System.out.println("Checkbox was unchecked. Now it's checked.");
		} else {
			System.out.println("Checkbox was already checked. No action taken.");
		}

		waitEle(By.xpath("//button[@class='el-button type-2 el-button--default']"));
	}

	public void FileuploadTwo() throws InterruptedException, Exception {
		Thread.sleep(5000);

		Runtime.getRuntime().exec("src/test/resources/meghana/fileupload.exe");
		Thread.sleep(5000);

		System.out.println("Uploaded file successfully");
	}

}
