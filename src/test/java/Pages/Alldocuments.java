package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Alldocuments {
	WebDriver driver;

	public Alldocuments(WebDriver driver) {
		this.driver = driver;
	}

	public void Createdocument() throws InterruptedException {
		Thread.sleep(10000);
		By Element = By.xpath("//span[normalize-space()='Create Document']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(10));
		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));
		canc.click();
		
		/*
		 * JavascriptExecutor executor = (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0]", Element);
		 */

	}

	public void Validdocument() {

	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(2)); 
	        WebElement DocMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='text-center text-dark fw-normal fs-4 mb-1']")));

	        Assert.assertEquals(DocMessage.getText(), "Upload Documents");
    

	        System.out.println("Upload Documents Page Displayed");
   }
	
}
