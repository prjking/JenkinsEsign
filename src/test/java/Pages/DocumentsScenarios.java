package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DocumentsScenarios {
	WebDriver driver;

	public DocumentsScenarios(WebDriver driver) {

		this.driver = driver;

	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
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

	public void DocScenario() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			// System.out.println("Overlay not found or not invisible.");
		}

		By ad = By.xpath("//span[normalize-space()='Documents']");

		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			WebElement docu = wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//h3[@class='fw-medium blue-dark mb-3 fs-6']")));
			Assert.assertNotNull(docu, "Documents");
			// System.out.println("Clicked On Documents using JS successfully");

		} catch (Exception e) {

			// System.out.println("Element not clickable or not found: ");
		}
		waitEle(By
				.xpath("//button[@class='el-button scaling-button el-button--primary is-plain create-btn px-4 ml-2']"));

	}

	public void Blankdocloginaccount() throws Exception {

		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		try {
			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}

		waitEle(By.xpath("//img[@src='/img/Blank.1f314c3f.svg']"));
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}

		Thread.sleep(10000);

		By Docname1 = By.xpath("//input[@placeholder='Enter Document name']");
		WebElement Docnameen = wait.until(ExpectedConditions.elementToBeClickable(Docname1));
		Docnameen.sendKeys("test");

		driver.findElement(By.xpath("(//span[normalize-space()='Continue'])[2]")).click();
//		WebElement doc = wait
//				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='fw-bold fs-24']")));
//		Assert.assertNotNull(doc, "Add Recepient element is not present Create document failed");
//		// System.out.println("Selected BlankDocument successfull");

	}

	public void Recipients() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
		//// System.out.println("Selected Recipients Successfully");

	}

	public void RecipientsCC() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select contact type']"));

		WebElement element = driver.findElement(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Search with Email']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select Signer Type']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		// System.out.println("Selected Recipients For CC Successfully");

	}

	public void Saveuser() throws Exception {

		waitEle(By.xpath("//span[normalize-space()='Save Users']"));
		//// System.out.println("Users Saved Successfully");

	}

	public void Signorder() throws Exception {

		waitEle(By.xpath("//span[normalize-space()='Enforce Signature Order']"));
		// System.out.println("Signorder Unchecked Successfully");

	}

	public void EssentialFields() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

		Actions actions = new Actions(driver);

		WebElement Sign = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions, Sign, Target);
		//// System.out.println("Sign Element Drag and Drop Done");

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));

		// fullNameEle
		WebElement fullName = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		// companyEle
		WebElement company = driver.findElement(By.xpath("//button[@id='companyEle']"));

		waitAndClick(actions, fullName, Target);
		//// System.out.println("Fullname Element Drag and Drop Done");

		waitAndClick(actions, company, Target);
		//// System.out.println("company Element Drag and Drop Done");

	}

	public void EssentialFields1() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

		Actions actions = new Actions(driver);

		WebElement Sign = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions, Sign, Target);
		// System.out.println("Sign Element Drag and Drop Done");

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));

		WebElement fullName = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		waitAndClick(actions, fullName, Target);
		// System.out.println("FullName Element Drag and Drop Done");

	}

	public void EssentialFieldscc() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

		Actions actions = new Actions(driver);

		WebElement Sign = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions, Sign, Target);
		// System.out.println("Sign Element Drag and Drop Done");

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[3]"));

		WebElement fullName = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		waitAndClick(actions, fullName, Target);
		// System.out.println("FullName Element Drag and Drop Done");

	}

	public void Senddoc() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='Send Document']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By overlayLocator = By.xpath("//div[@role='alert']//div[@class='el-notification__closeBtn el-icon-close']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			// System.out.println("Overlay not found or not invisible.");
		}
		Thread.sleep(10000);

		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Send Document']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		//// System.out.println("Document Submitted Sucessfully");
		waitEle(By.xpath("//span[normalize-space()='View Document']"));
		//// System.out.println("Clicked Submitted Sucessfully");

	}

	public void Blankwithoutsenderautofill() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		waitEle(By.xpath("//span[normalize-space()='Edit']"));
		driver.findElement(By.xpath("//input[@placeholder='Enter signature']")).sendKeys("Prj");

		waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));

		//// System.out.println("mySignatureEle Element opened With Double Click and
		//// Entered New Sign Data Successfully");
	}

	public void DocscenarioOnedrive() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		Thread.sleep(10000);

		waitEle(By.xpath("//img[@src='/img/onedrive.cc38d634.svg']"));

		// System.out.println("Selected Onedrive Sucessfully");

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
				Thread.sleep(10000);
				waitEle(By.id("idSIButton9"));

				Thread.sleep(10000);

				By password = By.id("idSIButton9");
				WebElement Upload1 = wait.until(ExpectedConditions.elementToBeClickable(password));
				Upload1.sendKeys("Prjking@99");

				waitEle(By.id("idSIButton9"));
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

				waitEle(By.xpath("//span[@title='Upload']"));
				Thread.sleep(10000);
				waitEle(By.xpath("//span[normalize-space()='Next']"));

				// System.out.println("Selected File From Onedrive and Uploaded Sucessfully");

			}
		}
	}

	public void DocscenariosGdrive() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//img[@placeholder=\"top-start\"]"));

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		String Parentwindowid = driver.getWindowHandle();
		waitEle(By.xpath("//span[normalize-space()=\"Sign in with Google\"]"));
		Set<String> allwindowhandles = driver.getWindowHandles();
		for (String childwindow : allwindowhandles) {
			if (!childwindow.endsWith(Parentwindowid)) {
				driver.switchTo().window(childwindow);
				Thread.sleep(10000);
				driver.findElement(By.xpath("//input[@id=\"identifierId\"]")).sendKeys("n180894@rguktn.ac.in");

				waitEle(By.xpath("//span[normalize-space()=\"Next\"]"));
				Thread.sleep(10000);
				Set<String> windowHandles1 = driver.getWindowHandles();
				for (String handle : windowHandles1) {
					driver.switchTo().window(handle);

				}
				driver.findElement(By.xpath("//input[@name=\"Passwd\"]")).sendKeys("meghu@123");
				waitEle(By.xpath("//span[normalize-space()=\"Next\"]"));
				Thread.sleep(10000);
				Set<String> windowHandles11 = driver.getWindowHandles();
				for (String handle : windowHandles11) {
					driver.switchTo().window(handle);

				}

				waitEle(By.xpath("//span[normalize-space()=\"Allow\"]"));
				Set<String> windowHandles111 = driver.getWindowHandles();
				for (String handle : windowHandles111) {
					driver.switchTo().window(handle);

				}
				Thread.sleep(10000);
				waitEle(By.xpath("//span//span[normalize-space()=\"car prediction.pdf\"]"));
				Set<String> windowHandles2 = driver.getWindowHandles();
				for (String handle : windowHandles2) {
					driver.switchTo().window(handle);

				}
				waitEle(By.xpath("//span[@class=\"fsp-button fsp-button--primary fsp-button-upload\"]"));

			}
		}

	}

	public void Rearrange() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement CC = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_2']")));
		WebElement Signer = driver.findElement(By.xpath("//div[@id='user_1']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(CC).moveToElement(Signer).release().build().perform();
		// System.out.println("Rearranged Fields Sucessfully");

	}

	public void MultipleSigners() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Search with Email']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[4]"));

		Thread.sleep(10000);
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		WebElement element1 = driver.findElement(By.xpath("//div[@x-placement]//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		Thread.sleep(1000);
		element1.click();

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		// System.out.println("Multi-Signers Added Sucessfully");

	}

	public void MultipleSignersEssentialFields() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

		Actions actions = new Actions(driver);

		WebElement Sign = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions, Sign, Target);
		// System.out.println("Sign Element Drag and Drop Done");

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));

		WebElement fullName = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		waitAndClick(actions, fullName, Target);
		// System.out.println("FullName Element Drag and Drop Done");
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[3]"));

		WebElement fullName1 = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		waitAndClick(actions, fullName1, Target);
		// System.out.println("FullName Element Drag and Drop Done");
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[4]"));

		WebElement fullName2 = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		waitAndClick(actions, fullName2, Target);
		// System.out.println("FullName Element Drag and Drop Done");
	}

	public void RearrangeSender() throws Exception {

		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Sender = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_0']")));
		WebElement Drop = driver.findElement(By.xpath("//div[@id='user_1']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(Sender).moveToElement(Drop).release().build().perform();
		// System.out.println("Sender Element Rearranged ");

	}

	public void Approver() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Search with Email']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select Signer Type']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));
		// System.out.println("Approver Element Selected Sucessfully ");

		waitEle(By.xpath("//span[normalize-space()='Enforce Signature Order']"));

		waitEle(By.xpath("//span[normalize-space()='Save Users']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

		Actions actions = new Actions(driver);

		WebElement Sign = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions, Sign, Target);
		// System.out.println("Sign Element Drag and Drop Done");

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));

		WebElement fullName = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		waitAndClick(actions, fullName, Target);
		// System.out.println("FullName Element Drag and Drop Done");
		// System.out.println("Approver Added Sucessfully");

	}

	// Meghana
	public void SignatureAndFullNameFeilds() throws Exception {
		Thread.sleep(10000);
		Actions actions1 = new Actions(driver);

		WebElement Sign1 = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target1 = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions1, Sign1, Target1);
		// System.out.println("Signature Element Drag and Drop Done");

		WebElement fullName1 = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		waitAndClick(actions1, fullName1, Target1);
		// System.out.println("FullName Drag and Drop Done");
	}

	public void DragAndDropAtThree() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[3]"));
		SignatureAndFullNameFeilds();

	}

	public void DradAndDropAtTwo() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));
		SignatureAndFullNameFeilds();

	}

	public void multipleApprover() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select contact type']"));

		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select Signer Type']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));
		// System.out.println("Approver Element 1 Selected Sucessfully ");

		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[5]"));

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Select Signer Type']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));
		// System.out.println("Approver Element 2 Selected Sucessfully ");
	}

	public void CCAtFour() throws Exception {

		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_4']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@id='user_4']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("//div[@id='user_4']//input[@placeholder='Select Signer Type']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
		// System.out.println("selected CC At 4");
	}

	public void dragaAndDropAtFour() throws Exception {
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[4]"));

		SignatureAndFullNameFeilds();
	}

	public void DragAndDropAtThreeFour() throws Exception {

		Thread.sleep(10000);

		DragAndDropAtThree();
		// At four
		dragaAndDropAtFour();
	}

	public void multipleCCThreeFour() throws Exception {

		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[6]"));

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Select Signer Type']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
		// System.out.println("CC Element Selected Successfully");
		CCAtFour();

	}

	public void multipleCCFourFive() throws Exception {
		Thread.sleep(10000);
		CCAtFour();

		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_5']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@id='user_5']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[6]"));

		waitEle(By.xpath("//div[@id='user_5']//input[@placeholder='Select Signer Type']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
		// System.out.println("Multiple CC selected successfully");
	}

	public void RearrangeThreeOne() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement CC = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_3']")));
		WebElement Signer = driver.findElement(By.xpath("//div[@id='user_1']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(CC).moveToElement(Signer).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void RearrangeAtThreeTwo() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement CC = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_3']")));
		WebElement Signer = driver.findElement(By.xpath("//div[@id='user_2']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(CC).moveToElement(Signer).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void multipleSigner() throws Exception {
		Recipients();
		// System.out.println("signer Element Selected Successfully");
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[6]"));
		// System.out.println("signer Element Selected Successfully");
	}

	public void ApproverThree() throws Exception {

		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Select Signer Type']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));
		// System.out.println("Approver Element Selected Sucessfully ");
	}

	public void RearrangeZeroTwo() throws Exception {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement CC = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_0']")));
		WebElement Signer = driver.findElement(By.xpath("//div[@id='user_2']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(CC).moveToElement(Signer).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void scrollDown() throws Exception {

		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@class='select-recipients']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 100;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();
		// System.out.println("ScrollDown done successfully");
	}

	public void scrollUp() {
		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@class='select-recipients']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 0;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();
		// System.out.println("ScrollUp done successfully");
	}

	public void Approver1() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select Signer Type']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));
		// System.out.println("Approver Element Selected Sucessfully ");
	}

	public void RecipientsCC3() throws Exception {

		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Select Signer Type']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));
		// System.out.println("Selected CC Successfully");
	}

//Ramya
	public void AddMultipleSigners() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[6]"));

		// System.out.println("Signer1 added successfully");

		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[4]"));

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Search with Email']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		// System.out.println("Signer2 added successfully");

	}

	public void AddRecipientsCC() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Select Signer Type']"));
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		// System.out.println("CC added successfully");

	}

	public void AddApprover() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		WebElement element = driver.findElement(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@id='user_3']//input[@placeholder='Select Signer Type']"));
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));
		// System.out.println("Approver added successfully");

	}

	public void AddRearrangeAPPSignerSenderThreeOne() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Approver = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_3']")));
		WebElement Signer = driver.findElement(By.xpath("//div[@id='user_1']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(Approver).moveToElement(Signer).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void AddRearrangeSender() throws Exception {

		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@class='select-recipients']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 0;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();

		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Sender = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_0']")));
		WebElement Approver = driver.findElement(By.xpath("//div[@id='user_1']"));
		Actions actions1 = new Actions(driver);
		actions1.clickAndHold(Sender).moveToElement(Approver).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void AddRearrangeZeroFour() throws Exception {
		Thread.sleep(10000);
		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@class='select-recipients']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 100;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Sender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='user_1']")));
		WebElement Signer = driver.findElement(By.xpath("//div[@id='user_3']"));
		Actions actions1 = new Actions(driver);
		actions1.clickAndHold(Sender).moveToElement(Signer).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void AddEssentialFields() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[4]"));

		Actions actions = new Actions(driver);

		WebElement Sign = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions, Sign, Target);
		// System.out.println("Sign Element Drag and Drop Done");

		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[3]"));

		// fullNameEle
		WebElement fullName = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		// companyEle
		WebElement company = driver.findElement(By.xpath("//button[@id='companyEle']"));

		waitAndClick(actions, fullName, Target);
		// System.out.println("Fullname Element Drag and Drop Done");

		waitAndClick(actions, company, Target);
		// System.out.println("company Element Drag and Drop Done");

	}

	public void AddEssentialFields1() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));

		Actions actions = new Actions(driver);

		WebElement Sign = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions, Sign, Target);
		// System.out.println("Sign Element Drag and Drop Done");

		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

		WebElement fullName = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		waitAndClick(actions, fullName, Target);
		// System.out.println("FullName Element Drag and Drop Done");

	}

	public void AddEssentialFieldscc() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

		Actions actions = new Actions(driver);

		WebElement Sign = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions, Sign, Target);
		// System.out.println("Sign Element Drag and Drop Done");

		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));

		WebElement fullName = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		waitAndClick(actions, fullName, Target);
		// System.out.println("FullName Element Drag and Drop Done");

	}

	public void AddEssentialFieldsccSender() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[3]"));

		Actions actions = new Actions(driver);

		WebElement Sign = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions, Sign, Target);
		// System.out.println("Sign Element Drag and Drop Done");

		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[4]"));

		WebElement fullName = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		waitAndClick(actions, fullName, Target);
		// System.out.println("FullName Element Drag and Drop Done");

	}

	public void AddRearrangeSignerSenderCCThreeOne() throws Exception {
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement Signer2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_2']")));

		WebElement Signer1 = driver.findElement(By.xpath("//div[@id='user_1']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(Signer2).moveToElement(Signer1).release().build().perform();

		// System.out.println("Rearrangement done");
	}

	public void AddRearrangeSigners() throws Exception {

		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@class='select-recipients']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 0;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();

		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		WebElement Sender = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_0']")));

		WebElement Signer2 = driver.findElement(By.xpath("//div[@id='user_1']"));

		Actions actions1 = new Actions(driver);

		actions1.clickAndHold(Sender).moveToElement(Signer2).release().build().perform();

		// System.out.println("Rearrangement done");
	}

	public void AddRearrangeOneTwo() throws Exception {
		Thread.sleep(10000);
		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@class='select-recipients']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 100;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Sender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='user_1']")));
		WebElement Signer = driver.findElement(By.xpath("//div[@id='user_2']"));
		Actions actions1 = new Actions(driver);
		actions1.clickAndHold(Sender).moveToElement(Signer).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void AddRearrangeSenderCCSignersThreeOne() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Approver = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_3']")));
		WebElement Signer = driver.findElement(By.xpath("//div[@id='user_1']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(Approver).moveToElement(Signer).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void AddRearrangeCCSignerSENDERThreeOne() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Approver = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_3']")));
		WebElement Signer = driver.findElement(By.xpath("//div[@id='user_1']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(Approver).moveToElement(Signer).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void AddRearrangeccsignersender() throws Exception {

		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@class='select-recipients']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 0;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();

		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Sender = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_0']")));
		WebElement Approver = driver.findElement(By.xpath("//div[@id='user_1']"));
		Actions actions1 = new Actions(driver);
		actions1.clickAndHold(Sender).moveToElement(Approver).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void AddRearrangeZeroFour1() throws Exception {
		Thread.sleep(10000);
		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@class='select-recipients']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 100;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Sender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='user_1']")));
		WebElement Signer = driver.findElement(By.xpath("//div[@id='user_3']"));
		Actions actions1 = new Actions(driver);
		actions1.clickAndHold(Sender).moveToElement(Signer).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void AddRearrangeMulApproverSENDERThreeOne() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Approver = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_2']")));
		WebElement Signer = driver.findElement(By.xpath("//div[@id='user_0']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(Approver).moveToElement(Signer).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void AddRearrangeMultipleApproverssender() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Approver = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_2']")));
		WebElement Signer = driver.findElement(By.xpath("//div[@id='user_1']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(Approver).moveToElement(Signer).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void AddSenderFields() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

		Actions actions = new Actions(driver);

		WebElement Sign = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions, Sign, Target);
		// System.out.println("Sign Element Drag and Drop Done");
	}

	public void AddRearrangeSenderFields() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[3]"));

		Actions actions = new Actions(driver);

		WebElement Sign = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions, Sign, Target);
		// System.out.println("Sign Element Drag and Drop Done");
	}

	public void AddRearrangeSenderFields1() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[4]"));

		Actions actions = new Actions(driver);

		WebElement Sign = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions, Sign, Target);
		// System.out.println("Sign Element Drag and Drop Done");
	}

	public void AddSenderFields2() throws Exception {
		Thread.sleep(10000);
		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));

		Actions actions = new Actions(driver);

		WebElement Sign = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions, Sign, Target);
		// System.out.println("Sign Element Drag and Drop Done");
	}

	public void AddMultipleAPPFields() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));

		Actions actions = new Actions(driver);
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		WebElement fullName = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		waitAndClick(actions, fullName, Target);
		// System.out.println("Fullname Element Drag and Drop Done");

		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[3]"));

		Actions actions1 = new Actions(driver);
		WebElement Target1 = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		WebElement fullName1 = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		waitAndClick(actions1, fullName1, Target1);
		// System.out.println("Fullname Element Drag and Drop Done");
	}

	public void AddRearrangeMultipleAPPFields() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]"));

		Actions actions = new Actions(driver);
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		WebElement fullName = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		waitAndClick(actions, fullName, Target);
		// System.out.println("Fullname Element Drag and Drop Done");

		Thread.sleep(10000);

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]"));

		Actions actions1 = new Actions(driver);
		WebElement Target1 = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		WebElement fullName1 = driver.findElement(By.xpath("//button[@id='fullNameEle']"));

		waitAndClick(actions1, fullName1, Target1);
		// System.out.println("Fullname Element Drag and Drop Done");
	}

	public void AddFinishdocument() throws Exception {
		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='Finish Document']"));
		// System.out.println("Finish Document successfull");
	}

	public void AddMultipleApprovers() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select contact type']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[4]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Search with Email']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select Signer Type']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		// System.out.println("Approver1 added successfully");

		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select contact type']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[4]"));
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Search with Email']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select Signer Type']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		// System.out.println("Approver2 added successfully");

	}

	public void AddMultipleCC() throws Exception {

		Thread.sleep(10000);
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[4]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[6]"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select Signer Type']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		// System.out.println("CC1 added successfully");

		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[4]"));

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Search with Email']"));
		Thread.sleep(10000);

		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select Signer Type']"));

		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		// System.out.println("CC2 added successfully");

	}

	public void AddRearrangeCCSenderSignerThreeOne() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Signer2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_3']")));
		WebElement Signer1 = driver.findElement(By.xpath("//div[@id='user_1']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(Signer2).moveToElement(Signer1).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void AddRearrangeSendercc() throws Exception {

		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@class='select-recipients']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 0;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();

		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Sender = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_0']")));
		WebElement Signer2 = driver.findElement(By.xpath("//div[@id='user_1']"));
		Actions actions1 = new Actions(driver);
		actions1.clickAndHold(Sender).moveToElement(Signer2).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void AddRearrangeSignersCCSenderThreeOne() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Approver = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_2']")));
		WebElement Signer = driver.findElement(By.xpath("//div[@id='user_1']"));
		Actions actions = new Actions(driver);
		actions.clickAndHold(Approver).moveToElement(Signer).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void AddRearrangeCC() throws Exception {

		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@class='select-recipients']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 0;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();

		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Sender = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='user_0']")));
		WebElement Approver = driver.findElement(By.xpath("//div[@id='user_1']"));
		Actions actions1 = new Actions(driver);
		actions1.clickAndHold(Sender).moveToElement(Approver).release().build().perform();
		// System.out.println("Rearrangement done");
	}

	public void AddRearrangeOnetoThree() throws Exception {
		Thread.sleep(10000);
		WebElement scrollbar = driver.findElement(By.xpath(
				"//div[@class='select-recipients']/div[@class='el-scrollbar']/div[@class='el-scrollbar__bar is-vertical']/div[@class='el-scrollbar__thumb']"));

		Actions actions = new Actions(driver);

		actions.clickAndHold(scrollbar).perform();

		int offset = 100;
		actions.moveByOffset(0, offset).perform();

		actions.release().perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement Sender = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='user_1']")));
		WebElement Signer = driver.findElement(By.xpath("//div[@id='user_3']"));
		Actions actions1 = new Actions(driver);
		actions1.clickAndHold(Sender).moveToElement(Signer).release().build().perform();
		// System.out.println("Rearrangement done");
	}

}
