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

public class Templatespage {
	WebDriver driver;

	public Templatespage(WebDriver driver) {

		this.driver = driver;

	}

	public void Temp() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			System.out.println("Overlay not found or not invisible.");
		}

		By ad = By.xpath("//span[normalize-space()='Templates']");

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

	public void EditTemp() throws Exception {
		Thread.sleep(10000);
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		WebElement Company = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='companyEle']")));
		WebElement Target = driver.findElement(By.xpath("//*[@id=\"svg\"]"));
		Thread.sleep(1000);
		Actions actions3 = new Actions(driver);
		actions3.clickAndHold(Company).moveToElement(Target).release().build().perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='el-scrollbar__view']//input[@placeholder='Select a Recipient']"))
				.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='el-scrollbar']//ul//li[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Save Template']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//i[@class='el-icon-back']")).click();
	}

	public void SendTocontacts() throws Exception {

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
		// driver.findElement(By.xpath("(//div[@role='group']//span[@class='el-checkbox__inner'])[2]")).click();
		driver.findElement(By.xpath("//label[@class='el-checkbox mt-1']//span[normalize-space()='Select All']"))
				.click();
		;
	}

	public void Addnew() throws Exception {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Create Contact']")).click();
		By adn = By.xpath("(//div[@class='el-input']//input)[1]");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement addnew = hold.until(ExpectedConditions.elementToBeClickable(adn));
		addnew.sendKeys("ramya");
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='el-input']//input)[2]")).sendKeys("sibbala");
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='el-input']//input)[3]"))
				.sendKeys("ramya.sibbala@nimbleaccounting.com");
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='el-input']//input)[7]")).sendKeys("HGT");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Save Contact']")).click();
	}

	public void Send() throws Exception {
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@role='group']//span[@class='el-checkbox__inner'])[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Send']")).click();

	}

	public void ConfirmationAlert() throws Exception {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='el-dialog__footer']//span[normalize-space()='Confirm'])[4]"))
				.click();

	}

	public void BulkSend() throws Exception {
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
		driver.findElement(By.xpath("(//div[@role='button'])[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@role='button'])[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@role='button'])[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@role='button'])[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button//span[normalize-space()='Download Blank CSV']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button//span[normalize-space()='Continue']")).click();

		By Element = By.xpath("//div//p[normalize-space()='Drag & Drop CSV file here']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));
		canc.click();
		Runtime.getRuntime().exec("\"C:\\Work Space\\EsignTest\\src\\test\\resources\\excel.exe\"");
		Thread.sleep(10000);
		driver.findElement(By.id("tab-error")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("tab-success")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button//span[normalize-space()='Continue']")).click();
		/*
		 * driver.findElement(By.
		 * xpath("(//div[@class='el-input el-input--mini']//input)[1]")).sendKeys("Raju"
		 * ); Thread.sleep(10000); driver.findElement(By.
		 * xpath("(//div[@class='el-input el-input--mini']//input)[4]")).clear();
		 * Thread.sleep(10000); driver.findElement(By.
		 * xpath("(//div[@class='el-input el-input--mini']//input)[4]")).
		 * sendKeys("Sample Test");
		 */
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Send documents']")).click();
	}

	public void ValidBulk() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement DocMessage = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//h2['Done! Your bulk send was delivered successfully.'])[1]")));

		Assert.assertEquals(DocMessage.getText(), "Done! Your bulk send was delivered successfully.");

		System.out.println("Upload CSV Document Success");
	}

	public void Getlink() throws Exception {
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
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Copy Link']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//span[@class='el-checkbox__label'])[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//span[@class='el-checkbox__label'])[2]")).click();
		Thread.sleep(10000);
		try {
			driver.findElement(By.xpath("//span[normalize-space()='Publish']")).click();
		} catch (Exception e) {
			Thread.sleep(10000);
			driver.findElement(By.xpath("//span[normalize-space()='Unpublish']")).click();
		}
		driver.findElement(By.xpath("//span[normalize-space()='Publish']")).click();
		Thread.sleep(10000);

		((JavascriptExecutor) driver).executeScript("window.open()");

		String currentWindowHandle = driver.getWindowHandle();
		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		driver.get(
				"https://dev.esigns.io/company-documents/65670561814325fcbe497514/configure/template/65670562814325fcbe497515/preview");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='Enter mail']")).sendKeys("prudhviraju.buddharaju@gmail.com");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@class='el-button type-2 w-100 fs-6 el-button--primary']//span")).click();
		Thread.sleep(10000);
		driver.switchTo().window(currentWindowHandle);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='mt-1 el-row']//span[normalize-space()='Close']")).click();
	}

	public void Share() throws Exception {
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
		WebElement subMenuItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[5]"));
		actions.click(subMenuItem).perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(10000);
		driver.findElement(By.id("tab-contact_types")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@id='pane-contact_types']//span[@class='el-checkbox__inner'])[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@id='pane-contact_types']//span[@class='el-checkbox__inner'])[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("tab-contacts")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@id='pane-contacts']//span[@class='el-checkbox__inner'])[1]")).click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@id='pane-contacts']//span[normalize-space()='ggg@gmail.com']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='el-dialog__footer']//span[normalize-space()='Share']")).click();
	}

	public void Settings() throws Exception {
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
		WebElement subMenuItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[7]"));
		actions.click(subMenuItem).perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);

		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[@class='el-switch__core']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Update after document completion']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Update after user finishes the document']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Never update']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(
				"(//div[@class='el-dialog__wrapper outersize-confirm-type-three']//div[@class='card-body']//span[@class='el-checkbox__inner'])[1]"))
				.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(
				"(//div[@class='el-dialog__wrapper outersize-confirm-type-three']//div[@class='card-body']//span[@class='el-checkbox__inner'])[2]"))
				.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(
				"(//div[@class='el-dialog__wrapper outersize-confirm-type-three']//div[@class='card-body']//span[@class='el-checkbox__inner'])[3]"))
				.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='1']")).clear();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='1']")).sendKeys("33");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Update after document completion']")).click();
		driver.findElement(By.xpath(
				"(//div[@class='el-dialog__wrapper outersize-confirm-type-three']//div[@class='card-body']//span[@class='el-checkbox__inner'])[4]"))
				.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(
				"(//div[@class='el-dialog__wrapper outersize-confirm-type-three']//div[@class='card-body']//span[@class='el-checkbox__inner'])[5]"))
				.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(
				"(//div[@class='el-dialog__wrapper outersize-confirm-type-three']//div[@class='card-body']//span[@class='el-checkbox__inner'])[7]"))
				.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[@class='el-switch__core']")).click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("(//div[@class='mb-1']//span[@class='el-checkbox__inner'])[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Save Changes']")).click();

	}

	public void ChangeOwner() throws Exception {
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
		WebElement subMenuItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[8]"));
		actions.click(subMenuItem).perform();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);

		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[@class='el-radio__inner']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Change']")).click();
	}

	public void Viewdata() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		try {

			By elementToHoverLocator = By.xpath("//div[@class='el-table__fixed']//tr[4]");
			WebElement elementToHover1 = wait.until(ExpectedConditions.presenceOfElementLocated(elementToHoverLocator));

			Actions actions = new Actions(driver);
			actions.moveToElement(elementToHover1).perform();

			By elementToHover2Locator = By.xpath("//div[@class='el-table__fixed']//tr[3]//ul/li[2]");
			WebElement elementToHover2 = wait
					.until(ExpectedConditions.presenceOfElementLocated(elementToHover2Locator));

			Actions actions2 = new Actions(driver);
			actions2.moveToElement(elementToHover2).perform();

			By subMenuItemLocator = By.xpath("//ul[@x-placement='bottom-end']//a[9]");
			WebElement subMenuItem = wait.until(ExpectedConditions.elementToBeClickable(subMenuItemLocator));

			actions.click(subMenuItem).perform();

			Set<String> windowHandles = driver.getWindowHandles();
			for (String handle : windowHandles) {
				driver.switchTo().window(handle);
			}

			By checkboxLocator = By.xpath(
					"//label[@class='el-checkbox el-tooltip checkbox mb-2 mr-2']//span[@class='el-checkbox__input']");
			WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(checkboxLocator));

			checkbox.click();

			By downloadCsvLocator = By.xpath("//span[normalize-space()='Download CSV']");
			WebElement downloadCsv = wait.until(ExpectedConditions.elementToBeClickable(downloadCsvLocator));

			downloadCsv.click();

			By closeButtonLocator = By.xpath("//div[9]//div[@class='el-dialog__header']/button/i");
			WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(closeButtonLocator));

			closeButton.click();
		} catch (Exception e) {

			System.out.println("Exception occurred: " + e.getMessage());
		}

		/*
		 * Thread.sleep(10000); WebDriverWait wait = new WebDriverWait(driver,
		 * Duration.ofMinutes(3)); By elementToHover =
		 * By.xpath("//div[@class='el-table__fixed']//tr[4]"); WebElement
		 * elementToHover1 =
		 * wait.until(ExpectedConditions.presenceOfElementLocated(elementToHover));
		 * 
		 * Actions actions = new Actions(driver);
		 * 
		 * actions.moveToElement((WebElement) elementToHover).perform();
		 * Thread.sleep(10000); WebElement elementToHover2 =
		 * driver.findElement(By.xpath(
		 * "//div[@class='el-table__fixed']//tr[3]//ul/li[2]"));
		 * 
		 * Actions actions2 = new Actions(driver); Thread.sleep(10000);
		 * actions2.moveToElement(elementToHover2).perform(); Thread.sleep(10000);
		 * WebElement subMenuItem =
		 * driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[9]"));
		 * actions.click(subMenuItem).perform(); Set<String> windowHandles =
		 * driver.getWindowHandles(); for (String handle : windowHandles) {
		 * driver.switchTo().window(handle);
		 * 
		 * } Thread.sleep(10000); driver.findElement(By.xpath(
		 * "//label[@class='el-checkbox el-tooltip checkbox mb-2 mr-2']//span[@class='el-checkbox__input']"
		 * )) .click();
		 * 
		 * By ad12 = By.xpath("//span[normalize-space()='Download CSV']"); WebDriverWait
		 * hold12 = new WebDriverWait(driver, Duration.ofMinutes(5)); WebElement add12 =
		 * hold12.until(ExpectedConditions.elementToBeClickable(ad12)); add12.click();
		 * Thread.sleep(10000); driver.findElement(By.xpath(
		 * "//div[9]//div[@class='el-dialog__header']/button/i")).click();
		 */
	}

	public void DuplicateTemplate() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		By elementToHover = By.xpath("//div[@class='el-table__fixed']//tr[6]");
		WebElement elementToHover1 = wait.until(ExpectedConditions.presenceOfElementLocated(elementToHover));

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
		Thread.sleep(10000);
		driver.findElement(By.xpath("(//span[text()='Confirm'])[3]")).click();
	}

	public void RenameTemplate() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		By elementToHover = By.xpath("//div[@class='el-table__fixed']//tr[6]");
		WebElement elementToHover1 = wait.until(ExpectedConditions.presenceOfElementLocated(elementToHover));

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
		driver.findElement(By.xpath("(//span[text()='Confirm'])[3]")).click();
	}

	public void inactive() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		By dr = By.xpath("//input[@placeholder='Select Status']");
		WebElement drp = wait.until(ExpectedConditions.presenceOfElementLocated(dr));
		drp.click();
		By sel = By.xpath("//div[@x-placement='bottom-start']//li[2]/span");
		WebElement sele = wait.until(ExpectedConditions.presenceOfElementLocated(sel));
		sele.click();

		/*
		 * JavascriptExecutor executor = (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0].click();", sele);
		 */
try {
		By elementToHoverLocator = By.xpath("//div[@class='el-table__fixed']//tr[2]");
		WebElement elementToHover1 = wait.until(ExpectedConditions.presenceOfElementLocated(elementToHoverLocator));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover1).perform();

		By elementToHover2Locator = By.xpath("//div[@class='el-table__fixed']//tr[3]//ul/li[2]");
		WebElement elementToHover2 = wait.until(ExpectedConditions.presenceOfElementLocated(elementToHover2Locator));

		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).perform();

		By subMenuItemLocator = By.xpath("//ul[@x-placement='top-end']//a[2]");
		WebElement subMenuItem = wait.until(ExpectedConditions.elementToBeClickable(subMenuItemLocator));
		
		actions.click(subMenuItem).perform();
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].click();", subMenuItem);
}
catch (Exception e) {

}
	}

	public void Delete() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		By dr = By.xpath("//input[@placeholder='Select Status']");
		WebElement drp = wait.until(ExpectedConditions.presenceOfElementLocated(dr));
		drp.click();
		By sel = By.xpath("//li//span[text()='Inactive']");
		WebElement sele = wait.until(ExpectedConditions.presenceOfElementLocated(sel));
		sele.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofMinutes(3));

		try {

			By elementToHoverLocator = By.xpath("//div[@class='el-table__fixed']//tr[3]");
			WebElement elementToHover1 = wait1
					.until(ExpectedConditions.presenceOfElementLocated(elementToHoverLocator));

			Actions actions = new Actions(driver);
			actions.moveToElement(elementToHover1).perform();

			By elementToHover2Locator = By.xpath("//div[@class='el-table__fixed']//tr[3]//ul/li[2]");
			WebElement elementToHover2 = wait1
					.until(ExpectedConditions.presenceOfElementLocated(elementToHover2Locator));

			Actions actions2 = new Actions(driver);
			actions2.moveToElement(elementToHover2).perform();

			By subMenuItemLocator = By.xpath("//ul[@x-placement='top-end']//a[3]");
			WebElement subMenuItem = wait1.until(ExpectedConditions.elementToBeClickable(subMenuItemLocator));

			actions.click(subMenuItem).perform();

		} catch (Exception e) {

		}
	}
}