package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Addrecipients {
	WebDriver driver;

	public Addrecipients(WebDriver driver) {

		this.driver = driver;

	}

	public void Recipients() throws Exception {
		By ad = By.xpath("//span[contains(text(),'Add Recipient')]");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));
		add.click();

		driver.findElement(By.xpath("//div[@id='user_1']//input[@placeholder='Select contact type']")).click();

		By ad1 = By.xpath("//div[@x-placement]//ul//li[1]");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add1 = hold1.until(ExpectedConditions.elementToBeClickable(ad1));
		add1.click();

		driver.findElement(By.xpath("//div[@id='user_1']//input[@placeholder='Search with Email']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[1]")).click();
		driver.findElement(By.xpath("//div[@id='user_1']//input[@placeholder='Select Signer Type']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[3]")).click();
	}

	public void Recipients1() throws Exception {
		By ad = By.xpath("//span[contains(text(),'Add Recipient')]");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add = hold.until(ExpectedConditions.elementToBeClickable(ad));
		add.click();

		driver.findElement(By.xpath("//div[@id='user_2']//input[@placeholder='Select contact type']")).click();

		By ad1 = By.xpath("//div[@x-placement]//ul//li[1]");
		WebDriverWait hold1 = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement add1 = hold1.until(ExpectedConditions.elementToBeClickable(ad1));
		add1.click();

		driver.findElement(By.xpath("//div[@id='user_2']//input[@placeholder='Search with Email']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[2]")).click();
		driver.findElement(By.xpath("//div[@id='user_2']//input[@placeholder='Select Signer Type']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@x-placement]//ul//li[2]")).click();
	}

	public void MoreFields() throws Exception {

		By Mor = By.xpath("//div[@id=\"user_2\"]//p");
		WebDriverWait More = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Morea = More.until(ExpectedConditions.elementToBeClickable(Mor));
		Morea.click();

		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@id='user_2']//input[@placeholder='middle_name']")).sendKeys("prj");
		driver.findElement(By.xpath("//div[@id='user_2']//input[@placeholder='Address']")).sendKeys("rjy");

		driver.findElement(By.xpath("//div[@id='user_2']//input[@placeholder='Title']")).sendKeys("mr");
		driver.findElement(By.id("//input[@placeholder='Company name']")).sendKeys("Act");
		Thread.sleep(10000);
		driver.findElement(By.id("//div[@id='user_2']//input[@placeholder='Phone']")).sendKeys("9888789456");
		Thread.sleep(10000);

		driver.findElement(By.xpath("//div[@id=\\\"user_2\\\"]//p")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Enforce Signature Order']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Enforce Signature Order']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[normalize-space()='Save Users']")).clear();
	}

	public void Verifrecipient() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement DocMessage = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Send Document']")));
		Assert.assertEquals(DocMessage.getText(), "Send Document");
		System.out.println("Test Data Entred In All Fields Sucessfully");

	}

}
