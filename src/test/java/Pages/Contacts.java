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

public class Contacts {
	WebDriver driver;

	public Contacts(WebDriver driver) {

		this.driver = driver;
	}

	public void contactsclick() throws Exception {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			System.out.println("Overlay not found or not invisible.");
		}

		By ad = By.xpath("//span[normalize-space()='Contacts']");

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

	public void contactssearch() throws Exception {
		Thread.sleep(10000);
		By consearch = By.xpath("//label[@class=\"search-icon-wrapper\"]");
		WebDriverWait cotime1 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement cocl1 = cotime1.until(ExpectedConditions.elementToBeClickable(consearch));
		cocl1.click();
		By context = By.xpath("//input[@data-v-4ec12b42]\r\n" + "");
		WebDriverWait cotime2 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement cocl2 = cotime2.until(ExpectedConditions.elementToBeClickable(context));
		cocl2.sendKeys("jeevitha");

	}

	public void addcontacts() throws Exception {
		Thread.sleep(10000);
		By conadd = By.xpath("//button[@class=\"el-button el-button--default el-button--mini is-plain\"]");
		WebDriverWait cotime3 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement cocl3 = cotime3.until(ExpectedConditions.elementToBeClickable(conadd));
		cocl3.click();

	}

	public boolean contacttypespage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//section[@class=\"all-documents-view\"]")));

		System.out.println("Contact Types is present on the page");

		return element.isDisplayed();

		// driver.findElement(By.xpath("//input[@placeholder=\"Enter contact type\"]"));

	}

	public void entercontacttype() throws Exception {
		Thread.sleep(10000);
		By contype = By.xpath("//input[@placeholder=\"Enter contact type\"]");
		WebDriverWait cotime7 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement cocl7 = cotime7.until(ExpectedConditions.elementToBeClickable(contype));
		cocl7.sendKeys("January");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()=\"Submit\"]")).click();
		driver.findElement(By.xpath("//i[@class=\"el-icon-arrow-left\"]")).click();
	}

	public void selectcontacts() throws Exception {
		Thread.sleep(10000);
		By consel = By
				.xpath("//div[@class='actions-wrapper contacts-page']//div[@class='el-select filter-contact-type']");
		WebDriverWait cotime4 = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement cocl4 = cotime4.until(ExpectedConditions.elementToBeClickable(consel));
		cocl4.click();

		// driver.findElement(By.xpath("//input[@placeholder=\"Select
		// Type\"]")).click();
		Thread.sleep(10000);
		By january=(By.xpath("//div[@x-placement='bottom-start']//li[1]"));
		WebDriverWait jan = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement jan1 = jan.until(ExpectedConditions.elementToBeClickable(january));
		jan1.click();

	}

	public void createcontacts() throws Exception {
		Thread.sleep(10000);
		By contactcreate = By.xpath("//span[normalize-space()=\"Create Contact\"]");
		WebDriverWait cotime5 = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement cocl5 = cotime5.until(ExpectedConditions.elementToBeClickable(contactcreate));
		cocl5.click();
		Thread.sleep(10000);
		By contactcreate1 = (By.xpath("(//input[@type=\"text\"])[3]"));
		WebDriverWait cotime6 = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement cocl6 = cotime6.until(ExpectedConditions.elementToBeClickable(contactcreate1));
		cocl6.sendKeys("Meghana");
		driver.findElement(By.xpath("(//input[@type=\"text\"])[4]")).sendKeys("pemma");
		driver.findElement(By.xpath("(//input[@type=\"text\"])[5]")).sendKeys("MeghanaP@gmail.com");
		driver.findElement(By.xpath("(//input[@type=\"text\"])[6]")).sendKeys("reddy");
		driver.findElement(By.xpath("(//input[@type=\"text\"])[7]")).sendKeys("9014783209");

		driver.findElement(By.xpath("//span[normalize-space()='Save Contact']")).click();

	}

	public void delcontacts() throws Exception {
		Thread.sleep(10000);
		By condel = By.xpath("(//div[@class=\"el-table__fixed-right\"]//ul[1]//li[3])[1]");
		WebDriverWait cotime8 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement cocl8 = cotime8.until(ExpectedConditions.elementToBeClickable(condel));
		cocl8.click();

	}

	public void editcontacts() throws Exception {
		Thread.sleep(10000);
		By conedit = By.xpath("(//div[@class=\"el-table__fixed-right\"]//ul[1]//li[2])[1]");
		WebDriverWait cotime9 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement cocl9 = cotime9.until(ExpectedConditions.elementToBeClickable(conedit));
		cocl9.click();
		driver.findElement(By.xpath("(//input[@type=\"text\"])[5]")).clear();
		driver.findElement(By.xpath("(//input[@type=\"text\"])[5]")).sendKeys("Meghanameghu@gmail.com");

		driver.findElement(By.xpath("//span[normalize-space()='Update Contact']")).click();

	}

	public void viewdocument() throws Exception {
		Thread.sleep(10000);
		By viewdoc = By.xpath("//div[@class='el-table__fixed-right']//tr[4]//li[1]");
		WebDriverWait cotime10 = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement cocl10 = cotime10.until(ExpectedConditions.elementToBeClickable(viewdoc));
		cocl10.click();

		Thread.sleep(10000);
		By sentact = By.xpath("//input[@placeholder=\"Select Status\"]");
		WebDriverWait sentact1 = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement Act1 = sentact1.until(ExpectedConditions.elementToBeClickable(sentact));
		Act1.click();

		// driver.findElement(By.xpath("//input[@placeholder=\"Select
		// Type\"]")).click();

		Thread.sleep(10000);
		By sentsel = By.xpath("//div[@x-placement=\"bottom-start\"]//li[3]");
		WebDriverWait sentsel1 = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement sel1 = sentsel1.until(ExpectedConditions.elementToBeClickable(sentsel));
		sel1.click();
		System.out.println("sent documents opened successfully");
		Thread.sleep(10000);
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class=\"el-table__fixed-body-wrapper\"]//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//span[normalize-space()='Actions']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement sentaction = driver.findElement(By.xpath("//ul[@x-placement]//a[1]"));
		act.click(sentaction).perform();
		Thread.sleep(10000);

		By sentrename = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait sr1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement renamesent = sr1.until(ExpectedConditions.elementToBeClickable(sentrename));
		renamesent.clear();
		Thread.sleep(10000);

		By sentrename1 = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait sr2 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement renamesent1 = sr2.until(ExpectedConditions.elementToBeClickable(sentrename1));
		renamesent1.sendKeys("Archieved");
		Thread.sleep(10000);

		By sentrename2 = By.xpath("(//span[normalize-space()='Confirm'])[1]");
		WebDriverWait sr3 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement renamesent2 = sr3.until(ExpectedConditions.elementToBeClickable(sentrename2));
		renamesent2.click();
	}
	public void Voiddoc() throws InterruptedException {

		/*
		 * By sentsel = By.xpath("//div[@x-placement=\"bottom-start\"]//li[3]");
		 * WebDriverWait sentsel1 = new WebDriverWait(driver, Duration.ofMinutes(3));
		 * WebElement sel1 =
		 * sentsel1.until(ExpectedConditions.elementToBeClickable(sentsel));
		 * sel1.click(); System.out.println("sent documents opened successfully");
		 */
WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class=\"el-table__fixed-body-wrapper\"]//tr[1]//span[normalize-space()='Actions']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement sentaction = driver.findElement(By.xpath("//ul[@x-placement]//a[2]"));
		act.click(sentaction).perform();
		Thread.sleep(10000);




		 Set<String> windowHandles = driver.getWindowHandles(); for (String handle :
		  windowHandles) { driver.switchTo().window(handle); }

		//span[normalize-space()='No']
		By sentvoid = By.xpath("//span[text()[normalize-space()='No']]");
		WebDriverWait sentvoid1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement voidsent = sentvoid1.until(ExpectedConditions.elementToBeClickable(sentvoid));
		voidsent.click();
		Thread.sleep(10000);

		/*
		 * act1.moveToElement(elementTomove2).perform(); Thread.sleep(10000); WebElement
		 * sentaction2 = driver.findElement(By.xpath("//ul[@x-placement]//a[3]"));
		 * act.click(sentaction2).perform(); Thread.sleep(10000);
		 *
		 * //span[normalize-space()='No'] By sentdel =
		 * By.xpath("(//span[normalize-space()='Cancel'])[3]"); WebDriverWait sentdel1 =
		 * new WebDriverWait(driver, Duration.ofMinutes(10)); WebElement delsent =
		 * sentdel1.until(ExpectedConditions.elementToBeClickable(sentdel));
		 * delsent.click();
		 *
		 */
	}



	public void importcontacts() throws Exception {
		Thread.sleep(10000);
		By importcon = By.xpath("//i[@class=\"el-icon-download\"]");
		WebDriverWait import1 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement imp1 = import1.until(ExpectedConditions.elementToBeClickable(importcon));
		imp1.click();

		Thread.sleep(10000);
		By impfross = By.xpath("//span[normalize-space()=\"Import from Spreadsheet\"]");
		WebDriverWait import2 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement imp2 = import2.until(ExpectedConditions.elementToBeClickable(impfross));
		imp2.click();

		Thread.sleep(10000);
		By downloadblankcsv = By.xpath("//span[normalize-space()=\"Download Blank CSV\"]");
		WebDriverWait csvdown = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement blank = csvdown.until(ExpectedConditions.elementToBeClickable(downloadblankcsv));
		blank.click();

		Thread.sleep(10000);
		By impcontinue = By.xpath("//span[normalize-space()=\"Continue\"]");
		WebDriverWait import3 = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement imp3 = import3.until(ExpectedConditions.elementToBeClickable(impcontinue));
		imp3.click();
	}

	@SuppressWarnings("deprecation")
	public void importcontactsdraganddrop() throws Exception {
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()=\"Import Contacts List\"]")).click();
		Runtime.getRuntime().exec("\"C:\\Users\\jeevitha.patnana\\OneDrive - Nimble Accounting\\Documents\\imp.exe\"");
		Thread.sleep(10000);
		By impclick = By.xpath("(//button[@class=\"el-button el-button--danger\"])[2]");
		WebDriverWait impclk = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement impbtn = impclk.until(ExpectedConditions.elementToBeClickable(impclick));
		impbtn.click();
		System.out.println("contacts imported successfully");

		driver.findElement(By.xpath("(//button[@aria-label=\"Close\"])[6]")).click();

		/*
		 * String Parentwindowid = driver.getWindowHandle(); driver.findElement(By.
		 * xpath("//span[normalize-space()=\\\"Import from Outlook\\\"]")).click();
		 * Set<String> allwindowhandles = driver.getWindowHandles(); for (String
		 * childwindow : allwindowhandles) { if (!childwindow.endsWith(Parentwindowid))
		 * { driver.switchTo().window(childwindow); Thread.sleep(10000); By
		 * impfrooutlook=By.xpath("(//img[@class=\"tile-img\"])[1]"); WebDriverWait
		 * import2 = new WebDriverWait(driver, Duration.ofMinutes(1)); WebElement imp2 =
		 * import2.until(ExpectedConditions.elementToBeClickable(impfrooutlook));
		 * imp2.click();
		 */

		// driver.findElement(By.xpath("(//input[@type=\"text\"])[5]")).clear();
		// driver.findElement(By.xpath("(//input[@type=\"text\"])[5]")).sendKeys("Meghanameghu@gmail.com");

		// driver.findElement(By.xpath("//span[normalize-space()='Update
		// Contact']")).click();

	}

}
