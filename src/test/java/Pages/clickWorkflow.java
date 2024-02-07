
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
 
public class clickWorkflow {

	static WebDriver driver;
 
	@SuppressWarnings("static-access")

	public clickWorkflow(WebDriver driver) {

		this.driver = driver;

	}
 
	public static void highlight(WebElement element) {

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid blue;');", element);

	}
 
	public void clickWF() throws Exception {

		Thread.sleep(10000);
 
		By Element = By.xpath("//span[normalize-space()='Workflows']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));

		canc.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//span[text()=\" Create Workflow \"]")).click();

		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {

			driver.switchTo().window(handle);

		}

		Thread.sleep(10000);

		WebElement w=driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));

		highlight(w);

		w.sendKeys(("TestingWF"));

		Thread.sleep(10000);

		WebElement clickAllDoc=driver.findElement(By.xpath("//div[@aria-label='Workflow Name']//span[contains(text(),'Confirm')]"));

		highlight(clickAllDoc);

		clickAllDoc.click();

		Thread.sleep(10000);

		WebElement file=driver.findElement(By.xpath("//div[text()=\" Payslip Nov 202 \"]"));

		highlight(file);

		file.click();

		Thread.sleep(10000);

		WebElement file2=driver.findElement(By.xpath("//div[text()=\" Evaluation form (1) \"]"));

		highlight(file2);

		file2.click();

		Thread.sleep(10000);

		WebElement save=driver.findElement(By.xpath("//span[normalize-space()='Save & send']"));

		highlight(save);

		save.click();

		Thread.sleep(10000);

		WebElement next=driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]"));

		highlight(next);

		next.click();

		Thread.sleep(10000);

		WebElement send=driver.findElement(By.xpath("//button[@class='el-button doc-send-button el-button--danger']"));

		highlight(send);

		send.click();

		// Check Status

	}

	public void status() throws Exception {
 
		WebElement status=driver.findElement(By.xpath("//input[@placeholder=\"Select Status\"]"));

		highlight(status);

		status.click();

		Thread.sleep(10000);

		WebElement inactive=driver.findElement(By.xpath("//span[normalize-space()=\"Inactive\"]"));

		highlight(inactive);

		inactive.click();

	}
 
	// Search

	public void search() {

		WebElement search=driver.findElement(By.xpath("//input[@placeholder=\"Search\"]"));

		highlight(search);

		search.sendKeys("hbh");

	}
 
	// Actions

	// Edit

	public void actionEdit() throws Exception {

		WebElement elementToHover = driver.findElement(By.xpath("//div[3]/table/tbody/tr[1]/td[2]"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='Edit']")).click();

		Thread.sleep(10000);

		WebElement elementToDoubleClick = driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]"));

        Actions actions1 = new Actions(driver);

        actions1.doubleClick(elementToDoubleClick).perform();	

        driver.findElement(By.xpath("//input[@placeholder=\"Enter Template Title\"]")).sendKeys("Meghana");

        driver.findElement(By.xpath("//span[normalize-space()='Save Workflow']")).click();

	}
 
	// Rename
 
	public void actionRename() throws Exception {

		WebElement elementToHover = driver.findElement(By.xpath("//div[3]/table/tbody/tr[1]/td[2]"));
 
		Actions actions = new Actions(driver);
 
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='Rename']")).click();

		Thread.sleep(10000);

		WebElement elementToDoubleClick = driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));

		Actions actions2 = new Actions(driver);

		actions2.doubleClick(elementToDoubleClick).perform();

		driver.findElement(By.xpath("//input[@placeholder=\"Title\"]")).sendKeys("qwerty");
 
		driver.findElement(By.xpath("//div[@class=\"el-dialog__wrapper rename-workflow-popup\"]//span[normalize-space()=\"Confirm\"]")).click();

	}
 
	// View Workflow Data
 
	public void actionViewData() throws Exception {

		WebElement elementToHover = driver.findElement(By.xpath("//div[3]/table/tbody/tr[1]/td[2]"));
 
		Actions actions = new Actions(driver);
 
		actions.moveToElement(elementToHover).perform();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='View Workflow Data']")).click();

		Thread.sleep(10000);

	}
 
	// Inactive

	public void actionInactive() throws Exception {

	WebElement elementToHover = driver.findElement(By.xpath("//div[3]/table/tbody/tr[1]/td[2]"));
 
	Actions actions = new Actions(driver);
 
	actions.moveToElement(elementToHover).perform();

	Thread.sleep(10000);

	driver.findElement(By.xpath("//ul[@x-placement=\"bottom-end\"] //li[normalize-space()='Inactive']")).click();

	Thread.sleep(10000);

}

	// Preview click add data and send
 
	public void previewWF() throws Exception {

		Thread.sleep(10000);
 
		By Element = By.xpath("//span[normalize-space()='Workflows']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));

		canc.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//span[text()=\" Create Workflow \"]")).click();

		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {

			driver.switchTo().window(handle);

		}

		Thread.sleep(10000);

		WebElement w=driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));

		highlight(w);

		w.sendKeys(("TestingWF"));

		Thread.sleep(10000);

		WebElement clickAllDoc=driver.findElement(By.xpath("//div[@aria-label='Workflow Name']//span[contains(text(),'Confirm')]"));

		highlight(clickAllDoc);

		clickAllDoc.click();

		Thread.sleep(10000);

		WebElement file=driver.findElement(By.xpath("//div[text()=\" Payslip Nov 202 \"]"));

		highlight(file);

		file.click();

		Thread.sleep(10000);

		WebElement file2=driver.findElement(By.xpath("//div[text()=\" Evaluation form (1) \"]"));

		highlight(file2);

		file2.click();

		Thread.sleep(10000);

		WebElement save=driver.findElement(By.xpath("//span[normalize-space()='Save & send']"));

		highlight(save);

		save.click();

		Thread.sleep(10000);

		WebElement next=driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]"));

		highlight(next);

		next.click();

		Thread.sleep(10000);

		WebElement prev=driver.findElement(By.xpath("//span[normalize-space()=\"Prev\"]"));

		highlight(prev);

		prev.click();

		Thread.sleep(10000);

		WebElement feild1=driver.findElement(By.xpath("//input[@class=\"el-input__inner\"][@placeholder=\"Enter Template Title\"]"));

		highlight(feild1);

		feild1.sendKeys("N180894");

		Thread.sleep(10000);

		WebElement send=driver.findElement(By.xpath("//button[@class='el-button doc-send-button el-button--danger']"));

		highlight(send);

		send.click();

	}
 
	// Add group while creating workflow and check in groups module
 
	

	public void addGroup() throws Exception {

		Thread.sleep(10000);
 
		By Element = By.xpath("//span[normalize-space()='Workflows']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));

		canc.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//span[text()=\" Create Workflow \"]")).click();

		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {

			driver.switchTo().window(handle);

		}

		Thread.sleep(10000);

		WebElement w=driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));

		highlight(w);

		w.sendKeys(("TestingAdGroup"));

		Thread.sleep(10000);

		WebElement Group=driver.findElement(By.xpath("//i[@class=\"el-tooltip el-icon-circle-plus-outline\"]"));

		highlight(Group);

		Group.click();

		Thread.sleep(10000);

		WebElement groupTitle=driver.findElement(By.xpath("//input[@placeholder=\"Enter Title\"]"));

		highlight(groupTitle);

		groupTitle.sendKeys("testing1");

		Thread.sleep(10000);

		WebElement clickOnSave=driver.findElement(By.xpath("//i[@class='el-icon-check']"));

		highlight(clickOnSave);

		clickOnSave.click();

		Thread.sleep(10000);
 
		WebElement clickAllDoc=driver.findElement(By.xpath("//div[@aria-label='Workflow Name']//span[contains(text(),'Confirm')]"));

		highlight(clickAllDoc);

		clickAllDoc.click();

		Thread.sleep(10000);

		WebElement file=driver.findElement(By.xpath("//div[text()=\" Payslip Nov 202 \"]"));

		highlight(file);

		file.click();

		Thread.sleep(10000);

		WebElement file2=driver.findElement(By.xpath("//div[text()=\" Evaluation form (1) \"]"));

		highlight(file2);

		file2.click();

		Thread.sleep(10000);

		WebElement save=driver.findElement(By.xpath("//span[normalize-space()='Save & send']"));

		highlight(save);

		save.click();

		Thread.sleep(10000);

		WebElement next=driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]"));

		highlight(next);

		next.click();

		Thread.sleep(10000);

		WebElement next1=driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]"));

		highlight(next1);

		next1.click();
 
		WebElement send=driver.findElement(By.xpath("//button[@class='el-button doc-send-button el-button--danger']"));

		highlight(send);

		send.click();

	}
 
	// test enforce while adding multiple contacts

	public void enforce() throws Exception {

		By Element = By.xpath("//span[normalize-space()='Workflows']");

		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));

		canc.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//span[text()=\" Create Workflow \"]")).click();

		Thread.sleep(10000);

		Set<String> windowHandles = driver.getWindowHandles();

		for (String handle : windowHandles) {

			driver.switchTo().window(handle);

		}

		Thread.sleep(10000);

		WebElement w=driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));

		highlight(w);

		w.sendKeys(("enforce"));

		Thread.sleep(10000);

		WebElement clickAllDoc=driver.findElement(By.xpath("//div[@aria-label='Workflow Name']//span[contains(text(),'Confirm')]"));

		highlight(clickAllDoc);

		clickAllDoc.click();

		Thread.sleep(10000);

		WebElement file=driver.findElement(By.xpath("//div[text()=\" Payslip Nov 202 \"]"));

		highlight(file);

		file.click();

		Thread.sleep(10000);

		WebElement file2=driver.findElement(By.xpath("//div[text()=\" Evaluation form (1) \"]"));

		highlight(file2);

		file2.click();

		Thread.sleep(10000);

		WebElement save=driver.findElement(By.xpath("//span[normalize-space()='Save & send']"));

		highlight(save);

		save.click();

		Thread.sleep(10000);

		WebElement cont1=driver.findElement(By.xpath("//div[@id=\"user_1\"]//input[@placeholder='Search with Email']"));

		highlight(cont1);

		cont1.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]")).click();

		WebElement cont2=driver.findElement(By.xpath("//div[@id=\"user_2\"]//input[@placeholder='Search with Email']"));

		highlight(cont2);

		cont2.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@x-placement=\"bottom-start\"]//li[3]")).click();

		WebElement cont3=driver.findElement(By.xpath("//div[@id=\"user_3\"]//input[@placeholder='Search with Email']"));

		highlight(cont3);

		cont3.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@x-placement=\"top-start\"]//li[5]")).click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//span[normalize-space()=\"Enforce Workflow Order\"]")).click();

		Thread.sleep(10000);

		WebElement next=driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]"));

		highlight(next);

		next.click();

		Thread.sleep(10000);

		WebElement prev=driver.findElement(By.xpath("//span[normalize-space()=\"Prev\"]"));

		highlight(prev);

		prev.click();

		Thread.sleep(10000);

		WebElement send=driver.findElement(By.xpath("//button[@class='el-button doc-send-button el-button--danger']"));

		highlight(send);

		send.click();

	}

	//Primary Users

	public void primaryUser() throws Exception {

	Thread.sleep(10000);
 
	By Element = By.xpath("//span[normalize-space()='Workflows']");

	WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));

	WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));

	canc.click();

	Thread.sleep(10000);

	driver.findElement(By.xpath("//span[text()=\" Create Workflow \"]")).click();

	Thread.sleep(10000);

	Set<String> windowHandles = driver.getWindowHandles();

	for (String handle : windowHandles) {

		driver.switchTo().window(handle);

	}

	Thread.sleep(10000);

	WebElement w=driver.findElement(By.xpath("//input[@placeholder=\"Title\"]"));

	highlight(w);

	w.sendKeys(("Testing"));

	Thread.sleep(10000);
 
	WebElement clickAllDoc=driver.findElement(By.xpath("//div[@aria-label='Workflow Name']//span[contains(text(),'Confirm')]"));

	highlight(clickAllDoc);

	clickAllDoc.click();

	Thread.sleep(10000);

	WebElement file=driver.findElement(By.xpath("//div[text()=\" PERMANENT ADDRESS_N180894 \"]"));

	highlight(file);

	file.click();

	Thread.sleep(10000);

	WebElement file2=driver.findElement(By.xpath("//div[text()=\" address \"]"));

	highlight(file2);

	file2.click();

	Thread.sleep(10000);

	WebElement file3=driver.findElement(By.xpath("//div[text()=\" practice \"]"));

	highlight(file3);

	file3.click();

	Thread.sleep(10000);

	WebElement save=driver.findElement(By.xpath("//span[normalize-space()='Save & send']"));

	highlight(save);

	save.click();

	Thread.sleep(10000);

	WebElement cont1=driver.findElement(By.xpath("//div[@id=\"user_0\"]//input[@placeholder='Search with Email']"));

	highlight(cont1);

	cont1.click();

	Thread.sleep(10000);

	driver.findElement(By.xpath("//div[@x-placement=\"bottom-start\"]//li[2]")).click();

	WebElement cont2=driver.findElement(By.xpath("//div[@id=\"user_1\"]//input[@placeholder='Search with Email']"));

	highlight(cont2);

	cont2.click();

	Thread.sleep(10000);

	driver.findElement(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]")).click();

	WebElement cont3=driver.findElement(By.xpath("//div[@id=\"user_2\"]//input[@placeholder='Search with Email']"));

	highlight(cont3);

	cont3.click();

	Thread.sleep(10000);

	driver.findElement(By.xpath("//div[@x-placement=\"bottom-start\"]//li[1]")).click();

	Thread.sleep(10000);

	driver.findElement(By.xpath("(//div[@id=\"user_1\"]//label)[1]")).click();

	Thread.sleep(10000);

	WebElement next=driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]"));

	highlight(next);

	next.click();

	Thread.sleep(10000);

	WebElement next1=driver.findElement(By.xpath("//span[normalize-space()=\"Next\"]"));

	highlight(next1);

	next1.click();
 
	WebElement send=driver.findElement(By.xpath("//button[@class='el-button doc-send-button el-button--danger']"));

	highlight(send);

	send.click();

}
 
	
 
}
