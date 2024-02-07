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

public class Dashboard {
	static WebDriver driver;

	@SuppressWarnings("static-access")
	public Dashboard(WebDriver driver) {
		Dashboard.driver = driver;
	}

	public static void highlight(WebElement element) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid blue;');", element);
	}

	public void Alldoc() throws Exception {
		Thread.sleep(10000);
		WebElement clickAllDoc = driver.findElement(By.xpath("//p[text()=\"All Documents\"]"));
		highlight(clickAllDoc);
		clickAllDoc.click();
	}

//	public boolean VerifyAlldocClick() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
//
//		WebElement name = wait.until(
//				ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class=\"fw-medium blue-dark mb-3 fs-6\"]")));
//		System.out.println("click on all documents done Sucessfully");
//		return name.isDisplayed();
//	}
	public void waitingForMe() throws Exception {
		Thread.sleep(10000);
		WebElement clickWaitOther = driver.findElement(By.xpath("//p[text()=\"Waiting for Me\"]"));
		highlight(clickWaitOther);
		clickWaitOther.click();
	}

	public boolean VerifywaitingForMeClick() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()=\" Documents Waiting for Me \"]")));
		System.out.println("Click on Waiting for others documents done Sucessfully");
		return name.isDisplayed();
	}

	public void waitOthers() throws Exception {
		Thread.sleep(10000);
		WebElement clickWaitOther = driver.findElement(By.xpath("//p[text()=\"Waiting for Others\"]"));
		highlight(clickWaitOther);
		clickWaitOther.click();
	}

	public boolean VerifyWaitingForOthersClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement name = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h3[text()=\" Documents Waiting for Others \"]")));
		System.out.println("Click on Waiting for others documents done Sucessfully");
		return name.isDisplayed();
	}

	public void Draft() throws Exception {
		Thread.sleep(10000);
		WebElement d = driver.findElement(By.xpath("//p[text()=\"Draft\"]"));
		highlight(d);
		d.click();
	}

	public boolean VerifyDraftsClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement name = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()=\" Draft Documents \"]")));
		System.out.println("Click on drafts done Sucessfully");
		return name.isDisplayed();
	}

	public void expSoon() throws Exception {
		Thread.sleep(20000);
		WebElement exp = driver.findElement(By.xpath("//p[text()=\"Expiring Soon\"]"));
		highlight(exp);
		exp.click();
	}

	public boolean VerifyExpSoonClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement name = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()=\" Expiring Soon Documents \"]")));
		System.out.println("click on expiring soon done Sucessfully");
		return name.isDisplayed();
	}

	public void completed() throws Exception {
		Thread.sleep(10000);
		WebElement cmplte = driver.findElement(By.xpath("//p[text()=\"Completed\"]"));
		highlight(cmplte);
		cmplte.click();
	}

	public boolean VerifyCompleteClick() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofMinutes(3));

		WebElement name = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[text()=\" Completed Documents \"]")));
		System.out.println("click on completed documents done Sucessfully");
		return name.isDisplayed();
	}

	public void completeDoc() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//ul[@x-placement=\"top-end\"]//a[2]//i")).click();

		Thread.sleep(20000);
		driver.findElement(By.xpath("//input[@placeholder=\"Select a Recipient\"]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]")).click();
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		Actions actions1 = new Actions(driver);
		WebElement sig = driver.findElement(By.id("signatureEle"));
		Thread.sleep(10000);
		actions1.clickAndHold(sig).moveToElement(Target).release().build().perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()=\"Send Document\"]")).click();

	}

	public void resend() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()=\"Resend\"]")).click();
	}

	// Save as Template
	public void saveAsTemplate() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[3]")).click();
		Thread.sleep(10000);
	}

	// Void document
	public void voidDoc() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[4]")).click();
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()=\"Yes\"]")).click();
	}

	// rename
	public void rename() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[5]")).click();
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		WebElement elementToDoubleClick = driver.findElement(By.xpath("//input[@placeholder=\"Document Name\"]"));
		Actions actions3 = new Actions(driver);
		actions3.doubleClick(elementToDoubleClick).perform();
		driver.findElement(By.xpath("//input[@placeholder=\"Document Name\"]")).sendKeys("address2412");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()=\"Confirm\"]")).click();

	}

	// Document Settings
	public void docSettings() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[6]")).click();
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//label[@class=\"el-checkbox\"]")).click();
		driver.findElement(By.xpath("//button[@class=\"el-button type-2 el-button--default\"]")).click();
	}

	// Delete Document
	public void deleteDoc() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[7]")).click();
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		driver.findElement(
				By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]"))
				.click();

	}
	// Download Original

	public void downloadOriginal() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[8]")).click();
		Thread.sleep(10000);
	}

	// Waiting for me
	// Actions
	// download original
	public void wFMdownloadOriginal() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"bottom-end\"]//li)[1]")).click();
		Thread.sleep(10000);
	}

	// Drafts
	// Actions
	// send Document
	public void DSendDoc() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[1]")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//span[normalize-space()=\"Send Document\"]")).click();
		Thread.sleep(10000);
	}

	// Save As Template
	public void draftSaveAsTemplate() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[2]")).click();
		Thread.sleep(10000);
	}

	// Rename Document
	public void DraftsRename() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[3]")).click();
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		WebElement elementToDoubleClick = driver.findElement(By.xpath("//input[@placeholder=\"Document Name\"]"));
		Actions actions3 = new Actions(driver);
		actions3.doubleClick(elementToDoubleClick).perform();
		driver.findElement(By.xpath("//input[@placeholder=\"Document Name\"]")).sendKeys("address2412");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()=\"Confirm\"]")).click();

	}

	// Document Settings
	public void DraftDocSettings() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[4]")).click();
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//label[@class=\"el-checkbox\"]")).click();
		driver.findElement(By.xpath("//button[@class=\"el-button type-2 el-button--default\"]")).click();
	}

	// Delete Document
	public void DraftdeleteDoc() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[5]")).click();
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		driver.findElement(
				By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]"))
				.click();

	}

	// Download original
	public void DraftdownloadOriginal() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[6]")).click();
		Thread.sleep(10000);
	}

	// completed
	// Actions
	// Download original
	public void comDownloadOriginal() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"bottom-end\"]//li)[2]")).click();
		Thread.sleep(10000);
	}

	// Download Document
	public void comDownloadDoc() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"bottom-end\"]//li)[1]")).click();
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class=\"el-dialog__wrapper\"]//i[@class=\"el-icon-download\"]")).click();

	}

	// expiring soon
	// Actions
	// correct Document
	public void expSooncorrectDocument() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[1]")).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath("//span[normalize-space()=\"Send Document\"]")).click();
		Thread.sleep(10000);
	}

	// Resend Document
	public void resendDocument() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class=\"el-button el-button--default el-button--mini\"]")).click();
	}

	// Save As Template
	public void expSoonSaveAsTemplate() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[3]")).click();
		Thread.sleep(10000);
	}

	// void Document
	public void expSoonvoidDocument() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[4]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()=\"Yes\"]")).click();
	}

	// Rename Document
	public void expSoonRename() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[5]")).click();
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		WebElement elementToDoubleClick = driver.findElement(By.xpath("//input[@placeholder=\"Document Name\"]"));
		Actions actions3 = new Actions(driver);
		actions3.doubleClick(elementToDoubleClick).perform();
		driver.findElement(By.xpath("//input[@placeholder=\"Document Name\"]")).sendKeys("address2412");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()=\"Confirm\"]")).click();

	}

	// Document Settings
	public void expSoonDocSettings() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[6]")).click();
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//label[@class=\"el-checkbox\"]")).click();
		driver.findElement(By.xpath("//button[@class=\"el-button type-2 el-button--default\"]")).click();
	}

	// Delete Document
	public void expSoondeleteDoc() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[7]")).click();
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		driver.findElement(
				By.xpath("//button[@class=\"el-button el-button--default el-button--small el-button--primary \"]"))
				.click();

	}

	// Download original
	public void expSoondownloadOriginal() throws Exception {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[8]")).click();
		Thread.sleep(10000);
	}

	// Waiting For me
	//Actions
	//Correct Document
	public void WFMCorrectDoc() throws Exception {
		try {
			Thread.sleep(10000);
			WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

			Actions actions = new Actions(driver);

			actions.moveToElement(elementToHover).perform();
			Thread.sleep(10000);
			WebElement elementToHover2 = driver.findElement(
					By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

			Actions actions2 = new Actions(driver);
			Thread.sleep(10000);
			actions2.moveToElement(elementToHover2).perform();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//ul[@x-placement=\"top-end\"]//li[contains(text(), 'Correct Document')]")).click();
			Thread.sleep(10000);

		}
		catch (Exception e) {
			System.out.println("no sender field exist");
			Thread.sleep(10000);
			WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

			Actions actions = new Actions(driver);

			actions.moveToElement(elementToHover).perform();
			Thread.sleep(10000);
			WebElement elementToHover2 = driver.findElement(
					By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

			Actions actions2 = new Actions(driver);
			Thread.sleep(10000);
			actions2.moveToElement(elementToHover2).perform();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//li[contains(text(), 'Download Original')]")).click();
			Thread.sleep(10000);

		}

	}
	//Resend
	public void WFMresend() throws Exception {
	try {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]"));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//ul[@x-placement=\"top-end\"]//li)[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class=\"el-button el-button--default el-button--mini\"]")).click();

		}
	catch(Exception e) {
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);
		WebElement elementToHover2 = driver.findElement(
				By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions actions2 = new Actions(driver);
		Thread.sleep(10000);
		actions2.moveToElement(elementToHover2).perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//li[contains(text(), 'Download Original')]")).click();
		Thread.sleep(10000);

		}
	}

}
