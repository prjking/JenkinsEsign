package Pages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}

	public static void Loadingmask() throws Exception {
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		By overlayLocator = By.xpath("//div[@class='el-loading-mask is-fullscreen']");

		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(overlayLocator));
		} catch (Exception e) {

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

	public static void asert(String message, WebElement element) {
		String actualValue = element.getText();
		System.out.println(message + ": " + actualValue);
	}

	public static void takeScreenshot(WebDriver driver) throws Exception {
		Thread.sleep(10000);
		try {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			String filename = "C:\\Work Space\\Esign\\src\\test\\Screenshots\\screenshot_" + timestamp + ".png";
			FileUtils.copyFile(screenshotFile, new File(filename));
		} catch (IOException e) {
			System.out.println("Failed to take screenshot: " + e.getMessage());
		}
	}

	public static void pagenation(String elementXPath) throws Exception {
		Thread.sleep(10000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		int pageNumber = 1;
		do {
			try {
				waitEle(By.xpath(elementXPath));

				System.out.println("Element found on page " + pageNumber);
			} catch (Exception e) {
				System.out.println("Element not found on page " + pageNumber);
			}

			try {
				WebElement nextPageButton = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn-next']")));
				nextPageButton.click();
				pageNumber++;
			} catch (Exception e) {
				System.out.println("Next page button not found or timeout, ending loop.");
				break;
			}
		} while (true);
	}

	public static void dragAndDrop(WebElement source, WebElement target) {
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(source).moveToElement(target).release(target).build();
		dragAndDrop.perform();
	}

 public static void setFilePermissions(String filePath, String permissions) {
        try {
        
            Set<PosixFilePermission> perms = PosixFilePermissions.fromString(permissions);
            Files.setPosixFilePermissions(Paths.get(filePath), perms);
            System.out.println("File permissions changed successfully for: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to change file permissions for: " + filePath);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
            System.err.println("POSIX file permissions not supported on this system.");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            System.err.println("Invalid permission string: " + permissions);
        }
    }

   

}