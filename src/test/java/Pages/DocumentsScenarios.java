
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
		Thread.sleep(10000);
		waitEle(By.xpath("//span[@class='create-doc']"));

	}

	public void Blankdocloginaccount() throws Exception {

		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		try {
			By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

		}

		waitEle(By.xpath("(//img[@class='el-tooltip upload-icon'])[1]"));

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
		Thread.sleep(10000);
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

		waitEle(By.xpath("//div[@x-placement]//li[1]"));

		Actions actions = new Actions(driver);

		WebElement Sign = driver.findElement(By.xpath("//button[@id='signatureEle']"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));

		waitAndClick(actions, Sign, Target);
		//// System.out.println("Sign Element Drag and Drop Done");

		waitEle(By.xpath("//input[@placeholder='Select a Recipient']"));

		waitEle(By.xpath("//div[@x-placement]//li[2]"));

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

//	public void Blankwithoutsenderautofill() throws Exception {
//		Thread.sleep(10000);
//		waitEle(By.xpath("//span[normalize-space()='NEXT FIELD']"));
//		Set<String> windowHandles = driver.getWindowHandles();
//		for (String handle : windowHandles) {
//			driver.switchTo().window(handle);
//		}
//		waitEle(By.xpath("//span[normalize-space()='Edit']"));
//		driver.findElement(By.xpath("//input[@placeholder='Enter signature']")).sendKeys("Prj");
//
//		waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
//		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));
//
//		//// System.out.println("mySignatureEle Element opened With Double Click and
//		//// Entered New Sign Data Successfully");
//	}
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

	public void autofilloff() throws Exception {
		Thread.sleep(5000);
		waitEle(By.xpath("(//div[@class=\"icon-text\"])[1]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//li[text()=\" Settings \"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//a[text()=\"Application Settings\"]"));

		try {
			waitEle(By.xpath(
					"//label[@class=\"el-checkbox is-checked\"]//span[text()=\" Auto-complete sender if all fields filled\"]"));
		} catch (Exception e) {
			System.out.println("without auto fill");
		}

		Thread.sleep(5000);
		waitEle(By.xpath("//span[text()=\"Save Changes\"]"));

	}

	public void VerifyDocCompleteReceiverEnd() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement welcomeMessage = wait.until(
					ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()=\"Document Completed! \"]")));

			Assert.assertNotNull(welcomeMessage, "");
			System.out.println("Document Signatures Completed At Receiver End Successfully");
			driver.close();
		} catch (Exception e) {
			System.out.println("Document not Completed At Receiver End");
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

	public void validateAtCC(String s) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement welcomeMessage = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(String.format("(//span[contains(text(),'%s')])[1]", s))));

		Assert.assertNotNull(welcomeMessage, "Not signed by all the signers");
		System.out.println("email received at cc");
	}

	public void autofillon() throws Exception {
		Thread.sleep(5000);
		waitEle(By.xpath("(//div[@class=\"icon-text\"])[1]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//li[text()=\" Settings \"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//a[text()=\"Application Settings\"]"));
		Thread.sleep(5000);
		try {
			waitEle(By.xpath(
					"//label[@class=\"el-checkbox\"]//span[text()=\" Auto-complete sender if all fields filled\"]"));
		} catch (Exception e) {
			System.out.println("with auto fill");
		}
		waitEle(By.xpath("//span[text()=\" Auto-complete sender if all fields filled\"]"));
		Thread.sleep(10000);
		waitEle(By.xpath("//span[text()=\"Save Changes\"]"));

	}

	public void Fileuploads(String s) throws InterruptedException, Exception {
		Thread.sleep(10000);
		By Element = By.xpath("//h4[@class='fw-normal blue pb-2']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));
		canc.click();
		Runtime.getRuntime().exec(s);

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
		WebElement para = driver.findElement(By.xpath("//button[@id=\"0_entity_0\"]"));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		waitAndClick(actions, para, Target, 0, -40);
		System.out.println("paragraph Field Drag and Drop Done");
		// Image
		WebElement image = driver.findElement(By.xpath("//button[@id=\"0_entity_1\"]"));
		waitAndClick(actions, image, Target, -200, -30);
		System.out.println("Image Field Drag and Drop Done");
		// Video
		WebElement video = driver.findElement(By.xpath("//button[@id=\"0_entity_2\"]"));
		waitAndClick(actions, video, Target, 0, 0);
		System.out.println("video Field Drag and Drop Done");
		// HTML
		WebElement html = driver.findElement(By.xpath("//button[@id=\"0_entity_3\"]"));
		waitAndClick(actions, html, Target, 0, 30);
		System.out.println("HTML Field Drag and Drop Done");
		// division
		WebElement division = driver.findElement(By.xpath("//button[@id=\"0_entity_4\"]"));
		waitAndClick(actions, division, Target, 0, 60);
		System.out.println("Division Field Drag and Drop Done");
		// Heading
		WebElement heading = driver.findElement(By.xpath("//button[@id=\"0_entity_5\"]"));
		waitAndClick(actions, heading, Target, 0, 90);
		System.out.println("heading Field Drag and Drop Done");
		// Single line Content
		WebElement SingleLineContent = driver.findElement(By.xpath("//button[@id=\"0_entity_6\"]"));
		waitAndClick(actions, SingleLineContent, Target, 0, 120);
		System.out.println("SingleLineContent Field Drag and Drop Done");
		// Horizontalline
		WebElement Hline = driver.findElement(By.xpath("//button[@id=\"0_entity_7\"]"));
		waitAndClick(actions, Hline, Target, 0, 150);
		System.out.println("Horizontal Line Field Drag and Drop Done");
		// Action
		WebElement action = driver.findElement(By.xpath("//button[@id=\"0_entity_8\"]"));
		waitAndClick(actions, action, Target, 0, 180);
		System.out.println("Action Field Drag and Drop Done");

	}

	public void Viewdocument() throws Exception {

		Thread.sleep(10000);

		waitEle(By.xpath("//span[normalize-space()='View Document']"));

		System.out.println("View Document successfull");
		Thread.sleep(10000);
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
//		MethodActions.switchToNewWindow();
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

	public void RecipientSigner(int id, String email, String signerType) throws Exception {
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));
		System.out.println("Click on Add recipient done Successfully");
		String xpath = String.format("//div[@id='user_%d']//input[@placeholder='Select contact type']", id);
		waitEle(By.xpath(xpath));
		waitEle(By.xpath("//div[@x-placement]//ul//li[normalize-space()='Receiver']"));

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

	private void waitAndClick1(Actions actions, WebElement element, WebElement target) {
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

	public void FileuploadTwo() throws InterruptedException, Exception {
		Thread.sleep(5000);

		Runtime.getRuntime().exec("\"C:\\Work Space\\Esign\\src\\test\\resources\\meghana\\fileupload.exe\"");
		Thread.sleep(5000);

		System.out.println("Uploaded file successfully");
	}

	public void clickFinishDoc() throws Exception {
		Thread.sleep(5000);
		waitEle(By.xpath("//span[text()=\"Finish Document\"]"));
	}

	public void FormTemplate() throws Exception {
//			Thread.sleep(10000);
		//
//			waitEle(By.xpath("//span[@class='el-icon-arrow-down text-white']"));
		WebElement elementToHover = driver.findElement(By.xpath("//span[@class='el-icon-arrow-down text-white']"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(3000);
		waitEle(By.xpath("//li[normalize-space()=\"Form Template\"]"));

		System.out.println("Clicked on Form template in profile completed");

	}

	public void CreateFormtemplate(String s) throws Exception {

		Thread.sleep(10000);

		By ad = By.xpath("//button[normalize-space()='Create Template']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", add);
		System.out.println("clicked create FormTemplate using JS.");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));

		By Name = By.xpath("//input[@placeholder='Enter Template Title']");
		WebElement Name1 = wait.until(ExpectedConditions.elementToBeClickable(Name));
		Name1.sendKeys(s);

		By Description = By.xpath("//textarea[@placeholder='Enter Template Description']");
		WebElement Description1 = wait.until(ExpectedConditions.elementToBeClickable(Description));
		Description1.sendKeys("Test purpose");

	}

	public void templateContentFeilds() throws Exception {
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).clear();
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"),
				"templateContentFeilds");
	}

	public void submit() throws Exception {
		waitEle(By.xpath("(//span[normalize-space()='Submit'])[1]"));
		System.out.println("Click on submit done successfully");

	}

	public void contentFeildsDragAndDrop() throws Exception {
		waitEle(By.xpath("//div[text()=\"Content Fields\"]"));
		// Heading Feild
		WebElement heading = driver.findElement(By.xpath("//span[text()=\"Heading\"]"));
		WebElement Target = driver.findElement(By.xpath("//div[@class='base-parent']"));
		Actions actions = new Actions(driver);
		waitAndClick1(actions, heading, Target);
		System.out.println("Heading feild Drag and Drop Done");
		Set<String> windowHandles1 = driver.getWindowHandles();
		for (String handle : windowHandles1) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder=\"Enter content or block title\"]"),
				"Heading Feild");
		waitEle(By.xpath("//input[@placeholder=\"Select Heading Type\"]"));
		Thread.sleep(5000);
		waitEle(By.xpath("//span[text()=\"H2\"]"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// HTML field
		WebElement html = driver.findElement(By.xpath("//span[text()=\"HTML\"]"));
		waitAndClick1(actions, html, Target);
		System.out.println("html feild Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "HTMLFeild");
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter content']"),
				"content for the HTMLFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Paragraph
		WebElement Para = driver.findElement(By.xpath("//span[text()=\"Paragraph\"]"));
		waitAndClick1(actions, Para, Target);
		System.out.println("Paragraph feild Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//textarea[@placeholder='Enter content']"),
				"content for the ParagraphFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Single Line Content
		WebElement singlelineContent = driver.findElement(By.xpath("//span[text()=\"Single Line Content\"]"));
		waitAndClick1(actions, singlelineContent, Target);
		System.out.println("singlelineContent feild Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter content']"),
				"content for the singlelineContent");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Image
		WebElement Image = driver.findElement(By.xpath("//span[text()=\"Image\"]"));
		waitAndClick1(actions, Image, Target);
		System.out.println("Image feild Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "ImageFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Video
		WebElement video = driver.findElement(By.xpath("//span[text()=\"Video\"]"));
		waitAndClick1(actions, video, Target);
		System.out.println("video feild Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter Field Title']"), "videoFeild");
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Action Button
		WebElement ActionButton = driver.findElement(By.xpath("//span[text()=\"Action Button\"]"));
		waitAndClick1(actions, ActionButton, Target);
		System.out.println("Action Button feild Drag and Drop Done");
		MethodActions.sendKeysToElement(By.xpath("//input[@placeholder='Enter label']"), "Action ButtonFeild");
		waitEle(By.xpath("//span[normalize-space()=\"Add\"]"));
		waitEle(By.xpath("//input[@placeholder=\"Select type\"]"));
		waitEle(By.xpath("//li[text()=\"Update template\"]"));
		waitEle(By.xpath("(//span[normalize-space()='Insert Field'])[1]"));
		// Horizontal Line
		WebElement horizontalLine = driver.findElement(By.xpath("//span[text()=\"Horizontal Line\"]"));
		waitAndClick1(actions, horizontalLine, Target);
		System.out.println("horizontalLine feild Drag and Drop Done");
		// Division
		WebElement Division = driver.findElement(By.xpath("//span[text()=\"Division\"]"));
		waitAndClick1(actions, Division, Target);
		System.out.println("Division feild Drag and Drop Done");
		waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));

	}

	public void companyProfile() throws Exception {
		waitEle(By.xpath("(//label[@class=\"el-checkbox\"])[2]"));
		waitEle(By.xpath("//i[@class=\"fa fa-plus\"]"));
		System.out.println("click on Add to company profile done");
	}
}
