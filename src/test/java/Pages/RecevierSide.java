package Pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecevierSide {
	WebDriver driver;

	public RecevierSide(WebDriver driver) {
		this.driver = driver;

	}

	public void waitEle(By by) throws Exception {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}

	public void CheckRecevierSide() throws Exception {
		driver.get(
				"https://dev.esigns.io/emp-documents/preview/65c0a9b8aa64cfe3cd633374/pp/vp/659fc16a24885c89f0305d01?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbXBfZG9jdW1lbnRfaWQiOiI2NWMwYTliOGFhNjRjZmUzY2Q2MzMzNzQiLCJwYXNzY29kZSI6Im5kcnY2NiIsIndvcmtmbG93X2lkIjpudWxsLCJpYXQiOjE3MDcxMjUxNzcsImV4cCI6MTcwNzI5Nzk3N30.h6h0lc9gMNV8FYpDcayyMQbRhUaSP3R0HXqIxD_zWFw");
		By Element = By.xpath("//div//input[@placeholder='Enter 6 letters code']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));
		canc.sendKeys("ndrv66");
		waitEle(By.xpath("//div[@class='el-form-item__content']//span[normalize-space()='Submit']"));
		try {
			waitEle(By.xpath("//span[@class='el-checkbox__inner']"));

			waitEle(By.xpath("//span[normalize-space()='Continue']"));
		} catch (Exception e) {
			
		}

		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@placeholder='Enter Company']")).sendKeys("HGT");
		waitEle(By.xpath("//span[normalize-space()='FINISH']"));

//		waitEle(By.xpath("//div[@class='card mb-3']//input[@placeholder='Select']"));
//
//		waitEle(By.xpath("//div[@x-placement]//ul//li[19]"));
//		driver.findElement(By.xpath("//input[@placeholder='Enter signature']")).sendKeys("Prj");
//		waitEle(By.xpath("//div[@id='pane-letter']//button[1]"));
//
//		waitEle(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']"));
//
//		waitEle(By.xpath("//span[normalize-space()='Edit']"));
//
//		waitEle(By.id("tab-drawer"));
//		Actions act = new Actions(driver);
//		Thread.sleep(10000);
//		act.clickAndHold(driver.findElement(By.xpath("//div[@id='signature']//canvas")))
//				.moveToElement(driver.findElement(By.xpath("//div[@id='signature']//canvas")), 20, -50)
//				.moveByOffset(50, 50).moveByOffset(80, -50).moveByOffset(100, 50).release().build().perform();
//		Thread.sleep(10000);
//		driver.findElement(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']")).click();
//		Thread.sleep(10000);
//		By down = By.xpath("//span[normalize-space()='FINISH']");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
//		WebElement download = wait.until(ExpectedConditions.elementToBeClickable(down));
//		download.click();
//		Thread.sleep(10000);
//		WebElement elementToHover = driver.findElement(By.xpath("//span[normalize-space()='Download']"));
//
//		Actions actions = new Actions(driver);
//
//		actions.moveToElement(elementToHover).perform();
//		Thread.sleep(10000);
//		By down11 = By.xpath("//ul[@x-placement]//li[normalize-space()='TESTING (1)']");
//		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofMinutes(2));
//		WebElement download11 = wait11.until(ExpectedConditions.elementToBeClickable(down11));
//		download11.click();

	}
}
