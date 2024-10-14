package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Bug {
	WebDriver driver;
	MethodActions methodActions;

	public Bug(WebDriver driver) {
		this.driver = driver;
		methodActions = new MethodActions(driver);

	}

	public void SigninjeevithaNSUI() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
				.sendKeys("jeevitha.patnana@nimbleaccounting.com");
		driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Nikki@1338");
		driver.findElement(By.xpath("//span[normalize-space()='Log In']")).click();
		Thread.sleep(10000);

	}

	public void entity() throws Exception {

		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		Thread.sleep(3000);

		MethodActions.waitEle(By.xpath("(//div[@class=\"icon-text\"])[1]"));

		Thread.sleep(3000);

		By Entities = By.xpath("//li[normalize-space()=\"Entities\"]");
		WebElement Entities1 = wait.until(ExpectedConditions.elementToBeClickable(Entities));
		Entities1.click();

		System.out.println("Clicked on entities in profile completed");

	}

	public void ClickCreateEntity() throws Exception {

		By ad = By.xpath("//button[normalize-space()='Create Entity']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on ceate entity using JS.");

	}

	public void CreateEntityScratch() throws Exception {
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

		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "student-bug");

		By Description = By.xpath("//textarea[@placeholder='Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("This entity is only for testing purpose");

		MethodActions.waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[3]"));

		MethodActions.waitEle(By.xpath("//h4[contains(text(),\"Start from scratch\")]"));

		System.out.println("Create entity successfull");

	}

	public void entity4004() throws Exception {
		MethodActions.waitEle(By.xpath("(//span[@class=\"el-radio-button__inner\"])[1]"));
		driver.findElement(By.xpath("//input[@placeholder='Title']")).clear();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Title']"), "Bug4004(");
	}

	public void confirmButton() throws Exception {
		Thread.sleep(10000);
		WebElement element = driver
				.findElement(By.xpath("//button[@class=\"btn btn btn-outline-primary btn-sm m-lr-1\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

	}

	public void validSuccessBug4004() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement welcomeMessage = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()=\"Error\"]")));

			Assert.assertNotNull(welcomeMessage, "Welcome message element is not present Login Failed");
			System.out.println("Bug 4004 reproduced");
		} catch (Exception e) {
			System.out.println("4004Bug Not reproduced");
		}
	}

	public class Bug5423 {
		WebDriver driver;

		public Bug5423(WebDriver driver) {
			this.driver = driver;

		}

		public void waitEle(By by) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			wait.until(ExpectedConditions.elementToBeClickable(by)).click();
		}

		public void sendKeysToElement(By by, CharSequence keysToSend) throws Exception {
			Thread.sleep(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
			element.sendKeys(keysToSend);
		}

		public void actionshover() throws Exception {
			Thread.sleep(10000);
			WebElement elementToHover2 = driver.findElement(By.xpath("//span[@class='el-icon-arrow-down text-white']"));
			Actions actions2 = new Actions(driver);
			actions2.moveToElement(elementToHover2).perform();

		}

		private void waitAndClick1(Actions actions, WebElement element, WebElement target) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
			try {

				WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

				actions.clickAndHold(clickableElement).moveToElement(target).release().build().perform();

				Thread.sleep(1000);

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		public void FormTemplate() throws Exception {
			Thread.sleep(10000);
			waitEle(By.xpath("//div[@class='icon-text']"));
			Thread.sleep(10000);
			waitEle(By.xpath("//ul[@x-placement]//li[normalize-space()='Form Template']"));

		}

		public void CreateFormtemplate() throws Exception {

			Thread.sleep(10000);

			waitEle(By.xpath("//button[normalize-space()='Create Template']"));
			Thread.sleep(10000);

		}

	}

	public void submit() throws Exception {
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Submit'])[1]"));
		System.out.println("Click on submit done successfully");

	}

	public void Feild5423() throws Exception {

		MethodActions.waitEle(By.xpath("//div[text()=\"Basic Fields\"]"));

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement dropLocation = driver.findElement(By.xpath("//div[@class='base-parent']"));

		WebElement Name = driver.findElement(By.xpath("(//span[normalize-space()='Single Line Text'])[2]"));

		Actions actions1 = new Actions(driver);

		Dimension dropSize = dropLocation.getSize();

		int targetX = dropLocation.getLocation().getX() + (dropSize.getWidth() / 2);
		int targetY = dropLocation.getLocation().getY() + (dropSize.getHeight() / 2);

		// Perform the drag-and-drop operation
		actions1.dragAndDropBy(Name, targetX, targetY).perform();
		System.out.println("Feild5423 Drag and Drop Done");

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "5423");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		System.out.println("dd done");
		Thread.sleep(5000);
		MethodActions.waitEle(By.xpath("(//div[@class='el-col el-col-24']//input)[1]"));
		MethodActions.waitEle(By.xpath("//div[@class=\"setting-icon el-row\"]"));
		MethodActions.waitEle(By.xpath("(//input[@placeholder=\"Select\"])[1]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[4]"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@class='el-drawer__container el-drawer__open']"));
		Thread.sleep(10000);

		WebElement document = driver.findElement(By.xpath("//span[text()=\"Document\"]"));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", document);
		Thread.sleep(5000);

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);

		MethodActions.waitAndClick(actions, document, Target);
		System.out.println("Document feild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "DocumentFeild");
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		Thread.sleep(10000);

//		waitEle(By.xpath("//div[text()=' DocumentFeild ']"));
		MethodActions.waitEle(By.xpath("//div[@class=\"icon avatar-uploader\"]"));
		MethodActions.waitEle(By.xpath("//div[@class=\"setting-icon el-row\"]"));
		MethodActions.waitEle(By.xpath("(//input[@placeholder=\"Select\"])[1]"));
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[4]"));
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@class='el-drawer__container el-drawer__open']"));

	}

	public void Save() throws Exception {
		MethodActions.waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));

	}

	public void veiwAction5423() throws Exception {
		Thread.sleep(10000);

		MethodActions.waitEle(By.xpath("//input[@placeholder=\"Select\"]"));
		MethodActions.waitEle(By.xpath("//span[normalize-space()='50/page']"));
		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__body-wrapper is-scrolling-none']//td[normalize-space()='unique_string_sample12a560']/ancestor::tr//span[normalize-space()=\"Actions\"]"
						+ ""));

		Actions actions = new Actions(driver);
		Thread.sleep(10000);
		actions.moveToElement(elementToHover).perform();
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[1]"));
		System.out.println("Hidden doc field is getting visible");

	}

	public void Feild5421() throws Exception {
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[text()=\"Content Fields\"]"));

		Thread.sleep(10000);
		WebElement videofield = driver.findElement(By.xpath("(//span[normalize-space()='Video'])[2]"));

		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));

		Actions actions = new Actions(driver);

		MethodActions.waitAndClick(actions, videofield, Target);
		System.out.println("video feild Drag and Drop Done");

		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "5421");
		MethodActions.waitEle(By.xpath("(//div[@class=\"el-upload__text\"])"));
		Thread.sleep(10000);
		Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\uploadimage.exe\"");
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));

		// add

	}

	public void entitys() throws Exception {

		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		Thread.sleep(3000);

		MethodActions.waitEle(By.xpath("(//div[@class=\"icon-text\"])[1]"));

		Thread.sleep(3000);

		By Entities = By.xpath("//li[normalize-space()=\"Entities\"]");
		WebElement Entities1 = wait.until(ExpectedConditions.elementToBeClickable(Entities));
		Entities1.click();

		System.out.println("Clicked on entities in profile completed");

	}

	public void CreateEntity() throws Exception {

		By ad = By.xpath("//button[normalize-space()='Create Entity']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked on ceate entity using JS.");

	}

	public void CreateEntityGeneral() throws Exception {
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

//		WebElement Title1 = driver.findElement(By.xpath("//input[@placeholder='Title']"));
//		String uniqueString = generateUniqueString();
//		Title1.sendKeys(uniqueString);
		By Description = By.xpath("//textarea[@placeholder='Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("This entity is only for testing purpose");

		MethodActions.waitEle(By.xpath("//span[normalize-space()='GENERAL']"));
		System.out.println("Clicked on GENERAL Successfully");
		MethodActions.waitEle(By.xpath("//h4[text()=\"Start from scratch\"]"));
		System.out.println("Clicked on Create from scratch successfully");

	}

	public void confirmButton1() throws Exception {
		Thread.sleep(10000);
		WebElement element = driver
				.findElement(By.xpath("//button[@class=\"btn btn btn-outline-primary btn-sm m-lr-1\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

	}

	public void addtemplates5421() throws Exception {

		MethodActions
				.waitEle(By.xpath("(//div[@class='el-scrollbar__view'])[2]//button//p[normalize-space()=\"okk\"]"));

		System.out.println("Form template added successfully");
		Thread.sleep(10000);

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Update & Next']"));
	}

	public void primaryFeild() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement Video55421 = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='el-scrollbar__view'])[2]//ul//li[1]")));

		WebElement Target = driver.findElement(By.xpath("(//div[@class='el-scrollbar'])[4]"));

		Actions actions = new Actions(driver);

		MethodActions.waitAndClick(actions, Video55421, Target);

		System.out.println("primary feild Drag and Drop Done");

		updateAndNext();
		updateAndNext();

		updateAndNext();
		// waitEle(By.xpath("//span[normalize-space()='Update & Next']"));

	}

	public void updateAndNext() throws Exception {
		Thread.sleep(10000);
		try {
			MethodActions.waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));
		} catch (Exception e) {
		}
		Thread.sleep(10000);

		MethodActions.waitEle(By.xpath("//span[normalize-space()='Update & Next']"));

	}

	public void Done() throws Exception {
		Thread.sleep(5000);
		x();
		MethodActions.waitEle(By.xpath("//span[normalize-space()=\"Done\"]"));
	}

	public void x() throws Exception {
		Thread.sleep(30000);
		try {
			MethodActions.waitEle(By.xpath("//div[@class=\"el-notification__closeBtn el-icon-close\"]"));

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void veiwAction5421() throws Exception {

		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//input[@placeholder='Select']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();
		MethodActions.waitEle(By.xpath("//div[@x-placement]//li[3]"));
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath(
				"(//div[@class='el-table__fixed']//div[contains(text(),'5421')]/ancestor::tr//span[normalize-space()=\"Actions\"])[1]"));

		Actions actions = new Actions(driver);
		Thread.sleep(10000);
		actions.moveToElement(elementToHover).perform();
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[1]"));
		System.out.println("Thumbnail Image Is Not Displaying");
	}

	
	
	//doc
	public void AllCombos() throws Exception {
		 
		Thread.sleep(10000);
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Create Document']"));
 
	}
 
	public void ValidAllCombos() {
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Message = wait1.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h3[@class='text-center text-dark fw-normal fs-4 mb-1']")));
		Assert.assertNotNull(Message, "Upload document element is not present Create document failed");
		System.out.println("Create document successfull");
	}
 
	@SuppressWarnings("deprecation")
	public void uploadDocument() throws Exception {
 
		MethodActions.waitEle(By.xpath("//h4[@class='fw-normal blue pb-2']"));
 
		Runtime.getRuntime().exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\fileupload.exe");
 
//		waitTill(By.xpath("//button[@class='el-button text-center upload-btn el-button--danger']"));
 
		Thread.sleep(10000);
	}
 
	public void ValidUploadDocument() throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Message1 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Next']")));
		Assert.assertNotNull(Message1, "Next button not present Create document failed");
		System.out.println("Upload document successfull");
 
	}
 
	@SuppressWarnings("deprecation")
	public void UploadMultipledocuments() throws Exception  {
		MethodActions.waitEle(By.xpath("//h4[@class='fw-normal blue pb-2']"));
		Runtime.getRuntime()
				.exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\multiple document.exe");
 
		Thread.sleep(10000);
	}
 
	public void ValidUploadMultipleDocument() throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Message1 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Next']")));
		Assert.assertNotNull(Message1, "Next button not present Create document failed");
		System.out.println("Upload document successfull");
 
	}
 
	public void oneDriveupload() throws Exception {
 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
 
		MethodActions.waitEle(By.xpath("//img[@src='/img/onedrive.cc38d634.svg']"));
 
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(5000);
		String Parentwindowid = driver.getWindowHandle();
 
		MethodActions.waitEle(By.xpath("//button[normalize-space()='Connect OneDrive']"));
		Thread.sleep(5000);
 
		Set<String> allwindowhandles = driver.getWindowHandles();
		for (String childwindow : allwindowhandles) {
			if (!childwindow.endsWith(Parentwindowid)) {
				driver.switchTo().window(childwindow);
				driver.findElement(By.xpath("//input[@id='i0116']")).sendKeys("bsrv.prudhviraju@outlook.com");
 
				MethodActions.waitEle(By.xpath("//input[@id='idSIButton9']"));
 
				Thread.sleep(10000);
 
				By password = By.xpath("//input[@id='i0118']");
				WebElement Upload1 = wait.until(ExpectedConditions.elementToBeClickable(password));
				Upload1.sendKeys("Prjking@99");
 
				Thread.sleep(10000);
				MethodActions.waitEle(By.xpath("//input[@id='idSIButton9']"));
				try {
					MethodActions.waitEle(By.xpath("//button[normalize-space()='Yes']"));
				} catch (Exception e) {
					// TODO: handle exception
				}
 
				Thread.sleep(5000);
				Set<String> windowHandles1 = driver.getWindowHandles();
				for (String handle : windowHandles1) {
					driver.switchTo().window(handle);
				}
 
				MethodActions.waitEle(By.xpath("//span//span[normalize-space()='Document 1.docx']"));
 
				MethodActions.waitEle(By.xpath("//span[@title='Upload']"));
 
			}
		}
	}
 
	public void ValidOneDrive() throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Next']")));
		Assert.assertNotNull(Message1, "Next button not present Create document failed");
		System.out.println("One Drive Upload document successfull");
 
	}
 
	public void googledrive() throws Exception {
 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
 
		MethodActions.waitEle(By.xpath("//img[@placeholder='top-start']"));
 
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		String Parentwindowid = driver.getWindowHandle();
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Sign in with Google']"));
 
		Set<String> allwindowhandles = driver.getWindowHandles();
		for (String childwindow : allwindowhandles) {
			if (!childwindow.endsWith(Parentwindowid)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(10000);
 
				By upload3 = By.xpath("//input[@id=\\\"identifierId\\\"]");
				WebElement upload2 = wait.until(ExpectedConditions.elementToBeClickable(upload3));
				upload2.sendKeys("n180894@rguktn.ac.in");
 
				MethodActions.waitEle(By.xpath("//span[normalize-space()='Next']"));
 
				Set<String> windowHandles1 = driver.getWindowHandles();
				for (String handle : windowHandles1) {
					driver.switchTo().window(handle);
 
				}
				By user = By.xpath("//input[@name='Passwd']");
				WebElement user1 = wait.until(ExpectedConditions.elementToBeClickable(user));
				user1.sendKeys("meghu@123");
 
				MethodActions.waitEle(By.xpath("//span[normalize-space()='Next']"));
 
				Thread.sleep(10000);
				Set<String> windowHandles11 = driver.getWindowHandles();
				for (String handle : windowHandles11) {
					driver.switchTo().window(handle);
 
				}
 
				MethodActions.waitEle(By.xpath("//span[normalize-space()='Allow']"));
 
				Set<String> windowHandles111 = driver.getWindowHandles();
				for (String handle : windowHandles111) {
					driver.switchTo().window(handle);
 
				}
 
				MethodActions.waitEle(By.xpath("//span[normalize-space()='N180894-resume.pdf']"));
 
				Set<String> windowHandles2 = driver.getWindowHandles();
				for (String handle : windowHandles2) {
					driver.switchTo().window(handle);
 
				}
 
				MethodActions.waitEle(By.xpath("//span[@class='fsp-button fsp-button--primary fsp-button-upload']"));
			}
		}
	}
 
	public void ValidGoogleDriveUploadDocument() throws InterruptedException {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Next']")));
		Assert.assertNotNull(Message1, "Next button not present Create document failed");
		System.out.println("Google Drive Upload document successfull");
 
	}
 
	public void BlankDoc() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
 
		MethodActions.waitEle(By.xpath("//img[@src='/img/Blank.1f314c3f.svg']"));
 
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
 
		By Element2 = By.xpath("//input[@placeholder='Enter Document name']");
		WebElement document2 = wait.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.sendKeys("test");
 
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select number of pages']"));
 
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
 
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Continue'])[2]"));
 
	}
 
	public void ValidBlankDoc() {
 
		WebDriverWait page = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement doc = page
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='fw-bold fs-24']")));
		Assert.assertNotNull(doc, "Add Recepient element is not present Create document failed");
		System.out.println("Upload document successfull");
 
	}
 
	@SuppressWarnings("deprecation")
	public void UploadPdfAf() throws Exception {
 
		MethodActions.waitEle(By.xpath("//h4[@class='fw-normal blue pb-2']"));
 
		Runtime.getRuntime().exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\fileupload.exe");
 
		MethodActions.waitEle(By.xpath("//button[@class='el-button text-center upload-btn el-button--danger']"));
 
	}
 
	public void Selecttofillrec() throws Exception {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
 
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select']"));
 
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
 
	}
 
	public void Selectautofill() throws Throwable {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Add fields']"));
		Thread.sleep(10000);
	}
 
	public void PCOnedoc() throws Exception {
 
		MethodActions.waitEle(By.xpath("//span[@class='el-checkbox__inner']"));
	}
 
	public void ValidPCOneDoc() {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Next']")));
		Assert.assertNotNull(Message1, "Next button is not present Create document failed");
		System.out.println("Process as a single Document successfull");
 
	}
 
	public void Nextbt() throws Exception {
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Next']"));
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
 
		MethodActions.waitEle(By.xpath("//img[@src='/img/Add Recipients.0f0af0e8.svg']"));
 
	}
 
	public void AddRepApprover() throws Exception {
 
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select contact type']"));
 
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[36]"));
 
		MethodActions.waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Search with Email']"));
 
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[4]"));
 
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select Signer Type']"));
 
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));
 
	}
 
	public void ValidAddRepApprover() {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@x-placement]//ul//li[3]")));
		Assert.assertNotNull(Message1, "Approver present in Add Recipient failed");
		System.out.println("Adding Approver is successfull");
	}
 
	public void AddRepSigner() throws Exception {
 
		MethodActions.waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select contact type']"));
 
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[12]"));
 
		MethodActions.waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Search with Email']"));
 
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
 
		MethodActions.waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select Signer Type']"));
 
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
 
		// span[normalize-space()='Save Users']"
	}
 
	public void ValidAddRepSigner() {
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Message1 = wait2
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@x-placement]//ul//li[1]")));
		Assert.assertNotNull(Message1, "Signer present in Add Recipient failed");
		System.out.println("Signer  is successfull");
	}
 
	public void Addrepsigner1() throws Exception {
 
		Thread.sleep(1000);
 
		MethodActions.waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select contact type']"));
 
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[12]"));
 
		Thread.sleep(10000);
 
		MethodActions.waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Search with Email']"));
 
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
 
		MethodActions.waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select Signer Type']"));
 
		Thread.sleep(10000);
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
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
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save Users']"));
 
	}
 
	public void SaveAsDraft() throws Exception {
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Save Draft']"));
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
 
	public void SenderFields() throws InterruptedException {
 
		Thread.sleep(10000);
		Actions actions1 = new Actions(driver);
 
		WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
 
		WebElement signElement = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		waitAndClick(actions1, signElement, targetElement, 10, 10);
		System.out.println("Signature Element Drag and Drop Done");
 
		WebElement fullNameElement = driver.findElement(By.xpath("//button[@id='fullNameEle']"));
		waitAndClick(actions1, fullNameElement, targetElement, 50, 50);
		System.out.println("FullName Drag and Drop Done");
 
		WebElement initialElement = driver.findElement(By.xpath("//button[@id='initialEle']"));
		waitAndClick(actions1, initialElement, targetElement, 90, 90);
		System.out.println("Initial Drag and Drop Done");
 
	}
 
	public void waitAndClick(Actions actions, WebElement sourceElement, WebElement targetElement, int xOffset,
			int yOffset) {
		actions.clickAndHold(sourceElement).moveToElement(targetElement, xOffset, yOffset).release().build().perform();
	}
 
	public void Receiverfields() throws Exception {
		Thread.sleep(10000);
 
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
 
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
 
		Thread.sleep(10000);
		Actions actions1 = new Actions(driver);
 
		WebElement targetElement = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
 
		WebElement signElement = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		waitAndClick(actions1, signElement, targetElement, 10, 10);
		System.out.println("Signature Element Drag and Drop Done");
 
		WebElement fullNameElement = driver.findElement(By.xpath("//button[@id='fullNameEle']"));
		waitAndClick(actions1, fullNameElement, targetElement, 50, 50);
		System.out.println("FullName Drag and Drop Done");
 
		WebElement initialElement = driver.findElement(By.xpath("//button[@id='initialEle']"));
		waitAndClick(actions1, initialElement, targetElement, 90, 90);
		System.out.println("Initial Drag and Drop Done");
 
	}
 
	public void VerifyApproverfields() throws Exception {
		Thread.sleep(10000);
 
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
 
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
 
		// ... (omitting the previous code for brevity)
 
		// Sign
		WebElement Sign = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='signatureEle']")));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		System.out.println("Signature Element Drag and Drop Done");
 
		Actions actions = new Actions(driver);
 
		waitAndClick(actions, Sign, Target);
		System.out.println("Sign Element Drag and Drop Done");
 
	}
 
	public void Signerfields() throws Exception {
		Thread.sleep(10000);
 
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
 
		MethodActions.waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));
 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
 
		// ... (omitting the previous code for brevity)
 
		// Sign
		WebElement Sign = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='signatureEle']")));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		System.out.println("Signature Element Drag and Drop Done");
 
		Actions actions = new Actions(driver);
 
		waitAndClick(actions, Sign, Target);
		System.out.println("Sign Element Drag and Drop Done");
 
	}
 
	public void Settings() throws Exception {
 
		MethodActions.waitEle(By.xpath("//img[@src='/img/Icon-ellipsis-v.eb3a1342.svg']"));
 
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[1]"));
 
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
 
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Secure E-Sign'])[1]"));
 
		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[2]"));
 
		MethodActions.waitEle(By.xpath("(//i[@class='el-dialog__close el-icon el-icon-close'])[26]"));
 
	}
 
	@SuppressWarnings("deprecation")
	public void changedoc() throws InterruptedException, Exception {
 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
 
		MethodActions.waitEle(By.xpath("//img[@src='/img/Icon-ellipsis-v.eb3a1342.svg']"));
 
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[2]"));
 
		MethodActions.waitEle(By.xpath("//img[@src='/img/attachment-filling.da0448d7.svg']"));
 
		Runtime.getRuntime().exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\fileupload.exe");
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Continue']"));
 
		Actions actions1 = new Actions(driver);
 
		WebElement Target = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"svg\"]")));
 
		// Sign
		WebElement Sign = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='signatureEle']")));
		actions1.clickAndHold(Sign).moveToElement(Target).release().build().perform();
 
		MethodActions.waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='EMPLOYEE-1']"));
 
		// signature
 
		Actions actions = new Actions(driver);
 
		WebElement Target1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"svg\"]")));
 
		// Sign
		WebElement Sign1 = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='signatureEle']")));
		actions.clickAndHold(Sign1).moveToElement(Target1).release().build().perform();
 
	}
 
	public void Lockfields() throws Exception {
 
		MethodActions.waitEle(By.xpath("//img[@src='/img/Icon-ellipsis-v.eb3a1342.svg']"));
 
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[3]"));
 
	}
 
	public void Senddocument() throws Exception {
		Thread.sleep(1000);
		By ad = By.xpath("//span[normalize-space()='Send Document']");
 
		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));
 
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("Element clicked using JS.");
		} catch (Exception e) {
 
			System.out.println("Element not clickable or not found: ");
		}
 
 
		System.out.println("click on send Doc after drag and drop done successfully");
		try {
			MethodActions.waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {
 
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By ele = By.xpath("//textarea[@placeholder='Subject']");
		WebElement sen = wait.until(ExpectedConditions.elementToBeClickable(ele));
		sen.sendKeys("Test Sample");
 
		By ele2 = By.xpath("//textarea[@placeholder='Type your text here']");
		WebElement sen2 = wait.until(ExpectedConditions.elementToBeClickable(ele2));
		sen2.sendKeys("Test Sample");
		Thread.sleep(5000);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Send Document']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
 
	}
 
	public void TextAndMsg() throws InterruptedException {
 
		try {
			MethodActions.waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {
 
		}
		try {
			MethodActions.waitEle(By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']"));
		} catch (Exception e) {
 
		}
//		Thread.sleep(10000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
//		
//		By Subject = By.xpath("//div[@class='el-textarea']");
//		WebElement Subject2 = wait.until(ExpectedConditions.elementToBeClickable(Subject));
//		Subject2.sendKeys("Please fill all sender fields");
//		
//		Thread.sleep(10000);
//		By Text = By.xpath("//div[@class='border-0 el-textarea']");
//		WebElement Text2 = wait.until(ExpectedConditions.elementToBeClickable(Text));
//		Text2.sendKeys("Please fill all sender fields correctly");
//		Thread.sleep(10000);
 
		By ad = By.xpath("//button[@class='el-button fs-7 el-button--danger']");
 
		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));
 
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("Element clicked using JS.");
		} catch (Exception e) {
 
			System.out.println("Element not clickable or not found: ");
		}
 
	}
 
	public void Viewdoc() throws Exception {
 
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='View Document']"));
 
	}
 
	public void OtherOptions() throws InterruptedException {
 
		Thread.sleep(10000);
 
		By ad = By.xpath("//div[@class='el-dropdown']");
 
		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));
 
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("Element clicked using JS.");
		} catch (Exception e) {
 
			System.out.println("Element not clickable or not found: ");
		}
	}
 
	public void otheroptionsfinishlater() throws Exception {
 
		Thread.sleep(10000);
 
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[1]"));
 
	}
 
	@SuppressWarnings("deprecation")
	public void otheroptionsprintandsign() throws Exception {
 
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[2]"));
 
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Download Document']"));
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Continue']"));
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Upload a File']"));
		Runtime.getRuntime().exec("C:\\Users\\ramya.sibbala\\OneDrive - Nimble Accounting\\Documents\\fileupload.exe");
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Finish']"));
	}
 
	public void Otheroptionsdownload() throws Exception {
 
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[3]"));
 
	}
 
	public void otheroptionshistory() throws Exception {
 
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[4]"));
 
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
 
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Download History'])[1]"));
 
		MethodActions.waitEle(By.xpath("(//i[@class='el-dialog__close el-icon el-icon-close'])[18]"));
	}
 
	public void otheroptionssettings() throws Exception {
		Thread.sleep(null);
 
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[5]"));
 
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
 
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Secure E-Sign'])[1]"));
 
		MethodActions.waitEle(By.xpath("(//span[@class='el-checkbox__inner'])[2]"));
 
		MethodActions.waitEle(By.xpath("(//i[@class='el-dialog__close el-icon el-icon-close'])[26]"));
	}
 
	public void otheroptionsCorrectdoc() throws Exception {
 
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[6]"));
 
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Yes'])[2]"));
 
	}
 
	public void otheroptionssaveastem() throws Exception {
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[7]"));
 
	}
 
	public void otheroptionsvoiddoc() throws Exception {
		Thread.sleep(null);
 
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[8]"));
 
		MethodActions.waitEle(By.xpath("(//span[normalize-space()='Yes'])[2]"));
 
	}
 
	public void otheroptionsdelete() throws Exception {
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[9]"));
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='OK']"));
 
	}
 
	public void Previousbtn() throws Exception {
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='PREV FIELD']"));
 
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));
 
	}
 
	public void Nextbtn() throws Exception {
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
 
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));
 
	}
 
	public void FinishDoc() throws Exception {
		MethodActions.waitEle(By.xpath("//span[normalize-space()='FINISH']"));
	}
 
	public void Chat() throws Exception {
 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Chat']"));
 
		By comment = By.xpath("//textarea[@placeholder='Enter comments here...']");
		WebElement comment2 = wait.until(ExpectedConditions.elementToBeClickable(comment));
		comment2.sendKeys("no comments");
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Post']"));
	}
 
//	public void FillRF() {
//		
//		
//		
//	}
	public void Logs() throws Exception {
 
		MethodActions.waitEle(By.xpath("//span[normalize-space()='Logs']"));
 
	}
//	"C:\Users\ramya.sibbala\OneDrive - Nimble Accounting\Documents\fileupload.exe"
 

public void Signinramya() throws InterruptedException {
	Thread.sleep(10000);
//	driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
//			.sendKeys("N180959@rguktn.ac.in");
//	driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Ramya@1234");
//	driver.findElement(By.xpath("//span[normalize-space()='Log In']")).click();
	driver.findElement(By.xpath("//input[@placeholder='Ex: johnwesley@abc.com']"))
	.sendKeys("ramya.sibbala@nimbleaccounting.com");
	driver.findElement(By.xpath("//input[@placeholder='Enter Password']")).sendKeys("Ramyasri@123");
	driver.findElement(By.xpath("//button[@class='el-button type-2 w-100 fs-6 el-button--danger']")).click();
	Thread.sleep(10000);

}}
