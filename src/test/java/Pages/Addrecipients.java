package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Addrecipients {
	WebDriver driver;

	public Addrecipients(WebDriver driver) {

		this.driver = driver;

	}
	
	

	public void waitEle(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));
		wait.until(ExpectedConditions.elementToBeClickable(by)).click();
	}
	public void Recipients() throws Exception {

		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select contact type']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Search with Email']"));

		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select Signer Type']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[3]"));
	}

	public void Recipients1() throws Exception {
		waitEle(By.xpath("//span[contains(text(),'Add Recipient')]"));

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Select contact type']"));
		Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Search with Email']"));
	   Thread.sleep(10000);
		waitEle(By.xpath("//div[@x-placement]//ul//li[1]"));

		waitEle(By.xpath("//div[@id='user_1']//input[@placeholder='Select Signer Type']"));
		
		waitEle(By.xpath("//div[@x-placement]//ul//li[2]"));

		waitEle(By.xpath("//span[normalize-space()='Enforce Signature Order']"));

		waitEle(By.xpath("//span[normalize-space()='Enforce Signature Order']"));
		waitEle(By.xpath("//span[normalize-space()='Save Users']"));

	}

	public void MoreFields() throws Exception {

		waitEle(By.xpath("//div[@id=\"user_2\"]//p"));
		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='middle_name']"));
		driver.findElement(By.xpath("//div[@id='user_2']//input[@placeholder='middle_name']")).clear();
		driver.findElement(By.xpath("//div[@id='user_2']//input[@placeholder='middle_name']")).sendKeys("prj");

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Address']"));
		driver.findElement(By.xpath("//div[@id='user_2']//input[@placeholder='Address']")).clear();
		driver.findElement(By.xpath("//div[@id='user_2']//input[@placeholder='Address']")).sendKeys("rjy");

		waitEle(By.xpath("//div[@id='user_2']//input[@placeholder='Title']"));
		driver.findElement(By.xpath("//div[@id='user_2']//input[@placeholder='Title']")).clear();
		driver.findElement(By.xpath("//div[@id='user_2']//input[@placeholder='Title']")).sendKeys("mr");

		waitEle(By.id("//input[@placeholder='Company name']"));
		driver.findElement(By.id("//input[@placeholder='Company name']")).clear();
		driver.findElement(By.id("//input[@placeholder='Company name']")).sendKeys("Act");

		Thread.sleep(10000);

		waitEle(By.id("//div[@id='user_2']//input[@placeholder='Phone']"));
		driver.findElement(By.id("//div[@id='user_2']//input[@placeholder='Phone']")).clear();
		driver.findElement(By.id("//div[@id='user_2']//input[@placeholder='Phone']")).sendKeys("9888789456");

		Thread.sleep(10000);
	}

	public void Verifrecipient() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

		WebElement DocMessage = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Send Document']")));
		Assert.assertEquals(DocMessage.getText(), "Send Document");
		System.out.println("Test Data Entred In All Fields Sucessfully");

	}

}
