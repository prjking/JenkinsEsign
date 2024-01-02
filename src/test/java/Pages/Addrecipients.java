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

		driver.findElement(By.xpath("//*[@id=\"user_1\"]//form/div/div[1]//input")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[4]//div//ul/li")).click();

		driver.findElement(By.xpath("//*[@id=\"user_1\"]//form/div/div[2]//input")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[5]//div//ul/li")).click();
		driver.findElement(By.xpath("//*[@id=\"user_1\"]/form//div[6]//input")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[6]/div[1]/div[1]/ul/li[3]")).click();
		By Mor = By.xpath("//p[normalize-space()='Add More Fields']");
		WebDriverWait More = new WebDriverWait(driver, Duration.ofMinutes(2));
		WebElement Morea = More.until(ExpectedConditions.elementToBeClickable(Mor));
		Morea.click();

		Thread.sleep(10000);

		/*
		 * WebElement inputField1 =
		 * driver.findElement(By.id("//input[@placeholder='middle_name']"));
		 * inputField1.clear(); inputField1.sendKeys("prj"); inputField1.clear();
		 * 
		 * WebElement inputField2 =
		 * driver.findElement(By.id("//input[@placeholder='Address']"));
		 * inputField2.clear(); inputField2.sendKeys("rjy");
		 * 
		 * WebElement inputField3 =
		 * driver.findElement(By.id("//input[@placeholder='Title']"));
		 * inputField3.clear(); inputField3.sendKeys("mr");
		 * 
		 * WebElement inputField4 =
		 * driver.findElement(By.id("//input[@placeholder='Company name']"));
		 * inputField4.clear(); inputField4.sendKeys("Act"); Thread.sleep(10000);
		 * WebElement inputField5 =
		 * driver.findElement(By.id("//input[@placeholder='Phone']"));
		 * inputField5.clear(); inputField5.sendKeys("9888789456"); Thread.sleep(10000);
		 */
		driver.findElement(By.xpath("//p[normalize-space()='Add More Fields']")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Add Recipient')]")).click();
        driver.findElement(By.xpath("//div[@id='user_2']//span[@class='el-link--inner']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Yes']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Enforce Signature Order']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Save Users']")).click();
	}   
        public void Verifrecipient() {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

    		WebElement DocMessage = wait.until(
    				ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Send Document']")));
    		Assert.assertEquals(DocMessage.getText(), "Send Document");
    		System.out.println("Test Data Entred In All Fields Sucessfully");
    		

    	}
       

      	}


