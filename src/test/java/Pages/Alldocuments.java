package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alldocuments {
	WebDriver driver;

	public Alldocuments(WebDriver driver) {
		this.driver = driver;
	}

	public void Createdocument() throws InterruptedException {
		Thread.sleep(10000);
		By Element = By.xpath("//span[normalize-space()='Create Document']");
		WebDriverWait hold = new WebDriverWait(driver, Duration.ofMinutes(3));
		WebElement canc = hold.until(ExpectedConditions.elementToBeClickable(Element));
		canc.click();
		
		/*
		 * JavascriptExecutor executor = (JavascriptExecutor) driver;
		 * executor.executeScript("arguments[0]", Element);
		 */

	}

	public boolean Validdocument()  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(3));

       
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[@class='text-center text-dark fw-normal fs-4 mb-1']")));

       
        System.out.println("Upload document is present on the page");
        
      
        return element.isDisplayed();

	}

}
