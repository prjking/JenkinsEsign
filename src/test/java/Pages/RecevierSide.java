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

	public void CheckRecevierSide() throws Exception {
		driver.get(
				"https://dev.esigns.io/emp-documents/preview/659bf0e862511da099b15582/pp/vp/659bbcece4adf8e24af80d2c?token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbXBfZG9jdW1lbnRfaWQiOiI2NTliZjBlODYyNTExZGEwOTliMTU1ODIiLCJwYXNzY29kZSI6IjBueXYyZiIsIndvcmtmbG93X2lkIjpudWxsLCJpYXQiOjE3MDQ3MTg1NjgsImV4cCI6MTcwNDg5MTM2OH0.BWrxiGXDD-XoPw3QN86l_1QlOw-F3YngtRWRJx1ghv4");
		By Element = By.xpath("//div//input[@placeholder='Enter 6 letters code']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(4));
		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));
		canc.sendKeys("0nyv2f");
		driver.findElement(By.xpath("//div[@class='el-form-item__content']//span[normalize-space()='Submit']")).click();
		try {
			By ele = By.xpath("//span[@class='el-checkbox__inner']");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement sen = wait.until(ExpectedConditions.elementToBeClickable(ele));
			sen.click();
			Thread.sleep(10000);
			driver.findElement(By.xpath("//span[normalize-space()='Continue']")).click();
		} catch (Exception e) {
			By sign = By.xpath("//section[@id=\"drag-template-background\"]//div[@data-index='0']//button");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
			WebElement sen = wait.until(ExpectedConditions.elementToBeClickable(sign));
			sen.click();
			Set<String> windowHandles = driver.getWindowHandles();
			for (String handle : windowHandles) {
				driver.switchTo().window(handle);
			}
		}
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='card mb-3']//input[@placeholder='Select']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[19]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter signature']")).sendKeys("Prj");
		driver.findElement(By.xpath("//div[@id='pane-letter']//button[1]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Edit']")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("tab-drawer")).click();
		Thread.sleep(10000);
		Actions act = new Actions(driver);
		Thread.sleep(10000);
		act.clickAndHold(driver.findElement(By.xpath("//div[@id='signature']//canvas")))
				.moveToElement(driver.findElement(By.xpath("//div[@id='signature']//canvas")), 20, -50)
				.moveByOffset(50, 50).moveByOffset(80, -50).moveByOffset(100, 50).release().build().perform();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Verify & Save Secure Signature']")).click();
		Thread.sleep(10000);
		By down = By.xpath("//span[normalize-space()='FINISH']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement download = wait.until(ExpectedConditions.elementToBeClickable(down));
		download.click();
		Thread.sleep(10000);
		WebElement elementToHover = driver.findElement(By.xpath("//span[normalize-space()='Download']"));

		Actions actions = new Actions(driver);

		actions.moveToElement(elementToHover).perform();
		Thread.sleep(10000);  
		By down11 = By.xpath("//ul[@x-placement]//li[normalize-space()='TESTING (1)']");
		WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement download11 = wait11.until(ExpectedConditions.elementToBeClickable(down11));
		download11.click();
		

	}
}
