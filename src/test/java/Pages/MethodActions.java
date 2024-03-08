package Pages;

import java.time.Duration;
import java.util.Set;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MethodActions {
	static WebDriver driver;

	public MethodActions(WebDriver driver) {
		MethodActions.driver = driver;

	}

	public static void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public static void switchToNewWindow() {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
	}

	public static void Javascriptclick(By xpath) throws Exception {
		Thread.sleep(3000);
		WebElement element = driver.findElement(xpath);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void Loadingmask() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

			System.out.println("Overlay not found or not invisible.");
		}

	}

	public static String generateUniqueEmail() {
		return "user_" + UUID.randomUUID().toString().substring(0, 8) + "@gmail.com";
	}

	private static int counter = 0;

	public static String generateUniqueString() {
		return "unique_string_sample" + UUID.randomUUID().toString().substring(0, 5) + counter++;
	}

	public static void sendKeysToElement(By by, CharSequence keysToSend) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
		element.sendKeys(keysToSend);
	}

	public static void waitAndClick(Actions actions, WebElement element, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		try {
			Actions builder = new Actions(driver);
			WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(element));

			builder.clickAndHold(clickableElement).moveToElement(target).release().build().perform();

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void scrollIntoViewAndClick(By by, WebDriver driver, WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(50000);
		element.click();
	}

}