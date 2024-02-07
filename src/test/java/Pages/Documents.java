package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Documents {
	WebDriver driver;
	public Documents(WebDriver driver) {
		this.driver = driver;
	}
	public void ApprovedCorrectdocument() throws InterruptedException {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			System.out.println("Overlay not found or not invisible.");
		}

		By ad = By.xpath("//span[normalize-space()='Documents']");

		try {
			WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
			WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));

			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", add);
			System.out.println("Element clicked using JS.");
		} catch (Exception e) {

			System.out.println("Element not clickable or not found: ");
		}

		
		
		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();
		
		
		Thread.sleep(10000);
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[2]"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void ApprovedDeletedocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();
		

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[8]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("(//span[normalize-space()='Cancel'])[6]");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();

		Thread.sleep(10000);

}
	public void ApprovedDocumentsettings() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[7]"));
		act.click(subItem).perform();
		Thread.sleep(10000);


		 By Element2 = By.xpath("//span[normalize-space()='Save']"); WebDriverWait
		 hold1 = new WebDriverWait(driver, Duration.ofMinutes(10)); WebElement
		 document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		 document2.click();
		 Thread.sleep(10000);

}
	public void ApprovedDownloadoriginal() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[9]"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void ApprovedRenamedocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[6]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();
		Thread.sleep(10000);

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait hold2 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document3 = hold2.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("approve");
		Thread.sleep(10000);

		By Element4 = By.xpath("(//span[normalize-space()='Confirm'])[2]");
		WebDriverWait hold3 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document4 = hold3.until(ExpectedConditions.elementToBeClickable(Element4));
		document4.click();

	}
	public void ApprovedResenddocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[3]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("//span[normalize-space()='Resend']");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();

		Thread.sleep(10000);
		By Element3 = By.xpath("(//button//i)[51]");
		WebDriverWait hold2 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document3 = hold2.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.click();

		Thread.sleep(10000);
	}
	public void ApprovedSaveastemplate() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[4]"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void ApprovedVoiddocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[5]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("//span[normalize-space()='No']");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();

		Thread.sleep(10000);
	}
	public void ArchivedDownloadoriginal() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[7]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[5]"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void ArchivedPermanentdelete() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[7]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[4]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("(//span[normalize-space()='Cancel'])[6]");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();

		Thread.sleep(10000);

}
	public void ArchivedRenamedocuments() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[7]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[2]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();
		Thread.sleep(10000);

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait hold2 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document3 = hold2.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("Archieved");
		Thread.sleep(10000);

		By Element4 = By.xpath("(//span[normalize-space()='Confirm'])[2]");
		WebDriverWait hold3 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document4 = hold3.until(ExpectedConditions.elementToBeClickable(Element4));
		document4.click();
	}
	public void ArchivedUndodocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[7]")).click();


		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[3]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("(//span[normalize-space()='Cancel'])[6]");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();

		Thread.sleep(10000);
	}
	public void CompletedClonedocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By CP = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait CP1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement CP2 = CP1.until(ExpectedConditions.elementToBeClickable(CP));
		CP2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[8]")).click();
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[4]"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void CompletedDeletedocuement() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By CP = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait CP1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement CP2 = CP1.until(ExpectedConditions.elementToBeClickable(CP));
		CP2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[8]")).click();
		Thread.sleep(10000);
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[7]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("//span[normalize-space()='OK']");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();
		Thread.sleep(10000);


	}
	public void CompletedDownloaddocuement() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By CP = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait CP1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement CP2 = CP1.until(ExpectedConditions.elementToBeClickable(CP));
		CP2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[8]")).click();
		Thread.sleep(10000);

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[6]"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void CompletedDownloadoriginal() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);

		By CP = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait CP1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement CP2 = CP1.until(ExpectedConditions.elementToBeClickable(CP));
		CP2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[8]")).click();
		Thread.sleep(10000);

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[8]"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void CompletedRenamedocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By CP = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait CP1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement CP2 = CP1.until(ExpectedConditions.elementToBeClickable(CP));
		CP2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[8]")).click();
		Thread.sleep(10000);

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[5]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();
		Thread.sleep(10000);

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait hold2 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document3 = hold2.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("test");
		Thread.sleep(10000);
		By Element4 = By.xpath("(//span[normalize-space()='Confirm'])[2]");
		WebDriverWait hold3 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document4 = hold3.until(ExpectedConditions.elementToBeClickable(Element4));
		document4.click();


	}
	public void CompletedSaveastemplate() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);

		By CP = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait CP1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement CP2 = CP1.until(ExpectedConditions.elementToBeClickable(CP));
		CP2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[8]")).click();
		Thread.sleep(10000);
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[2]//i"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void CompletedSenttomail() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);

		By CP = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait CP1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement CP2 = CP1.until(ExpectedConditions.elementToBeClickable(CP));
		CP2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[8]")).click();
		Thread.sleep(10000);

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[9]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("(//span//i[@class='el-select__caret el-input__icon el-icon-arrow-up'])[4]");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();

		Thread.sleep(10000);
		driver.findElement(By.xpath("(//div[@class='el-scrollbar']//ul//li[7])[3]")).click();
		Thread.sleep(10000);
		By Element3 = By.xpath("//span[normalize-space()='Send']");
		WebDriverWait hold3 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document3 = hold3.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.click();

	}
	public void CompletedSharewithothers() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);

		By CP = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait CP1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement CP2 = CP1.until(ExpectedConditions.elementToBeClickable(CP));
		CP2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[8]")).click();
		Thread.sleep(10000);
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[3]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("//span[normalize-space()='ramyasibbala2002@gmail.com']");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();
		Thread.sleep(10000);

		//span[normalize-space()='Save & Update']
		By Element3 = By.xpath("//span[normalize-space()='Save & Update']");
		WebDriverWait hold2 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document3 = hold2.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.click();
		Thread.sleep(10000);
	}
	public void DeclinedDeletedocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[6]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("(//span[normalize-space()='Cancel'])[6]");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();

		Thread.sleep(10000);

}
	public void DeclinedDocumentsettings() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[5]"));
		act.click(subItem).perform();
		Thread.sleep(10000);


		 By Element2 = By.xpath("//span[normalize-space()='Save']"); WebDriverWait
		 hold1 = new WebDriverWait(driver, Duration.ofMinutes(10)); WebElement
		 document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		 document2.click();
		 Thread.sleep(10000);

}
	public void DeclinedDownloadoriginal() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[7]"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void DeclinedRenamedocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[4]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();
		Thread.sleep(10000);

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait hold2 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document3 = hold2.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("Decline");
		Thread.sleep(10000);

		By Element4 = By.xpath("(//span[normalize-space()='Confirm'])[2]");
		WebDriverWait hold3 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document4 = hold3.until(ExpectedConditions.elementToBeClickable(Element4));
		document4.click();

	}
	public void DeclinedSaveastemplate() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[2]"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void DeclinedVoiddocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[3]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("//span[normalize-space()='No']");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();

		Thread.sleep(10000);
	}
	public void DraftDeletedocument() throws InterruptedException {
		Thread.sleep(10000);
		By DD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait DD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement DD2 = DD1.until(ExpectedConditions.elementToBeClickable(DD));
		DD2.click();

		Thread.sleep(10000);

		By draft = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait draft1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement draft2 = draft1.until(ExpectedConditions.elementToBeClickable(draft));
		draft2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[1]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[5]//i"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void Draftdocumentsetting() throws InterruptedException {
		Thread.sleep(10000);
		By DS = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait DS1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement DS2 = DS1.until(ExpectedConditions.elementToBeClickable(DS));
		DS2.click();

		Thread.sleep(10000);

		By draft = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait draft1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement draft2 = draft1.until(ExpectedConditions.elementToBeClickable(draft));
		draft2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[1]")).click();
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[4]//i"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void DraftDownloaddocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);

		By draft = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait draft1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement draft2 = draft1.until(ExpectedConditions.elementToBeClickable(draft));
		draft2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[1]")).click();
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[5]//i"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void DraftrenameDocument() throws InterruptedException {
		Thread.sleep(10000);
		By a = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait a1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement a2 = a1.until(ExpectedConditions.elementToBeClickable(a));
		a2.click();

		Thread.sleep(10000);
		By draft = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait draft1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement draft2 = draft1.until(ExpectedConditions.elementToBeClickable(draft));
		draft2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[1]")).click();
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[2]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[3]//i"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();
		Thread.sleep(10000);

		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait hold2 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document3 = hold2.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("Rename");
		Thread.sleep(10000);

		By Element4 = By.xpath("(//span[normalize-space()='Confirm'])[2]");
		WebDriverWait hold3 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document4 = hold3.until(ExpectedConditions.elementToBeClickable(Element4));
		document4.click();
		Thread.sleep(10000);
	}
	public void DraftSentDocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By draft = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait draft1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement draft2 = draft1.until(ExpectedConditions.elementToBeClickable(draft));
		draft2.click();
		Thread.sleep(10000);
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[4]"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void DraftVoiddocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By draft = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait draft1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement draft2 = draft1.until(ExpectedConditions.elementToBeClickable(draft));
		draft2.click();
		Thread.sleep(10000);
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[5]//i"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("//span[normalize-space()='No']");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();

		Thread.sleep(10000);
	}
	public void SentcorrectDocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);

		Thread.sleep(10000);
		By sent = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait sent1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement sent2 = sent1.until(ExpectedConditions.elementToBeClickable(sent));
		sent2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[2]")).click();
		Thread.sleep(10000);
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[2]"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void SentDeletedocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);

		Thread.sleep(10000);
		By sent = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait sent1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement sent2 = sent1.until(ExpectedConditions.elementToBeClickable(sent));
		sent2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[2]")).click();
		Thread.sleep(10000);
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[8]//i"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void Sentdocumentsettings() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);

		Thread.sleep(10000);
		By sent = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait sent1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement sent2 = sent1.until(ExpectedConditions.elementToBeClickable(sent));
		sent2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[2]")).click();
		Thread.sleep(10000);
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[7]//i"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void SentDownloaddocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		Thread.sleep(10000);
		By sent = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait sent1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement sent2 = sent1.until(ExpectedConditions.elementToBeClickable(sent));
		sent2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[2]")).click();
		Thread.sleep(10000);

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[9]//i"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void SentRenamedocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);

		Thread.sleep(10000);
		By sent = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait sent1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement sent2 = sent1.until(ExpectedConditions.elementToBeClickable(sent));
		sent2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[2]")).click();
		Thread.sleep(10000);


		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[6]//i"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void SentResenddocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);

		Thread.sleep(10000);
		By sent = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait sent1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement sent2 = sent1.until(ExpectedConditions.elementToBeClickable(sent));
		sent2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[2]")).click();
		Thread.sleep(10000);
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[3]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("//span[normalize-space()='Resend']");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();

		Thread.sleep(10000);
		By Element3 = By.xpath("(//button//i)[51]");
		WebDriverWait hold2 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document3 = hold2.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.click();

		Thread.sleep(10000);
	}
	public void SentsavetoTemplate() throws InterruptedException {
		Thread.sleep(10000);
		By d = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait d1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement d2 = d1.until(ExpectedConditions.elementToBeClickable(d));
		d2.click();
		Thread.sleep(10000);
		Thread.sleep(10000);
		By sent = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait sent1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement sent2 = sent1.until(ExpectedConditions.elementToBeClickable(sent));
		sent2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[2]")).click();

		Thread.sleep(10000);
		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));
		Actions act1 = new Actions(driver);
		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"]//a[1]//i"));
		act.click(subItem).perform();
		Thread.sleep(10000);
		}
	public void SentVoiddocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		Thread.sleep(10000);
		By sent = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait sent1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement sent2 = sent1.until(ExpectedConditions.elementToBeClickable(sent));
		sent2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[2]")).click();
		Thread.sleep(10000);

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[5]//i"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void VoidClonedocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@x-placement]//ul//li[6]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[3]"));
		act.click(subItem).perform();
		Thread.sleep(10000);


	}
	public void VoidDeletedocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@x-placement]//ul//li[6]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[4]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("(//span[normalize-space()='Cancel'])[6]");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();

		Thread.sleep(10000);


	}
	public void VoidDownloadoriginal() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@x-placement]//ul//li[6]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[5]"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void VoidSaveastemplate() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@x-placement]//ul//li[6]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[2]"));
		act.click(subItem).perform();
		Thread.sleep(10000);


	}
	public void WaitformeWaitforme() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[9]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[2]"));
		act.click(subItem).perform();
		Thread.sleep(10000);


	}
	public void WaitingForOthersCorrectdocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[2]"));
		act.click(subItem).perform();
		Thread.sleep(10000);


	}
	public void WaitingForOthersDeletedocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[8]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("(//span[normalize-space()='Cancel'])[6]");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();

		Thread.sleep(10000);

}
	public void WaitingForOthersDocumentsettings() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[7]"));
		act.click(subItem).perform();
		Thread.sleep(10000);


		 By Element2 = By.xpath("//span[normalize-space()='Save']"); WebDriverWait
		 hold1 = new WebDriverWait(driver, Duration.ofMinutes(10)); WebElement
		 document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		 document2.click();
		 Thread.sleep(10000);

}
	public void WaitingForOthersDownloadoriginal() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[9]"));
		act.click(subItem).perform();
		Thread.sleep(10000);
	}
	public void WaitingForOthersRenamedocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[6]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.clear();

		Thread.sleep(10000);
		By Element3 = By.xpath("//input[@placeholder='Document Name']");
		WebDriverWait hold2 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document3 = hold2.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.sendKeys("hfsdbjhdk");

		Thread.sleep(10000);

		By Element4 = By.xpath("(//span[normalize-space()='Confirm'])[2]");
		WebDriverWait hold3 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document4 = hold3.until(ExpectedConditions.elementToBeClickable(Element4));
		document4.click();

}
	public void WaitingForOthersResenddocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[3]"));
		act.click(subItem).perform();
		Thread.sleep(10000);

		By Element2 = By.xpath("//span[normalize-space()='Resend']");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();

		Thread.sleep(10000);
		By Element3 = By.xpath("(//button//i)[15]");
		WebDriverWait hold2 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document3 = hold2.until(ExpectedConditions.elementToBeClickable(Element3));
		document3.click();

		Thread.sleep(10000);


	}
	public void WaitingForOthersSaveastemplate() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[4]"));
		act.click(subItem).perform();
		Thread.sleep(10000);



	}
	public void WaitingForOthersVoiddocument() throws InterruptedException {
		Thread.sleep(10000);
		By dD = By.xpath("//span[normalize-space()='Documents']");
		WebDriverWait dD1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement dD2 = dD1.until(ExpectedConditions.elementToBeClickable(dD));
		dD2.click();

		Thread.sleep(10000);
		By WM = By.xpath("//input[@placeholder='Select Status']");
		WebDriverWait WM1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement WM2 = WM1.until(ExpectedConditions.elementToBeClickable(WM));
		WM2.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[10]")).click();

		WebElement elementTomove = driver.findElement(By.xpath("//div[@class='el-table__fixed-body-wrapper']//tr[1]"));

		Actions act = new Actions(driver);

		act.moveToElement(elementTomove).perform();
		Thread.sleep(10000);
		WebElement elementTomove2 = driver.findElement(By.xpath("//div[@class='el-table__fixed']//tr[1]//i[@class='el-icon-arrow-down el-icon--right']"));

		Actions act1 = new Actions(driver);

		Thread.sleep(10000);
		act1.moveToElement(elementTomove2).perform();
		Thread.sleep(10000);
		WebElement subItem = driver.findElement(By.xpath("//ul[@x-placement]//a[5]"));
		act.click(subItem).perform();
		Thread.sleep(10000);
		By Element2 = By.xpath("//span[normalize-space()='No']");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement document2 = hold1.until(ExpectedConditions.elementToBeClickable(Element2));
		document2.click();



	}
}
