package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
}
