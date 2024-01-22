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

		/*
		 * WebElement Company = wait
		 * .until(ExpectedConditions.presenceOfElementLocated(By.xpath(
		 * "//button[@id='companyEle']"))); WebElement Target =
		 * driver.findElement(By.xpath("//*[@id=\"svg\"]")); Thread.sleep(1000); Actions
		 * actions3 = new Actions(driver);
		 * actions3.clickAndHold(Company).moveToElement(Target).release().build().
		 * perform(); Thread.sleep(10000);
		 */
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='el-scrollbar__view']//input[@placeholder='Select a Recipient']"))
				.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='el-scrollbar']//ul//li[2]")).click();
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//span[normalize-space()='Save Template']")).click();
		
		
		
		
		Thread.sleep(10000);
		//driver.findElement(By.xpath("//i[@class='el-icon-back']")).click();
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
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By dropdownLocator = By.xpath("//input[@placeholder='Select Status']");
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
		dropdown.click();

		By optionLocator = By.xpath("//div[@x-placement='bottom-start']//li[2]/span");
		WebElement inactive = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
		inactive.click();

		Thread.sleep(10000);
		By elementToHoverLocator = By.xpath("//div[@class='el-table__fixed']//tr[4]");
		WebElement elementToHover1 = wait.until(ExpectedConditions.elementToBeClickable(elementToHoverLocator));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover1).perform();
		Thread.sleep(10000);
		By elementToHover2Locator = By
				.xpath("//div[@class='el-table__body-wrapper is-scrolling-left']//tr[3]//ul/li[2]//button/span/i");
		WebElement elementToHover2 = wait.until(ExpectedConditions.elementToBeClickable(elementToHover2Locator));

		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).perform();

		By subMenuItemLocator = By.xpath("//ul[@x-placement='top-end']//a[2]");
		WebElement subMenuItem = wait.until(ExpectedConditions.elementToBeClickable(subMenuItemLocator));

		actions.click(subMenuItem).perform();

	}

	public void Delete() throws Exception {

		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		By dropdownLocator = By.xpath("//input[@placeholder='Select Status']");
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
		dropdown.click();

		By optionLocator = By.xpath("//div[@x-placement='bottom-start']//li[2]/span");
		WebElement inactive = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
		inactive.click();

		Thread.sleep(10000);
		By elementToHoverLocator = By
				.xpath("//div[@class='el-table__header-wrapper']//span[@class='el-checkbox__inner']");
		WebElement elementToHover1 = wait.until(ExpectedConditions.elementToBeClickable(elementToHoverLocator));

		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover1).perform();
		Thread.sleep(10000);
		By elementToHover2Locator = By.xpath("//ul[@x-placement='bottom-end']//li/span");
		WebElement elementToHover2 = wait.until(ExpectedConditions.elementToBeClickable(elementToHover2Locator));

		Actions actions2 = new Actions(driver);
		actions2.moveToElement(elementToHover2).perform();

	}

	public void Creategroup() throws Exception {

		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		By createdoc = By
				.xpath("//button[@class='el-button create-btn px-4 ml-2 scaling-button el-button--primary is-plain']");
		WebElement createdocument = wait.until(ExpectedConditions.elementToBeClickable(createdoc));
		createdocument.click();

		By blank = By.xpath("//span[normalize-space()='Blank template']");
		WebElement blankdocument = wait.until(ExpectedConditions.elementToBeClickable(blank));
		blankdocument.click();

		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);

		}
		By template = By.xpath("//input[@placeholder='Enter template name']");
		WebElement templatename = wait.until(ExpectedConditions.elementToBeClickable(template));
		templatename.sendKeys("Test");

		By number = By.xpath("//input[@placeholder='Select number of pages']");
		WebElement numberpages = wait.until(ExpectedConditions.elementToBeClickable(number));
		numberpages.click();

		By list = By.xpath("//div[@x-placement='bottom-start']//li[2]");
		WebElement sellist = wait.until(ExpectedConditions.elementToBeClickable(list));
		sellist.click();

		/*
		 * By Addnew = By.xpath("//i[@class='el-tooltip el-icon-circle-plus-outline']");
		 * WebElement Addnewgroup =
		 * wait.until(ExpectedConditions.elementToBeClickable(Addnew));
		 * Addnewgroup.click();
		 * 
		 * Set<String> windowHandles1 = driver.getWindowHandles(); for (String handle :
		 * windowHandles1) { driver.switchTo().window(handle);
		 * 
		 * }
		 * driver.findElement(By.xpath("//input[@placeholder='Enter Title']")).clear();
		 * 
		 * By Group = By.xpath("//input[@placeholder='Enter Title']"); WebElement
		 * Grouptitle = wait.until(ExpectedConditions.elementToBeClickable(Group));
		 * Grouptitle.sendKeys("Sample Groups1");
		 * 
		 * /* By save = By.xpath("//span//i[@class='el-icon-check']"); WebElement
		 * savegroup = wait.until(ExpectedConditions.elementToBeClickable(save));
		 * savegroup.click();
		 * 
		 * By Continue = By.xpath("//span[normalize-space()='Continue']"); WebElement
		 * Continueto = wait.until(ExpectedConditions.elementToBeClickable(Continue));
		 * Continueto.click();
		 * 
		 * Set<String> windowHandles2 = driver.getWindowHandles(); for (String handle :
		 * windowHandles2) { driver.switchTo().window(handle);
		 * 
		 * }
		 */

		By select = By.xpath(
				"//div[@class='el-col el-col-20']//i[@class='el-select__caret el-input__icon el-icon-arrow-up']");
		WebElement selectgroup = wait.until(ExpectedConditions.elementToBeClickable(select));
		selectgroup.click();

		By selectlist = By.xpath("//div[@class='el-select-dropdown el-popper is-multiple']//li[3]");
		WebElement selectgrouplist = wait.until(ExpectedConditions.elementToBeClickable(selectlist));
		selectgrouplist.click();

		By Continue = By.xpath("//span[normalize-space()='Continue']");
		WebElement Continueto = wait.until(ExpectedConditions.elementToBeClickable(Continue));
		Continueto.click();

		/*
		 * Set<String> windowHandles2 = driver.getWindowHandles(); for (String handle :
		 * windowHandles2) { driver.switchTo().window(handle);
		 * 
		 * }
		 */
		Thread.sleep(10000);
		By Select1 = By.xpath("//input[@placeholder='Select Contact type']");
		WebElement Selectinput1 = wait.until(ExpectedConditions.elementToBeClickable(Select1));
		Selectinput1.click();

		By Select = By.xpath("//div[@x-placement='bottom-start']//li[1]");
		WebElement Selectinput = wait.until(ExpectedConditions.elementToBeClickable(Select));
		Selectinput.click();

		By Ad1 = By.xpath("//span[normalize-space()='Add']");
		WebElement Add1 = wait.until(ExpectedConditions.elementToBeClickable(Ad1));
		Add1.click();

		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Enforce Signature Order']")).click();

		By saveuser = By.xpath("//span[normalize-space()='Save Users']");
		WebElement saveusers = wait.until(ExpectedConditions.elementToBeClickable(saveuser));
		saveusers.click();
		Thread.sleep(10000);
		By send = By.xpath("(//input[@class='el-input__inner'])[2]");
		WebElement sends = wait.until(ExpectedConditions.elementToBeClickable(send));
		sends.click();
		Thread.sleep(10000);
		By send1 = By.xpath("//div[@class='el-select-dropdown el-popper']//li[2]");
		WebElement sends1 = wait.until(ExpectedConditions.elementToBeClickable(send1));
		sends1.click();

		By EMPLOYEE = By.xpath("//div[text()='ALL FIELDS']");
		WebDriverWait wait22 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement EMPLOYEEForm = wait22.until(ExpectedConditions.elementToBeClickable(EMPLOYEE));
		EMPLOYEEForm.click();
		System.out.println("EMPLOYEEForm clicked");
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

		/*
		 * By EMPLOYEE = By.xpath("//div[text()='EMPLOYEE FORM']"); WebDriverWait wait22
		 * = new WebDriverWait(driver, Duration.ofMinutes(2)); WebElement EMPLOYEEForm =
		 * wait22.until(ExpectedConditions.elementToBeClickable(EMPLOYEE));
		 * EMPLOYEEForm.click(); System.out.println("EMPLOYEEForm clicked");
		 * 
		 * Thread.sleep(10000);
		 * 
		 * Actions actions = new Actions(driver);
		 * actions.sendKeys(Keys.PAGE_DOWN).perform();
		 */

		WebElement name = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[@id='0_entity_0']//div[@class='name'][normalize-space()='NAME']")));

		WebElement Target = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='svg']")));
		Actions actions1 = new Actions(driver);
		actions1.clickAndHold(name).moveToElement(Target).release().build().perform();

		/*
		 * WebElement Doubleclick =
		 * driver.findElement(By.xpath("//div[contains(@class,'overlay')]")); Actions
		 * action = new Actions(driver);
		 * action.doubleClick(Doubleclick).build().perform(); Set<String> windowHandles3
		 * = driver.getWindowHandles(); for (String handle : windowHandles3) {
		 * driver.switchTo().window(handle); }
		 * 
		 * driver.findElement(By.xpath(
		 * "(//label[text()='Placeholder']/following::input)[1]")).clear(); By Place =
		 * By.xpath("(//label[text()='Placeholder']/following::input)[1]"); WebElement
		 * Placeholder = wait.until(ExpectedConditions.elementToBeClickable(Place));
		 * Placeholder.sendKeys("Sai"); Thread.sleep(10000); By Save = By.
		 * xpath("//div[contains(@aria-label,'Field Properties')//span[contains(text(),'Save')]"
		 * ); WebElement Saves =
		 * wait.until(ExpectedConditions.elementToBeClickable(Save)); Saves.click();
		 */

		WebElement dob = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='0_entity_1']")));

		Actions actions11 = new Actions(driver);
		actions11.clickAndHold(dob).moveToElement(Target).release().build().perform();

		/*
		 * Thread.sleep(1000); WebElement Doubleclick1 =
		 * driver.findElement(By.xpath("//input[@placeholder='Dob']")); Actions action1
		 * = new Actions(driver); action1.doubleClick(Doubleclick1).build().perform();
		 * Set<String> windowHandles5 = driver.getWindowHandles(); for (String handle :
		 * windowHandles5) { driver.switchTo().window(handle); } Thread.sleep(10000);
		 * driver.findElement(By.xpath(
		 * "(//span[@class='el-date-picker__header-label'])[1]")).click(); By Pyear =
		 * By.xpath("//button[@aria-label='Previous Year']"); WebElement Pyears =
		 * wait.until(ExpectedConditions.elementToBeClickable(Pyear)); Pyears.click();
		 * Thread.sleep(10000); By Pyear1 =
		 * By.xpath("//button[@aria-label='Previous Year']"); WebElement Pyears1 =
		 * wait.until(ExpectedConditions.elementToBeClickable(Pyear1)); Pyears1.click();
		 * Thread.sleep(10000); By Pyear2 =
		 * By.xpath("//button[@aria-label='Previous Year']"); WebElement Pyears2 =
		 * wait.until(ExpectedConditions.elementToBeClickable(Pyear2)); Pyears2.click();
		 * Thread.sleep(10000); By year = By.xpath("(//a[@class='cell'])[1]");
		 * WebElement years = wait.until(ExpectedConditions.elementToBeClickable(year));
		 * years.click(); Thread.sleep(10000); By month =
		 * By.xpath("//a[contains(text(),'Jun')]"); WebElement months =
		 * wait.until(ExpectedConditions.elementToBeClickable(month)); months.click();
		 * Thread.sleep(10000); By day =
		 * By.xpath("//span[text()[normalize-space()='19']]"); WebElement days =
		 * wait.until(ExpectedConditions.elementToBeClickable(day)); days.click();
		 */

		WebElement phone = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='0_entity_2']")));

		Actions actions12 = new Actions(driver);
		actions12.clickAndHold(phone).moveToElement(Target).release().build().perform();

		/*
		 * Thread.sleep(1000); WebElement Doubleclick12 =
		 * driver.findElement(By.xpath("(//div[text()=' Phone '])[1]")); Actions
		 * action13 = new Actions(driver);
		 * action13.doubleClick(Doubleclick12).build().perform(); Set<String>
		 * windowHandles6 = driver.getWindowHandles(); for (String handle :
		 * windowHandles6) { driver.switchTo().window(handle); }
		 * 
		 * By mob = By.xpath("(//div[@class='el-input']//input)[3]"); WebElement mobn =
		 * wait.until(ExpectedConditions.elementToBeClickable(mob));
		 * mobn.sendKeys("8923546987"); Thread.sleep(10000); By Save1 =
		 * By.xpath("(//span[text()='Save'])[3]"); WebElement Saved =
		 * wait.until(ExpectedConditions.elementToBeClickable(Save1)); Saved.click();
		 */
		
		By Creat = By.xpath("//span[text()='Create Document']");
		WebElement Creatdoc = wait.until(ExpectedConditions.elementToBeClickable(Creat));
		Creatdoc.click();

		try {
			By clo = By.xpath("(//div[@class='el-notification__closeBtn el-icon-close'])[2]");
			WebElement close = wait.until(ExpectedConditions.elementToBeClickable(clo));
			close.click();

		} catch (Exception e) {
			By Send = By.xpath("//span[text()='Send Document']");
			WebElement Senddoc = wait.until(ExpectedConditions.elementToBeClickable(Send));
			Senddoc.click();
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", Senddoc);
			System.out.println("senddoc clicked using JS.");
		}

		By emai = By.xpath("(//input[@placeholder='Search with Email'])[2]");
		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(emai));
		email.click();

		By emaisel = By.xpath("//div[@x-placement='top-start']//li");
		WebElement emailsel = wait.until(ExpectedConditions.elementToBeClickable(emaisel));
		emailsel.click();

		By saveuser1 = By.xpath("//span[text()=' Save Users ']");
		WebElement saveusers1 = wait.until(ExpectedConditions.elementToBeClickable(saveuser1));
		saveusers1.click();

		By ele = By.xpath("//textarea[@placeholder='Subject']");
		WebElement sen = wait.until(ExpectedConditions.elementToBeClickable(ele));
		sen.sendKeys("Test Sample");
		driver.findElement(By.xpath("(//textarea[@class='el-textarea__inner'])[2]")).sendKeys(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Send Document']")).click();

	}
}