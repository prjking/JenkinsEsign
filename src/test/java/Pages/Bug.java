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

	public void Save5423() throws Exception {
		MethodActions.waitEle(By.xpath("//span[normalize-space()=\"Save\"]"));

	}

	public void veiwAction5423() throws Exception {
		Thread.sleep(10000);

		WebElement elementToHover = driver.findElement(By.xpath(
				"//div[@class='el-table__body-wrapper is-scrolling-none']//td[normalize-space()='unique_string_sample12a560']/ancestor::tr//span[normalize-space()=\"Actions\"]"
						+ ""));

		Actions actions = new Actions(driver);
		Thread.sleep(10000);
		actions.moveToElement(elementToHover).perform();
		MethodActions.waitEle(By.xpath("//ul[@x-placement]//a[1]"));
		System.out.println("Hidden doc field is getting visible");

	}

}
